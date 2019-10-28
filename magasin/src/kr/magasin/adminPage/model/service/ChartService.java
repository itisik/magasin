package kr.magasin.adminPage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.magasin.adminPage.model.dao.ChartDao;
import kr.magasin.adminPage.model.vo.Chart;
import kr.magasin.common.JDBCTemplate;

public class ChartService {

	public ArrayList<Chart> chart(String chartIndex, String startDate, String endDate) {
		Connection conn = JDBCTemplate.getConnection();
		ChartDao dao = new ChartDao();
		ArrayList<Chart> list = dao.ChartDaily(conn, chartIndex, startDate, endDate);
		
		return list;
	}

}
