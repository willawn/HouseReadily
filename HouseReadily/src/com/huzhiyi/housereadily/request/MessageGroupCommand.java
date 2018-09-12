package com.huzhiyi.housereadily.request;

import java.sql.Timestamp;

public class MessageGroupCommand extends BaseCommand {
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
	private String share;
	private Integer creater;
	private Integer pageNo;
	private Integer pageSize;
	
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getShare() {
		return share;
	}
	public void setShare(String share) {
		this.share = share;
	}
	public Integer getCreater() {
		return creater;
	}
	public void setCreater(Integer creater) {
		this.creater = creater;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
