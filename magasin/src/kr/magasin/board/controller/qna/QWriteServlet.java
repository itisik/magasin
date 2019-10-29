package kr.magasin.board.controller.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.magasin.member.model.vo.Member;

/**
 * Servlet implementation class QWriteServlet
 */
@WebServlet(name = "QWrite", urlPatterns = { "/qWrite" })
public class QWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	/*
		String prdName = request.getParameter("prdName");
		String prdSnImg = request.getParameter("prdSnImg");*/
		
		//임시

		String prdName = request.getParameter("prdName");
		String prdSnImg = request.getParameter("prdSnImg");
		if(prdName==null&&prdSnImg==null) {
			response.sendRedirect("/qnaList");
		}else {
			request.setAttribute("prdName", prdName);
			request.setAttribute("prdSnImg", prdSnImg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/qna/qWrite2Test.jsp");
			rd.forward(request, response);
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
