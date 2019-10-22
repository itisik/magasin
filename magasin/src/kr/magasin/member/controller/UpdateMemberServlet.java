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
import kr.magasin.member.model.vo.Member;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet(name = "UpdateMember", urlPatterns = { "/updateMember" })
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] addrList = new String[4];
		String[] phoneList = new String[3];
		String[] emailList = new String[2];
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		addrList[0] = request.getParameter("addrList0");
		addrList[1] = request.getParameter("addrList1");
		addrList[2] = request.getParameter("addrList2");
		addrList[3] = request.getParameter("addrList3");
		 
		phoneList[0] = request.getParameter("phoneArr0");
		phoneList[1] = request.getParameter("phoneArr1");
		phoneList[2] = request.getParameter("phoneArr2");
		String phone  = phoneList[0]+phoneList[1]+phoneList[2];
		emailList[0] = request.getParameter("emailList0");
		emailList[1] = request.getParameter("emailList1");
	
		String email = emailList[0]+"@"+emailList[1];
		
		String addr = addrList[0]+","+addrList[1]+","+addrList[2]+","+addrList[3];
		//String addr = (String)request.getAttribute("addr");
		//
		
		

		
		Member member = new Member(id, pw, name, addr, phone, 0, null, null, email, null);
		System.out.println("member아이디"+id);
		System.out.println(phone);
		System.out.println(addr);
		System.out.println(email);
		MemberService service = new MemberService();
		int result = service.updateMember(member);
		
		if(result>0) {
			
			Member m = service.selectOne(id);			
			HttpSession session = request.getSession(false);
			session.setAttribute("member", m);			
			request.setAttribute("member", m);
		
			response.sendRedirect("/update?id="+id);
			request.setAttribute("msg", "회원정보 변경 성공");
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/myPage/myInfoUpdate.jsp");
			request.setAttribute("msg", "회원정보 변경 실패");
			request.setAttribute("loc", "/myInfoUpdate?id="+id);
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
