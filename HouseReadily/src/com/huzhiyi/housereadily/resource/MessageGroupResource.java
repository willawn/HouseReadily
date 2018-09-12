package com.huzhiyi.housereadily.resource;

import static com.huzhiyi.model.PagingBean.cpn;
import static com.huzhiyi.model.PagingBean.cps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

import com.huzhiyi.housereadily.biz.IBaseGroupService;
import com.huzhiyi.housereadily.biz.ICustomerService;
import com.huzhiyi.housereadily.biz.IHouseReadilyService;
import com.huzhiyi.housereadily.biz.IMemberGroupService;
import com.huzhiyi.housereadily.biz.IMessageGroupService;
import com.huzhiyi.housereadily.entity.BaseGroup;
import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.housereadily.entity.MessageGroup;
import com.huzhiyi.housereadily.request.MessageGroupCommand;
import com.huzhiyi.housereadily.response.MessageGroupListResult;
import com.huzhiyi.housereadily.response.MessageGroupResult;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.JsonHelper;
import com.huzhiyi.utils.RequestUtils;
import com.huzhiyi.utils.ResponseUtils;

public class MessageGroupResource extends BaseResource {

	private static final String ADD = "add";
	private static final String DELETE = "delete";
	private static final String LIST = "list";
	private static final String MESSAGELIST = "messagelist";
	private static final String FIND = "find";
	
	
	@Override
	protected void doInit() throws ResourceException {
		command = new MessageGroupCommand();
		super.doInit();
	}

	@Override
	protected void initQueryForm() {
		initData(queryForm);
	}

	private void initData(Form form) {
		getCommand().setId(RequestUtils.requestPropertyIntValue(form, "id"));
		getCommand().setBaseGroupId(RequestUtils.requestPropertyIntValue(form, "baseGroupId"));
		getCommand().setTitle(RequestUtils.requestPropertyValue(form, "title",""));
		getCommand().setDescription(RequestUtils.requestPropertyValue(form, "description", ""));
		getCommand().setMtype(RequestUtils.requestPropertyIntValue(form, "mtype", 0));
		getCommand().setSource(RequestUtils.requestPropertyIntValue(form, "source",0));
		getCommand().setSctype(RequestUtils.requestPropertyIntValue(form, "sctype", 0));
		getCommand().setOwnerRate(RequestUtils.requestPropertyDoubleValue(form, "ownerRate",0.00));
		getCommand().setOtherRate(RequestUtils.requestPropertyDoubleValue(form, "otherRate",0.00));
		getCommand().setBrokerage(RequestUtils.requestPropertyDoubleValue(form, "brokerage",0.00));
		getCommand().setRemarks(RequestUtils.requestPropertyValue(form, "remarks",""));
		getCommand().setShare(RequestUtils.requestPropertyValue(form, "share",""));
		getCommand().setCreater(RequestUtils.requestPropertyIntValue(form, "creater",0));
		getCommand().setPageNo(cpn(RequestUtils.requestPropertyIntValue(form, "pageNo")));
		getCommand().setPageSize(cps(RequestUtils.requestPropertyIntValue(form, "pageSize")));
	}

	public MessageGroupCommand getCommand() {
		return (MessageGroupCommand) command;
	}

