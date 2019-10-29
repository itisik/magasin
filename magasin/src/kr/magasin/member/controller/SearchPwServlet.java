package kr.magasin.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.member.model.service.MemberService;
import kr.magasin.member.model.vo.Member;

/**
 * Servlet implementation class SearchPwServlet
 */
@WebServlet(name = "SearchPw", urlPatterns = { "/searchPw" })
public class SearchPwServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1. 인코딩
      request.setCharacterEncoding("utf-8");
      //2. 변수저장
      //String memberId = request.getParameter("checkId"); //checkId속성 가져오기
      String name = request.getParameter("name");
      String id = request.getParameter("id");
      String email = request.getParameter("email");
      String phone = request.getParameter("phone");
      //3. 비지니스 로직처리
      MemberService service = new MemberService();
      Member m = service.searchPw(name,id,email);
      if(m == null){
         m = service.searchPw2(name,id,phone);
      }
      
      //4. view 처리
      if(m!=null) { //pw값 있을 때
         request.setAttribute("member", m); //findPwSuccess.jsp에서 사용해야되니까 set    //(key,value)
         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/findPwSuccess.jsp");
         rd.forward(request, response);
      }else { //없을때는 '해당하는 정보가 없습니다. 이름,아이디,이메일/전화번호를 확인해주세요.'띄우기 
         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
         request.setAttribute("msg", "해당하는 정보가 없습니다. 이름,아이디,이메일/전화번호를 확인해주세요.");
         request.setAttribute("loc", "/views/member/searchPw.jsp"); //비번찾기 실패하면 비번찾기 페이지 다시 뜨게하기
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
