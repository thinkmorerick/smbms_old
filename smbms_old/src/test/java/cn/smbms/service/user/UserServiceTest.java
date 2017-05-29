package cn.smbms.service.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.smbms.pojo.User;
import cn.smbms.service.impl.user.UserServiceImpl;

public class UserServiceTest {
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		userService = new UserServiceImpl();
	}

	@Test
	public void testAdd() {
		User user = new User();
		user.setUserCode("111");
		user.setUserName("222");
		boolean result = userService.add(user);
		// result = false;
		// 断言
		Assert.assertTrue("增加失败", result);
	}
}
