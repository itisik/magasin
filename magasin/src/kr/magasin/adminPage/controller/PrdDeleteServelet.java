package kr.magasin.adminPage.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.magasin.product.model.service.ProductService;

/**
 * Servlet implementation class PrdDeleteServelet
 */
@WebServlet(name = "PrdDelete", urlPatterns = { "/prdDelete" })
public class PrdDeleteServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrdDeleteServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prdId = Integer.parseInt(request.getParameter("prdId"));
		String prdSnImgpath = request.getParameter("prdSnImgpath");
		String prdFilepath = request.getParameter("prdFilepath");
		
		
		ProductService service = new ProductService();
		int result = service.delete(prdId);
		
		
		if(result>0){
			if(prdSnImgpath !=null && prdFilepath!=null){
				String saveDirectory = getServletContext().getRealPath("/upload/photo");
				File defFile = new File(saveDirectory+prdSnImgpath+prdFilepath);
			}
			request.setAttribute("msg", "상품삭제 완료");
			request.setAttribute("loc", "/");
			
		}else{
			request.setAttribute("msg", "상품삭제 실패");
			request.setAttribute("loc", "/");
		}
		 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
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
