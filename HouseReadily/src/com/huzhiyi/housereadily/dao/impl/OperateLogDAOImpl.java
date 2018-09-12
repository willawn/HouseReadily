package com.huzhiyi.housereadily.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.dao.IOperateLogDAO;
import com.huzhiyi.housereadily.entity.OperateLog;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Constants;

public class OperateLogDAOImpl extends AbstractOperateLogDAOImpl implements IOperateLogDAO {

	@Override
	public List<OperateLog> findPaging(Integer id, String userName, Integer regSource, String terminal, Integer type, Date beginDate, Date endDate,
			 String sort, String dir, PagingBean pagingBean) {
		StringBuffer hql = new StringBuffer("select o from com.huzhiyi.housereadily.entity.OperateLog o where 1 = 1");
		if (null != id && id > 0) {
			hql.append(" and o.id = ").append(id);
		}
		if (StringUtils.isNotEmpty(userName)) {
			hql.append(" and o.userId in (select u.id from com.huzhiyi.housereadily.model.CUser u where u.name like '%").append(userName).append(
					"%')");
		}
		if (null != regSource && regSource > 0) {
			if (regSource == 1) {
				hql.append(" and o.userId in (select u.id from com.huzhiyi.housereadily.model.CUser u where u.regSource is null or u.regSource = ").append(regSource).append(")");
			} else if (regSource == 2) {
				hql.append(" and o.userId in (select u.id from com.huzhiyi.housereadily.model.CUser u where u.regSource = ").append(regSource).append(")");
			}
		}
		if (StringUtils.isNotEmpty(terminal)) {
			hql.append(" and o.terminal = '").append(terminal).append("'");
		}
		if (null != type && type > 0) {
			hql.append(" and o.type = ").append(type);
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