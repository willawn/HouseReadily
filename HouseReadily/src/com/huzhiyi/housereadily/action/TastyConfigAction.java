package com.huzhiyi.housereadily.action;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.restlet.data.Form;

import com.huzhiyi.housereadily.model.CArea;
import com.huzhiyi.housereadily.model.CCustomers;
import com.huzhiyi.housereadily.model.CHouseSell;
import com.huzhiyi.housereadily.model.CProject;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.housereadily.model.CUserCredit;
import com.tastysoft.swct.db.model.ProjectEntity;
import com.tastysoft.swct.db.model.TastyEntity;
import com.tastysoft.swct.db.services.TastyService;
import com.tastysoft.swct.db.table.TableParam;
import com.tastysoft.swct.db.table.TableParamFilter;
import com.tastysoft.swct.util.DateHelper;
import com.tastysoft.yeapoo.dbmanager.DBConnectionManager;
import com.tastysoft.yeapoo.dbmanager.DBRunner;

public class TastyConfigAction {
	private TastyService tastyService;

	public TastyService getTastyService() {
		return tastyService;
	}

	public void setTastyService(TastyService tastyService) {
		this.tastyService = tastyService;
	}

	/*
	 * moudle remove
	 */

	public void deleteAllByUserId(String ctable, String property, String propertyValue, int userId) {
		if (propertyValue.length() == 0)
			return;
		String hql = sqlDeleteAll(ctable, property, propertyValue, userId);
		this.getTastyService().excute(hql);
	}

	public String sqlDeleteAll(String ctable, String property, String propertyValue, int userId) {
		String alias = ctable + "_";
		String hql = "";
		hql = "delete from " + ctable + " " + alias + " where " + alias + "." + property + " in(" + propertyValue + ")";
		hql += " And " + alias + ".userId=" + userId;
		return hql;
	}

	/*
	 * common moudle remove
	 */
	public void deleteCommonAllIds(String ctable, String[] ids) {
		String idvalues = "";
		for (int i = 0; i < ids.length; i++) {
			if (i < ids.length - 1)
				idvalues += ids[i] + ",";
			else
				idvalues += ids[i];
		}
		deleteCommonAll(ctable, "id", idvalues);
	}

	public void deleteCommonAll(String ctable, String property, String propertyValue) {
		if (propertyValue == null || propertyValue.length() == 0)
			return;
		String alias = ctable + "_";
		String hql = "delete from " + ctable + " " + alias + " where " + alias + "." + property + " in(" + propertyValue + ")";
		this.getTastyService().excute(hql);
	}

	/*
	 * 从ruquest中返回指定参数
	 */
	public String requestPropertyValue(Form form, String key) {
		return requestPropertyValue(form, key, "");
	}

