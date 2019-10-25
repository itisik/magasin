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
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		//3. 비지니스 로직처리
		MemberService service = new MemberService();
		Member m1 = service.searchId(name,email);
		Member m2 = service.searchId2(name, phone);
		
		//-----------하는중-----------
		//4. view 처리
		if(m1==null) {
			request.setAttribute("result", true);
		}else {
			request.setAttribute("result", false);
		}
		request.setAttribute("email", email);
		
		if(m2==null) { 
			request.setAttribute("result", true);
		}else {
			request.setAttribute("result", false);
		}
		request.setAttribute("phone", phone);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/searchId.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("/WEB-INF/views/member/searchPw.jsp");
		rd.forward(request, response);
		rd2.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
