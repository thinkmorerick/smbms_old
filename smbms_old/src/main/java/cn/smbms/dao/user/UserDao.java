package cn.smbms.dao.user;

import java.sql.Connection;
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
}
