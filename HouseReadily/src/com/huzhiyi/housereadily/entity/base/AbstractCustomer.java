package com.huzhiyi.housereadily.entity.base;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.tastysoft.swct.db.model.TastyEntity;

/**
 * AbstractCustomer entity provides the base persistence definition of the
 * Customer entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCustomer extends TastyEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer ctype;
	private Integer buildType;
	private String name;
	private Integer gender;
	private String phone;
	private String mobile;
	private Integer cityCode;
	private Integer bigAreaCode;
	private Integer smallAreaCode;
	private Integer roomNum;
	private Integer hallNum;
	private Integer toiletNum;
	// private BigDecimal firstPayment;
	// private BigDecimal area;
	// private BigDecimal unitPrice;
	// private BigDecimal totalPrice;
	private BigDecimal beginFirstPayment;
	private BigDecimal endFirstPayment;
	private BigDecimal beginArea;
	private BigDecimal endArea;
	private BigDecimal beginUnitPrice;
	private BigDecimal endUnitPrice;
	private BigDecimal beginTotalPrice;
	private BigDecimal endTotalPrice;
	private Integer year;
	private Integer month;
	private String description;
	private Timestamp lastFollowDate;
	private Timestamp updateTime;
	private Timestamp syncTime;
	private String version;
	private Integer isEnable;
	private Integer isDelete;
	private Integer state;
	private Integer creater;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public AbstractCustomer() {
	}

	/** minimal constructor */
	public AbstractCustomer(Integer ctype) {
		this.ctype = ctype;
	}

	/** full constructor */
	public AbstractCustomer(Integer id, Integer ctype, Integer buildType, String name, Integer gender, String phone, String mobile,
			Integer cityCode, Integer bigAreaCode, Integer smallAreaCode, Integer roomNum, Integer hallNum, Integer toiletNum,
			BigDecimal beginFirstPayment, BigDecimal endFirstPayment, BigDecimal beginArea, BigDecimal endArea, BigDecimal beginUnitPrice,
			BigDecimal endUnitPrice, BigDecimal beginTotalPrice, BigDecimal endTotalPrice, Integer year, Integer month, String description,
			Timestamp lastFollowDate, Timestamp updateTime, Timestamp syncTime, String version, Integer isEnable, Integer isDelete,
			Integer state, Integer creater, Timestamp createTime) {
		super();
		this.id = id;
		this.ctype = ctype;
		this.buildType = buildType;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.mobile = mobile;
		this.cityCode = cityCode;
		this.bigAreaCode = bigAreaCode;
		this.smallAreaCode = smallAreaCode;
		this.roomNum = roomNum;
		this.hallNum = hallNum;
		this.toiletNum = toiletNum;
		this.beginFirstPayment = beginFirstPayment;
		this.endFirstPayment = endFirstPayment;
		this.beginArea = beginArea;
		this.endArea = endArea;
		this.beginUnitPrice = beginUnitPrice;
		this.endUnitPrice = endUnitPrice;
		this.beginTotalPrice = beginTotalPrice;
		this.endTotalPrice = endTotalPrice;
		this.year = year;
		this.month = month;
		this.description = description;
		this.lastFollowDate = lastFollowDate;
		this.updateTime = updateTime;
		this.syncTime = syncTime;
		this.version = version;
		this.isEnable = isEnable;
		this.isDelete = isDelete;
		this.state = state;
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

	public Integer getCtype() {
		return this.ctype;
	}

	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public Integer getRoomNum() {
		return this.roomNum;
	}

	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}

	public Integer getHallNum() {
		return this.hallNum;
	}

	public void setHallNum(Integer hallNum) {
		this.hallNum = hallNum;
	}

	public Integer getToiletNum() {
		return this.toiletNum;
	}

	public void setToiletNum(Integer toiletNum) {
		this.toiletNum = toiletNum;
	}

	public BigDecimal getBeginFirstPayment() {
		return beginFirstPayment;
	}

	public void setBeginFirstPayment(BigDecimal beginFirstPayment) {
		this.beginFirstPayment = beginFirstPayment;
	}

	public BigDecimal getEndFirstPayment() {
		return endFirstPayment;
	}

	public void setEndFirstPayment(BigDecimal endFirstPayment) {
		this.endFirstPayment = endFirstPayment;
	}

	public BigDecimal getBeginArea() {
		return beginArea;
	}

	public void setBeginArea(BigDecimal beginArea) {
		this.beginArea = beginArea;
	}

	public BigDecimal getEndArea() {
		return endArea;
	}

	public void setEndArea(BigDecimal endArea) {
		this.endArea = endArea;
	}

	public BigDecimal getBeginUnitPrice() {
		return beginUnitPrice;
	}

	public void setBeginUnitPrice(BigDecimal beginUnitPrice) {
		this.beginUnitPrice = beginUnitPrice;
	}

	public BigDecimal getEndUnitPrice() {
		return endUnitPrice;
	}

	public void setEndUnitPrice(BigDecimal endUnitPrice) {
		this.endUnitPrice = endUnitPrice;
	}

	public BigDecimal getBeginTotalPrice() {
		return beginTotalPrice;
	}

	public void setBeginTotalPrice(BigDecimal beginTotalPrice) {
		this.beginTotalPrice = beginTotalPrice;
	}

	public BigDecimal getEndTotalPrice() {
		return endTotalPrice;
	}

	public void setEndTotalPrice(BigDecimal endTotalPrice) {
		this.endTotalPrice = endTotalPrice;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return this.month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getLastFollowDate() {
		return lastFollowDate;
	}

	public void setLastFollowDate(Timestamp lastFollowDate) {
		this.lastFollowDate = lastFollowDate;
	}
	
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Timestamp syncTime) {
		this.syncTime = syncTime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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

	public Integer getBuildType() {
		return buildType;
	}

	public void setBuildType(Integer buildType) {
		this.buildType = buildType;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}