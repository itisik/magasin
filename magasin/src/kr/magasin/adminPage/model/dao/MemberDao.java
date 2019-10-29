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
		MemberGrade mg = new MemberGrade();
		
		String query = "SELECT ROWNUM, ID, NAME, ORDER_MONEY, ENROLL_DATE, ORDER_DATE, GRADE FROM MEMBER LEFT JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID WHERE ID = ? AND ROWNUM = 1 ORDER BY ORDER_DATE DESC";
				
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberKeyword);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				mg.setMemId(rset.getString("ID") == null ? "내용없음" : rset.getString("ID"));
				mg.setMemName(rset.getString("NAME") == null ? "내용없음" : rset.getString("NAME"));
				mg.setEnrollDate(rset.getString("ENROLL_DATE") == null ? "내용없음" : rset.getString("ENROLL_DATE"));
				mg.setRecentOrderDate(rset.getString("ORDER_DATE") == null ? "내용없음" : rset.getString("ORDER_DATE"));
				mg.setRecentOrderDate(rset.getString("GRADE") == null ? "내용없음" : rset.getString("GRADE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return mg;
	}

	// ID로 검색
	public ArrayList<MemberGrade> MemberGrade2(Connection conn, String memberKeyword, MemberGrade mg) {
		System.out.println("아예 안 타는 건가?");
		System.out.println(memberKeyword);
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<MemberGrade> list = new ArrayList<MemberGrade>();

		String query = "SELECT ORDER_USER_ID, COUNT(ORDER_DATE) AS TOTALCOUNT, SUM(ORDER_MONEY) AS TOTALMONEY FROM ORDER_P WHERE ORDER_USER_ID = ? GROUP BY ORDER_USER_ID";
				
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberKeyword);

			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				mg.settCount(rset.getString("TOTALCOUNT") == null ? "0" : rset.getString("TOTALCOUNT"));
				mg.settMoney(rset.getString("TOTALMONEY") == null ? "0" : rset.getString("TOTALMONEY"));

				System.out.println(mg.getMemId());
				System.out.println(mg.getMemName());
				System.out.println(mg.getEnrollDate());
				System.out.println(mg.getRecentOrderDate());
				System.out.println(mg.gettCount());
				System.out.println(mg.gettMoney());
			}			
			list.add(mg);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

}
