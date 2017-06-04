package cn.smbms.dao.provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.smbms.dao.BaseDao;
import cn.smbms.pojo.Provider;

public class ProviderDaoImpl implements ProviderDao {

	@Override
	public boolean add(Connection connection, Provider provider)
			throws Exception {
		boolean flag = false;
		PreparedStatement pstm = null;
		if (null != connection) {
			String sql = "insert into smbms_provider (proCode,proName,"
					+ "proDesc,proContact,proPhone,proAddress,proFax,createBy,"
					+ "creationDate,modifyBy,modifyDate) values (?,?,?,?,?,?,?,?,?,?,?)";
			Object[] params = { provider.getProCode(), provider.getProName(),
					provider.getProDesc(), provider.getProContact(),
					provider.getProPhone(), provider.getProAddress(),
					provider.getProFax(), provider.getCreateBy(),
					provider.getCreationDate(), provider.getModifyBy(),
					provider.getModifyDate() };
			if (BaseDao.execute(connection, pstm, sql, params) > 0) {
				flag = true;
			}
			BaseDao.closeResource(null, pstm, null);
		}
		return flag;
	}

	@Override
	public List<Provider> getProviderList(Connection connection, String proName)
			throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Provider> providerList = new ArrayList<Provider>();
		if (null != connection) {
			String sql = "select * from smbms_provider where proName like ?";
			Object[] params = { "%" + proName + "%" };
			rs = BaseDao.execute(connection, pstm, rs, sql, params);
			while (rs.next()) {
				Provider _provider = new Provider();
				_provider.setId(rs.getInt("id"));
				_provider.setProCode(rs.getString("proCode"));
				_provider.setProName(rs.getString("proName"));
				_provider.setProDesc(rs.getString("proDesc"));
				_provider.setProContact(rs.getString("proContact"));
				_provider.setProPhone(rs.getString("proPhone"));
				_provider.setProAddress(rs.getString("proAddress"));
				_provider.setProFax(rs.getString("proFax"));
				_provider.setCreateBy(rs.getInt("createBy"));
				_provider.setCreationDate(rs.getTimestamp("creationDate"));
				_provider.setModifyBy(rs.getInt("modifyBy"));
				_provider.setModifyDate(rs.getTimestamp("modifyDate"));

				providerList.add(_provider);
			}
			BaseDao.closeResource(null, pstm, rs);
		}
		return providerList;
	}

	@Override
	public boolean deleteProviderById(Connection connection, String delId)
			throws Exception {
		boolean flag = false;
		PreparedStatement pstm = null;
		if (null != connection) {
			String sql = "delete from smbms_provider where id = ? ";
			Object[] params = { delId };
			if (BaseDao.execute(connection, pstm, sql, params) > 0) {
				flag = true;
			}
			BaseDao.closeResource(null, pstm, null);
		}
		return flag;
	}

	@Override
	public Provider getProviderById(Connection connection, String id)
			throws Exception {
		PreparedStatement pstm = null;
		Provider _provider = null;
		ResultSet rs = null;
		if (null != connection) {
			String sql = "select * from smbms_provider where id =?";
			Object[] params = { id };
			rs = BaseDao.execute(connection, pstm, rs, sql, params);
			if (rs.next()) {
				_provider = new Provider();
				_provider.setId(rs.getInt("id"));
				_provider.setProCode(rs.getString("proCode"));
				_provider.setProName(rs.getString("proName"));
				_provider.setProDesc(rs.getString("proDesc"));
				_provider.setProContact(rs.getString("proContact"));
				_provider.setProPhone(rs.getString("proPhone"));
				_provider.setProAddress(rs.getString("proAddress"));
				_provider.setProFax(rs.getString("proFax"));
				_provider.setCreateBy(rs.getInt("createBy"));
				_provider.setCreationDate(rs.getTimestamp("creationDate"));
				_provider.setModifyBy(rs.getInt("modifyBy"));
				_provider.setModifyDate(rs.getTimestamp("modifyDate"));
			}

		}
		return _provider;
	}

	@Override
	public boolean modify(Connection connection, Provider provider)
			throws Exception {
		boolean flag = false;
		PreparedStatement pstm = null;
		if (null != connection) {
			String sql = "update smbms_provider set "
					+ "proDesc=?,proContact=?,proPhone=?,proAddress=?,proFax=?,"
					+ "modifyBy=?,modifyDate=? where id=?";
			Object[] params = { provider.getProDesc(),
					provider.getProContact(), provider.getProPhone(),
					provider.getProAddress(), provider.getProFax(),
					provider.getModifyBy(), provider.getModifyDate(),
					provider.getId() };
			if (BaseDao.execute(connection, pstm, sql, params) > 0) {
				flag = true;
			}
			BaseDao.closeResource(null, pstm, null);
		}
		return flag;
	}

}
