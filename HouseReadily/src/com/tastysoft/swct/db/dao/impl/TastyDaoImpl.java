package com.tastysoft.swct.db.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tastysoft.swct.db.dao.TastyDao;
import com.tastysoft.swct.db.model.TastyEntity;
import com.tastysoft.swct.db.table.TableParam;
import com.tastysoft.swct.db.table.TableParamFilter;
import com.tastysoft.swct.db.table.TableSet;

/**
 * @author Seyo
 * 100610
 */
public class TastyDaoImpl extends HibernateDaoSupport implements TastyDao{

	public void save(TastyEntity entity){
		this.getHibernateTemplate().saveOrUpdate(entity);
	}
	
	public void insert(TastyEntity entity){
		this.getHibernateTemplate().save(entity);
	}
	
	public void delete(TastyEntity entity){
		this.getHibernateTemplate().delete(entity);
	}
	
	public void delete(String ctable ,String property, String value){
		List<TastyEntity> list = this.get(ctable, property, value);
		for(int i=0;i<list.size();i++){
			delete(list.get(i));
		}
	}
	
	public void delete(String ctable ,String property, int value){
		List<TastyEntity> list = this.get(ctable, property, value);
		for(int i=0;i<list.size();i++){
			delete(list.get(i));
		}
	}
	
	public Object getValue(String hql){
		Object obj  = this.getHibernateTemplate().find(hql);
		return obj;
	}
	
	public List<TastyEntity> find(String ctable,String property,Collection lists) {
		String alias = ctable+"_";
		String filter ="(";
		List<TastyEntity> list = null;
		Object obj = null;
		for(Iterator it = lists.iterator();it.hasNext();){
			obj = it.next();
			if(obj instanceof String){
				filter+="'"+obj.toString()+"',";
			}else{
				filter+= String.valueOf(obj)+",";
			}
		}
		filter = filter.substring(0,filter.length()-1)+")";
		list = this.getHibernateTemplate().find("select "+alias+" from " + ctable +" " +alias+" where "+alias+"."
				+ property + " in" +filter);
		return list;
	}

	public List<TastyEntity> getAll(String ctable) {
		String alias = ctable+"_";
		List<TastyEntity> list = null;
		list = this.getHibernateTemplate().find("select "+alias+" from " + ctable +" " +alias);
		return list;
	}
	public void delete(TastyEntity entity,String idvalue) {
		this.getHibernateTemplate().load(entity, Integer.valueOf(idvalue));
		this.delete(entity);	
	}
	
	public TastyEntity get(TastyEntity entity,String idvalue) {
		this.getHibernateTemplate().load(entity, Integer.valueOf(idvalue));
		return entity;

	}

	public List<TastyEntity> get(String ctable ,String property, String value) {
		List<TastyEntity> list = null;
		String alias = ctable+"_";
		list = this.getHibernateTemplate().find(
				"select "+alias+" from "+ctable+" "+alias+" where "+alias+"."
						+ property + "='" + value + "'");
		return list;
	}
	
	public List<TastyEntity> get(String ctable ,String property, int value) {
		List<TastyEntity> list = null;
		String alias = ctable+"_";
		list = this.getHibernateTemplate().find(
				"select "+alias+" from "+ctable+" "+alias+" where "+alias+"."
						+ property + "=" + value);
		return list;
	}
	
	public boolean isExists(String ctable ,String property, Object value, String id) {
		String valueStr="";
		if(value instanceof Integer){
			valueStr = String.valueOf(value);
		}else{
			valueStr = "'"+value.toString()+"'";
		}
		List<TastyEntity> list = null;
		String alias = ctable+"_";
		if(id!=null&&!"".equals(id)){
			list = this.getHibernateTemplate().find(
					"select "+alias+" from "+ctable+" "+alias+" where "+alias+"."
							+ property + "=" + valueStr + " and "+alias+".id <>"+id);
		}else
		list = this.getHibernateTemplate().find(
				"select "+alias+" from "+ctable+" "+alias+" where "+alias+"."
						+ property + "=" + valueStr + "");
		if (list.iterator().hasNext())
			return true;
		else
			return false;
	}
	
