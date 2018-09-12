package com.huzhiyi.housereadily.model;

import java.util.Date;

import com.tastysoft.swct.db.model.TastyEntity;

public class CUserCredit  extends TastyEntity {
	private Integer id;
	private Integer userId;
	private String pidImage;
	private Date pidSubmitTime;
	private Date pidCheckTime;
	private Integer pidStatus;
	private String pidStatusName;
	private String pidRemark;
	private String personImage;
	private Date personSubmitTime;
	private Date personCheckTime;
	private Integer personStatus;
	private String personStatusName;
	private String personRemark;
	private String agentImage;
	private Date agentSubmitTime;
	private Date agentCheckTime;
	private Integer agentStatus;
	private String agentStatusName;
	private String agentRemark;
	private String ncardImage;
	private Date ncardSubmitTime;
	private Date ncardCheckTime;
	private Integer ncardStatus;
	private String ncardStatusName;
	private String ncardRemark;
	
	private String companyLogoImage;
	private Date companyLogoSubmitTime;
	private Date companyLogoCheckTime;
	private Integer companyLogoStatus;
	private String companyLogoStatusName;
	private String companyLogoRemark;
	
	private String companyLicenseImage;
	private Date companyLicenseSubmitTime;
	private Date companyLicenseCheckTime;
	private Integer companyLicenseStatus;
	private String companyLicenseStatusName;
	private String companyLicenseRemark;
	
	private String companyCertificateImage;
	private Date companyCertificateSubmitTime;
	private Date companyCertificateCheckTime;
	private Integer companyCertificateStatus;
	private String companyCertificateStatusName;
	private String companyCertificateRemark;
	
