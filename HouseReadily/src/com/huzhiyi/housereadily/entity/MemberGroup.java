package com.huzhiyi.housereadily.entity;

import java.sql.Timestamp;

import com.huzhiyi.housereadily.entity.base.AbstractMemberGroup;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.ContextHelper;

/**
 * MemberGroup entity. @author MyEclipse Persistence Tools
 */
public class MemberGroup extends AbstractMemberGroup implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MemberGroup() {
	}

	/** minimal constructor */
	public MemberGroup(Integer baseGroupId, Integer roleType, Integer userId, Timestamp syncTime, String version, Integer isDelete,
			Timestamp createTime) {
		super(baseGroupId, roleType, userId, syncTime, version, isDelete, createTime);
	}

	/** full constructor */
	public MemberGroup(Integer baseGroupId, Integer roleType, Integer userId, String userName, String realName, Timestamp syncTime,
			String version, Integer isDelete, Timestamp createTime) {
		super(baseGroupId, roleType, userId, userName, realName, syncTime, version, isDelete, createTime);
	}

	private Integer cityCode;
	private String cityEn;
	private String cityName;
	private String avatar;
	private String mobile;
	private String email;

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityEn() {
		return ContextHelper.cityEnNames.get(getCityCode());
	}

	public void setCityEn(String cityEn) {
		this.cityEn = cityEn;
	}

	public String getCityName() {
		return ContextHelper.allareas.get(getCityCode());
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAvatar() {
		return StringUtils.isNotEmpty(avatar) ? Configuration.WEB_SITE_PATH + avatar : "";
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
