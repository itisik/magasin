package kr.magasin.adminPage.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.adminPage.model.dao.ChartDao;
import kr.magasin.adminPage.model.vo.Chart;
import kr.magasin.adminPage.model.vo.Chart2;
import kr.magasin.adminPage.model.vo.Chart3;
import kr.magasin.common.JDBCTemplate;

public class ChartService {

	public ArrayList<Chart> ChartList(String chartIndex, String startDate, String endDate) {
		Connection conn = JDBCTemplate.getConnection();
		ChartDao dao = new ChartDao();
		ArrayList<Chart> chartList = dao.ChartList(conn, chartIndex, startDate, endDate);
		JDBCTemplate.close(conn);
		return chartList;
	}

	public ArrayList<Chart2> ChartList2(String chartIndex, String startDate, String endDate) {
		Connection conn = JDBCTemplate.getConnection();
		ChartDao dao = new ChartDao();
		ArrayList<Chart2> chartList2 = dao.ChartList2(conn, chartIndex, startDate, endDate);
		JDBCTemplate.close(conn);
		return chartList2;
	}

	public ArrayList<Chart3> ChartList3(String chartIndex, String startDate, String endDate) {
		Connection conn = JDBCTemplate.getConnection();
		ChartDao dao = new ChartDao();
		
		ArrayList<Chart3> chartList3 = dao.ChartList3(conn, chartIndex, startDate, endDate);
		JDBCTemplate.close(conn);
		return chartList3;
	}

}
