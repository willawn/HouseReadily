package com.huzhiyi.housereadily.biz.impl;

import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.List;

import com.huzhiyi.housereadily.biz.IAuditMemberGroupService;
import com.huzhiyi.housereadily.biz.IMemberGroupCodeService;
import com.huzhiyi.housereadily.biz.IMemberGroupService;
import com.huzhiyi.housereadily.biz.IOperateLogService;
import com.huzhiyi.housereadily.biz.IUserService;
import com.huzhiyi.housereadily.dao.IBaseGroupDAO;
import com.huzhiyi.housereadily.dao.IUserDAO;
import com.huzhiyi.housereadily.entity.AuditMemberGroup;
import com.huzhiyi.housereadily.entity.BaseGroup;
import com.huzhiyi.housereadily.entity.MemberGroup;
import com.huzhiyi.housereadily.entity.MemberGroupCode;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.housereadily.request.AuditMemberGroupCommand;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.HttpHelper;

public class AuditMemberGroupServiceImpl extends AbstractAuditMemberGroupServiceImpl implements IAuditMemberGroupService {

	@Override
	public AuditMemberGroup add(ICommand command) throws Exception {
		AuditMemberGroupCommand auditMemberGroupCommand = (AuditMemberGroupCommand) command;
		Integer userId = auditMemberGroupCommand.getUserId();
		Integer baseGroupId = auditMemberGroupCommand.getBaseGroupId();
		String description = auditMemberGroupCommand.getDescription();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		CUser user = userService.findById(userId);
		BaseGroup baseGroup = baseGroupDAO.findById(baseGroupId);
		
		// 创建群组成员审核消息
		AuditMemberGroup auditMemberGroup = new AuditMemberGroup();
		auditMemberGroup.setBaseGroupId(baseGroupId);
		auditMemberGroup.setGroupNum(baseGroup.getGroupNum());
		auditMemberGroup.setGroupName(baseGroup.getGroupName());
		auditMemberGroup.setUserId(userId);
		auditMemberGroup.setUserName(user.getName());
		auditMemberGroup.setRealName(user.getRealname());
		auditMemberGroup.setDescription(description);
		auditMemberGroup.setIsPass(-1); // 是否通过审核（1：通过，0：未通过，-1：未处理）
		auditMemberGroup.setIsRead(0); // 是否已读（1：已读，0：未读）
		auditMemberGroup.setAuditer(baseGroup.getCreater()); // 群主审核
		auditMemberGroup.setCreateTime(currentTime);
		
		super.add(auditMemberGroup);
		
		// 发送短信到群主
		//sendCode(auditMemberGroup);
		
		return auditMemberGroup;
	}
	
