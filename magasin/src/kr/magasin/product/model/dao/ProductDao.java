package kr.magasin.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.common.JDBCTemplate;
import kr.magasin.product.model.vo.Product;

public class ProductDao {

	public ArrayList<Product> productList(Connection conn, int prdId) {
		ArrayList<Product> list = new ArrayList<Product>();
		return null;
	}

}
