package com.huzhiyi.housereadily.dao.impl;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.comm.dao.HibernateBaseDAO;
import java.io.Serializable;
import java.util.List;
import com.huzhiyi.model.abstraction.QueryResult;
import com.huzhiyi.housereadily.dao.IAbstractuserDAO;
import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.housereadily.entity.HouseReadily;
/**
*RDE(快速开发环境)自动生成代码
*CUser DAO Implement Class
*/
@SuppressWarnings("unchecked")
public abstract class AbstractUserDAOImpl extends HibernateBaseDAO<Integer> implements IAbstractuserDAO{
	/**
	*查询所有
	*/
	public List<CUser> findAll(){
		return super.findAll();
	}
	/**
	*根据HQL查询
	*/
	public QueryResult<CUser> findByHQL(String hql){
		return super.findByHQL(hql);
	}
	/**
	*根据实例查询
	*/
	public QueryResult<CUser> findByExample(CUser example){
		return super.findByExample(example);
	}
	/**
	*根据属性名查询
	*/
	public QueryResult<CUser> findByProperty(String propertyName,Object value){
		return super.findByProperty(propertyName, value);
	}
	/**
	*根据ID查询
	*/
	public CUser findById(Integer id){
		return (CUser)super.findById(id);
	}
	/**
	*新增操作
	*/
	public void add(CUser example){
		super.save(example);
	}
	/**
	*更新操作
	*/
	public void update(CUser example){
		super.update(example);
	}
	/**
	*删除操作
	*/
	public void delete(CUser example){
		super.delete(example);
	}
	
	@Override
	protected Class getEntityClass() {
		return CUser.class;
	}
	
	/**
	 *查询指定用户的客源
	 */
	public List<Customer> findCreater(Integer creater){
		//return null;{"id", "isMain", "customerId", "customerName", "gender", "phone", "mobile" }
		String hql = "from com.huzhiyi.housereadily.entity.Customer where (isDelete is null or isDelete = 1) and creater = ? order by updateTime desc";
		return (List<Customer>)super.findByHQL(hql, creater).getList();
	}
	
	/**
	 *查询指定用户的客源
	 */
	public List<HouseReadily> findReadilyCreater(Integer creater){
		//return null;{"id", "isMain", "customerId", "customerName", "gender", "phone", "mobile" }
		String hql = "from com.huzhiyi.housereadily.entity.HouseReadily o where (o.isDelete is null or o.isDelete = 1) and o.creater = ? order by o.updateTime desc";
		return (List<HouseReadily>)super.findByHQL(hql, creater).getList();
	}
}