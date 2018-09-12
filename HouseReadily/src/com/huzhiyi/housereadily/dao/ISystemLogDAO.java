package com.huzhiyi.housereadily.dao;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.SystemLog;
import com.huzhiyi.model.PagingBean;

public interface ISystemLogDAO extends IAbstractsystemLogDAO {

	public List<SystemLog> findPaging(Integer id, String userName, Integer regSource, String terminal, Integer type, Date beginDate,
			Date endDate, String sort, String dir, PagingBean pagingBean);
}