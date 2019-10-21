package kr.magasin.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.magasin.common.JDBCTemplate;
import kr.magasin.product.model.dao.ProductDao;
import kr.magasin.product.model.vo.Product;

public class ProductService {


	public ArrayList<Product> productList(int prdId) {
		Connection conn = JDBCTemplate.getConnection();
		ProductDao dao = new ProductDao();
		ArrayList<Product> list = dao.productList(conn,prdId);
		JDBCTemplate.close(conn);
		return list;
	}

}
