package kr.magasin.adminPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.adminPage.model.vo.Customer;
import kr.magasin.common.JDBCTemplate;

public class CustomerSearchDao {

	public ArrayList<Customer> CustomerSearchAllByName(Connection conn, String customer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM (SELECT * FROM MEMBER LEFT OUTER JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID) A LEFT JOIN (SELECT PRODUCT.PRD_ID, PRD_DTL_ID, PRD_NAME, PRD_GENDER, PRD_CTGR, PRD_SUB_CTGR, PRD_PRICE, PRD_UP_DATE FROM PRODUCT LEFT JOIN PRODUCT_DTL ON PRODUCT.PRD_ID = PRODUCT_DTL.PRD_ID) B ON A.ORDER_PRD_DTL_ID = B.PRD_DTL_ID  WHERE NAME LIKE (?)";

		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + customer + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Customer c = new Customer();
				c.setCusId(rset.getString("ID") == null ? "내용없음" : rset.getString("ID"));
				c.setCusName(rset.getString("NAME") == null ? "내용없음" : rset.getString("NAME"));
				c.setCusPrdName(rset.getString("PRD_NAME") == null ? "내용없음" : rset.getString("PRD_NAME"));
				c.setCusPrdCount(rset.getString("ORDER_PRD_COUNT") == null ? "내용없음" : rset.getString("ORDER_PRD_COUNT"));
				c.setCusPurDate(
						rset.getDate("ORDER_DATE") == null ? "내용없음" : rset.getString("ORDER_DATE").toString());
				c.setCusOutDate(rset.getDate("ORDER_OUT_DATE") == null ? "내용없음"
						: rset.getString("ORDER_OUT_DATE").toString());
				list.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public ArrayList<Customer> CustomerSearchAllById(Connection conn, String customer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM (SELECT * FROM MEMBER LEFT OUTER JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID) A LEFT JOIN (SELECT PRODUCT.PRD_ID, PRD_DTL_ID, PRD_NAME, PRD_GENDER, PRD_CTGR, PRD_SUB_CTGR, PRD_PRICE, PRD_UP_DATE FROM PRODUCT LEFT JOIN PRODUCT_DTL ON PRODUCT.PRD_ID = PRODUCT_DTL.PRD_ID) B ON A.ORDER_PRD_DTL_ID = B.PRD_DTL_ID WHERE ID = ?";

		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, customer);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Customer c = new Customer();
				c.setCusId(rset.getString("ID") == null ? "내용없음" : rset.getString("ID"));
				c.setCusName(rset.getString("NAME") == null ? "내용없음" : rset.getString("NAME"));
				c.setCusPrdName(rset.getString("PRD_NAME") == null ? "내용없음" : rset.getString("PRD_NAME"));
				c.setCusPrdCount(rset.getString("ORDER_PRD_COUNT") == null ? "내용없음" : rset.getString("ORDER_PRD_COUNT"));
				c.setCusPurDate(
						rset.getString("ORDER_DATE") == null ? "내용없음" : rset.getString("ORDER_DATE").toString());
				c.setCusOutDate(rset.getString("ORDER_OUT_DATE") == null ? "내용없음"
						: rset.getString("ORDER_OUT_DATE").toString());
				list.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public ArrayList<Customer> CustomerSearchAllByPrd(Connection conn, String customer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM (SELECT * FROM MEMBER LEFT OUTER JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID) A LEFT JOIN (SELECT PRODUCT.PRD_ID, PRD_DTL_ID, PRD_NAME, PRD_GENDER, PRD_CTGR, PRD_SUB_CTGR, PRD_PRICE, PRD_UP_DATE FROM PRODUCT LEFT JOIN PRODUCT_DTL ON PRODUCT.PRD_ID = PRODUCT_DTL.PRD_ID) B ON A.ORDER_PRD_DTL_ID = B.PRD_DTL_ID  WHERE PRD_NAME LIKE (?)";

		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + customer + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Customer c = new Customer();
				c.setCusId(rset.getString("ID") == null ? "내용없음" : rset.getString("ID"));
				c.setCusName(rset.getString("NAME") == null ? "내용없음" : rset.getString("NAME"));
				c.setCusPrdName(rset.getString("PRD_NAME") == null ? "내용없음" : rset.getString("PRD_NAME"));
				c.setCusPrdCount(rset.getString("ORDER_PRD_COUNT") == null ? "내용없음" : rset.getString("ORDER_PRD_COUNT"));
				c.setCusPurDate(
						rset.getString("ORDER_DATE") == null ? "내용없음" : rset.getString("ORDER_DATE").toString());
				c.setCusOutDate(rset.getString("ORDER_OUT_DATE") == null ? "내용없음"
						: rset.getString("ORDER_OUT_DATE").toString());
				list.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

}
