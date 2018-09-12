package com.huzhiyi.housereadily.biz;

import java.util.List;

import com.huzhiyi.housereadily.entity.HouseAttachment;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 HouseAttachment DAO Interface
 */
public abstract interface IAbstracthouseAttachmentService {
	/**
	 *查询所有
	 */
	List<HouseAttachment> findAll();

	/**
	 *根据实例查询
	 */
	QueryResult<HouseAttachment> findByExample(HouseAttachment example);

	/**
	 *根据属性名查询
	 */
	QueryResult<HouseAttachment> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	HouseAttachment findById(Integer id);

	/**
	 *新增操作
	 */
	void add(HouseAttachment example);

	/**
	 *更新操作
	 */
	void update(HouseAttachment example);

	/**
	 *删除操作
	 */
	void delete(HouseAttachment example);
}