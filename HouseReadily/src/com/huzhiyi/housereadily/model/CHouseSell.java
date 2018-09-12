package com.huzhiyi.housereadily.model;

import java.util.Date;

import com.tastysoft.swct.db.model.TastyEntity;
import com.tastysoft.swct.util.DateHelper;
import com.huzhiyi.utils.ContextHelper;
import com.huzhiyi.utils.StringUtil;

public class CHouseSell  extends TastyEntity {
	 private Integer id;
	 private String commName;
	 private String userDefine;
	 
	 private String areaNum;
	 private String proName;
	 private String detail;
	 private String uploadcommodelfile;
	 private String uploadpropertypicfile;
	 private String uploadcommpicfile;
	 private String coverImage;
	 
	 private String coverImageStr;
	 private Integer rentPriceType;
	 private Integer roomNum;
	 private Integer hallNum;
	 private Integer toiletNum;
	 private Integer proFloor;
	 private Integer floorNum;
	 private Integer houseAge;
	 private Integer fitmentType;
	 private Integer buildType;
	 private Integer houseOri;
	 
	 private Date insertTime;
	 private Date updateTime;
	 
	 private Integer userId;
	 private String userName;
	 
	 private Integer stype;
	 
	 private Integer cityCode;
	 private String communityCode;
	 private Integer bigAreaCode;
	 private Integer smallAreaCode;
	 private String address;
	 private String trafficInfo;
	 private String aroundCondition;
	 
	 private String liveAreaNum;
	 private Integer kitchenNum;
	 private Integer balconyNum;
	 private Integer floorType;
	 private Integer houseRight;
	 private Integer expireDays;
	 private Integer lookTime;
	 
	
	 
	 private Integer structure;
	 private Integer floorCells;
	 private Float manageFee;
	 private Integer hasElevator;
	 private Integer hasInnerFloor;
	 
	 private Float priceTexed;
	 private Integer payType;
	 private Float housePrice;
	 private Integer isRent;
	 
	 private Double rentPrice;
	 private Integer deposit;
	 private Integer paymentTerm;
	 private Integer isDolmus;
	 private Integer minMonth;
	 private Date liveDate;
	 private Float lon;
	 private Float lat;
	 private Integer utype;
	 private String landRemark;
	 private String detailKeyword;
	 private String detailText;
	 private Integer publish;
	private String targetNo;
	private Integer buildDate;
	private String infoCode;
	private String uploadcommodelfiletitle;
	private String uploadpropertypicfiletitle;
	private String uploadcommpicfiletitle;
	private String uploadcommodelfiletext;
	private String uploadpropertypicfiletext;
	private String uploadcommpicfiletext;
	private Date publishTime;
	private Date publishFirstTime;
	private int publishRefreshCount;
	private int deleted;
	private Date deletedTime;
	private int recommend;
	private String equitment;
	private Integer villaType;
	private Integer hallStructure;
	private Integer workshopType;
	private Float areaOfWorkshop;
	private Float areaOfSpace;
	private Integer countOfGarage;
	private Integer countOfPacking;
	private Integer officeType;
	private Integer officeLeve;
	private Integer splitable;
	private Integer companyReg;
	private Integer shopsType;
	private Integer shopType;
	private String shopsed;
	private String shopsWil;
	
	private Integer countSucceedSize; 
	
	private Integer houseVersion;
	private Integer isSlabShow;
	private Integer isSlabDelete;
	private Integer imageServer;

	
	
	public Integer getRentPriceType() {
		return rentPriceType;
	}
	public void setRentPriceType(Integer rentPriceType) {
		this.rentPriceType = rentPriceType;
	}
	public Integer getImageServer() {
		return imageServer;
	}
	public void setImageServer(Integer imageServer) {
		this.imageServer = imageServer;
	}
	public Integer getIsSlabDelete() {
		return isSlabDelete;
	}
	public void setIsSlabDelete(Integer isSlabDelete) {
		this.isSlabDelete = isSlabDelete;
	}
	public Integer getIsSlabShow() {
		return isSlabShow;
	}
	public void setIsSlabShow(Integer isSlabShow) {
		this.isSlabShow = isSlabShow;
	}
	public Integer getCountSucceedSize() {
		return countSucceedSize;
	}

	public void setCountSucceedSize(Integer countSucceedSize) {
		this.countSucceedSize = countSucceedSize;
	}

	public Integer getHouseVersion() {
		return houseVersion;
	}

