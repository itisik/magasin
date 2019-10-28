package kr.magasin.adminPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.magasin.common.JDBCTemplate;

public class OrderProgressDao {
	public int OrderProgressOne(Connection conn, int orderStatus, int orderNum) {
		PreparedStatement pstmt = null;
		int result = -1;
		
		String query = "UPDATE ORDER_P SET ORDER_STATUS = ORDER_STATUS+1 WHERE ORDER_NUM = ? AND ORDER_STATUS = ?";
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, orderNum);
			pstmt.setInt(2, orderStatus);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int OrderProgressMinus(Connection conn, int orderStatus, int orderNum) {
			PreparedStatement pstmt = null;
			int result = -1;
			
			String query = "UPDATE ORDER_P SET ORDER_STATUS = ORDER_STATUS-1 WHERE ORDER_NUM = ? AND ORDER_STATUS = ?";
			
			try {
				pstmt =conn.prepareStatement(query);
				pstmt.setInt(1, orderNum);
				pstmt.setInt(2, orderStatus);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
	}

	public int OrderProgressOutDate(Connection conn, int orderStatus, int orderNum) {
		PreparedStatement pstmt = null;
		int result = -1;
		
		String query = "UPDATE ORDER_P SET ORDER_OUT_DATE = SYSDATE WHERE ORDER_NUM = ? AND ORDER_STATUS = ?";
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, orderNum);
			pstmt.setInt(2, orderStatus+1);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int OrderProgressComDate(Connection conn, int orderStatus, int orderNum) {
		PreparedStatement pstmt = null;
		int result = -1;
		
		String query = "UPDATE ORDER_P SET ORDER_COM_DATE = SYSDATE WHERE ORDER_NUM = ? AND ORDER_STATUS = ?";
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, orderNum);
			pstmt.setInt(2, orderStatus+1);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
