package com.huzhiyi.housereadily.dao;

import java.util.List;

import com.huzhiyi.annotation.RDEDao;
import com.huzhiyi.housereadily.entity.Task;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Task DAO Interface
 */
@RDEDao
public abstract interface IAbstracttaskDAO {
	/**
	 *查询所有
	 */
	List<Task> findAll();

	/**
	 *根据HQL查询
	 */
	QueryResult<Task> findByHQL(String hql);

	/**
	 *根据实例查询
	 */
	QueryResult<Task> findByExample(Task example);

	/**
	 *根据属性名查询
	 */
	QueryResult<Task> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	Task findById(Integer id);

	/**
	 *新增操作
	 */
	void add(Task example);

	/**
	 *更新操作
	 */
	void update(Task example);

	/**
	 *删除操作
	 */
	void delete(Task example);
}