package com.huzhiyi.housereadily.model;


import java.util.Date;

import com.tastysoft.swct.db.model.TastyEntity;

public class CCustomers extends TastyEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String realname;
	private Integer sex;
	private String job;
	private String mobile;
	private String email;
	private String tel;
	private String pid;
	private String address;
	private String remark;
	private Integer deleted;
	private Date deleteTime;
	private Date insertTime;
	private Date updateTime;
	private Integer userId;
	private String userName;
	private Integer ctype;
	private Integer btype; 
	private Float mtotalPrice;
	private Float btotalPrice;
	private Float mpayment;
	private Float bpayment;
	private String area;
	private String sales;
	private String flools;
	private String houseAge;
	private String needgoal;
	private String xiaoqu;
	private String toward;
	private Float rentalprice;
	private String decoration;
	private String rentway;
	private String sexRequirement;
	private String housetype;
	private Integer room;
	private Integer hall;
	private Integer washroom;
	
	
	public Integer getHall() {
		return hall;
	}
	public void setHall(Integer hall) {
		this.hall = hall;
	}
	public Integer getWashroom() {
		return washroom;
	}
	public void setWashroom(Integer washroom) {
		this.washroom = washroom;
	}
	private String houseconfig;
	
	public Integer getRoom() {
		return room;
	}
	public void setRoom(Integer room) {
		this.room = room;
	}
	public Integer getCtype() {
		return ctype;
	}
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	private Integer classId;
	
	private String classIdName;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassIdName() {
		return classIdName;
	}
	public void setClassIdName(String classIdName) {
		this.classIdName = classIdName;
	}
	public Integer getBtype() {
		return btype;
	}
	public void setBtype(Integer btype) {
		this.btype = btype;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getFlools() {
		return flools;
	}
	public void setFlools(String flools) {
		this.flools = flools;
	}
	public String getXiaoqu() {
		return xiaoqu;
	}
	public void setXiaoqu(String xiaoqu) {
		this.xiaoqu = xiaoqu;
	}
	public String getToward() {
		return toward;
	}
	public void setToward(String toward) {
		this.toward = toward;
	}
	public String getDecoration() {
		return decoration;
	}
	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}
	public String getRentway() {
		return rentway;
	}
	public void setRentway(String rentway) {
		this.rentway = rentway;
	}
	public String getSexRequirement() {
		return sexRequirement;
	}
	public void setSexRequirement(String sexRequirement) {
		this.sexRequirement = sexRequirement;
	}
	public String getHousetype() {
		return housetype;
	}
	public void setHousetype(String housetype) {
		this.housetype = housetype;
	}
	public String getHouseconfig() {
		return houseconfig;
	}
	public void setHouseconfig(String houseconfig) {
		this.houseconfig = houseconfig;
	}
	public Float getMtotalPrice() {
		return mtotalPrice;
	}
	public void setMtotalPrice(Float mtotalPrice) {
		this.mtotalPrice = mtotalPrice;
	}
	public Float getBtotalPrice() {
		return btotalPrice;
	}
	public void setBtotalPrice(Float btotalPrice) {
		this.btotalPrice = btotalPrice;
	}
	public Float getMpayment() {
		return mpayment;
	}
	public void setMpayment(Float mpayment) {
		this.mpayment = mpayment;
	}
	public Float getBpayment() {
		return bpayment;
	}
	public void setBpayment(Float bpayment) {
		this.bpayment = bpayment;
	}
	public Float getRentalprice() {
		return rentalprice;
	}
	public void setRentalprice(Float rentalprice) {
		this.rentalprice = rentalprice;
	}
	public String getHouseAge() {
		return houseAge;
	}
	public void setHouseAge(String houseAge) {
		this.houseAge = houseAge;
	}
	public String getNeedgoal() {
		return needgoal;
	}
	public void setNeedgoal(String needgoal) {
		this.needgoal = needgoal;
	}
}
