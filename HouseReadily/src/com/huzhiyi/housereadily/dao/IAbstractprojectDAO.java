﻿package com.huzhiyi.housereadily.dao;

import java.util.List;

import com.huzhiyi.annotation.RDEDao;
import com.huzhiyi.housereadily.model.CProject;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 CProject DAO Interface
 */
@RDEDao
public abstract interface IAbstractprojectDAO {
	/**
	 *查询所有
	 */
	List<CProject> findAll();

	/**
	 *根据HQL查询
	 */
	QueryResult<CProject> findByHQL(String hql);

	/**
	 *根据实例查询
	 */
	QueryResult<CProject> findByExample(CProject example);

	/**
	 *根据属性名查询
	 */
	QueryResult<CProject> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	CProject findById(Integer id);

	/**
	 *新增操作
	 */
	void add(CProject example);

	/**
	 *更新操作
	 */
	void update(CProject example);

	/**
	 *删除操作
	 */
	void delete(CProject example);
}