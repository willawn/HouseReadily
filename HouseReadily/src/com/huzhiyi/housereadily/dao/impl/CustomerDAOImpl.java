package com.huzhiyi.housereadily.dao.impl;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.dao.ICustomerDAO;
import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.housereadily.request.CustomerCommand;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Constants;
public class CustomerDAOImpl extends AbstractCustomerDAOImpl implements ICustomerDAO{
	
	@Override
	public List<Customer> findPaging(ICommand command, PagingBean pagingBean) {
		CustomerCommand customerCommand = (CustomerCommand) command;
		Integer userId = customerCommand.getUserId();
		Integer ctype = customerCommand.getCtype();
		Integer buildType = customerCommand.getBuildType();
		String name = customerCommand.getName();
		Integer bigAreaCode = customerCommand.getBigAreaCode();
		Integer smallAreaCode = customerCommand.getSmallAreaCode();
		BigDecimal beginFirstPayment = customerCommand.getBeginFirstPayment();
		BigDecimal endFirstPayment = customerCommand.getEndFirstPayment();
		BigDecimal beginArea = customerCommand.getBeginArea();
		BigDecimal endArea = customerCommand.getEndArea();
		BigDecimal beginUnitPrice = customerCommand.getBeginUnitPrice();
		BigDecimal endUnitPrice = customerCommand.getEndUnitPrice();
		BigDecimal beginTotalPrice = customerCommand.getBeginTotalPrice();
		BigDecimal endTotalPrice = customerCommand.getEndTotalPrice();
		Integer beginRoomNum = customerCommand.getBeginRoomNum();
		Integer endRoomNum = customerCommand.getEndRoomNum();
		
		StringBuffer hql = new StringBuffer("select o from com.huzhiyi.housereadily.entity.Customer o where 1 = 1 and (o.isDelete is null or o.isDelete = 1)");
		if (null != userId && userId > 0) {
			hql.append(" and o.creater = ").append(userId);
		}
		if (null != ctype && ctype > 0) {
			hql.append(" and o.ctype = ").append(ctype);
		}
		if (null != buildType && buildType > 0) {
			hql.append(" and o.buildType = ").append(buildType);
		}
		if (!StringUtils.isEmpty(name)) {
			hql.append(" and o.name like '%").append(name).append("%'");
		}
		if (null != bigAreaCode && bigAreaCode > 0) {
			hql.append(" and o.bigAreaCode = ").append(bigAreaCode);
		}
		if (null != smallAreaCode && smallAreaCode > 0) {
			hql.append(" and o.smallAreaCode = ").append(smallAreaCode);
		}
		if (null != beginFirstPayment && beginFirstPayment.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.beginFirstPayment >= ").append(beginFirstPayment);
		}
		if (null != endFirstPayment && endFirstPayment.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.endFirstPayment <= ").append(endFirstPayment);
		}
		if (null != beginArea && beginArea.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.beginArea >= ").append(beginArea);
		}
		if (null != endArea && endArea.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.endArea <= ").append(endArea);
		}
		if (null != beginUnitPrice && beginUnitPrice.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.beginUnitPrice >= ").append(beginUnitPrice);
		}
		if (null != endUnitPrice && endUnitPrice.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.endUnitPrice <= ").append(endUnitPrice);
		}
		if (null != beginTotalPrice && beginTotalPrice.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.beginTotalPrice >= ").append(beginTotalPrice);
		}
		if (null != endTotalPrice && endTotalPrice.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.endTotalPrice <= ").append(endTotalPrice);
		}
		if (null != beginRoomNum && beginRoomNum > 0) {
			hql.append(" and o.roomNum >= ").append(beginRoomNum);
		}
		if (null != endRoomNum && endRoomNum > 0) {
			hql.append(" and o.roomNum <= ").append(endRoomNum);
		}
		hql.append(" order by o.updateTime desc");
		
		return super.findPaging(hql.toString(), pagingBean);
	}
	
	@Override
	public List<Customer> findIdAndVersion(Integer userId) {
		String hql = "select o.id, o.version, o.syncTime from com.huzhiyi.housereadily.entity.Customer o where (o.isDelete is null or o.isDelete = 1) and o.creater = ? order by o.updateTime desc";
		return super.findByHQL(hql, userId).getList();
	}
	
	@Override
	public Customer existsCustomer(Integer userId, Integer ctype, String name, String mobile) {
		StringBuffer hql = new StringBuffer("select o from com.huzhiyi.housereadily.entity.Customer o where 1 = 1 and (o.isDelete is null or o.isDelete = 1)");
		if (null != userId && userId > 0) {
			hql.append(" and o.creater = ").append(userId);
		}
		if (null != ctype && ctype > 0) {
			hql.append(" and o.ctype = ").append(ctype);
		}
		if (!StringUtils.isEmpty(name)) {
			hql.append(" and o.name = '").append(name).append("'");
		}
		if (!StringUtils.isEmpty(mobile)) {
			hql.append(" and o.mobile = '").append(mobile).append("'");
		}
		return super.findByHQL(hql.toString()).getUniqueResult();
	}
	
	@Override
	public Integer findCount(Integer userId) {
		String hql = "select count(o.id) from com.huzhiyi.housereadily.entity.Customer o where (o.isDelete is null or o.isDelete = 1) and o.creater = ?";
		return Integer.parseInt(super.findByHQL(hql, userId).getUniqueResult().toString());
	}
	
	@Override
	public Integer updateStatus(Integer id, Integer status) {
		String hql = "update com.huzhiyi.housereadily.entity.Customer o set o.state = ? where o.id = ?";
		return super.executeUpdate(hql, status, id);
	}
	
	@Override
	public List<Customer> findPaging(Integer id, Integer ctype, Integer buildType, String name, Integer gender, String mobile, Integer beginRoomNum, Integer endRoomNum,
			BigDecimal beginArea, BigDecimal endArea, String userName, Date beginDate, Date endDate, Integer isDelete, String sort, String dir,
			PagingBean pagingBean) {
		StringBuffer hql = new StringBuffer("select o from com.huzhiyi.housereadily.entity.Customer o where 1 = 1");
		if (null != id && id > 0) {
			hql.append(" and o.id = ").append(id);
		}
		if (null != ctype && ctype > 0) {
			hql.append(" and o.ctype = ").append(ctype);
		}
		if (null != buildType && buildType > 0) {
			hql.append(" and o.buildType = ").append(buildType);
		}
		if (!StringUtils.isEmpty(name)) {
			hql.append(" and o.name like '%").append(name).append("%'");
		}
		if (null != gender && gender > 0) {
			hql.append(" and o.gender = ").append(gender);
		}
		if (!StringUtils.isEmpty(mobile)) {
			hql.append(" and o.mobile like '%").append(mobile).append("%'");
		}
		if (null != beginArea && beginArea.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.beginArea >= ").append(beginArea);
		}
		if (null != endArea && endArea.compareTo(BigDecimal.ZERO) > 0) {
			hql.append(" and o.endArea <= ").append(endArea);
		}
		if (null != beginRoomNum && beginRoomNum > 0) {
			hql.append(" and o.roomNum >= ").append(beginRoomNum);
		}
		if (null != endRoomNum && endRoomNum > 0) {
			hql.append(" and o.roomNum <= ").append(endRoomNum);
		}
		if (StringUtils.isNotEmpty(userName)) {
			hql.append(" and o.creater in (select u.id from com.huzhiyi.housereadily.model.CUser u where u.name like '%").append(userName).append(
					"%')");
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