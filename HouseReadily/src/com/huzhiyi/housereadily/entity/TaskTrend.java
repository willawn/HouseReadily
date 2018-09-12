package com.huzhiyi.housereadily.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class TaskTrend implements Serializable {

	private Timestamp createTime;
	private Integer loginTask;
	private Integer houseReadilyTask;
	private Integer customerTask;
	private Integer shareSinaTask;
	private Integer shareTencentTask;
	private Integer shareWeiXinTask;
	private Integer shareQzoneTask;

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getLoginTask() {
		return loginTask;
	}

	public void setLoginTask(Integer loginTask) {
		this.loginTask = loginTask;
	}

	public Integer getHouseReadilyTask() {
		return houseReadilyTask;
	}

	public void setHouseReadilyTask(Integer houseReadilyTask) {
		this.houseReadilyTask = houseReadilyTask;
	}

	public Integer getCustomerTask() {
		return customerTask;
	}

	public void setCustomerTask(Integer customerTask) {
		this.customerTask = customerTask;
	}

	public Integer getShareSinaTask() {
		return shareSinaTask;
	}

	public void setShareSinaTask(Integer shareSinaTask) {
		this.shareSinaTask = shareSinaTask;
	}

	public Integer getShareTencentTask() {
		return shareTencentTask;
	}

	public void setShareTencentTask(Integer shareTencentTask) {
		this.shareTencentTask = shareTencentTask;
	}

	public Integer getShareWeiXinTask() {
		return shareWeiXinTask;
	}

	public void setShareWeiXinTask(Integer shareWeiXinTask) {
		this.shareWeiXinTask = shareWeiXinTask;
	}

	public Integer getShareQzoneTask() {
		return shareQzoneTask;
	}

	public void setShareQzoneTask(Integer shareQzoneTask) {
		this.shareQzoneTask = shareQzoneTask;
	}
}
