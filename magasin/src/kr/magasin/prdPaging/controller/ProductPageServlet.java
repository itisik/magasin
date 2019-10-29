package kr.magasin.prdPaging.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.prdPaging.model.service.ProductLeeService;
import kr.magasin.prdPaging.model.vo.PageDataLee;
import kr.magasin.prdPaging.model.vo.ProductLee;
import kr.magasin.productDtl.model.vo.ProductDtl;

/**
 * Servlet implementation class ProductPageServlet
 */
@WebServlet(name = "ProductPage", urlPatterns = { "/productPage" })
public class ProductPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String ctgr = request.getParameter("ctgr");
		
		String gender = request.getParameter("gender");
		
		int reqPage;
		
		try {
		reqPage = Integer.parseInt(request.getParameter("reqPage"));
		
		}catch(NumberFormatException e) {
			reqPage = 1;
		}
		
		
		ProductLeeService service = new ProductLeeService();
		PageDataLee pd = service.selectList(reqPage,ctgr,gender);
		ArrayList<ProductDtl> list = service.searchColor();

		ArrayList<String> subCtgr = service.subCtgr(ctgr, gender);

		ArrayList<Integer> subCtgrCount = service.subCtgrCount(ctgr, subCtgr);
		request.setAttribute("count", subCtgrCount);

		request.setAttribute("lists", pd.getLists());
		request.setAttribute("pageNavi",pd.getPageNavi());
		request.setAttribute("prdDtl", list);
		request.setAttribute("sub", subCtgr);
	
		RequestDispatcher rd = request.getRequestDispatcher("/views/prdPage/lists.jsp");
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
