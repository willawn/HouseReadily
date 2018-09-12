package com.huzhiyi.utils;

public class ParamHelper {
	
	private static String localParamPath="D:/training/BP/source/source_param_server_ok/";
	
	private static String localVerifySavePath="D:/training/zushou365/.metadata/.plugins/com.genuitec.eclipse.easie.tomcat.myeclipse/tomcat/webapps/HousePostServer/verify/";
	
	private static String localWebHost="http://localhost:8086/HousePostServer/verify/";
	
	private static String remoteParamPath="data/web/huzhiyi/rest/HousePostServer/source_param_server/";
	
	private static String remoteVerifySavePath="/"+"data/web/huzhiyi/rest/HousePostServer/verify/";
	
	private static String remoteWebHost="http://api.zushou365.com/HousePostServer/verify/";
	
	private static String localHost="localhost";
	
	private static String remoteHost="119.147.24.204";
	
	private static int port=1199;
	
	private static int socketPort = 1299;
	
	public static String getParamPath(){
		if(getHost().equals("127.0.0.1")||"localhost".equals(getHost()))
			return localParamPath;
		else
			return remoteParamPath;
	}
	
	public static String getHost(){
		return localHost;
		//return remoteHost;
	}
	
	public static int getPort(){
		return port;
	}

	public static int getSocketPort() {
		return socketPort;
	}

	public static void setSocketPort(int socketPort) {
		ParamHelper.socketPort = socketPort;
	}
	
	public static String getVerifySavePath(){
		if(getHost().equals("127.0.0.1")||"localhost".equals(getHost()))
			return localVerifySavePath;
		else
			return remoteVerifySavePath;
	}
	
	public static String getWebHost(){
		if(getHost().equals("127.0.0.1")||"localhost".equals(getHost()))
			return localWebHost;
		else
			return remoteWebHost;
	}
	
}