	private String sendCode(AuditMemberGroup auditMemberGroup) {
		CUser user = userService.findById(auditMemberGroup.getAuditer());
		String mobile = user.getMobile();
		if (StringUtils.isEmpty(mobile) || mobile.length() < 11) {
			return null;
		}

		String msg = null;
		try {
			String encodeMsg = MessageFormat.format(Configuration.CODE_AUDIT_MEMBERGROUP_MSG, auditMemberGroup.getUserName(), 
					auditMemberGroup.getGroupName(), auditMemberGroup.getGroupNum(), auditMemberGroup.getDescription());
			msg = URLEncoder.encode(encodeMsg, "GBK");
			if (StringUtils.isNotEmpty(msg)) {
				String url = MessageFormat.format(Configuration.SEND_MSG_URL, mobile, msg);
				String result = HttpHelper.doGet(url, null, "utf-8", false);
				if (StringUtils.isNotEmpty(result) && result.equals("0")) {
					MemberGroupCode memberGroupCode = new MemberGroupCode();
					memberGroupCode.setAuditMemberGroupId(auditMemberGroup.getId());
					memberGroupCode.setBaseGroupId(auditMemberGroup.getBaseGroupId());
					memberGroupCode.setGroupNum(auditMemberGroup.getGroupNum());
					memberGroupCode.setGroupName(auditMemberGroup.getGroupName());
					memberGroupCode.setUserId(auditMemberGroup.getId());
					memberGroupCode.setUserName(auditMemberGroup.getUserName());
					memberGroupCode.setDescription(encodeMsg);
					memberGroupCode.setMobile(mobile);
					memberGroupCode.setAuditer(auditMemberGroup.getAuditer());
					memberGroupCode.setCreateTime(auditMemberGroup.getCreateTime());
					memberGroupCodeService.add(memberGroupCode);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String updateAudit(ICommand command) {
		AuditMemberGroupCommand auditMemberGroupCommand = (AuditMemberGroupCommand) command;
		Integer userId = auditMemberGroupCommand.getUserId();
		Integer id = auditMemberGroupCommand.getId();
		Integer isPass = auditMemberGroupCommand.getIsPass();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		AuditMemberGroup auditMemberGroup = findById(id);
		BaseGroup baseGroup = baseGroupDAO.findById(auditMemberGroup.getBaseGroupId()); // 群
		CUser applyer = userService.findById(auditMemberGroup.getUserId()); // 申请人
		
		// 查询验证消息是否已经处理
		if (auditMemberGroup.getIsPass().equals(1) || auditMemberGroup.getIsPass().equals(0)) {
			return Configuration.AUDITMEMBER_ISPASSED;
		}
		
		// 判断群创建人和审核人是否一致
		if (!userId.equals(auditMemberGroup.getAuditer())) {
			return Configuration.UPDATER_NOTEQUALS_CREATER;
		}
		
		// 审核验证消息
		auditMemberGroup.setIsPass(isPass);			
		auditMemberGroup.setIsRead(1);
		auditMemberGroup.setAuditTime(currentTime);
		
		// 验证结果处理
		if (isPass.equals(1)) { // 审核通过
			// 判断群是否存在这个用户
			List<MemberGroup> memberGroupList = memberGroupService.findByBaseGroupId(baseGroup.getId());
			boolean isExits = false;
			for (MemberGroup memberGroup : memberGroupList) {
				if (memberGroup.getUserId().equals(auditMemberGroup.getUserId())) {
					isExits = true;
					break;
				}
			}
			if (isExits) {
				return Configuration.MEMBERGROUP_EXIST;
			}
			
			// 添加群成员
			MemberGroup memberGroup = new MemberGroup();
			memberGroup.setBaseGroupId(baseGroup.getId());
			memberGroup.setRoleType(3); // 成员角色（1：群主，2：管理员，3：普通用户）
			memberGroup.setUserId(applyer.getId());
			memberGroup.setUserName(applyer.getName());
			memberGroup.setRealName(applyer.getRealname());
			memberGroup.setSyncTime(currentTime);
			memberGroup.setVersion(Configuration.DEFAULT_VERSION);
			memberGroup.setIsDelete(1);
			memberGroup.setCreateTime(currentTime);
			memberGroupService.add(memberGroup);
			
			// 新增操作日志
			operateLogService.add(userId, auditMemberGroupCommand.getIp(), auditMemberGroupCommand.getOperate(), 10, MessageFormat.format(
					Configuration.MEMBERGROUP_ADD_LOG, applyer.getRealname(), applyer.getName()), currentTime);
			
			// 发送短信提醒
			//sendCode(Configuration.APPLY_GROUP_PASS, auditMemberGroup, baseGroup, applyer);
		} else if (isPass.equals(0)) { // 审核不通过
			// 发送短信提醒
			sendCode(Configuration.APPLY_GROUP_REFUSE, auditMemberGroup, baseGroup, applyer);
		}
		
		return null;
	}
	
	private String sendCode(String formatMsg, AuditMemberGroup auditMemberGroup, BaseGroup baseGroup, CUser applyer) {
		String msg = null;
		try {
			String encodeMsg = MessageFormat.format(formatMsg, baseGroup.getGroupName(), baseGroup.getGroupNum());
			msg = URLEncoder.encode(encodeMsg, "GBK");
			if (StringUtils.isNotEmpty(msg)) {
				String url = MessageFormat.format(Configuration.SEND_MSG_URL, applyer.getMobile(), msg);
				String result = HttpHelper.doGet(url, null, "utf-8", false);
				if (StringUtils.isNotEmpty(result) && result.equals("0")) {
					MemberGroupCode memberGroupCode = new MemberGroupCode();
					memberGroupCode.setAuditMemberGroupId(auditMemberGroup.getId());
					memberGroupCode.setBaseGroupId(baseGroup.getId());
					memberGroupCode.setGroupNum(baseGroup.getGroupNum());
					memberGroupCode.setGroupName(baseGroup.getGroupName());
					memberGroupCode.setUserId(applyer.getId());
					memberGroupCode.setUserName(applyer.getName());
					memberGroupCode.setDescription(encodeMsg);
					memberGroupCode.setMobile(applyer.getMobile());
					memberGroupCode.setAuditer(auditMemberGroup.getAuditer());
					memberGroupCode.setCreateTime(auditMemberGroup.getAuditTime());
					memberGroupCodeService.add(memberGroupCode);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	@Override
	public List<AuditMemberGroup> findPaging(Integer baseGroupId, Integer userId, Integer isRead, String sort, String dir, PagingBean pagingBean) throws Exception {
		List<AuditMemberGroup> auditMemberGroupList = getAuditMemberGroupDAO().findPaging(baseGroupId, userId, isRead, sort, dir, pagingBean);
		for (AuditMemberGroup auditMemberGroup : auditMemberGroupList) {
			initAuditMemberGroupForeignValue(auditMemberGroup);
		}
		return auditMemberGroupList;
	}
	
	private void initAuditMemberGroupForeignValue(AuditMemberGroup auditMemberGroup) {
		if (null != auditMemberGroup) {
			CUser applyer = userService.findById(auditMemberGroup.getUserId());
			CUser auditer = userService.findById(auditMemberGroup.getAuditer());
			auditMemberGroup.setCityCode(applyer.getCityCode());
			auditMemberGroup.setAvatar(applyer.getUserExt().getAvatar());
			auditMemberGroup.setMobile(applyer.getMobile());
			auditMemberGroup.setEmail(applyer.getEmail());
			auditMemberGroup.setAuditerName(auditer.getName());
			auditMemberGroup.setAuditerRealName(auditer.getRealname());
		}
	}
	
	private IUserService userService;
	private IBaseGroupDAO baseGroupDAO;
	private IMemberGroupCodeService memberGroupCodeService;
	private IMemberGroupService memberGroupService;
	private IOperateLogService operateLogService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public IBaseGroupDAO getBaseGroupDAO() {
		return baseGroupDAO;
	}

	public void setBaseGroupDAO(IBaseGroupDAO baseGroupDAO) {
		this.baseGroupDAO = baseGroupDAO;
	}

	public IMemberGroupCodeService getMemberGroupCodeService() {
		return memberGroupCodeService;
	}

	public void setMemberGroupCodeService(IMemberGroupCodeService memberGroupCodeService) {
		this.memberGroupCodeService = memberGroupCodeService;
	}

	public IMemberGroupService getMemberGroupService() {
		return memberGroupService;
	}

	public void setMemberGroupService(IMemberGroupService memberGroupService) {
		this.memberGroupService = memberGroupService;
	}
	
	public IOperateLogService getOperateLogService() {
		return operateLogService;
	}

	public void setOperateLogService(IOperateLogService operateLogService) {
		this.operateLogService = operateLogService;
	}
}