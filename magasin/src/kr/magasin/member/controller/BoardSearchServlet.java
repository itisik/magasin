package kr.magasin.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.board.model.service.NoticeService;
import kr.magasin.board.model.service.QnAService;
import kr.magasin.board.model.service.ReviewService;
import kr.magasin.board.model.vo.AEtc;
import kr.magasin.board.model.vo.PageData;
import kr.magasin.board.model.vo.QEtc;
import kr.magasin.board.model.vo.QPrd;
import kr.magasin.board.model.vo.Review;

/**
 * Servlet implementation class BoardSearchServlet
 */
@WebServlet(name = "BoardSearch", urlPatterns = { "/boardSearch" })
public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String memberId= request.getParameter("memberId");
		ReviewService service1 = new ReviewService();
		QnAService service2 = new QnAService();
		ArrayList<Review> reviewList = service1.searchReview(memberId);
		PageData board = service2.searchBoard(memberId);
		request.setAttribute("qEtc", board.getqEtcList());
		request.setAttribute("qPrd", board.getqPrdList());
		request.setAttribute("aEtc", board.getaEtcList());
		request.setAttribute("aPrd", board.getaPrdList());
		request.setAttribute("rBoard", reviewList);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/myPage/myBoard.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
