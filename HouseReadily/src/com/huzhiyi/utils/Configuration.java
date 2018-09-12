package com.huzhiyi.utils;

import java.util.Properties;

/**
 * @ClassName: Configuration
 * @Description: 读取配置文件信息工具类
 *               <p>
 * @author willter
 * @date 2013-8-16
 */
public class Configuration {

	public static Properties configProperties = null;

	public static String configFilePath = "/rest.properties";

	public static String LOGIN_SUCCESS = "";

	public static String LOGIN_FAILURE = "";

	public static String MOBILE_MANY_USER = "";

	public static String USER_LOGIN_LOG = "";

	public static String USER_LOGINOUT_LOG = "";

	public static String USER_REGISTER_LOG = "";

	public static String HOUSEREADILY_ADD_LOG = "";

	public static String HOUSEREADILY_UPDATE_LOG = "";

	public static String HOUSEREADILY_DELETE_LOG = "";

	public static String CUSTOMER_ADD_LOG = "";

	public static String CUSTOMER_UPDATE_LOG = "";

	public static String CUSTOMER_DELETE_LOG = "";

	public static String USER_DISABLE = "";

	public static String USERNAME_EXIST_REGISTER = "";

	public static String USERNAME_NOTEXIST = "";

	public static String USERNAME_EXIST_ZUSHOU365 = "";

	public static String EMAIL_EXIST_REGISTER = "";

	public static String CUSTOMER_EXIST_ADD = "";

	public static String REGISTER_SUCCESS = "";

	public static String WEB_SITE_PATH = "";

	public static String SUBMIT_SUCCESS = "";

	public static String SUBMIT_FAILURE = "";

	public static String UPDATE_SUCCESS = "";

	public static String UPDATE_FAILURE = "";

	public static String DELETE_SUCCESS = "";

	public static String DELETE_FAILURE = "";

	public static String SEND_SUCCESS = "";

	public static String SEND_FAILURE = "";

	public static String WEB_ROOT_PATH = "";

	public static String NO_PICTURE = "";

	public static String BT = "";

	public static String SN = "";

	public static String FX = "";

	public static String XQ = "";

	public static String DEFAULT_VERSION = "";

	public static String SELECT_IP_LOCATION = "";

	public static String SEND_MSG_URL = "";

	public static String CODE_MSG = "";

	public static String CODE_EXIST = "";

	public static String CODE_ERROR = "";

	public static String USERNAME_MOBILE_ERROR = "";

	public static String MOBILE_INFO_NOTEXIST = "";

	public static String USERNAME_REGISTER_SUISHOUFANG_NOTEXIST = "";

	public static String OLDPASSWORD_ERROR = "";

	public static String COMMON_PASSWORD = "";

	public static String UPDATE_IOS_VERSION = "";

	public static String TASK_AVATAR_ID = "";

	public static String TASK_PERSONAL_ID = "";

	public static String TASK_FIRSTSHARE_ID = "";

	public static String TASK_LOGIN_ID = "";

	public static String TASK_HOUSEREADILY_ID = "";

	public static String TASK_CUSTOMER_ID = "";

	public static String TASK_SHARE_ID = "";

	public static String TASK_REGISTERGIFT_ID = "";
	
	public static String TASK_MESSAGEGROUP_ID = "";

	public static String SHARE_SUCCESS = "";

	public static String SHARE_FAILURE = "";

	public static String SELECT_FAILURE = "";

	public static String EXTMSG = "";

	public static String NORMAL_GROUP_ADD_FAILURE = "";

	public static String NOT_FIND_BASEGROUP_NUM = "";

	public static String NOT_FIND_MEMBERGROUP = "";

	public static String NORMAL_MEMBERGROUP_ADD_FAILURE = "";

	public static String SEND_AUDIT_SUCCESS = "";

	public static String SEND_AUDIT_FAILURE = "";

	public static String SEND_AUDIT_ALREADY = "";

	public static String MEMBERGROUP_EXIST = "";

