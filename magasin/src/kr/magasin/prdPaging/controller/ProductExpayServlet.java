package kr.magasin.prdPaging.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.basket.model.vo.BasketT;
import kr.magasin.prdPaging.model.service.ProductLeeService;
import kr.magasin.product.model.vo.Product;

/**
 * Servlet implementation class ProductExpayServlet
 */
@WebServlet(name = "ProductExpay", urlPatterns = { "/productExpay" })
public class ProductExpayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductExpayServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int count = Integer.parseInt(request.getParameter("count"));
		ArrayList<BasketT> list = new ArrayList<BasketT>();
		BasketT bt = null;
		//basket.jsp에서 받아온 값 
		for(int i=0;i<count;i++) {
			bt = new BasketT();
			String prdDtlId = request.getParameter("prdDtlId"+i);
			String prdDtlSize = request.getParameter("prdDtlSize"+i);
			String prdDtlColor =request.getParameter("prdDtlColor"+i);
			int prdCount = Integer.parseInt(request.getParameter("prdCount"+i));
			int prdPrice = Integer.parseInt(request.getParameter("prdPrice"+i));	
			bt = new BasketT(prdDtlId, prdDtlSize, prdDtlColor, prdCount, prdPrice);
			list.add(bt);
		}
		//총가격
		int sum= 0;
		for(int i =0;i<count;i++) {
			int result = list.get(i).getPrdCount()*list.get(i).getPrdPrice();
			sum += result;
		}

		ProductLeeService service = new ProductLeeService();
		Product pay = service.ProductdetailId(list);
	
		
			RequestDispatcher rd = request.getRequestDispatcher("/views/prdPage/expays.jsp");
			request.setAttribute("pays", pay);
			request.setAttribute("sum", sum);
			rd.forward(request, response);
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
