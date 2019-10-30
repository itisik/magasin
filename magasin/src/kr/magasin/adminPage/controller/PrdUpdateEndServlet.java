package kr.magasin.adminPage.controller;

import java.io.IOException;
import java.io.File;
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


/**
 * Servlet implementation class PrdUpdateEndServlet
 */
@WebServlet(name = "PrdUpdateEnd", urlPatterns = { "/prdUpdateEnd" })
public class PrdUpdateEndServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrdUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      if(!ServletFileUpload.isMultipartContent(request)){
         request.setAttribute("msg", "[enctype]확인");
         request.setAttribute("loc", "/");
         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
         rd.forward(request, response);
         return;
      }
      String root = getServletContext().getRealPath("/");
      String saveDirectory = root + "upload/photo";
      int maxSize = 10*1024*1024;
      MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
      int prdId = Integer.parseInt(mRequest.getParameter("prdId"));
      String prdName = mRequest.getParameter("prdName");
      String prdSnImgname = mRequest.getOriginalFileName("prdSnImgname");
      String prdSnImgpath = mRequest.getFilesystemName("prdSnImgname");
      String prdFilename =  mRequest.getOriginalFileName("prdFilename");
      String prdFilepath = mRequest.getFilesystemName("prdFilename");
      int prdPrice = Integer.parseInt(mRequest.getParameter("prdPrice"));
      
      //파일 삭제 여부 확인
      String psimgstatus2 = mRequest.getParameter("psimgstatus2");
      String pimgstatus = mRequest.getParameter("pimgstatus");
      String oldFilename2 = mRequest.getParameter("oldFilename2");
      String oldFilepath2 = mRequest.getParameter("oldFilepath2");
      String oldFilename = mRequest.getParameter("oldFilename");
      String oldFilepath = mRequest.getParameter("oldFilepath");
      
      if(prdSnImgname!=null) {
         if(oldFilename2 !=null) {
            File delFile2 = new File(saveDirectory+"/"+oldFilepath2);
            System.out.println(delFile2.delete()?"성공":"실패");
         }
      }else if(prdFilename!=null) {
         if(oldFilename2!=null){
            File delFile = new File(saveDirectory+"/"+oldFilepath);
            System.out.println(delFile.delete()?"성공":"실패");
         }

      }else {
         if(psimgstatus2.equals("stay")) {
            prdSnImgname=oldFilename2;
            prdSnImgpath=oldFilepath2;
         }else if(psimgstatus2.equals("delete")) {
            File delFile2 = new File(saveDirectory+"/"+oldFilepath2);
            System.out.println(delFile2.delete()?"파일1 성공":"파일1 실패");
         }
         if(pimgstatus.equals("stay")) {
            prdFilename=oldFilename;
            prdFilepath=oldFilepath;
         }else if(pimgstatus.equals("delete")) {
            File delFile = new File(saveDirectory+"/"+oldFilepath2);
            System.out.println(delFile.delete()?"파일2 삭제 성공":"파일2 삭제 실패");
         }
      }
      Product p = new Product(prdId, prdName, null, null, null, prdPrice, null, prdSnImgname, prdSnImgpath, prdFilename, prdFilepath);
      ProductService pservice = new ProductService();
      
      int result = pservice.updateProduct(p);
      if(result>0){
         request.setAttribute("msg", "상품 수정 성공");
      }else {
         request.setAttribute("msg", "상품 수정 실패");
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