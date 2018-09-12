package com.huzhiyi.utils;



public class ThreadSendEmail implements Runnable {

	private String toEmail; 
	private String title; 
	private String content; 
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public ThreadSendEmail(String toEmail,String title, String content) {
		super();
		this.title = title;
		this.content = content;
		this.toEmail=toEmail; 
	}
	@Override
	public void run() {
		//发送Email
			SendEmailHelper.sendEmail(toEmail, title, content);
	}

}
