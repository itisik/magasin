package kr.magasin.adminPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.adminPage.model.vo.Customer;
import kr.magasin.common.JDBCTemplate;

public class CustomerSearchDao {

	public ArrayList<Customer> CustomerSearchAllByName(Connection conn, String condition) {
		ArrayList<Customer> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM Customer WHERE NAME = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, condition);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				
				
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public ArrayList<Customer> CustomerSearchAllById(Connection conn, String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Customer> CustomerSearchAllByPrd(Connection conn, String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
