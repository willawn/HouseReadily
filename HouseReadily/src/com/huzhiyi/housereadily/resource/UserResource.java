package com.huzhiyi.housereadily.resource;

import java.util.List;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

import com.huzhiyi.housereadily.biz.ITaskService;
import com.huzhiyi.housereadily.biz.IUserService;
import com.huzhiyi.housereadily.entity.Task;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.housereadily.request.UserCommand;
import com.huzhiyi.housereadily.response.UserResult;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.JsonHelper;
import com.huzhiyi.utils.RequestUtils;
import com.tastysoft.swct.util.MD5;

public class UserResource extends BaseResource {

	private static final String FIND = "find";
	private static final String UPDATE = "update";
	
	@Override
	protected void doInit() throws ResourceException {
		command = new UserCommand();
		super.doInit();
	}

	@Override
	public void initQueryForm() {
		initData(queryForm);
	}

	private void initData(Form form) {
		getCommand().setPassword(RequestUtils.requestPropertyValue(form, "password", ""));
		getCommand().setOldPassword(RequestUtils.requestPropertyValue(form, "oldPassword", ""));
		getCommand().setEmail(RequestUtils.requestPropertyValue(form, "email", ""));
		getCommand().setMobile(RequestUtils.requestPropertyValue(form, "mobile", ""));
		getCommand().setRealName(RequestUtils.requestPropertyValue(form, "realName", ""));
		getCommand().setCityCode(RequestUtils.requestPropertyIntValue(form, "cityCode"));
		getCommand().setAvatar(RequestUtils.requestPropertyValue(form, "avatar", ""));
		getCommand().setProperties(RequestUtils.requestPropertyValue(form, "properties", ""));
	}
	
	public UserCommand getCommand() {
		return (UserCommand) command;
	}
	
	private void initData(CUser user, UserResult userResult, Integer growing, Integer growed) {
		userResult.setCommand(command);
		userResult.setStatus(1);
		userResult.setUserId(user.getId());
		userResult.setUserName(user.getName());
		userResult.setEmail(user.getEmail());
		userResult.setMobile(user.getMobile());
		userResult.setCityCode(user.getCityCode());
		userResult.setGroupId(user.getGroupId());
		userResult.setGroupName(user.getGroupName());
		userResult.setSmsCount(user.getSmsCount());
		userResult.setVipExpireTime(user.getVipExpireTimeStr());
		userResult.setRealName(user.getRealname());
		userResult.setHouseReadilyCount(user.getUserExt().getHouseReadilyCount());
		userResult.setCustomerCount(user.getUserExt().getCustomerCount());
		userResult.setGrowing(growing);
		userResult.setGrowed(growed);
		userResult.setAvatar(StringUtils.isNotEmpty(user.getUserExt().getAvatar()) ? Configuration.WEB_SITE_PATH + user.getUserExt().getAvatar() : "");
		userResult.setIsComplete(user.getIsComplete());
	}
	
	private Representation find() {
		UserResult userResult = new UserResult();
		Integer userId = getCommand().getUserId();

		if (null != userId && userId > 0) {
			CUser user = userService.findById(userId);
			if (null != user) {
				// 用户是否完成所有任务
				Integer isComplete = 1;
				try {
					List<Task> taskList = taskService.findAll(user.getId(), 1);
					for (int i = 0, size = taskList.size(); i < size; i++) {
						if (taskList.get(i).getCount() < taskList.get(i).getTotal()) {
							isComplete = 0;
							break;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					isComplete = 0;
				}
				user.setIsComplete(isComplete);
				
				initData(user, userResult, user.getUserExt().getGrowing(), null);
			} else {
				return JsonHelper.getJson(getStatusResult(0, Configuration.USERNAME_NOTEXIST));
			}
		}

		return JsonHelper.getJson(userResult);
	}

	private Representation update() {
		UserResult userResult = new UserResult();
		UserCommand userCommand = (UserCommand) command;
		Integer userId = userCommand.getUserId();
		String oldPassword = userCommand.getOldPassword();
		String properties = userCommand.getProperties();
		CUser user = null;
		if (properties.indexOf("password") > -1) {
			user = userService.findById(userId);
			if (!user.getPasswd().equals(MD5.getMD5(oldPassword.getBytes()))) {
				return JsonHelper.getJson(getStatusResult(0, Configuration.OLDPASSWORD_ERROR));
			}
		}
		Integer growed = null;
		try {
			Object[] result = userService.update(command);
			user = (CUser) result[0];
			growed = (Integer) result[1];
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.UPDATE_FAILURE));
		}

		initData(user, userResult, user.getUserExt().getGrowing(), growed);
		
		return JsonHelper.getJson(userResult);
	}
	
	@Get
	public Representation get() {
		Representation representation = null;

		if (FIND.equals(command.getAction())) {
			representation = find();
		}
		
		return representation;
	}

	@Override
	@Post
	public Representation post(Representation entity) throws ResourceException {
		Representation representation = null;
		Form form = new Form(entity);
		initData(form);

		if (UPDATE.equals(command.getAction())) {
			representation = update();
		} 
		
		return representation;
	}
	
	private IUserService userService;
	private ITaskService taskService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public ITaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(ITaskService taskService) {
		this.taskService = taskService;
	}
}
