package kr.magasin.board.controller.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.board.model.service.QnAService;
import kr.magasin.board.model.vo.QPrd;

/**
 * Servlet implementation class QPrdViewServlet
 */
@WebServlet(name = "QPrdView", urlPatterns = { "/qPrdView" })
public class QPrdViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QPrdViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		QnAService service = new QnAService();
		QPrd q = service.qPrdOne(qNo);
		if(q!=null) {
			request.setAttribute("qPrd", q);
			RequestDispatcher rd =  request.getRequestDispatcher("/WEB-INF/views/board/qna/qView2Test.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("/qnaList");
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
