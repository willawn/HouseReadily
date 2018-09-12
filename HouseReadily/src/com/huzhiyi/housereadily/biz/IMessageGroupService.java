package com.huzhiyi.housereadily.biz;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.MessageGroup;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;

public interface IMessageGroupService extends IAbstractmessageGroupService {
	
	public MessageGroup add(ICommand command) throws Exception;
	
	public Integer findMessageGroupByCount(Integer baseGroupId, Integer mtype);
	
	public Integer findCoundMessage(Integer baseGroupId, Integer mtype, Date date);
	
	public boolean exitsMessageGroup(Integer baseGroupId, Integer userId, Integer mtype, Integer source);
	
	public void deleteByUserId(Integer baseGroupId, Integer userId);
	
	public MessageGroup findById(Integer id);
	
	public void deleteById(ICommand command);
	
	public List<MessageGroup> findPaging(Integer baseGroupId, Integer creater, Integer mtype, Integer sctype, PagingBean pagingBean);
	
	public List<MessageGroup> findPagingMessage(Integer baseGroupId, Integer creater, Integer mtype, Integer sctype, PagingBean pagingBean);
	
}
