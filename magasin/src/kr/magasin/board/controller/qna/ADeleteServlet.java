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
 * Servlet implementation class ADeleteServlet
 */
@WebServlet(name = "ADelete", urlPatterns = { "/aDelete" })
public class ADeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADeleteServlet() {
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
		/*int qNo = Integer.parseInt(request.getParameter("qNo"));*/
		QnAService service = new QnAService();
		
		if(ctgr.equals("etc")) {
			int result = service.aEtcDelete(aNo);
			if(result>0) {
				System.out.println("aetc 삭제 성공");	
			}
		}else if(ctgr.equals("prd")) {
			int result = service.aPrdDelete(aNo);
			if(result>0) {
				System.out.println("aprd 삭제 성공");
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
