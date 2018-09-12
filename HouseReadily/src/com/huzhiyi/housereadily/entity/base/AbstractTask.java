package com.huzhiyi.housereadily.entity.base;

import com.tastysoft.swct.db.model.TastyEntity;

/**
 * AbstractTask entity provides the base persistence definition of the Task
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTask extends TastyEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String description;
	private String explanation;
	private Integer growing;
	private Integer integration;
	private Integer total;
	private String img;
	private Integer type;
	private Integer isDisplay;
	
	// Constructors

	/** default constructor */
	public AbstractTask() {
	}

	/** full constructor */
	public AbstractTask(String title, String description, String explanation, Integer growing, Integer integration, Integer total,
			String img, Integer type, Integer isDisplay) {
		this.title = title;
		this.description = description;
		this.explanation = explanation;
		this.growing = growing;
		this.integration = integration;
		this.total = total;
		this.img = img;
		this.type = type;
		this.isDisplay = isDisplay;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExplanation() {
		return this.explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public Integer getGrowing() {
		return this.growing;
	}

	public void setGrowing(Integer growing) {
		this.growing = growing;
	}

	public Integer getIntegration() {
		return this.integration;
	}

	public void setIntegration(Integer integration) {
		this.integration = integration;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}

}