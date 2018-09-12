package com.tastysoft.swct.db.table;

import java.util.List;

import com.tastysoft.swct.db.model.TastyEntity;
public class TableSet {
	private int total  = 0;
	private List<TastyEntity> list;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<TastyEntity> getList() {
		return list;
	}
	public void setList(List<TastyEntity> list) {
		this.list = list;
	}
}
