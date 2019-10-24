package kr.magasin.adminPage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.magasin.adminPage.model.dao.CustomerSearchDao;
import kr.magasin.adminPage.model.vo.Customer;
import kr.magasin.common.JDBCTemplate;

public class CustomerSearchService {
	public ArrayList<Customer> CustomerSearch(String searchIndex, int dateSelect, String selectIndex, String condition) {
		Connection conn = JDBCTemplate.getConnection();
		CustomerSearchDao dao = new CustomerSearchDao();
		ArrayList<Customer> list = null;
		if (searchIndex.equals("none")) {
			// 전체 기간 검색.
			
			if (selectIndex.equals("customerName")) {
				// 고객이름 기준
				list = dao.CustomerSearchAllByName(conn, condition);
				
				
			} else if (selectIndex.equals("customerId")) {
				// 고객아이디 기준
				list = dao.CustomerSearchAllById(conn, condition);
				
			} else if (selectIndex.equals("prdName")) {
				// 제품명
				list = dao.CustomerSearchAllByPrd(conn, condition);
				
			}
		} else if (searchIndex.equals("purchaseDate")) {
			// 기간 : 결제일 기준.
			
			if (selectIndex.equals("customerName")) {
				// 고객이름 기준
				list = dao.CustomerSearchPurByName(conn, condition);
				
			} else if (selectIndex.equals("customerId")) {
				// 고객아이디 기준
				list = dao.CustomerSearchPurById(conn, condition);
				
			} else if (selectIndex.equals("prdName")) {
				// 제품명
				list = dao.CustomerSearchPurByPrd(conn, condition);
				
			}
			list = dao.CustomerSearchByPurchase();
		} else if (searchIndex.equals("outDate")) {
			// 기간 : 발송일 기준.

			if (selectIndex.equals("customerName")) {
				// 고객이름 기준
				list = dao.CustomerSearchOutByName(conn, condition);
				
			} else if (selectIndex.equals("customerId")) {
				// 고객아이디 기준
				list = dao.CustomerSearchOutById(conn, condition);
				
			} else if (selectIndex.equals("prdName")) {
				// 제품명
				list = dao.CustomerSearchOutByPrd(conn, condition);
				
			}
			list = dao.CustomerSearchByOutDate();
		}
		return list;

	}
}
