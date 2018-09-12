package com.huzhiyi.housereadily.entity.base;

import java.sql.Timestamp;

/**
 * AbstractMessageGroup entity provides the base persistence definition
 * of the MessageGroup entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMessageGroup implements
		java.io.Serializable {

	// Fields

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
	private String remarks;
	private Timestamp syncTime;
	private String version;
	private Integer isDelete;
	private Integer creater;
	private Timestamp createTime;
	private String share;

	// Constructors

	/** default constructor */
	public AbstractMessageGroup() {
	}

	/** minimal constructor */
	public AbstractMessageGroup(Integer baseGroupId,
			String description, Integer mtype, Timestamp syncTime,
			String version, Integer isDelete, Integer creater,
			Timestamp createTime) {
		this.baseGroupId = baseGroupId;
		this.description = description;
		this.mtype = mtype;
		this.syncTime = syncTime;
		this.version = version;
		this.isDelete = isDelete;
		this.creater = creater;
		this.createTime = createTime;
	}

	/** full constructor */
	public AbstractMessageGroup(Integer baseGroupId, String title,
			String description, Integer mtype, Integer source, Integer sctype,
			Double ownerRate, Double otherRate, Timestamp syncTime,
			String version, Integer isDelete, Integer creater,
			Timestamp createTime,Double brokerage, String remarks, String share) {
		this.baseGroupId = baseGroupId;
		this.title = title;
		this.description = description;
		this.mtype = mtype;
		this.source = source;
		this.sctype = sctype;
		this.ownerRate = ownerRate;
		this.otherRate = otherRate;
		this.syncTime = syncTime;
		this.version = version;
		this.isDelete = isDelete;
		this.creater = creater;
		this.createTime = createTime;
		this.brokerage = brokerage;
		this.remarks = remarks;
		this.share = share;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBaseGroupId() {
		return this.baseGroupId;
	}

	public void setBaseGroupId(Integer baseGroupId) {
		this.baseGroupId = baseGroupId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMtype() {
		return this.mtype;
	}

	public void setMtype(Integer mtype) {
		this.mtype = mtype;
	}

	public Integer getSource() {
		return this.source;
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
		return this.ownerRate;
	}

	public void setOwnerRate(Double ownerRate) {
		this.ownerRate = ownerRate;
	}

	public Double getOtherRate() {
		return this.otherRate;
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
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Timestamp getSyncTime() {
		return this.syncTime;
	}

	public void setSyncTime(Timestamp syncTime) {
		this.syncTime = syncTime;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getCreater() {
		return this.creater;
	}

	public void setCreater(Integer creater) {
		this.creater = creater;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getShare() {
		return this.share;
	}

	public void setShare(String share) {
		this.share = share;
	}

}