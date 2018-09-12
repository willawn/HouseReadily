package com.huzhiyi.housereadily.dao;

import java.util.List;

import com.huzhiyi.annotation.RDEDao;
import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Customer DAO Interface
 */
@RDEDao
public abstract interface IAbstractcustomerDAO {
	/**
	 *查询所有
	 */
	List<Customer> findAll();

	/**
	 *根据HQL查询
	 */
	QueryResult<Customer> findByHQL(String hql);

	/**
	 *根据实例查询
	 */
	QueryResult<Customer> findByExample(Customer example);

	/**
	 *根据属性名查询
	 */
	QueryResult<Customer> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	Customer findById(Integer id);

	/**
	 *新增操作
	 */
	void add(Customer example);

	/**
	 *更新操作
	 */
	void update(Customer example);

	/**
	 *删除操作
	 */
	void delete(Customer example);
}