	public void setHouseVersion(Integer houseVersion) {
		this.houseVersion = houseVersion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public String getUserDefine() {
		return userDefine;
	}

	public void setUserDefine(String userDefine) {
		this.userDefine = userDefine;
	}

	public String getAreaNum() {
		return areaNum;
	}

	public void setAreaNum(String areaNum) {
		this.areaNum = areaNum;
	}
	
	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getUploadcommodelfile() {
		return uploadcommodelfile;
	}

	public void setUploadcommodelfile(String uploadcommodelfile) {
		this.uploadcommodelfile = uploadcommodelfile;
	}

	public String getUploadpropertypicfile() {
		return uploadpropertypicfile;
	}

	public void setUploadpropertypicfile(String uploadpropertypicfile) {
		this.uploadpropertypicfile = uploadpropertypicfile;
	}

	public String getUploadcommpicfile() {
		return uploadcommpicfile;
	}

	public void setUploadcommpicfile(String uploadcommpicfile) {
		this.uploadcommpicfile = uploadcommpicfile;
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

	public Integer getProFloor() {
		return proFloor;
	}

	public void setProFloor(Integer proFloor) {
		this.proFloor = proFloor;
	}

	public Integer getFloorNum() {
		return floorNum;
	}

	public void setFloorNum(Integer floorNum) {
		this.floorNum = floorNum;
	}

	public Integer getHouseAge() {
		return houseAge;
	}

	public void setHouseAge(Integer houseAge) {
		this.houseAge = houseAge;
	}

	public Integer getIsRent() {
		return isRent;
	}

	public void setIsRent(Integer isRent) {
		this.isRent = isRent;
	}

	public Integer getFitmentType() {
		return fitmentType;
	}

	public void setFitmentType(Integer fitmentType) {
		this.fitmentType = fitmentType;
	}

	public Integer getBuildType() {
		return buildType;
	}

	public void setBuildType(Integer buildType) {
		this.buildType = buildType;
	}

	public Integer getHouseOri() {
		return houseOri;
	}

	public void setHouseOri(Integer houseOri) {
		this.houseOri = houseOri;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStype() {
		return stype;
	}

	public void setStype(Integer stype) {
		this.stype = stype;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public String getCommunityCode() {
		return communityCode;
	}

	public void setCommunityCode(String communityCode) {
		this.communityCode = communityCode;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTrafficInfo() {
		return trafficInfo;
	}

	public void setTrafficInfo(String trafficInfo) {
		this.trafficInfo = trafficInfo;
	}

	public String getAroundCondition() {
		return aroundCondition;
	}

	public void setAroundCondition(String aroundCondition) {
		this.aroundCondition = aroundCondition;
	}

	public String getLiveAreaNum() {
		return liveAreaNum;
	}

	public void setLiveAreaNum(String liveAreaNum) {
		this.liveAreaNum = liveAreaNum;
	}

	public Integer getKitchenNum() {
		return kitchenNum;
	}

	public void setKitchenNum(Integer kitchenNum) {
		this.kitchenNum = kitchenNum;
	}

	public Integer getBalconyNum() {
		return balconyNum;
	}

	public void setBalconyNum(Integer balconyNum) {
		this.balconyNum = balconyNum;
	}

	public Integer getFloorType() {
		return floorType;
	}

	public void setFloorType(Integer floorType) {
		this.floorType = floorType;
	}

	public Integer getHouseRight() {
		return houseRight;
	}

	public void setHouseRight(Integer houseRight) {
		this.houseRight = houseRight;
	}

	public Integer getExpireDays() {
		return expireDays;
	}

	public void setExpireDays(Integer expireDays) {
		this.expireDays = expireDays;
	}

	public Integer getLookTime() {
		return lookTime;
	}

	public void setLookTime(Integer lookTime) {
		this.lookTime = lookTime;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getStructure() {
		return structure;
	}

	public void setStructure(Integer structure) {
		this.structure = structure;
	}

	public Integer getFloorCells() {
		return floorCells;
	}

	public void setFloorCells(Integer floorCells) {
		this.floorCells = floorCells;
	}
	

	public Float getManageFee() {
		return manageFee;
	}

	public void setManageFee(Float manageFee) {
		this.manageFee = manageFee;
	}

	public Integer getHasElevator() {
		return hasElevator;
	}

	public void setHasElevator(Integer hasElevator) {
		this.hasElevator = hasElevator;
	}

	public Integer getHasInnerFloor() {
		return hasInnerFloor;
	}

	public void setHasInnerFloor(Integer hasInnerFloor) {
		this.hasInnerFloor = hasInnerFloor;
	}

	public Integer getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(Integer paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public Integer getIsDolmus() {
		return isDolmus;
	}

	public void setIsDolmus(Integer isDolmus) {
		this.isDolmus = isDolmus;
	}

	public Float getPriceTexed() {
		return priceTexed;
	}

	public void setPriceTexed(Float priceTexed) {
		this.priceTexed = priceTexed;
	}

	public Float getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(Float housePrice) {
		this.housePrice = housePrice;
	}

	public Double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public Integer getDeposit() {
		return deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Integer getMinMonth() {
		return minMonth;
	}

	public void setMinMonth(Integer minMonth) {
		this.minMonth = minMonth;
	}

	public Date getLiveDate() {
		return liveDate;
	}

	public void setLiveDate(Date liveDate) {
		this.liveDate = liveDate;
	}

	public Integer getUtype() {
		return utype;
	}

	public void setUtype(Integer utype) {
		this.utype = utype;
	}

	public String getInsertTimeStr() {
		return DateHelper.dateToString(insertTime);
	}
	
	public String getUpdateTimeStr() {
		return DateHelper.dateToString(updateTime);
	}

	public String getLandRemark() {
		return landRemark;
	}

	public void setLandRemark(String landRemark) {
		this.landRemark = landRemark;
	}

	public String getLiveDateStr() {
		return DateHelper.dateToString(liveDate,"yyyy-MM-dd");
	}

	public String getDetailText() {
		return detailText;
	}

	public void setDetailText(String detailText) {
		this.detailText = detailText;
	}

	public String getDetailKeyword() {
		String detailKeyword_ = StringUtil.replace(detailKeyword,"|--|",",");
		return detailKeyword_;
	}

	public void setDetailKeyword(String detailKeyword) {
		String detailKeyword_ = StringUtil.replace(detailKeyword,",","|--|");
		this.detailKeyword = detailKeyword_;
	}

	public String getCoverImageStr() {
		if(coverImage==null){
			return "";
		}
		return coverImage;
	}

	public void setCoverImageStr(String coverImageStr) {
		this.coverImageStr = coverImageStr;
	}

	public Integer getPublish() {
		return publish;
	}

	public void setPublish(Integer publish) {
		this.publish = publish;
	}

	public String getTargetNo() {
		return targetNo;
	}

	public void setTargetNo(String targetNo) {
		this.targetNo = targetNo;
	}

	public Integer getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(Integer buildDate) {
		this.buildDate = buildDate;
	}

	public String getInfoCode() {
		return infoCode;
	}

	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}

	public String getUploadcommodelfiletitle() {
		return uploadcommodelfiletitle;
	}

	public void setUploadcommodelfiletitle(String uploadcommodelfiletitle) {
		this.uploadcommodelfiletitle = uploadcommodelfiletitle;
	}

	public String getUploadpropertypicfiletitle() {
		return uploadpropertypicfiletitle;
	}

	public void setUploadpropertypicfiletitle(String uploadpropertypicfiletitle) {
		this.uploadpropertypicfiletitle = uploadpropertypicfiletitle;
	}

	public String getUploadcommpicfiletitle() {
		return uploadcommpicfiletitle;
	}

	public void setUploadcommpicfiletitle(String uploadcommpicfiletitle) {
		this.uploadcommpicfiletitle = uploadcommpicfiletitle;
	}

	public String getUploadcommodelfiletext() {
		return uploadcommodelfiletext;
	}

	public void setUploadcommodelfiletext(String uploadcommodelfiletext) {
		this.uploadcommodelfiletext = uploadcommodelfiletext;
	}

	public String getUploadpropertypicfiletext() {
		return uploadpropertypicfiletext;
	}

	public void setUploadpropertypicfiletext(String uploadpropertypicfiletext) {
		this.uploadpropertypicfiletext = uploadpropertypicfiletext;
	}

	public String getUploadcommpicfiletext() {
		return uploadcommpicfiletext;
	}

	public void setUploadcommpicfiletext(String uploadcommpicfiletext) {
		this.uploadcommpicfiletext = uploadcommpicfiletext;
	}

	public Date getPublishTime() {
		return publishTime;
	}
	
	public String getPublishTimeStr() {
		return DateHelper.dateToString(publishTime);
	}
	
	public boolean isTodayRefresh(){
		boolean ret = false;
		String dtStr = DateHelper.dateToString(new Date(),"yyyy-MM-dd");
		Date dt = DateHelper.stringToDate(dtStr);
		if(publishTime!=null){
			if(publishTime.after(dt)){
				if(publishRefreshCount>0)
					ret = true;
			}
		}
		return ret;
	}
	public int getCanRefresh(){
		int can = 1;
		String dtStr = "2010-10-08";
		Date dt = DateHelper.stringToDate(dtStr);
		if(publishFirstTime!=null){
			if(publishFirstTime.before(dt)){
					can =2;
			}
		}
		if(can>1)
			return can;
		
		/*if(isTodayRefresh()){
			if(publishRefreshCount>=3)
				can =4;
		}
		
		if(can>1)
			return can;*/
		
		if(publishTime!=null){
			dt = new Date();
			if(DateHelper.getMinute(publishTime, 30).after(dt)){
				can =3;
			}
		}
		
		return can;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Date getPublishFirstTime() {
		return publishFirstTime;
	}

	public void setPublishFirstTime(Date publishFirstTime) {
		this.publishFirstTime = publishFirstTime;
	}

	public int getPublishRefreshCount() {
		return publishRefreshCount;
	}

	public void setPublishRefreshCount(int publishRefreshCount) {
		this.publishRefreshCount = publishRefreshCount;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public Date getDeletedTime() {
		return deletedTime;
	}

	public void setDeletedTime(Date deletedTime) {
		this.deletedTime = deletedTime;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	
	public boolean isCanPublish(){
		if(this.buildType==1||this.buildType==2){
			if(this.infoCode==null||infoCode.length()==0){
				return false;
			}
			return true;
		}else{
			return true;
		}
	}

	public String getEquitment() {
		return equitment;
	}

	public void setEquitment(String equitment) {
		this.equitment = equitment;
	}

	public Integer getVillaType() {
		return villaType;
	}

	public void setVillaType(Integer villaType) {
		this.villaType = villaType;
	}

	public Integer getHallStructure() {
		return hallStructure;
	}

	public void setHallStructure(Integer hallStructure) {
		this.hallStructure = hallStructure;
	}

	public Integer getWorkshopType() {
		return workshopType;
	}

	public void setWorkshopType(Integer workshopType) {
		this.workshopType = workshopType;
	}

	public Float getAreaOfWorkshop() {
		return areaOfWorkshop;
	}

	public void setAreaOfWorkshop(Float areaOfWorkshop) {
		this.areaOfWorkshop = areaOfWorkshop;
	}

	public Float getAreaOfSpace() {
		return areaOfSpace;
	}

	public void setAreaOfSpace(Float areaOfSpace) {
		this.areaOfSpace = areaOfSpace;
	}

	public Integer getCountOfGarage() {
		return countOfGarage;
	}

	public void setCountOfGarage(Integer countOfGarage) {
		this.countOfGarage = countOfGarage;
	}

	public Integer getCountOfPacking() {
		return countOfPacking;
	}

	public void setCountOfPacking(Integer countOfPacking) {
		this.countOfPacking = countOfPacking;
	}

	public Integer getOfficeType() {
		return officeType;
	}

	public void setOfficeType(Integer officeType) {
		this.officeType = officeType;
	}

	public Integer getOfficeLeve() {
		return officeLeve;
	}

	public void setOfficeLeve(Integer officeLeve) {
		this.officeLeve = officeLeve;
	}

	public Integer getSplitable() {
		return splitable;
	}

	public void setSplitable(Integer splitable) {
		this.splitable = splitable;
	}

	public Integer getCompanyReg() {
		return companyReg;
	}

	public void setCompanyReg(Integer companyReg) {
		this.companyReg = companyReg;
	}

	public Integer getShopsType() {
		return shopsType;
	}

	public void setShopsType(Integer shopsType) {
		this.shopsType = shopsType;
	}

	public Integer getShopType() {
		return shopType;
	}

	public void setShopType(Integer shopType) {
		this.shopType = shopType;
	}

	public String getShopsed() {
		return shopsed;
	}

	public void setShopsed(String shopsed) {
		this.shopsed = shopsed;
	}

	public String getShopsWil() {
		return shopsWil;
	}

	public void setShopsWil(String shopsWil) {
		this.shopsWil = shopsWil;
	}
	
	

	 public String getCityCodeName(){
		 return ContextHelper.getAreaName(this.getCityCode()); 
	 }
	 
	 public String getBigAreaCodeName(){
		 return ContextHelper.getAreaName(this.getBigAreaCode()); 
	 }
	 
	 public String getSmallAreaCodename(){
		 return ContextHelper.getAreaName(this.getSmallAreaCode()); 
	 }
	
	
}
