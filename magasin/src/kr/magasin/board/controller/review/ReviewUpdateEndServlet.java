package kr.magasin.board.controller.review;

import java.io.File;
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
 * Servlet implementation class ReviewUpdateEndServlet
 */
@WebServlet(name = "ReviewUpdateEnd", urlPatterns = { "/reviewUpdateEnd" })
public class ReviewUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		if(!ServletFileUpload.isMultipartContent(request)) {
			response.sendRedirect("/");
			return;
		}
		String saveDirectory = getServletContext().getRealPath("/")+"img/review_upload";
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory,maxSize, "utf-8",new DefaultFileRenamePolicy());
		String reviewTitle = mRequest.getParameter("reviewTitle");
		int reviewNo = Integer.parseInt(mRequest.getParameter("reviewNo"));
		String reviewWriter = mRequest.getParameter("reviewWriter");
		int reviewPoint = Integer.parseInt(mRequest.getParameter("reviewPoint"));
		System.out.println(reviewPoint);
		String reviewCont = mRequest.getParameter("reviewContent");
		String prdName = mRequest.getParameter("prdName");
		String prdSnImg = mRequest.getParameter("prdSnImg");
		

		String filename1 = mRequest.getOriginalFileName("filename1");
		String filepath1 = mRequest.getFilesystemName("filename1");
		String filename2 = mRequest.getOriginalFileName("filename2");
		String filepath2 = mRequest.getFilesystemName("filename2");
				
		String status1 = mRequest.getParameter("status1");
		String status2 = mRequest.getParameter("status2");
		String oldFilename1 = mRequest.getParameter("oldFilename1");
		String oldFilepath1 = mRequest.getParameter("oldFilepath1");
		String oldFilename2 = mRequest.getParameter("oldFilename2");
		String oldFilepath2 = mRequest.getParameter("oldFilepath2");
		if(filename1!=null) {
			if(oldFilename1 !=null) {
				File delFile = new File(saveDirectory+"/"+oldFilepath1);
				System.out.println(delFile.delete()?"성공":"실패");
			}
		}
		if(filename2!=null) {
			if(oldFilename2!=null){
				File delFile = new File(saveDirectory+"/"+oldFilepath2);
				System.out.println(delFile.delete()?"성공":"실패");
			}
			
		}else {
			if(status1.equals("stay")) {
				filename1 = oldFilename1;
				filepath1 = oldFilepath2;
			}else if(status1.equals("delete")) {
				File delFile = new File(saveDirectory+"/"+oldFilepath1);
				System.out.println(delFile.delete()?"파일1 성공":"파일1 실패");
			}
			if(status2.equals("stay")) {
				filename2 = oldFilename2;
				filepath2 = oldFilepath2;
			}else if(status2.equals("delete")) {
				File delFile = new File(saveDirectory+"/"+oldFilepath2);
				System.out.println(delFile.delete()?"파일2 삭제 성공":"파일2 삭제 실패");
			}
		}
		Review r = new Review(reviewNo, reviewWriter, reviewTitle, reviewPoint, reviewCont, null, 0, filename1, filepath1, filename2, filepath2, prdName, prdSnImg);
		ReviewService service = new ReviewService();
		int result = service.reviewUpdate(r);
		if(result>0) {
			System.out.println("수정 성공");	
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
