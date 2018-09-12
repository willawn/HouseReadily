package com.huzhiyi.housereadily.biz.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.biz.IHouseAttachmentService;
import com.huzhiyi.housereadily.biz.IMessageGroupService;
import com.huzhiyi.housereadily.biz.IOperateLogService;
import com.huzhiyi.housereadily.biz.ITaskLogService;
import com.huzhiyi.housereadily.biz.IUserExtService;
import com.huzhiyi.housereadily.dao.IBaseGroupDAO;
import com.huzhiyi.housereadily.dao.ICustomerDAO;
import com.huzhiyi.housereadily.dao.IHouseReadilyDAO;
import com.huzhiyi.housereadily.dao.IUserDAO;
import com.huzhiyi.housereadily.entity.BaseGroup;
import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.housereadily.entity.MessageGroup;
import com.huzhiyi.housereadily.entity.UserExt;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.housereadily.request.MessageGroupCommand;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Configuration;

public class MessageGroupServiceImpl extends AbstractMessageGroupServiceImpl implements IMessageGroupService {
	@Override
	public MessageGroup add(ICommand command) throws Exception {
		MessageGroupCommand messageGroupCommand = (MessageGroupCommand) command;
		Integer userId = messageGroupCommand.getUserId();
		Integer baseGroupId = messageGroupCommand.getBaseGroupId();
		String title = messageGroupCommand.getTitle();
		String description = messageGroupCommand.getDescription();
		Integer mtype = messageGroupCommand.getMtype();
		Integer source = messageGroupCommand.getSource();
		Integer sctype = new Integer(0);
		Double ownerRate = messageGroupCommand.getOwnerRate();
		Double otherRate = messageGroupCommand.getOtherRate();
		Double brokerage = messageGroupCommand.getBrokerage();
		String remarks = messageGroupCommand.getRemarks();
		String share = messageGroupCommand.getShare();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		CUser user = userDAO.findById(userId);
		
		MessageGroup messageGroup = new MessageGroup();
		
		if(mtype == 1){
			HouseReadily houseReadily = houseReadilyDAO.findById(source);
			
			if(null != houseReadily.getBigAreaName() && null != houseReadily.getSmallAreaName()) {
				description = MessageFormat.format(Configuration.MESSAGEGROUP_ADD_HOUSEREADILY,
														null != user.getRealname() && user.getRealname().length() > 0 ? user.getRealname() : user.getName(), 
														houseReadily.getStype() == 1 ? Configuration.CS : Configuration.CZ, 
														houseReadily.getProjectName(), 
														houseReadily.getBigAreaName(), 
														houseReadily.getSmallAreaName());
			} else {
				description = MessageFormat.format(Configuration.MESSAGEGROUP_ADD_HOUSEREADILY,
						null != user.getRealname() && user.getRealname().length() > 0 ? user.getRealname() : user.getName(), 
						houseReadily.getStype() == 1 ? Configuration.CS : Configuration.CZ, 
						houseReadily.getProjectName());
			}
			
			sctype = houseReadily.getStype();
			if(null == title || "".equals(title))
				title = houseReadily.getProjectName();
		}else if(mtype == 2){
			Customer customer = customerDAO.findById(source);
			if(null != customer.getBigAreaName() && null != customer.getSmallAreaName()) {
				description = MessageFormat.format(Configuration.MESSAGEGROUP_ADD_CUSTOMER,
														null != user.getRealname() && user.getRealname().length() > 0 ? user.getRealname() : user.getName(), 
														customer.getCtype() == 1 ? Configuration.YZ : customer.getCtype() == 2 ? Configuration.QZ : Configuration.QG, 
														customer.getBigAreaName(), 
														customer.getSmallAreaName());
			} else {
				description = MessageFormat.format(Configuration.MESSAGEGROUP_ADD_CUSTOMER,
						null != user.getRealname() && user.getRealname().length() > 0 ? user.getRealname() : user.getName(), 
						customer.getCtype() == 1 ? Configuration.YZ : customer.getCtype() == 2 ? Configuration.QZ : Configuration.QG);
			}
			
			sctype = customer.getCtype();
			if(null == title || "".equals(title))
				title = customer.getName();
		}

		messageGroup.setBaseGroupId(baseGroupId); 
		messageGroup.setTitle(title);
		messageGroup.setDescription(description);
		messageGroup.setMtype(mtype);
		messageGroup.setSource(source);
		messageGroup.setSctype(sctype);
		messageGroup.setOwnerRate(ownerRate);
		messageGroup.setOtherRate(otherRate);
		messageGroup.setBrokerage(brokerage);
		messageGroup.setRemarks(remarks);
		messageGroup.setShare(share);
		messageGroup.setSyncTime(currentTime);
		messageGroup.setVersion(Configuration.DEFAULT_VERSION);
		messageGroup.setIsDelete(1);
		messageGroup.setCreater(userId);
		messageGroup.setCreateTime(currentTime);

		add(messageGroup);
		
		// 新增消息日志
		if(mtype == 1){
			operateLogService.add(userId, messageGroupCommand.getIp(), messageGroupCommand.getOperate(), 13, description, currentTime);
			
			//新增积分日志
			messageGroup.setGrowing(taskLogService.add(userId, Integer.parseInt(Configuration.TASK_MESSAGEGROUP_ID), null));
		}else if(mtype == 2){
			operateLogService.add(userId, messageGroupCommand.getIp(), messageGroupCommand.getOperate(), 15, description, currentTime);
			
			//新增积分日志
			messageGroup.setGrowing(taskLogService.add(userId, Integer.parseInt(Configuration.TASK_MESSAGEGROUP_ID), null));
		}else{
			operateLogService.add(userId, messageGroupCommand.getIp(), messageGroupCommand.getOperate(), 17, MessageFormat.format(Configuration.MESSAGEGROUP_ADD, messageGroup.getId()), currentTime);
		}

		return messageGroup;
	}
	
