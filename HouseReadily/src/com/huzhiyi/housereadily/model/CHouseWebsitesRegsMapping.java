package com.huzhiyi.housereadily.model;

import com.tastysoft.swct.db.model.TastyEntity;

public class CHouseWebsitesRegsMapping extends TastyEntity {
	 private Integer id;
	 private Integer serialNo;
	 private Integer userId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	} 
}
