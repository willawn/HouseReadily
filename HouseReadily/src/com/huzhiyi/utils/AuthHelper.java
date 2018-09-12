package com.huzhiyi.utils;

import com.tastysoft.swct.util.MD5;


public class AuthHelper {
	
	public static String md5Key="CopyRight 2012 Huzhiyi";
	
	public static String buildMd5(int userId){
		String sVerify = md5Key+userId;
		sVerify = MD5.getMD5(sVerify.getBytes());
		return sVerify;
	}
	
	public static boolean checkMd5(String md5,int userId){
		String sVerify = md5Key+userId;
		String md5_ = MD5.getMD5(sVerify.getBytes());
		if(md5!=null&&md5_.equals(md5)){
			return true;
		}
		return false;
	}
}
