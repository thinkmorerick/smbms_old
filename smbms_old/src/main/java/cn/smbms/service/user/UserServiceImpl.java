package cn.smbms.service.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import cn.smbms.dao.BaseDao;
import cn.smbms.dao.user.UserDao;
import cn.smbms.dao.user.UserDaoImpl;
import cn.smbms.pojo.User;

/**
 * service层捕获异常，进行事务处理
 * 事务处理：调用不同dao的多个方法，必须使用同一个connection（connection作为参数传递）
 * 事务完成之后，需要service层进行connection的关闭，在dao层关闭（PrepareStatement和ResultSet对象）
 * 
 * @author Rick
 * 
 * 2017-5-29上午3:49:39
 *
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public boolean add(User user) {
		boolean flag = false;
		Connection connection = null;
		try {
			connection = BaseDao.getConnection();
			connection.setAutoCommit(false); // 开启JDBC事务管理
			userDao.add(connection, user);
			/**			userDao.update(); // 多表操作，commit之前继续调用其他方法
						userDao.delete();*/
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 在service层进行connection连接的关闭
			BaseDao.closeResource(connection, null, null);
		}

		return flag;
	}

	/**
	 * 登录功能就不用开启事务了
	 */
	@Override
	public User login(String userCode, String userPassword) {
		Connection connection = null;
		User user = null;
		try {
			connection = BaseDao.getConnection();
			user = userDao.getLoginUser(connection, userCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeResource(connection, null, null);
		}
		// 匹配密码
		if (null != user) {
			if (!user.getUserPassword().equals(userPassword)) {
				user = null;
			}
		}
		return user;
	}

	@Override
	public List<User> getUserList(String queryUserName) {
		Connection connection = null;
		List<User> userList = null;
		try {
			connection = BaseDao.getConnection();
			userList = userDao.getUserList(connection, queryUserName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeResource(connection, null, null);
		}
		return userList;
	}

	@Override
	public User selectUserCodeExist(String userCode) {
		Connection connection = null;
		User user = null;
		try {
			connection = BaseDao.getConnection();
			user = userDao.getLoginUser(connection, userCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeResource(connection, null, null);
		}

		return user;
	}

	@Override
	public boolean deleteUserById(Integer delId) {
		boolean flag = false;
		Connection connection = null;
		try {
			connection = BaseDao.getConnection();
			connection.setAutoCommit(false); // 开启JDBC事务管理
			userDao.deleteUserById(connection, delId);
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 在service层进行connection连接的关闭
			BaseDao.closeResource(connection, null, null);
		}

		return flag;
	}

	@Override
	public User getUserById(String id) {

		Connection connection = null;
		User _user = null;

		try {
			connection = BaseDao.getConnection();
			_user = userDao.getUserById(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeResource(connection, null, null);
		}
		return _user;
	}

	@Override
	public boolean modify(User user) {
		boolean flag = false;
		Connection connection = null;
		try {
			connection = BaseDao.getConnection();
			connection.setAutoCommit(false); // 开启JDBC事务管理
			userDao.modify(connection, user);
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 在service层进行connection连接的关闭
			BaseDao.closeResource(connection, null, null);
		}

		return flag;
	}

	@Override
	public boolean updatePwd(int id, String pwd) {
		boolean flag = false;
		Connection connection = null;
		try {
			connection = BaseDao.getConnection();
			flag = userDao.updatePwd(connection, id, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeResource(connection, null, null);
		}

		return flag;
	}

	@Override
	public List<User> getPageUserList(String userName,
			HashMap<String, Integer> pageInfo) {
		Connection connection = null;
		List<User> userList = null;
		try {
			connection = BaseDao.getConnection();
			userList = userDao.getPageUserList(connection, userName, pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeResource(connection, null, null);
		}
		return userList;
	}

	@Override
	public int getRecCountByName(String userName) {
		int recCount = 0;
		Connection connection = null;
		try {
			connection = BaseDao.getConnection();
			recCount = userDao.getRecCountByName(connection, userName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeResource(connection, null, null);
		}
		return recCount;
	}
}
