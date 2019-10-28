package kr.magasin.prdPaging.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.prdPaging.model.service.ProductLeeService;
import kr.magasin.product.model.vo.Product;
import kr.magasin.productDtl.model.vo.ProductDtl;

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

		int prdId = Integer.parseInt(request.getParameter("prdId"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		String prdName = request.getParameter("prdName");
		int prdPrice = Integer.parseInt(request.getParameter("prdPrice"));
		String prdDtlColor = request.getParameter("prdDtrlColor");
		String prdDtlSize = request.getParameter("prdDtlSize");
		
		
		
		
		ProductLeeService service = new ProductLeeService();

		Product pay = service.ProductdetailId(prdId);
		
		
		
		
		
			RequestDispatcher rd = request.getRequestDispatcher("/views/prdPage/expays.jsp");
			request.setAttribute("pays", pay);
			
			
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
