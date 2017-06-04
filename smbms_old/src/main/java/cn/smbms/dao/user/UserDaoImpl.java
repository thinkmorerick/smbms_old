package cn.smbms.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.smbms.dao.BaseDao;
import cn.smbms.pojo.User;
import cn.smbms.tools.Constants;

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
			String sql = "insert into smbms_user (userCode,userName,userPassword,"
					+ "userType,gender,birthday,phone,address,creationDate,createBy"
					+ ")" + "values(?,?,?,?,?,?,?,?,?,?)";
			Object[] params = { user.getUserCode(), user.getUserName(),
					user.getUserPassword(), user.getUserType(),
					user.getGender(), user.getBirthday(), user.getPhone(),
					user.getAddress(), user.getCreationDate(),
					user.getCreateBy() };
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
		User _user = null; // 不能new
		if (null != connection) {
			String sql = "select * from smbms_user where userCode=?";
			Object[] params = { userCode };
			rs = BaseDao.execute(connection, pstm, rs, sql, params);
			if (rs.next()) {
				_user = new User();
				_user.setId(rs.getInt("id"));
				_user.setUserCode(rs.getString("userCode"));
				_user.setUserName(rs.getString("userName"));
				_user.setUserPassword(rs.getString("userPassword"));
				_user.setGender(rs.getInt("gender"));
				_user.setBirthday(rs.getDate("birthday"));
				_user.setPhone(rs.getString("phone"));
				_user.setAddress(rs.getString("address"));
				_user.setUserType(rs.getInt("userType"));
				_user.setCreateBy(rs.getInt("createBy"));
				_user.setCreationDate(rs.getTimestamp("creationDate"));
				_user.setModifyBy(rs.getInt("modifyBy"));
				_user.setModifyDate(rs.getTimestamp("modifyDate"));
			}
			BaseDao.closeResource(null, pstm, rs);
		}
		return _user;
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

	@Override
	public Boolean deleteUserById(Connection connection, int delId)
			throws Exception {
		boolean flag = false;
		PreparedStatement pstm = null;
		if (null != connection) {
			String sql = "delete from smbms_user where id = ?";
			Object[] params = { delId };
			int result = BaseDao.execute(connection, pstm, sql, params);
			if (result > 0) {
				flag = true;
			}
			BaseDao.closeResource(null, pstm, null);
		}
		return flag;
	}

	@Override
	public User getUserById(Connection connection, String id) throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User user = null; // 不能new
		if (null != connection) {
			String sql = "select * from smbms_user where id=?";
			Object[] params = { id };
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
	public boolean modify(Connection connection, User user) throws Exception {
		boolean flag = false;
		PreparedStatement pstm = null;
		if (null != connection) {
			String sql = "UPDATE smbms_user SET userName=?,gender=?,birthday=?,phone=?,address=?,userType=?,modifyBy=?,modifyDate=? WHERE id = ?";
			Object[] params = { user.getUserName(), user.getGender(),
					user.getBirthday(), user.getPhone(), user.getAddress(),
					user.getUserType(), user.getModifyBy(),
					user.getModifyDate(), user.getId() };
			int result = BaseDao.execute(connection, pstm, sql, params);
			if (result > 0) {
				flag = true;
			}
			BaseDao.closeResource(null, pstm, null);
		}
		return flag;

	}

	@Override
	public boolean updatePwd(Connection connection, int id, String pwd)
			throws Exception {
		boolean flag = false;
		PreparedStatement pstm = null;
		if (connection != null) {
			String sql = "update smbms_user set userPassword=? where id =?";
			Object[] params = { pwd, id };
			if (BaseDao.execute(connection, pstm, sql, params) > 0) {
				flag = true;
			}
			BaseDao.closeResource(null, pstm, null);
		}
		return flag;
	}

	@Override
	public List<User> getPageUserList(Connection connection, String userName,
			HashMap<String, Integer> pageInfo) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		if (connection != null) {
			String sql = "select * from smbms_user where userName like ? order by creationDate desc limit ?,?";
			int startPageNo = pageInfo.get(Constants.PAGE_START_NO);
			int pageSize = pageInfo.get(Constants.PAGE_SIZE);
			startPageNo = (startPageNo - 1) * pageSize;
			Object[] params = { "%" + userName + "%", startPageNo, pageSize };
			rs = BaseDao
					.execute(connection, preparedStatement, rs, sql, params);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserCode(rs.getString("userCode"));
				user.setUserName(rs.getString("userName"));
				user.setGender(rs.getInt("gender"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPhone(rs.getString("Phone"));
				user.setUserType(rs.getInt("userType"));
				userList.add(user);
			}
			BaseDao.closeResource(null, preparedStatement, rs);
		}
		return userList;
	}

	@Override
	public int getRecCountByName(Connection connection, String userName)
			throws Exception {
		int recCount = 0;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			String sql = "select count(1) from smbms_user where userName like ?";
			Object[] params = { "%" + userName + "%" };
			resultSet = BaseDao.execute(connection, preparedStatement,
					resultSet, sql, params);
			if (resultSet.next()) {
				recCount = resultSet.getInt("count(1)");
			}
			BaseDao.closeResource(null, preparedStatement, resultSet);
		}
		return recCount;
	}
}
