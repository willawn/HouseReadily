package com.huzhiyi.housereadily.dao.impl;

import com.huzhiyi.housereadily.dao.IHouseOwnerDAO;

public class HouseOwnerDAOImpl extends AbstractHouseOwnerDAOImpl implements IHouseOwnerDAO {

	@Override
	public Integer countHouseOwner(Integer houseReadilyId, Integer customerId) {
		StringBuffer hql = new StringBuffer("select count(*) from com.huzhiyi.housereadily.entity.HouseOwner o where 1 = 1");
		if (null != houseReadilyId && houseReadilyId > 0) {
			hql.append(" and o.houseReadilyId = ").append(houseReadilyId);
		}
		if (null != customerId && customerId > 0) {
			hql.append(" and o.customerId = ").append(customerId);
		}
		hql.append(" order by o.createTime desc");
		return Integer.parseInt(super.findByHQL(hql.toString(), new Object[] {}).getUniqueResult().toString());
	}

}