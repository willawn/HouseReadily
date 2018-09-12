package com.huzhiyi.housereadily.dao;

import java.util.List;

import com.huzhiyi.annotation.RDEDao;
import com.huzhiyi.housereadily.entity.OperateLog;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 OperateLog DAO Interface
 */
@RDEDao
public abstract interface IAbstractoperateLogDAO {
	/**
	 *查询所有
	 */
	List<OperateLog> findAll();

	/**
	 *根据HQL查询
	 */
	QueryResult<OperateLog> findByHQL(String hql);

	/**
	 *根据实例查询
	 */
	QueryResult<OperateLog> findByExample(OperateLog example);

	/**
	 *根据属性名查询
	 */
	QueryResult<OperateLog> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	OperateLog findById(Integer id);

	/**
	 *新增操作
	 */
	void add(OperateLog example);

	/**
	 *更新操作
	 */
	void update(OperateLog example);

	/**
	 *删除操作
	 */
	void delete(OperateLog example);
}