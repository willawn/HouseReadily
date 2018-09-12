package com.huzhiyi.housereadily.model;

import java.util.Date;

import com.tastysoft.swct.db.model.TastyEntity;

public class CHouseConfirm extends TastyEntity {
	
	
	public CHouseConfirm() {
	}
	public CHouseConfirm(int userId, int houseId, Date insertTime,
			Date confirmTime, String costomerts, String remark,String costMoble) {
		super();
		this.userId = userId;
		this.houseId = houseId;
		this.insertTime = insertTime;
		this.confirmTime = confirmTime;
		this.costomerts = costomerts;
		this.remark = remark;
		this.costMoble = costMoble; 
	}
	private int id ; 
	private int userId; 
	private int houseId; 
	private Date insertTime; 
	private Date confirmTime; 
	private String costomerts; 
	private String remark;
	private String costMoble; 
	
	public String getCostMoble() {
		return costMoble;
	}
	public void setCostMoble(String costMoble) {
		this.costMoble = costMoble;
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
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Date getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}
	public String getCostomerts() {
		return costomerts;
	}
	public void setCostomerts(String costomerts) {
		this.costomerts = costomerts;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	} 
	
	
	
}
