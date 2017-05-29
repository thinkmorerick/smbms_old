package cn.smbms.dao.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.smbms.tools.ConfigManager;

public class TestUserDao {

	public int add() {
		int updateRows = 0;

		String driver = ConfigManager.getInstance().getValue("driver");
		String url = ConfigManager.getInstance().getValue("url");
		String user = ConfigManager.getInstance().getValue("user");
		String password = ConfigManager.getInstance().getValue("password");
		Connection connection = null;
		PreparedStatement pstm = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false); // 开启JDBC事务管理

			// userDao.add(User user)
			String sql = "insert into smbms_user (userCode,userName)"
					+ "values(?,?)";
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, "rick");
			pstm.setString(2, "朱峰");
			updateRows = pstm.executeUpdate();

			// providerDao.add(Provider provider)
			String sql2 = "insert into smbms_provider (proCode,proName)"
					+ "values(?,?)";
			pstm = connection.prepareStatement(sql2);
			pstm.setString(1, "rick11111111");
			pstm.setString(2, "朱峰11111111111111");
			updateRows = pstm.executeUpdate();

			float a = 5 / 0; // 错误代码，模拟抛出异常
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
			try {
				pstm.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return updateRows;
	}

	public static void main(String[] args) {
		TestUserDao testUserDao = new TestUserDao();
		testUserDao.add();
	}
}
