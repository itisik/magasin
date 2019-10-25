package kr.magasin.board.controller.qna;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.board.model.service.QnAService;
import kr.magasin.board.model.vo.QEtc;

/**
 * Servlet implementation class QEtcInsertServlet
 */
@WebServlet(name = "QEtcInsert", urlPatterns = { "/qEtcInsert" })
public class QEtcInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QEtcInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String qWriter = request.getParameter("qWriter");
		String qTitle = request.getParameter("qTitle");
		String qCont = request.getParameter("qContent");
		String qCtgr = request.getParameter("qCtgr");
		QnAService service = new  QnAService();
		QEtc q = new QEtc(0, qCtgr, qTitle, qWriter, qCont, null, 0, null, null) ;		
		int result = service.qEtcInsert(q);
		if(result>0) {
			System.out.println("등록 성공");
		}
		response.sendRedirect("/qnaList");
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
