package kr.magasin.adminPage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.magasin.adminPage.model.dao.CustomerSearchDao;
import kr.magasin.common.JDBCTemplate;
import kr.magasin.member.model.vo.Member;

public class CustomerSearchService {
	public ArrayList<Member> CustomerSearch(String searchIndex, String dateSelect, String selectIndex, String customer) {
		CustomerSearchDao dao = new CustomerSearchDao();
		if(searchIndex.equals("none")) {
			// 기간을 특정하지 않은 검색.
			if(selectIndex.equals("1w")) {
				
			} else if(selectIndex.equals("2w")) {
				
			} else if(selectIndex.equals("1m")) {
				
			} else if(selectIndex.equals("3m")) {
				
			}
			ArrayList<Member> list = dao.CustomerSearchAll(dateSelect, );
		} else if (searchIndex.equals("purchaseDate")) {
			// 기간 : 결제일 기준.
			ArrayList<Member> list = dao.CustomerSearchPurchase();
		} else if(searchIndex.equals("outDate")) {
			// 기간 : 발송일 기준.
			ArrayList<Member> list = dao.CustomerSearchOutDate();
		}
		return list;
		
	}
}

