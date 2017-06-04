package cn.smbms.dao.bill;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import cn.smbms.pojo.Bill;

public interface BillDao {
	/**
	 * 增加订单
	 * @param connection
	 * @param bill
	 * @return
	 * @throws Exception
	 */
	public boolean add(Connection connection, Bill bill) throws Exception;

	/**
	 * 通过查询条件获取供应商列表-模糊查询-getBillList
	 * @param connection
	 * @param bill
	 * @return
	 * @throws Exception
	 */
	public List<Bill> getBillList(Connection connection, Bill bill)
			throws Exception;

	/**
	 * 通过delId删除Bill
	 * @param connection
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteBillById(Connection connection, String delId)
			throws Exception;

	/**
	 * 通过billId获取Bill
	 * @param connection
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Bill getBillById(Connection connection, String id) throws Exception;

	/**
	 * 修改订单信息
	 * @param connection
	 * @param bill
	 * @return
	 * @throws Exception
	 */
	public boolean modify(Connection connection, Bill bill) throws Exception;

	/**
	 * 根据供应商ID查询订单数量
	 * @param connection
	 * @param delId
	 * @return
	 */
	public int getBillCountByProviderId(Connection connection, String providerId)
			throws Exception;

	/**
	 * 分页获取pageBillList,通过Bill模糊查询
	 * @param connection
	 * @param bill
	 * @param pageInfo
	 * @return
	 * @throws Exception
	 */
	public List<Bill> getPageBillList(Connection connection, Bill bill,
			HashMap<String, Integer> pageInfo) throws Exception;

	/**
	 * 获取订单条数，模糊查询
	 * @param connection
	 * @param bill
	 * @return
	 * @throws Exception
	 */
	public int getRecCountByBill(Connection connection, Bill bill)
			throws Exception;

}
