package cn.smbms.service.provider;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.smbms.pojo.Provider;

public class ProviderServiceTest {

	private ProviderService providerService;

	@Before
	public void setUp() throws Exception {
		providerService = new ProviderServiceImpl();
	}

	@Test
	public void testAdd() {
		Provider provider = new Provider();
		provider.setId(111);
		provider.setProCode("5");
		provider.setProName("北京市粮油总公司");
		provider.setProDesc("无");
		provider.setProContact("黄上清");
		provider.setProPhone("18900000000");
		provider.setProAddress("无");
		provider.setProFax("无");
		provider.setCreateBy(1);
		provider.setCreationDate(new Timestamp(System.currentTimeMillis()));

		boolean result = providerService.add(provider);
		Assert.assertTrue("添加失败", result);

	}

	@Test
	public void testGetProviderList() {
		List<Provider> providerList = providerService.getProviderList("");
		Iterator<Provider> it = providerList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	@Test
	public void testDeleteProviderById() {
		int result = providerService.deleteProviderById("3");
		Assert.assertEquals(0, result);
	}

	@Test
	public void testGetProviderById() {
		Provider provider = new Provider();
		provider = providerService.getProviderById("1");
		System.out.println(provider);
	}

	@Test
	public void testModify() {
		Provider provider = new Provider();
		provider.setId(2);
		provider.setProCode("333");
		provider.setProName("邯郸市五得利面粉厂");
		provider.setProDesc("啥也没有");
		provider.setProContact("程海洋");
		provider.setProPhone("18900000000");
		provider.setProAddress("啥也没有");
		provider.setProFax("000");
		provider.setModifyBy(2);
		provider.setModifyDate(new Timestamp(System.currentTimeMillis()));
		boolean result = providerService.modify(provider);
		Assert.assertTrue("更新失败！", result);
	}

}
