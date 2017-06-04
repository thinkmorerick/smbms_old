package cn.smbms.service.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.smbms.pojo.User;
import cn.smbms.tools.Constants;

public class UserServiceTest {
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		userService = new UserServiceImpl();
	}

	@Test
	public void testAdd() {

		User user = new User();
		user.setUserCode("1211211");
		user.setUserName("221212");
		boolean result = userService.add(user);
		// result = false;
		// 断言
		Assert.assertTrue("增加失败", result);
	}

	@Test
	public void testLogin() {
		User user = new User();
		String userCode = "rick";
		String userPassword = "0000000";
		user = userService.login(userCode, userPassword);
		Assert.assertNotNull("空的", user);
	}

	@Test
	public void testGetUserList() {
		List<User> userList = new ArrayList<User>();
		userList = userService.getUserList("null");
		Assert.assertEquals(7, userList.size());
	}

	@Test
	public void testSelectUserCodeExist() {
		User user = new User();
		user = userService.selectUserCodeExist("rick1");
		Assert.assertNotNull("为空", user);
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

	@Test
	public void testUpdatePwd() {
		boolean result = userService.updatePwd(111, "111111");
		Assert.assertTrue("更新失败！", result);
	}

	@Test
	public void testGetPageUserList() {

		HashMap<String, Integer> pageInfo = new HashMap<String, Integer>();
		pageInfo.put(Constants.PAGE_START_NO, Integer.valueOf(1));
		pageInfo.put(Constants.PAGE_SIZE, Integer.valueOf(10));
		List<User> userList = userService.getPageUserList("", pageInfo);
		for (User user : userList) {
			System.out.println(user.getAge());
		}
	}

}
