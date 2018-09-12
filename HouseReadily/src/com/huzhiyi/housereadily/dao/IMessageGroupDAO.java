package com.huzhiyi.housereadily.dao;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.MessageGroup;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.model.abstraction.QueryResult;

public interface IMessageGroupDAO extends IAbstractmessageGroupDAO {
	
	public QueryResult<MessageGroup> findByProperty(String[] propertyNames, Object[] values, String order, String dir);
	
	public Integer findCoundMessage(Integer baseGroupId, Integer mtype, Date date);
	
	public MessageGroup findByMessageGroup(Integer baseGroupId, Integer userId, Integer mtype, Integer source, Date date);
	
	public void deleteByUserId(Integer baseGroupId, Integer userId);
	
	public void deleteById(Integer id);
	
	public List<MessageGroup> findPaging(Integer baseGroupId, Integer creater, Integer mtype, Integer sctype, Date date, PagingBean pagingBean);
	
	public List<MessageGroup> findPagingMessage(Integer baseGroupId, Integer creater, Integer mtype, Integer sctype, Date date, PagingBean pagingBean);
	
}
