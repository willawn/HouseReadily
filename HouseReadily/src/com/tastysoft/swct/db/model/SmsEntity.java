package com.tastysoft.swct.db.model;

import java.io.Serializable;
/**
 * 
 * @author sana
 * @date 2012-06-16
 *
 */
public class SmsEntity implements Serializable {
         
	private String phoneNo;
	private String conent;
	private String sendTime;
	
	
	public SmsEntity() {
	}
	public SmsEntity(String phoneNo, String conent, String sendTime) {
		this.phoneNo = phoneNo;
		this.conent = conent;
		this.sendTime = sendTime;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getConent() {
		return conent;
	}
	public void setConent(String conent) {
		this.conent = conent;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	
	
}
