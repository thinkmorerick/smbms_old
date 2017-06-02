package cn.smbms.service.provider;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.smbms.dao.BaseDao;
import cn.smbms.dao.bill.BillDao;
import cn.smbms.dao.bill.BillDaoImpl;
import cn.smbms.dao.provider.ProviderDao;
import cn.smbms.dao.provider.ProviderDaoImpl;
import cn.smbms.pojo.Provider;

public class ProviderServiceImpl implements ProviderService {
	private ProviderDao providerDao;
	private BillDao billDao;

	public ProviderServiceImpl() {
		providerDao = new ProviderDaoImpl();
		billDao = new BillDaoImpl();
	}

	@Override
	public boolean add(Provider provider) {
		boolean flag = false;
		Connection connection = null;
		try {
			connection = BaseDao.getConnection();
			connection.setAutoCommit(false);
			flag = providerDao.add(connection, provider);
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
	public List<Provider> getProviderList(String proName) {
		Connection connection = null;
		List<Provider> providerList = null;
		try {
			connection = BaseDao.getConnection();
			providerList = providerDao.getProviderList(connection, proName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeResource(connection, null, null);
		}
		return providerList;
	}

	/**
	 * 业务：根据ID删除供应商表的数据之前，需要先去订单表里进行查询操作
	 * 若订单表中无该供应商的订单数据，则可以删除
	 * 若有该供应商的订单数据，则不可以删除
	 * 返回值billCount
	 * 1> billCount == 0 删除---1成功(0) 2 不成功(-1)
	 * 2> billCount > 0 不能删除 查询成功（0） 查询不成功（-1）
	 * 
	 * ---判断--
	 * 如果billCount = -1 失败
	 * 若billCount >= 0 成功
	 */
	@Override
	public int deleteProviderById(String delId) {
		Connection connection = null;
		int billCount = -1;
		try {
			connection = BaseDao.getConnection();
			connection.setAutoCommit(false);
			billCount = billDao.getBillCountByProviderId(connection, delId);
			if (billCount == 0) {
				providerDao.deleteProviderById(connection, delId);
			}
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			billCount = -1;
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

	@Override
	public Provider getProviderById(String id) {

		Connection connection = null;
		Provider _provider = null;
		try {
			connection = BaseDao.getConnection();
			_provider = providerDao.getProviderById(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeResource(connection, null, null);
		}
		return _provider;
	}

	@Override
	public boolean modify(Provider provider) {
		boolean flag = false;
		Connection connection = null;
		try {
			connection = BaseDao.getConnection();
			connection.setAutoCommit(false);
			boolean result = providerDao.modify(connection, provider);
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
}
