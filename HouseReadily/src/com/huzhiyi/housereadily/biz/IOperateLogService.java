package com.huzhiyi.housereadily.biz;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.OperateLog;
import com.huzhiyi.model.PagingBean;

@com.huzhiyi.annotation.RDEBiz
public interface IOperateLogService extends IAbstractoperateLogService {

	public List<OperateLog> findPaging(Integer id, String userName, Integer regSource, String terminal, Integer type, Date beginDate,
			Date endDate, String sort, String dir, PagingBean pagingBean, boolean isRequestIpAddress);

	public OperateLog add(Integer userId, String ip, String operate, Integer type, String description, Timestamp createTime);
}