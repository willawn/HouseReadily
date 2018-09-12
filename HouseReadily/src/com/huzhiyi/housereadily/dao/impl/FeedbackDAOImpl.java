package com.huzhiyi.housereadily.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.dao.IFeedbackDAO;
import com.huzhiyi.housereadily.entity.Feedback;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Constants;

public class FeedbackDAOImpl extends AbstractFeedbackDAOImpl implements IFeedbackDAO {

	@Override
	public List<Feedback> findPaging(Date beginDate, Date endDate, String sort, String dir, PagingBean pagingBean) {
		StringBuffer hql = new StringBuffer("select o from com.huzhiyi.housereadily.entity.Feedback o where 1 = 1");
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