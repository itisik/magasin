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
import kr.magasin.adminPage.model.vo.Chart3;

/**
 * Servlet implementation class Chart3Servlet
 */
@WebServlet(name = "Chart3", urlPatterns = { "/chart3" })
public class Chart3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Chart3Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 연령별 차트 그리기
		String chartIndex = request.getParameter("chartIndex");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		ChartService service = new ChartService();
		ArrayList<Chart3> chartList3 = service.ChartList3(chartIndex, startDate, endDate);

		if (chartList3 == null) {
			return;
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(chartList3, response.getWriter());
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
