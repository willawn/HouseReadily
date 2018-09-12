package com.huzhiyi.housereadily.biz.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.biz.IBaseGroupService;
import com.huzhiyi.housereadily.biz.IMemberGroupService;
import com.huzhiyi.housereadily.biz.IOperateLogService;
import com.huzhiyi.housereadily.dao.IUserDAO;
import com.huzhiyi.housereadily.entity.BaseGroup;
import com.huzhiyi.housereadily.entity.MemberGroup;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.housereadily.request.BaseGroupCommand;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.utils.CodeMobileUtils;
import com.huzhiyi.utils.Configuration;

public class BaseGroupServiceImpl extends AbstractBaseGroupServiceImpl implements IBaseGroupService {

	@Override
	public BaseGroup add(ICommand command) throws Exception {
		BaseGroupCommand baseGroupCommand = (BaseGroupCommand) command;
		Integer userId = baseGroupCommand.getUserId();
		String groupName = baseGroupCommand.getGroupName();
		String acement = baseGroupCommand.getAcement();
		String description = baseGroupCommand.getDescription();
		Integer cityCode = baseGroupCommand.getCityCode();
		Integer bigAreaCode = baseGroupCommand.getBigAreaCode();
		Integer smallAreaCode = baseGroupCommand.getSmallAreaCode();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		CUser user = userDAO.findById(userId);

		BaseGroup baseGroup = new BaseGroup();
		baseGroup.setLevel(0); // 群等级（0：普通群）
		baseGroup.setGroupNum(getGroupNum()); // 群号（六位数）
		baseGroup.setGroupName(groupName);
		baseGroup.setAcement(acement);
		baseGroup.setDescription(description);
		baseGroup.setMemberCount(0);
		baseGroup.setHouseReadilyCount(0);
		baseGroup.setCustomerCount(0);
		baseGroup.setCityCode(cityCode);
		baseGroup.setBigAreaCode(bigAreaCode);
		baseGroup.setSmallAreaCode(smallAreaCode);
		baseGroup.setSyncTime(currentTime);
		baseGroup.setVersion(Configuration.DEFAULT_VERSION);
		baseGroup.setIsDelete(1);
		baseGroup.setCreater(userId);
		baseGroup.setCreateTime(currentTime);

		super.add(baseGroup);

		// 添加群成员为群主
		MemberGroup memberGroup = new MemberGroup();
		memberGroup.setBaseGroupId(baseGroup.getId());
		memberGroup.setRoleType(1); // 成员角色（1：群主，2：管理员，3：普通用户）
		memberGroup.setUserId(userId);
		memberGroup.setUserName(user.getName());
		memberGroup.setRealName(user.getRealname());
		memberGroup.setSyncTime(currentTime);
		memberGroup.setVersion(Configuration.DEFAULT_VERSION);
		memberGroup.setIsDelete(1);
		memberGroup.setCreateTime(currentTime);
		memberGroupService.add(memberGroup);

		// 新增操作日志
		operateLogService.add(userId, baseGroupCommand.getIp(), baseGroupCommand.getOperate(), 7, MessageFormat.format(
				Configuration.BASEGROUP_ADD_LOG, baseGroup.getGroupName(), baseGroup.getGroupNum()), currentTime);

		return baseGroup;
	}

	private String getGroupNum() {
		String groupNum = CodeMobileUtils.getCode2(6);
		List<BaseGroup> baseGroupList = findByProperty("groupNum", groupNum).getList();
		if (!baseGroupList.isEmpty()) {
			groupNum = getGroupNum();
		}
		return groupNum;

	}
	
