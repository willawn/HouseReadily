package com.huzhiyi.housereadily.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.UserExt;
import com.huzhiyi.utils.AuthHelper;
import com.huzhiyi.utils.ContextHelper;
import com.huzhiyi.utils.StringUtil;
import com.tastysoft.swct.db.model.TastyEntity;
import com.tastysoft.swct.util.DateHelper;
import com.tastysoft.swct.util.MD5;



public class CUser extends TastyEntity {

	private Integer id;

	private String name;
	
	private String realname;
	
	private String passwd;

	private String email;

	private Integer status;

	private String descn;
	
	private Date regDate;
	
	private String tel;
	private String mobile;
	private String address;
	private List houseReadilys = new ArrayList(0);
	private List houseOwners = new ArrayList(0);
	private List houseFollows = new ArrayList(0);
	public List getHouseReadilys() {
		return houseReadilys;
	}

	public void setHouseReadilys(List houseReadilys) {
		this.houseReadilys = houseReadilys;
	}

	public List getHouseOwners() {
		return houseOwners;
	}

	public void setHouseOwners(List houseOwners) {
		this.houseOwners = houseOwners;
	}

	public List getHouseFollows() {
		return houseFollows;
	}

	public void setHouseFollows(List houseFollows) {
		this.houseFollows = houseFollows;
	}

	private String companyName;
	private String companyShortName;
	private int cityCode;
	private int bigAreaCode;
	private int smallAreaCode;
	
	private Integer sex;
	private String phoneZone;
	private String qq;
	private String msn;
	private String pid;
	
	private String companyUrl;
	private Integer workYear;
	private Date workDate;
	private String postCode;
	private String project;
	private String agentPass;
	private String faxZone;
	private String fax;
	
	private Date foundDate;
	private Date birthDate;
	private String jobTitle;
	private String department;
	
	private Integer groupId;
	
	private Date vipExpireTime;
	private Date lastLoginTime;
	private Integer totalLoginCount;
	private Integer dayLoginCount;
	private Integer dayJifen;
	private Integer totalJifen;
	private Double money;
	private Integer credit;
	
	private String realFirstName;
	private String realLastName;
	private String question;
	private String answer;
	
	private String licenseNo;
	private String certificateNo;
	private String registrationNo;
	private Integer birthProvinceCode;
	private Integer birthCityCode;
	private Integer birthAreaCode;
	private String school;
	
	private String recommend;
	
	private Integer wsProcessOk;
	private Integer wsProcessCur;
	private Integer wsProcessIndex;
	
	private String companyDescn;
	private String companyAddress;
	
	private Integer Cid;
	
	private String verify;
	
	private int websitesCount;
	
	private int tjJifen;
	private int tjLevel;
	private int tjPublishCount;
	private int recommendType;
	private int vipType;
	private Date vipStartTime;
	private Date lastPublishTime;
	
	private String topRecommend;
	
	private String extendStr;
	
	private Date lastMsgTime;
	
	private int smsCount;
	
	private int userType;
	
	private String smsPwd;
	
	private Integer paymentId;
	private Date paymentExpireTime;
	
	private Date trialSpTime;
	private Integer trialSpDays;
	private Integer internetServer;
	private String usersZone; 
	private int active; 
	
	private Integer regSource;
	private UserExt userExt;
	private Integer isComplete;
	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Integer getInternetServer() {
		return internetServer;
	}

	public void setInternetServer(Integer internetServer) {
		this.internetServer = internetServer;
	}

	public String getUsersZone() {
		return usersZone;
	}

	public void setUsersZone(String usersZone) {
		this.usersZone = usersZone;
	}

