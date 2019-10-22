package kr.magasin.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.magasin.member.model.service.MemberService;

/**
 * Servlet implementation class DeleteMemberServlet
 */
@WebServlet(name = "DeleteMember", urlPatterns = { "/deleteMember" })
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 . 인코딩
	      request.setCharacterEncoding("utf-8");      
	      //2. 변수 선어
	      String id = request.getParameter("id");
	      System.out.println("DELETEMEMBER"+id);
	      //3. 비지니스 로직
	      MemberService service = new MemberService();
	      int result = service.delete(id);
	      //4. 뷰
	      if(result >0) {
	         HttpSession session = request.getSession(false);
	         //session은 로그인헀을 때 회원 정보가 담겨있는 부분
	         if(session != null) {
	            //session은 로그인 되어있을 경우 
	            session.invalidate();   //session.invalidate(); 로 로그아웃 
	         }
<<<<<<< HEAD
	         request.setAttribute("msg", "회원정보가 삭제가 정상적으로 처리 되었습니다.");
=======
	         request.setAttribute("msg", "회원정보 삭제 성공");
>>>>>>> upstream/master
	         //   - request : 하나의 요청에 대해서 정보를 공유하는 객체 /<form>태그로 데이터 전송 시 다음페이지에서 사용   
	      }else {
	         request.setAttribute("msg", "회원정보 삭제 실패");
	      }
	      request.setAttribute("loc", "/");
	      //이동하려는 로컬 호스트 
	      RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
	      //이동할 페이지를 지정한것 
	      rd.forward(request, response);
	      //현재 요청받은 걸 그쪽 페이지로 이동시키는거  
	      //request는 이동할 떄 정보, RequestDispatcher는 이동하려는 위치 
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
