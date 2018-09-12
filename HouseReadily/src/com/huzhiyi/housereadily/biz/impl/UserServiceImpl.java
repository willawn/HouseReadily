package com.huzhiyi.housereadily.biz.impl;

import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.biz.ICodeService;
import com.huzhiyi.housereadily.biz.IHouseReadilyService;
import com.huzhiyi.housereadily.biz.ISystemLogService;
import com.huzhiyi.housereadily.biz.ITaskLogService;
import com.huzhiyi.housereadily.biz.IUserExtService;
import com.huzhiyi.housereadily.biz.IUserService;
import com.huzhiyi.housereadily.entity.Code;
import com.huzhiyi.housereadily.entity.SystemLog;
import com.huzhiyi.housereadily.entity.UserExt;
import com.huzhiyi.housereadily.entity.UserTrend;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.housereadily.request.UserCheckCommand;
import com.huzhiyi.housereadily.request.UserCommand;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.HttpHelper;
import com.tastysoft.swct.util.MD5;

public class UserServiceImpl extends AbstractUserServiceImpl implements IUserService {

	@Override
	public void add(String userName, String password, String email, String mobile, String registerIp, String sinauid, String txuid,
			String operate, String ip, String version) {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		CUser user = new CUser();
		user.setName(userName);
		user.setPasswd(MD5.getMD5(password.getBytes()));
		user.setEmail(email);
		user.setMobile(mobile);
		user.setRegSource(2); // 注册来源（null：租售365，2：随手房）
		user.setTotalLoginCount(0); // 默认为0
		user.setSex(1); // 默认为男
		user.setStatus(1); // 启用状态
		user.setRegDate(currentTime); // 注册时间

		/*************** 必录字段设置默认值 **************/
		user.setDayLoginCount(0); // 当天登录次数
		user.setDayJifen(0); // 当天积分数
		user.setTotalJifen(0); // 总积分数
		user.setMoney(0.0d); // 金额
		user.setWsProcessOk(1);
		user.setWsProcessCur(1);
		user.setWsProcessIndex(0);
		user.setGroupId(-2); // 免费版
		user.setRecommendType(1);
		user.setCompanyAddress(""); // 门店地址
		user.setCompanyDescn(""); // 公司简介
		user.setCid(1000);
		user.setTjJifen(0); // 可用积分
		user.setTjLevel(0); // 等级 【成长值】
		user.setTjPublishCount(0);
		user.setVipType(1); // VIP类型
		user.setSmsCount(0); // 可发短信条数
		user.setUserType(0);

		// 新增用户
		super.add(user);

		// 新增用户扩展属性
		Integer isUpdate = 0;
		if ("ios".equals(operate) && isBigVersion(Configuration.UPDATE_IOS_VERSION, version)) {
			isUpdate = 1;
		} else if ("android".equals(operate)) {
			isUpdate = 1;
		}
		userExtService.add(user.getId(), isUpdate);

		// 注册成功
		if (null != user) {
			// 注册日志
			SystemLog systemLog = new SystemLog();
			systemLog.setUserId(user.getId());
			systemLog.setIp(ip);
			systemLog.setTerminal(operate);
			systemLog.setType(2); // （1：登录，2：注册，3：注销）
			systemLog.setDescription(MessageFormat.format(Configuration.USER_REGISTER_LOG, user.getName()));
			systemLog.setCreater(user.getId());
			systemLog.setCreateTime(currentTime);
			systemLogService.add(systemLog);
		}
	}

	@Override
	public boolean emailExist(String email) {
		return getUserDAO().countByEmail(email) > 0;
	}

	@Override
	public boolean usernameExist(String username) {
		return getUserDAO().countByUsername(username) > 0;
	}

	@Override
	public CUser findByNameAndMobile(String username, String mobile) {
		return getUserDAO().findByNameAndMobile(username, mobile);
	}

