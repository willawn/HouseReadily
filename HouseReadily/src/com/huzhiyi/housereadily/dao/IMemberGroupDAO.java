package com.huzhiyi.housereadily.dao;

import java.util.List;

import com.huzhiyi.housereadily.entity.MemberGroup;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.model.abstraction.QueryResult;

public interface IMemberGroupDAO extends IAbstractmemberGroupDAO {

	public QueryResult<MemberGroup> findByProperty(String propertyName, Object value, String order, String dir);
	
	public MemberGroup findByMemberGroup(Integer baseGroupId, Integer userId);
	
	public List<MemberGroup> findPaging(Integer baseGroupId, String sort, String dir, PagingBean pagingBean);
}