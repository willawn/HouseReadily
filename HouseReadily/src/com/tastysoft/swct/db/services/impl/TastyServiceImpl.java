package com.tastysoft.swct.db.services.impl;

import java.util.Collection;
import java.util.List;

import com.tastysoft.swct.db.dao.TastyDao;
import com.tastysoft.swct.db.model.TastyEntity;
import com.tastysoft.swct.db.services.TastyService;
import com.tastysoft.swct.db.table.TableParam;
import com.tastysoft.swct.db.table.TableSet;

/**
 * @author Seyo
 *
 */
public class TastyServiceImpl implements TastyService {
	
	private TastyDao tastyDao;

	public void delete(TastyEntity entity) {
		tastyDao.delete(entity);
		
	}
	public void insert(TastyEntity entity) {
		tastyDao.insert(entity);
		
	}
	public void save(TastyEntity entity) {
		tastyDao.save(entity);
		
	}
	public TastyDao getTastyDao() {
		return tastyDao;
	}

	public void setTastyDao(TastyDao tastyDao) {
		this.tastyDao = tastyDao;
	}

	public List<TastyEntity> getAll(String ctable) {
		return tastyDao.getAll(ctable);
	}

	public void delete(TastyEntity entity,String idvalue) {
		 tastyDao.delete(entity,idvalue);
	}
	public TastyEntity get(TastyEntity entity,String idvalue) {
		// TODO Auto-generated method stub
		return  tastyDao.get(entity,idvalue);
	}
	public List<TastyEntity> get(String ctable, String property, String value) {
		// TODO Auto-generated method stub
		return tastyDao.get(ctable, property, value);
	}

	public boolean isExists(String ctable, String property, Object value,
			String id) {
		return tastyDao.isExists(ctable, property, value,id);
	}

	public List<TastyEntity> get(String ctable, String property, int value) {
		return tastyDao.get(ctable, property, value);
	}

	public void delete(String ctable, String property, String value) {
		tastyDao.delete(ctable, property, value);
		
	}

	public void delete(String ctable, String property, int value) {
		tastyDao.delete(ctable, property, value);
	}

	public List<TastyEntity> find(String ctable, String property,
			Collection lists) {
		return tastyDao.find(ctable, property, lists);
	}

	public Object getValue(String hql) {
		return this.tastyDao.getValue(hql);
	}

	public Object excute(String sql) {
		// TODO Auto-generated method stub
		return this.tastyDao.excute(sql);
	}

	public TableSet findExtjs(String ctable,TableParam jsonParam){
		return this.tastyDao.findExtjs(ctable, jsonParam);
	}
	

	public List excuteSql(String sql,Class cls) {
		return this.tastyDao.excuteSql(sql,cls);
	}
	
	
}