	@Override
	public void add(MessageGroup messageGroup) {
		super.add(messageGroup);
		
		Integer baseGroupId = messageGroup.getBaseGroupId();
		
		if(messageGroup.getMtype() == 1 || messageGroup.getMtype() == 2){
			// 群基本信息
			BaseGroup baseGroup = baseGroupDAO.findById(baseGroupId);
			// 更新群房源数量
			Integer houseReadilyCount = findCoundMessage(baseGroupId, 1, getDate(-30));
			baseGroup.setHouseReadilyCount(houseReadilyCount);
			// 更新群客源数量
			Integer customerCount = findCoundMessage(baseGroupId, 2, getDate(-30));
			baseGroup.setCustomerCount(customerCount);
			
			baseGroup.setVersion(new BigDecimal(baseGroup.getVersion()).add(new BigDecimal("0.1")).toString());
		}
	}
	
	@Override
	public Integer findMessageGroupByCount(Integer baseGroupId, Integer mtype) {
		String[] propertyNames = {"baseGroupId", "mtype", "isDelete"};
		Object[] values = {baseGroupId, mtype, 1};
		return getMessageGroupDAO().findByProperty(propertyNames, values, null, null).getList().size();
	}
	
	@Override
	public Integer findCoundMessage(Integer baseGroupId, Integer mtype, Date date){
		return getMessageGroupDAO().findCoundMessage(baseGroupId, mtype, date);
	}
	
	@Override
	public boolean exitsMessageGroup(Integer baseGroupId, Integer userId,
			Integer mtype, Integer source) {
		return getMessageGroupDAO().findByMessageGroup(baseGroupId, userId, mtype, source, getDate(-30)) != null;
	}
	
	@Override
	public void deleteByUserId(Integer baseGroupId, Integer userId) {
		getMessageGroupDAO().deleteByUserId(baseGroupId, userId);
		
		// 群基本信息
		BaseGroup baseGroup = baseGroupDAO.findById(baseGroupId);
		// 更新群房源数量
		Integer houseReadilyCount = findCoundMessage(baseGroupId, 1, getDate(-30));
		baseGroup.setHouseReadilyCount(houseReadilyCount);
		// 更新群客源数量
		Integer customerCount = findCoundMessage(baseGroupId, 2, getDate(-30));
		baseGroup.setCustomerCount(customerCount);
		baseGroup.setVersion(new BigDecimal(baseGroup.getVersion()).add(new BigDecimal("0.1")).toString());
	}
	
