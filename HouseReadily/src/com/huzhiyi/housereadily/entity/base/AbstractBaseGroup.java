package com.huzhiyi.housereadily.entity.base;

import java.sql.Timestamp;

/**
 * AbstractBaseGroup entity provides the base persistence definition of the
 * BaseGroup entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBaseGroup implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer level;
	private String groupNum;
	private String groupName;
	private String acement;
	private String description;
	private Integer memberCount;
	private Integer houseReadilyCount;
	private Integer customerCount;
	private Integer cityCode;
	private Integer bigAreaCode;
	private Integer smallAreaCode;
	private Timestamp syncTime;
	private String version;
	private Integer isDelete;
	private Integer creater;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public AbstractBaseGroup() {
	}

	/** minimal constructor */
	public AbstractBaseGroup(Integer level, String groupNum, String groupName, Integer cityCode, Integer bigAreaCode,
			Integer smallAreaCode, Timestamp syncTime, String version, Integer isDelete, Integer creater, Timestamp createTime) {
		this.level = level;
		this.groupNum = groupNum;
		this.groupName = groupName;
		this.cityCode = cityCode;
		this.bigAreaCode = bigAreaCode;
		this.smallAreaCode = smallAreaCode;
		this.syncTime = syncTime;
		this.version = version;
		this.isDelete = isDelete;
		this.creater = creater;
		this.createTime = createTime;
	}

	/** full constructor */
	public AbstractBaseGroup(Integer level, String groupNum, String groupName, String acement, String description, Integer cityCode,
			Integer bigAreaCode, Integer smallAreaCode, Timestamp syncTime, String version, Integer isDelete, Integer creater,
			Timestamp createTime) {
		this.level = level;
		this.groupNum = groupNum;
		this.groupName = groupName;
		this.acement = acement;
		this.description = description;
		this.cityCode = cityCode;
		this.bigAreaCode = bigAreaCode;
		this.smallAreaCode = smallAreaCode;
		this.syncTime = syncTime;
		this.version = version;
		this.isDelete = isDelete;
		this.creater = creater;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getGroupNum() {
		return this.groupNum;
	}

	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getAcement() {
		return this.acement;
	}

	public void setAcement(String acement) {
		this.acement = acement;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
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

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public Integer getBigAreaCode() {
		return this.bigAreaCode;
	}

	public void setBigAreaCode(Integer bigAreaCode) {
		this.bigAreaCode = bigAreaCode;
	}

	public Integer getSmallAreaCode() {
		return this.smallAreaCode;
	}

	public void setSmallAreaCode(Integer smallAreaCode) {
		this.smallAreaCode = smallAreaCode;
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

}