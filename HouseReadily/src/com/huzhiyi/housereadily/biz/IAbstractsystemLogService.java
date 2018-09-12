package com.huzhiyi.housereadily.biz;

import java.util.List;

import com.huzhiyi.housereadily.entity.SystemLog;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 SystemLog DAO Interface
 */
public abstract interface IAbstractsystemLogService {
	/**
	 *查询所有
	 */
	List<SystemLog> findAll();

	/**
	 *根据实例查询
	 */
	QueryResult<SystemLog> findByExample(SystemLog example);

	/**
	 *根据属性名查询
	 */
	QueryResult<SystemLog> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	SystemLog findById(Integer id);

	/**
	 *新增操作
	 */
	void add(SystemLog example);

	/**
	 *更新操作
	 */
	void update(SystemLog example);

	/**
	 *删除操作
	 */
	void delete(SystemLog example);
}