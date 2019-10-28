package kr.magasin.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.product.model.service.ProductService;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int count = Integer.parseInt(request.getParameter("count0"));
		System.out.println(count);
		for(int i=0;i<count; i++) {
		String prdDtlId = request.getParameter("prdDtlId"+i);
		String prdDtlSize = request.getParameter("prdDtlSize"+i);
		String prdDtlColor = request.getParameter("prdDtlColor"+i);
		String prdCount = request.getParameter("prdCount"+i);
		String prdPrice = request.getParameter("prdPrice"+i);
		
		System.out.println(prdDtlId+"/"+prdDtlSize+"/"+prdDtlColor+"/"+prdCount+"/"+prdPrice);
		}
		System.out.println("결제창");
		
		
		ProductService service = new ProductService();
		
	/*	Product pay = service.ProductdetailId();
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/prdPage/expays.jsp");
		request.setAttribute("pays", pay);
		
		rd.forward(request, response);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
