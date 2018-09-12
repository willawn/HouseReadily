package com.huzhiyi.housereadily.model;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.tastysoft.swct.db.model.TastyEntity;
import com.tastysoft.swct.util.DateHelper;



public class CHouseHistoryViewId extends TastyEntity {

	private Integer id;
	private Integer serialNo;
	private String innerNo;
	private String viewId;
	private String viewUrl;
	private String ViewExtend;
	private Integer UserId;
	private Date insertTime;
	private Date updateTime;
	private Integer errorCode; 
	private String description; 
	private String PublishRemark; 
	private Integer autoDeleted; 
	
	
	public Integer getAutoDeleted() {
		return autoDeleted;
	}

	public void setAutoDeleted(Integer autoDeleted) {
		this.autoDeleted = autoDeleted;
	}

	public String getPublishRemark() {
		return PublishRemark;
	}

	public void setPublishRemark(String publishRemark) {
		PublishRemark = publishRemark;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return this.id;
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

	public String getInnerNo() {
		return innerNo;
	}

	public void setInnerNo(String innerNo) {
		this.innerNo = innerNo;
	}

	public String getViewId() {
		return viewId;
	}

	public void setViewId(String viewId) {
		this.viewId = viewId;
	}

	public String getViewUrl() {
		if(viewUrl!=null&&viewUrl.length()>0&&!viewUrl.toLowerCase().startsWith("http://")){
			viewUrl = "http://"+viewUrl;
		}
		return viewUrl;
	}

	public void setViewUrl(String viewUrl) {
		this.viewUrl = viewUrl;
	}

	public String getViewExtend() {
		return ViewExtend;
	}

	public void setViewExtend(String viewExtend) {
		ViewExtend = viewExtend;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
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
	
	public String getInsertTimeStr(){
		return DateHelper.dateToString(insertTime);
	}
	
	public String getUpdateTimeStr(){
		return DateHelper.dateToString(updateTime);
	}
	

}
