package kr.magasin.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.magasin.member.model.service.MemberService;
import kr.magasin.member.model.vo.Member;
import kr.magasin.orderP.model.service.OrderPService;
import kr.magasin.orderP.model.vo.Order;
import kr.magasin.orderP.model.vo.OrderP2;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet(name = "Mypage", urlPatterns = { "/mypage" })
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//1.문자인코딩
	request.setCharacterEncoding("UTF-8");
	//2. 변수 저장
	String id = request.getParameter("id");
	//3.비지니스 로직
	MemberService service = new MemberService();
	Member m = service.selectOne(id);
	OrderPService service2 = new OrderPService();
	ArrayList<Order> list = service2.orderAll(id);
	
	//4. 뷰
	if(m != null) {
		request.setAttribute("member", m);
		request.setAttribute("order", list);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/myPage/myPage.jsp");
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
