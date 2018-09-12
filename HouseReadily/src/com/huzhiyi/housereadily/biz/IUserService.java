package com.huzhiyi.housereadily.biz;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.UserTrend;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;

@com.huzhiyi.annotation.RDEBiz
public interface IUserService extends IAbstractuserService {

	/**
	 * @Title: verify
	 * @Description: 登录校验
	 *               <p>
	 * @author willter
	 * @date 2012-10-29
	 *       <p>
	 * @param command
	 * @return
	 */
	public Object[] verify(ICommand command) throws Exception;
	
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

	/**
	 * @Title: usernameExist
	 * @Description: 检查用户是否存在
	 *               <p>
	 * @author willter
	 * @date 2012-10-30
	 *       <p>
	 * @param username
	 * @return
	 */
	public boolean usernameExist(String username);
	
	/**
	 * @Title: findByName
	 * @Description: 根据用户名查询
	 * 		<p>
	 * @author willter
	 * @date 2013-4-12
	 * 		<p>
	 * @param username
	 * @return
	 */
	CUser findByNameAndMobile(String username, String mobile);

	/**
	 * @Title: emailExist
	 * @Description: 检查邮箱是否存在
	 *               <p>
	 * @author willter
	 * @date 2012-10-30
	 *       <p>
	 * @param email
	 * @return
	 */
	public boolean emailExist(String email);

	/**
	 * @Title: add
	 * @Description: 注册用户
	 *               <p>
	 * @author willter
	 * @date 2012-10-30
	 *       <p>
	 * @param userName
	 * @param password
	 * @param email
	 * @param mobile
	 * @param registerIp
	 */
	public void add(String userName, String password, String email, String mobile, String registerIp, String sinauid, String txuid,
			String operate, String ip, String version);

	/**
	 * @Title: updatePassword
	 * @Description: 修改密码
	 * 		<p>
	 * @author willter
	 * @date 2013-4-16
	 * 		<p>
	 * @param userId
	 * @param password
	 */
	public Object[] update(ICommand command) throws Exception;
	
	/**
	 * @Title: sendCode
	 * @Description: 发送验证码
	 * 		<p>
	 * @author willter
	 * @date 2013-4-16
	 * 		<p>
	 * @param mobile
	 * @return
	 */
	public String sendCode(String userName, String mobile);
	
	/**
	 * @Title: updatePassword
	 * @Description: 找回密码
	 * 		<p>
	 * @author willter
	 * @date 2013-4-17
	 * 		<p>
	 * @param userName
	 * @param password
	 * @return
	 */
	public String updatePassword(String userName, String password);
	
	/**
	 * @Title: addUserExt
	 * @Description: 新增用户扩展表
	 * 		<p>
	 * @author willter
	 * @date 2013-5-21
	 * 		<p>
	 */
	public void addUserExt();
	
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
	
	public List<UserTrend> findByUserTrend(Date createTime) throws Exception;
}