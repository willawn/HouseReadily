package com.huzhiyi.housereadily.resource;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

import com.huzhiyi.housereadily.biz.ICodeService;
import com.huzhiyi.housereadily.biz.IUserService;
import com.huzhiyi.housereadily.entity.Code;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.housereadily.request.UserCheckCommand;
import com.huzhiyi.housereadily.response.UserCheckResult;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.AuthHelper;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.JsonHelper;
import com.huzhiyi.utils.RequestUtils;
import com.tastysoft.swct.util.MD5;

public class UserCheckResource extends BaseResource {

	private static final String REGISTER = "register";
	private static final String LOGIN = "login";
	private static final String RETAKEPASSWORD = "retakepassword";
	private static final String SENDCODE = "sendcode";
	private static final String ADDUSEREXT = "adduserext";

	@Override
	protected void doInit() throws ResourceException {
		command = new UserCheckCommand();
		super.doInit();
	}

	@Override
	public void initQueryForm() {
		initData(queryForm);
	}

	private void initData(Form form) {
		getCommand().setUserName(RequestUtils.requestPropertyValue(form, "userName", ""));
		getCommand().setPassword(RequestUtils.requestPropertyValue(form, "password", ""));
		getCommand().setEmail(RequestUtils.requestPropertyValue(form, "email", ""));
		getCommand().setMobile(RequestUtils.requestPropertyValue(form, "mobile", ""));
		getCommand().setCode(RequestUtils.requestPropertyValue(form, "code", ""));
		getCommand().setVersion(RequestUtils.requestPropertyValue(form, "version", ""));
	}

	public UserCheckCommand getCommand() {
		return (UserCheckCommand) command;
	}

