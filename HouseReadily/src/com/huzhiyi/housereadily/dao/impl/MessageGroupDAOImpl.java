package com.huzhiyi.housereadily.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.huzhiyi.housereadily.dao.IMessageGroupDAO;
import com.huzhiyi.housereadily.entity.MessageGroup;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.model.abstraction.QueryResult;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.utils.Constants;

public class MessageGroupDAOImpl extends AbstractMessageGroupDaoImpl implements IMessageGroupDAO {

	@Override
	public QueryResult<MessageGroup> findByProperty(String[] propertyNames, Object[] values, String order, String dir) {
		return super.findByProperty(propertyNames, values, order, dir);
	}
	
	@Override
	public Integer findCoundMessage(Integer baseGroupId, Integer mtype, Date date){
		StringBuffer hql = new StringBuffer();
		hql.append("select count(*) from readily_messagegroup where isDelete = 1");
		if(null != baseGroupId && baseGroupId >0){
			hql.append(" and baseGroupId = ").append(baseGroupId);
		}
		if(null != mtype && mtype > 0){
			hql.append(" and mtype = ").append(mtype);
		}
		if(null != date){
			hql.append(" and createTime > '").append(DateUtils.format(date, Constants.DATEFORMAT)).append("'");
		}
		Query countQuery = this.getSession().createSQLQuery(hql.toString());
		Long cnt = ((java.math.BigInteger) countQuery.uniqueResult()).longValue();
		return cnt.intValue();
	}
	
	@Override
	public void deleteByUserId(Integer baseGroupId, Integer userId) {
		String hql = "update com.huzhiyi.housereadily.entity.MessageGroup set isDelete = 0 where baseGroupId = ? and creater = ? and isDelete = 1";
		super.executeUpdate(hql, baseGroupId, userId);
	}
	
	@Override
	public MessageGroup findByMessageGroup(Integer baseGroupId, Integer userId,
			Integer mtype, Integer source, Date date) {
		String hql = "select o from com.huzhiyi.housereadily.entity.MessageGroup o where o.baseGroupId = ? and o.creater = ? and mtype = ? and source = ? and createTime > ? and isDelete = 1";
		return (MessageGroup) super.findByHQL(hql.toString(), baseGroupId, userId, mtype, source, date).getUniqueResult();
	}

	@Override
	public void deleteById(Integer id) {
		String hql = "update com.huzhiyi.housereadily.entity.MessageGroup set isDelete = 0 where id = ? and isDelete = 1";
		super.executeUpdate(hql, id);
	}
	
	@Override
	public List<MessageGroup> findPaging(Integer baseGroupId, Integer creater, Integer mtype, Integer sctype, Date date, PagingBean pagingBean){
		StringBuffer hql = new StringBuffer();
		hql.append("select o from com.huzhiyi.housereadily.entity.MessageGroup o where isDelete = 1");
		hql.append(" and baseGroupId = ").append(baseGroupId);
		hql.append(" and createTime > '").append(DateUtils.format(date, Constants.DATEFORMAT)).append("'");
		if(!(creater == 0)){
			hql.append(" and creater = ").append(creater);
		}
		if(mtype == 1 || mtype == 2 || mtype == 3){
			hql.append(" and mtype = ").append(mtype);
		}
		if(mtype == 4){
			hql.append(" and (mtype =1 or mtype =2)");
		}
		
		if(null != sctype && sctype > 0){
			hql.append(" and sctype = ").append(sctype);
		}
		
		hql.append(" order by createTime desc");
		
		return super.findPaging(hql.toString(), pagingBean);
	}
	
	@Override
	public List<MessageGroup> findPagingMessage(Integer baseGroupId, Integer creater, Integer mtype, Integer sctype, Date date, PagingBean pagingBean){
		StringBuffer hql = new StringBuffer();
		hql.append("select o from com.huzhiyi.housereadily.entity.MessageGroup o where isDelete = 1");
		hql.append(" and baseGroupId = ").append(baseGroupId);
		hql.append(" and createTime > '").append(DateUtils.format(date, Constants.DATEFORMAT)).append("'");
		if(!(creater == 0)){
			hql.append(" and creater = ").append(creater);
		}
		if(mtype == 1 || mtype == 2 || mtype == 3){
			hql.append(" and mtype = ").append(mtype);
		}else if(mtype == 4){
			hql.append(" and (mtype =1 or mtype =2)");
		}

		if(null != sctype && sctype > 0){
			hql.append(" and sctype = ").append(sctype);
		}
		
		hql.append(" order by createTime desc");
		
		return super.findPaging(hql.toString(), pagingBean);
	}

}
