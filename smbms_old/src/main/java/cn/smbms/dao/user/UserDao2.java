package cn.smbms.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.smbms.dao.BaseDao;
import cn.smbms.pojo.User;

public class UserDao2 {

	public int add() {
		int updateRows = 0;
		UserDao userDao = new UserDaoImpl();
		Connection connection = null;
		PreparedStatement pstm = null;
		try {
			connection = BaseDao.getConnection();
			connection.setAutoCommit(false); // 开启JDBC事务管理
			User user = new User();
			user.setUserCode("rick");
			user.setUserName("朱峰");
			updateRows = userDao.add(connection, user);

			// providerDao.add(Provider provider)
			/**			String sql2 = "insert into smbms_provider (proCode,proName)"
								+ "values(?,?)";
						Object[] params2 = { "rick1111111", "朱峰11111111111" };
						updateRows = BaseDao.execute(connection, pstm, sql2, params2);

					*/
			// float a = 5 / 0; // 错误代码，模拟抛出异常
			connection.commit();

			if (updateRows > 0) {
				System.out.println("add success!");
			} else {
				System.out.println("add failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				System.out.println("进入roll back <==========");
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			BaseDao.closeResource(connection, pstm, null);
		}

		return updateRows;
	}

	public static void main(String[] args) {
		UserDao2 testUserDao = new UserDao2();
		testUserDao.add();
	}
}
