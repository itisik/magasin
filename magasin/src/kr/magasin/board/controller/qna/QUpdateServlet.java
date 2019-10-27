package kr.magasin.board.controller.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.board.model.service.QnAService;
import kr.magasin.board.model.vo.QEtc;
import kr.magasin.board.model.vo.QPrd;

/**
 * Servlet implementation class QUpdateServlet
 */
@WebServlet(name = "QUpdate", urlPatterns = { "/qUpdate" })
public class QUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String ctgr= request.getParameter("ctgr");
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		QnAService service = new QnAService();
		if(ctgr.equals("etc")) {
			QEtc q = service.qEtcOne(qNo);
			request.setAttribute("q",q);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/qna/qUpdate1Test.jsp");
			rd.forward(request, response);
		}else if(ctgr.equals("prd")) {
			QPrd q = service.qPrdOne(qNo);
			request.setAttribute("q",q);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/qna/qUpdate2Test.jsp");
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
