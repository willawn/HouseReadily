package com.huzhiyi.housereadily.model;



import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.tastysoft.swct.db.model.TastyEntity;
import com.tastysoft.swct.util.DateHelper;

public class CCustomersSms extends TastyEntity{
	
	private Integer id;
	private String content;
	private String mobiles;
	private int status;
	private Date insertTime;
	private int userId;
	private String userName;
	private int smsCount;
	private int deleted;
	private Date deleteTime;
	private int ctype; 
	

	public int getCtype() {
		return ctype;
	}
	public void setCtype(int ctype) {
		this.ctype = ctype;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMobiles() {
		return mobiles;
	}
	public void setMobiles(String mobiles) {
		this.mobiles = mobiles;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getInsertTimeStr(){
		return DateHelper.dateToString(insertTime);
	}
	
	public String getContentStr(){
		if(this.content!=null&&this.content.length()>0){
			int maxLen = 28 ;
			if(this.content.length()>maxLen){
				return this.content.substring(0,maxLen-1)+"...";
			}
		}
		return this.content;
	}
	
	public String getMobileStr(){
		if(this.mobiles!=null&&this.mobiles.length()>0){
			int maxLen = 24 ;
			if(this.mobiles.length()>maxLen){
				return this.mobiles.substring(0,maxLen-1)+"...";
			}
		}
		return this.mobiles;
	}
	
	public String getMobileStr2(){
		if(this.mobiles!=null&&this.mobiles.length()>0){
			return StringUtils.replace(this.mobiles, ",", "\r\n");
		}
		return this.mobiles;
	}
	
	public int getSmsCount() {
		return smsCount;
	}
	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	
	
}
