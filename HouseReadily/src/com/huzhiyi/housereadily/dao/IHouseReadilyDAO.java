package com.huzhiyi.housereadily.dao;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;

public interface IHouseReadilyDAO extends IAbstracthouseReadilyDAO {

	public List<HouseReadily> findPaging(ICommand command, PagingBean pagingBean);

	public List<HouseReadily> findPaging(Integer id, Integer stype, Integer buildType, String projectName, String title, Integer cityCode,
			Integer bigAreaCode, Integer smallAreaCode, String userName, Date beginDate, Date endDate, Integer isDelete, String sort,
			String dir, PagingBean pagingBean);

	public List<HouseReadily> findIdAndVersion(Integer userId);

	public Integer findCount(Integer userId);
	
	public Integer updateStatus(Integer id, Integer status);
}