	public String requestPropertyValue(Form form, String key, String defaultValue) {
		/* ******** iOS 判断 ********* */
		try {
			String operate = form.getFirstValue("operate");
			if (null != operate && "ios".equalsIgnoreCase(operate)) {
				return new String(form.getFirstValue(key, defaultValue).getBytes("ISO-8859-1"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
		}
		return form.getFirstValue(key, defaultValue);
	}

	public Integer requestPropertyIntValue(Form form, String property) {
		return requestPropertyIntValue(form, property, null);
	}

	public Integer requestPropertyIntValue(Form form, String property, Integer defaultValue) {
		Integer propertyValue = defaultValue;
		if (property == null)
			return propertyValue;
		String value = form.getFirstValue(property);
		try {
			if (value != null) {
				value = value.trim();
				propertyValue = Integer.valueOf(value);
			}
		} catch (Exception ex) {

		}
		return propertyValue;
	}

	public Date requestPropertyDateValue(Form form, String property) {
		Date propertyValue = null;
		if (property == null)
			return propertyValue;
		String value = form.getFirstValue(property);
		try {
			if (value != null) {
				value = value.trim();
				propertyValue = DateHelper.stringToDate(value);
			}
		} catch (Exception ex) {

		}
		return propertyValue;
	}

	public Float requestPropertyFloatValue(Form form, String property) {
		return requestPropertyFloatValue(form, property, null);
	}

	public Float requestPropertyFloatValue(Form form, String property, Float defaultValue) {
		Float propertyValue = defaultValue;
		if (property == null)
			return propertyValue;
		String value = form.getFirstValue(property);
		try {
			if (value != null) {
				value = value.trim();
				propertyValue = Float.valueOf(value);
			}
		} catch (Exception ex) {

		}
		return propertyValue;
	}

	/*
	 * 从ruquest中返回指定参数
	 */
	public String requestPropertyValue(Form form, String property, boolean needDecode) {
		String propertyValue = "";
		if (property == null)
			return "";
		if (form.getFirstValue(property) != null) {
			propertyValue = form.getFirstValue(property).trim();
			if (needDecode) {
				if (propertyValue == null || propertyValue.length() == 0)
					propertyValue = "";
				String encode = null;// request.getCharacterEncoding();
				if (encode == null || encode.length() == 0)
					encode = "ISO-8859-1";
				try {
					propertyValue = new String(propertyValue.getBytes(encode), "utf-8");
				} catch (UnsupportedEncodingException e) {
					propertyValue = "";
				}
			}
		}
		return propertyValue;
	}

	public Double requestPropertyDoubleValue(Form form, String property, Double defaultValue) {
		double propertyValue = defaultValue;
		if (property == null)
			return propertyValue;
		String value = form.getFirstValue(property);
		try {
			if (value != null) {
				value = value.trim();
				propertyValue = Double.valueOf(value);
			}
		} catch (Exception ex) {

		}
		return propertyValue;
	}

	/**
	 * table param
	 * */

	public TableParam numericEqFilter(TableParam tableParam, String field, String fieldValue) {
		return autoTableParamFilter(tableParam, field, fieldValue, "numeric", "eq");
	}

	public TableParam numericInFilter(TableParam tableParam, String field, String fieldValue) {
		return autoTableParamFilter(tableParam, field, fieldValue, "numeric", "in");
	}

	public TableParam numericLtFilter(TableParam tableParam, String field, String fieldValue) {
		return autoTableParamFilter(tableParam, field, fieldValue, "numeric", "lt");
	}

	public TableParam numericGtFilter(TableParam tableParam, String field, String fieldValue) {
		return autoTableParamFilter(tableParam, field, fieldValue, "numeric", "gt");
	}

	public TableParam numericLeFilter(TableParam tableParam, String field, String fieldValue) {
		return autoTableParamFilter(tableParam, field, fieldValue, "numeric", "le");
	}

	public TableParam numericGeFilter(TableParam tableParam, String field, String fieldValue) {
		return autoTableParamFilter(tableParam, field, fieldValue, "numeric", "ge");
	}

	public TableParam autoTableParamFilter(TableParam tableParam, String field, String fieldValue, String fieldDataType,
			String fieldComparison) {
		return autoTableParamFilter(tableParam, field, fieldValue, fieldDataType, fieldComparison, true);
	}

	public TableParam stringLikeFilter(TableParam tableParam, String field, String fieldValue) {
		return autoTableParamFilter(tableParam, field, fieldValue, "string", "like");
	}

	public Boolean processRequestCheckBox(String key) {
		boolean ret = false;
		if (key != null && key.equals("1")) {
			ret = true;
		}
		return ret;
	}

	public TableParam numericCheckboxFilter(TableParam tableParam, String field, String checkValue, String unCheckValue) {
		boolean ret = processRequestCheckBox(field);
		String utype = unCheckValue;
		if (ret)
			utype = checkValue;
		else {
			return tableParam;
		}
		tableParam = autoTableParamFilter(tableParam, field, utype, "numeric", "eq");
		return tableParam;
	}

	public TableParam autoTableParamTimeFilter(TableParam tableParam, String field, String fieldValue, String fieldDataType,
			String fieldComparison) {
		if (fieldValue != null && fieldValue.length() > 0) {
			TableParamFilter jsonParamFilter = null;
			jsonParamFilter = new TableParamFilter();
			jsonParamFilter.setFilterDataType(fieldDataType);
			jsonParamFilter.setFilterDataValue(fieldValue);
			jsonParamFilter.setFilterField(field);
			jsonParamFilter.setFilterFieldComparison(fieldComparison);
			tableParam.getFilters().add(jsonParamFilter);

			fieldValue = java.net.URLEncoder.encode(fieldValue);
			if (fieldComparison.equals("ge")) {
				tableParam.appendExtendPageStr("&" + field + "Start=" + fieldValue);
			} else if (fieldComparison.equals("lt")) {
				tableParam.appendExtendPageStr("&" + field + "End=" + fieldValue);
			}
		}
		return tableParam;
	}

	public TableParam autoTableParamFilter(TableParam tableParam, String field, String fieldValue, String fieldDataType,
			String fieldComparison, boolean pageExtend) {
		if (fieldDataType.equals("numeric")) {
			if (fieldValue == null || fieldValue.length() == 0) {
				return tableParam;
			}
		}
		if (fieldValue != null && fieldValue.length() > 0) {
			TableParamFilter jsonParamFilter = null;
			jsonParamFilter = new TableParamFilter();
			jsonParamFilter.setFilterDataType(fieldDataType);
			jsonParamFilter.setFilterDataValue(fieldValue);
			jsonParamFilter.setFilterField(field);
			jsonParamFilter.setFilterFieldComparison(fieldComparison);
			tableParam.getFilters().add(jsonParamFilter);
			if (pageExtend)
				tableParam.appendExtendPageStr("&" + field + "=" + fieldValue);
		} else if (fieldValue != null && fieldValue.length() == 0 && fieldComparison.equals("neq")) {
			TableParamFilter jsonParamFilter = null;
			jsonParamFilter = new TableParamFilter();
			jsonParamFilter.setFilterDataType(fieldDataType);
			jsonParamFilter.setFilterDataValue(fieldValue);
			jsonParamFilter.setFilterField(field);
			jsonParamFilter.setFilterFieldComparison(fieldComparison);
			tableParam.getFilters().add(jsonParamFilter);
			if (pageExtend)
				tableParam.appendExtendPageStr("&" + field + "=" + fieldValue);
		}
		return tableParam;
	}

	public TableParam autoTableParamExtendPageStr(TableParam tableParam, String field, String fieldValue) {
		tableParam.appendExtendPageStr("&" + field + "=" + fieldValue);
		return tableParam;
	}
	
	public TableParam numericRangeFilter(TableParam tableParam,String field,String fieldValue){
		 if(fieldValue==null||fieldValue.length()==0||fieldValue.equals("0,0"))
				return tableParam;
			String[] fieldValueSplit = fieldValue.split(",");
			if(fieldValueSplit.length!=2){
				return tableParam;
			}
			tableParam = autoRangeTableParamFilter(tableParam,field,fieldValueSplit[0],"numeric","ge");
			if(!fieldValueSplit[1].equals("0")){
				tableParam =autoRangeTableParamFilter(tableParam,field,fieldValueSplit[1],"numeric","lt");
			}
		 return tableParam;
	 }

	public TableParam autoRangeTableParamFilter(TableParam tableParam, String field, String fieldValue, String fieldDataType,
			String fieldComparison) {
		if (fieldDataType.equals("numeric")) {
			if (fieldValue == null || fieldValue.length() == 0) {
				return tableParam;
			}
		}
		if (fieldValue != null && fieldValue.length() > 0) {
			TableParamFilter jsonParamFilter = null;
			jsonParamFilter = new TableParamFilter();
			jsonParamFilter.setFilterDataType(fieldDataType);
			jsonParamFilter.setFilterDataValue(fieldValue);
			jsonParamFilter.setFilterField(field);
			jsonParamFilter.setFilterFieldComparison(fieldComparison);
			tableParam.getFilters().add(jsonParamFilter);
		} else if (fieldValue != null && fieldValue.length() == 0 && fieldComparison.equals("neq")) {
			TableParamFilter jsonParamFilter = null;
			jsonParamFilter = new TableParamFilter();
			jsonParamFilter.setFilterDataType(fieldDataType);
			jsonParamFilter.setFilterDataValue(fieldValue);
			jsonParamFilter.setFilterField(field);
			jsonParamFilter.setFilterFieldComparison(fieldComparison);
			tableParam.getFilters().add(jsonParamFilter);
			tableParam.appendExtendPageStr("&" + field + "=" + fieldValue);
		}
		return tableParam;
	}

	public TableParam stringTimeFilter(TableParam tableParam, String field, String nameStartValue, String nameEndValue) {
		if (nameStartValue.length() > 0 && DateHelper.stringToDate(nameStartValue) != null) {
			tableParam = autoTableParamTimeFilter(tableParam, field, nameStartValue, "date", "ge");
		}
		if (nameEndValue.length() > 0 && DateHelper.stringToDate(nameEndValue) != null) {
			tableParam = autoTableParamTimeFilter(tableParam, field, nameEndValue, "date", "lt");
		}
		return tableParam;
	}

	protected String transMavValue(TableParam tableParam, String name, String value) {
		if (value != null && value.length() > 0) {
			return value;
		}
		return "";
	}

	public TableParam numericDefaultEqFilter(TableParam tableParam, String field, String fieldValue, String defaultValue) {
		boolean ret = true;
		if (fieldValue == null || fieldValue.length() == 0 || fieldValue.equals("0")) {
			fieldValue = defaultValue;
			if (defaultValue == null || defaultValue.length() == 0)
				ret = false;
			else
				ret = true;
		}
		if (ret) {
			return autoTableParamFilter(tableParam, field, fieldValue, "numeric", "eq");
		} else
			return tableParam;
	}

	public ArrayList<TastyEntity> getUsersWebsitesList(int userId, String status, String isBanstatus) {
		String hql = "SELECT CUsersWebSites_ from CUsersWebSites CUsersWebSites_ WHERE CUsersWebSites_.isBanStatus in(" + isBanstatus
				+ ")and CUsersWebSites_.status in(" + status + ") and  CUsersWebSites_.userId=" + userId;
		ArrayList<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		return lists;
	}

	public ArrayList<TastyEntity> getUserHouseSellById(String ids) {
		String hql = "SELECT CHouseSell_ from CHouseSell CHouseSell_ WHERE CHouseSell_.id in (" + ids + ")";
		ArrayList<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		return lists;
	}

	// house_websites serialNo
	public String getSiteNameStr(Integer serialNo) {
		Connection connection_house = DBRunner.getConnection("house_db");
		if (connection_house == null) {
			String emsg = "-1";
			try {
				connection_house = DBConnectionManager.getInstance().getConnection("house_db");

			} catch (SQLException e) {
				emsg = "house:" + e.toString();
				e.printStackTrace();
			}
			return null;
		}
		Connection connection_project = DBRunner.getConnection("house_project_db");
		if (connection_project == null) {
			String emsg = "-1";
			try {
				connection_project = DBConnectionManager.getInstance().getConnection("house_project_db");
			} catch (SQLException e) {
				emsg = "project:" + e.toString();
				e.printStackTrace();
			}
			return null;
		}
		/*-----*/

		String sql = "select SiteName from house_websites where SerialNo = " + serialNo;
		String name = "";
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			if (connection_house != null) {
				ps = connection_house.prepareStatement(sql);
			} else {
				ps = connection_project.prepareStatement(sql);
			}

			rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString("SiteName");
			}
		} catch (Exception ex) {
			return null;
		}
		return name;
	}

	public ArrayList<TastyEntity> getCHouseWebsitesViewById(String ids) {
		String hql = "SELECT CHouseWebsitesView_ from CHouseWebsitesView CHouseWebsitesView_ WHERE CHouseWebsitesView_.wid in (" + ids
				+ ")";
		ArrayList<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		return lists;
	}

	public ArrayList<TastyEntity> getUserHouseSellByUserId(int userId) {
		String hql = "SELECT CHouseSell_ from CHouseSell CHouseSell_ WHERE CHouseSell_.userId=" + userId
				+ " and CHouseSell_.deleted=0 and CHouseSell_.publish !=3";
		ArrayList<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		return lists;
	}

	public ArrayList<TastyEntity> getHouseSells(int userId) {
		String hql = "SELECT CHouseSell_ from CHouseSell CHouseSell_ WHERE (CHouseSell_.userId=" + userId
				+ " and CHouseSell_.deleted=1) Or (CHouseSell_.userId=" + userId + " and  CHouseSell_.publish =3)";
		ArrayList<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		return lists;
	}

	public ArrayList<TastyEntity> getCustomers(int UserId) {
		String hql = "SELECT CCustomers_ from CCustomers CCustomers_ WHERE CCustomers_.userId =" + UserId;
		ArrayList<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		return lists;
	}

	public CCustomers getMaxCustomerId(int UserId) {
		String hql = "SELECT CCustomers_ from CCustomers CCustomers_ WHERE CCustomers_.userId =" + UserId + " order by id DESC";
		ArrayList<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		return lists != null && lists.size() != 0 ? (CCustomers) lists.get(0) : null;
	}

	// 获取客户信息 根据更新时间段
	public ArrayList<TastyEntity> getCustomersByUserIdAndPtime(int UserId, String synUpdateDate) {
		String hql = "SELECT CCustomers_ from CCustomers CCustomers_ WHERE CCustomers_.userId =" + UserId
				+ " and CCustomers_.updateTime >= '" + synUpdateDate + "'";
		ArrayList<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		return lists;
	}

	public int updateHouseIsSablShow(String houseIds, int userId) {
		try {
			String hql = "SELECT CHouseSell_ from CHouseSell CHouseSell_ WHERE CHouseSell_.id in (" + houseIds + ") and userId =" + userId;
			ArrayList<TastyEntity> houseList = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
			for (int i = 0; i < houseList.size(); i++) {
				CHouseSell house = (CHouseSell) houseList.get(i);
				if (house != null) {
					house.setIsSlabShow(2);
					this.getTastyService().save(house);
				}
			}
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	public int updateHouseIsSablDelete(String houseIds, int userId) {

		try {
			String hql = "SELECT CHouseSell_ from CHouseSell CHouseSell_ WHERE CHouseSell_.id in (" + houseIds + ") and userId =" + userId;
			ArrayList<TastyEntity> houseList = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
			for (int i = 0; i < houseList.size(); i++) {
				CHouseSell house = (CHouseSell) houseList.get(i);
				if (house != null) {
					house.setIsSlabDelete(0);
					this.getTastyService().save(house);
				}
			}
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	public CUserCredit getUserCUserCredit(int userId) {
		String hql = "SELECT CUserCredit_ from CUserCredit CUserCredit_ WHERE CUserCredit_.userId=" + userId + "";
		ArrayList<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		return lists != null && lists.size() != 0 ? (CUserCredit) lists.get(0) : null;
	}

	public CCustomers getUserCCustomers(String email, int userId) {
		String hql = "SELECT CCustomers_ from CCustomers CCustomers_ WHERE CCustomers_.userId=" + userId + " and CCustomers_.email ='"
				+ email + "'";
		ArrayList<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		return lists != null && lists.size() != 0 ? (CCustomers) lists.get(0) : null;
	}

	public CProject getCProject(String commId) {
		try {

			String hql = "SELECT CProject_ from CProject CProject_ WHERE CProject_.projectId=" + commId;
			System.err.println("hql:" + hql);
			ArrayList<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
			return lists != null && lists.size() != 0 ? (CProject) lists.get(0) : null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public CHouseSell getCHouseSell(Integer houseId) {
		String hql = "SELECT CHouseSell_ from CHouseSell CHouseSell_ WHERE CHouseSell_.id=" + houseId;
		ArrayList<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		return lists != null && lists.size() != 0 ? (CHouseSell) lists.get(0) : null;
	}

	public CHouseSell getCHouseSell(Integer houseId, Integer userId) {
		String hql = "SELECT CHouseSell_ from CHouseSell CHouseSell_ WHERE CHouseSell_.id=" + houseId + " and CHouseSell_.userId=" + userId;
		ArrayList<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		return lists != null && lists.size() != 0 ? (CHouseSell) lists.get(0) : null;
	}

	public CHouseSell getCHouseSell(String communityCode, CUser cuser) {
		String hql = "SELECT CHouseSell_ from CHouseSell CHouseSell_ WHERE CHouseSell_.communityCode=" + communityCode
				+ " and CHouseSell_.userId=" + cuser.getId();
		ArrayList<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		return lists != null && lists.size() != 0 ? (CHouseSell) lists.get(0) : null;
	}

	/**
	 * ..sana
	 * 
	 * @param ctable
	 * @param userDefine
	 * @param userId
	 * @return
	 */
	public boolean checkValidUserDefine(String ctable, String userDefine, int userId) {
		String hql = "Select " + ctable + "_ from " + ctable + " " + ctable + "_ " + "where " + ctable + "_.userDefine = '" + userDefine
				+ "' and " + ctable + "_.userId = " + userId;
		ArrayList<Object> objs = (ArrayList<Object>) this.getTastyService().getValue(hql);
		if (objs.size() > 0) {
			return false;
		}
		return true;
	}

	public CUser getUser(int userId) {
		CUser user;
		String hql = "SELECT CUser_ from CUser CUser_ WHERE CUser_.id=" + userId + "";
		List<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		if (lists.size() > 0) {
			user = (CUser) lists.get(0);
			return user;
		}
		return null;
	}

	public List<TastyEntity> getArea(int parentId) {
		CArea cArea;
		String hql = "SELECT CArea_ from CArea CArea_ WHERE CArea_.parentId=" + parentId + "";
		List<TastyEntity> lists = (ArrayList<TastyEntity>) this.getTastyService().getValue(hql);
		return lists;
	}

	public ArrayList<CHouseSell> getHouses(CUser user, String ctable, int stype, float minPrice, float maxPrice, double rentPrice) {
		String alias = ctable + "_";
		String hql = "SELECT " + alias + " from " + ctable + " " + alias + " WHERE " + alias + ".userId =" + user.getId() + " and  "
				+ alias + ".stype = " + stype;
		if (stype == 1) { // 出 售
			hql += " and " + alias + ".housePrice >=" + minPrice + " and " + alias + ".housePrice<=" + maxPrice + " ";
		} else {
			hql += " and " + alias + ".rentPrice <= " + rentPrice;
		}
		ArrayList<CHouseSell> lists = (ArrayList<CHouseSell>) this.getTastyService().getValue(hql);
		return lists;
	}

	/*
	 * moudle remove
	 */
	public void deleteAllByUserIdAndIds(String ctable, int id, CUser user, String property) {
		// String idvalues = ContextHelper.buildIds(ids);
		String alias = ctable + "_";
		// String property = "syncId"; // 同步id
		String hql = "delete from " + ctable + " " + alias + " where " + alias + "." + property + " in(" + id + ")  And " + alias
				+ ".userId=" + user.getId();
		;
		this.getTastyService().excute(hql);
	}

	/*
	 * moudle edit
	 */
	public Object ObjByUserIdAndId(String ctable, Object idValue) {
		int userId = 0; // cookie中
		int level = 0;
		String property = "id";
		int propertyValue;
		if (idValue instanceof Integer)
			propertyValue = (Integer) idValue;
		else
			propertyValue = Integer.valueOf((String) idValue);
		String hql = SqlByUserId(ctable, property, propertyValue, userId, level);
		ArrayList<Object> objs = (ArrayList<Object>) this.getTastyService().getValue(hql);
		if (objs == null || objs.size() == 0)
			return null;
		else
			return objs.get(0);
	}

	public String SqlByUserId(String ctable, String property, Object propertyValue, int userId, int level) {
		String alias = ctable + "_";
		String hql = "";
		if (propertyValue instanceof Integer) {
			hql = "select " + alias + " from " + ctable + " " + alias + " where " + alias + "." + property + "=" + propertyValue;
			if (level > 1) {
				hql += " And " + alias + ".userId=" + userId;
			}
			int propertyValue_ = (Integer) propertyValue;
			if (property.equals("id") && propertyValue_ == 0) {
				hql = "select " + alias + " from " + ctable + " " + alias + " where ";
				if (level > 1) {
					hql += " " + alias + ".userId=" + userId;
				}
			}
		} else {
			hql = "select " + alias + " from " + ctable + " " + alias + " where " + alias + "." + property + "='" + propertyValue + "'";
			if (level > 1) {
				hql += " And " + alias + ".userId=" + userId;
			}
		}
		return hql;
	}

	/**
	 * 
	 * @param cityEnName
	 *            城市简称
	 * @param cityCode
	 *            城市编号
	 * @param keyWord
	 *            楼盘检索关键字
	 * @param buildType
	 *            标识
	 * @param otherCityCode
	 * @return
	 */
	public List<Object> getCommNameKeyWord(String cityEnName, int cityCode, String keyWord, int buildType) {
		/*-----*/
		Connection connection_house = DBRunner.getConnection("house_db");
		if (connection_house == null) {
			String emsg = "-1";
			try {
				connection_house = DBConnectionManager.getInstance().getConnection("house_db");

			} catch (SQLException e) {
				emsg = "house:" + e.toString();
				e.printStackTrace();
			}
			return null;
		}
		Connection connection_project = DBRunner.getConnection("house_project_db");
		if (connection_project == null) {
			String emsg = "-1";
			try {
				connection_project = DBConnectionManager.getInstance().getConnection("house_project_db");
			} catch (SQLException e) {
				emsg = "project:" + e.toString();
				e.printStackTrace();
			}
			return null;
		}
		/*-----*/
		List<Object> lists = new ArrayList<Object>();
		if (buildType == 3 || buildType == 4 || buildType == 5)
			buildType = 1;
		StringBuilder sb = new StringBuilder();
		String sql = "select Id,Area,SubArea,Address,name,AreaId,SubAreaId,Lng,Lat,IsNew,Arround,Traffic from Project where BuildType = "
				+ buildType + " And City='" + cityEnName + "' And (Name like '%" + keyWord + "%' Or NameFullEn like '%" + keyWord
				+ "%' Or NameSimpleEn like '%" + keyWord + "%') order by length(name) asc";
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			if (connection_house != null) {
				ps = connection_house.prepareStatement(sql);
			} else {
				ps = connection_project.prepareStatement(sql);
			}

			rs = ps.executeQuery();
			while (rs.next()) {
				ProjectEntity projectEntity = new ProjectEntity();
				int district = 0;
				int comerce = 0;
				String districtname = "";
				String comercename = "";

				String id = rs.getString("Id");
				String address = rs.getString("Address");

				projectEntity.setCommId(id); // 楼盘编号
				projectEntity.setCommName(rs.getString("name"));
				projectEntity.setAddress(address);
				projectEntity.setTrafficInfo(rs.getString("Traffic"));
				projectEntity.setAroundCondition(rs.getString("Arround"));
				try {
					districtname = rs.getString("Area");// ContextHelper.getAreaName(district);
					comercename = rs.getString("SubArea");
					district = rs.getInt("AreaId");// DBRunner.getAreaCacheId(connection_house,
					// cityCode, districtname);
					if (district > 0)
						comerce = rs.getInt("SubAreaId");// DBRunner.getAreaCacheId(connection_house,
					// district,
					// comercename);
					else
						comerce = 0;
					projectEntity.setBigAreaName(districtname);
					projectEntity.setBigAreaCode(district);
					projectEntity.setSmallAreaName(comercename);
					projectEntity.setSmallAreaCode(comerce);

				} catch (Exception ex) {
					district = 0;
					comerce = 0;
				}

				lists.add(projectEntity);

			}
			return lists;
		} catch (Exception ex) {
			return null;
		}

	}
}
