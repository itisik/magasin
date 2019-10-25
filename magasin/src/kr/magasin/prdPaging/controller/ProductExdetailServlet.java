package kr.magasin.prdPaging.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.prdPaging.model.service.ProductLeeService;
import kr.magasin.product.model.vo.Product;

/**
 * Servlet implementation class ProductExdetailServlet
 */
@WebServlet(name = "ProductExdetail", urlPatterns = { "/productExdetail" })
public class ProductExdetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductExdetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		int prdId = Integer.parseInt(request.getParameter("prdId"));
		
		
		ProductLeeService service = new ProductLeeService();
		Product prd = service.ProductdetailId(prdId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/prdPage/exdetail.jsp");
		
		request.setAttribute("productId", prd);
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
