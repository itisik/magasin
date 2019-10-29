package kr.magasin.prdPaging.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.magasin.basket.model.vo.BasketT;
import kr.magasin.member.model.service.MemberService;
import kr.magasin.member.model.vo.Member;
import kr.magasin.prdPaging.model.service.ProductLeeService;
import kr.magasin.prdPaging.model.vo.PaydcutLee;
import kr.magasin.product.model.vo.Product;
import kr.magasin.productDtl.model.vo.ProductDtl;



/**
 * Servlet implementation class ProductExpayServlet
 */
@WebServlet(name = "ProductExpay", urlPatterns = { "/productExpay" })
public class ProductExpayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductExpayServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		///주문창으로 넘어가는 페이지 
	      request.setCharacterEncoding("utf-8");
	      
	      HttpSession session = request.getSession(false); // 기존 세션이 있다는 가정하에
	         if(session.getAttribute("member")==null) {// 멤버가 없으면
	            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
	            request.setAttribute("msg", "로그인을 해주세요"); // 메시지 창 출력
	            request.setAttribute("loc", "/views/member/login.jsp"); // 회원가입창 이동
	            rd.forward(request, response);
	         }else {// 로그인이 되어있으면
	            int prdId = Integer.parseInt(request.getParameter("prdId"));
	         int amount = Integer.parseInt(request.getParameter("total"));
	         String prdName = request.getParameter("prdName");
	         int prdPrice = Integer.parseInt(request.getParameter("prdPrice"));
	         String prdDtlColor = request.getParameter("prdDtrlColor");
	         String prdDtlSize = request.getParameter("prdDtlSize");
	         String prdSnImgpath = request.getParameter("PrdSnImgpath");
	         System.out.println("여기들어왔어");
	         
	         
	         
	         PaydcutLee pay = new PaydcutLee(prdId, amount, prdName, prdPrice, prdDtlColor, prdDtlSize, prdSnImgpath);
	         
	         
	         request.setAttribute("pays", pay);
	         
	         RequestDispatcher rd = request.getRequestDispatcher("/views/prdPage/expays.jsp"); // 결제페이지 이동
	         rd.forward(request, response);
	         }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