	@Override
	public MessageGroup findById(Integer id){
		MessageGroup messageGroup = super.findById(id);
		
		if(null != messageGroup){
			if(messageGroup.getIsDelete() == 0){
				return null;
			}
			initMessageGroupForeignValue(messageGroup);
		}
		
		return messageGroup;
	}
	
	private void initMessageGroupForeignValue(MessageGroup messageGroup){
		if(null != messageGroup){
			CUser user = userDAO.findById(messageGroup.getCreater());
			messageGroup.setCreaterName(user.getName());
			messageGroup.setCreaterRealName(user.getRealname());
			messageGroup.setMobile(user.getMobile());
			UserExt userExt = userExtService.findByUserId(user.getId());
			messageGroup.setAvatar(userExt.getAvatar());
			
			BaseGroup baseGroup = baseGroupDAO.findById(messageGroup.getBaseGroupId());
			messageGroup.setBaseGroupName(baseGroup.getGroupName());
			
			String share = messageGroup.getShare();
			if(messageGroup.getMtype() == 1){
				HouseReadily houseReadily = houseReadilyDAO.findById(messageGroup.getSource());
				List<HouseReadily> houseReadilys = new ArrayList<HouseReadily>();
				if(share.indexOf("title")<0){
					houseReadily.setTitle(null);
				}
				if(share.indexOf("totalPrice")<0){
					houseReadily.setTotalPrice(null);
				}
				if(share.indexOf("unitPrice")<0){
					houseReadily.setUnitPrice(null);
				}
				if(share.indexOf("area")<0){
					houseReadily.setArea(null);
				}
				if(share.indexOf("building")<0){
					houseReadily.setBuilding(null);
				}
				if(share.indexOf("houseNum")<0){
					houseReadily.setHouseNum(null);
				}
				if(share.indexOf("keyer")<0){
					houseReadily.setKeyer(null);
				}
				if(share.indexOf("description")<0){
					houseReadily.setDescription(null);
				}
				houseReadilys.add(houseReadily);
				messageGroup.setHouseReadilys(houseReadilys);
				if(share.indexOf("btAttachments")>-1){
					messageGroup.setBtAttachments(houseAttachmentService.findAttachment(messageGroup.getSource(), Configuration.BT));
				}
				if(share.indexOf("snAttachments")>-1){
					messageGroup.setSnAttachments(houseAttachmentService.findAttachment(messageGroup.getSource(), Configuration.SN));
				}
				if(share.indexOf("fxAttachments")>-1){
					messageGroup.setFxAttachments(houseAttachmentService.findAttachment(messageGroup.getSource(), Configuration.FX));
				}
				if(share.indexOf("xqAttachments")>-1){
					messageGroup.setXqAttachments(houseAttachmentService.findAttachment(messageGroup.getSource(), Configuration.XQ));
				}
			}else if(messageGroup.getMtype() == 2){
				Customer customer = customerDAO.findById(messageGroup.getSource());
				List<Customer> customers = new ArrayList<Customer>();
				if(share.indexOf("description")<0){
					customer.setDescription(null);
				}
				customers.add(customer);
				messageGroup.setCustomers(customers);
			}
		}
	}
	
	@Override
	public void deleteById(ICommand command) {
		MessageGroupCommand messageGroupCommand = (MessageGroupCommand) command;
		Integer id = messageGroupCommand.getId();
		Integer userId = messageGroupCommand.getUserId();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		MessageGroup messageGroup = findById(id);
		
		getMessageGroupDAO().deleteById(id);
		
		if(null != messageGroup){
			if(messageGroup.getMtype() == 1){
				operateLogService.add(userId, messageGroupCommand.getIp(), messageGroupCommand.getOperate(), 14, MessageFormat.format(Configuration.MESSAGEGROUP_DELETE_HOUSEREADILY, messageGroup.getCreater(),messageGroup.getSource()), currentTime);
			}else if(messageGroup.getMtype() == 2){
				operateLogService.add(userId, messageGroupCommand.getIp(), messageGroupCommand.getOperate(), 16, MessageFormat.format(Configuration.MESSAGEGROUP_DELETE_CUSTOMER, messageGroup.getCreater(),messageGroup.getSource()), currentTime);
			}else{
				operateLogService.add(userId, messageGroupCommand.getIp(), messageGroupCommand.getOperate(), 18, MessageFormat.format(Configuration.MESSAGEGROUP_DELETE, messageGroup.getId()), currentTime);
			}
		}
		
		Integer baseGroupId = messageGroup.getBaseGroupId();
		
		if(messageGroup.getMtype() == 1 || messageGroup.getMtype() == 2){
			// 群基本信息
			BaseGroup baseGroup = baseGroupDAO.findById(baseGroupId);
			// 更新群房源数量
			Integer houseReadilyCount = findCoundMessage(baseGroupId, 1, getDate(-30));
			baseGroup.setHouseReadilyCount(houseReadilyCount);
			// 更新群客源数量
			Integer customerCount = findCoundMessage(baseGroupId, 2, getDate(-30));
			baseGroup.setCustomerCount(customerCount);
			baseGroup.setVersion(new BigDecimal(baseGroup.getVersion()).add(new BigDecimal("0.1")).toString());
		}
	}
	
