package com.huzhiyi.housereadily.biz.impl;
import com.huzhiyi.housereadily.entity.HouseReadily;
import java.io.Serializable;
import java.util.List;
import com.huzhiyi.model.abstraction.QueryResult;
import com.huzhiyi.housereadily.dao.IHouseReadilyDAO;
import com.huzhiyi.housereadily.biz.IAbstracthouseReadilyService;
/**
*RDE(快速开发环境)自动生成代码
*HouseReadily Biz Implement Class
*/
public abstract class AbstractHouseReadilyServiceImpl implements IAbstracthouseReadilyService{
	/**
	*DAO对象注入
	*/
	private IHouseReadilyDAO houseReadilyDAO;
	public IHouseReadilyDAO getHouseReadilyDAO(){
		return this.houseReadilyDAO;
	}
	public void setHouseReadilyDAO(IHouseReadilyDAO houseReadilyDAO){
		this.houseReadilyDAO=houseReadilyDAO;
	}
	/**
	*查询所有
	*/
	public List<HouseReadily> findAll(){
		return houseReadilyDAO.findAll();
	}
	/**
	*根据实例查询
	*/
	public QueryResult<HouseReadily> findByExample(HouseReadily example){
		return houseReadilyDAO.findByExample(example);
	}
	/**
	*根据属性名查询
	*/
	public QueryResult<HouseReadily> findByProperty(String propertyName,Object value){
		return houseReadilyDAO.findByProperty(propertyName, value);
	}
	/**
	*根据ID查询
	*/
	public HouseReadily findById(Integer id){
		return houseReadilyDAO.findById(id);
	}
	/**
	*新增操作
	*/
	public void add(HouseReadily example){
		houseReadilyDAO.add(example);
	}
	/**
	*更新操作
	*/
	public void update(HouseReadily example){
		houseReadilyDAO.update(example);
	}
	/**
	*删除操作
	*/
	public void delete(HouseReadily example){
		houseReadilyDAO.delete(example);
	}
}