package com.huzhiyi.housereadily.entity;

import java.sql.Timestamp;

import com.huzhiyi.housereadily.entity.base.AbstractBaseGroup;
import com.huzhiyi.utils.ContextHelper;

/**
 * BaseGroup entity. @author MyEclipse Persistence Tools
 */
public class BaseGroup extends AbstractBaseGroup implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public BaseGroup() {
	}

	/** minimal constructor */
	public BaseGroup(Integer level, String groupNum, String groupName, Integer cityCode, Integer bigAreaCode, Integer smallAreaCode,
			Timestamp syncTime, String version, Integer isDelete, Integer creater, Timestamp createTime) {
		super(level, groupNum, groupName, cityCode, bigAreaCode, smallAreaCode, syncTime, version, isDelete, creater, createTime);
	}

	/** full constructor */
	public BaseGroup(Integer level, String groupNum, String groupName, String acement, String description, Integer cityCode,
			Integer bigAreaCode, Integer smallAreaCode, Timestamp syncTime, String version, Integer isDelete, Integer creater,
			Timestamp createTime) {
		super(level, groupNum, groupName, acement, description, cityCode, bigAreaCode, smallAreaCode, syncTime, version, isDelete, creater,
				createTime);
	}

	private String cityEn;
	private String cityName;
	private String bigAreaName;
	private String smallAreaName;
	private String createrName;
	private String createrRealName;

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

	public String getBigAreaName() {
		return ContextHelper.allareas.get(getBigAreaCode());
	}

	public void setBigAreaName(String bigAreaName) {
		this.bigAreaName = bigAreaName;
	}

	public String getSmallAreaName() {
		return ContextHelper.allareas.get(getSmallAreaCode());
	}

	public void setSmallAreaName(String smallAreaName) {
		this.smallAreaName = smallAreaName;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public String getCreaterRealName() {
		return createrRealName;
	}

	public void setCreaterRealName(String createrRealName) {
		this.createrRealName = createrRealName;
	}
}
