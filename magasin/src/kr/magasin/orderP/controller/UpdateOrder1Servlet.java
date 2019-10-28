package kr.magasin.orderP.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.orderP.model.service.OrderPService;

/**
 * Servlet implementation class UpdateOrder1Servlet
 */
@WebServlet(name = "UpdateOrder1", urlPatterns = { "/updateOrder1" })
public class UpdateOrder1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrder1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String orderUserId = request.getParameter("orderUserId");
		int orderNum = Integer.parseInt(request.getParameter("orderNum"));
		System.out.println("주문번호 : "+orderNum); 
		OrderPService service = new OrderPService();
		int result = service.update1(orderNum);
		
		if(result>0) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "반품접수가 정상접수 되었습니다.");
			request.setAttribute("loc", "/orderList?id="+orderUserId);
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "반품접수가 되지 않았습니다. 관리자에게 문의 주세요.");
			request.setAttribute("loc", "/orderList?id="+orderUserId);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
