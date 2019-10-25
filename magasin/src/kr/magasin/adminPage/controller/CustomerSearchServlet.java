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
		String selectIndex = request.getParameter("selectIndex");
		int dateSelect = -1;

		if (!searchIndex.equals("none")) {
			dateSelect = Integer.parseInt(request.getParameter("dateSelect"));
		}
		String customer = request.getParameter("customer");

		CustomerSearchService service = new CustomerSearchService();
		ArrayList<Customer> list = service.CustomerSearch(searchIndex, dateSelect, selectIndex, customer);
		if (!list.isEmpty()) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(list, response.getWriter());

			System.out.println(searchIndex + "/" + selectIndex + "/" + dateSelect + "/" + customer);
		} else {
			request.setAttribute("customers", "조회 결과가 없습니다.");
		}
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
