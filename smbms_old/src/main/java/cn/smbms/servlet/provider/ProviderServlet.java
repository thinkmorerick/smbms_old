package cn.smbms.servlet.provider;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.smbms.pojo.Provider;
import cn.smbms.pojo.User;
import cn.smbms.service.provider.ProviderService;
import cn.smbms.service.provider.ProviderServiceImpl;
import cn.smbms.tools.Constants;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

public class ProviderServlet extends HttpServlet {

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
		/**String totalPrice = request.getParameter("totalPrice");
		// 设置规则：小数点后保留2位，多出部分：ROUND_DOWN:舍弃
		// ROUND_HALF_UP:四舍五入（5入）
		
		 * BigDecimal totalPriceBigDecimal = new
		 * BigDecimal(totalPrice).setScale( 2, BigDecimal.ROUND_HALF_UP);
		 
		// ROUND_HALF_DOWN:四舍五入（>5）5不入
		
		 * BigDecimal totalPriceBigDecimal = new
		 * BigDecimal(totalPrice).setScale( 2, BigDecimal.ROUND_HALF_DOWN);
		 
		// ROUND_UP:进位
		
		 * BigDecimal totalPriceBigDecimal = new
		 * BigDecimal(totalPrice).setScale( 2, BigDecimal.ROUND_UP);
		 

		// ROUND_DOWN:舍弃
		BigDecimal totalPriceBigDecimal = new BigDecimal(totalPrice).setScale(
				2, BigDecimal.ROUND_DOWN);*/
		String method = request.getParameter("method");
		if (method != null && method.equals("query")) {
			this.query(request, response);
		} else if (method != null && method.equals("add")) {
			this.add(request, response);
		} else if (method != null && method.equals("delprovider")) {
			this.delProvider(request, response);
		} else if (method != null && method.equals("view")) {
			this.getProviderById(request, response, "jsp/providerview.jsp");
		} else if (method != null && method.equals("modify")) {
			this.getProviderById(request, response, "jsp/providermodify.jsp");
		} else if (method != null && method.equals("modifysave")) {
			this.modify(request, response);
		}
	}

	private void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("pid");
		System.out.println(".........");
		System.out.println(id);
		String proContact = request.getParameter("proContact");
		String proPhone = request.getParameter("proPhone");
		String proAddress = request.getParameter("proAddress");
		String proFax = request.getParameter("proFax");
		String proDesc = request.getParameter("proDesc");

		Provider provider = new Provider();
		provider.setId(Integer.valueOf(id));
		provider.setProContact(proContact);
		provider.setProPhone(proPhone);
		provider.setProAddress(proAddress);
		provider.setProFax(proFax);
		provider.setProDesc(proDesc);
		provider.setModifyBy(((User) request.getSession().getAttribute(
				Constants.USER_SESSION)).getId());
		provider.setModifyDate(new Timestamp(System.currentTimeMillis()));

		ProviderService providerService = new ProviderServiceImpl();
		if (providerService.modify(provider)) {
			request.getRequestDispatcher("/provider.do?method=query").forward(
					request, response);
		} else {
			request.getRequestDispatcher("/jsp/providermodify.jsp").forward(
					request, response);

		}

	}

	private void getProviderById(HttpServletRequest request,
			HttpServletResponse response, String url) throws ServletException,
			IOException {
		String id = request.getParameter("pid");
		if (!StringUtils.isNullOrEmpty(id)) {
			ProviderService providerService = new ProviderServiceImpl();
			Provider provider = providerService.getProviderById(id);
			request.setAttribute("provider", provider);
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	private void delProvider(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(id)) {
			ProviderService providerService = new ProviderServiceImpl();
			int flag = providerService.deleteProviderById(id);
			if (flag == 0) { // 删除成功
				resultMap.put("delResult", "true");
			} else if (flag == -1) { // 删除失败
				resultMap.put("delResult", "false");
			} else if (flag > 0) { // 该供应商下有订单，不能删除，返回订单数
				resultMap.put("delResult", String.valueOf(flag));
			}
		} else {
			resultMap.put("delResult", "notexit");
		}
		// 把resultMap转换成json对象输出
		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(resultMap));
		outPrintWriter.flush();
		outPrintWriter.close();
	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String proCode = request.getParameter("proCode");
		String proName = request.getParameter("proName");
		String proContact = request.getParameter("proContact");
		String proPhone = request.getParameter("proPhone");
		String proAddress = request.getParameter("proAddress");
		String proDesc = request.getParameter("proDesc");
		String proFax = request.getParameter("proFax");

		Provider provider = new Provider();
		provider.setProCode(proCode);
		provider.setProName(proName);
		provider.setProPhone(proPhone);
		provider.setProContact(proContact);
		provider.setProAddress(proAddress);
		provider.setProDesc(proDesc);
		provider.setProFax(proFax);
		provider.setCreateBy(((User) request.getSession().getAttribute(
				Constants.USER_SESSION)).getId());

		provider.setCreationDate(new Timestamp(System.currentTimeMillis()));

		ProviderService providerService = new ProviderServiceImpl();
		if (providerService.add(provider)) {
			request.getRequestDispatcher("/provider.do?method=query").forward(
					request, response);
		} else {
			request.getRequestDispatcher("jsp/provideradd.jsp").forward(
					request, response);
		}
	}

	private void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String queryProName = request.getParameter("queryProName");
		if (StringUtils.isNullOrEmpty(queryProName)) {
			queryProName = "";
		}
		List<Provider> providerList = new ArrayList<Provider>();

		ProviderService providerService = new ProviderServiceImpl();
		providerList = providerService.getProviderList(queryProName);
		request.setAttribute("providerList", providerList);
		request.setAttribute("queryProName", queryProName);
		request.getRequestDispatcher("jsp/providerlist.jsp").forward(request,
				response);
	}

	/**public static void main(String[] args) {
		System.out.println(new BigDecimal("23.235").setScale(2,
				BigDecimal.ROUND_DOWN));
	}*/

}