	@Override
	public Object[] verify(ICommand command) throws Exception {
		Object[] result = new Object[3];
		UserCheckCommand userCheckCommand = (UserCheckCommand) command;
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		CUser user = new CUser();
		user.setName(userCheckCommand.getUserName());
		user.setPasswd(MD5.getMD5(userCheckCommand.getPassword().getBytes()));
		user = getUserDAO().verify(user);
		Integer userId = user.getId();
		
		if(null !=user ) {
			initUserForeignValue(user);
		}
		result[0] = user;

		// 登录成功
		if (null != user) {
			user.setTotalLoginCount(user.getTotalLoginCount() + 1);

			// 登录日志
			SystemLog systemLog = new SystemLog();
			systemLog.setUserId(userId);
			systemLog.setIp(userCheckCommand.getIp());
			systemLog.setTerminal(userCheckCommand.getOperate());
			systemLog.setType(1); // （1：登录，2：注册，3：注销）
			systemLog.setDescription(MessageFormat.format(Configuration.USER_LOGIN_LOG, user.getName()));
			systemLog.setCreater(userId);
			systemLog.setCreateTime(currentTime);
			systemLogService.add(systemLog);

			// 修改人：willter，修改时间：2013-05-21，修改描述：修复ios版本数据bug，1.2.2版本之后需要修复数据，房源表中的租售类型，单价，总价
			UserExt userExt = userExtService.findByUserId(userId);
			if ("ios".equals(userCheckCommand.getOperate())
					&& isBigVersion(Configuration.UPDATE_IOS_VERSION, userCheckCommand.getVersion())
					&& (userExt.getIsUpdate() == null || userExt.getIsUpdate() == 0)) {
				houseReadilyService.updateIosBug(userId);
				userExtService.updateIsUpdate(userId, 1);
			} else if ("android".equals(userCheckCommand.getOperate()) && (userExt.getIsUpdate() == null || userExt.getIsUpdate() == 0)) {
				userExtService.updateIsUpdate(userId, 1);
			}

			// 新增登录积分日志
			result[1] = taskLogService.add(userId, Integer.parseInt(Configuration.TASK_LOGIN_ID), null);

			// 新增赠送积分日志
			result[2] = 0;
			// List<TaskLog> taskLogList = taskLogService.findAll(userId,
			// Integer.parseInt(Configuration.TASK_REGISTERGIFT_ID), null,
			// null);
			if (user.getRegDate().compareTo(DateUtils.parse("2013-06-16 00:00:00", Constants.DATEFORMAT)) < 0) {
				if (("ios".equals(userCheckCommand.getOperate()) && isBigVersion("1.3.0", userCheckCommand.getVersion()))
						|| ("android".equals(userCheckCommand.getOperate()) && (StringUtils.isNotEmpty(userCheckCommand.getVersion()) ? Integer
								.parseInt(userCheckCommand.getVersion())
								: 0) >= 2013060916)) {
					result[2] = taskLogService.add(userId, Integer.parseInt(Configuration.TASK_REGISTERGIFT_ID), null);
				}
			}
		}

		return result;
	}

	private boolean isBigVersion(String sourceVersion, String version) {
		String str1 = version;
		String str2 = sourceVersion;
		String[] s1 = str1.split("\\.");
		String[] s2 = str2.split("\\.");

		int n1 = s1.length;
		int n2 = s2.length;
		if (n1 == n2) {
			for (int i = 0; i < n1; i++) {
				if (Integer.parseInt(s1[i]) - Integer.parseInt(s2[i]) > 0) {
					return true;
				}
				if (Integer.parseInt(s1[i]) - Integer.parseInt(s2[i]) < 0) {
					return false;
				}
			}
		}
		if (n1 < n2) {
			return false;
		}
		if (n1 > n2) {
			return true;
		}
		return true;
	}

	@Override
	public List<CUser> findByMobileAndPassword(String mobile, String password) {
		return getUserDAO().findByMobileAndPassword(mobile, password);
	}

	@Override
	public Object[] update(ICommand command) throws Exception {
		Object[] result = new Object[2];
		UserCommand userCommand = (UserCommand) command;
		Integer userId = userCommand.getUserId();
		String password = userCommand.getPassword();
		String email = userCommand.getEmail();
		String mobile = userCommand.getMobile();
		String realName = userCommand.getRealName();
		Integer cityCode = userCommand.getCityCode();
		String avatar = userCommand.getAvatar();
		String properties = userCommand.getProperties();

		CUser user = findById(userId);
		UserExt userExt = userExtService.findByUserId(userId);
		if (properties.indexOf("password") > -1) {
			user.setPasswd(MD5.getMD5(password.getBytes()));
		}
		if (properties.indexOf("email") > -1) {
			user.setEmail(email);
		}
		if (properties.indexOf("mobile") > -1) {
			user.setMobile(mobile);
		}
		if (properties.indexOf("realName") > -1) {
			user.setRealname(realName);
			user.setRealFirstName(realName.substring(0, 1));
			user.setRealLastName(realName.substring(1));
		}
		if (properties.indexOf("cityCode") > -1) {
			user.setCityCode(cityCode);
		}

		Integer growing = 0;
		// 判断是否完善用户信息
		if (StringUtils.isNotEmpty(user.getEmail()) && StringUtils.isNotEmpty(user.getMobile())
				&& StringUtils.isNotEmpty(user.getRealname()) && user.getCityCode() > 0) {
			// 新增积分日志
			growing = taskLogService.add(userId, Integer.parseInt(Configuration.TASK_PERSONAL_ID), null);
		}

		if (properties.indexOf("avatar") > -1) {
			userExt.setAvatar(avatar.split(",")[1]);

			// 新增积分日志
			growing = taskLogService.add(userId, Integer.parseInt(Configuration.TASK_AVATAR_ID), null);
		}

		result[0] = findById(user.getId());
		result[1] = growing;

		return result;
	}

