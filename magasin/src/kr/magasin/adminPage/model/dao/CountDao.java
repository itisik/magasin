package kr.magasin.adminPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.adminPage.model.vo.Count;
import kr.magasin.common.JDBCTemplate;

public class CountDao {
	public Count CountNew(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Count c = new Count();
		
		String query = "SELECT COUNT(ORDER_DATE) AS STATUS FROM ORDER_P WHERE ORDER_STATUS = 1";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				c.setNewOrder(rset.getInt("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return c;
	}

	public Count CountShip(Connection conn, Count c) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT COUNT(ORDER_DATE) AS STATUS FROM ORDER_P WHERE ORDER_STATUS = 3";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				c.setShippingOrder(rset.getInt("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return c;
	}

	public Count CountCom(Connection conn, Count c) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT COUNT(ORDER_DATE) AS STATUS FROM ORDER_P WHERE ORDER_STATUS = 4";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				c.setComOrder(rset.getInt("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return c;
	}

	public Count CountToday(Connection conn, Count c) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT COUNT(ORDER_MONEY) AS 결제금액 FROM ORDER_P WHERE TO_DATE(ORDER_DATE) = TO_DATE(TO_CHAR(SYSDATE, 'YYYY-MM-DD'))";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				c.setTodayMoney(rset.getInt("결제금액"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return c;
	}

	public Count CountWeek(Connection conn, Count c) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT COUNT(ORDER_MONEY) AS 결제금액 FROM ORDER_P WHERE TO_DATE(ORDER_DATE) BETWEEN TO_DATE(TO_CHAR(SYSDATE - 7, 'YYYY-MM-DD')) AND TO_DATE(TO_CHAR(SYSDATE, 'YYYY-MM-DD')";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				c.setWeekMoney(rset.getInt("결제금액"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return c;
	}

	public Count CountQ1(Connection conn, Count c) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT COUNT(*) AS 미답변1 FROM Q_PRD WHERE Q_IS_A = 0";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				c.setqCount(rset.getInt("미답변1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return c;
	}
	

	public Count CountQ2(Connection conn, Count c) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT COUNT(*) AS 미답변2 FROM Q_PRD WHERE Q_IS_A = 0";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				int tmp = c.getqCount();
				tmp += rset.getInt("미답변2");
				c.setqCount(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return c;
	}
	
	public ArrayList<Count> CountCancle(Connection conn, Count c) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Count> list = new ArrayList<Count>();
		
		String query = "SELECT COUNT(*) AS 컴플레인 FROM ORDER_P WHERE ORDER_STATUS = 0 OR ORDER_STATUS = 5";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				c.setCancleOrder(rset.getInt("컴플레인"));
			}
			list.add(c);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}
}
