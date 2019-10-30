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
import kr.magasin.prdPaging.model.vo.PageDataLee;
import kr.magasin.prdPaging.model.vo.ProductLee;
import kr.magasin.productDtl.model.vo.ProductDtl;

/**
 * Servlet implementation class NewProductServlet
 */
@WebServlet(name = "NewProduct", urlPatterns = { "/newProduct" })
public class NewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int reqPage;
		
		try {
		reqPage = Integer.parseInt(request.getParameter("reqPage"));
		
		}catch(NumberFormatException e) {
			reqPage = 1;
		}
		
		
		String gender = request.getParameter("gender");
		ProductLeeService service = new ProductLeeService();
		PageDataLee pd = service.newPrdList(reqPage,gender);

		ArrayList<ArrayList<ProductDtl>> colors = service.searchColor(pd.getLists());
		request.setAttribute("dtlList", colors);
		
		/*ArrayList<ProductLee> list = service.newPrdList(gender);*/
		request.setAttribute("newList", pd.getLists());
		request.setAttribute("pageNavi", pd.getPageNavi());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/prdPage/newPrd.jsp");
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
