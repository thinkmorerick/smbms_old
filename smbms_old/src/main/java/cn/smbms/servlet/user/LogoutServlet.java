package cn.smbms.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.smbms.tools.Constants;

public class LogoutServlet extends HttpServlet {

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
		// 清除session
		request.getSession().removeAttribute(Constants.USER_SESSION);
		response.sendRedirect("login.jsp");
	}

}
