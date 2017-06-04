package cn.smbms.servlet.bill;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Provider;
import cn.smbms.pojo.User;
import cn.smbms.service.bill.BillService;
import cn.smbms.service.bill.BillServiceImpl;
import cn.smbms.service.provider.ProviderService;
import cn.smbms.service.provider.ProviderServiceImpl;
import cn.smbms.tools.Constants;
import cn.smbms.tools.PageSupport;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

public class BillServlet extends HttpServlet {

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
		if (method != null && method.equals("query")) {
			this.query(request, response);
		} else if (method != null && method.equals("add")) {
			this.add(request, response);
		} else if (method != null && method.equals("view")) {
			this.getBillById(request, response, "jsp/billview.jsp");
		} else if (method != null && method.equals("modify")) {
			this.getBillById(request, response, "jsp/billmodify.jsp");
		} else if (method != null && method.equals("modifysave")) {
			this.modify(request, response);
		} else if (method != null && method.equals("delbill")) {
			this.delBill(request, response);
		} else if (method != null && method.equals("getproviderlist")) {
			this.getProviderlist(request, response);
		}
	}

	private void delBill(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("bid");
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(id)) {
			BillService billService = new BillServiceImpl();
			boolean flag = billService.deleteBillById(id);
			if (flag) {// 删除成功
				resultMap.put("delResult", "true");
			} else {// 删除失败
				resultMap.put("delResult", "false");
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

	private void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("bid");
		String productName = request.getParameter("productName");
		String productDesc = request.getParameter("productDesc");
		String productUnit = request.getParameter("productUnit");
		String productCount = request.getParameter("productCount");
		String totalPrice = request.getParameter("totalPrice");
		String providerId = request.getParameter("providerId");
		String isPayment = request.getParameter("isPayment");

		Bill bill = new Bill();
		bill.setId(Integer.valueOf(id));
		bill.setProductName(productName);
		bill.setProductDesc(productDesc);
		bill.setProductUnit(productUnit);
		bill.setProductCount(new BigDecimal(productCount).setScale(2,
				BigDecimal.ROUND_DOWN));
		bill.setIsPayment(Integer.parseInt(isPayment));
		bill.setTotalPrice(new BigDecimal(totalPrice).setScale(2,
				BigDecimal.ROUND_DOWN));
		bill.setProviderId(Integer.parseInt(providerId));

		bill.setModifyBy(((User) request.getSession().getAttribute(
				Constants.USER_SESSION)).getId());
		bill.setModifyDate(new Timestamp(System.currentTimeMillis()));
		boolean flag = false;
		BillService billService = new BillServiceImpl();
		flag = billService.modify(bill);
		if (flag) {
			request.getRequestDispatcher("/bill.do?method=query").forward(
					request, response);
		} else {
			request.getRequestDispatcher("jsp/billmodify.jsp").forward(request,
					response);
		}

	}

	private void getBillById(HttpServletRequest request,
			HttpServletResponse response, String url) throws ServletException,
			IOException {
		String id = request.getParameter("bid");
		if (!StringUtils.isNullOrEmpty(id)) {
			Bill bill = new BillServiceImpl().getBillById(id);
			request.setAttribute("bill", bill);
			request.getRequestDispatcher(url).forward(request, response);
		}

	}

	private void getProviderlist(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<Provider> providerList = new ArrayList<Provider>();
		ProviderService providerService = new ProviderServiceImpl();
		providerList = providerService.getProviderList("");
		// 把providerList转换成json对象输出
		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(providerList));
		outPrintWriter.flush();
		outPrintWriter.close();
	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String billCode = request.getParameter("billCode");
		String productName = request.getParameter("productName");
		String productDesc = request.getParameter("productDesc");
		String productUnit = request.getParameter("productUnit");

		String productCount = request.getParameter("productCount");
		String totalPrice = request.getParameter("totalPrice");
		String providerId = request.getParameter("providerId");
		String isPayment = request.getParameter("isPayment");

		Bill bill = new Bill();
		bill.setBillCode(billCode);
		bill.setProductName(productName);
		bill.setProductDesc(productDesc);
		bill.setProductUnit(productUnit);

		bill.setProductCount(new BigDecimal(productCount).setScale(2,
				BigDecimal.ROUND_DOWN));
		bill.setTotalPrice(new BigDecimal(totalPrice).setScale(2,
				BigDecimal.ROUND_DOWN));
		bill.setProviderId(Integer.valueOf(providerId));
		bill.setIsPayment(Integer.valueOf(isPayment));
		bill.setCreateBy(((User) request.getSession().getAttribute(
				Constants.USER_SESSION)).getId());
		bill.setCreateDate(new Timestamp(System.currentTimeMillis()));

		BillService billService = new BillServiceImpl();
		if (billService.add(bill)) {
			request.getRequestDispatcher("/bill.do?method=query").forward(
					request, response);
		} else {
			request.getRequestDispatcher("jsp/billadd.jsp").forward(request,
					response);
		}
	}

	private void query2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Provider> providerList = new ArrayList<Provider>();
		ProviderService providerService = new ProviderServiceImpl();
		providerList = providerService.getProviderList("");
		request.setAttribute("providerList", providerList);

		String queryProductName = request.getParameter("queryProductName");
		String queryProviderId = request.getParameter("queryProviderId");
		String queryIsPayment = request.getParameter("queryIsPayment");
		if (StringUtils.isNullOrEmpty(queryProductName)) {
			queryProductName = "";
		}

		List<Bill> billList = new ArrayList<Bill>();
		BillService billService = new BillServiceImpl();
		Bill bill = new Bill();
		if (StringUtils.isNullOrEmpty(queryIsPayment)) {
			bill.setIsPayment(0);
		} else {
			bill.setIsPayment(Integer.parseInt(queryIsPayment));
		}

		if (StringUtils.isNullOrEmpty(queryProviderId)) {
			bill.setProviderId(0);
		} else {
			bill.setProviderId(Integer.parseInt(queryProviderId));
		}
		bill.setProductName(queryProductName);
		billList = billService.getBillList(bill);
		request.setAttribute("billList", billList);
		request.setAttribute("queryProductName", queryProductName);
		request.setAttribute("queryProviderId", queryProviderId);
		request.setAttribute("queryIsPayment", queryIsPayment);
		request.getRequestDispatcher("jsp/billlist.jsp").forward(request,
				response);
	}

	// 分页查询用户列表
	public void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Provider> providerList = new ArrayList<Provider>();
		ProviderService providerService = new ProviderServiceImpl();
		providerList = providerService.getProviderList("");
		request.setAttribute("providerList", providerList);
		String queryProductName = request.getParameter("queryProductName");
		String queryProviderId = request.getParameter("queryProviderId");
		String queryIsPayment = request.getParameter("queryIsPayment");
		String pageIndex = request.getParameter("pageIndex");
		Bill bill = new Bill();
		bill.setProductName(queryProductName);
		if (!StringUtils.isNullOrEmpty(queryProviderId)) {
			if (Integer.valueOf(queryProviderId) > 0) {
				bill.setProviderId(Integer.valueOf(queryProviderId));
			}
		}
		if (!StringUtils.isNullOrEmpty(queryIsPayment)) {
			if (Integer.valueOf(queryIsPayment) > 0) {
				bill.setIsPayment(Integer.valueOf(queryIsPayment));
			}
		}
		BillService billService = new BillServiceImpl();
		int billPageSize = Constants.BILL_PAGE_SIZE;
		// 实例化PageSupport对象
		PageSupport pageSupport = new PageSupport();
		pageSupport.setPageSize(billPageSize);
		// 查询总记录数
		int recCount = billService.getRecCountByBill(bill);
		pageSupport.setRecCount(recCount);
		// 设置当前页码
		int pageStartNo = 1;
		if (!StringUtils.isNullOrEmpty(pageIndex)) {// 设置当前页码
			pageStartNo = Integer.parseInt(pageIndex);
			if (pageStartNo < 1) {
				pageStartNo = 1;
			} else if (pageStartNo > pageSupport.getTotalPageCount()) {
				pageStartNo = pageSupport.getTotalPageCount();
			}
		}
		pageSupport.setCurrPageNo(pageStartNo);
		// 分页获取billlist
		HashMap<String, Integer> pageInfo = new HashMap<String, Integer>();
		pageInfo.put(Constants.PAGE_START_NO, Integer.valueOf(pageStartNo));
		pageInfo.put(Constants.PAGE_SIZE, Integer.valueOf(billPageSize));

		List<Bill> billList = billService.getPageBillList(bill, pageInfo);
		request.setAttribute("pageSupport", pageSupport);
		// 设置billlist的分页选项容量
		request.setAttribute("pageNavNum", Constants.BILL_PAGE_NAV_NUM);

		request.setAttribute("billList", billList);
		request.setAttribute("queryProductName", queryProductName);
		request.setAttribute("queryProviderId", queryProviderId);
		request.setAttribute("queryIsPayment", queryIsPayment);
		request.getRequestDispatcher("/jsp/billlist.jsp").forward(request,
				response);
	}

}
