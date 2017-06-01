package cn.smbms.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.smbms.pojo.User;
import cn.smbms.service.impl.user.UserServiceImpl;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

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
		String method = request.getParameter("method");
		System.out.println("method---->" + method);
		if (method != null && method.equals("add")) {
			// 增加操作
			this.add(request, response);
		} else if (method != null && method.equals("query")) {
			this.query(request, response);
		} else if (method != null && method.equals("ucexist")) {
			this.userCodeExist(request, response);
		} else if (method != null && method.equals("deluser")) {
			this.delUser(request, response);
		} else if (method != null && method.equals("view")) {
			this.getUserById(request, response, "jsp/userview.jsp");
		} else if (method != null && method.equals("modify")) {
			this.getUserById(request, response, "jsp/usermodify.jsp");
		} else if (method != null && method.equals("modifysave")) {
			this.modify(request, response);
		} else if (method != null && method.equals("pwdmodify")) {
			this.getPwdByUserId(request, response);
		} else if (method != null && method.equals("savepwd")) {
			this.updatePwd(request, response);
		}
	}

	private void updatePwd(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		Object o = request.getSession().getAttribute(Constants.USER_SESSION);
		String newpassword = request.getParameter("newpassword");
		boolean flag = false;
		if (o != null && !StringUtils.isNullOrEmpty(newpassword)) {
			UserService userService = new UserServiceImpl();
			flag = userService.updatePwd(((User) o).getId(), newpassword);
			if (flag) {
				request.setAttribute(Constants.SYS_MESSAGE, "修改密码成功！");
			} else {
				request.setAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
			}
		} else {
			request.setAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
		}
		request.getRequestDispatcher("jsp/pwdmodify.jsp").forward(request,
				response);
	}

	private void getPwdByUserId(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		Object o = request.getSession().getAttribute(Constants.USER_SESSION);
		String oldpassword = request.getParameter("oldpassword");
		Map<String, String> resultMap = new HashMap<String, String>();

		if (null != o && !StringUtils.isNullOrEmpty(oldpassword)) {
			String sessionPwd = ((User) o).getUserPassword();
			if (oldpassword.equals(sessionPwd)) {
				resultMap.put("result", "true");
			} else {
				resultMap.put("result", "false");
			}
		} else {
			resultMap.put("result", "error");
		}

		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(resultMap));
		outPrintWriter.flush();
		outPrintWriter.close();
	}

	private void modify(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("uid");
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String userType = request.getParameter("userType");

		User user = new User();
		user.setId(Integer.valueOf(id));
		user.setUserName(userName);
		user.setGender(Integer.valueOf(gender));
		try {
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setPhone(phone);
		user.setAddress(address);
		user.setUserType(Integer.valueOf(userType));
		user.setModifyBy(((User) request.getSession().getAttribute(
				Constants.USER_SESSION)).getId());
		user.setModifyDate(new Timestamp(System.currentTimeMillis()));

		UserService userService = new UserServiceImpl();
		if (userService.modify(user)) {
			request.getRequestDispatcher("/user.do?method=query").forward(
					request, response);
		} else {
			request.getRequestDispatcher("/jsp/usermodify.jsp").forward(
					request, response);

		}

	}

	private void getUserById(HttpServletRequest request,
			HttpServletResponse response, String url) throws IOException,
			ServletException {
		String id = request.getParameter("uid");
		if (!StringUtils.isNullOrEmpty(id)) {
			// 调用后台方法得到user对象
			UserService userService = new UserServiceImpl();
			User user = userService.getUserById(id);
			request.setAttribute("user", user);
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	private void delUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("uid");
		Integer delId = 0;
		try {
			delId = Integer.parseInt(id);
		} catch (Exception e) {
			delId = 0;
		}
		HashMap<String, String> resultMap = new HashMap<String, String>();

		if (delId <= 0) {
			resultMap.put("delResult", "notexist");
		} else {
			UserService userService = new UserServiceImpl();
			if (userService.deleteUserById(delId)) {
				resultMap.put("delResult", "true");
			} else {
				resultMap.put("delResult", "false");
			}
		}

		// 把resultMap转换成json对象输出
		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(resultMap));
		outPrintWriter.flush();
		outPrintWriter.close();
	}

	private void userCodeExist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 判断用户账号是否可用
		String userCode = request.getParameter("userCode");
		HashMap<String, String> resultMap = new HashMap<String, String>();
		System.out.println("userCode========" + userCode);
		if (StringUtils.isNullOrEmpty(userCode)) {
			// userCode == null || userCode.equals("")
			resultMap.put("userCode", "exist");
		} else {
			UserService userService = new UserServiceImpl();
			User user = userService.selectUserCodeExist(userCode);
			if (null != user) { // 存在
				System.out.println("userCodeExist===================");
				resultMap.put("userCode", "exist");
			} else {
				resultMap.put("userCode", "notexist");
			}
		}
		// 把resultMap转为json字符串以json的形式输出
		// 配置上下文的输出类型
		response.setContentType("application/json"); // 配置上下文的输出类型
		// 从response对象中获取往外输出的write对象
		PrintWriter outpPrintWriter = response.getWriter();
		// 把resultMap转为json字符串 输出
		outpPrintWriter.write(JSONArray.toJSONString(resultMap));
		outpPrintWriter.flush(); // 刷新
		outpPrintWriter.close(); // 关闭流
	}

	private void query(HttpServletRequest request, HttpServletResponse response)
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

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("add()=======================");
		String userCode = request.getParameter("userCode");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String userType = request.getParameter("userType");

		User user = new User();
		user.setUserCode(userCode);
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setAddress(address);
		try {
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setGender(Integer.valueOf(gender));
		user.setPhone(phone);
		user.setUserType(Integer.valueOf(userType));
		user.setCreationDate(new Timestamp(System.currentTimeMillis()));
		user.setCreateBy(((User) request.getSession().getAttribute(
				Constants.USER_SESSION)).getId());
		UserService userService = new UserServiceImpl();
		if (userService.add(user)) {
			request.getRequestDispatcher("/user.do?method=query").forward(
					request, response);
		} else {
			request.getRequestDispatcher("jsp/useradd.jsp").forward(request,
					response);
		}
	}
}
