package com.huzhiyi.housereadily.entity.base;

import java.sql.Timestamp;

/**
 * AbstractMemberGroup entity provides the base persistence definition of the
 * MemberGroup entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMemberGroup implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer baseGroupId;
	private Integer roleType;
	private Integer userId;
	private String userName;
	private String realName;
	private Timestamp syncTime;
	private String version;
	private Integer isDelete;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public AbstractMemberGroup() {
	}

	/** minimal constructor */
	public AbstractMemberGroup(Integer baseGroupId, Integer roleType, Integer userId, Timestamp syncTime, String version, Integer isDelete,
			Timestamp createTime) {
		this.baseGroupId = baseGroupId;
		this.roleType = roleType;
		this.userId = userId;
		this.syncTime = syncTime;
		this.version = version;
		this.isDelete = isDelete;
		this.createTime = createTime;
	}

	/** full constructor */
	public AbstractMemberGroup(Integer baseGroupId, Integer roleType, Integer userId, String userName, String realName, Timestamp syncTime, String version,
			Integer isDelete, Timestamp createTime) {
		this.baseGroupId = baseGroupId;
		this.roleType = roleType;
		this.userId = userId;
		this.userName = userName;
		this.realName = realName;
		this.syncTime = syncTime;
		this.version = version;
		this.isDelete = isDelete;
		this.createTime = createTime;
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

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}