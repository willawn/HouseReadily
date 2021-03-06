﻿package com.huzhiyi.housereadily.biz;

import com.huzhiyi.housereadily.entity.UserExt;
import java.io.Serializable;
import java.util.List;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 UserExt DAO Interface
 */
public abstract interface IAbstractuserExtService {
	/**
	 *查询所有
	 */
	List<UserExt> findAll();

	/**
	 *根据实例查询
	 */
	QueryResult<UserExt> findByExample(UserExt example);

	/**
	 *根据属性名查询
	 */
	QueryResult<UserExt> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	UserExt findById(Integer id);

	/**
	 *新增操作
	 */
	void add(UserExt example);

	/**
	 *更新操作
	 */
	void update(UserExt example);

	/**
	 *删除操作
	 */
	void delete(UserExt example);
}