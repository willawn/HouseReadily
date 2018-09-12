package com.huzhiyi.housereadily.biz;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.SystemLog;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;

@com.huzhiyi.annotation.RDEBiz
public interface ISystemLogService extends IAbstractsystemLogService {

	public SystemLog add(ICommand command);

	public List<SystemLog> findPaging(Integer id, String userName, Integer regSource, String terminal, Integer type, Date beginDate,
			Date endDate, String sort, String dir, PagingBean pagingBean, boolean isRequestIpAddress);
}