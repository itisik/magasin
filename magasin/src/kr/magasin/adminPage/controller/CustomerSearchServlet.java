package kr.magasin.adminPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.magasin.adminPage.model.service.CustomerSearchService;
import kr.magasin.adminPage.model.vo.Customer;

/**
 * Servlet implementation class CustomerSearchServlet
 */
@WebServlet(name = "CustomerSearch", urlPatterns = { "/customerSearch" })
public class CustomerSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String searchIndex = request.getParameter("searchIndex");
		// 기간조건 : 전체, 결제일, 발송일

		int dateSelect = -1;
		// 조회기간 : -1, 7, 14, 30, 90
		
		if (!searchIndex.equals("all") && !searchIndex.equals("none")) {
			// 전체기간이 아니면, 조회 기간을 숫자로 변환한다.
			dateSelect = Integer.parseInt(request.getParameter("dateSelect"));
		}
		String selectIndex = request.getParameter("selectIndex");
		// 상세조건 : 고객이름, 고객아이디, 구매상품이름

		String customer = request.getParameter("customer");
		// 검색 키워드

		CustomerSearchService service = new CustomerSearchService();
		ArrayList<Customer> list = service.CustomerSearch(searchIndex, dateSelect, selectIndex, customer);
		if(list.isEmpty()) {
			list = new ArrayList<Customer>();
			list.set(0, new Customer("", "", "", "", "", "", ""));
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
