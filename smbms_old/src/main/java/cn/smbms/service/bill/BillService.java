package cn.smbms.service.bill;

import java.util.List;

import cn.smbms.pojo.Bill;

public interface BillService {

	/**
	 * 增加订单
	 * @param connection
	 * @param bill
	 * @return
	 * @throws Exception
	 */
	public boolean add(Bill bill);

	/**
	 * 通过查询条件获取供应商列表-模糊查询-getBillList
	 * @param connection
	 * @param bill
	 * @return
	 * @throws Exception
	 */
	public List<Bill> getBillList(Bill bill);

	/**
	 * 通过delId删除Bill
	 * @param connection
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteBillById(String delId);

	/**
	 * 通过billId获取Bill
	 * @param connection
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Bill getBillById(String id);

	/**
	 * 修改订单信息
	 * @param connection
	 * @param bill
	 * @return
	 * @throws Exception
	 */
	public boolean modify(Bill bill);

	/**
	 * 根据供应商ID查询订单数量
	 * @param connection
	 * @param delId
	 * @return
	 */
	public int getBillCountByProviderId(String providerId);

}