	@Override
	public BaseGroup updateAcement(ICommand command) {
		BaseGroupCommand baseGroupCommand = (BaseGroupCommand) command;
		Integer id = baseGroupCommand.getId();
		String acement = baseGroupCommand.getAcement();
		Integer userId = baseGroupCommand.getUserId();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		// 修改群公告
		BaseGroup baseGroup = findById(id);
		String oldAcement = baseGroup.getAcement();
		baseGroup.setAcement(acement);
		
		// 更新群版本号
		baseGroup.setVersion(new BigDecimal(baseGroup.getVersion()).add(new BigDecimal("0.1")).toString());

		// 新增操作日志
		operateLogService.add(userId, baseGroupCommand.getIp(), baseGroupCommand.getOperate(), 8, MessageFormat.format(
				Configuration.BASEGROUP_UPDATE_LOG, baseGroup.getGroupName(), baseGroup.getGroupNum(), oldAcement, acement), currentTime);

		return baseGroup;
	}

	@Override
	public void delete(ICommand command) {
		BaseGroupCommand baseGroupCommand = (BaseGroupCommand) command;
		Integer id = baseGroupCommand.getId();
		Integer userId = baseGroupCommand.getUserId();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		BaseGroup baseGroup = findById(id);
		baseGroup.setIsDelete(0);

		// 新增操作日志
		operateLogService.add(userId, baseGroupCommand.getIp(), baseGroupCommand.getOperate(), 9, MessageFormat.format(
				Configuration.BASEGROUP_DELETE_LOG, baseGroup.getGroupName(), baseGroup.getGroupNum()), currentTime);
	}

	@Override
	public BaseGroup findById(Integer id) {
		BaseGroup baseGroup = super.findById(id);
		
		if(null != baseGroup){
			// 判断群是否已被删除
			if (baseGroup.getIsDelete() == 0) {
				return null;
			}
			
			initBaseGroupForeignValue(baseGroup);
		}

		return baseGroup;
	}

	@Override
	public BaseGroup findByIdNull(Integer id) {
		BaseGroup baseGroup = super.findById(id);
		
		if(null != baseGroup){
			initBaseGroupForeignValue(baseGroup);
		}

		return baseGroup;
	}

	@Override
	public List<BaseGroup> findPaging(Integer userId, String sort, String dir, PagingBean pagingBean) throws Exception {
		List<BaseGroup> baseGroupList = getBaseGroupDAO().findPaging(userId, sort, dir, pagingBean);
		for (BaseGroup baseGroup : baseGroupList) {
			initBaseGroupForeignValue(baseGroup);
		}
		return baseGroupList;
	}

	private void initBaseGroupForeignValue(BaseGroup baseGroup) {
		if (null != baseGroup) {
			Integer baseGroupId = baseGroup.getId();
			CUser user = userDAO.findById(baseGroup.getCreater());

			baseGroup.setCreaterName(user.getName());
			baseGroup.setCreaterRealName(user.getRealname());
		}
	}

	@Override
	public BaseGroup findByGroupNum(String groupNum) {
		BaseGroup baseGroup = getBaseGroupDAO().findByGroupNum(groupNum);
		initBaseGroupForeignValue(baseGroup);

		return baseGroup;
	}
	
	@Override
	public List<BaseGroup> findPaging(Integer id, Integer level, String groupNum, String groupName, Integer cityCode, Integer bigAreaCode,
			Integer smallAreaCode, String userName, Date beginDate, Date endDate, Integer isDelete, String sort, String dir, PagingBean pagingBean ){
		List<BaseGroup> baseGroupList = getBaseGroupDAO().findPaging(id, level, groupNum, groupName, cityCode, bigAreaCode, smallAreaCode,
												userName, beginDate, endDate, isDelete, sort, dir, pagingBean);
		for (BaseGroup baseGroup : baseGroupList) {
			initBaseGroupForeignValue(baseGroup);
		}
		return baseGroupList;
	}

	@Override
	public Integer findCountByUserId(Integer userId) {
		return getBaseGroupDAO().findCountByUserId(userId);
	}

	private IUserDAO userDAO;
	private IMemberGroupService memberGroupService;
	private IOperateLogService operateLogService;

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
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