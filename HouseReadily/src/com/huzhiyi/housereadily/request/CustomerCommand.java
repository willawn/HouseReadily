package com.huzhiyi.housereadily.request;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerCommand extends BaseCommand {

	private Integer id;
	private Integer ctype;
	private Integer buildType;
	private String name;
	private Integer gender;
	private String phone;
	private String mobile;
	private Integer bigAreaCode;
	private Integer smallAreaCode;
	private Integer roomNum;
	private Integer hallNum;
	private Integer toiletNum;
//	private BigDecimal firstPayment;
//	private BigDecimal area;
//	private BigDecimal unitPrice;
	private Integer year;
	private Integer month;
	private String description;
	private Date createTime;
	private Date updateTime;
	//private Date lastFollowDate;
	private Date syncTime;
	private String version;
	private Integer state;
	private String houseReadilyIds;
	private String delHouseReadilys;
	private String houseFollows;
	private String delHouseFollows;
	private String properties;
	private String ids;
	private Integer pageNo;
	private Integer pageSize;
	private BigDecimal beginFirstPayment;
	private BigDecimal endFirstPayment;
	private BigDecimal beginArea;
	private BigDecimal endArea;
	private BigDecimal beginUnitPrice;
	private BigDecimal endUnitPrice;
	private BigDecimal beginTotalPrice;
	private BigDecimal endTotalPrice;
	private Integer beginRoomNum;
	private Integer endRoomNum;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
//	public Date getLastFollowDate() {
//		return lastFollowDate;
//	}
//
//	public void setLastFollowDate(Date lastFollowDate) {
//		this.lastFollowDate = lastFollowDate;
//	}

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
	
	public String getHouseReadilyIds() {
		return houseReadilyIds;
	}

	public void setHouseReadilyIds(String houseReadilyIds) {
		this.houseReadilyIds = houseReadilyIds;
	}

	public String getDelHouseReadilys() {
		return delHouseReadilys;
	}

	public void setDelHouseReadilys(String delHouseReadilys) {
		this.delHouseReadilys = delHouseReadilys;
	}
	
	public String getHouseFollows() {
		return houseFollows;
	}

	public void setHouseFollows(String houseFollows) {
		this.houseFollows = houseFollows;
	}
	
	public String getDelHouseFollows() {
		return delHouseFollows;
	}

	public void setDelHouseFollows(String delHouseFollows) {
		this.delHouseFollows = delHouseFollows;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public BigDecimal getBeginArea() {
		return beginArea;
	}

	public void setBeginArea(BigDecimal beginArea) {
		this.beginArea = beginArea;
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

	public Integer getBeginRoomNum() {
		return beginRoomNum;
	}

	public void setBeginRoomNum(Integer beginRoomNum) {
		this.beginRoomNum = beginRoomNum;
	}

	public Integer getEndRoomNum() {
		return endRoomNum;
	}

	public void setEndRoomNum(Integer endRoomNum) {
		this.endRoomNum = endRoomNum;
	}

	public BigDecimal getEndArea() {
		return endArea;
	}

	public void setEndArea(BigDecimal endArea) {
		this.endArea = endArea;
	}

	public Integer getBuildType() {
		return buildType;
	}

	public void setBuildType(Integer buildType) {
		this.buildType = buildType;
	}

//	public BigDecimal getFirstPayment() {
//		return firstPayment;
//	}
//
//	public void setFirstPayment(BigDecimal firstPayment) {
//		this.firstPayment = firstPayment;
//	}

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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
