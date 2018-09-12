package com.huzhiyi.housereadily.biz.impl;
import com.huzhiyi.housereadily.entity.HouseFollow;
import java.io.Serializable;
import java.util.List;
import com.huzhiyi.model.abstraction.QueryResult;
import com.huzhiyi.housereadily.dao.IHouseFollowDAO;
import com.huzhiyi.housereadily.biz.IAbstracthouseFollowService;
/**
*RDE(快速开发环境)自动生成代码
*HouseFollow Biz Implement Class
*/
public abstract class AbstractHouseFollowServiceImpl implements IAbstracthouseFollowService{
	/**
	*DAO对象注入
	*/
	private IHouseFollowDAO houseFollowDAO;
	public IHouseFollowDAO getHouseFollowDAO(){
		return this.houseFollowDAO;
	}
	public void setHouseFollowDAO(IHouseFollowDAO houseFollowDAO){
		this.houseFollowDAO=houseFollowDAO;
	}
	/**
	*查询所有
	*/
	public List<HouseFollow> findAll(){
		return houseFollowDAO.findAll();
	}
	/**
	*根据实例查询
	*/
	public QueryResult<HouseFollow> findByExample(HouseFollow example){
		return houseFollowDAO.findByExample(example);
	}
	/**
	*根据属性名查询
	*/
	public QueryResult<HouseFollow> findByProperty(String propertyName,Object value){
		return houseFollowDAO.findByProperty(propertyName, value);
	}
	/**
	*根据ID查询
	*/
	public HouseFollow findById(Integer id){
		return houseFollowDAO.findById(id);
	}
	/**
	*新增操作
	*/
	public void add(HouseFollow example){
		houseFollowDAO.add(example);
	}
	/**
	*更新操作
	*/
	public void update(HouseFollow example){
		houseFollowDAO.update(example);
	}
	/**
	*删除操作
	*/
	public void delete(HouseFollow example){
		houseFollowDAO.delete(example);
	}
}