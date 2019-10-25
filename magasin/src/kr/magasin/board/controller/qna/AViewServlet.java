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
import kr.magasin.board.model.vo.QPrd;

/**
 * Servlet implementation class AViewServlet
 */
@WebServlet(name = "AView", urlPatterns = { "/aView" })
public class AViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String ctgr = request.getParameter("ctgr");
		int aNo = Integer.parseInt(request.getParameter("aNo"));
		String id = request.getParameter("id");
		QnAService service = new QnAService();
		
		if(ctgr.equals("etc")) {
			AEtc a = service.aEtcOne(aNo);
			QEtc q = service.qEtcOne(a.getaQEtcNoRef());
			
			if(a!=null && id!=null && (q.getqWriter().equals(id)||id.equals("admin"))){
				request.setAttribute("a", a);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/qna/aEtcView.jsp");
				rd.forward(request, response);
			}else if(id==null){
				response.sendRedirect("/views/member/login.jsp");
			}else {
				request.setAttribute("msg", "접근권한이 없습니다.");
				request.setAttribute("loc", "/qnaList");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				rd.forward(request, response);
			}
			
		}else if(ctgr.equals("prd")) {
			APrd a = service.aPrdOne(aNo);
			QPrd q =  service.qPrdOne(a.getaQPrdNoRef());
			if(a!=null && id!=null && (q.getqWriter().equals(id)||id.equals("admin"))){
				request.setAttribute("a", a);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/qna/aPrdView.jsp");
				rd.forward(request, response);
			}else if(id==null){
				response.sendRedirect("/views/member/login.jsp");
			}else {
				request.setAttribute("msg", "접근권한이 없습니다.");
				request.setAttribute("loc", "/qnaList");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				rd.forward(request, response);
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
