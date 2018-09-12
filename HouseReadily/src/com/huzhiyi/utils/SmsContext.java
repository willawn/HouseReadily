package com.huzhiyi.utils;

import org.apache.commons.httpclient.methods.PostMethod;

import cn.emay.sdk.client.api.Client;

public class SmsContext {
	public static String softwareSerialNo="3SDK-EMY-0130-NBSSS";//软件序列号,请通过亿美销售人员获取
	public static String key="149527";//序列号首次激活时自己设定
	public static String password="526271";// 密码,请通过亿美销售人员获取
	public static Client client=null;
	
	
	/*public static String ECODE="365365";
	public static String userName="365365";
	public static String password="123456";
	public static String smsUrl="http://www.020sms.com/?ECODE="+ECODE
	+"&USERNAME="+userName+"&PASSWORD="+password+"&EXTNO=&MOBILE={mobiles}&CONTENT={contents}&SEQ=1000";
	*/
	public static String sendSms(String mobiles,String contents){
		/*try {
			contents = URLEncoder.encode(contents, "UTF-8");
		} catch (UnsupportedEncodingException e) {
		
		}
		String url=StringUtils.replace(smsUrl, "{mobiles}", mobiles);
		url = StringUtils.replace(url, "{contents}", contents);
		System.out.println(url);
		String result = HtmlUtils.getHtml(url);
		return result;*/
		return null; 
	}
	
	public static String sendSmsPost(String mobiles,String contents){
	
	/*	String url=StringUtils.replace(smsUrl, "{mobiles}", mobiles);
		url = StringUtils.replace(url, "{contents}", contents);
		System.out.println(url);
		Map map = new HashMap();
		map.put("ECODE", ECODE);
		map.put("USERNAME", userName);
		map.put("PASSWORD", password);
		map.put("SEQ", "1000");
		map.put("MOBILE", mobiles);
		map.put("CONTENT", contents);
		map.put("EXTNO", "");
		String result =  HtmlUtils.doPost("http://www.020sms.com", map); 

		return result;*/
		return null; 
	}
	
	public static String sendSmsPost2(String mobiles,String contents){/*
		
		String url = "http://www.020sms.com";
		PostMethod postMethod = new UTF8PostMethod(url);
		//填入各个表单域的值
		NameValuePair[] data = {
		new NameValuePair("ECODE", ECODE),
		new NameValuePair("USERNAME", userName),
		new NameValuePair("PASSWORD", password),
		new NameValuePair("SEQ", "1000"),
		new NameValuePair("MOBILE", mobiles),
		new NameValuePair("CONTENT", contents),
		new NameValuePair("EXTNO", ""),
		};
		//将表单的值放入postMethod中
		postMethod.setRequestBody(data);
		//执行postMethod
		HttpClient httpClient = new HttpClient();
		String response = null; 
		 try { 
			 httpClient.executeMethod(postMethod); 
             if (postMethod.getStatusCode() == HttpStatus.SC_OK) { 
                     response = postMethod.getResponseBodyAsString(); 
             } 
     } catch (IOException e) { 
     } finally { 
    	 postMethod.releaseConnection(); 
     } 

		return response;
	*/
		return null; 
		}
	
	
	public static String newSendSmsPost(String [] mobiles,String contents){
		int result = -1 ; 
		try {
			if(client==null){
				client = SDKClient.getClient();
			}
			client.registEx(password); 
			result = client.sendSMS(mobiles, contents, "145", 5);
			result = result ==0?result+1:result; 
			System.out.println("余额："+client.getBalance());
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	    
	  return String.valueOf(result);
	} 
	
	public static String showError(int result){
		String info = ""; 
		switch (result) {
		case 0:
			info = "发送成功!";
			break;
		case 17:
			info = "发送信息失败!";
			break;
		case 101:
			info = "客户端网络故障!";
			break;
		case 307:
			info = "目标电话号码不符合规则，电话号码必须是以0、1开头!";
			break;
		case 997:
			info = "平台返回找不到超时的短信，该信息是否成功无法确定!";
			break;
		case 998:
			info = "由于客户端网络问题导致信息发送超时，该信息是否成功下发无法确定!";
			break;
		default:
			info = "联系客服!";
			break;
		}
		return info; 
	}
	
	//Inner class for UTF-8 support
	public static class UTF8PostMethod extends PostMethod{
	public UTF8PostMethod(String url){
	super(url);
	}
	@Override
	public String getRequestCharSet() {
	//return super.getRequestCharSet();
	return "GB2312";
	}

	}
}
