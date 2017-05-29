package cn.smbms.service.user;

import java.util.List;

import cn.smbms.pojo.User;

public interface UserService {

	/**
	 * 增加用户信息
	 * @param user
	 * @return
	 */
	public boolean add(User user);

	/**
	 * 判断用户是否存在
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public User login(String userCode, String userPassword);

	/**
	 * 查询用户列表
	 * @param userName
	 * @return
	 */
	public List<User> getUserList(String queryUserName);
}
