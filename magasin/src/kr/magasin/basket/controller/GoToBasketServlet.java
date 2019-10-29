package kr.magasin.basket.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.basket.model.service.BasketService;
import kr.magasin.basket.model.vo.Basket;
import kr.magasin.basket.model.vo.BasketT;
import kr.magasin.basket.model.vo.BasketYim;

/**
 * Servlet implementation class GoToBasketServlet
 */
@WebServlet(name = "GoToBasket", urlPatterns = { "/goToBasket" })
public class GoToBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToBasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		

	String prdDtlSize = request.getParameter("prdDtlSize");
	String prdDtlColor = request.getParameter("prdDtlColor");
	String basketUserId = request.getParameter("basketUserId");
	String prdName = request.getParameter("prdName");
	int prdId = Integer.parseInt(request.getParameter("prdId"));
	int prdCount = Integer.parseInt(request.getParameter("prdCount"));
	int prdPrice = Integer.parseInt(request.getParameter("prdPrice"));
	BasketService service = new BasketService();
	int prdDtlId = Integer.parseInt(service.goToBasket(prdId, prdDtlSize, prdDtlColor));
	BasketYim bsk = new BasketYim(0, basketUserId, prdDtlId, prdCount);
	int result = service.updateBasket(bsk);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
