package kr.magasin.adminPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.adminPage.model.vo.Chart;
import kr.magasin.adminPage.model.vo.Chart2;
import kr.magasin.adminPage.model.vo.Chart3;

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

			while (rset.next()) {
				date.add(rset.getString("MYDATE") == null ? "0" : rset.getString("MYDATE"));
				countByDate.add(rset.getString("ORDERCOUNT") == null ? 0 : rset.getInt("ORDERCOUNT"));
				sumMoney.add(rset.getString("ORDERMONEY") == null ? 0 : rset.getInt("ORDERMONEY"));
			}

			Chart c = new Chart(date, countByDate, sumMoney);
			list.add(c);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<Chart2> ChartList2(Connection conn, String chartIndex, String startDate, String endDate) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Chart2> list2 = new ArrayList<Chart2>();

		String query = "SELECT GENDER, COUNT(GENDER) AS COUNT FROM (SELECT TO_CHAR(TO_DATE(TO_DATE(?), 'YY-MM-DD') + ROWNUM - 1, 'YY-MM-DD') AS MYDATE FROM ALL_OBJECTS WHERE ROWNUM <= TO_DATE(?) - TO_DATE(?) + 1) LEFT JOIN (SELECT GENDER, ORDER_DATE FROM MEMBER LEFT JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID) ON MYDATE = ORDER_DATE GROUP BY GENDER ORDER BY GENDER DESC";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setString(3, startDate);

			ArrayList<Integer> genderNoneCount = new ArrayList<Integer>();
			ArrayList<Integer> manCount = new ArrayList<Integer>();
			ArrayList<Integer> womancount = new ArrayList<Integer>();

			rset = pstmt.executeQuery();

			if (rset.next()) {
				genderNoneCount.add(rset.getString("COUNT") == null ? 0 : rset.getInt("COUNT"));
				System.out.println(rset.getString("COUNT"));
			}

			if (rset.next()) {
				manCount.add(rset.getString("COUNT") == null ? 0 : rset.getInt("COUNT"));
				System.out.println(rset.getString("COUNT"));
			}

			if (rset.next()) {
				womancount.add(rset.getString("COUNT") == null ? 0 : rset.getInt("COUNT"));
				System.out.println(rset.getString("COUNT"));
			}

			Chart2 c2 = new Chart2(genderNoneCount, manCount, womancount);
			list2.add(c2);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list2;
	}

	public ArrayList<Chart3> ChartList3(Connection conn, String chartIndex, String startDate, String endDate) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Chart3> list3 = new ArrayList<Chart3>();

		String query = "SELECT FLOOR((MONTHS_BETWEEN(TRUNC(SYSDATE,'YEAR'), TRUNC(TO_DATE(BIRTHDATE, 'YYYYMMDD'), 'YEAR')) / 12 +1 ) /10)*10  AS AGE_BAND,\r\n" + 
				"COUNT(FLOOR((MONTHS_BETWEEN(TRUNC(SYSDATE,'YEAR'), TRUNC(TO_DATE(BIRTHDATE, 'YYYYMMDD'), 'YEAR')) / 12 +1 ) /10)*10) AS AGE_COUNT\r\n" + 
				"FROM MEMBER \r\n" + 
				"LEFT JOIN ORDER_P\r\n" + 
				"ON MEMBER.ID = ORDER_P.ORDER_USER_ID\r\n" + 
				"GROUP BY FLOOR((MONTHS_BETWEEN(TRUNC(SYSDATE,'YEAR'), TRUNC(TO_DATE(BIRTHDATE, 'YYYYMMDD'), 'YEAR')) / 12 +1 ) /10)*10";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setString(3, startDate);

			ArrayList<Integer> age10 = new ArrayList<Integer>();
			ArrayList<Integer> age20 = new ArrayList<Integer>();
			ArrayList<Integer> age30 = new ArrayList<Integer>();
			ArrayList<Integer> ageOver40 = new ArrayList<Integer>();
			ArrayList<Integer> ageNone = new ArrayList<Integer>();

			rset = pstmt.executeQuery();

			while (rset.next()) {
				// !!!
				if(rset.getString("AGE_BAND") == "10") {
					age10.add(rset.getString("AGE_COUNT") == null ? 0 : rset.getInt("AGE_COUNT"));
				} else 
				
				if(rset.getString("AGE_BAND") == "20") {
					age10.add(rset.getString("AGE_BAND") == null ? 0 : rset.getInt("AGE_BAND"));
				} else if(rset.getString("AGE_BAND") == "30") {
					age10.add(rset.getString("AGE_BAND") == null ? 0 : rset.getInt("AGE_BAND"));
				} else if(rset.getString("AGE_BAND") == null) {
					
				}
				// !!!

	}

	{
		age10.add(rset.getString("COUNT") == null ? 0 : rset.getInt("COUNT"));
	}

	Chart3 c3 = new Chart3(age10, age20, age30, ageOver40, ageNone);list3.add(c3);

	}catch(

	SQLException e){e.printStackTrace();
}

	return list3;
}

}
