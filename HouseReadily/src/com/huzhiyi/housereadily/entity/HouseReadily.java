package com.huzhiyi.housereadily.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.huzhiyi.housereadily.entity.base.AbstractHouseReadily;
import com.huzhiyi.utils.ContextHelper;

/**
 * HouseReadily entity. @author MyEclipse Persistence Tools
 */
public class HouseReadily extends AbstractHouseReadily implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public HouseReadily() {
	}

	/** full constructor */
	public HouseReadily(Integer id, Integer stype, Integer projectId, String projectName, Integer cityCode, Integer bigAreaCode,
			Integer smallAreaCode, BigDecimal lon, BigDecimal lat, Integer buildType, String title, String building, String houseNum,
			Integer roomNum, Integer hallNum, Integer toiletNum, BigDecimal area, BigDecimal unitPrice, BigDecimal totalPrice,
			Integer towards, Integer fitment, Integer houseRight, Integer furn, String keyer, Integer hasRedBook, String description,
			String address, Timestamp lastFollowDate, Timestamp updateTime, Timestamp syncTime, String version, Integer isEnable,
			Integer isDelete, Integer state, Integer creater, Timestamp createTime) {
		super(id, stype, projectId, projectName, cityCode, bigAreaCode, smallAreaCode, lon, lat, buildType, title, building, houseNum,
				roomNum, hallNum, toiletNum, area, unitPrice, totalPrice, towards, fitment, houseRight, furn, keyer, hasRedBook,
				description, address, lastFollowDate, updateTime, syncTime, version, isEnable, isDelete, state, creater, createTime);
	}

	private String cityEn;
	private String cityName;
	private String bigAreaName;
	private String smallAreaName;
	private String buildTypeName;
	private List houseOwners = new ArrayList(0);
	private List btAttachments = new ArrayList(0);
	private List snAttachments = new ArrayList(0);
	private List fxAttachments = new ArrayList(0);
	private List xqAttachments = new ArrayList(0);
	private List houseFollows = new ArrayList(0);
	private String userName;
	private Integer growing;

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

	public String getBuildTypeName() {
		return ContextHelper.getBuildTypeName(getBuildType());
	}

	public void setBuildTypeName(String buildTypeName) {
		this.buildTypeName = buildTypeName;
	}

	public List getHouseOwners() {
		return houseOwners;
	}

	public void setHouseOwners(List houseOwners) {
		this.houseOwners = houseOwners;
	}

	public List getBtAttachments() {
		return btAttachments;
	}

	public void setBtAttachments(List btAttachments) {
		this.btAttachments = btAttachments;
	}

	public List getSnAttachments() {
		return snAttachments;
	}

	public void setSnAttachments(List snAttachments) {
		this.snAttachments = snAttachments;
	}

	public List getFxAttachments() {
		return fxAttachments;
	}

	public void setFxAttachments(List fxAttachments) {
		this.fxAttachments = fxAttachments;
	}

	public List getXqAttachments() {
		return xqAttachments;
	}

	public void setXqAttachments(List xqAttachments) {
		this.xqAttachments = xqAttachments;
	}

	public List getHouseFollows() {
		return houseFollows;
	}

	public void setHouseFollows(List houseFollows) {
		this.houseFollows = houseFollows;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getGrowing() {
		return growing;
	}

	public void setGrowing(Integer growing) {
		this.growing = growing;
	}
}
