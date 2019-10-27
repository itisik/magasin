package kr.magasin.adminPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.adminPage.model.vo.Customer;
import kr.magasin.adminPage.model.vo.Order;
import kr.magasin.common.JDBCTemplate;

public class OrderSearchDao {

	public ArrayList<Order> OrderSearchAllByName(Connection conn, String order) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT ID, NAME, ADDR, ORDER_ADDR, PHONE, BIRTHDATE, GENDER, GRADE, EMAIL, ENROLL_DATE, ORDER_NUM, PRD_ID,  ORDER_PRD_DTL_ID, PRD_NAME, ORDER_PRD_COUNT, ORDER_MONEY, ORDER_STATUS, ORDER_DATE, ORDER_OUT_DATE, ORDER_COM_DATE FROM (SELECT * FROM MEMBER LEFT OUTER JOIN ORDER_P ON MEMBER.ID = ORDER_P.ORDER_USER_ID) A LEFT JOIN (SELECT PRODUCT.PRD_ID, PRD_DTL_ID, PRD_NAME, PRD_GENDER, PRD_CTGR, PRD_SUB_CTGR, PRD_PRICE, PRD_UP_DATE FROM PRODUCT LEFT JOIN PRODUCT_DTL ON PRODUCT.PRD_ID = PRODUCT_DTL.PRD_ID) B ON A.ORDER_PRD_DTL_ID = B.PRD_DTL_ID WHERE NAME LIKE (?) ORDER BY ORDER_DATE DESC";

		ArrayList<Order> list = new ArrayList<Order>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + order + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Order o = new Order();
				o.setOrderNum(rset.getInt("ORDER_NUM"));
				o.setOrderCusId(rset.getString("ID") == null ? "내용없음" : rset.getString("ID"));
				o.setOrderCusName(rset.getString("NAME") == null ? "내용없음" : rset.getString("NAME"));
				o.setOrderCusPrdName(rset.getString("PRD_NAME") == null ? "내용없음" : rset.getString("PRD_NAME"));
				o.setOrderCusPrdCount(rset.getString("ORDER_PRD_COUNT") == null ? "내용없음" : rset.getString("ORDER_PRD_COUNT"));
				o.setOrderCusPurDate(rset.getDate("ORDER_DATE") == null ? "내용없음" : rset.getString("ORDER_DATE").toString());
				o.setOrderCusOutDate(rset.getDate("ORDER_OUT_DATE") == null ? "내용없음" : rset.getString("ORDER_OUT_DATE").toString());
				o.setOrderCusComDate(rset.getDate("ORDER_COM_DATE") == null ? "내용없음" : rset.getString("ORDER_COM_DATE").toString());
				o.setOrderStatus(rset.getInt("ORDER_STATUS"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public ArrayList<Order> OrderSearchAllById(Connection conn, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Order> OrderSearchAllByPrd(Connection conn, String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