	@Override
	public String sendCode(String userName, String mobile) {
		String code = codeService.getCode(mobile);
		String msg = null;
		try {
			String encodeMsg = MessageFormat.format(Configuration.CODE_MSG, code);
			msg = URLEncoder.encode(encodeMsg, "GBK");
			if (StringUtils.isNotEmpty(msg)) {
				String url = MessageFormat.format(Configuration.SEND_MSG_URL, mobile, msg);
				String result = HttpHelper.doGet(url, null, "utf-8", false);
				if (StringUtils.isNotEmpty(result) && result.equals("0")) {
					Code c = new Code();
					CUser user = findByNameAndMobile(userName, null);
					c.setUserId(user.getId());
					c.setUserName(userName);
					c.setMobile(mobile);
					c.setCode(code);
					c.setDescription(encodeMsg);
					c.setCreateTime(new Timestamp(System.currentTimeMillis()));
					codeService.add(c);
					return code;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updatePassword(String userName, String password) {
		CUser user = findByNameAndMobile(userName, null);
		if (null != user) {
			user.setPasswd(MD5.getMD5(password.getBytes()));
			return user.getPasswd();
		}
		return null;
	}

	@Override
	public void addUserExt() {
		PagingBean pagingBean = new PagingBean();
		pagingBean.setCurrentPage(1);
		pagingBean.setPageRows(10000);
		List<CUser> userList = getUserDAO().findPaging(null, null, null, null, null, null, null, null, "regDate", "asc", pagingBean, false);
		for (CUser user : userList) {
			if (!userExtService.userExtExist(user.getId())) {
				userExtService.add(user.getId(), 0);
			}
		}
	}

	@Override
	public CUser findById(Integer id) {
		CUser user = super.findById(id);
		initUserForeignValue(user);

		return user;
	}

	@Override
	public List<CUser> findPaging(Integer id, String userName, Integer regSource, Integer cityCode, String mobile, String email, Date beginDate,
			Date endDate, String sort, String dir, PagingBean pagingBean, boolean isSelectUserExt) {
		List<CUser> userList = getUserDAO().findPaging(id, userName, regSource, cityCode, mobile, email, beginDate, endDate, sort, dir, pagingBean, isSelectUserExt);
		for (CUser user : userList) {
			initUserForeignValue(user);
		}
		return userList;
	}
	
	@Override
	public List<Object> export(Integer id, String userName, Integer regSource, Integer cityCode, String mobile, String email, Date beginDate, Date endDate,
			String sort, String dir) {
		return getUserDAO().export(id, userName, regSource, cityCode, mobile, email, beginDate, endDate, sort, dir);
	}
	
	private void initUserForeignValue(CUser user) {
		if (null != user) {
			UserExt userExt = userExtService.findByUserId(user.getId());
			
			user.setUserExt(userExt);
			user.setHouseReadilyCount(userExt.getHouseReadilyCount());
			user.setCustomerCount(userExt.getCustomerCount());
			user.setLevel(userExt.getLevel());
			user.setGrowing(userExt.getGrowing());
			user.setIntegration(userExt.getIntegration());
		}
	}

	@Override
	public List<UserTrend> findByUserTrend(Date createTime) throws Exception {
		return getUserDAO().findByUserTrend(createTime);
	}

	private IUserExtService userExtService;
	private ISystemLogService systemLogService;
	private ICodeService codeService;
	private ITaskLogService taskLogService;
	private IHouseReadilyService houseReadilyService;

	public IUserExtService getUserExtService() {
		return userExtService;
	}

	public void setUserExtService(IUserExtService userExtService) {
		this.userExtService = userExtService;
	}

	public ISystemLogService getSystemLogService() {
		return systemLogService;
	}

	public void setSystemLogService(ISystemLogService systemLogService) {
		this.systemLogService = systemLogService;
	}

	public ICodeService getCodeService() {
		return codeService;
	}

	public void setCodeService(ICodeService codeService) {
		this.codeService = codeService;
	}

	public ITaskLogService getTaskLogService() {
		return taskLogService;
	}

	public void setTaskLogService(ITaskLogService taskLogService) {
		this.taskLogService = taskLogService;
	}

	public IHouseReadilyService getHouseReadilyService() {
		return houseReadilyService;
	}

	public void setHouseReadilyService(IHouseReadilyService houseReadilyService) {
		this.houseReadilyService = houseReadilyService;
	}
}