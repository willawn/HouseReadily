package com.huzhiyi.utils;


import cn.emay.sdk.client.api.Client;


public class SDKClient {
	private SDKClient(){
	}
	
	private static Client client=null;
	
	public synchronized static Client getClient(String softwareSerialNo,String key){
		if(client==null){
			try {
				client=new Client(softwareSerialNo,key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}
	
	public synchronized static Client getClient(){
		//ResourceBundle bundle=PropertyResourceBundle.getBundle("config");
		if(client==null){
			try {
				client=new Client(SmsContext.softwareSerialNo,SmsContext.key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}
}
