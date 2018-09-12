package com.huzhiyi.housereadily.biz;

import com.huzhiyi.housereadily.entity.HouseOwner;
import java.io.Serializable;
import java.util.List;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 HouseOwner DAO Interface
 */
public abstract interface IAbstracthouseOwnerService {
	/**
	 *查询所有
	 */
	List<HouseOwner> findAll();

	/**
	 *根据实例查询
	 */
	QueryResult<HouseOwner> findByExample(HouseOwner example);

	/**
	 *根据属性名查询
	 */
	QueryResult<HouseOwner> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	HouseOwner findById(Integer id);

	/**
	 *新增操作
	 */
	void add(HouseOwner example);

	/**
	 *更新操作
	 */
	void update(HouseOwner example);

	/**
	 *删除操作
	 */
	void delete(HouseOwner example);
}