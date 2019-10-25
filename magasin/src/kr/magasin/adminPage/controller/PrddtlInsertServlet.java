package kr.magasin.adminPage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.magasin.product.model.service.ProductService;
import kr.magasin.product.model.vo.Product;
import kr.magasin.productDtl.model.vo.ProductDtl;

/**
 * Servlet implementation class PrddtlInsertServlet
 */
@WebServlet(name = "PrddtlInsert", urlPatterns = { "/prddtlInsert" })
public class PrddtlInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrddtlInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(!ServletFileUpload.isMultipartContent(request)){
			request.setAttribute("msg", "[enctype]ddd");
			request.setAttribute("loc", "/");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/photo";
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		String prdName = mRequest.getParameter("prdName");
		String prdGender = mRequest.getParameter("prdGender");
		String prdCtgr = mRequest.getParameter("prdCtgr");
		String prdSubCtrg = mRequest.getParameter("prdSubCtrg");
		int prdPrice = Integer.parseInt(mRequest.getParameter("prdPrice"));
		String prdSnImgname =  mRequest.getOriginalFileName("prdSnImgname");
		String prdSnImgpath = mRequest.getFilesystemName("prdSnImgname");
		String prdImgname =  mRequest.getOriginalFileName("prdImgname");
		String prdImgpath = mRequest.getFilesystemName("prdImgname");
		
	
		Product p = new Product(0, prdName, prdGender, prdCtgr, prdSubCtrg, prdPrice, null, prdSnImgname, prdSnImgpath, prdImgname, prdImgpath);
		
		
		String prdDtlColor = mRequest.getParameter("prdDtlColor");
		String prdDtlSize = mRequest.getParameter("prdDtlSize");
		int prdDtlCount = Integer.parseInt(mRequest.getParameter("prdDtlCount"));
		ProductDtl pdtl = new ProductDtl(0, 0, prdDtlCount, prdDtlSize, prdDtlColor);
		
		ProductService pservice = new ProductService();
		int result = pservice.insertProductdtl(p, pdtl);
		if(result>=0){
			System.out.println(result);
			 request.setAttribute("msg", "상품상세등록 성공");
		}else{
			request.setAttribute("msg", "상품상세등록 실패");
		}
		request.setAttribute("loc", "/");
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
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
