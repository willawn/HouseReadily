package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.housereadily.dao.IMemberGroupDAO;
import com.huzhiyi.housereadily.entity.MemberGroup;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.model.abstraction.QueryResult;
import com.huzhiyi.util.StringUtils;

public class MemberGroupDAOImpl extends AbstractMemberGroupDAOImpl implements IMemberGroupDAO {

	@Override
	public QueryResult<MemberGroup> findByProperty(String propertyName, Object value, String order, String dir) {
		String[] propertyNames = new String[] { propertyName, "isDelete" };
		Object[] values = new Object[] { value, 1 };
		return super.findByProperty(propertyNames, values, order, dir);
	}

	@Override
	public MemberGroup findByMemberGroup(Integer baseGroupId, Integer userId) {
		String hql = "select o from com.huzhiyi.housereadily.entity.MemberGroup o where isDelete = 1 and o.baseGroupId = ? and o.userId = ?";
		return (MemberGroup) super.findByHQL(hql.toString(), baseGroupId, userId).getUniqueResult();
	}

	@Override
	public List<MemberGroup> findPaging(Integer baseGroupId, String sort, String dir, PagingBean pagingBean) {
		StringBuffer hql = new StringBuffer("select o from com.huzhiyi.housereadily.entity.MemberGroup o where o.isDelete = 1");
		if (null != baseGroupId && baseGroupId > 0) {
			hql.append(" and o.baseGroupId = ").append(baseGroupId);
		}
		if (StringUtils.isNotEmpty(sort) && StringUtils.isNotEmpty(dir)) {
			hql.append(" order by o.").append(sort).append(" ").append(dir);
		} else {
			hql.append(" order by createTime asc");
		}
		return super.findPaging(hql.toString(), pagingBean);
	}
}