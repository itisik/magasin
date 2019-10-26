package kr.magasin.adminPage.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.adminPage.model.dao.OrderSearchDao;
import kr.magasin.adminPage.model.vo.Order;
import kr.magasin.common.JDBCTemplate;

public class OrderSearchService {

	public ArrayList<Order> OrderSearch(String timeIndex, int dateSelect2, String detailIndex, String order) {

		Connection conn = JDBCTemplate.getConnection();
		OrderSearchDao dao = new OrderSearchDao();
		ArrayList<Order> list = new ArrayList<Order>();

		if (searchIndex.equals("all2")) {
			// 전체 기간 검색.
			if (detailIndex.equals("customerName")) {
				// 고객이름 기준
				list = dao.CustomerSearchAllByName(conn, order);
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			} else if (detailIndex.equals("customerId")) {
				// 고객아이디 기준
				list = dao.CustomerSearchAllById(conn, order);
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			} else if (detailIndex.equals("prdName")) {
				// 제품명
				list = dao.CustomerSearchAllByPrd(conn, order);

				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		} else if (searchIndex.equals("purchaseDate2")) {
			// 기간 : 결제일 기준.
			if (detailIndex.equals("customerName")) {
				// 고객이름 기준
				list = dao.CustomerSearchPurByName(conn, dateSelect, customer);
				return list;
			} else if (detailIndex.equals("customerId")) {
				// 고객아이디 기준
				list = dao.CustomerSearchPurById(conn, dateSelect, customer);
				return list;
			} else if (detailIndex.equals("prdName")) {
				// 제품명
				list = dao.CustomerSearchPurByPrd(conn, dateSelect, customer);
				return list;

			}
		} else if (searchIndex.equals("outDate2")) {
			// 기간 : 발송일 기준.
			if (detailIndex.equals("customerName")) {
				// 고객이름 기준
				list = dao.CustomerSearchOutByName(conn, dateSelect, customer);
				return list;
			} else if (detailIndex.equals("customerId")) {
				// 고객아이디 기준
				list = dao.CustomerSearchOutById(conn, dateSelect, customer);
				return list;
			} else if (detailIndex.equals("prdName")) {
				// 제품명
				list = dao.CustomerSearchOutByPrd(conn, dateSelect, customer);
				return list;
			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
