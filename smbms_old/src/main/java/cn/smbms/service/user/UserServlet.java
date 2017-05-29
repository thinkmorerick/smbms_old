package cn.smbms.service.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.smbms.pojo.User;
import cn.smbms.service.impl.user.UserServiceImpl;

public class UserServlet extends HttpServlet {

	/**
		 * 出品人：rick
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	/**
		 * 出品人：rick
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查询用户列表
		String queryUserName = request.getParameter("queryname");
		/** 
		 * http://localhost:8080/smbms_old/userlist.do
		 * ----queryUserName---null
		 * http://localhost:8080/smbms_old/userlist.do?queryname=
		 * ----queryUserName---""
		 */
		System.out.println("queryUserName servlet--------" + queryUserName);
		if (queryUserName == null) {
			queryUserName = "";
		}
		UserService userService = new UserServiceImpl();
		userService.getUserList(queryUserName);
		List<User> userList = null;
		userList = userService.getUserList(queryUserName);
		request.setAttribute("userList", userList);
		request.setAttribute("queryUserName", queryUserName);
		request.getRequestDispatcher("/jsp/userlist.jsp").forward(request,
				response);
	}

}
