package com.huzhiyi.housereadily.entity;

import java.sql.Timestamp;

import com.huzhiyi.housereadily.entity.base.AbstractHouseOwner;

/**
 * HouseOwner entity. @author MyEclipse Persistence Tools
 */
public class HouseOwner extends AbstractHouseOwner implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public HouseOwner() {
	}

	/** full constructor */
	public HouseOwner(Integer isMain, Integer houseReadilyId, Integer customerId, Integer creater, Timestamp createTime) {
		super(isMain, houseReadilyId, customerId, creater, createTime);
	}

	private String houseReadilyName;
	private String customerName;
	private Integer gender;
	private String phone;
	private String mobile;

	public String getHouseReadilyName() {
		return houseReadilyName;
	}

	public void setHouseReadilyName(String houseReadilyName) {
		this.houseReadilyName = houseReadilyName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
