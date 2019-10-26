package kr.magasin.board.controller.review;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.board.model.service.ReviewService;

/**
 * Servlet implementation class ReviewDeleteServlet
 */
@WebServlet(name = "ReviewDelete", urlPatterns = { "/reviewDelete" })
public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		String reviewFilepath1 = request.getParameter("reviewFilepath1");
		String reviewFilepath2 = request.getParameter("reviewFilepath2");
		
		ReviewService service = new ReviewService();
		int result = service.reviewDelete(reviewNo);
		if(result>0) {
			if(reviewFilepath1!=null) {
				String saveDirectory = getServletContext().getRealPath("/img/review_upload/");
				File delFile = new File(saveDirectory+reviewFilepath1);
				if(delFile.exists()) {
					delFile.delete();
				}else {
					System.out.println("파일 없음1");
				}
			}
			if(reviewFilepath2!=null) {
				String saveDirectory = getServletContext().getRealPath("/img/review_upload/");
				File delFile = new File(saveDirectory+reviewFilepath2);
				if(delFile.exists()) {
					delFile.delete();
				}else {
					System.out.println("파일 없음2");
				}
			}
		}
		response.sendRedirect("/reviewList");
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
