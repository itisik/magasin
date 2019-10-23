package kr.magasin.board.controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.magasin.board.model.vo.Review;
import kr.magasin.member.model.vo.Member;

/**
 * Servlet implementation class ReviewWriteServlet
 */
@WebServlet(name = "ReviewWrite", urlPatterns = { "/reviewWrite" })
public class ReviewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		if(m!= null) {
			// test용 임시
			String prdName= "짜증나는자켓";
			String prdSnImg = "121912b148a317da45f35c16cf99ddf4.jpg";
			request.setAttribute("prdName", prdName);
			request.setAttribute("prdSnImg", prdSnImg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/review/reviewWriteTest.jsp");
			rd.forward(request, response);
			
		}else {
			response.sendRedirect("/views/member/login.jsp");
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
