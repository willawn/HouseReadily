package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.housereadily.dao.IAuditMemberGroupDAO;
import com.huzhiyi.housereadily.entity.AuditMemberGroup;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.StringUtils;

public class AuditMemberGroupDAOImpl extends AbstractAuditMemberGroupDAOImpl implements IAuditMemberGroupDAO {

	@Override
	public List<AuditMemberGroup> findPaging(Integer baseGroupId, Integer userId, Integer isRead, String sort, String dir, PagingBean pagingBean)
			throws Exception {
		StringBuffer hql = new StringBuffer();
		hql.append("select o from com.huzhiyi.housereadily.entity.AuditMemberGroup o where 1 = 1");

		if (null != userId && userId > 0) {
			hql.append(" and (o.userId = ").append(userId);
			hql.append(" or o.auditer = ").append(userId).append(")");
		}
		if (null != baseGroupId && baseGroupId > 0) {
			hql.append(" and o.baseGroupId = ").append(baseGroupId);
		}
		if (null != isRead) {
			hql.append(" and o.isRead = ").append(isRead);
		}
		if (StringUtils.isNotEmpty(sort) && StringUtils.isNotEmpty(dir)) {
			hql.append(" order by o.").append(sort).append(" ").append(dir);
		} else {
			hql.append(" order by createTime desc");
		}
		return super.findPaging(hql.toString(), pagingBean);
	}
}