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

	public int delete(Connection conn, int prdId) {
		PreparedStatement pstmt = null;
		int result =0;
		String query = "delete from product where prd_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, prdId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
