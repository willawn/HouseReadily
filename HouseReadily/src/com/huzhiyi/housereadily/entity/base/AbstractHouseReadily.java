package com.huzhiyi.housereadily.entity.base;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.tastysoft.swct.db.model.TastyEntity;

/**
 * AbstractHouseReadily entity provides the base persistence definition of the
 * HouseReadily entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractHouseReadily extends TastyEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer stype;
	private Integer projectId;
	private String projectName;
	private Integer cityCode;
	private Integer bigAreaCode;
	private Integer smallAreaCode;
	private BigDecimal lon;
	private BigDecimal lat;
	private Integer buildType;
	private String title;
	private String building;
	private String houseNum;
	private Integer roomNum;
	private Integer hallNum;
	private Integer toiletNum;
	private BigDecimal area;
	private BigDecimal unitPrice;
	private BigDecimal totalPrice;
	private Integer towards;
	private Integer fitment;
	private Integer houseRight;
	private Integer furn;
	private String keyer;
	private Integer hasRedBook;
	private String description;
	private String address;
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
	public AbstractHouseReadily() {
	}

	/** full constructor */
	public AbstractHouseReadily(Integer id, Integer stype, Integer projectId, String projectName, Integer cityCode, Integer bigAreaCode,
			Integer smallAreaCode, BigDecimal lon, BigDecimal lat, Integer buildType, String title, String building, String houseNum,
			Integer roomNum, Integer hallNum, Integer toiletNum, BigDecimal area, BigDecimal unitPrice, BigDecimal totalPrice,
			Integer towards, Integer fitment, Integer houseRight, Integer furn, String keyer, Integer hasRedBook, String description,
			String address, Timestamp lastFollowDate, Timestamp updateTime, Timestamp syncTime, String version, Integer isEnable,
			Integer isDelete, Integer state, Integer creater, Timestamp createTime) {
		super();
		this.id = id;
		this.stype = stype;
		this.projectId = projectId;
		this.projectName = projectName;
		this.cityCode = cityCode;
		this.bigAreaCode = bigAreaCode;
		this.smallAreaCode = smallAreaCode;
		this.lon = lon;
		this.lat = lat;
		this.buildType = buildType;
		this.title = title;
		this.building = building;
		this.houseNum = houseNum;
		this.roomNum = roomNum;
		this.hallNum = hallNum;
		this.toiletNum = toiletNum;
		this.area = area;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.towards = towards;
		this.fitment = fitment;
		this.houseRight = houseRight;
		this.furn = furn;
		this.keyer = keyer;
		this.hasRedBook = hasRedBook;
		this.description = description;
		this.address = address;
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

	public Integer getStype() {
		return this.stype;
	}

	public void setStype(Integer stype) {
		this.stype = stype;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getCityCode() {
		return this.cityCode;
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

	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public Integer getBuildType() {
		return buildType;
	}

	public void setBuildType(Integer buildType) {
		this.buildType = buildType;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBuilding() {
		return this.building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getHouseNum() {
		return this.houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
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

//	public BigDecimal getFirstPayment() {
//		return firstPayment;
//	}
//
//	public void setFirstPayment(BigDecimal firstPayment) {
//		this.firstPayment = firstPayment;
//	}

	public BigDecimal getArea() {
		return this.area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getTowards() {
		return towards;
	}

	public void setTowards(Integer towards) {
		this.towards = towards;
	}

	public Integer getFitment() {
		return fitment;
	}

	public void setFitment(Integer fitment) {
		this.fitment = fitment;
	}

	public Integer getHouseRight() {
		return houseRight;
	}

	public void setHouseRight(Integer houseRight) {
		this.houseRight = houseRight;
	}

	public Integer getFurn() {
		return furn;
	}

	public void setFurn(Integer furn) {
		this.furn = furn;
	}

	public Integer getHasRedBook() {
		return this.hasRedBook;
	}

	public void setHasRedBook(Integer hasRedBook) {
		this.hasRedBook = hasRedBook;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getKeyer() {
		return keyer;
	}

	public void setKeyer(String keyer) {
		this.keyer = keyer;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}