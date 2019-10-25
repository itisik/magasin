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
 * Servlet implementation class UpdateBasketCountServlet
 */
@WebServlet(name = "UpdateBasketCount", urlPatterns = { "/updateBasketCount" })
public class UpdateBasketCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBasketCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int basketId = Integer.parseInt(request.getParameter("basketId"));
		int basketPrdCount = Integer.parseInt(request.getParameter("basketPrdCount"));
		String basketUserId = request.getParameter("basketUserId");
		System.out.println("장바구니 갯수 수정 페이지 ");
	
		BasketService service = new BasketService();
		int result = service.updateBasketCount(basketId, basketPrdCount);
		System.out.println("service !!"+result);
		
		if(result>0) {
			System.out.println("장바구니  카운트 업데이트 성공");
			RequestDispatcher rd = request.getRequestDispatcher("/listBasket?id="+basketUserId);
			rd.forward(request, response);
		}else {
			System.out.println("장바구니  카운트 업데이트 실패 ");
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
