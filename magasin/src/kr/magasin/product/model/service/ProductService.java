package kr.magasin.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.magasin.common.JDBCTemplate;
import kr.magasin.product.model.dao.ProductDao;
import kr.magasin.product.model.vo.Product;

public class ProductService {


	public ArrayList<Product> productList() {
		Connection conn = JDBCTemplate.getConnection();
		ProductDao dao = new ProductDao();
		ArrayList<Product> list = dao.productList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public Product ProductdetailId(int prdId) {
		Connection conn = JDBCTemplate.getConnection();
		ProductDao dao = new ProductDao();
		Product pdI = dao.ProductdetailId(conn,prdId);
		JDBCTemplate.close(conn);
		return pdI;
	}

	public ArrayList<Product> productLowPrice() {
		Connection conn = JDBCTemplate.getConnection();
		ProductDao dao = new ProductDao();
		ArrayList<Product> lop = dao.productLowPrice(conn);
		JDBCTemplate.close(conn);
		return lop;
	}

	public ArrayList<Product> productHighprice() {
		Connection conn = JDBCTemplate.getConnection();
		ProductDao dao = new ProductDao();
		ArrayList<Product> hop = dao.productHighprice(conn);
		JDBCTemplate.close(conn);
		return hop;
	}

	public ArrayList<Product> productArrival() {
		Connection conn = JDBCTemplate.getConnection();
		ProductDao dao = new ProductDao();
		ArrayList<Product> nc = dao.productArrival(conn);
		JDBCTemplate.close(conn);
		return nc;
	}
}
