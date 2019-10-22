package kr.magasin.member.controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.member.model.service.MemberService;
import kr.magasin.member.model.vo.Member;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet(name = "Update", urlPatterns = { "/update" })
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.문자인코딩
<<<<<<< HEAD
=======
		System.out.println("오긴옴");
>>>>>>> upstream/master
		request.setCharacterEncoding("UTF-8");
		//2. 변수 저장
		String id = request.getParameter("id");
		//3.비지니스 로직
		MemberService service = new MemberService();
		Member m = service.selectOne(id);
		//4. 뷰
		if(m != null) {
			request.setAttribute("member", m);
		
			
		 String phoneStr = m.getPhone(); 

		 String[] phoneArr = new String[3];
			 phoneArr[0] = phoneStr.substring(0,3); 
			 phoneArr[1] = phoneStr.substring(3,7); 
			 phoneArr[2] = phoneStr.substring(7); 

			String addrStr = m.getAddr();
			
			String[] addrList = new String[4];
			StringTokenizer str = new StringTokenizer(addrStr,",");
			int countTokens = str.countTokens();
			for(int i = 0;i<countTokens;i++) {
				addrList[i] = str.nextToken();
			}
		
			String emailStr = m.getEmail();
			String[] emailList = new String[2];
			StringTokenizer str1 = new StringTokenizer(emailStr,"@");
			int countTokens1 = str1.countTokens();
			for(int i=0;i<countTokens1;i++) {
				emailList[i] = str1.nextToken();
			}
			
			request.setAttribute("phoneArr", phoneArr);
			request.setAttribute("addrList", addrList);
			request.setAttribute("emailList", emailList);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/myPage/myInfoUpdate.jsp");
			//이동할페이지 
			rd.forward(request, response);
		}else {
			response.sendRedirect("/");
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