	public TableSet findExtjs(String ctable,TableParam tableParam/*,String extendSql*/) {
		TableSet tableSet = new TableSet();
		String alias = ctable+"_";
		String totalsql = "select count(*) from " + ctable +" "+alias;
		String pagesql ="select "+alias+" from " + ctable +" "+alias;
		String where =" where ";
		ArrayList<TableParamFilter> filters = tableParam.getFilters();
		TableParamFilter filter = null;
		String qs="";
		boolean mit = false;
		String mq=" ";
		for(int i=0;i<filters.size();i++){
			filter = filters.get(i);
			String datatype = filter.getFilterDataType();
			if(datatype.equals("string")){
				if(filter.getFilterField()!=null&&filter.getFilterField().indexOf(",")!=-1){
					qs =" "+ mq+ " (";
					String[] fieldSplit = filter.getFilterField().split(",");
					for(int k=0;k<fieldSplit.length;k++){
						String operator = filter.getFilterFieldComparison();
						if(operator!=null&&operator.equals("eq")){
							qs += alias+"."+fieldSplit[k]+" = '"+filter.getFilterDataValue()+"'";
						}else if(operator!=null&&operator.equals("neq")){
							qs = mq+alias+"."+fieldSplit[k]+" <> '"+filter.getFilterDataValue()+"'";
						}
						else
							qs += alias+"."+fieldSplit[k]+" like '%"+filter.getFilterDataValue()+"%'";
						if(k<fieldSplit.length-1)
							qs +=" Or ";
					}
					qs +=")";
					if(!mit){
						mit = true;
						mq = " and ";
					}
					where+=qs;
				}else if(filter.getFilterDataValue()!=null&&filter.getFilterDataValue().indexOf(",")!=-1){
					qs =" "+ mq+ " (";
					String[] fieldDataSplit = filter.getFilterDataValue().split(",");
					for(int k=0;k<fieldDataSplit.length;k++){
						String operator = filter.getFilterFieldComparison();
						if(operator!=null&&operator.equals("eq")){
							qs += alias+"."+filter.getFilterField()+" = '"+fieldDataSplit[k]+"'";
						}else if(operator!=null&&operator.equals("neq")){
							qs = mq+alias+"."+filter.getFilterField()+" <> '"+fieldDataSplit[k]+"'";
						}
						else
							qs += alias+"."+filter.getFilterField()+" like '%"+fieldDataSplit[k]+"%'";
						if(k<fieldDataSplit.length-1)
							qs +=" Or ";
					}
					qs +=")";
					if(!mit){
						mit = true;
						mq = " and ";
					}
					where+=qs;
				}else{
					String operator = filter.getFilterFieldComparison();
					if(operator!=null&&operator.equals("eq")){
						qs = mq+alias+"."+filter.getFilterField()+" = '"+filter.getFilterDataValue()+"'";
					}else if(operator!=null&&operator.equals("neq")){
						qs = mq+alias+"."+filter.getFilterField()+" <> '"+filter.getFilterDataValue()+"'";
					}
					else
						qs = mq+alias+"."+filter.getFilterField()+" like '%"+filter.getFilterDataValue()+"%'";
					if(!mit){
						mit = true;
						mq = " and ";
					}
					where+=qs;
				}
				
			}else if(datatype.equals("boolean")){
				int bvalue = 0;
				if(filter.getFilterDataValue().equals("true")){
					bvalue = 1;
				}
				
				qs = mq+alias+"."+filter.getFilterField()+" = "+bvalue;
				
				if(!mit){
					mit = true;
					mq = " and ";
				}
				where+=qs;
			}else if(datatype.equals("date")){
				String operator = filter.getFilterFieldComparison();
				String tdate = filter.getFilterDataValue();
				if(tdate==null)
					continue;
				if(operator.equals("eq")){
					qs = mq+alias+"."+filter.getFilterField()+" = '"+tdate+"'";
				}else if(operator.equals("lt")){
					qs = mq+alias+"."+filter.getFilterField()+" < '"+tdate+"'";
				}else if(operator.equals("gt")){
					qs = mq+alias+"."+filter.getFilterField()+" > '"+tdate+"'";
				}else if(operator.equals("le")){
					qs = mq+alias+"."+filter.getFilterField()+" <= '"+tdate+"'";
				}else if(operator.equals("ge")){
					qs = mq+alias+"."+filter.getFilterField()+" >= '"+tdate+"'";
				}
				
				if(!mit){
					mit = true;
					mq = " and ";
				}
				where+=qs;
			}else if(datatype.equals("numeric")){
				String operator = filter.getFilterFieldComparison();
				if(filter.getFilterField()!=null&&filter.getFilterField().indexOf(",")!=-1){
					qs =" "+ mq+ " (";
					String[] fieldSplit = filter.getFilterField().split(",");
					for(int k=0;k<fieldSplit.length;k++){
						qs += alias+"."+fieldSplit[k]+" = "+filter.getFilterDataValue()+"";
						if(k<fieldSplit.length-1)
							qs +=" Or ";
					}
					qs +=")";
					if(!mit){
						mit = true;
						mq = " and ";
					}
					where+=qs;
				}else if(operator.equals("eq")&&filter.getFilterDataValue()!=null&&filter.getFilterDataValue().indexOf(",")!=-1){
					qs =" "+ mq+ " (";
					String[] fieldSplit = filter.getFilterDataValue().split(",");
					for(int k=0;k<fieldSplit.length;k++){
						qs += alias+"."+filter.getFilterField()+" = "+fieldSplit[k]+"";
						if(k<fieldSplit.length-1)
							qs +=" Or ";
					}
					qs +=")";
					if(!mit){
						mit = true;
						mq = " and ";
					}
					where+=qs;
				}else{
					
					if(operator.equals("eq")){
						qs = mq+alias+"."+filter.getFilterField()+" = "+filter.getFilterDataValue();
					}else if(operator.equals("lt")){
						qs = mq+alias+"."+filter.getFilterField()+" < "+filter.getFilterDataValue();
					}else if(operator.equals("gt")){
						qs = mq+alias+"."+filter.getFilterField()+" > "+filter.getFilterDataValue();
					}else if(operator.equals("ge")){
						qs = mq+alias+"."+filter.getFilterField()+" >= "+filter.getFilterDataValue();
					}else if(operator.equals("le")){
						qs = mq+alias+"."+filter.getFilterField()+" <= "+filter.getFilterDataValue();
					}else if(operator.equals("in")){
						qs = mq+alias+"."+filter.getFilterField()+" in("+filter.getFilterDataValue()+")";
					}
					
					if(!mit){
						mit = true;
						mq = " and ";
					}
					where+=qs;
				}
			
		}else if(datatype.equals("listint")){
			
			
			if (filter.getFilterDataValue().indexOf(",")!=-1){
				String[] str =filter.getFilterDataValue().split(",");
				String intvalues="(";
				for (int k=0;k<str.length;k++){
					if(k==str.length-1){
						intvalues+=str[k];
					}else{
						intvalues+=str[k]+",";
					}
				}
				intvalues+=")";
				qs = mq+alias+"."+filter.getFilterField()+" in "+intvalues; 
			}else{
				qs = mq+alias+"."+filter.getFilterField()+" = "+filter.getFilterDataValue(); 
			}
			
			
			if(!mit){
				mit = true;
				mq = " and ";
			}
			where+=qs;
		}else if(datatype.equals("hqlstr")){
			String nsql = mq + filter.getFilterDataValue();
			if(!mit){
				mit = true;
				mq = " and ";
			}
			where+= nsql;
		}
	}
		if(!where.equals(" where ")){
			totalsql+=where;
			pagesql+=where;
		}
		
		//check extendSql
		if(tableParam.getExtendSql()!=null&&tableParam.getExtendSql().length()>0){
			String extendSql = tableParam.getExtendSql();
			if(!where.equals(" where ")){
				extendSql = " and "+extendSql;
			}else{
				extendSql = where+extendSql;
			}
			
			totalsql+=extendSql;
			pagesql+=extendSql;
		}
		
		long count = (Long)getHibernateTemplate().find(totalsql).listIterator().next();
		tableSet.setTotal((int)count);
		if(tableParam.getSort().indexOf(",")>-1){
			String orderStr="";
			String[] sortSplit = tableParam.getSort().split(",");
			String[] dirSplit = tableParam.getDir().split(",");
			for(int i=0;i<sortSplit.length;i++){
				orderStr+= alias +"."+sortSplit[i]+" "+dirSplit[i];
				if(i<sortSplit.length-1){
					orderStr+= " , ";
				}
			}
			pagesql += " order by " + orderStr ;
		}else{
			pagesql += " order by "+alias +"."+tableParam.getSort()+" "+tableParam.getDir();
		}
		
		
		List<TastyEntity> list = null;
		list = this.findPage(pagesql,tableParam.getStart(),tableParam.getLimit());
		tableSet.setList(list);
		return tableSet;
	}
	/*public TableSet findExtjs(String ctable,TableParam tableParam) {
		return findExtjs(ctable,tableParam,"");
	}*/
	
	
	
	/**
	 * 分页查询
	 * 
	 * @param sql
	 *            String
	 * @param firstRow
	 *            int
	 * @param maxRow
	 *            int
	 * @return List
	 */
	public List findPage(final String sql, final int firstRow, final int maxRow) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws SQLException,
					HibernateException {
				Query q = session.createQuery(sql);
				if(maxRow!=0){
					q.setFirstResult(firstRow);
					q.setMaxResults(maxRow);
				}
				return q.list();
			}
		});
	}
	
	public List excuteSql(final String sql,final Class cls) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws SQLException,
					HibernateException {
				Query q = session.createSQLQuery(sql).addEntity(cls);
				return q.list();
			}
		});
	}
	
	public Object excute(final String sql) {    
		  return this.getHibernateTemplate().execute(new HibernateCallback() {    
		   public Object doInHibernate(Session session) throws HibernateException,    
		     SQLException {    
			   return session.createQuery(sql).executeUpdate();    
		   }    
		  });    
	}    
	
	public List<TastyEntity> getEntityList(TastyEntity entity) {
		// TODO Auto-generated method stub
		return (List<TastyEntity>)this.getHibernateTemplate().findByExample(entity); 
	}    


}
