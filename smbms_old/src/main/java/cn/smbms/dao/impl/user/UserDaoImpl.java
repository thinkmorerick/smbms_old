package cn.smbms.dao.impl.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.smbms.dao.BaseDao;
import cn.smbms.dao.user.UserDao;
import cn.smbms.pojo.User;

/**
 * dao层抛出异常，让service层去捕获处理
 * 
 * @author Rick
 * 
 * 2017-5-29上午3:51:08
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public int add(Connection connection, User user) throws Exception {
		PreparedStatement pstm = null;
		int updateRows = 0;
		if (null != connection) {
			String sql = "insert into smbms_user (userCode,userName)"
					+ "values(?,?)";
			Object[] params = { user.getUserCode(), user.getUserName() };
			updateRows = BaseDao.execute(connection, pstm, sql, params);
			BaseDao.closeResource(null, pstm, null);
		}
		return updateRows;
	}

	@Override
	public User getLoginUser(Connection connection, String userCode)
			throws Exception {

		PreparedStatement pstm = null;
		ResultSet rs = null;
		User user = null; // 不能new
		if (null != connection) {
			String sql = "select * from smbms_user where userCode=?";
			Object[] params = { userCode };
			rs = BaseDao.execute(connection, pstm, rs, sql, params);
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserCode(rs.getString("userCode"));
				user.setUserName(rs.getString("userName"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setGender(rs.getInt("gender"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setUserType(rs.getInt("userType"));
				user.setCreateBy(rs.getInt("createBy"));
				user.setCreationDate(rs.getTimestamp("creationDate"));
				user.setModifyBy(rs.getInt("modifyBy"));
				user.setModifyDate(rs.getTimestamp("modifyDate"));
			}
			BaseDao.closeResource(null, pstm, rs);
		}
		return user;
	}

	@Override
	public List<User> getUserList(Connection connection, String userName)
			throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		if (connection != null) {
			String sql = "select * from smbms_user where userName like ?";
			Object[] params = { "%" + userName + "%" };
			rs = BaseDao.execute(connection, pstm, rs, sql, params);
			while (rs.next()) {
				User _user = new User();
				_user.setId(rs.getInt("id"));
				_user.setUserCode(rs.getString("userCode"));
				_user.setUserName(rs.getString("userName"));
				_user.setGender(rs.getInt("gender"));
				_user.setBirthday(rs.getDate("birthday"));
				_user.setPhone(rs.getString("phone"));
				_user.setUserType(rs.getInt("userType"));

				userList.add(_user);
			}
			BaseDao.closeResource(null, pstm, rs);
		}

		return userList;
	}
}
