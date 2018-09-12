package com.huzhiyi.housereadily.biz.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.List;

import com.huzhiyi.housereadily.biz.IMemberGroupService;
import com.huzhiyi.housereadily.biz.IMessageGroupService;
import com.huzhiyi.housereadily.biz.IOperateLogService;
import com.huzhiyi.housereadily.biz.IUserService;
import com.huzhiyi.housereadily.dao.IBaseGroupDAO;
import com.huzhiyi.housereadily.entity.BaseGroup;
import com.huzhiyi.housereadily.entity.MemberGroup;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.housereadily.request.MemberGroupCommand;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Configuration;

public class MemberGroupServiceImpl extends AbstractMemberGroupServiceImpl implements IMemberGroupService {

	@Override
	public void add(MemberGroup memberGroup) {
		super.add(memberGroup);
		
		Integer baseGroupId = memberGroup.getBaseGroupId();
		
		// 群基本信息
		BaseGroup baseGroup = baseGroupDAO.findById(baseGroupId);
		// 更新群成员数量
		Integer memberCount = findByBaseGroupId(baseGroupId).size();
		baseGroup.setMemberCount(memberCount);
		// 更新群版本号
		baseGroup.setVersion(new BigDecimal(baseGroup.getVersion()).add(new BigDecimal("0.1")).toString());
	}
	
	@Override
	public List<MemberGroup> findByBaseGroupId(Integer baseGroupId) {
		return getMemberGroupDAO().findByProperty("baseGroupId", baseGroupId, "createTime", "desc").getList();
	}

	@Override
	public List<MemberGroup> findPaging(Integer baseGroupId, String sort, String dir, PagingBean pagingBean) {
		List<MemberGroup> memberGroupList = getMemberGroupDAO().findPaging(baseGroupId, sort, dir, pagingBean);
		for (MemberGroup memberGroup : memberGroupList) {
			initMemberGroupForeignValue(memberGroup);
		}
		return memberGroupList;
	}

	@Override
	public MemberGroup findById(Integer id) {
		MemberGroup memberGroup = super.findById(id);
		initMemberGroupForeignValue(memberGroup);
		return memberGroup;
	}

	private void initMemberGroupForeignValue(MemberGroup memberGroup) {
		if (null != memberGroup) {
			CUser user = userService.findById(memberGroup.getUserId());
			memberGroup.setCityCode(user.getCityCode());
			memberGroup.setAvatar(user.getUserExt().getAvatar());
			memberGroup.setMobile(user.getMobile());
			memberGroup.setEmail(user.getEmail());
		}
	}

	@Override
	public boolean exitsMemberGroup(Integer baseGroupId, Integer userId) {
		return getMemberGroupDAO().findByMemberGroup(baseGroupId, userId) != null;
	}

	@Override
	public void delete(ICommand command) {
		MemberGroupCommand memberGroupCommand = (MemberGroupCommand) command;
		Integer id = memberGroupCommand.getId();
		Integer userId = memberGroupCommand.getUserId();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		MemberGroup memberGroup = findById(id);
		CUser memberUser = userService.findById(memberGroup.getUserId());

		// 移除群成员
		// delete(memberGroup);
		memberGroup.setIsDelete(0);

		// 删除群成员发布的房源和客源记录
		messageGroupService.deleteByUserId(memberGroup.getBaseGroupId(),memberUser.getId());
		
		Integer baseGroupId = memberGroup.getBaseGroupId();
		
		// 群基本信息
		BaseGroup baseGroup = baseGroupDAO.findById(baseGroupId);
		// 更新群成员数量
		Integer memberCount = findByBaseGroupId(baseGroupId).size();
		baseGroup.setMemberCount(memberCount);

		// 新增操作日志
		operateLogService.add(userId, memberGroupCommand.getIp(), memberGroupCommand.getOperate(), 11, MessageFormat.format(
				Configuration.MEMBERGROUP_DELETE_LOG, memberUser.getRealname(), memberUser.getName()), currentTime);
	}

	@Override
	public void deleteQuitGroup(ICommand command) {
		MemberGroupCommand memberGroupCommand = (MemberGroupCommand) command;
		Integer userId = memberGroupCommand.getUserId();
		Integer baseGroupId = memberGroupCommand.getBaseGroupId();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		MemberGroup memberGroup = getMemberGroupDAO().findByMemberGroup(baseGroupId, userId);
		CUser memberUser = userService.findById(userId);
		BaseGroup baseGroup = baseGroupDAO.findById(baseGroupId);

		// 退出群
		// delete(memberGroup);
		memberGroup.setIsDelete(0);

		// 删除群成员发布的房源和客源记录
		messageGroupService.deleteByUserId(memberGroup.getBaseGroupId(),memberUser.getId());
		
		// 更新群成员数量
		Integer memberCount = findByBaseGroupId(baseGroupId).size();
		baseGroup.setMemberCount(memberCount);

		// 新增操作日志
		operateLogService.add(userId, memberGroupCommand.getIp(), memberGroupCommand.getOperate(), 12, MessageFormat.format(
				Configuration.MEMBERGROUP_QUITGROUP_LOG, memberUser.getRealname(), memberUser.getName(), baseGroup.getGroupName(),
				baseGroup.getGroupNum()), currentTime);
	}

	private IUserService userService;
	private IOperateLogService operateLogService;
	private IBaseGroupDAO baseGroupDAO;
	private IMessageGroupService messageGroupService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IOperateLogService getOperateLogService() {
		return operateLogService;
	}

	public void setOperateLogService(IOperateLogService operateLogService) {
		this.operateLogService = operateLogService;
	}

	public IBaseGroupDAO getBaseGroupDAO() {
		return baseGroupDAO;
	}

	public void setBaseGroupDAO(IBaseGroupDAO baseGroupDAO) {
		this.baseGroupDAO = baseGroupDAO;
	}

	public IMessageGroupService getMessageGroupService() {
		return messageGroupService;
	}

	public void setMessageGroupService(IMessageGroupService messageGroupService) {
		this.messageGroupService = messageGroupService;
	}
}