package com.huzhiyi.housereadily.model;

import java.util.Date;

import com.tastysoft.swct.db.model.TastyEntity;

public class CUsersWebSites extends TastyEntity{

	private int id; 
	private int userId; 
	private String userName;
	private int webSitesNo; 
	private int status; 
	private int isBanStatus; 
	private Date isBanTime; 
	private Date insertTime; 
	private Date updateTime;

	public int getWebSitesNo() {
		return webSitesNo;
	}
	public void setWebSitesNo(int webSitesNo) {
		this.webSitesNo = webSitesNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIsBanStatus() {
		return isBanStatus;
	}
	public void setIsBanStatus(int isBanStatus) {
		this.isBanStatus = isBanStatus;
	}
	public Date getIsBanTime() {
		return isBanTime;
	}
	public void setIsBanTime(Date isBanTime) {
		this.isBanTime = isBanTime;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	} 
	
	
}