	private String companyRegistrationImage;
	private Date companyRegistrationSubmitTime;
	private Date companyRegistrationCheckTime;
	private Integer companyRegistrationStatus;
	private String companyRegistrationStatusName;
	private String companyRegistrationRemark;
	
	
	private String pidBackImage;
	private Date pidBackSubmitTime;
	private Date pidBackCheckTime;
	private Integer pidBackStatus;
	private String pidBackStatusName;
	private String pidBackRemark;
	private int imageServer; 
	
	
	public int getImageServer() {
		return imageServer;
	}
	public void setImageServer(int imageServer) {
		this.imageServer = imageServer;
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
	public String getPidImage() {
		return pidImage;
	}
	public void setPidImage(String pidImage) {
		this.pidImage = pidImage;
	}
	public Date getPidSubmitTime() {
		return pidSubmitTime;
	}
	public void setPidSubmitTime(Date pidSubmitTime) {
		this.pidSubmitTime = pidSubmitTime;
	}
	public Date getPidCheckTime() {
		return pidCheckTime;
	}
	public void setPidCheckTime(Date pidCheckTime) {
		this.pidCheckTime = pidCheckTime;
	}
	public Integer getPidStatus() {
		return pidStatus;
	}
	public void setPidStatus(Integer pidStatus) {
		this.pidStatus = pidStatus;
	}
	public String getPersonImage() {
		return personImage;
	}
	public void setPersonImage(String personImage) {
		this.personImage = personImage;
	}
	public Date getPersonSubmitTime() {
		return personSubmitTime;
	}
	public void setPersonSubmitTime(Date personSubmitTime) {
		this.personSubmitTime = personSubmitTime;
	}
	public Date getPersonCheckTime() {
		return personCheckTime;
	}
	public void setPersonCheckTime(Date personCheckTime) {
		this.personCheckTime = personCheckTime;
	}
	public Integer getPersonStatus() {
		return personStatus;
	}
	public void setPersonStatus(Integer personStatus) {
		this.personStatus = personStatus;
	}
	public String getAgentImage() {
		return agentImage;
	}
	public void setAgentImage(String agentImage) {
		this.agentImage = agentImage;
	}
	public Date getAgentSubmitTime() {
		return agentSubmitTime;
	}
	public void setAgentSubmitTime(Date agentSubmitTime) {
		this.agentSubmitTime = agentSubmitTime;
	}
	public Date getAgentCheckTime() {
		return agentCheckTime;
	}
	public void setAgentCheckTime(Date agentCheckTime) {
		this.agentCheckTime = agentCheckTime;
	}
	public Integer getAgentStatus() {
		return agentStatus;
	}
	public void setAgentStatus(Integer agentStatus) {
		this.agentStatus = agentStatus;
	}
	public String getNcardImage() {
		return ncardImage;
	}
	public void setNcardImage(String ncardImage) {
		this.ncardImage = ncardImage;
	}
	public Date getNcardSubmitTime() {
		return ncardSubmitTime;
	}
	public void setNcardSubmitTime(Date ncardSubmitTime) {
		this.ncardSubmitTime = ncardSubmitTime;
	}
	public Date getNcardCheckTime() {
		return ncardCheckTime;
	}
	public void setNcardCheckTime(Date ncardCheckTime) {
		this.ncardCheckTime = ncardCheckTime;
	}
	public Integer getNcardStatus() {
		return ncardStatus;
	}
	public void setNcardStatus(Integer ncardStatus) {
		this.ncardStatus = ncardStatus;
	}
	public String getPidRemark() {
		return pidRemark;
	}
	public void setPidRemark(String pidRemark) {
		this.pidRemark = pidRemark;
	}
	public String getPersonRemark() {
		return personRemark;
	}
	public void setPersonRemark(String personRemark) {
		this.personRemark = personRemark;
	}
	public String getAgentRemark() {
		return agentRemark;
	}
	public void setAgentRemark(String agentRemark) {
		this.agentRemark = agentRemark;
	}
	public String getNcardRemark() {
		return ncardRemark;
	}
	public void setNcardRemark(String ncardRemark) {
		this.ncardRemark = ncardRemark;
	}
	/*public String getPidStatusName() {
		return ContextHelper.getCreditCheckTypeName(pidStatus);
	}
	public String getPersonStatusName() {
		return ContextHelper.getCreditCheckTypeName(personStatus);
	}
	public String getAgentStatusName() {
		return ContextHelper.getCreditCheckTypeName(agentStatus);
	}
	public String getNcardStatusName() {
		return ContextHelper.getCreditCheckTypeName(ncardStatus);
	}*/
	public String getCompanyLogoImage() {
		return companyLogoImage;
	}
	public void setCompanyLogoImage(String companyLogoImage) {
		this.companyLogoImage = companyLogoImage;
	}
	public Date getCompanyLogoSubmitTime() {
		return companyLogoSubmitTime;
	}
	public void setCompanyLogoSubmitTime(Date companyLogoSubmitTime) {
		this.companyLogoSubmitTime = companyLogoSubmitTime;
	}
	public Date getCompanyLogoCheckTime() {
		return companyLogoCheckTime;
	}
	public void setCompanyLogoCheckTime(Date companyLogoCheckTime) {
		this.companyLogoCheckTime = companyLogoCheckTime;
	}
	public Integer getCompanyLogoStatus() {
		return companyLogoStatus;
	}
	public void setCompanyLogoStatus(Integer companyLogoStatus) {
		this.companyLogoStatus = companyLogoStatus;
	}
	public String getCompanyLogoRemark() {
		return companyLogoRemark;
	}
	public void setCompanyLogoRemark(String companyLogoRemark) {
		this.companyLogoRemark = companyLogoRemark;
	}
	public String getCompanyLicenseImage() {
		return companyLicenseImage;
	}
	public void setCompanyLicenseImage(String companyLicenseImage) {
		this.companyLicenseImage = companyLicenseImage;
	}
	public Date getCompanyLicenseSubmitTime() {
		return companyLicenseSubmitTime;
	}
	public void setCompanyLicenseSubmitTime(Date companyLicenseSubmitTime) {
		this.companyLicenseSubmitTime = companyLicenseSubmitTime;
	}
	public Date getCompanyLicenseCheckTime() {
		return companyLicenseCheckTime;
	}
	public void setCompanyLicenseCheckTime(Date companyLicenseCheckTime) {
		this.companyLicenseCheckTime = companyLicenseCheckTime;
	}
	public Integer getCompanyLicenseStatus() {
		return companyLicenseStatus;
	}
	public void setCompanyLicenseStatus(Integer companyLicenseStatus) {
		this.companyLicenseStatus = companyLicenseStatus;
	}
	public String getCompanyLicenseRemark() {
		return companyLicenseRemark;
	}
	public void setCompanyLicenseRemark(String companyLicenseRemark) {
		this.companyLicenseRemark = companyLicenseRemark;
	}
	public String getCompanyCertificateImage() {
		return companyCertificateImage;
	}
	public void setCompanyCertificateImage(String companyCertificateImage) {
		this.companyCertificateImage = companyCertificateImage;
	}
	public Date getCompanyCertificateSubmitTime() {
		return companyCertificateSubmitTime;
	}
	public void setCompanyCertificateSubmitTime(Date companyCertificateSubmitTime) {
		this.companyCertificateSubmitTime = companyCertificateSubmitTime;
	}
	public Date getCompanyCertificateCheckTime() {
		return companyCertificateCheckTime;
	}
	public void setCompanyCertificateCheckTime(Date companyCertificateCheckTime) {
		this.companyCertificateCheckTime = companyCertificateCheckTime;
	}
	public Integer getCompanyCertificateStatus() {
		return companyCertificateStatus;
	}
	public void setCompanyCertificateStatus(Integer companyCertificateStatus) {
		this.companyCertificateStatus = companyCertificateStatus;
	}
	public String getCompanyCertificateRemark() {
		return companyCertificateRemark;
	}
	public void setCompanyCertificateRemark(String companyCertificateRemark) {
		this.companyCertificateRemark = companyCertificateRemark;
	}
	public String getCompanyRegistrationImage() {
		return companyRegistrationImage;
	}
	public void setCompanyRegistrationImage(String companyRegistrationImage) {
		this.companyRegistrationImage = companyRegistrationImage;
	}
	public Date getCompanyRegistrationSubmitTime() {
		return companyRegistrationSubmitTime;
	}
	public void setCompanyRegistrationSubmitTime(Date companyRegistrationSubmitTime) {
		this.companyRegistrationSubmitTime = companyRegistrationSubmitTime;
	}
	public Date getCompanyRegistrationCheckTime() {
		return companyRegistrationCheckTime;
	}
	public void setCompanyRegistrationCheckTime(Date companyRegistrationCheckTime) {
		this.companyRegistrationCheckTime = companyRegistrationCheckTime;
	}
	public Integer getCompanyRegistrationStatus() {
		return companyRegistrationStatus;
	}
	public void setCompanyRegistrationStatus(Integer companyRegistrationStatus) {
		this.companyRegistrationStatus = companyRegistrationStatus;
	}
	public String getCompanyRegistrationRemark() {
		return companyRegistrationRemark;
	}
	public void setCompanyRegistrationRemark(String companyRegistrationRemark) {
		this.companyRegistrationRemark = companyRegistrationRemark;
	}
	public String getCompanyLogoStatusName() {
		return companyLogoStatusName;
	}
	public String getCompanyLicenseStatusName() {
		return companyLicenseStatusName;
	}
	public String getCompanyCertificateStatusName() {
		return companyCertificateStatusName;
	}
	public String getCompanyRegistrationStatusName() {
		return companyRegistrationStatusName;
	}
	
	/*public String getCompanyRegistrationSImage() {
		String image  = companyRegistrationImage;
		if(image==null)
			image="";
		if(image!=null&&image.length()>0){
			image =  Configuration.imageHost+companyRegistrationImage;
		}
		return image;
	}
	
	public String getCompanyRegistrationBImage() {
		String image  = getCompanyRegistrationSImage();
		if(image.length()>0)
			image = StringUtil.replace(image, "s.", "b.");
		return image;
	}
	
	public String getCompanyCertificateSImage() {
		String image  = companyCertificateImage;
		if(image==null)
			image="";
		if(image!=null&&image.length()>0){
			image =  Configuration.imageHost+companyCertificateImage;
		}
		return image;
	}
	
	public String getCompanyCertificateBImage() {
		String image  = getCompanyCertificateSImage();
		if(image.length()>0)
			image = StringUtil.replace(image, "s.", "b.");
		return image;
	}
	
	public String getCompanyLicenseSImage() {
		String image  = companyLicenseImage;
		if(image==null)
			image="";
		if(image!=null&&image.length()>0){
			image =  Configuration.imageHost+companyLicenseImage;
		}
		return image;
	}
	
	public String getCompanyLicenseBImage() {
		String image  = getCompanyLicenseSImage();
		if(image.length()>0)
			image = StringUtil.replace(image, "s.", "b.");
		return image;
	}
	
	public String getCompanyLogoSImage() {
		String image  = companyLogoImage;
		if(image==null)
			image="";
		if(image!=null&&image.length()>0){
			image =  Configuration.imageHost+companyLogoImage;
		}
		return image;
	}
	
	public String getCompanyLogoBImage() {
		String image  = getCompanyLogoSImage();
		if(image.length()>0)
			image = StringUtil.replace(image, "s.", "b.");
		return image;
	}
	
	public String getAgentSImage() {
		String image  = agentImage;
		if(image==null)
			image="";
		if(image!=null&&image.length()>0){
			image =  Configuration.imageHost+agentImage;
		}
		return image;
	}
	
	public String getAgentBImage() {
		String image  = getAgentSImage();
		if(image.length()>0)
			image = StringUtil.replace(image, "s.", "b.");
		return image;
	}
	
	public String getPersonSImage() {
		String image  = personImage;
		if(image==null)
			image="";
		if(image!=null&&image.length()>0){
			image =  Configuration.imageHost+personImage;
		}
		return image;
	}
	
	public String getPersonBImage() {
		String image  = getPersonSImage();
		if(image.length()>0)
			image = StringUtil.replace(image, "s.", "b.");
		return image;
	}
	
	public String getPidSImage() {
		String image  = pidImage;
		if(image==null)
			image="";
		if(image!=null&&image.length()>0){
			image =  Configuration.imageHost+pidImage;
		}
		return image;
	}
	
	public String getPidBImage() {
		String image  = getPidSImage();
		if(image.length()>0)
			image = StringUtil.replace(image, "s.", "b.");
		return image;
	}
	
	public String getNcardSImage() {
		String image  = ncardImage;
		if(image==null)
			image="";
		if(image!=null&&image.length()>0){
			image =  Configuration.imageHost+ncardImage;
		}
		return image;
	}
	
	public String getNcardBImage() {
		String image  = getNcardSImage();
		if(image.length()>0)
			image = StringUtil.replace(image, "s.", "b.");
		return image;
	}
	
	public String getPidBackSImage() {
		String image  = pidBackImage;
		if(image==null)
			image="";
		if(image!=null&&image.length()>0){
			image =  Configuration.imageHost+pidBackImage;
		}
		return image;
	}
	
	public String getPidBackBImage() {
		String image  = getPidBackSImage();
		if(image.length()>0)
			image = StringUtil.replace(image, "s.", "b.");
		return image;
	}*/
	
	public String getPidBackImage() {
		return pidBackImage;
	}
	public void setPidBackImage(String pidBackImage) {
		this.pidBackImage = pidBackImage;
	}
	public Date getPidBackSubmitTime() {
		return pidBackSubmitTime;
	}
	public void setPidBackSubmitTime(Date pidBackSubmitTime) {
		this.pidBackSubmitTime = pidBackSubmitTime;
	}
	public Date getPidBackCheckTime() {
		return pidBackCheckTime;
	}
	public void setPidBackCheckTime(Date pidBackCheckTime) {
		this.pidBackCheckTime = pidBackCheckTime;
	}
	public Integer getPidBackStatus() {
		return pidBackStatus;
	}
	public void setPidBackStatus(Integer pidBackStatus) {
		this.pidBackStatus = pidBackStatus;
	}
	public String getPidBackRemark() {
		return pidBackRemark;
	}
	public void setPidBackRemark(String pidBackRemark) {
		this.pidBackRemark = pidBackRemark;
	}
	
	
	public int getCreditWsStatus(){
		int status= 0;
		
		if(this.personStatus==4||this.pidStatus==4
				||this.ncardStatus==4||this.agentStatus==4){
			status = 1;
		}else if(this.personStatus==3&&this.pidStatus==3
				&&this.ncardStatus==3&&(this.agentStatus==1||this.agentStatus==3||this.agentStatus==0)){
			status = 2;
		}
		return status;
	}
	
	public int getCreditNeedWsCount(){
		int count= 0;
		if(this.personStatus!=3)count++;
		if(this.pidStatus!=3)count++;
		if(this.ncardStatus!=3)count++;
		if(this.agentStatus==4)count++;
		return count;
	}
	
}
