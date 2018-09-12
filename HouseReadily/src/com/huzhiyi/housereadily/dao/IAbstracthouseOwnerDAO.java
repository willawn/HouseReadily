package com.huzhiyi.housereadily.dao;

import com.huzhiyi.housereadily.entity.HouseOwner;
import java.io.Serializable;
import java.util.List;
import com.huzhiyi.model.abstraction.QueryResult;
import com.huzhiyi.annotation.RDEDao;
import com.huzhiyi.annotation.RDEQueryMethod;

/**
 *RDE(快速开发环境)自动生成代码 HouseOwner DAO Interface
 */
@RDEDao
public abstract interface IAbstracthouseOwnerDAO {
	/**
	 *查询所有
	 */
	List<HouseOwner> findAll();

	/**
	 *根据HQL查询
	 */
	QueryResult<HouseOwner> findByHQL(String hql);

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

	/**
	 *根据customerI;查询this,排序:createTime asc
	 */
	@RDEQueryMethod(queryName = "com.huzhiyi.housereadily.entity.HouseOwner:this", findType = "find", paramters = "java.lang.Integer:customerId", order = "createTime asc")
	QueryResult<HouseOwner> findHouseOwnerByCustomerId(Integer customerId);

	/**
	 *根据houseReadilyI;查询this,排序:createTime asc
	 */
	@RDEQueryMethod(queryName = "com.huzhiyi.housereadily.entity.HouseOwner:this", findType = "find", paramters = "java.lang.Integer:houseReadilyId", order = "createTime asc")
	QueryResult<HouseOwner> findHouseOwnerByHouseReadilyId(Integer houseReadilyId);
}