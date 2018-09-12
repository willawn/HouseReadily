package com.huzhiyi.housereadily.dao;

import java.util.List;

import com.huzhiyi.housereadily.entity.HouseFollow;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.model.abstraction.QueryResult;

public interface IHouseFollowDAO extends IAbstracthouseFollowDAO {

	public List<HouseFollow> findPaging(Integer houseReadilyId, Integer customerId, Integer ctype, PagingBean pagingBean);
	
	public List<HouseFollow> findByCustomerId(Integer customerId);
	
	public QueryResult<HouseFollow> findByProperty(String propertyName, Object value, String order, String dir);
}