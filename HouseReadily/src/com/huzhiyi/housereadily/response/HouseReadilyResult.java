package com.huzhiyi.housereadily.response;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONObject;

public class HouseReadilyResult extends StatusResult {

	private Integer id;
	private Integer stype;
	private Integer projectId;
	private String projectName;
	private Integer cityCode;
	private String cityEn;
	private String cityName;
	private Integer bigAreaCode;
	private String bigAreaName;
	private Integer smallAreaCode;
	private String smallAreaName;
	private BigDecimal lon;
	private BigDecimal lat;
	private Integer buildType;
	private String buildTypeName;
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
	private Date syncTime;
	private String version;
	private Timestamp updateTime;
	private Integer state;
	private Integer creater;
	private Timestamp createTime;
	private JSONObject houseOwners;
	private JSONObject btAttachments;
	private JSONObject snAttachments;
	private JSONObject fxAttachments;
	private JSONObject xqAttachments;
	private JSONObject houseFollows;
	private Integer growing;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStype() {
		return stype;
	}

	public void setStype(Integer stype) {
		this.stype = stype;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
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

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getHasRedBook() {
		return hasRedBook;
	}

	public void setHasRedBook(Integer hasRedBook) {
		this.hasRedBook = hasRedBook;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
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

	public JSONObject getHouseOwners() {
		return houseOwners;
	}

	public void setHouseOwners(JSONObject houseOwners) {
		this.houseOwners = houseOwners;
	}

	public JSONObject getBtAttachments() {
		return btAttachments;
	}

	public void setBtAttachments(JSONObject btAttachments) {
		this.btAttachments = btAttachments;
	}

	public JSONObject getSnAttachments() {
		return snAttachments;
	}

	public void setSnAttachments(JSONObject snAttachments) {
		this.snAttachments = snAttachments;
	}

	public JSONObject getFxAttachments() {
		return fxAttachments;
	}

	public void setFxAttachments(JSONObject fxAttachments) {
		this.fxAttachments = fxAttachments;
	}

	public JSONObject getXqAttachments() {
		return xqAttachments;
	}

	public void setXqAttachments(JSONObject xqAttachments) {
		this.xqAttachments = xqAttachments;
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

	public Integer getGrowing() {
		return growing;
	}

	public void setGrowing(Integer growing) {
		this.growing = growing;
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
