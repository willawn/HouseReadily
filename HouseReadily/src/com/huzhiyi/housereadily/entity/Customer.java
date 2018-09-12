package com.huzhiyi.housereadily.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.huzhiyi.housereadily.entity.base.AbstractCustomer;
import com.huzhiyi.utils.ContextHelper;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */
public class Customer extends AbstractCustomer implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(Integer ctype) {
		super(ctype);
	}

	/** full constructor */
	public Customer(Integer id, Integer ctype, Integer buildType, String name, Integer gender, String phone, String mobile,
			Integer cityCode, Integer bigAreaCode, Integer smallAreaCode, Integer roomNum, Integer hallNum, Integer toiletNum,
			BigDecimal beginFirstPayment, BigDecimal endFirstPayment, BigDecimal beginArea, BigDecimal endArea, BigDecimal beginUnitPrice,
			BigDecimal endUnitPrice, BigDecimal beginTotalPrice, BigDecimal endTotalPrice, Integer year, Integer month, String description,
			Timestamp lastFollowDate, Timestamp updateTime, Timestamp syncTime, String version, Integer isEnable, Integer isDelete,
			Integer state, Integer creater, Timestamp createTime) {
		super(id, ctype, buildType, name, gender, phone, mobile, cityCode, bigAreaCode, smallAreaCode, roomNum, hallNum, toiletNum,
				beginFirstPayment, endFirstPayment, beginArea, endArea, beginUnitPrice, endUnitPrice, beginTotalPrice, endTotalPrice, year,
				month, description, lastFollowDate, updateTime, syncTime, version, isEnable, isDelete, state, creater, createTime);
	}

	private String cityEn;
	private String cityName;
	private String bigAreaName;
	private String smallAreaName;
	private String buildTypeName;
	private List houseReadilys = new ArrayList(0);
	private List houseOwners = new ArrayList(0);
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

	public List getHouseReadilys() {
		return houseReadilys;
	}

	public void setHouseReadilys(List houseReadilys) {
		this.houseReadilys = houseReadilys;
	}

	public List getHouseOwners() {
		return houseOwners;
	}

	public void setHouseOwners(List houseOwners) {
		this.houseOwners = houseOwners;
	}

	public String getBuildTypeName() {
		return ContextHelper.getBuildTypeName(getBuildType());
	}

	public void setBuildTypeName(String buildTypeName) {
		this.buildTypeName = buildTypeName;
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
