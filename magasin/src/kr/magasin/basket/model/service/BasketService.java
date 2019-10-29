package kr.magasin.basket.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.magasin.basket.model.dao.BasketDao;
import kr.magasin.basket.model.vo.Basket;
import kr.magasin.basket.model.vo.BasketT;
import kr.magasin.common.JDBCTemplate;

public class BasketService {
	public int locationPrd(int prdDtlId) {
		int result =0;
		Connection conn = JDBCTemplate.getConnection();
		BasketDao dao = new BasketDao();
		result = dao.locationPrd(conn, prdDtlId);
		JDBCTemplate.close(conn);		
		return result;
	}
	public int deleteBasket(ArrayList<BasketT> list, int count) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		BasketDao dao = new BasketDao();
		result = dao.deleteBasket(conn, list, count);
		JDBCTemplate.close(conn);		
		return result;
		
	}
	public ArrayList<Basket> basketList(String id){
		System.out.println("장바구니 서비스 !!!");
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