	public Integer getId() {
		return this.id;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public Integer getStatus() {
		return this.status;
	}

	public String getDescn() {
		return descn;
	}
	
	public boolean isEnabled() {
		if(status==0)
			return false;
		else
			return true;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCityCode() {
		return cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public int getBigAreaCode() {
		return bigAreaCode;
	}

	public void setBigAreaCode(int bigAreaCode) {
		this.bigAreaCode = bigAreaCode;
	}

	public int getSmallAreaCode() {
		return smallAreaCode;
	}

	public void setSmallAreaCode(int smallAreaCode) {
		this.smallAreaCode = smallAreaCode;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhoneZone() {
		return phoneZone;
	}

	public void setPhoneZone(String phoneZone) {
		this.phoneZone = phoneZone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getCompanyUrl() {
		return companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public Integer getWorkYear() {
		return workYear;
	}

	public void setWorkYear(Integer workYear) {
		this.workYear = workYear;
	}
	
	

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getAgentPass() {
		return agentPass;
	}

	public void setAgentPass(String agentPass) {
		this.agentPass = agentPass;
	}

	public String getFaxZone() {
		return faxZone;
	}

	public void setFaxZone(String faxZone) {
		this.faxZone = faxZone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return ContextHelper.getGroupName(groupId);
	}


	public String getStatusName() {
		return ContextHelper.getStatusName(status);
	}
	
	public String getFoundDateStr(){
		return DateHelper.dateToString(foundDate);
	}
	
	public String getBirthDateStr(){
		return DateHelper.dateToString(birthDate);
	}
	
	public String getWorkDateStr(){
		return DateHelper.dateToString(workDate);
	}
	
	public Date getVipExpireTime() {
		return vipExpireTime;
	}

	public void setVipExpireTime(Date vipExpireTime) {
		this.vipExpireTime = vipExpireTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Integer getTotalLoginCount() {
		return totalLoginCount;
	}

	public void setTotalLoginCount(Integer totalLoginCount) {
		this.totalLoginCount = totalLoginCount;
	}

	public Integer getDayLoginCount() {
		return dayLoginCount;
	}

	public void setDayLoginCount(Integer dayLoginCount) {
		this.dayLoginCount = dayLoginCount;
	}

	public Integer getDayJifen() {
		return dayJifen;
	}

	public void setDayJifen(Integer dayJifen) {
		this.dayJifen = dayJifen;
	}

	public Integer getTotalJifen() {
		return totalJifen;
	}

	public void setTotalJifen(Integer totalJifen) {
		this.totalJifen = totalJifen;
	}
	
	public String getMoneyStr(){
		return StringUtil.getDoubleValue(money);
	}
	
	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Date getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRealFirstName() {
		return realFirstName;
	}

	public void setRealFirstName(String realFirstName) {
		this.realFirstName = realFirstName;
	}

	public String getRealLastName() {
		return realLastName;
	}

	public void setRealLastName(String realLastName) {
		this.realLastName = realLastName;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCompanyShortName() {
		return companyShortName;
	}

	public void setCompanyShortName(String companyShortName) {
		this.companyShortName = companyShortName;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Integer getBirthProvinceCode() {
		return birthProvinceCode;
	}

	public void setBirthProvinceCode(Integer birthProvinceCode) {
		this.birthProvinceCode = birthProvinceCode;
	}

	public Integer getBirthCityCode() {
		return birthCityCode;
	}

	public void setBirthCityCode(Integer birthCityCode) {
		this.birthCityCode = birthCityCode;
	}

	public Integer getBirthAreaCode() {
		return birthAreaCode;
	}

	public void setBirthAreaCode(Integer birthAreaCode) {
		this.birthAreaCode = birthAreaCode;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public Integer getWsProcessOk() {
		return wsProcessOk;
	}

	public void setWsProcessOk(Integer wsProcessOk) {
		this.wsProcessOk = wsProcessOk;
	}

	public Integer getWsProcessCur() {
		return wsProcessCur;
	}

	public void setWsProcessCur(Integer wsProcessCur) {
		this.wsProcessCur = wsProcessCur;
	}

	public String getCompanyDescn() {
		return companyDescn;
	}

	public void setCompanyDescn(String companyDescn) {
		this.companyDescn = companyDescn;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public Integer getCid() {
		return Cid;
	}

	public void setCid(Integer cid) {
		Cid = cid;
	}
	
	public String getVerify(){
		String sVerify = AuthHelper.md5Key+name;
		sVerify = MD5.getMD5(sVerify.getBytes());
		return sVerify;
	}
	
	public String getRegDateStr(){
		return DateHelper.dateToString(regDate);
	}
	
	public String getLastLoginTimeStr(){
		return DateHelper.dateToString(lastLoginTime);
	}
	
	public String getVipExpireTimeStr(){
		return DateHelper.dateToString(vipExpireTime);
	}

	public String getCityCodeName() {
		return ContextHelper.getAreaName(cityCode);
	}

	public String getBigAreaCodeName() {
		return ContextHelper.getAreaName(bigAreaCode);
	}

	public String getSmallAreaCodeName() {
		return ContextHelper.getAreaName(smallAreaCode);
	}

	public Integer getWsProcessIndex() {
		return wsProcessIndex;
	}

	public void setWsProcessIndex(Integer wsProcessIndex) {
		this.wsProcessIndex = wsProcessIndex;
	}

	public int getWebsitesCount() {
		return websitesCount;
	}

	public void setWebsitesCount(int websitesCount) {
		this.websitesCount = websitesCount;
	}

	public boolean isVipOk() {
		if(groupId==99){
			return true;
		}
		Date dt = new Date();
		if(vipExpireTime!=null){
			if(vipExpireTime.after(dt)){
				return true;
			}else{
				return false;
			}
		}else{
			return true;
		}
	}
	
	public boolean isInTrivalVip(){
		if(groupId==99){
			return false;
		}
		Date dt = new Date();
		if(vipStartTime!=null){
			int freeDays = 7;//ContextHelper.getFreeDays(groupId);
			Date vDate = null;
			if(this.getCityCode()==900003)
				vDate = DateHelper.getDate(vipStartTime, freeDays);
			else
				vDate = DateHelper.getMonth(vipStartTime, 2);
			if(vDate.after(dt)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public boolean isFreeDaysOn(){
		return true;
	}
	
	public int getTjJifen() {
		return tjJifen;
	}

	public void setTjJifen(int tjJifen) {
		this.tjJifen = tjJifen;
	}

	public int getTjLevel() {
		return tjLevel;
	}

	public void setTjLevel(int tjLevel) {
		this.tjLevel = tjLevel;
	}

	public int getTjPublishCount() {
		return tjPublishCount;
	}

	public void setTjPublishCount(int tjPublishCount) {
		this.tjPublishCount = tjPublishCount;
	}

	public int getRecommendType() {
		return recommendType;
	}

	public void setRecommendType(int recommendType) {
		this.recommendType = recommendType;
	}

	public int getVipType() {
		return vipType;
	}

	public void setVipType(int vipType) {
		this.vipType = vipType;
	}

	public Date getVipStartTime() {
		return vipStartTime;
	}

	public void setVipStartTime(Date vipStartTime) {
		this.vipStartTime = vipStartTime;
	}

	public Date getLastPublishTime() {
		return lastPublishTime;
	}

	public void setLastPublishTime(Date lastPublishTime) {
		this.lastPublishTime = lastPublishTime;
	}
	
	public int getGold(){
		int gold = (this.tjJifen-this.tjJifen%1000)/1000;
		return gold;
	}
	
	public int getGrey(){
		int jifen = this.tjJifen%1000;
		int grey = (jifen-jifen%100)/100;
		return grey;	
	}
	
	public int getStar(){
		int jifen = this.tjJifen%100;
		int star = (jifen-jifen%10)/10;
		return star;
	}
	
	public String getTjjfDesc(){
		/*int gold = getGold();
		int grey = getGrey();
		int star = getStar();
		StringBuilder sb = new StringBuilder();
		if(gold>0)
			sb.append(gold+"金钻");
		if(grey>0)
			sb.append(grey+"银钻");
		if(star>0)
			sb.append(star+"金星");
		if(sb.toString().length()==0)
			sb.append("0金星");*/
		return String.valueOf(tjJifen);
	}
	
	public int getVipNoticeType(){
		//1 试用期快到期
		//2 付费用户快到期
		//3 提示录入房源后将开启7天免费试用
		Date dt = new Date();
		int result = 0 ;
		if(this.groupId==99)
			return result;
		if(vipExpireTime!=null){
			int freeDays = 7;//ContextHelper.getFreeDays(groupId);
			Date tDate = null;
			if(this.getCityCode()==900003)
				tDate = DateHelper.getDate(dt, freeDays);
			else
				tDate = DateHelper.getMonth(dt, 2);
			
			if(isInTrivalVip()){
				if(tDate.after(this.vipExpireTime)){
					result = 1;
				}
			}else{
				if(tDate.after(this.vipExpireTime)){
					result = 2;
				}
			}
		}else{
			result = 3;
		}
		
		return result;
	}
	
	public int getVipNoticeDay(){
		int result = 0 ;
		result = DateHelper.getDateInternal(new Date(),vipExpireTime);
		return result;
	}

	public String getTopRecommend() {
		return topRecommend;
	}

	public void setTopRecommend(String topRecommend) {
		this.topRecommend = topRecommend;
	}
	
	public boolean isCanSpDcwq(){
		if(this.trialSpTime==null){
			return true;
		}else
			return false;
	}
	public String getExtendStr() {
		if(extendStr==null)
			extendStr="";
		return extendStr;
	}

	public void setExtendStr(String extendStr) {
		this.extendStr = extendStr;
	}
	
	public String getExtendStrDcwq2(){
		return StringUtil.getSplitStr(getExtendStrSplit(),2);
	}
	
	public String[] getExtendStrSplit(){
		return getExtendStr().split(",");
	}
	
	public void setExtendStrSplit(String[] strSplit ){
		this.extendStr = StringUtil.getStr(strSplit,",");
	}
	
	public Date getLastMsgTime() {
		return lastMsgTime;
	}

	public void setLastMsgTime(Date lastMsgTime) {
		this.lastMsgTime = lastMsgTime;
	}

	public int getSmsCount() {
		return smsCount;
	}

	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
	}
	
	public int getSmsTotalCount(){
		//int moneySmsCount = (int)(money/0.1);
		return /*moneySmsCount+*/ smsCount;
	}
	
	public String getSmsEnd(){
		return " "+this.getRealname()+this.getMobile();
	}
	
	public int getSmsEndCount(){
		return getSmsEnd().length();
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	
	public boolean isCxEnd(){
		Date dt = DateHelper.stringToDate("2011-02-01 00:00:00");
		Date tnow = new Date();
		if(tnow.after(dt)){
			return true;
		}
		return false;
	}
	
	public boolean isNoticeEnd(){
		Date dt = DateHelper.stringToDate("2011-02-09 00:00:00");
		Date tnow = new Date();
		if(tnow.after(dt)){
			return true;
		}
		return false;
	}

	public String getSmsPwd() {
		if(smsPwd==null)
			return "";
		return smsPwd;
	}

	public void setSmsPwd(String smsPwd) {
		this.smsPwd = smsPwd;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Date getPaymentExpireTime() {
		return paymentExpireTime;
	}

	public void setPaymentExpireTime(Date paymentExpireTime) {
		this.paymentExpireTime = paymentExpireTime;
	}

	public Date getTrialSpTime() {
		return trialSpTime;
	}

	public void setTrialSpTime(Date trialSpTime) {
		this.trialSpTime = trialSpTime;
	}

	public Integer getTrialSpDays() {
		return trialSpDays;
	}

	public void setTrialSpDays(Integer trialSpDays) {
		this.trialSpDays = trialSpDays;
	}
	
	public int getNeedWsCount(){
		int count = 0 ;
		if(this.getCompanyAddress()==null||this.getCompanyAddress().length()==0)count++;
		if(this.getPid()==null||this.getPid().length()==0)count++;
		if(this.getSex()==null)count++;
		if(this.getRealname()==null||this.getRealname().length()==0)count++;
		if(this.getCompanyName()==null||this.getCompanyName().length()==0)count++;
		if(this.getCompanyShortName()==null||this.getCompanyShortName().length()==0)count++;
		if(this.getFoundDateStr()==null||this.getFoundDateStr().length()==0)count++;
		if(this.getCompanyDescn()==null||this.getCompanyDescn().length()==0)count++;
		if(this.getTel()==null||this.getTel().length()==0)count++;
		if(this.getJobTitle()==null||this.getJobTitle().length()==0)count++;
		if(this.getDepartment()==null||this.getDepartment().length()==0)count++;
		if(this.getAddress()==null||this.getAddress().length()==0)count++;
		if(this.getEmail()==null||this.getEmail().length()==0)count++;
		if(this.getMobile()==null||this.getMobile().length()==0)count++;
		return count;
	}

	public Integer getRegSource() {
		return regSource;
	}

	public void setRegSource(Integer regSource) {
		this.regSource = regSource;
	}

	public UserExt getUserExt() {
		return userExt;
	}

	public void setUserExt(UserExt userExt) {
		this.userExt = userExt;
	}

	public Integer getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}

	private Integer houseReadilyCount;
	private Integer customerCount;
	private Integer level;
	private Integer growing;
	private Integer integration;
	private String avatar;
	private String cityEn;
	private String cityName;

	public Integer getHouseReadilyCount() {
		return houseReadilyCount;
	}

	public void setHouseReadilyCount(Integer houseReadilyCount) {
		this.houseReadilyCount = houseReadilyCount;
	}

	public Integer getCustomerCount() {
		return customerCount;
	}

	public void setCustomerCount(Integer customerCount) {
		this.customerCount = customerCount;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getGrowing() {
		return growing;
	}

	public void setGrowing(Integer growing) {
		this.growing = growing;
	}

	public Integer getIntegration() {
		return integration;
	}

	public void setIntegration(Integer integration) {
		this.integration = integration;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getCityEn() {
		return ContextHelper.cityEnNames.get(getCityCode());
	}

	public void setCityEn(String cityEn) {
		this.cityEn = cityEn;
	}

	public String getCityName() {
		return ContextHelper.allareas.get(getCityCode());
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
