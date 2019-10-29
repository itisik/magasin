package kr.magasin.adminPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.adminPage.model.vo.Chart;

public class ChartDao {

	public ArrayList<Chart> ChartList(Connection conn, String chartIndex, String startDate, String endDate) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Chart> list = new ArrayList<Chart>();
		
		String query = "SELECT * FROM (SELECT TO_CHAR(TO_DATE(TO_DATE(?), 'YY-MM-DD') + ROWNUM - 1, 'YY-MM-DD') AS MYDATE, TO_CHAR(TO_DATE(TO_DATE(?), 'YY-MM-DD') + ROWNUM - 1, 'DY') AS DAY FROM ALL_OBJECTS WHERE ROWNUM <= TO_DATE(?) - TO_DATE(?) + 1) A LEFT OUTER JOIN (SELECT TO_CHAR(ORDER_DATE, 'YY-MM-DD') AS MYDATE, SUM(ORDER_MONEY) AS ORDERMONEY, COUNT(ORDER_MONEY) AS ORDERCOUNT FROM ORDER_P WHERE TO_CHAR(ORDER_DATE, 'YY-MM-DD') BETWEEN TO_DATE(?)+1 AND TO_DATE(?) GROUP BY TO_CHAR(ORDER_DATE, 'YY-MM-DD') ORDER BY TO_CHAR(ORDER_DATE, 'YY-MM-DD') ASC) B USING(MYDATE) ORDER BY MYDATE ASC";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, startDate);
			pstmt.setString(2, startDate);
			pstmt.setString(3, endDate);
			pstmt.setString(4, startDate);
			pstmt.setString(5, startDate);
			pstmt.setString(6, endDate);

			ArrayList<String> date = new ArrayList<String>();
			ArrayList<Integer> countByDate = new ArrayList<Integer>();
			ArrayList<Integer> sumMoney = new ArrayList<Integer>();
			
			rset = pstmt.executeQuery();
		
			while(rset.next()) {
				date.add(rset.getString("MYDATE") == null ? "0" : rset.getString("MYDATE"));
				countByDate.add(rset.getString("ORDERCOUNT") == null ? 0 : rset.getInt("ORDERCOUNT"));
				sumMoney.add(rset.getString("ORDERMONEY") == null ? 0 : rset.getInt("ORDERMONEY"));
				System.out.println(rset.getString("MYDATE"));
				System.out.println( rset.getInt("ORDERCOUNT"));
				System.out.println(rset.getInt("ORDERMONEY"));
			}
			
			Chart c = new Chart(date, countByDate, sumMoney);
			list.add(c);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return list;
	}

}
