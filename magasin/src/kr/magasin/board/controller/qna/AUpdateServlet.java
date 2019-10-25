package kr.magasin.board.controller.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.board.model.service.QnAService;
import kr.magasin.board.model.vo.AEtc;
import kr.magasin.board.model.vo.APrd;

/**
 * Servlet implementation class AUpdateServlet
 */
@WebServlet(name = "AUpdate", urlPatterns = { "/aUpdate" })
public class AUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String ctgr = request.getParameter("ctgr");
		int aNo = Integer.parseInt(request.getParameter("aNo"));
		QnAService service = new QnAService();
		if(ctgr.equals("etc")) {
			AEtc a = service.aEtcOne(aNo);
			request.setAttribute("a", a);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/qna/aEtcUpdate.jsp");
			rd.forward(request, response);
		}else if(ctgr.equals("prd")) {
			APrd a = service.aPrdOne(aNo);
			request.setAttribute("a", a);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/qna/aPrdUpdate.jsp");
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
