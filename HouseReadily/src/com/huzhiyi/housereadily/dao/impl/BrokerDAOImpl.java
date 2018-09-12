package com.huzhiyi.housereadily.dao.impl;

import com.huzhiyi.housereadily.dao.IBrokerDAO;
import com.huzhiyi.housereadily.entity.Broker;
import com.huzhiyi.model.abstraction.QueryResult;

public class BrokerDAOImpl extends AbstractBrokerDAOImpl implements IBrokerDAO {

	public QueryResult<Broker> findBrokerByNameAndMobile(String name, String moblie) {
		String hql = "select o from com.huzhiyi.housereadily.entity.Broker o where o.name = ? and o.mobile = ?";
		return super.findByHQL(hql, new Object[] { name, moblie });
	}
}