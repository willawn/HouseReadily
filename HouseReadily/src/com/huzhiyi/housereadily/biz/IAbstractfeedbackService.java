package com.huzhiyi.housereadily.biz;

import java.util.List;

import com.huzhiyi.housereadily.entity.Feedback;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Feedback DAO Interface
 */
public abstract interface IAbstractfeedbackService {
	/**
	 *查询所有
	 */
	List<Feedback> findAll();

	/**
	 *根据实例查询
	 */
	QueryResult<Feedback> findByExample(Feedback example);

	/**
	 *根据属性名查询
	 */
	QueryResult<Feedback> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	Feedback findById(Integer id);

	/**
	 *新增操作
	 */
	void add(Feedback example);

	/**
	 *更新操作
	 */
	void update(Feedback example);

	/**
	 *删除操作
	 */
	void delete(Feedback example);
}