	@Override
	public List<MessageGroup> findPaging(Integer baseGroupId, Integer creater, Integer mtype, Integer sctype, PagingBean pagingBean){
		List<MessageGroup> messageGroups = getMessageGroupDAO().findPaging(baseGroupId, creater, mtype, sctype, getDate(-30), pagingBean);
		for(MessageGroup messageGroup : messageGroups){
			initMessageGroupForeignValue(messageGroup);
		}
		return messageGroups;
	}
	
	@Override
	public List<MessageGroup> findPagingMessage(Integer baseGroupId, Integer creater, Integer mtype, Integer sctype, PagingBean pagingBean){
		List<MessageGroup> messageGroups = getMessageGroupDAO().findPagingMessage(baseGroupId, creater, mtype, sctype, getDate(-30), pagingBean);
		for(MessageGroup messageGroup : messageGroups){
			if(null != messageGroup){
				CUser user = userDAO.findById(messageGroup.getCreater());
				messageGroup.setCreaterName(user.getName());
				messageGroup.setCreaterRealName(user.getRealname());
				UserExt userExt = userExtService.findByUserId(user.getId());
				messageGroup.setAvatar(userExt.getAvatar());
			}
		}
		return messageGroups;
	}
	
	public Date getDate(int day){
		Date   d=new Date();  
	    Calendar   calendar=Calendar.getInstance();  
	    calendar.setTime(d);  
	    calendar.add(Calendar.DATE,day);  
	    
	    return calendar.getTime();
	}
	
	
	private IUserDAO userDAO;
	private IOperateLogService operateLogService;
	private IHouseReadilyDAO houseReadilyDAO;
	private ICustomerDAO customerDAO;
	private IBaseGroupDAO baseGroupDAO;
	private IHouseAttachmentService houseAttachmentService;
	private IUserExtService userExtService;
	private ITaskLogService taskLogService;
	public ITaskLogService getTaskLogService() {
		return taskLogService;
	}

	public void setTaskLogService(ITaskLogService taskLogService) {
		this.taskLogService = taskLogService;
	}

	public IUserExtService getUserExtService() {
		return userExtService;
	}

	public void setUserExtService(IUserExtService userExtService) {
		this.userExtService = userExtService;
	}

	public IHouseAttachmentService getHouseAttachmentService() {
		return houseAttachmentService;
	}

	public void setHouseAttachmentService(
			IHouseAttachmentService houseAttachmentService) {
		this.houseAttachmentService = houseAttachmentService;
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public IOperateLogService getOperateLogService() {
		return operateLogService;
	}
	public void setOperateLogService(IOperateLogService operateLogService) {
		this.operateLogService = operateLogService;
	}
	public IHouseReadilyDAO getHouseReadilyDAO() {
		return houseReadilyDAO;
	}
	public void setHouseReadilyDAO(IHouseReadilyDAO houseReadilyDAO) {
		this.houseReadilyDAO = houseReadilyDAO;
	}
	public ICustomerDAO getCustomerDAO() {
		return customerDAO;
	}
	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public IBaseGroupDAO getBaseGroupDAO() {
		return baseGroupDAO;
	}

	public void setBaseGroupDAO(IBaseGroupDAO baseGroupDAO) {
		this.baseGroupDAO = baseGroupDAO;
	}
	
}
