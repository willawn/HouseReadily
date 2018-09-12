package com.huzhiyi.housereadily.biz;

import com.huzhiyi.housereadily.entity.HouseReadily;
import java.io.Serializable;
import java.util.List;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 HouseReadily DAO Interface
 */
public abstract interface IAbstracthouseReadilyService {
	/**
	 *查询所有
	 */
	List<HouseReadily> findAll();

	/**
	 *根据实例查询
	 */
	QueryResult<HouseReadily> findByExample(HouseReadily example);

	/**
	 *根据属性名查询
	 */
	QueryResult<HouseReadily> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	HouseReadily findById(Integer id);

	/**
	 *新增操作
	 */
	void add(HouseReadily example);

	/**
	 *更新操作
	 */
	void update(HouseReadily example);

	/**
	 *删除操作
	 */
	void delete(HouseReadily example);
}