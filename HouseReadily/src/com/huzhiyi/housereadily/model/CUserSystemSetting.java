package com.huzhiyi.housereadily.model;

import java.io.Serializable;
import java.util.Date;

import com.tastysoft.swct.db.model.TastyEntity;

public class CUserSystemSetting  extends TastyEntity {
	private Integer id;
	private Integer userId;
	private Integer runMode;
	private Integer maxThread;
	private Integer timeOut;
	private Integer hightPriority;
	private Integer needReadReceipt;
	
	private String mailDomain;
	private String mailServer;
	private Integer mailPort;
	private Integer mailNeedSSL;
	private String mailAddress;
	private String mailUserName;
	private String mailPassword;
	private Integer mailIsChecked;
	 
	private Integer proxy;
	private String proxyAddress;
	private Integer proxyPort;
	private String proxyUserName;
	private String proxyPassword;
	
	private Integer notShowVerifyCode;
	private Integer recoginzeTimeout;
	private Integer notShowRecognized;
	private String regName;
	private String regPwd;
	private String regEmail;
	private String regMobile;
	private Integer arrowRenewAccount;
	private Integer arrowCheckAccount;
	private Integer arrowRndAccount;
	private Integer arrowRndEmail;
	private Integer arrowRndMobile;
	
	private String regTel;
	private Integer arrowRndTel;
	
	private Integer arrowAutoDelete;
	private Integer serverType;
	
	public Integer getServerType() {
		return serverType;
	}
	public void setServerType(Integer serverType) {
		this.serverType = serverType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRunMode() {
		return runMode;
	}
	public void setRunMode(Integer runMode) {
		this.runMode = runMode;
	}
	public Integer getMaxThread() {
		return maxThread;
	}
	public void setMaxThread(Integer maxThread) {
		this.maxThread = maxThread;
	}
	public Integer getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}
	public Integer getHightPriority() {
		return hightPriority;
	}
	public void setHightPriority(Integer hightPriority) {
		this.hightPriority = hightPriority;
	}
	public Integer getNeedReadReceipt() {
		return needReadReceipt;
	}
	public void setNeedReadReceipt(Integer needReadReceipt) {
		this.needReadReceipt = needReadReceipt;
	}
	public String getMailDomain() {
		return mailDomain;
	}
	public void setMailDomain(String mailDomain) {
		this.mailDomain = mailDomain;
	}
	public String getMailServer() {
		return mailServer;
	}
	public void setMailServer(String mailServer) {
		this.mailServer = mailServer;
	}
	public Integer getMailPort() {
		return mailPort;
	}
	public void setMailPort(Integer mailPort) {
		this.mailPort = mailPort;
	}
	public Integer getMailNeedSSL() {
		return mailNeedSSL;
	}
	public void setMailNeedSSL(Integer mailNeedSSL) {
		this.mailNeedSSL = mailNeedSSL;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getMailUserName() {
		return mailUserName;
	}
	public void setMailUserName(String mailUserName) {
		this.mailUserName = mailUserName;
	}
	public String getMailPassword() {
		return mailPassword;
	}
	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}
	public Integer getMailIsChecked() {
		return mailIsChecked;
	}
	public void setMailIsChecked(Integer mailIsChecked) {
		this.mailIsChecked = mailIsChecked;
	}
	public Integer getProxy() {
		return proxy;
	}
	public void setProxy(Integer proxy) {
		this.proxy = proxy;
	}
	public String getProxyAddress() {
		return proxyAddress;
	}
	public void setProxyAddress(String proxyAddress) {
		this.proxyAddress = proxyAddress;
	}
	public Integer getProxyPort() {
		return proxyPort;
	}
	public void setProxyPort(Integer proxyPort) {
		this.proxyPort = proxyPort;
	}
	public String getProxyUserName() {
		return proxyUserName;
	}
	public void setProxyUserName(String proxyUserName) {
		this.proxyUserName = proxyUserName;
	}
	public String getProxyPassword() {
		return proxyPassword;
	}
	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}
	public Integer getNotShowVerifyCode() {
		return notShowVerifyCode;
	}
	public void setNotShowVerifyCode(Integer notShowVerifyCode) {
		this.notShowVerifyCode = notShowVerifyCode;
	}
	public Integer getRecoginzeTimeout() {
		return recoginzeTimeout;
	}
	public void setRecoginzeTimeout(Integer recoginzeTimeout) {
		this.recoginzeTimeout = recoginzeTimeout;
	}
	public Integer getNotShowRecognized() {
		return notShowRecognized;
	}
	public void setNotShowRecognized(Integer notShowRecognized) {
		this.notShowRecognized = notShowRecognized;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getRegPwd() {
		return regPwd;
	}
	public void setRegPwd(String regPwd) {
		this.regPwd = regPwd;
	}
	public String getRegEmail() {
		return regEmail;
	}
	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}
	public String getRegMobile() {
		return regMobile;
	}
	public void setRegMobile(String regMobile) {
		this.regMobile = regMobile;
	}
	public Integer getArrowRenewAccount() {
		return arrowRenewAccount;
	}
	public void setArrowRenewAccount(Integer arrowRenewAccount) {
		this.arrowRenewAccount = arrowRenewAccount;
	}
	public Integer getArrowCheckAccount() {
		return arrowCheckAccount;
	}
	public void setArrowCheckAccount(Integer arrowCheckAccount) {
		this.arrowCheckAccount = arrowCheckAccount;
	}
	public Integer getArrowRndAccount() {
		return arrowRndAccount;
	}
	public void setArrowRndAccount(Integer arrowRndAccount) {
		this.arrowRndAccount = arrowRndAccount;
	}
	public Integer getArrowRndEmail() {
		return arrowRndEmail;
	}
	public void setArrowRndEmail(Integer arrowRndEmail) {
		this.arrowRndEmail = arrowRndEmail;
	}
	public Integer getArrowRndMobile() {
		return arrowRndMobile;
	}
	public void setArrowRndMobile(Integer arrowRndMobile) {
		this.arrowRndMobile = arrowRndMobile;
	}
	public String getRegTel() {
		return regTel;
	}
	public void setRegTel(String regTel) {
		this.regTel = regTel;
	}
	public Integer getArrowRndTel() {
		return arrowRndTel;
	}
	public void setArrowRndTel(Integer arrowRndTel) {
		this.arrowRndTel = arrowRndTel;
	}
	public Integer getArrowAutoDelete() {
		return arrowAutoDelete;
	}
	public void setArrowAutoDelete(Integer arrowAutoDelete) {
		this.arrowAutoDelete = arrowAutoDelete;
	}
	
	
	
	
}
