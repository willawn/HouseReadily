package com.huzhiyi.housereadily.biz.impl;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.biz.ISystemLogService;
import com.huzhiyi.housereadily.dao.IUserDAO;
import com.huzhiyi.housereadily.entity.SystemLog;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.utils.RequestUtils;

public class SystemLogServiceImpl extends AbstractSystemLogServiceImpl implements ISystemLogService {

	@Override
	public SystemLog add(ICommand command) {
		return null;
	}

	@Override
	public List<SystemLog> findPaging(Integer id, String userName, Integer regSource, String terminal, Integer type, Date beginDate,
			Date endDate, String sort, String dir, PagingBean pagingBean, boolean isRequestIpAddress) {
		List<SystemLog> systemLogs = getSystemLogDAO().findPaging(id, userName, regSource, terminal, type, beginDate, endDate, sort, dir,
				pagingBean);
		for (SystemLog systemLog : systemLogs) {
			initSystemLogForeignValue(systemLog, isRequestIpAddress);
		}
		return systemLogs;
	}

	@Override
	public SystemLog findById(Integer id) {
		SystemLog systemLog = super.findById(id);
		initSystemLogForeignValue(systemLog, true);

		return systemLog;
	}

	private void initSystemLogForeignValue(SystemLog systemLog, boolean isRequestIpAddress) {
		if (null != systemLog) {
			Integer systemLogId = systemLog.getId();

			CUser user = userDAO.findById(systemLog.getUserId());
			if (isRequestIpAddress) {
				systemLog.setIpAddress(RequestUtils.getIpAddress(systemLog.getIp()));
			}
			systemLog.setUserName(user.getName());
			systemLog.setRegSource(user.getRegSource());
		}
	}

	private IUserDAO userDAO;

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
}