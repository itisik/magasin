package kr.magasin.adminPage.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.adminPage.model.dao.OrderSearchDao;
import kr.magasin.adminPage.model.vo.Order;
import kr.magasin.common.JDBCTemplate;

public class OrderSearchService {

	public ArrayList<Order> OrderSearch(String timeIndex, int dateSelect2, String detailIndex, String order) {
		if(timeIndex.equals("none2") || detailIndex.equals("none3")) {
			return null;
		}
		Connection conn = JDBCTemplate.getConnection();
		OrderSearchDao dao = new OrderSearchDao();
		ArrayList<Order> list = new ArrayList<Order>();

		if (timeIndex.equals("all2")) {
			// 전체 기간 검색.
			if (detailIndex.equals("customerName2")) {
				// 고객이름 기준
				list = dao.OrderSearchAllByName(conn, order);
			} else if (detailIndex.equals("customerId2")) {
				// 고객아이디 기준
				list = dao.OrderSearchAllById(conn, order);
			} else if (detailIndex.equals("prdName2")) {
				// 제품명
				list = dao.OrderSearchAllByPrd(conn, order);
			} else {
				// 주문 상태에 따른 모든 검색.
				// detailIndex가 orderStatus의 역할을 함.
				list = dao.OrderSearchAllByStatus(conn, detailIndex);
			}
			// 전체 기간 검색 끝.
		} else if (timeIndex.equals("purchaseDate2")) {
			// 기간 : 결제일 기준.
			if (detailIndex.equals("customerName2")) {
				// 고객이름 기준
				list = dao.OrderSearchPurByName(conn, dateSelect2, order);
				return list;
			} else if (detailIndex.equals("customerId2")) {
				// 고객아이디 기준
				list = dao.OrderSearchPurById(conn, dateSelect2, order);
				return list;
			} else if (detailIndex.equals("prdName2")) {
				// 제품명
				list = dao.OrderSearchPurByPrd(conn, dateSelect2, order);
				return list;
			}else {
				// 주문 상태와 결제일에 따른 모든 검색.
				// detailIndex가 orderStatus의 역할을 함.
				list = dao.OrderSearchAllByPurNStatus(conn, dateSelect2, detailIndex);
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
				
			}
		} /*else if (timeIndex.equals("outDate2")) {
			// 기간 : 발송일 기준.
			if (detailIndex.equals("orderName")) {
				// 고객이름 기준
				list = dao.OrderSearchOutByName(conn, dateSelect2, order);
				return list;
			} else if (detailIndex.equals("orderId")) {
				// 고객아이디 기준
				list = dao.OrderSearchOutById(conn, dateSelect2, order);
				return list;
			} else if (detailIndex.equals("prdName")) {
				// 제품명
				list = dao.OrderSearchOutByPrd(conn, dateSelect2, order);
				return list;
			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	*/
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
