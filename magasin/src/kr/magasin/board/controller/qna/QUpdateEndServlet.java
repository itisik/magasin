package kr.magasin.board.controller.qna;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.board.model.service.QnAService;
import kr.magasin.board.model.vo.QEtc;
import kr.magasin.board.model.vo.QPrd;

/**
 * Servlet implementation class QUpdateEndServlet
 */
@WebServlet(name = "QUpdateEnd", urlPatterns = { "/qUpdateEnd" })
public class QUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QUpdateEndServlet() {
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
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		String qTitle = request.getParameter("qTitle");
		String qWriter = request.getParameter("qWriter");
		String qCont = request.getParameter("qContent");
		String qCtgr = request.getParameter("qCtgr");
		QnAService service = new  QnAService();
		if(ctgr.equals("etc")) {
			QEtc q = new QEtc(qNo, qCtgr, qTitle, qWriter, qCont, null, 0, null, null); 
			int result = service.qEtcUpdate(q);
			if(result>0) {
				System.out.println("수정 완료");
				response.sendRedirect("/qnaList");
			}
			
		}else if(ctgr.equals("prd")) {
			QPrd q = new QPrd(qNo, qCtgr, qTitle, qWriter, qCont, null, 0, null, null, null, null);
			int result = service.qPrdUpdate(q);
			if(result>0) {
				response.sendRedirect("/qnaList");
			}
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
