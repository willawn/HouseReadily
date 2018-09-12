package com.huzhiyi.housereadily.biz;

import java.util.List;

import com.huzhiyi.housereadily.entity.TaskLog;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 TaskLog DAO Interface
 */
public abstract interface IAbstracttaskLogService {
	/**
	 *查询所有
	 */
	List<TaskLog> findAll();

	/**
	 *根据实例查询
	 */
	QueryResult<TaskLog> findByExample(TaskLog example);

	/**
	 *根据属性名查询
	 */
	QueryResult<TaskLog> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	TaskLog findById(Integer id);

	/**
	 *新增操作
	 */
	void add(TaskLog example);

	/**
	 *更新操作
	 */
	void update(TaskLog example);

	/**
	 *删除操作
	 */
	void delete(TaskLog example);
}