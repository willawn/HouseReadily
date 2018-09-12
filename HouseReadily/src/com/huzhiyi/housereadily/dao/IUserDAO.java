package com.huzhiyi.housereadily.dao;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.UserTrend;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.model.abstraction.QueryResult;

public interface IUserDAO extends IAbstractuserDAO {

	/**
	 * @Title: verify
	 * @Description: 登录校验
	 *               <p>
	 * @author willter
	 * @date 2012-10-29
	 *       <p>
	 * @param user
	 * @return
	 */
	public CUser verify(CUser user);
	
	/**
	 * @Title: findByMobileAndPassword
	 * @Description: 查询是否有注册多个相同手机号码的用户
	 * 		<p>
	 * @author willter
	 * @date 2013-4-27
	 * 		<p>
	 * @param mobile
	 * @param password
	 * @return
	 */
	public List<CUser> findByMobileAndPassword(String mobile, String password);

	public Integer countByUsername(String username);

	public Integer countByEmail(String email);

	/**
	 * @Title: findPaging
	 * @Description: 获取随手房注册用户
	 *               <p>
	 * @author willter
	 * @date 2013-3-26
	 *       <p>
	 * @param command
	 * @param pagingBean
	 * @return
	 */
	public List<CUser> findPaging(Integer id, String userName, Integer regSource, Integer cityCode, String mobile, String email, Date beginDate,
			Date endDate, String sort, String dir, PagingBean pagingBean, boolean isSelectUserExt);
	
	public List<Object> export(Integer id, String userName, Integer regSource, Integer cityCode, String mobile, String email, Date beginDate,
			Date endDate, String sort, String dir);
	
	public CUser findByNameAndMobile(String username, String mobile);
	
	public List<UserTrend> findByUserTrend(Date createTime) throws Exception;
}