package kr.magasin.basket.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.magasin.basket.model.dao.BasketDao;
import kr.magasin.basket.model.vo.Basket;
import kr.magasin.common.JDBCTemplate;

public class BasketService {
	public ArrayList<Basket> basketList(String id){
		ArrayList<Basket>list = new ArrayList<Basket>();
		Connection conn = JDBCTemplate.getConnection();
		BasketDao dao = new BasketDao();
		list = dao.basketList(conn,id);
		JDBCTemplate.close(conn);		
		return list;
	}
	public int deleteOne(int basketId) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		BasketDao dao = new BasketDao();
		result = dao.deleteOne(conn, basketId);
		JDBCTemplate.close(conn);		
		return result;
	}
	public int deleteAll(String basketUserId) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		BasketDao dao = new BasketDao();
		result = dao.deleteAll(conn, basketUserId);
		JDBCTemplate.close(conn);		
		return result;
	}
	public int updateBasketCount(int basketId, int basketPrdCount) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		BasketDao dao = new BasketDao();
		result = dao. updateBasketCount(conn, basketId, basketPrdCount);
		JDBCTemplate.close(conn);		
		return result;
	}
}
