package kr.magasin.board.controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.board.model.service.ReviewService;
import kr.magasin.board.model.vo.PageData;

/**
 * Servlet implementation class ReviewListServlet
 */
@WebServlet(name = "ReviewList", urlPatterns = { "/reviewList" })
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		int reqPage;
		try {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
			
		}catch(NumberFormatException e){
			reqPage = 1;
			
		}
		ReviewService service = new ReviewService();
		PageData pd  = service.reviewList(reqPage);
		request.setAttribute("reviewList", pd.getReviewList());
		request.setAttribute("pageNavi", pd.getPageNavi());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/review/reviewListTest.jsp");
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
