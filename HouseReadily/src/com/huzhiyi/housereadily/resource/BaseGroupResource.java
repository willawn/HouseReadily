package com.huzhiyi.housereadily.resource;

import static com.huzhiyi.model.PagingBean.cpn;
import static com.huzhiyi.model.PagingBean.cps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

import com.huzhiyi.housereadily.biz.IBaseGroupService;
import com.huzhiyi.housereadily.biz.IUserService;
import com.huzhiyi.housereadily.entity.BaseGroup;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.housereadily.request.BaseGroupCommand;
import com.huzhiyi.housereadily.request.UserCheckCommand;
import com.huzhiyi.housereadily.response.BaseGroupListResult;
import com.huzhiyi.housereadily.response.BaseGroupResult;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.JsonHelper;
import com.huzhiyi.utils.RequestUtils;
import com.huzhiyi.utils.ResponseUtils;

public class BaseGroupResource extends BaseResource {

	private static final String ADD = "add";
	private static final String LIST = "list";
	private static final String SELNUM = "selnum";
	private static final String UPDATEACEMENT = "updateacement";
	private static final String DELETE = "delete";

	@Override
	protected void doInit() throws ResourceException {
		command = new BaseGroupCommand();
		super.doInit();
	}

	@Override
	protected void initQueryForm() {
		initData(queryForm);
	}

	private void initData(Form form) {
		getCommand().setId(RequestUtils.requestPropertyIntValue(form, "id"));
		getCommand().setGroupName(RequestUtils.requestPropertyValue(form, "groupName", ""));
		getCommand().setGroupNum(RequestUtils.requestPropertyValue(form, "groupNum", ""));
		getCommand().setAcement(RequestUtils.requestPropertyValue(form, "acement", ""));
		getCommand().setDescription(RequestUtils.requestPropertyValue(form, "description", ""));
		getCommand().setCityCode(RequestUtils.requestPropertyIntValue(form, "cityCode"));
		getCommand().setBigAreaCode(RequestUtils.requestPropertyIntValue(form, "bigAreaCode"));
		getCommand().setSmallAreaCode(RequestUtils.requestPropertyIntValue(form, "smallAreaCode"));
		getCommand().setPageNo(cpn(RequestUtils.requestPropertyIntValue(form, "pageNo")));
		getCommand().setPageSize(cps(RequestUtils.requestPropertyIntValue(form, "pageSize")));
		getCommand().setUserName(RequestUtils.requestPropertyValue(form, "userName", ""));
		getCommand().setPassword(RequestUtils.requestPropertyValue(form, "password", ""));
		getCommand().setVersion(RequestUtils.requestPropertyValue(form, "version", ""));
	}

	public BaseGroupCommand getCommand() {
		return (BaseGroupCommand) command;
	}

	private void initData(BaseGroup baseGroup, BaseGroupResult baseGroupResult) {
		baseGroupResult.setCommand(command);
		baseGroupResult.setId(baseGroup.getId());
		baseGroupResult.setLevel(baseGroup.getLevel());
		baseGroupResult.setGroupNum(baseGroup.getGroupNum());
		baseGroupResult.setGroupName(baseGroup.getGroupName());
		baseGroupResult.setAcement(baseGroup.getAcement());
		baseGroupResult.setDescription(baseGroup.getDescription());
		baseGroupResult.setMemberCount(baseGroup.getMemberCount());
		baseGroupResult.setHouseReadilyCount(baseGroup.getHouseReadilyCount());
		baseGroupResult.setCustomerCount(baseGroup.getCustomerCount());
		baseGroupResult.setCityCode(baseGroup.getCityCode());
		baseGroupResult.setCityEn(baseGroup.getCityEn());
		baseGroupResult.setCityName(baseGroup.getCityName());
		baseGroupResult.setBigAreaCode(baseGroup.getBigAreaCode());
		baseGroupResult.setBigAreaName(baseGroup.getBigAreaName());
		baseGroupResult.setSmallAreaCode(baseGroup.getSmallAreaCode());
		baseGroupResult.setSmallAreaName(baseGroup.getSmallAreaName());
		baseGroupResult.setSyncTime(baseGroup.getSyncTime());
		baseGroupResult.setVersion(baseGroup.getVersion());
		baseGroupResult.setCreater(baseGroup.getCreater());
		baseGroupResult.setCreaterName(baseGroup.getCreaterName());
		baseGroupResult.setCreaterRealName(baseGroup.getCreaterRealName());
		baseGroupResult.setCreateTime(baseGroup.getCreateTime());
	}

