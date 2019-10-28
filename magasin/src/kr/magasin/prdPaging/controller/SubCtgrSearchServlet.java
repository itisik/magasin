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
import kr.magasin.productDtl.model.vo.ProductDtl;

/**
 * Servlet implementation class SubCtgrSearchServlet
 */
@WebServlet(name = "SubCtgrSearch", urlPatterns = { "/subCtgrSearch" })
public class SubCtgrSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubCtgrSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String subCtgr = request.getParameter("subCtgr");
		String gender = request.getParameter("gender");
		ProductLeeService service = new ProductLeeService();
		String ctgr = request.getParameter("ctgr");
		
		int reqPage;
		
		try {
		reqPage = Integer.parseInt(request.getParameter("reqPage"));
		}catch(NumberFormatException e) {
			reqPage = 1;
		}
		PageDataLee pd = service.subCtgrSearch(reqPage,subCtgr,gender);
		ArrayList<ProductDtl> prdDtllist = service.searchColor();

		ArrayList<String> subCtgrList = service.subCtgr(ctgr,gender);

		ArrayList<Integer> subCtgrCount = service.subCtgrCount(ctgr, subCtgrList);
		request.setAttribute("count", subCtgrCount);
		request.setAttribute("subList", pd.getLists());
		request.setAttribute("pageNavi", pd.getPageNavi());
		request.setAttribute("prdDtl", prdDtllist);
		request.setAttribute("subCtgrList", subCtgrList);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/prdPage/subCtgrSearch.jsp");
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
