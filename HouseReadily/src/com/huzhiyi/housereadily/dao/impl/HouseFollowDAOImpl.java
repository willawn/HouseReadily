package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.housereadily.dao.IHouseFollowDAO;
import com.huzhiyi.housereadily.entity.HouseFollow;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.model.abstraction.QueryResult;

public class HouseFollowDAOImpl extends AbstractHouseFollowDAOImpl implements IHouseFollowDAO {

	@Override
	public List<HouseFollow> findPaging(Integer houseReadilyId, Integer customerId, Integer ctype, PagingBean pagingBean) {
		StringBuffer hql = new StringBuffer("select o from com.huzhiyi.housereadily.entity.HouseFollow o where 1 = 1");
		if (null != houseReadilyId && houseReadilyId > 0) {
			hql.append(" and o.houseReadilyId = ").append(houseReadilyId);
		}
		if (null != customerId && customerId > 0) {
			hql.append(" and o.customerId = ").append(customerId);
		}
		if (null != ctype && ctype > 0) {
			hql.append(" and o.customerId in (select c.id from com.huzhiyi.housereadily.entity.Customer c where c.ctype = ").append(ctype)
					.append(")");
		}
		hql.append(" order by o.createTime desc");
		return super.findPaging(hql.toString(), pagingBean);
	}

	@Override
	public List<HouseFollow> findByCustomerId(Integer customerId) {
		String hql = "select o from com.huzhiyi.housereadily.entity.HouseFollow o where o.houseReadilyId is null and o.customerId = ? order by o.createTime desc";
		return super.findByHQL(hql, customerId).getList();
	}
	
	@Override
	public QueryResult<HouseFollow> findByProperty(String propertyName, Object value, String order, String dir) {
		return super.findByProperty(propertyName, value, order, dir);
	}
}