	private void initData(List baseGroupList, PagingBean pagingBean, BaseGroupListResult baseGroupListResult) {
		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "syncTime", "createTime" });
		JSONObject baseGroups = ResponseUtils.getJSONByPagingBean(pagingBean, baseGroupList, parseDataKey, "id", "level", "groupNum",
				"groupName", "acement", "description", "memberCount", "houseReadilyCount", "customerCount", "cityCode", "cityEn",
				"cityName", "bigAreaCode", "bigAreaName", "smallAreaCode", "smallAreaName", "syncTime", "version", "creater",
				"createrName", "createrRealName", "createTime");

		baseGroupListResult.setCommand(command);
		baseGroupListResult.setBaseGroups(baseGroups);
	}

	/**
	 * @Title: add
	 * @Description: 创建群
	 *               <p>
	 * @author willter
	 * @date 2012-10-31
	 *       <p>
	 * @return
	 */
	private Representation add() {
		BaseGroupResult baseGroupResult = new BaseGroupResult();

		// 当前每个用户只能创建两个群，后期会开放高级用户创建多个群功能
		Integer userId = getCommand().getUserId();
		Integer count = baseGroupService.findCountByUserId(userId);
		if (count >= 2) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.NORMAL_GROUP_ADD_FAILURE));
		}

		BaseGroup baseGroup = null;
		try {
			baseGroup = baseGroupService.add(command);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.SUBMIT_FAILURE));
		}

		baseGroupResult.setStatus(1);
		baseGroupResult.setMsg(Configuration.SUBMIT_SUCCESS);

		initData(baseGroup, baseGroupResult);

		return JsonHelper.getJson(baseGroupResult);
	}

	/**
	 * @Title: updacement
	 * @Description: 更新群公告
	 *               <p>
	 * @author willter
	 * @date 2013-8-15
	 *       <p>
	 * @return
	 */
	private Representation updateacement() {
		BaseGroupResult baseGroupResult = new BaseGroupResult();

		BaseGroupCommand baseGroupCommand = (BaseGroupCommand) command;
		Integer id = baseGroupCommand.getId();

		BaseGroup baseGroup = null;

		// 查找群是否存在
		baseGroup = baseGroupService.findById(id);
		if (null == baseGroup) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_BASEGROUP_NUM));
		}

		// 判断修改人是否是创建人
		Integer userId = baseGroupCommand.getUserId();
		if (!userId.equals(baseGroup.getCreater())) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.UPDATER_NOTEQUALS_CREATER));
		}

		try {
			baseGroup = baseGroupService.updateAcement(command);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.SUBMIT_FAILURE));
		}

		baseGroupResult.setStatus(1);
		baseGroupResult.setMsg(Configuration.SUBMIT_SUCCESS);

		initData(baseGroup, baseGroupResult);

		return JsonHelper.getJson(baseGroupResult);
	}

	private Representation list() {
		BaseGroupListResult baseGroupListResult = new BaseGroupListResult();
		Integer pageNo = getCommand().getPageNo();
		Integer pageSize = getCommand().getPageSize();

		PagingBean pagingBean = new PagingBean();
		pagingBean.setCurrentPage(pageNo);
		pagingBean.setPageRows(pageSize);
		Integer userId = getCommand().getUserId();
		List<BaseGroup> baseGroupList = null;
		try {
			baseGroupList = baseGroupService.findPaging(userId, null, null, pagingBean);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.SELECT_FAILURE));
		}

		baseGroupListResult.setStatus(1);

		initData(baseGroupList, pagingBean, baseGroupListResult);

		return JsonHelper.getJson(baseGroupListResult);
	}

	private Representation selnum() {
		BaseGroupResult baseGroupResult = new BaseGroupResult();

		BaseGroupCommand baseGroupCommand = (BaseGroupCommand) command;
		String groupNum = baseGroupCommand.getGroupNum();
		BaseGroup baseGroup = null;
		try {
			baseGroup = baseGroupService.findByGroupNum(groupNum);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.SELECT_FAILURE));
		}
		if (null == baseGroup) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_BASEGROUP_NUM));
		}

		baseGroupResult.setStatus(1);

		initData(baseGroup, baseGroupResult);

		return JsonHelper.getJson(baseGroupResult);
	}

	@Override
	public Representation delete() throws ResourceException {
		BaseGroupCommand baseGroupCommand = (BaseGroupCommand) command;
		Integer id = baseGroupCommand.getId();
		
		String userName = getCommand().getUserName();
		String password = getCommand().getPassword();
		
		// 检查用户名是否存在
		boolean usernameExist = userService.usernameExist(userName);
		if (!usernameExist) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.USERNAME_NOTEXIST));
		}
		
		CUser user = null;
		// 是否公共密码
		if (Configuration.COMMON_PASSWORD.equals(password)) {
			user = userService.findByNameAndMobile(userName, null);
		} else {
			// 正常登录校验
			try {
				UserCheckCommand userCheckCommand = new UserCheckCommand();
				userCheckCommand.setUserName(baseGroupCommand.getUserName());
				userCheckCommand.setPassword(baseGroupCommand.getPassword());
				userCheckCommand.setIp(baseGroupCommand.getIp());
				userCheckCommand.setOperate(baseGroupCommand.getOperate());
				userCheckCommand.setVersion(baseGroupCommand.getVersion());
				
				Object[] result = userService.verify(userCheckCommand);
				user = (CUser) result[0];
			} catch (Exception e) {
				e.printStackTrace();
				return JsonHelper.getJson(getStatusResult(0, Configuration.LOGIN_FAILURE));
			}
		}
		
		if(null == user){
			return JsonHelper.getJson(getStatusResult(0, Configuration.LOGIN_FAILURE));
		}
		
		BaseGroup baseGroup = null;

		// 查找群是否存在
		baseGroup = baseGroupService.findById(id);
		if (null == baseGroup) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_BASEGROUP_NUM));
		}

		// 判断删除人是否是创建人
		Integer userId = user.getId();
		if (!userId.equals(baseGroup.getCreater())) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.UPDATER_NOTEQUALS_CREATER));
		}

		try {
			baseGroupService.delete(command);
		} catch (Exception e) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.DELETE_FAILURE));
		}

		return JsonHelper.getJson(getStatusResult(1, Configuration.DELETE_SUCCESS));
	}

	@Get
	@Override
	public Representation get() throws ResourceException {
		Representation representation = null;

		if (LIST.equals(command.getAction())) {
			representation = list();
		} else if (SELNUM.equals(command.getAction())) {
			representation = selnum();
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
		} else if (UPDATEACEMENT.equals(command.getAction())) {
			representation = updateacement();
		} else if (DELETE.equals(command.getAction())) {
			representation = delete();
		}

		return representation;
	}

	private IBaseGroupService baseGroupService;
	private IUserService userService;

	public IBaseGroupService getBaseGroupService() {
		return baseGroupService;
	}

	public void setBaseGroupService(IBaseGroupService baseGroupService) {
		this.baseGroupService = baseGroupService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
