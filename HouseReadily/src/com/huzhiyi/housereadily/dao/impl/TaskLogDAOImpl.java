package com.huzhiyi.housereadily.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.dao.ITaskLogDAO;
import com.huzhiyi.housereadily.entity.TaskLog;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.model.abstraction.QueryResult;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Constants;

public class TaskLogDAOImpl extends AbstractTaskLogDAOImpl implements ITaskLogDAO {

	@Override
	public QueryResult<TaskLog> findByProperty(String[] propertyNames, Object[] values, String order, String dir) {
		return super.findByProperty(propertyNames, values, order, dir);
	}

	@Override
	public List<TaskLog> findAll(Integer userId, Integer taskId, Date beginDate, Date endDate) {
		StringBuffer hql = new StringBuffer("select o from com.huzhiyi.housereadily.entity.TaskLog o where 1 = 1");
		if (null != userId && userId > 0) {
			hql.append(" and o.userId = ").append(userId);
		}
		if (null != taskId && taskId > 0) {
			hql.append(" and o.taskId = ").append(taskId);
		}
		if (null != beginDate) {
			hql.append(" and o.createTime >= '").append(DateUtils.format(beginDate, Constants.SHORT_DATEFORMAT)).append("'");
		}
		if (null != endDate) {
			hql.append(" and o.createTime < '").append(DateUtils.format(endDate, Constants.SHORT_DATEFORMAT)).append("'");
		}

		return super.findByHQL(hql.toString()).getList();
	}

	@Override
	public List<TaskLog> findPaging(Integer id, String userName, Integer type, Integer taskId, Integer shareType, Date beginDate, Date endDate,
			String sort, String dir, PagingBean pagingBean) {
		StringBuffer hql = new StringBuffer("select o from com.huzhiyi.housereadily.entity.TaskLog o where 1 = 1");
		if (null != id && id > 0) {
			hql.append(" and o.id = ").append(id);
		}
		if (StringUtils.isNotEmpty(userName)) {
			hql.append(" and o.userId in (select u.id from com.huzhiyi.housereadily.model.CUser u where u.name like '%").append(userName)
					.append("%')");
		}
		if (null != type && type > 0) {
			hql.append(" and o.taskId in (select t.id from com.huzhiyi.housereadily.entity.Task t where t.type = ").append(type).append(")");
		}
		if (null != taskId && taskId > 0) {
			hql.append(" and o.taskId = ").append(taskId);
		}
		if (null != shareType && shareType > 0) {
			hql.append(" and o.shareType = ").append(shareType);
		}
		if (null != beginDate) {
			hql.append(" and o.createTime >= '").append(DateUtils.format(beginDate, Constants.DATEFORMAT)).append("'");
		}
		if (null != endDate) {
			hql.append(" and o.createTime < '").append(
					DateUtils.format(DateUtils.addDate(endDate, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT)).append("'");
		}
		if (StringUtils.isNotEmpty(sort) && StringUtils.isNotEmpty(dir)) {
			hql.append(" order by o.").append(sort).append(" ").append(dir);
		} else {
			hql.append(" order by o.createTime desc");
		}

		return super.findPaging(hql.toString(), pagingBean);
	}
}