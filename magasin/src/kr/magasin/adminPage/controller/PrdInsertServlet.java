package kr.magasin.adminPage.controller;

import java.io.IOException;
import java.util.ArrayList;

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


@WebServlet(name = "PrdInsert", urlPatterns = { "/prdInsert" })
public class PrdInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PrdInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. PRD 등록 2. PRD ID체크  3. PRD_DTL 등록 서비스보내서 한번에 처리!!!
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
		
		System.out.println("fileName : " +prdSnImgname);
		System.out.println("filePath : " + prdSnImgpath);
		Product p = new Product(0, prdName, prdGender, prdCtgr, prdSubCtrg, prdPrice, null, prdSnImgname, prdSnImgpath, prdImgname, prdImgpath);
		
		
		//1. prd 등록
		
		int length1 = Integer.parseInt(mRequest.getParameter("length1"));
		int length2 = Integer.parseInt(mRequest.getParameter("length2"));
		int totalLength = length1*length2;
		ArrayList<ProductDtl> list = new ArrayList<ProductDtl>();
		
		
		System.out.println(length1);
		System.out.println(length2);
		System.out.println(totalLength);
		System.out.println("구분하기 :length 값은 정상적으로 다 들어옴 ㅇㅋ");
		
		String [] size = new String[totalLength];
		String [] color = new String[totalLength];
		int [] count = new int[totalLength];
		//int count = size.length*color.length;
		
		
		System.out.println(mRequest.getParameter("count1"));
		for(int i=0; i<totalLength; i++){
			System.out.println(i+" : 번째");
			String sizee = "sizee"+i;
			size[i] = mRequest.getParameter(sizee);
			System.out.println(size[i]);
			String colorr = "colorr"+i;
			color[i] = mRequest.getParameter(colorr);
			System.out.println(color[i]);
			String countt = "count"+i;
			count[i] =  Integer.parseInt(mRequest.getParameter(countt));
			System.out.println(count[i]);
			ProductDtl pdtl = new ProductDtl(0, 0, count[i], size[i], color[i]);
			list.add(pdtl);
			
		}
//		for(int i=0; i<length1; i++){
//			String sizee = "sizee"+i;
//			size[i] = mRequest.getParameter(sizee);
//			for(int j=0; j<length2; j++){
//				String colorr = "colorr"+i;
//				color[i] = mRequest.getParameter(colorr);
//				String countt = "count"+i;
//				count[i] =  Integer.parseInt(mRequest.getParameter(countt));
//				ProductDtl pdtl = new ProductDtl(0, 0, count[i], size[i], color[i]);
//				list.add(pdtl);
//			}
//		}
//		for(int i=0; i<totalLength; i++){
//			size[i] = mRequest.getParameter("sizee"+i);
//			System.out.println(size[i]);
//			color[i] = mRequest.getParameter("colorr"+i);
//			System.out.println(color[i]);
//			count[i] =  Integer.parseInt(mRequest.getParameter("count"+i));
//			System.out.println(count[i]);
//			//2. PRD ID체크 
//			ProductDtl pdtl = new ProductDtl(0, 0, count[i], size[i], color[i]);
//			list.add(pdtl);
//		}
		ProductService pservice = new ProductService();
		int result = pservice.productInsert(p,list);
		//3. PRD_dtl 등록
		if(result>=1){
			 request.setAttribute("msg", "상품등록 성공");
		}else{
			request.setAttribute("msg", "상품등록 실패");
		}
		request.setAttribute("loc", "/");
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
	    rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
