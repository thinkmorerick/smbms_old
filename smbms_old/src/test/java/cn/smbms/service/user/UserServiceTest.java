package cn.smbms.service.user;

import java.util.ArrayList;
import java.util.List;

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

	@Test
	public void testGetUserList() {
		List<User> userList = new ArrayList<User>();
		userList = userService.getUserList("null");
		Assert.assertEquals(7, userList.size());
	}

	@Test
	public void testDeleteUserById() {
		boolean result = userService.deleteUserById(14);
		Assert.assertTrue("删除失败", result);
	}

	@Test
	public void testGetUserById() {
		User user = new User();
		user = userService.getUserById(String.valueOf(1));
		Assert.assertNull("不为空", user);
	}

	@Test
	public void testModify() {
		User user = new User();
		user = userService.getUserById(String.valueOf(1));
		user.setUserName("kkkkkkkkkkk");
		boolean result = userService.modify(user);
		Assert.assertTrue("更新失败", result);
	}
}
