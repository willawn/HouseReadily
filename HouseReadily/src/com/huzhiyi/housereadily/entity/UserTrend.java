package com.huzhiyi.housereadily.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserTrend implements Serializable {

	private Timestamp createTime;
	private Integer activeCount;
	private Integer loginCount;
	private Integer registerCount;
	private Integer houseReadilyCount;
	private Integer customerCount;
	private Integer houseFollowCount;

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getActiveCount() {
		return activeCount;
	}

	public void setActiveCount(Integer activeCount) {
		this.activeCount = activeCount;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Integer getRegisterCount() {
		return registerCount;
	}

	public void setRegisterCount(Integer registerCount) {
		this.registerCount = registerCount;
	}

	public Integer getHouseReadilyCount() {
		return houseReadilyCount;
	}

	public void setHouseReadilyCount(Integer houseReadilyCount) {
		this.houseReadilyCount = houseReadilyCount;
	}

	public Integer getCustomerCount() {
		return customerCount;
	}

	public void setCustomerCount(Integer customerCount) {
		this.customerCount = customerCount;
	}

	public Integer getHouseFollowCount() {
		return houseFollowCount;
	}

	public void setHouseFollowCount(Integer houseFollowCount) {
		this.houseFollowCount = houseFollowCount;
	}
}
