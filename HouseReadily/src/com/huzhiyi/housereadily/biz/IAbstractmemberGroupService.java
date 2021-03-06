﻿package com.huzhiyi.housereadily.biz;

import java.util.List;

import com.huzhiyi.housereadily.entity.MemberGroup;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 MemberGroup DAO Interface
 */
public abstract interface IAbstractmemberGroupService {
	/**
	 *查询所有
	 */
	List<MemberGroup> findAll();

	/**
	 *根据实例查询
	 */
	QueryResult<MemberGroup> findByExample(MemberGroup example);

	/**
	 *根据属性名查询
	 */
	QueryResult<MemberGroup> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	MemberGroup findById(Integer id);

	/**
	 *新增操作
	 */
	void add(MemberGroup example);

	/**
	 *更新操作
	 */
	void update(MemberGroup example);

	/**
	 *删除操作
	 */
	void delete(MemberGroup example);
}