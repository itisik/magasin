package kr.magasin.adminPage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.product.model.service.ProductService;
import kr.magasin.product.model.vo.Product;
import kr.magasin.productDtl.model.vo.ProductDtl;

/**
 * Servlet implementation class PrdUpdateServlet
 */
@WebServlet(name = "PrdUpdate", urlPatterns = { "/prdUpdate" })
public class PrdUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrdUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int prdId = Integer.parseInt(request.getParameter("prdId"));
		ProductService pservice = new ProductService();
		Product p = new Product();
		ProductDtl pdtl = new ProductDtl();
		if(p !=null){
			p = pservice.searchOne(prdId);	
		}
		request.setAttribute("product", p);
		request.setAttribute("productdtl", pdtl);
		System.out.println(p.getPrdName());
		System.out.println(p.getPrdId());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/adminPage/graph/graphPage.jsp");
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
