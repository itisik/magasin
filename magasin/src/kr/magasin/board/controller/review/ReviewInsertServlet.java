package kr.magasin.board.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.magasin.board.model.service.ReviewService;
import kr.magasin.board.model.vo.Review;

/**
 * Servlet implementation class ReviewInsertServlet
 */
@WebServlet(name = "ReviewInsert", urlPatterns = { "/reviewInsert" })
public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(!ServletFileUpload.isMultipartContent(request)) {
			response.sendRedirect("/");
			return;
		}
		String saveDirectory = getServletContext().getRealPath("/")+"img/review_upload";
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory,maxSize, "utf-8",new DefaultFileRenamePolicy());
		String reviewTitle = mRequest.getParameter("reviewTitle");
		String reviewWriter = mRequest.getParameter("reviewWriter");
		int reviewPoint = Integer.parseInt(mRequest.getParameter("reviewPoint"));
		String reviewCont = mRequest.getParameter("reviewContent");
		String filename1 = mRequest.getOriginalFileName("filename1");
		String filepath1 = mRequest.getFilesystemName("filename1");
		String filename2 = mRequest.getOriginalFileName("filename2");
		String filepath2 = mRequest.getFilesystemName("filename2");
		String prdName = mRequest.getParameter("prdName");
		String prdSnImg = mRequest.getParameter("prdSnImg");
		
		Review r = new Review(0, reviewWriter, reviewTitle, reviewPoint, reviewCont, null, 0, filename1, filepath1, filename2, filepath2, prdName, prdSnImg);
		
		ReviewService service = new ReviewService();
		int result = service.reviewInsert(r);
		if(result>0) {
			System.out.println("등록 성공");
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
