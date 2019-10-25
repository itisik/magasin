package kr.magasin.adminPage.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.adminPage.model.dao.CustomerSearchDao;
import kr.magasin.adminPage.model.vo.Customer;
import kr.magasin.common.JDBCTemplate;

public class CustomerSearchService {
	public ArrayList<Customer> CustomerSearch(String searchIndex, int dateSelect, String selectIndex, String customer) {
		Connection conn = JDBCTemplate.getConnection();
		CustomerSearchDao dao = new CustomerSearchDao();
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		if (searchIndex.equals("none") && dateSelect == -1) {
			// 전체 기간 검색.
			if (selectIndex.equals("customerName")) {
				// 고객이름 기준
				return dao.CustomerSearchAllByName(conn, customer);
				
			} else if (selectIndex.equals("customerId")) {
				// 고객아이디 기준
				list = dao.CustomerSearchAllById(conn, customer);
				return list;
				
			} else if (selectIndex.equals("prdName")) {
				// 제품명
				list = dao.CustomerSearchAllByPrd(conn, customer);
				return list;
			}
		} /*else if (searchIndex.equals("purchaseDate")) {
			// 기간 : 결제일 기준.
			
			if (selectIndex.equals("customerName")) {
				// 고객이름 기준
				list = dao.CustomerSearchPurByName(conn, customer);
				return list;
				
			} else if (selectIndex.equals("customerId")) {
				// 고객아이디 기준
				list = dao.CustomerSearchPurById(conn, customer);
				return list;
				
			} else if (selectIndex.equals("prdName")) {
				// 제품명
				list = dao.CustomerSearchPurByPrd(conn, customer);
				return list;
				
			}
		} else if (searchIndex.equals("outDate")) {
			// 기간 : 발송일 기준.

			if (selectIndex.equals("customerName")) {
				// 고객이름 기준
				list = dao.CustomerSearchOutByName(conn, customer);
				return list;
				
			} else if (selectIndex.equals("customerId")) {
				// 고객아이디 기준
				list = dao.CustomerSearchOutById(conn, customer);
				return list;
				
			} else if (selectIndex.equals("prdName")) {
				// 제품명
				list = dao.CustomerSearchOutByPrd(conn, customer);
				return list;
				
			}
		}*/
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
