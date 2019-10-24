package kr.magasin.board.controller.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AWriteServlet
 */
@WebServlet(name = "AWrite", urlPatterns = { "/aWrite" })
public class AWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String ctgr = request.getParameter("ctgr");
		if(ctgr.equals("etc")) {
			int qEtcNo = Integer.parseInt(request.getParameter("qNo"));
			request.setAttribute("qNo", qEtcNo);
			System.out.println(qEtcNo);
			request.setAttribute("ctgr", ctgr);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/qna/aWriteTest.jsp");
			rd.forward(request, response);
				
		}else if(ctgr.equals("prd")){
			int qPrdNo = Integer.parseInt(request.getParameter("qNo"));
			request.setAttribute("qNo", qPrdNo);
			System.out.println(qPrdNo);
			request.setAttribute("ctgr", ctgr);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/qna/aWriteTest.jsp");
			rd.forward(request, response);
				
		}
			
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
