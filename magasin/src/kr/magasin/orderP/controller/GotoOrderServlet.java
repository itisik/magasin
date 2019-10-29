package kr.magasin.orderP.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.magasin.orderP.model.vo.OrderYim;
import kr.magasin.orderP.model.service.OrderPService;
import kr.magasin.orderP.model.vo.OrderP2;

/**
 * Servlet implementation class GotoOrderServlet
 */
@WebServlet(name = "GotoOrder", urlPatterns = { "/gotoOrder" })
public class GotoOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GotoOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ArrayList<OrderYim> list = new ArrayList<OrderYim>();
		OrderYim order = null;
		int count = Integer.parseInt(request.getParameter("count"));
		for(int i = 0;i<count;i++) {
			order = new OrderYim();
			String orderUserId = request.getParameter("orderUserId");
			String orderBuyerName = request.getParameter("orderBuyerName");
			String orderBuyerPhone = request.getParameter("orderBuyerPhone");
			int orderPrdDtlId = Integer.parseInt(request.getParameter("orderPrdDtlId"));
			int orderPrdCount = Integer.parseInt(request.getParameter("orderPrdCount"));
			int orderMoney = Integer.parseInt(request.getParameter("orderMoney"));
			String orderAddr = request.getParameter("orderAddr");
			String orderPay = request.getParameter("orderPay");
			int  orderStatus = Integer.parseInt(request.getParameter("orderStatus"));
			list.add(order);
		}
		
		OrderPService service = new OrderPService();
		int result = service.updateOrderP(count, list);
		
		if(result>0){
			System.out.println("ORDERP 에 INSERT");
		}else {
			System.out.println("ORDERP 에 INSERT XXXXXXX");
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
