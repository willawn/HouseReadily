package com.huzhiyi.housereadily.entity;

import com.huzhiyi.housereadily.entity.base.AbstractTask;

/**
 * Task entity. @author MyEclipse Persistence Tools
 */
public class Task extends AbstractTask implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Task() {
	}

	/** full constructor */
	public Task(String title, String description, String explanation, Integer growing, Integer integration, Integer total, String img,
			Integer type, Integer isDisplay) {
		super(title, description, explanation, growing, integration, total, img, type, isDisplay);
	}

	private Integer count;
	private Integer growed;
	private Integer isComplete;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getGrowed() {
		return growed;
	}

	public void setGrowed(Integer growed) {
		this.growed = growed;
	}

	public Integer getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}
}