	public static String CODE_AUDIT_MEMBERGROUP_MSG = "";

	public static String UPDATER_NOTEQUALS_CREATER = "";

	public static String BASEGROUP_ADD_LOG = "";

	public static String BASEGROUP_UPDATE_LOG = "";

	public static String BASEGROUP_DELETE_LOG = "";

	public static String AUDITMEMBER_ISPASSED = "";

	public static String AUDIT_SUCCESS = "";

	public static String AUDIT_FAILURE = "";

	public static String APPLY_GROUP_PASS = "";

	public static String APPLY_GROUP_REFUSE = "";

	public static String MEMBERGROUP_ADD_LOG = "";

	public static String MEMBERGROUP_DELETE_LOG = "";

	public static String MEMBERGROUP_QUITGROUP_LOG = "";

	public static String CANNOT_QUITGROUP_CREATER_LOG = "";

	public static String QUITGROUP_SUCCESS = "";

	public static String QUITGROUP_FAILURE = "";
	
	public static String MESSAGEGROUP_ADD_HOUSEREADILY = "";
	
	public static String MESSAGEGROUP_HOUSEREADILY = "";
	
	public static String MESSAGEGROUP_ADD_CUSTOMER = "";
	
	public static String MESSAGEGROUP_CUSTOMER = "";
	
	public static String MESSAGEGROUP_ADD = "";
	
	public static String MESSAGEGROUP_FAILURE = "";
	
	public static String NOT_FIND_HOUSEREADILY = "";
	
	public static String NOT_FIND_CUSTOMER = "";
	
	public static String MESSAGEGROUP_EXIST = "";
	
	public static String NOT_FIND_MESSAGEGROUP = "";
	
	public static String UPDATER_MESSAGEGROUP_CREATER = "";
	
	public static String MESSAGEGROUP_DELETE_HOUSEREADILY = "";
	
	public static String MESSAGEGROUP_DELETE_CUSTOMER = "";
	
	public static String MESSAGEGROUP_DELETE = "";
	
	public static String ROOMHALLTOILET = "";
	
	public static String MOBILE_EXIST_REGISTER = "";
	
	public static String CZ = "";
	
	public static String CS = "";
	
	public static String YZ = "";
	
	public static String QZ = "";
	
	public static String QG = "";

