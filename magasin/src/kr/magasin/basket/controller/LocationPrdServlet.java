package kr.magasin.basket.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.basket.model.service.BasketService;
import kr.magasin.prdPaging.model.service.ProductLeeService;
import kr.magasin.product.model.vo.Product;
import kr.magasin.productDtl.model.vo.ProductDtl;

/**
 * Servlet implementation class LocationPrdServlet
 */
@WebServlet(name = "LocationPrd", urlPatterns = { "/locationPrd" })
public class LocationPrdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationPrdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int prdDtlId = Integer.parseInt(request.getParameter("prdDtlId"));
		System.out.println("이미지 눌러서 상품 이동하려 할떄 들어오는 prdDtlId 확인"+prdDtlId);
		BasketService service = new BasketService();
		int prdId = service.locationPrd(prdDtlId);
		System.out.println("locationPrd 타고 넘어온 prdId :"+prdId);
		
		ProductLeeService service2 = new ProductLeeService();
		Product prd = service2.ProductdetailId(prdId);//경필 결제페이지 가는 로직
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/prdPage/exdetail.jsp");
		
		ArrayList<ProductDtl> prdDtl = service2.searchColor();
		
		request.setAttribute("prdCol", prdDtl);
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
