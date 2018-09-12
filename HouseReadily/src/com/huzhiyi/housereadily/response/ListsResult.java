package com.huzhiyi.housereadily.response;

import com.tastysoft.swct.db.table.TablesSet;

/**
 * 返回结果集
 * @author sana
 *
 */
public class ListsResult extends Result {
	private TablesSet tableSet;
	private TablesSet tableSetTwo;
	private TablesSet cityTableSet;
	
	public TablesSet getTableSet() {
		return tableSet;
	}
	public void setTableSet(TablesSet tableSet) {
		this.tableSet = tableSet;
	}
	public TablesSet getTableSetTwo() {
		return tableSetTwo;
	}
	public void setTableSetTwo(TablesSet tableSetTwo) {
		this.tableSetTwo = tableSetTwo;
	}
	public TablesSet getCityTableSet() {
		return cityTableSet;
	}
	public void setCityTableSet(TablesSet cityTableSet) {
		this.cityTableSet = cityTableSet;
	}
}
