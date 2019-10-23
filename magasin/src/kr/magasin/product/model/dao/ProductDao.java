package kr.magasin.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import java.sql.SQLException;
import java.util.ArrayList;
import kr.magasin.common.JDBCTemplate;
import kr.magasin.product.model.vo.Product;

public class ProductDao {


	// 리스트불러옴 //
	public ArrayList<Product> productList(Connection conn) {
		ArrayList<Product> list = new ArrayList<Product>();
		Product pd= null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from product";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				pd = new Product();
				pd.setPrdId(rset.getInt("prd_Id"));
				pd.setPrdName(rset.getString("prd_Name"));
				pd.setPrdGender(rset.getString("prd_gender"));
				pd.setPrdCtgr(rset.getString("prd_ctgr"));
				pd.setPrdSubCtrg(rset.getString("prd_sub_ctgr"));
				pd.setPrdPrice(rset.getInt("prd_price"));
				pd.setPrdUpDate(rset.getDate("prd_up_date"));
				pd.setPrdSnImgname(rset.getString("prd_sn_imgname"));
				pd.setPrdSnImgpath(rset.getString("prd_sn_imgpath"));
				pd.setPrdFilename(rset.getString("prd_filename"));
				pd.setPrdFilepath(rset.getString("prd_filepath"));
				list.add(pd);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	// 상품번호로 페이지 이동 //
	public Product ProductdetailId(Connection conn, int prdId) {
		Product pdI = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from product where prd_Id=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, prdId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pdI = new Product();
				pdI.setPrdId(rset.getInt("prd_Id"));
				pdI.setPrdName(rset.getString("prd_Name"));
				pdI.setPrdPrice(rset.getInt("prd_price"));
				pdI.setPrdUpDate(rset.getDate("prd_up_date"));
				pdI.setPrdSnImgname(rset.getString("prd_sn_imgname"));
				pdI.setPrdSnImgpath(rset.getString("prd_sn_imgpath"));
				pdI.setPrdFilename(rset.getString("prd_filename"));
				pdI.setPrdFilepath(rset.getString("prd_filepath"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return pdI;	
	}

	// 낮은 가격으로 조회 //
	public ArrayList<Product> productLowPrice(Connection conn) {
		ArrayList<Product> lop = new ArrayList<Product>();
		Product lp = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from product order by prd_price";
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				lp = new Product();
				lp.setPrdId(rset.getInt("prd_Id"));
				lp.setPrdName(rset.getString("prd_Name"));
				lp.setPrdGender(rset.getString("prd_gender"));
				lp.setPrdCtgr(rset.getString("prd_ctgr"));
				lp.setPrdSubCtrg(rset.getString("prd_sub_ctgr"));
				lp.setPrdPrice(rset.getInt("prd_price"));
				lp.setPrdUpDate(rset.getDate("prd_up_date"));
				lp.setPrdSnImgname(rset.getString("prd_sn_imgname"));
				lp.setPrdSnImgpath(rset.getString("prd_sn_imgpath"));
				lp.setPrdFilename(rset.getString("prd_filename"));
				lp.setPrdFilepath(rset.getString("prd_filepath"));
				lop.add(lp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return lop;
	}

	// 높은 가격으로 조회 //
	public ArrayList<Product> productHighprice(Connection conn) {
		ArrayList<Product> hop = new ArrayList<Product>();
		Product hp = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from product order by prd_price desc";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset=  pstmt.executeQuery();
			
			while(rset.next()) {
			hp = new Product();
			hp.setPrdId(rset.getInt("prd_Id"));
			hp.setPrdName(rset.getString("prd_Name"));
			hp.setPrdGender(rset.getString("prd_gender"));
			hp.setPrdCtgr(rset.getString("prd_ctgr"));
			hp.setPrdSubCtrg(rset.getString("prd_sub_ctgr"));
			hp.setPrdPrice(rset.getInt("prd_price"));
			hp.setPrdUpDate(rset.getDate("prd_up_date"));
			hp.setPrdSnImgname(rset.getString("prd_sn_imgname"));
			hp.setPrdSnImgpath(rset.getString("prd_sn_imgpath"));
			hp.setPrdFilename(rset.getString("prd_filename"));
			hp.setPrdFilepath(rset.getString("prd_filepath"));
			hop.add(hp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return hop;
	}

	// 최신 상품으로 조회//
	public ArrayList<Product> productArrival(Connection conn) {
		ArrayList<Product> nc = new ArrayList<Product>();
		Product c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from product order by PRD_UP_DATE desc";
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				c = new Product();
				c.setPrdId(rset.getInt("prd_Id"));
				c.setPrdName(rset.getString("prd_Name"));
				c.setPrdGender(rset.getString("prd_gender"));
				c.setPrdCtgr(rset.getString("prd_ctgr"));
				c.setPrdSubCtrg(rset.getString("prd_sub_ctgr"));
				c.setPrdPrice(rset.getInt("prd_price"));
				c.setPrdUpDate(rset.getDate("prd_up_date"));
				c.setPrdSnImgname(rset.getString("prd_sn_imgname"));
				c.setPrdSnImgpath(rset.getString("prd_sn_imgpath"));
				c.setPrdFilename(rset.getString("prd_filename"));
				c.setPrdFilepath(rset.getString("prd_filepath"));
				nc.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nc;
	}

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
