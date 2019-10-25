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
import kr.magasin.board.model.vo.QEtc;

/**
 * Servlet implementation class AInsertServlet
 */
@WebServlet(name = "AInsert", urlPatterns = { "/aInsert" })
public class AInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AInsertServlet() {
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
		String aTitle = request.getParameter("aTitle");
		int qNoRef = Integer.parseInt(request.getParameter("qNoRef"));
		String aCont = request.getParameter("aContent");
		
		QnAService service = new QnAService();
		if(ctgr.equals("etc")) {
			
			AEtc a = new AEtc(0, qNoRef, aTitle, aCont, null);
			int result = service.aEtcInsert(a);
			if(result>0) {
				response.sendRedirect("/qnaList");
				/*request.setAttribute("a", a);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/qna/aViewTest.jsp");
				rd.forward(request, response);*/
			}
			return;
		}else if(ctgr.equals("prd")) {
			
			APrd a = new APrd(0, qNoRef, aTitle, aCont, null);
			int result = service.aPrdInsert(a);
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
