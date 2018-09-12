package com.huzhiyi.housereadily.dao;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.OperateLog;
import com.huzhiyi.model.PagingBean;

public interface IOperateLogDAO extends IAbstractoperateLogDAO {

	public List<OperateLog> findPaging(Integer id, String userName, Integer regSource, String terminal, Integer type, Date beginDate,
			Date endDate, String sort, String dir, PagingBean pagingBean);
}