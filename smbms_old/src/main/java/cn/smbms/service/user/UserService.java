package cn.smbms.service.user;

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
}
