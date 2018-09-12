package com.huzhiyi.housereadily.model;

import java.util.Date;

import com.tastysoft.swct.db.model.TastyEntity;

public class CHouseProTemplate extends TastyEntity {
	private int id;
	private String title;
	private int stype;
	private int bulidType;
	private int proType;
	private String feature;
	private Date insertTime;
	private String context;
	private int deleted;
	private Date deleteTime;
	private int enable;
	private int userCount;
	
	
	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStype() {
		return stype;
	}

	public void setStype(int stype) {
		this.stype = stype;
	}

	public int getBulidType() {
		return bulidType;
	}

	public void setBulidType(int bulidType) {
		this.bulidType = bulidType;
	}

	public int getProType() {
		return proType;
	}

	public void setProType(int proType) {
		this.proType = proType;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}
