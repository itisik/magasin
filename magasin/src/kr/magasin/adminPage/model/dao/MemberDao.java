package kr.magasin.adminPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.adminPage.model.vo.MemberGrade;
import kr.magasin.common.JDBCTemplate;

public class MemberDao {

	// ID로 검색
	public MemberGrade MemberGrade1(Connection conn, String memberKeyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberGrade mg = null;

		String query = "SELECT ROWNUM, ID, NAME, ORDER_MONEY, ENROLL_DATE, ORDER_DATE, GRADE FROM MEMBER LEFT JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID WHERE ID = ? AND ROWNUM = 1 ORDER BY ORDER_DATE DESC";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberKeyword);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				String memId = rset.getString("ID") == null ? "기록없음" : rset.getString("ID");
				String memName = rset.getString("NAME") == null ? "기록없음" : rset.getString("NAME");
				String enrollDate = rset.getString("ENROLL_DATE") == null ? "기록없음" : rset.getString("ENROLL_DATE");
				String recentOrderDate = rset.getString("ORDER_DATE") == null ? "기록없음" : rset.getString("ORDER_DATE");
				String grade = rset.getString("GRADE") == null ? "내용없음" : rset.getString("GRADE");
				mg = new MemberGrade(memId, memName, enrollDate, recentOrderDate, grade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return mg;
	}
	public ArrayList<MemberGrade> MemberGrade2(Connection conn, String memberKeyword, MemberGrade mg) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<MemberGrade> list = new ArrayList<MemberGrade>();
		MemberGrade tmp = new MemberGrade();

		String query = "SELECT ORDER_USER_ID, COUNT(ORDER_DATE) AS TOTALCOUNT, SUM(ORDER_MONEY) AS TOTALMONEY FROM ORDER_P WHERE ORDER_USER_ID = ? GROUP BY ORDER_USER_ID";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberKeyword);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				String tCount = rset.getString("TOTALCOUNT") == null ? "0" : rset.getString("TOTALCOUNT");
				String tMoney = rset.getString("TOTALMONEY") == null ? "0" : rset.getString("TOTALMONEY");

				tmp.setMemId(mg.getMemId());
				tmp.setMemName(mg.getMemName());
				tmp.setEnrollDate(mg.getEnrollDate());
				tmp.setRecentOrderDate(mg.getRecentOrderDate());
				tmp.setGrade(mg.getGrade());
				tmp.settCount(tCount);
				tmp.settMoney(tMoney);

			} else {
				tmp.setMemId(mg.getMemId());
				tmp.setMemName(mg.getMemName());
				tmp.setEnrollDate(mg.getEnrollDate());
				tmp.setRecentOrderDate(mg.getRecentOrderDate());
				tmp.setGrade(mg.getGrade());
				tmp.settCount("기록없음");
				tmp.settMoney("기록없음");
			}
			list.add(tmp);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}
}
