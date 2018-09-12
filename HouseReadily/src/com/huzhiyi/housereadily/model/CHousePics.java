package com.huzhiyi.housereadily.model;



import java.util.Date;

import com.tastysoft.swct.db.model.TastyEntity;
import com.huzhiyi.utils.StringUtil;


public class CHousePics extends TastyEntity{
	
	private int id;
	private String userName;
	private int userId;
	private String communityCode;
	private int picType;
	private int communityType;
	private String pic;
	private int share;
	private int deleted;
	private String adminName;
	private Date insertTime;
	private Date checkTime;
	private Date deleteTime;
	private int cityCode;
	private String picB;
	private String picMd5;
	private Integer imageServer;
	
	public Integer getImageServer() {
		return imageServer;
	}
	public void setImageServer(Integer imageServer) {
		this.imageServer = imageServer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCommunityCode() {
		return communityCode;
	}
	public void setCommunityCode(String communityCode) {
		this.communityCode = communityCode;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	public int getPicType() {
		return picType;
	}
	public void setPicType(int picType) {
		this.picType = picType;
	}
	public int getCommunityType() {
		return communityType;
	}
	public void setCommunityType(int communityType) {
		this.communityType = communityType;
	}
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}
	public String getPicB() {
		String image  = getPic();
		if(image.length()>0)
			image = StringUtil.replace(image, "s.", "b.");
		return image;
	}
	
	public void setPicB(String picB) {
		this.picB = picB;
	}
	
	public String getPicMd5() {
		return picMd5;
	}
	public void setPicMd5(String picMd5) {
		this.picMd5 = picMd5;
	}
	
}
