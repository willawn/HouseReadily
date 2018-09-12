package com.huzhiyi.housereadily.model;

import com.tastysoft.swct.db.model.TastyEntity;
public class CHouseWebsitesView extends TastyEntity {
	
	
	private Integer id;
	private Integer wid;
	private Integer serialNo;
	private String siteName;
	private String siteUrl;
	
	private Integer groupId;
    private String groupName;
	private String remark;
	 
	
	private Integer allowReg;
	private Integer allowLogin;
	private Integer allowSell;
	private Integer allowImport;
	private Integer allowModifyPwd;
	private Integer allowModifyUser;
	
	private Integer allowRefresh;
	private Integer allowTimerRefresh;
	private Integer allowTj;
	private Integer allowTimerTj;
	private Integer allowTop;
	
	private Integer allowUpdate;
	private Integer allowDelete;
	private Integer allowServer;
	

	private Integer siteLoginType;
	private Integer siteImageType;
	private Integer siteValidCodeType;
	
	private Integer siteKc;
	private Integer siteChangeCity;
	private Integer paramUserType;
	private Integer paramSubjectType;
	
	private Integer sitePublishType;
	private String siteLogo;
	private Integer status;
	
	private String nameFullEn;
	private String nameSimpleEn;
	
	
	private Integer cityCode;
	private Integer rank;
	private Integer cityStatus;
	
	private String esfUrl;
	private String spUrl;
	private String bsUrl;
	private String xzlUrl;
	private String cfckUrl;
	
	private int forbidType;
	private String regName;
	private String siteRemark;
	
	private int loginType;
	
	private Integer visible ;
	private String citySiteRemark;
	
