package kr.magasin.orderP.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.magasin.common.JDBCTemplate;
import kr.magasin.orderP.model.dao.OrderPDao;
import kr.magasin.orderP.model.vo.Order;
import kr.magasin.orderP.model.vo.OrderP2;
import kr.magasin.orderP.model.vo.OrderYim;

public class OrderPService {
	
	//ORDERP INSERT 
	public int updateOrderP(int count, ArrayList<OrderYim> list) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		OrderPDao dao = new OrderPDao();
		result = dao.updateOrderP(conn, count, list);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<OrderP2> selectAll(String id) {
		ArrayList<OrderP2> list = new ArrayList<OrderP2>();
		Connection conn = JDBCTemplate.getConnection();
		OrderPDao dao = new OrderPDao();
		list = dao.selectAll(conn, id);
		JDBCTemplate.close(conn);
		return list;
	}
	//취소,반품 페이지 
	public ArrayList<OrderP2> selectAll2(String id) {
		ArrayList<OrderP2> list = new ArrayList<OrderP2>();
		Connection conn = JDBCTemplate.getConnection();
		OrderPDao dao = new OrderPDao();
		list = dao.selectAll2(conn, id);
		JDBCTemplate.close(conn);
		return list;
	}
	//취소요청
	public int update(int orderNum) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		OrderPDao dao = new OrderPDao();
		result = dao.update(conn, orderNum);
		JDBCTemplate.close(conn);
		return result;
	}
	
	//반품요청
	public int update1(int orderNum) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		OrderPDao dao = new OrderPDao();
		result = dao.update1(conn, orderNum);
		JDBCTemplate.close(conn);
		return result;
	}
	public ArrayList<Order> orderAll(String id){
		ArrayList<Order> list = new ArrayList<Order>();
		Connection conn = JDBCTemplate.getConnection();
		OrderPDao dao = new OrderPDao();
		list = dao.orderAll(conn, id);
		JDBCTemplate.close(conn);
		return list;
	}
}
