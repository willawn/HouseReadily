package com.tastysoft.swct.db.dao;

import java.util.Collection;
import java.util.List;

import com.tastysoft.swct.db.model.TastyEntity;
import com.tastysoft.swct.db.table.TableParam;
import com.tastysoft.swct.db.table.TableSet;
/**
 * @author Seyo
 *
 */
public interface TastyDao {
	public void save(TastyEntity entity);
	public void insert(TastyEntity entity);
	public void delete(TastyEntity entity);
	public void delete(TastyEntity entity,String idvalue);
	public TastyEntity get(TastyEntity entity,String idvalue);
	public List<TastyEntity> get(String ctable ,String property, String value);
	public List<TastyEntity> getAll(String ctable);
	public boolean isExists(String ctable ,String property, Object value, String id);
	public List<TastyEntity> get(String ctable ,String property, int value);
	public void delete(String ctable ,String property, String value);
	public void delete(String ctable ,String property, int value);
	public List<TastyEntity> find(String ctable,String property,Collection lists);
	public Object getValue(String hql);
	public Object excute(final String sql);
	public TableSet findExtjs(String ctable,TableParam tableParam);
	//public TableSet findExtjs(String ctable,TableParam tableParam,String extendSql);
	public List excuteSql(final String sql,Class cls);
	public List<TastyEntity> getEntityList(TastyEntity entity); 
}
