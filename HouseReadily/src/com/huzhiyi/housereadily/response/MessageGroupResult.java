package com.huzhiyi.housereadily.response;

import java.sql.Timestamp;

import org.json.JSONObject;

import com.huzhiyi.housereadily.entity.HouseReadily;

public class MessageGroupResult extends StatusResult {
	private Integer id;
	private Integer baseGroupId;
	private String title;
	private String description;
	private Integer mtype;
	private Integer source;
	private Integer sctype;
	private Double ownerRate;
	private Double otherRate;
	private Double brokerage;
	private String share;
	private String remarks;
	private Timestamp syncTime;
	private String version;
	private Integer isDelete;
	private Integer creater;
	private Timestamp createTime;
	private String createrName;
	private String createrRealName;
	private String mobile;
	private String baseGroupName;
	private String avatar;
	private Integer growing;
	private JSONObject houseReadilys;
	private JSONObject customers;
	private JSONObject btAttachments;
	private JSONObject snAttachments;
	private JSONObject fxAttachments;
	private JSONObject xqAttachments;
	public JSONObject getBtAttachments() {
		return btAttachments;
	}
	public void setBtAttachments(JSONObject btAttachments) {
		this.btAttachments = btAttachments;
	}
	public JSONObject getSnAttachments() {
		return snAttachments;
	}
	public void setSnAttachments(JSONObject snAttachments) {
		this.snAttachments = snAttachments;
	}
	public JSONObject getFxAttachments() {
		return fxAttachments;
	}
	public void setFxAttachments(JSONObject fxAttachments) {
		this.fxAttachments = fxAttachments;
	}
	public JSONObject getXqAttachments() {
		return xqAttachments;
	}
	public void setXqAttachments(JSONObject xqAttachments) {
		this.xqAttachments = xqAttachments;
	}
	public JSONObject getHouseReadilys() {
		return houseReadilys;
	}
	public void setHouseReadilys(JSONObject houseReadilys) {
		this.houseReadilys = houseReadilys;
	}
	public JSONObject getCustomers() {
		return customers;
	}
	public void setCustomers(JSONObject customers) {
		this.customers = customers;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Integer getGrowing() {
		return growing;
	}
	public void setGrowing(Integer growing) {
		this.growing = growing;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBaseGroupId() {
		return baseGroupId;
	}
	public void setBaseGroupId(Integer baseGroupId) {
		this.baseGroupId = baseGroupId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getMtype() {
		return mtype;
	}
	public void setMtype(Integer mtype) {
		this.mtype = mtype;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public Integer getSctype() {
		return sctype;
	}
	public void setSctype(Integer sctype) {
		this.sctype = sctype;
	}
	public Double getOwnerRate() {
		return ownerRate;
	}
	public void setOwnerRate(Double ownerRate) {
		this.ownerRate = ownerRate;
	}
	public Double getOtherRate() {
		return otherRate;
	}
	public void setOtherRate(Double otherRate) {
		this.otherRate = otherRate;
	}
	public Double getBrokerage() {
		return brokerage;
	}
	public void setBrokerage(Double brokerage) {
		this.brokerage = brokerage;
	}
	public String getShare() {
		return share;
	}
	public void setShare(String share) {
		this.share = share;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Timestamp getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(Timestamp syncTime) {
		this.syncTime = syncTime;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getCreater() {
		return creater;
	}
	public void setCreater(Integer creater) {
		this.creater = creater;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	public String getCreaterRealName() {
		return createrRealName;
	}
	public void setCreaterRealName(String createrRealName) {
		this.createrRealName = createrRealName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBaseGroupName() {
		return baseGroupName;
	}
	public void setBaseGroupName(String baseGroupName) {
		this.baseGroupName = baseGroupName;
	}
	
}
