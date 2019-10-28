package kr.magasin.adminPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.adminPage.model.vo.Chart;

public class ChartDao {

	public ArrayList<Chart> ChartDaily(Connection conn, String chartIndex, String startDate, String endDate) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Chart> list = new ArrayList<Chart>();
		
		String query = "SELECT * FROM (SELECT TO_CHAR(TO_DATE(TO_DATE(?), 'YY-MM-DD') + ROWNUM - 1, 'YY-MM-DD') AS 년월일 ,TO_CHAR(TO_DATE(TO_DATE(?), 'YY-MM-DD') + ROWNUM - 1, 'DY') AS 요일, TO_CHAR(TO_DATE(TO_DATE(?), 'YY-MM-DD') + ROWNUM - 1, 'DD') AS 일 FROM ALL_OBJECTS WHERE ROWNUM <= TO_DATE(?) - TO_DATE(?) + 1) A LEFT OUTER JOIN (SELECT TO_CHAR(ORDER_DATE, 'YY-MM-DD') AS 년월일, SUM(ORDER_MONEY) AS 결제금액, COUNT(ORDER_MONEY) AS 결제건수 FROM ORDER_P WHERE TO_CHAR(ORDER_DATE, 'YY-MM-DD') BETWEEN TO_DATE(?)+1 AND TO_DATE(?) GROUP BY TO_CHAR(ORDER_DATE, 'YY-MM-DD') ORDER BY TO_CHAR(ORDER_DATE, 'YY-MM-DD') ASC) B USING(년월일)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, startDate);
			pstmt.setString(2, startDate);
			pstmt.setString(3, startDate);
			pstmt.setString(4, endDate);
			pstmt.setString(5, startDate);
			pstmt.setString(6, startDate);
			pstmt.setString(7, endDate);
			
			rset = pstmt.executeQuery();
			
			Chart c = new Chart();
			c.set
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
