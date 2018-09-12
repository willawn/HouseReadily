package com.huzhiyi.housereadily.response;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONObject;

public class CustomerResult extends StatusResult {

	private Integer id;
	private Integer ctype;
	private Integer buildType;
	private String buildTypeName;
	private String name;
	private Integer gender;
	private String phone;
	private String mobile;
	private Integer cityCode;
	private String cityEn;
	private String cityName;
	private Integer bigAreaCode;
	private String bigAreaName;
	private Integer smallAreaCode;
	private String smallAreaName;
	private Integer roomNum;
	private Integer hallNum;
	private Integer toiletNum;
//	private BigDecimal firstPayment;
//	private BigDecimal area;
//	private BigDecimal unitPrice;
//	private BigDecimal totalPrice;
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
	private Date syncTime;
	private String version;
	private Timestamp updateTime;
	private Integer state;
	private Integer creater;
	private Timestamp createTime;
	private JSONObject houseReadilys;
	private JSONObject houseOwners;
	private JSONObject houseFollows;
	private Integer growing;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCtype() {
		return ctype;
	}

	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityEn() {
		return cityEn;
	}

	public void setCityEn(String cityEn) {
		this.cityEn = cityEn;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getBigAreaCode() {
		return bigAreaCode;
	}

	public void setBigAreaCode(Integer bigAreaCode) {
		this.bigAreaCode = bigAreaCode;
	}

	public Integer getSmallAreaCode() {
		return smallAreaCode;
	}

	public void setSmallAreaCode(Integer smallAreaCode) {
		this.smallAreaCode = smallAreaCode;
	}

	public Integer getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}

	public Integer getHallNum() {
		return hallNum;
	}

	public void setHallNum(Integer hallNum) {
		this.hallNum = hallNum;
	}

	public Integer getToiletNum() {
		return toiletNum;
	}

	public void setToiletNum(Integer toiletNum) {
		this.toiletNum = toiletNum;
	}

//	public BigDecimal getFirstPayment() {
//		return firstPayment;
//	}
//
//	public void setFirstPayment(BigDecimal firstPayment) {
//		this.firstPayment = firstPayment;
//	}
//	
//	public BigDecimal getArea() {
//		return area;
//	}
//
//	public void setArea(BigDecimal area) {
//		this.area = area;
//	}
//
//	public BigDecimal getUnitPrice() {
//		return unitPrice;
//	}
//
//	public void setUnitPrice(BigDecimal unitPrice) {
//		this.unitPrice = unitPrice;
//	}
//
//	public BigDecimal getTotalPrice() {
//		return totalPrice;
//	}
//
//	public void setTotalPrice(BigDecimal totalPrice) {
//		this.totalPrice = totalPrice;
//	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getDescription() {
		return description;
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
	
	public Integer getCreater() {
		return creater;
	}

	public void setCreater(Integer creater) {
		this.creater = creater;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public JSONObject getHouseReadilys() {
		return houseReadilys;
	}

	public void setHouseReadilys(JSONObject houseReadilys) {
		this.houseReadilys = houseReadilys;
	}

	public String getBigAreaName() {
		return bigAreaName;
	}

	public void setBigAreaName(String bigAreaName) {
		this.bigAreaName = bigAreaName;
	}

	public String getSmallAreaName() {
		return smallAreaName;
	}

	public void setSmallAreaName(String smallAreaName) {
		this.smallAreaName = smallAreaName;
	}

	public Integer getBuildType() {
		return buildType;
	}

	public void setBuildType(Integer buildType) {
		this.buildType = buildType;
	}

	public String getBuildTypeName() {
		return buildTypeName;
	}

	public void setBuildTypeName(String buildTypeName) {
		this.buildTypeName = buildTypeName;
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

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public JSONObject getHouseFollows() {
		return houseFollows;
	}

	public void setHouseFollows(JSONObject houseFollows) {
		this.houseFollows = houseFollows;
	}

	public JSONObject getHouseOwners() {
		return houseOwners;
	}

	public void setHouseOwners(JSONObject houseOwners) {
		this.houseOwners = houseOwners;
	}

	public Integer getGrowing() {
		return growing;
	}

	public void setGrowing(Integer growing) {
		this.growing = growing;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
