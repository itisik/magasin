package kr.magasin.board.controller.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.magasin.board.model.service.QnAService;
import kr.magasin.board.model.vo.PageData;

/**
 * Servlet implementation class QnAListServlet
 */
@WebServlet(name = "QnAList", urlPatterns = { "/qnaList" })
public class QnAListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int reqPage1;
		
		try {
			reqPage1 = Integer.parseInt(request.getParameter("reqPage1"));
			
			
		}catch(NumberFormatException e){
			reqPage1 = 1;
			
			
		}

		QnAService service = new QnAService();
		PageData pd  = service.qnAList(reqPage1);
		
		request.setAttribute("qEtcList", pd.getqEtcList());
		request.setAttribute("aEtcList", pd.getaEtcList());
		request.setAttribute("qPrdList", pd.getqPrdList());
		request.setAttribute("aPrdList", pd.getaPrdList());
		
		request.setAttribute("pageNavi", pd.getPageNavi());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/qna/qnaListTest.jsp");
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
