package kr.magasin.board.controller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.board.model.service.NoticeService;
import kr.magasin.board.model.vo.Notice;

/**
 * Servlet implementation class NoticeInsertServlet
 */
@WebServlet(name = "NoticeInsert", urlPatterns = { "/noticeInsert" })
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeWriter = request.getParameter("noticeWriter");
		String noticeCont = request.getParameter("noticeContent");
		
		NoticeService service = new NoticeService();
		Notice n = new Notice(0, noticeTitle, noticeWriter, noticeCont, null, 0, null, null);
		int result  = service.noticeInsert(n);
		
		response.sendRedirect("/noticeList");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
