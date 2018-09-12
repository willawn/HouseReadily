package com.tastysoft.swct.db.model;

public class WebListEntity {

	private Integer webId;
	private String webName;
	private String lastupdateTime;
	private Integer status;  //（最后一次发布、刷新状态：1-成功；0-失败；2-操作中）
	private String errorMsg;  //（最后一次操作失败的原因）
	private Integer progress;  // 进度
	private String verCode;  // 验证码图片的URL，这个比较特殊，如果服务器上存在未提交的验证码，这个字段会一直返回）
	public Integer getWebId() {
		return webId;
	}
	public void setWebId(Integer webId) {
		this.webId = webId;
	}
	public String getWebName() {
		return webName;
	}
	public void setWebName(String webName) {
		this.webName = webName;
	}
	public String getLastupdateTime() {
		return lastupdateTime;
	}
	public void setLastupdateTime(String lastupdateTime) {
		this.lastupdateTime = lastupdateTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Integer getProgress() {
		return progress;
	}
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	public String getVerCode() {
		return verCode;
	}
	public void setVerCode(String verCode) {
		this.verCode = verCode;
	}

   
}
