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
 * Servlet implementation class SearchIdServlet
 */
@WebServlet(name = "SearchId", urlPatterns = { "/searchId" })
public class SearchIdServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //1. 인코딩
            request.setCharacterEncoding("utf-8");
            //2. 변수저장
            String name = request.getParameter("name");  //name속성 가져오기
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            //3. 비지니스 로직처리
            MemberService service = new MemberService();
            Member m = service.searchId(name,email);
            if(m == null){
               m = service.searchId2(name,phone);
            }
            
            
            //4. view 처리
            if(m!=null) { //id값 있을 때
               request.setAttribute("member", m); //findIdSuccess.jsp에서 사용해야되니까 set    //(key,value)
               RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/findIdSuccess.jsp");
               rd.forward(request, response);
            }else { //없을때는 '해당하는 아이디가 없습니다. 이름 이메일/전화번호를 확인해주세요.'띄우기 
               RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
               request.setAttribute("msg", "해당하는 아이디가 없습니다. 이름,이메일/전화번호를 확인해주세요.");
               request.setAttribute("loc", "/views/member/searchId.jsp"); //회원가입 실패하면 회원가입하던 페이지 다시 뜨게하기
               rd.forward(request, response);
            }
            
            
            /*
            if(m2!=null) { //id값 있을 때
               request.setAttribute("m2", m2); //idFindSuccess.jsp에서 사용해야되니까 set    //(key,value)
               RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/findIdSuccess.jsp");
               rd.forward(request, response);
            }else { //없을때는 '해당하는 아이디가 없습니다. 이름 이메일을 확인해주세요.'띄우기 
               request.setAttribute("result", false);
               RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
               request.setAttribute("msg", "해당하는 아이디가 없습니다. 이름,전화번호를 확인해주세요.");
               request.setAttribute("loc", "/views/member/searchId.jsp"); //회원가입 실패하면 회원가입하던 페이지 다시 뜨게하기
               rd.forward(request, response);
            }*/
   }

}
