package com.huzhiyi.housereadily.dao;

import java.util.List;

import com.huzhiyi.annotation.RDEDao;
import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 HouseReadily DAO Interface
 */
@RDEDao
public abstract interface IAbstracthouseReadilyDAO {
	/**
	 *查询所有
	 */
	List<HouseReadily> findAll();

	/**
	 *根据HQL查询
	 */
	QueryResult<HouseReadily> findByHQL(String hql);

	/**
	 *根据实例查询
	 */
	QueryResult<HouseReadily> findByExample(HouseReadily example);

	/**
	 *根据属性名查询
	 */
	QueryResult<HouseReadily> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	HouseReadily findById(Integer id);

	/**
	 *新增操作
	 */
	void add(HouseReadily example);

	/**
	 *更新操作
	 */
	void update(HouseReadily example);

	/**
	 *删除操作
	 */
	void delete(HouseReadily example);
}