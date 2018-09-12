package com.huzhiyi.housereadily.biz;

import java.io.Serializable;
import java.util.List;

import com.huzhiyi.housereadily.entity.Code;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Code DAO Interface
 */
public abstract interface IAbstractcodeService {
	/**
	 *查询所有
	 */
	List<Code> findAll();

	/**
	 *根据实例查询
	 */
	QueryResult<Code> findByExample(Code example);

	/**
	 *根据属性名查询
	 */
	QueryResult<Code> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	Code findById(Integer id);

	/**
	 *新增操作
	 */
	void add(Code example);

	/**
	 *更新操作
	 */
	void update(Code example);

	/**
	 *删除操作
	 */
	void delete(Code example);
}