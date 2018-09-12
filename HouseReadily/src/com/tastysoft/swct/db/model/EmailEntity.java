package com.tastysoft.swct.db.model;

import java.io.Serializable;
/**
 * 
 * @author sana
 *
 */
public class EmailEntity  implements Serializable{

	private String email;  // 邮箱地址
	private String sendTime;  // 发送时间
	
	
	public EmailEntity() {
	}
	public EmailEntity(String email, String sendTime) {
		this.email = email;
		this.sendTime = sendTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	
	
}
