package com.huzhiyi.housereadily.model;

import java.util.Date;

/**
 * 华南
 * @author LanChaoQiang
 *
 */
public class CHouseHistoryViewIdHn extends CHouseHistoryViewId {

	private Integer id;
	private String innerNo;
	private Integer serialNo;
	private String viewUrl;
	private String viewId;
	private String viewExtend;
	private Integer UserId;
	private Date insertTime;
	private Date updateTime;
	private Integer errorCode; 
	private String description; 
	private String PublishRemark; 
	private Integer autoDeleted;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInnerNo() {
		return innerNo;
	}
	public void setInnerNo(String innerNo) {
		this.innerNo = innerNo;
	}
	public Integer getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}
	public String getViewUrl() {
		return viewUrl;
	}
	public void setViewUrl(String viewUrl) {
		this.viewUrl = viewUrl;
	}
	public String getViewId() {
		return viewId;
	}
	public void setViewId(String viewId) {
		this.viewId = viewId;
	}
	public String getViewExtend() {
		return viewExtend;
	}
	public void setViewExtend(String viewExtend) {
		this.viewExtend = viewExtend;
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
	public String getPublishRemark() {
		return PublishRemark;
	}
	public void setPublishRemark(String publishRemark) {
		PublishRemark = publishRemark;
	}
	public Integer getAutoDeleted() {
		return autoDeleted;
	}
	public void setAutoDeleted(Integer autoDeleted) {
		this.autoDeleted = autoDeleted;
	}

}
