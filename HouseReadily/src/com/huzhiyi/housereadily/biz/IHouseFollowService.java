package com.huzhiyi.housereadily.biz;

import java.util.List;

import com.huzhiyi.housereadily.entity.HouseFollow;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.model.abstraction.QueryResult;

@com.huzhiyi.annotation.RDEBiz
public interface IHouseFollowService extends IAbstracthouseFollowService {

	public HouseFollow add(ICommand command);

	public List<HouseFollow> findPaging(Integer houseReadilyId, Integer customerId, Integer ctype, PagingBean pagingBean);
	
	public List<HouseFollow> findByCustomerId(Integer customerId);
	
	public void delete(String ids);
	
	public QueryResult<HouseFollow> findByProperty(String propertyName, Object value, String order, String dir);
}