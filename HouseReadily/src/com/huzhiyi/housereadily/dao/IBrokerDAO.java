package com.huzhiyi.housereadily.dao;

import com.huzhiyi.annotation.RDEQueryMethod;
import com.huzhiyi.housereadily.entity.Broker;
import com.huzhiyi.model.abstraction.QueryResult;

public interface IBrokerDAO extends IAbstractbrokerDAO {

	@RDEQueryMethod(queryName = "com.huzhiyi.housereadily.entity.Broker:this", findType = "find", paramters = "java.lang.String:name,java.lang.String:mobile", order = "")
	QueryResult<Broker> findBrokerByNameAndMobile(String name, String moblie);
}