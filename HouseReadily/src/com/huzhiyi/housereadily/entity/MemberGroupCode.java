package com.huzhiyi.housereadily.entity;

import java.sql.Timestamp;

import com.huzhiyi.housereadily.entity.base.AbstractMemberGroupCode;

/**
 * MemberGroupCode entity. @author MyEclipse Persistence Tools
 */
public class MemberGroupCode extends AbstractMemberGroupCode implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MemberGroupCode() {
	}

	/** minimal constructor */
	public MemberGroupCode(Integer auditMemberGroupId, Integer baseGroupId, String groupNum, String groupName, Integer userId, String userName, String mobile,
			Integer auditer, Timestamp createTime) {
		super(auditMemberGroupId, baseGroupId, groupNum, groupName, userId, userName, mobile, auditer, createTime);
	}

	/** full constructor */
	public MemberGroupCode(Integer auditMemberGroupId, Integer baseGroupId, String groupNum, String groupName, Integer userId, String userName, String description,
			String mobile, Integer auditer, Timestamp createTime) {
		super(auditMemberGroupId, baseGroupId, groupNum, groupName, userId, userName, description, mobile, auditer, createTime);
	}

}
