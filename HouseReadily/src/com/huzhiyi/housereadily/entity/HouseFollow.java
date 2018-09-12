package com.huzhiyi.housereadily.entity;

import java.sql.Timestamp;

import com.huzhiyi.housereadily.entity.base.AbstractHouseFollow;

/**
 * HouseFollow entity. @author MyEclipse Persistence Tools
 */
public class HouseFollow extends AbstractHouseFollow implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public HouseFollow() {
	}

	/** full constructor */
	public HouseFollow(Integer houseReadilyId, Integer customerId, Integer mode, String description, Integer creater, Timestamp createTime) {
		super(houseReadilyId, customerId, mode, description, creater, createTime);
	}

	private Integer projectId;
	private String projectName;
	private String title;
	private String building;
	private String houseNum;
	private Integer ctype;
	private String customerName;
	private Integer gender;
	private String phone;
	private String mobile;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public Integer getCtype() {
		return ctype;
	}

	public void setCtype(Integer ctype) {
		this.ctype = ctype;
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
