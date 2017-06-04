package cn.smbms.dao.user;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import cn.smbms.pojo.User;

public interface UserDao {
	/**
	 * 增加用户信息
	 * @param connection
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int add(Connection connection, User user) throws Exception;

	/**
	 * 根据userCode获取User
	 * 
	 * @param connection
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(Connection connection, String userCode)
			throws Exception;

	/**
	 * 通过userName模糊查询-userList
	 * @param connection
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public List<User> getUserList(Connection connection, String userName)
			throws Exception;

	/**
	 * 根据delId删除User
	 * @param connection
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Boolean deleteUserById(Connection connection, int delId)
			throws Exception;

	/**
	 * 根据id查询User
	 * @param id
	 * @return
	 */
	public User getUserById(Connection connection, String id) throws Exception;

	/**
	 * 修改User
	 * @param connection
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean modify(Connection connection, User user) throws Exception;

	/**
	 * 修改当前用户密码
	 * @param connection
	 * @param id
	 * @param pwd
	 * @return
	 */
	public boolean updatePwd(Connection connection, int id, String pwd)
			throws Exception;

	/**
	 * 分页获取pageUserList,通过userName模糊查询
	 * @param connection
	 * @param userName
	 * @param pageInfo
	 * @return
	 * @throws Exception
	 */
	public List<User> getPageUserList(Connection connection, String userName,
			HashMap<String, Integer> pageInfo) throws Exception;

	/**
	 * 通过userName查询得到总记录条数
	 * @param connection
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public int getRecCountByName(Connection connection, String userName)
			throws Exception;
}
