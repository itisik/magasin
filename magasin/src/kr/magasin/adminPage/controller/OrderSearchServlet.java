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
import kr.magasin.adminPage.model.service.OrderSearchService;
import kr.magasin.adminPage.model.vo.Customer;
import kr.magasin.adminPage.model.vo.Order;

/**
 * Servlet implementation class OrderSearchServlet
 */
@WebServlet(name = "OrderSearch", urlPatterns = { "/orderSearch" })
public class OrderSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String timeIndex = request.getParameter("timeIndex");
		// 조회 기간 카테고리

		int dateSelect2 = -1;
		// 조회기간 : -1, 7, 14, 30, 90

		if (!timeIndex.equals("all2") && !timeIndex.equals("none2")) {
			// 전체기간이 아니면, 조회 기간을 숫자로 변환한다.
			dateSelect2 = Integer.parseInt(request.getParameter("dateSelect"));
		}
		String detailIndex = request.getParameter("detailIndex");
		// 상세조건 : 전체주문, 신규주문, ..........
		
		String order = request.getParameter("order");
		// 검색 키워드

		OrderSearchService service = new OrderSearchService();
		ArrayList<Order> list = service.OrderSearch(timeIndex, dateSelect2, detailIndex, order);
		if(list.isEmpty()) {
			list = new ArrayList<Order>();
			list.set(0, new Order("", "", "", "", "", "", "", ""));
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
