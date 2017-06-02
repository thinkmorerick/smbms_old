package cn.smbms.service.bill;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.smbms.dao.BaseDao;
import cn.smbms.dao.bill.BillDao;
import cn.smbms.dao.bill.BillDaoImpl;
import cn.smbms.pojo.Bill;

public class BillServiceImpl implements BillService {
	private BillDao billDao;

	public BillServiceImpl() {
		billDao = new BillDaoImpl();
	}

	@Override
	public boolean add(Bill bill) {
		boolean flag = false;
		Connection connection = null;
		try {
			connection = BaseDao.getConnection();
			connection.setAutoCommit(false); // 开启JDBC事务管理
			flag = billDao.add(connection, bill);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			BaseDao.closeResource(connection, null, null);
		}
		return flag;
	}

	@Override
	public List<Bill> getBillList(Bill bill) {

		Connection connection = null;
		List<Bill> billList = null;
		try {
			connection = BaseDao.getConnection();
			billList = billDao.getBillList(connection, bill);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeResource(connection, null, null);
		}
		return billList;
	}

	@Override
	public boolean deleteBillById(String delId) {
		boolean flag = false;
		Connection connection = null;
		try {
			connection = BaseDao.getConnection();
			connection.setAutoCommit(false); // 开启JDBC事务管理
			boolean result = billDao.deleteBillById(connection, delId);
			connection.commit();

			if (result) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			BaseDao.closeResource(connection, null, null);
		}
		return flag;
	}

	@Override
	public Bill getBillById(String id) {
		Connection connection = null;
		Bill _bill = null;

		try {
			connection = BaseDao.getConnection();
			_bill = billDao.getBillById(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeResource(connection, null, null);
		}
		return _bill;
	}

	@Override
	public boolean modify(Bill bill) {
		boolean flag = false;
		Connection connection = null;
		try {
			connection = BaseDao.getConnection();
			connection.setAutoCommit(false); // 开启JDBC事务管理
			flag = billDao.modify(connection, bill);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			BaseDao.closeResource(connection, null, null);
		}

		return flag;
	}

	@Override
	public int getBillCountByProviderId(String providerId) {
		int billCount = -1;
		Connection connection = null;
		try {
			connection = BaseDao.getConnection();
			connection.setAutoCommit(false);
			billCount = billDao
					.getBillCountByProviderId(connection, providerId);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			BaseDao.closeResource(connection, null, null);
		}
		return billCount;
	}

}
