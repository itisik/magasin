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

		String query = "SELECT ID, NAME, GENDER, ADDR, PHONE, BIRTHDATE, EMAIL FROM (SELECT * FROM MEMBER LEFT OUTER JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID) A LEFT JOIN (SELECT PRODUCT.PRD_ID, PRD_DTL_ID, PRD_NAME, PRD_GENDER, PRD_CTGR, PRD_SUB_CTGR, PRD_PRICE, PRD_UP_DATE FROM PRODUCT LEFT JOIN PRODUCT_DTL ON PRODUCT.PRD_ID = PRODUCT_DTL.PRD_ID) B ON A.ORDER_PRD_DTL_ID = B.PRD_DTL_ID WHERE NAME LIKE (?) ORDER BY ORDER_DATE DESC";

		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + customer + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Customer c = new Customer();
				c.setCusId(rset.getString("ID") == null ? "내용없음" : rset.getString("ID"));
				c.setCusName(rset.getString("NAME") == null ? "내용없음" : rset.getString("NAME"));
				c.setCusGender(rset.getString("GENDER") == null ? "내용없음" : rset.getString("GENDER"));
				c.setCusAddr(rset.getString("ADDR") == null ? "내용없음" : rset.getString("ADDR"));
				c.setCusPhone(rset.getString("PHONE") == null ? "내용없음" : rset.getString("PHONE"));
				c.setCusBirthdate(rset.getString("BIRTHDATE") == null ? "내용없음" : rset.getString("BIRTHDATE"));
				c.setCusEmail(rset.getString("EMAIL") == null ? "내용없음" : rset.getString("EMAIL"));
				list.add(c);
				System.out.println(c.getCusName() + c.getCusBirthdate());
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

		String query = "SELECT ID, NAME, GENDER, ADDR, PHONE, BIRTHDATE, EMAIL FROM (SELECT * FROM MEMBER LEFT OUTER JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID) A LEFT JOIN (SELECT PRODUCT.PRD_ID, PRD_DTL_ID, PRD_NAME, PRD_GENDER, PRD_CTGR, PRD_SUB_CTGR, PRD_PRICE, PRD_UP_DATE FROM PRODUCT LEFT JOIN PRODUCT_DTL ON PRODUCT.PRD_ID = PRODUCT_DTL.PRD_ID) B ON A.ORDER_PRD_DTL_ID = B.PRD_DTL_ID WHERE ID = (?) ORDER BY ORDER_DATE DESC";

		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, customer);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Customer c = new Customer();
				c.setCusId(rset.getString("ID") == null ? "내용없음" : rset.getString("ID"));
				c.setCusName(rset.getString("NAME") == null ? "내용없음" : rset.getString("NAME"));
				c.setCusGender(rset.getString("GENDER") == null ? "내용없음" : rset.getString("GENDER"));
				c.setCusAddr(rset.getString("ADDR") == null ? "내용없음" : rset.getString("ADDR"));
				c.setCusPhone(rset.getDate("PHONE") == null ? "내용없음" : rset.getString("PHONE"));
				c.setCusBirthdate(rset.getDate("BIRTHDATE") == null ? "내용없음" : rset.getString("BIRTHDATE"));
				c.setCusEmail(rset.getDate("EMAIL") == null ? "내용없음" : rset.getString("EMAIL"));
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

		String query = "SELECT ID, NAME, GENDER, ADDR, PHONE, BIRTHDATE, EMAIL FROM (SELECT * FROM MEMBER LEFT OUTER JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID) A LEFT JOIN (SELECT PRODUCT.PRD_ID, PRD_DTL_ID, PRD_NAME, PRD_GENDER, PRD_CTGR, PRD_SUB_CTGR, PRD_PRICE, PRD_UP_DATE FROM PRODUCT LEFT JOIN PRODUCT_DTL ON PRODUCT.PRD_ID = PRODUCT_DTL.PRD_ID) B ON A.ORDER_PRD_DTL_ID = B.PRD_DTL_ID  WHERE PRD_NAME LIKE (?) ORDER BY ORDER_DATE DESC";

		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + customer + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Customer c = new Customer();
				c.setCusId(rset.getString("ID") == null ? "내용없음" : rset.getString("ID"));
				c.setCusName(rset.getString("NAME") == null ? "내용없음" : rset.getString("NAME"));
				c.setCusGender(rset.getString("GENDER") == null ? "내용없음" : rset.getString("GENDER"));
				c.setCusAddr(rset.getString("ADDR") == null ? "내용없음" : rset.getString("ADDR"));
				c.setCusPhone(rset.getDate("PHONE") == null ? "내용없음" : rset.getString("PHONE"));
				c.setCusBirthdate(rset.getDate("BIRTHDATE") == null ? "내용없음" : rset.getString("BIRTHDATE"));
				c.setCusEmail(rset.getDate("EMAIL") == null ? "내용없음" : rset.getString("EMAIL"));
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

	public ArrayList<Customer> CustomerSearchPurByName(Connection conn, int dateSelect, String customer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT ID, NAME, GENDER, ADDR, PHONE, BIRTHDATE, EMAIL FROM (SELECT * FROM MEMBER LEFT OUTER JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID) A LEFT JOIN (SELECT PRODUCT.PRD_ID, PRD_DTL_ID, PRD_NAME, PRD_GENDER, PRD_CTGR, PRD_SUB_CTGR, PRD_PRICE, PRD_UP_DATE FROM PRODUCT LEFT JOIN PRODUCT_DTL ON PRODUCT.PRD_ID = PRODUCT_DTL.PRD_ID) B ON A.ORDER_PRD_DTL_ID = B.PRD_DTL_ID  WHERE NAME LIKE (?) AND ORDER_DATE BETWEEN TRUNC(SYSDATE - (?)) AND SYSDATE ORDER BY ORDER_DATE DESC";

		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + customer + "%");
			pstmt.setInt(2, dateSelect);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Customer c = new Customer();
				c.setCusId(rset.getString("ID") == null ? "내용없음" : rset.getString("ID"));
				c.setCusName(rset.getString("NAME") == null ? "내용없음" : rset.getString("NAME"));
				c.setCusGender(rset.getString("GENDER") == null ? "내용없음" : rset.getString("GENDER"));
				c.setCusAddr(rset.getString("ADDR") == null ? "내용없음" : rset.getString("ADDR"));
				c.setCusPhone(rset.getDate("PHONE") == null ? "내용없음" : rset.getString("PHONE"));
				c.setCusBirthdate(rset.getDate("BIRTHDATE") == null ? "내용없음" : rset.getString("BIRTHDATE"));
				c.setCusEmail(rset.getDate("EMAIL") == null ? "내용없음" : rset.getString("EMAIL"));
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

	
	public ArrayList<Customer> CustomerSearchPurById(Connection conn, int dateSelect, String customer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT ID, NAME, GENDER, ADDR, PHONE, BIRTHDATE, EMAIL FROM (SELECT * FROM MEMBER LEFT OUTER JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID) A LEFT JOIN (SELECT PRODUCT.PRD_ID, PRD_DTL_ID, PRD_NAME, PRD_GENDER, PRD_CTGR, PRD_SUB_CTGR, PRD_PRICE, PRD_UP_DATE FROM PRODUCT LEFT JOIN PRODUCT_DTL ON PRODUCT.PRD_ID = PRODUCT_DTL.PRD_ID) B ON A.ORDER_PRD_DTL_ID = B.PRD_DTL_ID  WHERE ID ? AND ORDER_DATE BETWEEN TRUNC(SYSDATE-?) AND SYSDATE ORDER BY ORDER_DATE DESC";

		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, customer);
			pstmt.setInt(2, dateSelect);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Customer c = new Customer();
				c.setCusId(rset.getString("ID") == null ? "내용없음" : rset.getString("ID"));
				c.setCusName(rset.getString("NAME") == null ? "내용없음" : rset.getString("NAME"));
				c.setCusGender(rset.getString("GENDER") == null ? "내용없음" : rset.getString("GENDER"));
				c.setCusAddr(rset.getString("ADDR") == null ? "내용없음" : rset.getString("ADDR"));
				c.setCusPhone(rset.getDate("PHONE") == null ? "내용없음" : rset.getString("PHONE"));
				c.setCusBirthdate(rset.getDate("BIRTHDATE") == null ? "내용없음" : rset.getString("BIRTHDATE"));
				c.setCusEmail(rset.getDate("EMAIL") == null ? "내용없음" : rset.getString("EMAIL"));
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

	
	public ArrayList<Customer> CustomerSearchPurByPrd(Connection conn, int dateSelect, String customer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;


		String query = "SELECT ID, NAME, GENDER, ADDR, PHONE, BIRTHDATE, EMAIL FROM (SELECT * FROM MEMBER LEFT OUTER JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID) A LEFT JOIN (SELECT PRODUCT.PRD_ID, PRD_DTL_ID, PRD_NAME, PRD_GENDER, PRD_CTGR, PRD_SUB_CTGR, PRD_PRICE, PRD_UP_DATE FROM PRODUCT LEFT JOIN PRODUCT_DTL ON PRODUCT.PRD_ID = PRODUCT_DTL.PRD_ID) B ON A.ORDER_PRD_DTL_ID = B.PRD_DTL_ID  WHERE PRD_NAME LIKE (?) AND ORDER_DATE BETWEEN TRUNC(SYSDATE-?) AND SYSDATE ORDER BY ORDER_DATE DESC";
		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + customer + "%");
			pstmt.setInt(2, dateSelect);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Customer c = new Customer();
				c.setCusId(rset.getString("ID") == null ? "내용없음" : rset.getString("ID"));
				c.setCusName(rset.getString("NAME") == null ? "내용없음" : rset.getString("NAME"));
				c.setCusGender(rset.getString("GENDER") == null ? "내용없음" : rset.getString("GENDER"));
				c.setCusAddr(rset.getString("ADDR") == null ? "내용없음" : rset.getString("ADDR"));
				c.setCusPhone(rset.getDate("PHONE") == null ? "내용없음" : rset.getString("PHONE"));
				c.setCusBirthdate(rset.getDate("BIRTHDATE") == null ? "내용없음" : rset.getString("BIRTHDATE"));
				c.setCusEmail(rset.getDate("EMAIL") == null ? "내용없음" : rset.getString("EMAIL"));
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

	
	public ArrayList<Customer> CustomerSearchOutByName(Connection conn, int dateSelect, String customer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT ID, NAME, GENDER, ADDR, PHONE, BIRTHDATE, EMAIL FROM (SELECT * FROM MEMBER LEFT OUTER JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID) A LEFT JOIN (SELECT PRODUCT.PRD_ID, PRD_DTL_ID, PRD_NAME, PRD_GENDER, PRD_CTGR, PRD_SUB_CTGR, PRD_PRICE, PRD_UP_DATE FROM PRODUCT LEFT JOIN PRODUCT_DTL ON PRODUCT.PRD_ID = PRODUCT_DTL.PRD_ID) B ON A.ORDER_PRD_DTL_ID = B.PRD_DTL_ID  WHERE NAME LIKE (?) AND ORDER_OUT_DATE BETWEEN TRUNC(SYSDATE - (?)) AND SYSDATE ORDER BY ORDER_DATE DESC";

		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + customer + "%");
			pstmt.setInt(2, dateSelect);

			rset = pstmt.executeQuery();

			while (rset.next()) {

				Customer c = new Customer();
				c.setCusId(rset.getString("ID") == null ? "내용없음" : rset.getString("ID"));
				c.setCusName(rset.getString("NAME") == null ? "내용없음" : rset.getString("NAME"));
				c.setCusGender(rset.getString("GENDER") == null ? "내용없음" : rset.getString("GENDER"));
				c.setCusAddr(rset.getString("ADDR") == null ? "내용없음" : rset.getString("ADDR"));
				c.setCusPhone(rset.getDate("PHONE") == null ? "내용없음" : rset.getString("PHONE"));
				c.setCusBirthdate(rset.getDate("BIRTHDATE") == null ? "내용없음" : rset.getString("BIRTHDATE"));
				c.setCusEmail(rset.getDate("EMAIL") == null ? "내용없음" : rset.getString("EMAIL"));
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

	public ArrayList<Customer> CustomerSearchOutById(Connection conn, int dateSelect, String customer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT ID, NAME, GENDER, ADDR, PHONE, BIRTHDATE, EMAIL FROM (SELECT * FROM MEMBER LEFT OUTER JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID) A LEFT JOIN (SELECT PRODUCT.PRD_ID, PRD_DTL_ID, PRD_NAME, PRD_GENDER, PRD_CTGR, PRD_SUB_CTGR, PRD_PRICE, PRD_UP_DATE FROM PRODUCT LEFT JOIN PRODUCT_DTL ON PRODUCT.PRD_ID = PRODUCT_DTL.PRD_ID) B ON A.ORDER_PRD_DTL_ID = B.PRD_DTL_ID  WHERE ID ? AND ORDER_OUT_DATE BETWEEN TRUNC(SYSDATE-?) AND SYSDATE ORDER BY ORDER_DATE DESC";

		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, customer);
			pstmt.setInt(2, dateSelect);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Customer c = new Customer();
				c.setCusId(rset.getString("ID") == null ? "내용없음" : rset.getString("ID"));
				c.setCusName(rset.getString("NAME") == null ? "내용없음" : rset.getString("NAME"));
				c.setCusGender(rset.getString("GENDER") == null ? "내용없음" : rset.getString("GENDER"));
				c.setCusAddr(rset.getString("ADDR") == null ? "내용없음" : rset.getString("ADDR"));
				c.setCusPhone(rset.getDate("PHONE") == null ? "내용없음" : rset.getString("PHONE"));
				c.setCusBirthdate(rset.getDate("BIRTHDATE") == null ? "내용없음" : rset.getString("BIRTHDATE"));
				c.setCusEmail(rset.getDate("EMAIL") == null ? "내용없음" : rset.getString("EMAIL"));
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

	public ArrayList<Customer> CustomerSearchOutByPrd(Connection conn, int dateSelect, String customer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;


		String query = "SELECT ID, NAME, GENDER, ADDR, PHONE, BIRTHDATE, EMAIL FROM (SELECT * FROM MEMBER LEFT OUTER JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID) A LEFT JOIN (SELECT PRODUCT.PRD_ID, PRD_DTL_ID, PRD_NAME, PRD_GENDER, PRD_CTGR, PRD_SUB_CTGR, PRD_PRICE, PRD_UP_DATE FROM PRODUCT LEFT JOIN PRODUCT_DTL ON PRODUCT.PRD_ID = PRODUCT_DTL.PRD_ID) B ON A.ORDER_PRD_DTL_ID = B.PRD_DTL_ID  WHERE PRD_NAME LIKE (?) AND ORDER_OUT_DATE BETWEEN TRUNC(SYSDATE-?) AND SYSDATE ORDER BY ORDER_DATE DESC";
		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + customer + "%");
			pstmt.setInt(2, dateSelect);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Customer c = new Customer();
				c.setCusId(rset.getString("ID") == null ? "내용없음" : rset.getString("ID"));
				c.setCusName(rset.getString("NAME") == null ? "내용없음" : rset.getString("NAME"));
				c.setCusGender(rset.getString("GENDER") == null ? "내용없음" : rset.getString("GENDER"));
				c.setCusAddr(rset.getString("ADDR") == null ? "내용없음" : rset.getString("ADDR"));
				c.setCusPhone(rset.getDate("PHONE") == null ? "내용없음" : rset.getString("PHONE"));
				c.setCusBirthdate(rset.getDate("BIRTHDATE") == null ? "내용없음" : rset.getString("BIRTHDATE"));
				c.setCusEmail(rset.getDate("EMAIL") == null ? "내용없음" : rset.getString("EMAIL"));
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
