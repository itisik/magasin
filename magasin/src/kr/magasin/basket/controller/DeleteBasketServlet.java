package kr.magasin.basket.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.basket.model.service.BasketService;

/**
 * Servlet implementation class DeleteBasketServlet
 */
@WebServlet(name = "DeleteBasket", urlPatterns = { "/deleteBasket" })
public class DeleteBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String basketUserId = request.getParameter("basketUserId");
		int basketId = Integer.parseInt(request.getParameter("basketId"));
		BasketService service = new BasketService();
		int result = service.deleteOne(basketId);
		if(result>0) {
			RequestDispatcher rd = request.getRequestDispatcher("/listBasket?id="+basketUserId);
			rd.forward(request, response);
		}else {
			System.out.println("장바구니 전체 삭제 실패 ");
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
