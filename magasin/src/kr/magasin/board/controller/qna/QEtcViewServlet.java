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

/**
 * Servlet implementation class QEtcViewServlet
 */
@WebServlet(name = "QEtcView", urlPatterns = { "/qEtcView" })
public class QEtcViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QEtcViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
//		qNo 받아오기
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		String id=  request.getParameter("id");
		QnAService service = new QnAService();
		QEtc q = service.qEtcOne(qNo);
		if(q!=null && (q.getqWriter().equals(id)||id.equals("admin"))){
			request.setAttribute("qEtc", q);
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/views/board/qna/qView1Test.jsp");
			rd.forward(request, response);
				
		}else {
			request.setAttribute("msg", "접근권한이 없습니다.");
			request.setAttribute("loc", "/qnaList");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
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