	static {

		try {
			configProperties = ConfigHelper.getConfigProperties(configFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		WEB_SITE_PATH = configProperties.getProperty("web_site_path", "");
		LOGIN_SUCCESS = configProperties.getProperty("login_success", "");
		LOGIN_FAILURE = configProperties.getProperty("login_failure", "");
		MOBILE_MANY_USER = configProperties.getProperty("mobile_many_user", "");
		USER_LOGIN_LOG = configProperties.getProperty("user_login_log", "");
		USER_LOGINOUT_LOG = configProperties.getProperty("user_loginout_log", "");
		USER_REGISTER_LOG = configProperties.getProperty("user_register_log", "");
		HOUSEREADILY_ADD_LOG = configProperties.getProperty("housereadily_add_log", "");
		HOUSEREADILY_UPDATE_LOG = configProperties.getProperty("housereadily_update_log", "");
		HOUSEREADILY_DELETE_LOG = configProperties.getProperty("housereadily_delete_log", "");
		CUSTOMER_ADD_LOG = configProperties.getProperty("customer_add_log", "");
		CUSTOMER_UPDATE_LOG = configProperties.getProperty("customer_update_log", "");
		CUSTOMER_DELETE_LOG = configProperties.getProperty("customer_delete_log", "");
		USER_DISABLE = configProperties.getProperty("user_disable", "");
		USERNAME_EXIST_REGISTER = configProperties.getProperty("username_exist_register", "");
		USERNAME_NOTEXIST = configProperties.getProperty("username_notexist", "");
		USERNAME_EXIST_ZUSHOU365 = configProperties.getProperty("username_exist_zushou365", "");
		EMAIL_EXIST_REGISTER = configProperties.getProperty("email_exist_register", "");
		CUSTOMER_EXIST_ADD = configProperties.getProperty("customer_exist_add", "");
		REGISTER_SUCCESS = configProperties.getProperty("register_success", "");
		SUBMIT_SUCCESS = configProperties.getProperty("submit_success", "");
		SUBMIT_FAILURE = configProperties.getProperty("submit_failure", "");
		UPDATE_SUCCESS = configProperties.getProperty("update_success", "");
		UPDATE_FAILURE = configProperties.getProperty("update_failure", "");
		DELETE_SUCCESS = configProperties.getProperty("delete_success", "");
		DELETE_FAILURE = configProperties.getProperty("delete_failure", "");
		SEND_SUCCESS = configProperties.getProperty("send_success", "");
		SEND_FAILURE = configProperties.getProperty("send_failure", "");
		WEB_ROOT_PATH = configProperties.getProperty("web_root_path", "");
		NO_PICTURE = configProperties.getProperty("no_picture", "");
		BT = configProperties.getProperty("bt", "");
		SN = configProperties.getProperty("sn", "");
		FX = configProperties.getProperty("fx", "");
		XQ = configProperties.getProperty("xq", "");
		DEFAULT_VERSION = configProperties.getProperty("default_version", "");
		SELECT_IP_LOCATION = configProperties.getProperty("select_ip_location", "");
		SEND_MSG_URL = configProperties.getProperty("send_msg_url", "");
		CODE_MSG = configProperties.getProperty("code_msg", "");
		CODE_EXIST = configProperties.getProperty("code_exist", "");
		CODE_ERROR = configProperties.getProperty("code_error", "");
		USERNAME_MOBILE_ERROR = configProperties.getProperty("username_mobile_error", "");
		MOBILE_INFO_NOTEXIST = configProperties.getProperty("mobile_info_notexist", "");
		USERNAME_REGISTER_SUISHOUFANG_NOTEXIST = configProperties.getProperty("username_register_suishoufang_notexist", "");
		OLDPASSWORD_ERROR = configProperties.getProperty("oldpassword_error", "");
		COMMON_PASSWORD = configProperties.getProperty("common_password", "");
		UPDATE_IOS_VERSION = configProperties.getProperty("update_ios_version", "");
		TASK_AVATAR_ID = configProperties.getProperty("task_avatar_id", "");
		TASK_PERSONAL_ID = configProperties.getProperty("task_personal_id", "");
		TASK_FIRSTSHARE_ID = configProperties.getProperty("task_firstshare_id", "");
		TASK_LOGIN_ID = configProperties.getProperty("task_login_id", "");
		TASK_HOUSEREADILY_ID = configProperties.getProperty("task_housereadily_id", "");
		TASK_CUSTOMER_ID = configProperties.getProperty("task_customer_id", "");
		TASK_SHARE_ID = configProperties.getProperty("task_share_id", "");
		TASK_REGISTERGIFT_ID = configProperties.getProperty("task_registergift_id", "");
		TASK_MESSAGEGROUP_ID = configProperties.getProperty("task_messagegroup_id", "");
		SHARE_SUCCESS = configProperties.getProperty("share_success", "");
		SHARE_FAILURE = configProperties.getProperty("share_failure", "");
		SELECT_FAILURE = configProperties.getProperty("select_failure", "");
		EXTMSG = configProperties.getProperty("extmsg", "");
		NORMAL_GROUP_ADD_FAILURE = configProperties.getProperty("normal_group_add_failure", "");
		NOT_FIND_BASEGROUP_NUM = configProperties.getProperty("not_find_basegroup_num", "");
		NOT_FIND_MEMBERGROUP = configProperties.getProperty("not_find_membergroup", "");
		NORMAL_MEMBERGROUP_ADD_FAILURE = configProperties.getProperty("normal_membergroup_add_failure", "");
		SEND_AUDIT_SUCCESS = configProperties.getProperty("send_audit_success", "");
		SEND_AUDIT_FAILURE = configProperties.getProperty("send_audit_failure", "");
		SEND_AUDIT_ALREADY = configProperties.getProperty("send_audit_already", "");
		MEMBERGROUP_EXIST = configProperties.getProperty("membergroup_exist", "");
		CODE_AUDIT_MEMBERGROUP_MSG = configProperties.getProperty("code_audit_membergroup_msg", "");
		UPDATER_NOTEQUALS_CREATER = configProperties.getProperty("updater_notequals_creater", "");
		BASEGROUP_ADD_LOG = configProperties.getProperty("basegroup_add_log", "");
		BASEGROUP_UPDATE_LOG = configProperties.getProperty("basegroup_update_log", "");
		BASEGROUP_DELETE_LOG = configProperties.getProperty("basegroup_delete_log", "");
		AUDITMEMBER_ISPASSED = configProperties.getProperty("auditmember_ispassed", "");
		AUDIT_SUCCESS = configProperties.getProperty("audit_success", "");
		AUDIT_FAILURE = configProperties.getProperty("audit_failure", "");
		APPLY_GROUP_PASS = configProperties.getProperty("apply_group_pass", "");
		APPLY_GROUP_REFUSE = configProperties.getProperty("apply_group_refuse", "");
		MEMBERGROUP_ADD_LOG = configProperties.getProperty("membergroup_add_log", "");
		MEMBERGROUP_DELETE_LOG = configProperties.getProperty("membergroup_delete_log", "");
		MEMBERGROUP_QUITGROUP_LOG = configProperties.getProperty("membergroup_quitgroup_log", "");
		CANNOT_QUITGROUP_CREATER_LOG = configProperties.getProperty("cannot_quitgroup_creater_log", "");
		QUITGROUP_SUCCESS = configProperties.getProperty("quitgroup_success", "");
		QUITGROUP_FAILURE = configProperties.getProperty("quitgroup_failure", "");
		MESSAGEGROUP_ADD_HOUSEREADILY = configProperties.getProperty("messagegroup_add_housereadily", "");
		MESSAGEGROUP_HOUSEREADILY = configProperties.getProperty("messagegroup_housereadily", "");
		MESSAGEGROUP_CUSTOMER = configProperties.getProperty("messagegroup_customer", "");
		MESSAGEGROUP_ADD_CUSTOMER = configProperties.getProperty("messagegroup_add_customer", "");
		MESSAGEGROUP_ADD = configProperties.getProperty("messagegroup_add", "");
		MESSAGEGROUP_FAILURE = configProperties.getProperty("messagegroup_failure", "");
		NOT_FIND_HOUSEREADILY = configProperties.getProperty("not_find_housereadily", "");
		NOT_FIND_CUSTOMER = configProperties.getProperty("not_find_customer", "");
		MESSAGEGROUP_EXIST = configProperties.getProperty("messagegroup_exist", "");
		NOT_FIND_MESSAGEGROUP = configProperties.getProperty("not_find_messagegroup", "");
		UPDATER_MESSAGEGROUP_CREATER = configProperties.getProperty("updater_messagegroup_creater", "");
		MESSAGEGROUP_DELETE_HOUSEREADILY = configProperties.getProperty("messagegroup_delete_housereadily", "");
		MESSAGEGROUP_DELETE_CUSTOMER = configProperties.getProperty("messagegroup_delete_customer", "");
		MESSAGEGROUP_DELETE = configProperties.getProperty("messagegroup_delete", "");
		ROOMHALLTOILET = configProperties.getProperty("room_hall_toilet", "");
		MOBILE_EXIST_REGISTER = configProperties.getProperty("mobile_exist_register", "");
		CZ = configProperties.getProperty("cz", "");
		CS = configProperties.getProperty("cs", "");
		YZ = configProperties.getProperty("yz", "");
		QZ = configProperties.getProperty("qz", "");
		QG = configProperties.getProperty("qg", "");
	}

	public static void init() {
	}

	public Configuration() {

	}

}
