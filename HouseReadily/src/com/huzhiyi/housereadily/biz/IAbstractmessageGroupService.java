package com.huzhiyi.housereadily.biz;

import java.util.List;

import com.huzhiyi.housereadily.entity.MessageGroup;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 MessageGroup DAO Interface
 */
public abstract interface IAbstractmessageGroupService {
	/**
	 *查询所有
	 */
	List<MessageGroup> findAll();

	/**
	 *根据实例查询
	 */
	QueryResult<MessageGroup> findByExample(MessageGroup example);

	/**
	 *根据属性名查询
	 */
	QueryResult<MessageGroup> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	MessageGroup findById(Integer id);

	/**
	 *新增操作
	 */
	void add(MessageGroup example);

	/**
	 *更新操作
	 */
	void update(MessageGroup example);

	/**
	 *删除操作
	 */
	void delete(MessageGroup example);
}
