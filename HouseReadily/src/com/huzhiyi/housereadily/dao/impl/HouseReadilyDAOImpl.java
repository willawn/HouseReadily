package com.huzhiyi.housereadily.dao.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.dao.IHouseReadilyDAO;
import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.housereadily.request.HouseReadilyCommand;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Constants;

public class HouseReadilyDAOImpl extends AbstractHouseReadilyDAOImpl implements IHouseReadilyDAO {

	@Override
	public List<HouseReadily> findPaging(ICommand command, PagingBean pagingBean) {
		HouseReadilyCommand readilyCommand = (HouseReadilyCommand) command;
		Integer userId = readilyCommand.getUserId();
		Integer stype = readilyCommand.getStype();
		Integer buildType = readilyCommand.getBuildType();
		String projectName = readilyCommand.getProjectName();
		Integer bigAreaCode = readilyCommand.getBigAreaCode();
		Integer smallAreaCode = readilyCommand.getSmallAreaCode();
		BigDecimal beginArea = readilyCommand.getBeginArea();
		BigDecimal endArea = readilyCommand.getEndArea();
		BigDecimal beginUnitPrice = readilyCommand.getBeginUnitPrice();
		BigDecimal endUnitPrice = readilyCommand.getEndUnitPrice();
		BigDecimal beginTotalPrice = readilyCommand.getBeginTotalPrice();
		BigDecimal endTotalPrice = readilyCommand.getEndTotalPrice();
		Integer beginRoomNum = readilyCommand.getBeginRoomNum();
		Integer endRoomNum = readilyCommand.getEndRoomNum();
		Integer order = readilyCommand.getOrder();

		StringBuffer hql = new StringBuffer(
				"select o from com.huzhiyi.housereadily.entity.HouseReadily o where 1 = 1 and (o.isDelete is null or o.isDelete = 1)");
		if (null != userId && userId > 0) {
			hql.append(" and o.creater = ").append(userId);
		}
		if (null != stype && stype > 0) {
			hql.append(" and o.stype = ").append(stype);
		}
		if (null != buildType && buildType > 0) {
			hql.append(" and o.buildType = ").append(buildType);
		}
		if (!StringUtils.isEmpty(projectName)) {
			hql.append(" and o.projectName like '%").append(projectName).append("%'");
		}
		if (null != bigAreaCode && bigAreaCode > 0) {
			hql.append(" and o.bigAreaCode = ").append(bigAreaCode);
		}
		if (null != smallAreaCode && smallAreaCode > 0) {
			hql.append(" and o.smallAreaCode = ").append(smallAreaCode);
		}
		if (null != beginArea && beginArea.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.area >= ").append(beginArea);
		}
		if (null != endArea && endArea.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.area <= ").append(endArea);
		}
		if (null != beginUnitPrice && beginUnitPrice.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.unitPrice >= ").append(beginUnitPrice);
		}
		if (null != endUnitPrice && endUnitPrice.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.unitPrice <= ").append(endUnitPrice);
		}
		if (null != beginTotalPrice && beginTotalPrice.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.totalPrice >= ").append(beginTotalPrice);
		}
		if (null != endTotalPrice && endTotalPrice.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.totalPrice <= ").append(endTotalPrice);
		}
		if (null != beginRoomNum && beginRoomNum > 0) {
			hql.append(" and o.roomNum >= ").append(beginRoomNum);
		}
		if (null != endRoomNum && endRoomNum > 0) {
			hql.append(" and o.roomNum <= ").append(endRoomNum);
		}
		String field = null;
		if (null != order && order == 1) {
			field = "updateTime";
		} else if (null != order && order == 2) {
			field = "lastFollowDate";
		} else {
			field = "updateTime";
		}
		hql.append(" order by o.").append(field).append(" desc");

		return super.findPaging(hql.toString(), pagingBean);
	}

	@Override
	public List<HouseReadily> findIdAndVersion(Integer userId) {
		String hql = "select o.id, o.version, o.syncTime from com.huzhiyi.housereadily.entity.HouseReadily o where (o.isDelete is null or o.isDelete = 1) and o.creater = ? order by o.updateTime desc";
		return super.findByHQL(hql, userId).getList();
	}

	@Override
	public Integer findCount(Integer userId) {
		String hql = "select count(o.id) from com.huzhiyi.housereadily.entity.HouseReadily o where (o.isDelete is null or o.isDelete = 1) and o.creater = ?";
		return Integer.parseInt(super.findByHQL(hql, userId).getUniqueResult().toString());
	}
	
	@Override
	public Integer updateStatus(Integer id, Integer status) {
		String hql = "update com.huzhiyi.housereadily.entity.HouseReadily o set o.state = ? where o.id = ?";
		return super.executeUpdate(hql, status, id);
	}

	@Override
	public List<HouseReadily> findPaging(Integer id, Integer stype, Integer buildType, String projectName, String title, Integer cityCode,
			Integer bigAreaCode, Integer smallAreaCode, String userName, Date beginDate, Date endDate, Integer isDelete, String sort,
			String dir, PagingBean pagingBean) {
		StringBuffer hql = new StringBuffer("select o from com.huzhiyi.housereadily.entity.HouseReadily o where 1 = 1");
		if (null != id && id > 0) {
			hql.append(" and o.id = ").append(id);
		}
		if (null != stype && stype > 0) {
			hql.append(" and o.stype = ").append(stype);
		}
		if (null != buildType && buildType > 0) {
			hql.append(" and o.buildType = ").append(buildType);
		}
		if (!StringUtils.isEmpty(projectName)) {
			hql.append(" and o.projectName like '%").append(projectName).append("%'");
		}
		if (!StringUtils.isEmpty(title)) {
			hql.append(" and o.title like '%").append(title).append("%'");
		}
		if (null != cityCode && cityCode > 0) {
			hql.append(" and o.cityCode = ").append(cityCode);
		}
		if (null != bigAreaCode && bigAreaCode > 0) {
			hql.append(" and o.bigAreaCode = ").append(bigAreaCode);
		}
		if (null != smallAreaCode && smallAreaCode > 0) {
			hql.append(" and o.smallAreaCode = ").append(smallAreaCode);
		}
		if (StringUtils.isNotEmpty(userName)) {
			hql.append(" and o.creater in (select u.id from com.huzhiyi.housereadily.model.CUser u where u.name like '%").append(userName)
					.append("%')");
		}
		if (null != beginDate) {
			hql.append(" and o.updateTime >= '").append(DateUtils.format(beginDate, Constants.DATEFORMAT)).append("'");
		}
		if (null != endDate) {
			hql.append(" and o.updateTime < '").append(
					DateUtils.format(DateUtils.addDate(endDate, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT)).append("'");
		}
		if (null != isDelete && isDelete > -1) {
			hql.append(" and o.isDelete = ").append(isDelete);
		}
		if (StringUtils.isNotEmpty(sort) && StringUtils.isNotEmpty(dir)) {
			hql.append(" order by o.").append(sort).append(" ").append(dir);
		} else {
			hql.append(" order by o.updateTime desc");
		}

		return super.findPaging(hql.toString(), pagingBean);
	}
}