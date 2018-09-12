package com.huzhiyi.housereadily.request;

public class MemberGroupCommand extends BaseCommand {

	private Integer id;
	private Integer baseGroupId;
	private Integer pageNo;
	private Integer pageSize;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBaseGroupId() {
		return baseGroupId;
	}

	public void setBaseGroupId(Integer baseGroupId) {
		this.baseGroupId = baseGroupId;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
