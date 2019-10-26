package kr.magasin.board.controller.qna;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.board.model.service.QnAService;
import kr.magasin.board.model.vo.AEtc;
import kr.magasin.board.model.vo.APrd;

/**
 * Servlet implementation class AUpdateEndServlet
 */
@WebServlet(name = "AUpdateEnd", urlPatterns = { "/aUpdateEnd" })
public class AUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AUpdateEndServlet() {
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
		String aTitle = request.getParameter("aTitle");
		String aCont = request.getParameter("aContent");
		QnAService service = new QnAService();
		if(ctgr.equals("etc")) {
			AEtc a = new AEtc(aNo, 0, aTitle, aCont, null);
			int result = service.aEtcUpdate(a);
			if(result>0) {
				response.sendRedirect("/qnaList");
			}
		}else if(ctgr.equals("prd")) {
			APrd a = new APrd(aNo, 0, aTitle, aCont, null);
			int result = service.aPrdUpdate(a);
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
