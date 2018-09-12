package com.huzhiyi.housereadily.dao;

import java.util.List;

import com.huzhiyi.annotation.RDEDao;
import com.huzhiyi.housereadily.entity.HouseFollow;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 HouseFollow DAO Interface
 */
@RDEDao
public abstract interface IAbstracthouseFollowDAO {
	/**
	 *查询所有
	 */
	List<HouseFollow> findAll();

	/**
	 *根据HQL查询
	 */
	QueryResult<HouseFollow> findByHQL(String hql);

	/**
	 *根据实例查询
	 */
	QueryResult<HouseFollow> findByExample(HouseFollow example);

	/**
	 *根据属性名查询
	 */
	QueryResult<HouseFollow> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	HouseFollow findById(Integer id);

	/**
	 *新增操作
	 */
	void add(HouseFollow example);

	/**
	 *更新操作
	 */
	void update(HouseFollow example);

	/**
	 *删除操作
	 */
	void delete(HouseFollow example);
}