	private void initData(MessageGroup messageGroup, MessageGroupResult messageGroupResult) {
		messageGroupResult.setCommand(command);
		messageGroupResult.setId(messageGroup.getId());
		messageGroupResult.setBaseGroupId(messageGroup.getBaseGroupId());
		messageGroupResult.setTitle(messageGroup.getTitle());
		messageGroupResult.setDescription(messageGroup.getDescription());
		messageGroupResult.setMtype(messageGroup.getMtype());
		messageGroupResult.setSource(messageGroup.getSource());
		messageGroupResult.setSctype(messageGroup.getSctype());
		messageGroupResult.setOwnerRate(messageGroup.getOwnerRate());
		messageGroupResult.setOtherRate(messageGroup.getOtherRate());
		messageGroupResult.setBrokerage(messageGroup.getBrokerage());
		messageGroupResult.setShare(messageGroup.getShare());
		messageGroupResult.setSyncTime(messageGroup.getSyncTime());
		messageGroupResult.setVersion(messageGroup.getVersion());
		messageGroupResult.setIsDelete(messageGroup.getIsDelete());
		messageGroupResult.setCreater(messageGroup.getCreater());
		messageGroupResult.setCreateTime(messageGroup.getCreateTime());
		messageGroupResult.setCreaterName(messageGroup.getCreaterName());
		messageGroupResult.setCreaterRealName(messageGroup.getCreaterRealName());
		messageGroupResult.setRemarks(messageGroup.getRemarks());
		messageGroupResult.setMobile(messageGroup.getMobile());
		messageGroupResult.setBaseGroupName(messageGroup.getBaseGroupName());
		messageGroupResult.setAvatar(messageGroup.getAvatar());
		messageGroupResult.setGrowing(messageGroup.getGrowing());
		
		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime", "updateTime", "syncTime" });
		String[] field = new String[] { "id", "stype",
				"projectId", "projectName", "cityCode", "cityEn", "cityName", "bigAreaCode", "bigAreaName", "smallAreaCode",
				"smallAreaName", "lon", "lat", "buildType", "buildTypeName", "title", "building", "houseNum", "roomNum", "hallNum",
				"toiletNum", "area", "unitPrice", "totalPrice", "towards", "fitment", "houseRight", "furn", "keyer", "hasRedBook",
				"description", "address", "lastFollowDate", "syncTime", "version", "updateTime", "state", "creater", "userName", "createTime" };
		JSONObject houseReadilys = ResponseUtils.getJSONByModel("list", messageGroup.getHouseReadilys(), parseDataKey, field);
		messageGroupResult.setHouseReadilys(houseReadilys);
		
		field = new String[] { "id", "buildType",
				"buildTypeName", "ctype", "cityCode", "cityEn", "cityName", "bigAreaCode",
				"bigAreaName", "smallAreaCode", "smallAreaName", "roomNum", "hallNum", "toiletNum", "beginFirstPayment", "endFirstPayment",
				"beginArea", "endArea", "beginUnitPrice", "endUnitPrice", "beginTotalPrice", "endTotalPrice", "year", "month",
				"description", "lastFollowDate", "syncTime", "version", "updateTime", "state", "creater", "userName", "createTime" };
		JSONObject customers = ResponseUtils.getJSONByModel("list", messageGroup.getCustomers(), parseDataKey, field);
		messageGroupResult.setCustomers(customers);
		
		parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime" });
		parseDataKey.put(Constants.PARSEIMGKEY, new String[] { "path", "spath", "mpath" });
		field = new String[] { "id", "type", "houseReadilyId", "name", "description", "path", "spath", "mpath", "size", "isPicture",
				"createTime" };
		JSONObject btAttachments = ResponseUtils.getJSONByModel("list", messageGroup.getBtAttachments(), parseDataKey, field);
		messageGroupResult.setBtAttachments(btAttachments);
		JSONObject snAttachments = ResponseUtils.getJSONByModel("list", messageGroup.getSnAttachments(), parseDataKey, field);
		messageGroupResult.setSnAttachments(snAttachments);
		JSONObject fxAttachments = ResponseUtils.getJSONByModel("list", messageGroup.getFxAttachments(), parseDataKey, field);
		messageGroupResult.setFxAttachments(fxAttachments);
		JSONObject xqAttachments = ResponseUtils.getJSONByModel("list", messageGroup.getXqAttachments(), parseDataKey, field);
		messageGroupResult.setXqAttachments(xqAttachments);
	}

