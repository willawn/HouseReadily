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



public class CClientsHouse extends TastyEntity {

	private Integer id;
	private String innerNo;
	private String serialNo;
	private int userId;
	private int repeatType;
	private Date preSchedulerTime;
	private Date schedulerTime;
	
	private int status;
	
	private int successCount;
	private int failCount;
	
	private int deleted;
	private Date deleteTime;
	private Date insertTime;
	private Date updateTime;
	private Date startTime;
	private Date finishTime;
	
	private String title;
	private String statusRemark;
	private String websites;
	private String repeatTime;
	private String userName;
	
	private int stype;
	private int schedulerHistoryId;
	
	private int serverType;
	
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
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	public int getRepeatType() {
		return repeatType;
	}
	public void setRepeatType(int repeatType) {
		this.repeatType = repeatType;
	}
	public Date getSchedulerTime() {
		return schedulerTime;
	}
	public void setSchedulerTime(Date schedulerTime) {
		this.schedulerTime = schedulerTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSuccessCount() {
		return successCount;
	}
	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}
	public int getFailCount() {
		return failCount;
	}
	public void setFailCount(int failCount) {
		this.failCount = failCount;
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatusRemark() {
		return statusRemark;
	}
	public void setStatusRemark(String statusRemark) {
		this.statusRemark = statusRemark;
	}
	public String getWebsites() {
		return websites;
	}
	public void setWebsites(String websites) {
		this.websites = websites;
	}
	public String getRepeatTime() {
		return repeatTime;
	}
	public void setRepeatTime(String repeatTime) {
		this.repeatTime = repeatTime;
	}
	
	public String getStartTimeStr(){
		return DateHelper.dateToString(startTime);
	}
	
	public String getFinishTimeStr(){
		return DateHelper.dateToString(finishTime);
	}
	
	public String getInsertTimeStr(){
		return DateHelper.dateToString(insertTime);
	}
	
	public String getUpdateTimeStr(){
		return DateHelper.dateToString(updateTime);
	}
	
	public String getDeleteTimeStr(){
		return DateHelper.dateToString(deleteTime);
	}
	
	public String getSchedulerTimeStr(){
		return DateHelper.dateToString(schedulerTime);
	}
	
	public String getPreSchedulerTimeStr(){
		return DateHelper.dateToString(preSchedulerTime);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getStype() {
		return stype;
	}
	public void setStype(int stype) {
		this.stype = stype;
	}
	public Date getPreSchedulerTime() {
		return preSchedulerTime;
	}
	public void setPreSchedulerTime(Date preSchedulerTime) {
		this.preSchedulerTime = preSchedulerTime;
	}
	public int getSchedulerHistoryId() {
		return schedulerHistoryId;
	}
	public void setSchedulerHistoryId(int schedulerHistoryId) {
		this.schedulerHistoryId = schedulerHistoryId;
	}
	public int getServerType() {
		return serverType;
	}
	public void setServerType(int serverType) {
		this.serverType = serverType;
	}
	
	
	
}
