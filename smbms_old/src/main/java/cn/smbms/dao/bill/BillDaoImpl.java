package cn.smbms.dao.bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.smbms.dao.BaseDao;
import cn.smbms.pojo.Bill;
import cn.smbms.tools.Constants;

import com.mysql.jdbc.StringUtils;

public class BillDaoImpl implements BillDao {

	@Override
	public boolean add(Connection connection, Bill bill) throws Exception {
		boolean flag = false;
		PreparedStatement pstm = null;
		if (null != connection) {
			String sql = "insert into smbms_bill (billCode,productName,productDesc,"
					+ "productUnit,productCount,totalPrice,isPayment,providerId,"
					+ "createDate,createBy,modifyDate,modifyBy)values(?,?,?,?,?,?,?,?,?,?,?,?)";
			Object[] params = { bill.getBillCode(), bill.getProductName(),
					bill.getProductDesc(), bill.getProductUnit(),
					bill.getProductCount(), bill.getTotalPrice(),
					bill.getIsPayment(), bill.getProviderId(),
					bill.getCreateDate(), bill.getCreateBy(),
					bill.getModifyDate(), bill.getModifyBy() };
			if (BaseDao.execute(connection, pstm, sql, params) > 0) {
				flag = true;
			}
			BaseDao.closeResource(null, pstm, null);
		}

		return flag;
	}

