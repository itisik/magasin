package kr.magasin.adminPage.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import kr.magasin.adminPage.model.dao.OrderProgressDao;
import kr.magasin.common.JDBCTemplate;

public class OrderProgressService {

	public int OrderProgress(int orderStatus, int orderNum) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;

		OrderProgressDao dao = new OrderProgressDao();

		if (orderStatus > 0) {
			result = dao.OrderProgressOne(conn, orderStatus, orderNum);
			
			if(orderStatus == 2) {
				result += dao.OrderProgressOutDate(conn, orderStatus, orderNum);
			}
			if(orderStatus == 3) {
				result += dao.OrderProgressComDate(conn, orderStatus, orderNum);
			}
		} else {
			result = dao.OrderProgressMinus(conn, orderStatus, orderNum);
		}

		try {
			if ((orderStatus != 2 && orderStatus != 3 && result > 0) || ((orderStatus == 2 || orderStatus == 3) && result > 1)){
				conn.commit();
				System.out.println("성공");
			} else {
				conn.rollback();
				System.out.println("실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

}
