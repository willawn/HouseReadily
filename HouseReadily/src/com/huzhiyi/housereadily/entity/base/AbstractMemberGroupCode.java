package com.huzhiyi.housereadily.entity.base;

import java.sql.Timestamp;

/**
 * AbstractMemberGroupCode entity provides the base persistence definition of
 * the MemberGroupCode entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMemberGroupCode implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer auditMemberGroupId;
	private Integer baseGroupId;
	private String groupNum;
	private String groupName;
	private Integer userId;
	private String userName;
	private String description;
	private String mobile;
	private Integer auditer;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public AbstractMemberGroupCode() {
	}

	/** minimal constructor */
	public AbstractMemberGroupCode(Integer auditMemberGroupId, Integer baseGroupId, String groupNum, String groupName, Integer userId,
			String userName, String mobile, Integer auditer, Timestamp createTime) {
		this.auditMemberGroupId = auditMemberGroupId;
		this.baseGroupId = baseGroupId;
		this.groupNum = groupNum;
		this.groupName = groupName;
		this.userId = userId;
		this.userName = userName;
		this.mobile = mobile;
		this.auditer = auditer;
		this.createTime = createTime;
	}

	/** full constructor */
	public AbstractMemberGroupCode(Integer auditMemberGroupId, Integer baseGroupId, String groupNum, String groupName, Integer userId,
			String userName, String description, String mobile, Integer auditer, Timestamp createTime) {
		this.auditMemberGroupId = auditMemberGroupId;
		this.baseGroupId = baseGroupId;
		this.groupNum = groupNum;
		this.groupName = groupName;
		this.userId = userId;
		this.userName = userName;
		this.description = description;
		this.mobile = mobile;
		this.auditer = auditer;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAuditMemberGroupId() {
		return this.auditMemberGroupId;
	}

	public void setAuditMemberGroupId(Integer auditMemberGroupId) {
		this.auditMemberGroupId = auditMemberGroupId;
	}

	public Integer getBaseGroupId() {
		return this.baseGroupId;
	}

	public void setBaseGroupId(Integer baseGroupId) {
		this.baseGroupId = baseGroupId;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getAuditer() {
		return this.auditer;
	}

	public void setAuditer(Integer auditer) {
		this.auditer = auditer;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}