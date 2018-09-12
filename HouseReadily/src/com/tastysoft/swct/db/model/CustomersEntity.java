package com.tastysoft.swct.db.model;

import java.util.Date;

public class CustomersEntity extends TastyEntity{

   private String customerServerId; // 服务器上客户表的ID
   private String customerLocalId;   // 本机上的客户ID
   private String name;   // 客户名称
   private String pinyin; // 客户姓名全拼
   private String sex;    // 姓名（男/女
   private String telphone;//  手机号码
   private String email;   // 邮箱地址
   private String callname; // 称呼
   private String helloword; // 招呼语
   private String sign;    // 签名
   private String remark;  // 备注
   private String commId;  // 意向小区编码
   private String floor;  //楼层
   private String rooms;  //房间数
   private String area;   // 面积
   private Float lPrice; // 最低房价
   private Float hPrice; // 最高房价
   private String firstPay; //首付 （XX-XX
   private String tendcomm;  //意向小区名称
   private String purpose; //购房目的
   private String direct;  // 朝向
   private String houseold;  //房龄
   private String rhousetype; //租房方式
   private String rsex;  // 性别要求
   private Integer rrooms; // 租房房间数
   private Integer rhalls; //租房厅数
   private Integer rtoilets; //租房卫数
   private Float rentprice; // 租金
   private String rconfig;  // 房间配置需求
   private Date ptime; //房间配置需求	
	public String getCustomerServerId() {
		return customerServerId;
	}
	public void setCustomerServerId(String customerServerId) {
		this.customerServerId = customerServerId;
	}
	public String getCustomerLocalId() {
		return customerLocalId;
	}
	public void setCustomerLocalId(String customerLocalId) {
		this.customerLocalId = customerLocalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCallname() {
		return callname;
	}
	public void setCallname(String callname) {
		this.callname = callname;
	}
	public String getHelloword() {
		return helloword;
	}
	public void setHelloword(String helloword) {
		this.helloword = helloword;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCommId() {
		return commId;
	}
	public void setCommId(String commId) {
		this.commId = commId;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getRooms() {
		return rooms;
	}
	public void setRooms(String rooms) {
		this.rooms = rooms;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Float getLPrice() {
		return lPrice;
	}
	public void setLPrice(Float price) {
		lPrice = price;
	}
	public Float getHPrice() {
		return hPrice;
	}
	public void setHPrice(Float price) {
		hPrice = price;
	}
	public String getFirstPay() {
		return firstPay;
	}
	public void setFirstPay(String firstPay) {
		this.firstPay = firstPay;
	}
	public String getTendcomm() {
		return tendcomm;
	}
	public void setTendcomm(String tendcomm) {
		this.tendcomm = tendcomm;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getDirect() {
		return direct;
	}
	public void setDirect(String direct) {
		this.direct = direct;
	}
	public String getHouseold() {
		return houseold;
	}
	public void setHouseold(String houseold) {
		this.houseold = houseold;
	}
	public String getRhousetype() {
		return rhousetype;
	}
	public void setRhousetype(String rhousetype) {
		this.rhousetype = rhousetype;
	}
	public String getRsex() {
		return rsex;
	}
	public void setRsex(String rsex) {
		this.rsex = rsex;
	}
	public Integer getRrooms() {
		return rrooms;
	}
	public void setRrooms(Integer rrooms) {
		this.rrooms = rrooms;
	}
	public Integer getRhalls() {
		return rhalls;
	}
	public void setRhalls(Integer rhalls) {
		this.rhalls = rhalls;
	}
	public Integer getRtoilets() {
		return rtoilets;
	}
	public void setRtoilets(Integer rtoilets) {
		this.rtoilets = rtoilets;
	}
	public Float getRentprice() {
		return rentprice;
	}
	public void setRentprice(Float rentprice) {
		this.rentprice = rentprice;
	}
	public String getRconfig() {
		return rconfig;
	}
	public void setRconfig(String rconfig) {
		this.rconfig = rconfig;
	}
	public Date getPtime() {
		return ptime;
	}
	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}
	   
	   
}