	private Representation login() {
		UserCheckResult userCheckResult = new UserCheckResult();
		String userName = getCommand().getUserName();
		String password = getCommand().getPassword();
		CUser user = null;
		Integer growing = null;
		Integer giftGrowing = null;
		
		// 检查用户名是否存在
		boolean usernameExist = userService.usernameExist(userName);
		if (!usernameExist) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.USERNAME_NOTEXIST));
		}

		// 是否公共密码
		if (Configuration.COMMON_PASSWORD.equals(password)) {
			user = userService.findByNameAndMobile(userName, null);
			growing = 0;
			giftGrowing = 0;
		} else {
			// 正常登录校验
			try {
				Object[] result = userService.verify(command);
				user = (CUser) result[0];
				growing = (Integer) result[1];
				giftGrowing = (Integer) result[2];
			} catch (Exception e) {
				return JsonHelper.getJson(getStatusResult(0, Configuration.LOGIN_FAILURE));
			}
		}

		// 登录后返回信息
		String auth = "";
		Integer userId = null;
		if (user != null) {
			auth = AuthHelper.buildMd5(user.getId());
			userId = user.getId();
			if (!user.isEnabled()) {
				return JsonHelper.getJson(getStatusResult(0, Configuration.USER_DISABLE));
			} else {
				// 登录成功
				userCheckResult.setStatus(1);
				userCheckResult.setMsg(Configuration.LOGIN_SUCCESS);
				userCheckResult.setCommand(command);
				userCheckResult.setAuth(auth);
				userCheckResult.setUserId(userId);
				userCheckResult.setUserName(user.getName());
				userCheckResult.setEmail(user.getEmail());
				userCheckResult.setMobile(user.getMobile());

				userCheckResult.setCityCode(user.getCityCode());
				userCheckResult.setGroupId(user.getGroupId());
				userCheckResult.setGroupName(user.getGroupName());
				userCheckResult.setSmsCount(user.getSmsCount());
				userCheckResult.setVipExpireTime(user.getVipExpireTimeStr());
				userCheckResult.setRealName(user.getRealname());
				userCheckResult.setAvatar(StringUtils.isNotEmpty(user.getUserExt().getAvatar()) ? Configuration.WEB_SITE_PATH + user.getUserExt().getAvatar() : "");
				if (user.getGroupId() < 2 && userCheckResult.getLive() == 0) {
					userCheckResult.setAuthOk(-1);
				}
				
				// 增加返回积分属性
				userCheckResult.setGrowing(growing);
				// 本次有增加赠送积分，返回提示字符串
				if (giftGrowing > 0) {
					userCheckResult.setExtMsg(MessageFormat.format(Configuration.EXTMSG, giftGrowing));
				} else {
					userCheckResult.setExtMsg("");
				}
			}
		} else {
			List<CUser> userList = userService.findByMobileAndPassword(getCommand().getUserName(), MD5.getMD5(getCommand().getPassword().getBytes()));
			if (userList.size() > 1) {
				return JsonHelper.getJson(getStatusResult(0, Configuration.MOBILE_MANY_USER));
			}
			return JsonHelper.getJson(getStatusResult(0, Configuration.LOGIN_FAILURE));
		}

		return JsonHelper.getJson(userCheckResult);
	}

	private Representation register() {
		String userName = getCommand().getUserName();
		String password = getCommand().getPassword();
		String email = getCommand().getEmail();
		String mobile = getCommand().getMobile();
		String sinauid = null;
		String txuid = null;
		String operate = getCommand().getOperate();
		String ip = RequestUtils.getIpAddr(request);
		String version = getCommand().getVersion();

		// 检查用户名是否存在
		if (!StringUtils.isEmpty(userName)) {
			CUser user = userService.findByNameAndMobile(userName, null);
			if (null != user) {
				if (user.getRegSource() != null && user.getRegSource() == 2) {
					return JsonHelper.getJson(getStatusResult(0, Configuration.USERNAME_EXIST_REGISTER));
				} else if (user.getRegSource() == null || user.getRegSource() == 1) {
					return JsonHelper.getJson(getStatusResult(0, Configuration.USERNAME_EXIST_ZUSHOU365));
				}
			}
		}
		
		// 检查手机号码是否存在
		if (!StringUtils.isEmpty(mobile)) {
			CUser user = userService.findByNameAndMobile(null, mobile);
			if (null != user) {
				return JsonHelper.getJson(getStatusResult(0, Configuration.MOBILE_EXIST_REGISTER));
			}
		}

		// 检查邮箱是否存在
		if (!StringUtils.isEmpty(email)) {
			boolean emailExist = userService.emailExist(email);
			if (emailExist) {
				return JsonHelper.getJson(getStatusResult(0, Configuration.EMAIL_EXIST_REGISTER));
			}
		}

		// 注册用户
		String registerIp = RequestUtils.getIpAddr(request);
		userService.add(userName, password, email, mobile, registerIp, sinauid, txuid, operate, ip, version);

		return JsonHelper.getJson(getStatusResult(1, Configuration.REGISTER_SUCCESS));
	}

	private Representation sendcode() {
		String userName = getCommand().getUserName();
		String mobile = getCommand().getMobile();

		CUser user = userService.findByNameAndMobile(userName, null);

		// 检查用户是否存在
		if (null == user) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.USERNAME_NOTEXIST));
		}

		// 检查用户是否通过随手房注册
		if (!(user.getRegSource() != null && user.getRegSource() == 2)) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.USERNAME_REGISTER_SUISHOUFANG_NOTEXIST));
		}

		// 检查用户的手机号码是否有绑定
		if (StringUtils.isEmpty(user.getMobile())) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.MOBILE_INFO_NOTEXIST));
		}

		// 检查用户名和手机号码是否正确
		if (!user.getMobile().equals(mobile)) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.USERNAME_MOBILE_ERROR));
		}

		Code code = codeService.findCodeByUserNameAndMobile(userName, mobile);
		if (null != code) {
			Date createTime = DateUtils.addDate(new Date(code.getCreateTime().getTime()), Calendar.MINUTE, 10);
			if (createTime.compareTo(new Date()) >= 0) {
				return JsonHelper.getJson(getStatusResult(0, Configuration.CODE_EXIST));
			}
		}

		String result = userService.sendCode(userName, mobile);
		if (StringUtils.isNotEmpty(result)) {
			return JsonHelper.getJson(getStatusResult(1, Configuration.SEND_SUCCESS));
		} else {
			return JsonHelper.getJson(getStatusResult(0, Configuration.SEND_FAILURE));
		}
	}

	private Representation retakepassword() {
		String userName = getCommand().getUserName();
		String password = getCommand().getPassword();
		String mobile = getCommand().getMobile();
		String code$ = getCommand().getCode();
		Code code = codeService.findCodeByCodeAndMobile(code$, mobile);
		if (!(null != code && code.getUserName().equals(userName)
				&& DateUtils.addDate(new Date(code.getCreateTime().getTime()), Calendar.MINUTE, 10).compareTo(new Date()) >= 0)) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.CODE_ERROR));
		}
		String passwordNew = userService.updatePassword(userName, password);
		if (StringUtils.isNotEmpty(passwordNew)) {
			return JsonHelper.getJson(getStatusResult(1, Configuration.UPDATE_SUCCESS));
		} else {
			return JsonHelper.getJson(getStatusResult(0, Configuration.UPDATE_FAILURE));
		}
	}
	
	private Representation adduserext() {
		userService.addUserExt();
		return JsonHelper.getJson(getStatusResult(1, Configuration.UPDATE_SUCCESS));
	}

	@Get
	public Representation get() {
		Representation representation = null;

		if (LOGIN.equals(command.getAction())) {
			representation = login();
		} else if (SENDCODE.equals(command.getAction())) {
			representation = sendcode();
		} else if (ADDUSEREXT.equals(command.getAction())) {
			representation = adduserext();
		}

		return representation;
	}

	@Override
	@Post
	public Representation post(Representation entity) throws ResourceException {
		Representation representation = null;
		Form form = new Form(entity);
		initData(form);

		if (REGISTER.equals(command.getAction())) {
			representation = register();
		} else if (RETAKEPASSWORD.equals(command.getAction())) {
			representation = retakepassword();
		}

		return representation;
	}

	private IUserService userService;
	private ICodeService codeService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ICodeService getCodeService() {
		return codeService;
	}

	public void setCodeService(ICodeService codeService) {
		this.codeService = codeService;
	}

}
