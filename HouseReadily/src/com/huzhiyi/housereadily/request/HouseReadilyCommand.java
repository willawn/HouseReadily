package com.huzhiyi.housereadily.request;

import java.math.BigDecimal;
import java.util.Date;

public class HouseReadilyCommand extends BaseCommand {

	private Integer id;
	private Integer stype;
	private Integer projectId;
	private String projectName;
//	private Integer cityCode;
//	private Integer bigAreaCode;
//	private Integer smallAreaCode;
//	private BigDecimal lon;
//	private BigDecimal lat;
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
	private Date createTime;
	private Date updateTime;
	//private Date lastFollowDate;
	private Date syncTime;
	private String version;
	private Integer state;
	//	private String address;
	private String houseOwners;
	private String btAttachments;
	private String snAttachments;
	private String fxAttachments;
	private String xqAttachments;
	private String delHouseOwners;
	private String updateHouseOwners;
	private String delAttachments;
	private String houseFollows;
	private String delHouseFollows;
	private String properties;
	private String ids;
	private Integer pageNo;
	private Integer pageSize;
	private Integer bigAreaCode;
	private Integer smallAreaCode;
	private BigDecimal beginArea;
	private BigDecimal endArea;
	private BigDecimal beginUnitPrice;
	private BigDecimal endUnitPrice;
	private BigDecimal beginTotalPrice;
	private BigDecimal endTotalPrice;
	private Integer beginRoomNum;
	private Integer endRoomNum;
	private Integer order;

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

//	public Integer getCityCode() {
//		return cityCode;
//	}
//
//	public void setCityCode(Integer cityCode) {
//		this.cityCode = cityCode;
//	}
//
//	public Integer getBigAreaCode() {
//		return bigAreaCode;
//	}
//
//	public void setBigAreaCode(Integer bigAreaCode) {
//		this.bigAreaCode = bigAreaCode;
//	}
//
//	public Integer getSmallAreaCode() {
//		return smallAreaCode;
//	}
//
//	public void setSmallAreaCode(Integer smallAreaCode) {
//		this.smallAreaCode = smallAreaCode;
//	}
//
//	public BigDecimal getLon() {
//		return lon;
//	}
//
//	public void setLon(BigDecimal lon) {
//		this.lon = lon;
//	}
//
//	public BigDecimal getLat() {
//		return lat;
//	}
//
//	public void setLat(BigDecimal lat) {
//		this.lat = lat;
//	}

	public Integer getBuildType() {
		return buildType;
	}

	public void setBuildType(Integer buildType) {
		this.buildType = buildType;
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

//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}

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

	public String getBtAttachments() {
		return btAttachments;
	}

	public void setBtAttachments(String btAttachments) {
		this.btAttachments = btAttachments;
	}

	public String getSnAttachments() {
		return snAttachments;
	}

	public void setSnAttachments(String snAttachments) {
		this.snAttachments = snAttachments;
	}

	public String getFxAttachments() {
		return fxAttachments;
	}

	public void setFxAttachments(String fxAttachments) {
		this.fxAttachments = fxAttachments;
	}

	public String getXqAttachments() {
		return xqAttachments;
	}

	public void setXqAttachments(String xqAttachments) {
		this.xqAttachments = xqAttachments;
	}

	public String getDelHouseOwners() {
		return delHouseOwners;
	}

	public void setDelHouseOwners(String delHouseOwners) {
		this.delHouseOwners = delHouseOwners;
	}
	
	public String getUpdateHouseOwners() {
		return updateHouseOwners;
	}

	public void setUpdateHouseOwners(String updateHouseOwners) {
		this.updateHouseOwners = updateHouseOwners;
	}

	public String getDelAttachments() {
		return delAttachments;
	}

	public void setDelAttachments(String delAttachments) {
		this.delAttachments = delAttachments;
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

	public String getHouseOwners() {
		return houseOwners;
	}

	public void setHouseOwners(String houseOwners) {
		this.houseOwners = houseOwners;
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

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
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
