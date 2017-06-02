package cn.smbms.dao.provider;

import java.sql.Connection;
import java.util.List;

import cn.smbms.pojo.Provider;

public interface ProviderDao {

	/**
	 * 增加供应商
	 * @param connection
	 * @param provider
	 * @return
	 * @throws Exception
	 */
	public boolean add(Connection connection, Provider provider)
			throws Exception;

	/**
	 * 通过供应商名称获取供应商列表-模糊查询-providerList
	 * @param connection
	 * @param proName
	 * @return
	 */
	public List<Provider> getProviderList(Connection connection, String proName)
			throws Exception;

	/**
	 * 通过proId删除Provider
	 * @param connection
	 * @param string
	 * @return
	 * @throws Exception
	 */
	public boolean deleteProviderById(Connection connection, String delId)
			throws Exception;

	/**
	 * 通过proId获取Provider
	 * @param connection
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Provider getProviderById(Connection connection, String id)
			throws Exception;

	/**
	 * 修改用户信息
	 * @param connection
	 * @param provider
	 * @return
	 * @throws Exception
	 */
	public boolean modify(Connection connection, Provider provider)
			throws Exception;
}
