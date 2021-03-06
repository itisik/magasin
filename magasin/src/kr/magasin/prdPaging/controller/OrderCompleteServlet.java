package kr.magasin.prdPaging.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.prdPaging.model.service.ProductLeeService;

/**
 * Servlet implementation class OrderCompleteServlet
 */
@WebServlet(name = "OrderComplete", urlPatterns = { "/orderComplete" })
public class OrderCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String memberId = request.getParameter("prdId");

		int prdId = Integer.parseInt(request.getParameter("prdId"));
		String size = request.getParameter("size");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String color = request.getParameter("color");
		ProductLeeService service = new ProductLeeService();

		
		int result = service.orderComplete(memberId,prdId,size,amount,color);
		if(result>0) {
			request.setAttribute("msg", "결제성공~");
			request.setAttribute("loc", "/");
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "결제실패~");
			request.setAttribute("loc", "/");
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
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
