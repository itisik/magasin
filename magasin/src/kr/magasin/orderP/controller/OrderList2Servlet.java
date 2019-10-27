package kr.magasin.orderP.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.orderP.model.service.OrderPService;
import kr.magasin.orderP.model.vo.OrderP2;

/**
 * Servlet implementation class OrderList2Servlet
 */
@WebServlet(name = "orderList2", urlPatterns = { "/orderList2" })
public class OrderList2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderList2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String orderUserId = request.getParameter("orderUserId");
		System.out.println("orderUserId"+orderUserId);
		OrderPService service = new OrderPService();
		ArrayList<OrderP2> list = service.selectAll2(orderUserId);
		RequestDispatcher rd  = request.getRequestDispatcher("/views/myPage/orderList2.jsp");
		request.setAttribute("orderP2", list);
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
