package com.huzhiyi.housereadily.dao;

import java.util.List;

import com.huzhiyi.annotation.RDEDao;
import com.huzhiyi.housereadily.entity.Broker;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Broker DAO Interface
 */
@RDEDao
public abstract interface IAbstractbrokerDAO {
	/**
	 *查询所有
	 */
	List<Broker> findAll();

	/**
	 *根据HQL查询
	 */
	QueryResult<Broker> findByHQL(String hql);

	/**
	 *根据实例查询
	 */
	QueryResult<Broker> findByExample(Broker example);

	/**
	 *根据属性名查询
	 */
	QueryResult<Broker> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	Broker findById(Integer id);

	/**
	 *新增操作
	 */
	void add(Broker example);

	/**
	 *更新操作
	 */
	void update(Broker example);

	/**
	 *删除操作
	 */
	void delete(Broker example);
}