	@Override
	public List<Bill> getBillList(Connection connection, Bill bill)
			throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Bill> billList = new ArrayList<Bill>();
		if (connection != null) {
			// 拼接sql语句和params
			StringBuffer sql = new StringBuffer();
			sql.append("select b.*,p.proName as providerName from smbms_bill b, smbms_provider p where b.providerId = p.id");

			List<Object> list = new ArrayList<Object>();
			if (!StringUtils.isNullOrEmpty(bill.getProductName())) {
				sql.append(" and productName like ? "); // 拼接sql前后都会加空格
				list.add("%" + bill.getProductName() + "%");
			}
			if (bill.getProviderId() > 0) {
				sql.append(" and providerId = ? ");
				list.add(bill.getProviderId());
			}
			if (bill.getIsPayment() > 0) {
				sql.append(" and isPayment = ? ");
				list.add(bill.getIsPayment());
			}

			Object[] params = list.toArray();

			rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);
			while (rs.next()) {
				Bill _bill = new Bill();
				_bill.setId(rs.getInt("id"));
				_bill.setBillCode(rs.getString("billCode"));
				_bill.setProductName(rs.getString("productName"));
				_bill.setProductDesc(rs.getString("productDesc"));
				_bill.setProductUnit(rs.getString("productUnit"));
				_bill.setProductCount(rs.getBigDecimal("productCount"));
				_bill.setTotalPrice(rs.getBigDecimal("totalPrice"));
				_bill.setIsPayment(rs.getInt("isPayment"));
				_bill.setProviderId(rs.getInt("providerId"));
				_bill.setProviderName(rs.getString("providerName"));
				_bill.setCreateDate(rs.getTimestamp("createDate"));
				_bill.setCreateBy(rs.getInt("createBy"));
				billList.add(_bill);
			}
			BaseDao.closeResource(null, pstm, rs);
		}

		return billList;
	}

	@Override
	public boolean deleteBillById(Connection connection, String delId)
			throws Exception {
		boolean flag = false;
		PreparedStatement pstm = null;
		if (null != connection) {
			String sql = "delete from smbms_bill where id = ? ";
			Object[] params = { delId };
			if (BaseDao.execute(connection, pstm, sql, params) > 0) {
				flag = true;
			}
			BaseDao.closeResource(null, pstm, null);
		}
		return flag;
	}

	@Override
	public Bill getBillById(Connection connection, String id) throws Exception {
		Bill _bill = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		if (null != connection) {
			String sql = "select b.*,p.proName as providerName from smbms_bill b, smbms_provider p "
					+ "where b.providerId = p.id and b.id=?";
			Object[] params = { id };
			rs = BaseDao.execute(connection, pstm, rs, sql, params);
			if (rs.next()) {
				_bill = new Bill();
				_bill.setId(rs.getInt("id"));
				_bill.setBillCode(rs.getString("billCode"));
				_bill.setProductName(rs.getString("productName"));
				_bill.setProductDesc(rs.getString("productDesc"));
				_bill.setProductUnit(rs.getString("productUnit"));
				_bill.setProductCount(rs.getBigDecimal("productCount"));
				_bill.setTotalPrice(rs.getBigDecimal("totalPrice"));
				_bill.setIsPayment(rs.getInt("isPayment"));
				_bill.setProviderId(rs.getInt("providerId"));
				_bill.setProviderName(rs.getString("providerName"));
				_bill.setCreateDate(rs.getTimestamp("createDate"));
				_bill.setCreateBy(rs.getInt("createBy"));
				_bill.setCreateDate(rs.getTimestamp("modifyDate"));
				_bill.setCreateBy(rs.getInt("modifyBy"));
			}
		}

		return _bill;
	}

	@Override
	public boolean modify(Connection connection, Bill bill) throws Exception {
		boolean flag = false;
		PreparedStatement pstm = null;
		if (null != connection) {
			String sql = "UPDATE smbms_bill SET billCode=?,productName=?"
					+ ",productDesc=?,productUnit=?,productCount=?,"
					+ "totalPrice=?,isPayment=?,providerId=?,modifyDate=?,modifyBy=? WHERE id=?";
			Object[] params = { bill.getBillCode(), bill.getProductName(),
					bill.getProductDesc(), bill.getProductUnit(),
					bill.getProductCount(), bill.getTotalPrice(),
					bill.getIsPayment(), bill.getProviderId(),
					bill.getModifyDate(), bill.getModifyBy(), bill.getId() };
			if (BaseDao.execute(connection, pstm, sql, params) > 0) {
				flag = true;
			}
			BaseDao.closeResource(null, pstm, null);
		}

		return flag;
	}

	@Override
	public int getBillCountByProviderId(Connection connection, String providerId)
			throws Exception {
		int count = 0;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		if (null != connection) {
			String sql = "select count(1) as billCount from smbms_bill where"
					+ " providerId = ?";
			Object[] params = { providerId };
			rs = BaseDao.execute(connection, pstm, rs, sql, params);
			if (rs.next()) {
				count = rs.getInt("billCount");
			}
			BaseDao.closeResource(null, pstm, rs);
		}

		return count;
	}

	@Override
	public List<Bill> getPageBillList(Connection connection, Bill bill,
			HashMap<String, Integer> pageInfo) throws Exception {
		List<Bill> pageBillList = new ArrayList<Bill>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			StringBuffer sql = new StringBuffer();
			sql.append("select b.*,p.proName as providerName from smbms_bill b, smbms_provider p where b.providerId = p.id ");
			List<Object> list = new ArrayList<Object>();
			if (bill.getId() > 0) {
				sql.append(" and b.id=? ");
				list.add(bill.getId());
			} else {
				if (!StringUtils.isNullOrEmpty(bill.getProductName())) {
					sql.append(" and b.productName like ? ");
					list.add("%" + bill.getProductName() + "%");
				}
				if (bill.getProviderId() > 0) {
					sql.append(" and b.providerId=? ");
					list.add(bill.getProviderId());
				}
				if (bill.getIsPayment() > 0) {
					sql.append(" and b.isPayment=? ");
					list.add(bill.getIsPayment());
				}
				if (pageInfo != null) {
					int pageSize = pageInfo.get(Constants.PAGE_SIZE);
					int startPageNo = pageInfo.get(Constants.PAGE_START_NO);
					startPageNo = (startPageNo - 1) * pageSize;
					sql.append(" order by createDate desc limit ?,?");
					list.add(startPageNo);
					list.add(pageSize);
				}
			}
			Object[] params = list.toArray();
			resultSet = BaseDao.execute(connection, preparedStatement,
					resultSet, sql.toString(), params);
			while (resultSet.next()) {
				Bill _bill = new Bill();
				_bill.setId(resultSet.getInt("id"));
				_bill.setBillCode(resultSet.getString("billCode"));
				_bill.setProductName(resultSet.getString("productName"));
				_bill.setProductDesc(resultSet.getString("productDesc"));
				_bill.setProductUnit(resultSet.getString("productUnit"));
				_bill.setProductCount(resultSet.getBigDecimal("productCount"));
				_bill.setTotalPrice(resultSet.getBigDecimal("totalPrice"));
				_bill.setIsPayment(resultSet.getInt("isPayment"));
				_bill.setProviderId(resultSet.getInt("providerId"));
				_bill.setProviderName(resultSet.getString("providerName"));
				_bill.setCreateDate(resultSet.getTimestamp("createDate"));
				_bill.setCreateBy(resultSet.getInt("createBy"));
				pageBillList.add(_bill);
			}
			BaseDao.closeResource(null, preparedStatement, resultSet);
		}
		return pageBillList;
	}

	@Override
	public int getRecCountByBill(Connection connection, Bill bill)
			throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int billCount = 0;
		if (connection != null) {
			StringBuffer sql = new StringBuffer();
			sql.append("select count(1) from smbms_bill b, smbms_provider p where b.providerId = p.id ");
			List<Object> list = new ArrayList<Object>();
			if (!StringUtils.isNullOrEmpty(bill.getProductName())) {
				sql.append(" and b.productName like ? ");
				list.add("%" + bill.getProductName() + "%");
			}
			if (bill.getProviderId() > 0) {
				sql.append(" and b.providerId=? ");
				list.add(bill.getProviderId());
			}
			if (bill.getIsPayment() > 0) {
				sql.append(" and b.isPayment=? ");
				list.add(bill.getIsPayment());
			}
			Object[] params = list.toArray();
			resultSet = BaseDao.execute(connection, preparedStatement,
					resultSet, sql.toString(), params);
			if (resultSet.next()) {
				billCount = resultSet.getInt(1);
			}
			BaseDao.closeResource(null, preparedStatement, resultSet);
		}
		return billCount;
	}

}