	private void initData(List messageGroupList, PagingBean pagingBean, MessageGroupListResult messageGroupListResult) {
		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "syncTime", "createTime", "updateTime" });
		parseDataKey.put(Constants.PARSEIMGKEY, new String[] { "path", "spath", "mpath", "avatar" });
		parseDataKey.put(Constants.PARSECOLLKEY, new String[] { "houseReadilys", "customers", "btAttachments", "snAttachments", "fxAttachments", "xqAttachments" });
		
		String[] houseReadilys = new String[] { "id", "stype",
				"projectId", "projectName", "cityCode", "cityEn", "cityName", "bigAreaCode", "bigAreaName", "smallAreaCode",
				"smallAreaName", "lon", "lat", "buildType", "buildTypeName", "title", "building", "houseNum", "roomNum", "hallNum",
				"toiletNum", "area", "unitPrice", "totalPrice", "towards", "fitment", "houseRight", "furn", "keyer", "hasRedBook",
				"description", "address", "lastFollowDate", "syncTime", "version", "updateTime", "state", "creater", "userName", "createTime" };
		String[] customers = new String[] { "id", "buildType",
				"buildTypeName", "ctype", "cityCode", "cityEn", "cityName", "bigAreaCode",
				"bigAreaName", "smallAreaCode", "smallAreaName", "roomNum", "hallNum", "toiletNum", "beginFirstPayment", "endFirstPayment",
				"beginArea", "endArea", "beginUnitPrice", "endUnitPrice", "beginTotalPrice", "endTotalPrice", "year", "month",
				"description", "lastFollowDate", "syncTime", "version", "updateTime", "state", "creater", "userName", "createTime" };
		String[] fieldAttachments = { "id", "type", "houseReadilyId", "name", "description", "path", "spath", "mpath", "size", "isPicture",
		"createTime" };
		parseDataKey.put(Constants.PARSECOLLFIELD, new String[][] { houseReadilys, customers, fieldAttachments, fieldAttachments, fieldAttachments, fieldAttachments  });
		
		JSONObject messageGroups = ResponseUtils.getJSONByPagingBean(pagingBean, messageGroupList, parseDataKey, "id", "baseGroupId", "title",
				"description", "mtype", "source", "sctype", "ownerRate", "otherRate", "brokerage", "share", "remarks", "syncTime",
				"version", "isDelete", "creater", "createTime", "createrName", "createrRealName", "mobile", "baseGroupName", "avatar", "houseReadilys", 
				"customers", "btAttachments", "snAttachments", "fxAttachments", "xqAttachments");

		messageGroupListResult.setCommand(command);
		messageGroupListResult.setMessageGroups(messageGroups);
	}

	/**
	 * @Title: add
	 * @Description: 添加消息
	 *               <p>
	 * @author wuht128
	 * @date 2012-10-31
	 *       <p>
	 * @return
	 */
	private Representation add() {
		MessageGroupResult messageGroupResult = new MessageGroupResult();

		Integer userId = getCommand().getUserId();
		Integer baseGroupId = getCommand().getBaseGroupId();
		Integer mtype = getCommand().getMtype();
		Integer source = getCommand().getSource();
		
		// 查找群是否存在
		BaseGroup baseGroup = baseGroupService.findById(baseGroupId);
		if (null == baseGroup) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_BASEGROUP_NUM));
		}
			
		// 判断群是否存在这个用户
		boolean isExits = memberGroupService.exitsMemberGroup(baseGroupId, userId);
		if (!isExits) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.MESSAGEGROUP_FAILURE));
		}
		
		if(mtype == 1){
			//判断房源是否存在
			HouseReadily houseReadily = houseReadilyService.findById(source);
			if(null == houseReadily){
				return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_HOUSEREADILY));
			}
			//判断用户是否存在 这个房源
			if(!userId.equals(houseReadily.getCreater())){
				return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_HOUSEREADILY));
			}
			//判断群是否存在这个房源
			isExits = messageGroupService.exitsMessageGroup(baseGroupId, userId , mtype, source);
			if (isExits) {
				return JsonHelper.getJson(getStatusResult(0, Configuration.MESSAGEGROUP_EXIST));
			}
		}else if(mtype == 2){
			//判断客源是否存在
			Customer customer = customerService.findById(source);
			if(null == customer){
				return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_CUSTOMER));
			}
			//判断用户是否存在这个客源
			if(!userId.equals(customer.getCreater())){
				return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_CUSTOMER));
			}
			//判断群是否存在这个客源
			isExits = messageGroupService.exitsMessageGroup(baseGroupId, userId , mtype, source);
			if (isExits) {
				return JsonHelper.getJson(getStatusResult(0, Configuration.MESSAGEGROUP_EXIST));
			}
		}
		
		MessageGroup messageGroup = null;
		try {
			messageGroup = messageGroupService.add(command);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.SUBMIT_FAILURE));
		}

		messageGroupResult.setStatus(1);
		messageGroupResult.setMsg(Configuration.SUBMIT_SUCCESS);

		initData(messageGroup, messageGroupResult);

		return JsonHelper.getJson(messageGroupResult);
	}
	
	@Delete
	@Override
	public Representation delete() throws ResourceException {

		Integer userId = getCommand().getUserId();
		Integer id = getCommand().getId();
		
		//判断消息是否存在
		MessageGroup messageGroup = messageGroupService.findById(id);
		if(null == messageGroup){
			return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_MESSAGEGROUP));
		}
		
		//判断删除人是否是创建人
		if(!userId.equals(messageGroup.getCreater())){
			return JsonHelper.getJson(getStatusResult(0, Configuration.UPDATER_MESSAGEGROUP_CREATER));
		}
		
		try {
			messageGroupService.deleteById(command);
		} catch (Exception e) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.DELETE_FAILURE));
		}
		
		return JsonHelper.getJson(getStatusResult(1, Configuration.DELETE_SUCCESS));
	}
	
	/**
	 * @Title: find
	 * @Description: 群主消息详细信息查看
	 *               <p>
	 * @author willter
	 * @date 2012-12-5
	 *       <p>
	 * @return
	 */
	private Representation find() {
		Integer id = getCommand().getId();
		
		MessageGroupResult messageGroupResult = new MessageGroupResult();
		MessageGroup messageGroup = messageGroupService.findById(id);
		
		if( null != messageGroup ){
			initData(messageGroup, messageGroupResult);
		}else{
			return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_MESSAGEGROUP));
		}
		
		messageGroupResult.setStatus(1);
		return JsonHelper.getJson(messageGroupResult);
	}
	
	/**
	 * @Title: list
	 * @Description: 群消息列表查询
	 *               <p>
	 * @author wuht128
	 * @date 2013-8-21
	 *       <p>
	 * @return
	 */
	private Representation list() {
		MessageGroupListResult messageGroupListResult = new MessageGroupListResult();
		Integer baseGroupId = getCommand().getBaseGroupId();
		Integer creater = getCommand().getCreater();
		Integer mtype = getCommand().getMtype();
		Integer sctype = getCommand().getSctype();
		Integer pageNo = getCommand().getPageNo();
		Integer pageSize = getCommand().getPageSize();
		
		PagingBean pagingBean = new PagingBean();
		pagingBean.setCurrentPage(pageNo);
		pagingBean.setPageRows(pageSize);
		
		List messageGroupList = null;
		
		try {
			messageGroupList = messageGroupService.findPaging(baseGroupId, creater, mtype, sctype, pagingBean);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.SELECT_FAILURE));
		}
		
		messageGroupListResult.setStatus(1);
		initData(messageGroupList, pagingBean, messageGroupListResult);
		
		return JsonHelper.getJson(messageGroupListResult);
	}
	
	/**
	 * @Title: list
	 * @Description: 群消息列表查询
	 *               <p>
	 * @author wuht128
	 * @date 2013-8-21
	 *       <p>
	 * @return
	 */
	private Representation messagelist() {
		MessageGroupListResult messageGroupListResult = new MessageGroupListResult();
		Integer baseGroupId = getCommand().getBaseGroupId();
		Integer creater = getCommand().getCreater();
		Integer mtype = getCommand().getMtype();
		Integer sctype = getCommand().getSctype();
		Integer pageNo = getCommand().getPageNo();
		Integer pageSize = getCommand().getPageSize();
		
		PagingBean pagingBean = new PagingBean();
		pagingBean.setCurrentPage(pageNo);
		pagingBean.setPageRows(pageSize);
		
		List messageGroupList = null;
		
		try {
			messageGroupList = messageGroupService.findPagingMessage(baseGroupId, creater, mtype, sctype, pagingBean);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.SELECT_FAILURE));
		}
		
		messageGroupListResult.setStatus(1);
