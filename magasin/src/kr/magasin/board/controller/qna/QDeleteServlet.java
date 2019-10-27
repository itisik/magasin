package kr.magasin.board.controller.qna;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.board.model.service.QnAService;

/**
 * Servlet implementation class QDeleteServlet
 */
@WebServlet(name = "QDelete", urlPatterns = { "/qDelete" })
public class QDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String ctgr = request.getParameter("ctgr");
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		QnAService service =new QnAService();
		if(ctgr.equals("etc")) {
			int result = service.qEtcDelete(qNo);
			if(result>0) {
				// 모달
				System.out.println("etc 삭제성공1");
			}
		}else if(ctgr.equals("prd")) {
			int result = service.qPrdDelete(qNo);
			if(result>0) {
				System.out.println("prd 삭제 성공2");
			}
			
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