	private int allowResidence;
	private int allowVilla;
	private int allowShop;
	private int allowOffice;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public Integer getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteUrl() {
		return siteUrl;
	}
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getAllowReg() {
		return allowReg;
	}
	public void setAllowReg(Integer allowReg) {
		this.allowReg = allowReg;
	}
	public Integer getAllowLogin() {
		return allowLogin;
	}
	public void setAllowLogin(Integer allowLogin) {
		this.allowLogin = allowLogin;
	}
	public Integer getAllowSell() {
		return allowSell;
	}
	public void setAllowSell(Integer allowSell) {
		this.allowSell = allowSell;
	}
	public Integer getAllowImport() {
		return allowImport;
	}
	public void setAllowImport(Integer allowImport) {
		this.allowImport = allowImport;
	}
	public Integer getAllowModifyPwd() {
		return allowModifyPwd;
	}
	public void setAllowModifyPwd(Integer allowModifyPwd) {
		this.allowModifyPwd = allowModifyPwd;
	}
	public Integer getAllowModifyUser() {
		return allowModifyUser;
	}
	public void setAllowModifyUser(Integer allowModifyUser) {
		this.allowModifyUser = allowModifyUser;
	}
	public Integer getAllowRefresh() {
		return allowRefresh;
	}
	public void setAllowRefresh(Integer allowRefresh) {
		this.allowRefresh = allowRefresh;
	}
	public Integer getAllowTimerRefresh() {
		return allowTimerRefresh;
	}
	public void setAllowTimerRefresh(Integer allowTimerRefresh) {
		this.allowTimerRefresh = allowTimerRefresh;
	}
	public Integer getAllowTj() {
		return allowTj;
	}
	public void setAllowTj(Integer allowTj) {
		this.allowTj = allowTj;
	}
	public Integer getAllowTimerTj() {
		return allowTimerTj;
	}
	public void setAllowTimerTj(Integer allowTimerTj) {
		this.allowTimerTj = allowTimerTj;
	}
	public Integer getAllowTop() {
		return allowTop;
	}
	public void setAllowTop(Integer allowTop) {
		this.allowTop = allowTop;
	}
	public Integer getAllowUpdate() {
		return allowUpdate;
	}
	public void setAllowUpdate(Integer allowUpdate) {
		this.allowUpdate = allowUpdate;
	}
	public Integer getAllowDelete() {
		return allowDelete;
	}
	public void setAllowDelete(Integer allowDelete) {
		this.allowDelete = allowDelete;
	}
	public Integer getSiteLoginType() {
		return siteLoginType;
	}
	public void setSiteLoginType(Integer siteLoginType) {
		this.siteLoginType = siteLoginType;
	}
	public Integer getSiteImageType() {
		return siteImageType;
	}
	public void setSiteImageType(Integer siteImageType) {
		this.siteImageType = siteImageType;
	}
	public Integer getSiteValidCodeType() {
		return siteValidCodeType;
	}
	public void setSiteValidCodeType(Integer siteValidCodeType) {
		this.siteValidCodeType = siteValidCodeType;
	}
	public Integer getSiteKc() {
		return siteKc;
	}
	public void setSiteKc(Integer siteKc) {
		this.siteKc = siteKc;
	}
	public Integer getSiteChangeCity() {
		return siteChangeCity;
	}
	public void setSiteChangeCity(Integer siteChangeCity) {
		this.siteChangeCity = siteChangeCity;
	}
	public Integer getParamUserType() {
		return paramUserType;
	}
	public void setParamUserType(Integer paramUserType) {
		this.paramUserType = paramUserType;
	}
	public Integer getParamSubjectType() {
		return paramSubjectType;
	}
	public void setParamSubjectType(Integer paramSubjectType) {
		this.paramSubjectType = paramSubjectType;
	}
	public Integer getSitePublishType() {
		return sitePublishType;
	}
	public void setSitePublishType(Integer sitePublishType) {
		this.sitePublishType = sitePublishType;
	}
	public String getSiteLogo() {
		return siteLogo;
	}
	public void setSiteLogo(String siteLogo) {
		this.siteLogo = siteLogo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getNameFullEn() {
		return nameFullEn;
	}
	public void setNameFullEn(String nameFullEn) {
		this.nameFullEn = nameFullEn;
	}
	public String getNameSimpleEn() {
		return nameSimpleEn;
	}
	public void setNameSimpleEn(String nameSimpleEn) {
		this.nameSimpleEn = nameSimpleEn;
	}
	public Integer getCityCode() {
		return cityCode;
	}
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getCityStatus() {
		return cityStatus;
	}
	public void setCityStatus(Integer cityStatus) {
		this.cityStatus = cityStatus;
	}
	public String getEsfUrl() {
		return esfUrl;
	}
	public void setEsfUrl(String esfUrl) {
		this.esfUrl = esfUrl;
	}
	public String getSpUrl() {
		return spUrl;
	}
	public void setSpUrl(String spUrl) {
		this.spUrl = spUrl;
	}
	public String getBsUrl() {
		return bsUrl;
	}
	public void setBsUrl(String bsUrl) {
		this.bsUrl = bsUrl;
	}
	public String getXzlUrl() {
		return xzlUrl;
	}
	public void setXzlUrl(String xzlUrl) {
		this.xzlUrl = xzlUrl;
	}
	public String getCfckUrl() {
		return cfckUrl;
	}
	public void setCfckUrl(String cfckUrl) {
		this.cfckUrl = cfckUrl;
	}
	public int getForbidType() {
		return forbidType;
	}
	public void setForbidType(int forbidType) {
		this.forbidType = forbidType;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getSiteRemark() {
		return siteRemark;
	}
	public void setSiteRemark(String siteRemark) {
		this.siteRemark = siteRemark;
	}
	public int getLoginType() {
		return loginType;
	}
	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}
	public Integer getVisible() {
		return visible;
	}
	public void setVisible(Integer visible) {
		this.visible = visible;
	}
	public String getCitySiteRemark() {
		return citySiteRemark;
	}
	public void setCitySiteRemark(String citySiteRemark) {
		this.citySiteRemark = citySiteRemark;
	}
	public int getAllowResidence() {
		return allowResidence;
	}
	public void setAllowResidence(int allowResidence) {
		this.allowResidence = allowResidence;
	}
	public int getAllowVilla() {
		return allowVilla;
	}
	public void setAllowVilla(int allowVilla) {
		this.allowVilla = allowVilla;
	}
	public int getAllowShop() {
		return allowShop;
	}
	public void setAllowShop(int allowShop) {
		this.allowShop = allowShop;
	}
	public int getAllowOffice() {
		return allowOffice;
	}
	public void setAllowOffice(int allowOffice) {
		this.allowOffice = allowOffice;
	}
	
	public Integer getAllowServer() {
		return allowServer;
	}
	public void setAllowServer(Integer allowServer) {
		this.allowServer = allowServer;
	}
	
	
}
