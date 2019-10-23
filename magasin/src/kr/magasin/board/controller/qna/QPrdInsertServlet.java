package kr.magasin.board.controller.qna;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.board.model.service.QnAService;
import kr.magasin.board.model.vo.QPrd;

/**
 * Servlet implementation class QPrdInsertServlet
 */
@WebServlet(name = "QPrdInsert", urlPatterns = { "/qPrdInsert" })
public class QPrdInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QPrdInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String qWriter=request.getParameter("qWriter");
		String qCtgr = request.getParameter("qCtgr");
		String qTitle = request.getParameter("qTitle");
		String qCont = request.getParameter("qContent");
		String prdName = request.getParameter("prdName");
		String prdSnImg = request.getParameter("prdSnImg");
		
		QPrd q = new QPrd(0, qCtgr, qTitle, qWriter, qCont, null, 0, null, null, prdName, prdSnImg);
		QnAService service = new QnAService();
		int result = service.qPrdInsert(q);
		if(result>0) {
			System.out.println("등록성공");
			
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
