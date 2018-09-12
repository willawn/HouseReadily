package com.huzhiyi.housereadily.dao;

import java.util.List;

import com.huzhiyi.annotation.RDEDao;
import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 CUser DAO Interface
 */
@RDEDao
public abstract interface IAbstractuserDAO {
	/**
	 *查询所有
	 */
	List<CUser> findAll();

	/**
	 *根据HQL查询
	 */
	QueryResult<CUser> findByHQL(String hql);

	/**
	 *根据实例查询
	 */
	QueryResult<CUser> findByExample(CUser example);

	/**
	 *根据属性名查询
	 */
	QueryResult<CUser> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	CUser findById(Integer id);

	/**
	 *新增操作
	 */
	void add(CUser example);

	/**
	 *更新操作
	 */
	void update(CUser example);

	/**
	 *删除操作
	 */
	void delete(CUser example);

	/**
	 *查询指定用户的客源
	 */
	List<Customer> findCreater(Integer creater);

	/**
	 *查询指定用户的房源
	 */
	List<HouseReadily> findReadilyCreater(Integer creater);
}