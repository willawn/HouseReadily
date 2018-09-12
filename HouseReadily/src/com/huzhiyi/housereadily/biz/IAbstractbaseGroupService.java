package com.huzhiyi.housereadily.biz;

import java.util.List;

import com.huzhiyi.housereadily.entity.BaseGroup;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 BaseGroup DAO Interface
 */
public abstract interface IAbstractbaseGroupService {
	/**
	 *查询所有
	 */
	List<BaseGroup> findAll();

	/**
	 *根据实例查询
	 */
	QueryResult<BaseGroup> findByExample(BaseGroup example);

	/**
	 *根据属性名查询
	 */
	QueryResult<BaseGroup> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	BaseGroup findById(Integer id);

	/**
	 *新增操作
	 */
	void add(BaseGroup example);

	/**
	 *更新操作
	 */
	void update(BaseGroup example);

	/**
	 *删除操作
	 */
	void delete(BaseGroup example);
}