//		initData(messageGroupList, pagingBean, messageGroupListResult);
		
		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime" });
		parseDataKey.put(Constants.PARSEIMGKEY, new String[] { "avatar" });
		
		JSONObject messageGroups = ResponseUtils.getJSONByPagingBean(pagingBean, messageGroupList, parseDataKey, "id", "baseGroupId", "title",
				"description", "mtype", "source", "sctype", "creater", "createTime", "createrName", "createrRealName", "avatar" );

		messageGroupListResult.setCommand(command);
		messageGroupListResult.setMessageGroups(messageGroups);
		
		return JsonHelper.getJson(messageGroupListResult);
	}
	
	
	@Get
	@Override
	public Representation get() throws ResourceException {
		Representation representation = null;
		
		if (DELETE.equals(command.getAction())) {
			representation = delete();
		} else if(LIST.equals(command.getAction())){
			representation = list();
		} else if(FIND.equals(command.getAction())){
			representation = find();
		} else if(MESSAGELIST.equals(command.getAction())){
			representation = messagelist();
		}

		return representation;
	}

	@Post
	@Override
	public Representation post(Representation entity) throws ResourceException {
		Representation representation = null;
		Form form = new Form(entity);
		initData(form);

		if (ADD.equals(command.getAction())) {
			representation = add();
		} 

		return representation;
	}
	
	private IMessageGroupService messageGroupService;
	private IBaseGroupService baseGroupService;
	private IMemberGroupService memberGroupService;
	private ICustomerService customerService;
	private IHouseReadilyService houseReadilyService;

	public IMessageGroupService getMessageGroupService() {
		return messageGroupService;
	}

	public void setMessageGroupService(IMessageGroupService messageGroupService) {
		this.messageGroupService = messageGroupService;
	}

	public IBaseGroupService getBaseGroupService() {
		return baseGroupService;
	}

	public void setBaseGroupService(IBaseGroupService baseGroupService) {
		this.baseGroupService = baseGroupService;
	}

	public IMemberGroupService getMemberGroupService() {
		return memberGroupService;
	}

	public void setMemberGroupService(IMemberGroupService memberGroupService) {
		this.memberGroupService = memberGroupService;
	}

	public ICustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public IHouseReadilyService getHouseReadilyService() {
		return houseReadilyService;
	}

	public void setHouseReadilyService(IHouseReadilyService houseReadilyService) {
		this.houseReadilyService = houseReadilyService;
	}

}
