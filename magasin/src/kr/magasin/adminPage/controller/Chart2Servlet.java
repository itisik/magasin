package kr.magasin.adminPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.magasin.adminPage.model.service.ChartService;
import kr.magasin.adminPage.model.vo.Chart2;

/**
 * Servlet implementation class Chart2Servlet
 */
@WebServlet(name = "Chart2", urlPatterns = { "/chart2" })
public class Chart2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chart2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 성별별 차트 그릭
		String chartIndex = request.getParameter("chartIndex");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		ChartService service = new ChartService();
		ArrayList<Chart2> chartList2 = service.ChartList2(chartIndex, startDate, endDate);
		
		if(chartList2 == null) {
			return;
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(chartList2, response.getWriter());
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
