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
 * Servlet implementation class JoinServlet
 */
@WebServlet(name = "Join", urlPatterns = { "/join" })
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 변수저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		int birthdate = Integer.parseInt(request.getParameter("birthdate"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(addr);
		System.out.println(phone);
		System.out.println(birthdate);
		System.out.println(gender);
		System.out.println(email);
		Member m =new Member(id, pw, name, addr, phone, birthdate, gender, null, email, null);
		
		
		//3. 비지니스로직
		
		/* DB에 gender 자동으로 'member'들어가게
		 * addr, birthdate, gender 안써도 회원가입되게. (birthdate안쓰면 가입이 안된다ㅠㅠ)
		 * 만들어주기*/
		//addr=null인 경우
		//birthdate=null인 경우
		//gender=null인 경우
		
		MemberService service = new MemberService();
		int result = service.insertMember(m);
		//4. view처리
		if(result>0) {
			request.setAttribute("member", m); //joinSuccess.jsp에서 사용해야되니까 set    //(key,value)
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/joinSuccess.jsp"); //회원가입 성공했을 때 회원가입이 완료되었습니다 라는 페이지 만들기
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "회원가입 실패");
			request.setAttribute("loc", "/views/member/join.jsp"); //회원가입 실패하면 회원가입하던 페이지 다시 뜨게하기
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