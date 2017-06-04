package cn.smbms.service.bill;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.smbms.pojo.Bill;

public class BillServiceTest {
	private BillService billService;

	@Before
	public void setUp() throws Exception {
		billService = new BillServiceImpl();
	}

	@Test
	public void testAdd() {
		Bill bill = new Bill();
		bill.setId(1);
		bill.setBillCode("6");
		bill.setProductName("原阳大米");
		bill.setProductDesc("没有");
		bill.setProductUnit("袋");
		bill.setProductCount(new BigDecimal("20.00"));
		bill.setTotalPrice(new BigDecimal("20.00"));
		bill.setIsPayment(1);
		bill.setProviderId(1);
		bill.setCreateDate(new Timestamp(System.currentTimeMillis()));
		bill.setCreateBy(1);
		boolean result = billService.add(bill);
		Assert.assertTrue("添加失败！", result);
	}

	@Test
	public void testGetBillList() {
		Bill bill = new Bill();
		// bill.setProductName("原阳大米");
		// bill.setProviderId(1);
		bill.setIsPayment(1);
		List<Bill> billList = billService.getBillList(bill);
		for (Bill bill2 : billList) {
			System.out.println(bill2);
		}
	}

	@Test
	public void testDeleteBillById() {
		boolean result = billService.deleteBillById("3");
		Assert.assertTrue("删除失败", result);
	}

	@Test
	public void testGetBillById() {
		System.out.println(billService.getBillById("2"));
	}

	@Test
	public void testModify() {
		Bill bill = new Bill();
		bill.setId(3);
		bill.setBillCode("6");
		bill.setProductName("燕京啤酒-普通");
		bill.setProductDesc("没有");
		bill.setProductUnit("瓶");
		bill.setProductCount(new BigDecimal("25.00"));
		bill.setTotalPrice(new BigDecimal("25.00"));
		bill.setIsPayment(1);
		bill.setProviderId(2);
		bill.setModifyDate(new Timestamp(System.currentTimeMillis()));
		bill.setModifyBy(1);
		boolean result = billService.modify(bill);
		Assert.assertTrue("更新失败！", result);
	}

	@Test
	public void testGetBillCountByProviderId() {
		int result = billService.getBillCountByProviderId("1");
		Assert.assertEquals(1, result);
	}

}
