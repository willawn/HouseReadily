package com.huzhiyi.postserver.client;

import java.util.Date;

import com.tastysoft.swct.util.MD5; /*import com.huzhiyi.postserver.scheduler.SchedulerRmiServer;*/
import com.huzhiyi.utils.ContextHelper;

public class SchedulerContext {
	public static Date startTime;
	public static int poolSize = 2;
	public static int schedulerType = 1;
	public static int useOcr = 1;
	public static int schedulerCount = 0;
	public static String schedulerConfFile = "/Scheduler_Conf.properties";
	private static String verifyOcrPath = "http://222.73.241.6:8787/ocr";
	public static int schedulerSingleRefreshCount = 50;
	public static float schedulerRefreshCountFactor = 0.7f;
	public static boolean SchdulerLog = false;

	private static String schedulerServiceUrl = "";
	public static boolean schedulerServiceOn = true;
	public static boolean schedulerServiceStatus = true;
	public static int schedulerServiceRmi = 0;

	public static boolean rmiRet = true;

	public static synchronized int getSchedulerCount() {
		if (schedulerCount > 1000) {
			schedulerCount = 0;
		}
		schedulerCount++;
		return schedulerCount;
	}

	public static int getSchedulerMaxRefreshCount() {
		int totalTaskCount = 0; // SchedulerRmiServer.validRmiCount*schedulerSingleRefreshCount;
		return totalTaskCount;
	}

	public static int getSchedulerRefreshCount_() {
		int totalTaskCount = getSchedulerMaxRefreshCount();
		int needTaskCount = 0; // totalTaskCount-SchedulerRmiServer.validRmiTaskCount;
		return needTaskCount;
	}

	public static int getSchedulerRefreshCount() {
		int limitCount = getSchedulerRefreshCount_();
		if (limitCount <= 0)
			return 0;
		limitCount = (int) (limitCount * schedulerRefreshCountFactor);
		return limitCount;
	}

	static {
		startTime = new Date();
	}

	public static void init() {

	};

	public static String PropertiesString() {
		StringBuilder sb = new StringBuilder();
		/*
		 * sb.append("schedulerType="+schedulerType+"\r\n");
		 * sb.append("poolSize="+poolSize+"\r\n");
		 * sb.append("useOcr="+useOcr+"\r\n");
		 * sb.append("schedulerSingleRefreshCount="
		 * +schedulerSingleRefreshCount+"\r\n");
		 * sb.append("schedulerRefreshCountFactor="
		 * +schedulerRefreshCountFactor+"\r\n");
		 */
		sb.append("schedulerServiceUrl=" + schedulerServiceUrl + "\r\n");
		return sb.toString();
	}

	public static String getVerifyOcrPath() {
		if (useOcr == 1) {
			return verifyOcrPath;
		}
		return "";
	}

	public static String getSchedulerServiceUrl() {
		return schedulerServiceUrl;
	}

	public static String buildSchedulerServiceUrl(int userId, String dataType, boolean sessionDebug, int taskType) {
		String sVerify = ContextHelper.md5Key + userId + dataType;
		String md5_ = MD5.getMD5(sVerify.getBytes());
		return getSchedulerServiceUrl() + "/data.do?dataVerify=" + md5_ + "&dataType=" + dataType + "&userId=" + userId + "&sessionDebug="
				+ sessionDebug + "&serverType=1&taskType=" + taskType;
	}

	public static String buildSchedulerServiceUrl(String md5Key, int userId, String dataType) {
		String sVerify = ContextHelper.md5Key + userId + dataType;
		String md5_ = MD5.getMD5(sVerify.getBytes());
		return getSchedulerServiceUrl() + "/data.do?dataVerify=" + md5_ + "&dataType=" + dataType + "&userId=" + userId
				+ "&serverType=1&md5Key=" + md5Key;
	}

	public static void setSchedulerServiceUrl(String schedulerServiceUrl) {
		SchedulerContext.schedulerServiceUrl = schedulerServiceUrl;
	}

}
