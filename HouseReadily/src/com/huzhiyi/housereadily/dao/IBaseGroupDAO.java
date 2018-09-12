package com.huzhiyi.housereadily.dao;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.BaseGroup;
import com.huzhiyi.model.PagingBean;

public interface IBaseGroupDAO extends IAbstractbaseGroupDAO {
	
	public List<BaseGroup> findPaging(Integer userId, String sort, String dir, PagingBean pagingBean) throws Exception;
	
	public Integer findCountByUserId(Integer userId);
	
	public BaseGroup findByGroupNum(String groupNum);
	
	public List<BaseGroup> findPaging(Integer id, Integer level, String groupNum, String groupName, Integer cityCode, Integer bigAreaCode,
			Integer smallAreaCode, String userName, Date beginDate, Date endDate, Integer isDelete, String sort, String dir, PagingBean pagingBean );
}