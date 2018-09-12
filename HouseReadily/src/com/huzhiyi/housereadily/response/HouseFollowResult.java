package com.huzhiyi.housereadily.response;

import java.sql.Timestamp;

public class HouseFollowResult extends StatusResult {

	private Integer id;
	private Integer houseReadilyId;
	private Integer customerId;
	private Integer mode;
	private String description;
	private Integer creater;
	private Timestamp createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHouseReadilyId() {
		return houseReadilyId;
	}

	public void setHouseReadilyId(Integer houseReadilyId) {
		this.houseReadilyId = houseReadilyId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getMode() {
		return mode;
	}

	public void setMode(Integer mode) {
		this.mode = mode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
}
