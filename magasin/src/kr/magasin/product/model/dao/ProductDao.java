package kr.magasin.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;

import kr.magasin.common.JDBCTemplate;
import kr.magasin.product.model.vo.Product;
import kr.magasin.product.model.vo.ProductInsert;
import kr.magasin.productDtl.model.vo.ProductDtl;

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


   public int insertProduct(Connection conn, Product p) {
      PreparedStatement pstmt = null;
      int result =0;
      
      String query = "insert into product values (PRODUCT_SEQ.nextval,?,?,?,?,?,sysdate,?,?,?,?)";
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, p.getPrdName());
         pstmt.setString(2, p.getPrdGender());
         pstmt.setString(3, p.getPrdCtgr());
         pstmt.setString(4, p.getPrdSubCtrg());
         pstmt.setInt(5, p.getPrdPrice());
         pstmt.setString(6, p.getPrdSnImgname());
         pstmt.setString(7, p.getPrdSnImgpath());
         pstmt.setString(8, p.getPrdFilename());
         pstmt.setString(9, p.getPrdFilepath());

         result = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally{
         JDBCTemplate.close(pstmt);
      }
      return result;
   }

   public int selectSequenNo(Connection conn) {
      PreparedStatement pstmt = null;
      ResultSet rset =null;
      int prdId=0;
      String query ="select PRODUCT_SEQ.CURRVAL from DUAL";
      try {
         pstmt = conn.prepareStatement(query);
         rset=pstmt.executeQuery();
         if(rset.next()){
            
            prdId = rset.getInt("currval");
            
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally{
         JDBCTemplate.close(rset);
         JDBCTemplate.close(pstmt);         
      }
      return prdId;
   }

   public int insertProdctdtl(Connection conn, int refKey, ProductDtl pdtl) {
      PreparedStatement pstmt = null;
      int result =0;
      String query = "insert into product_dtl values (PRODUCT_DTL_SEQ.nextval,?,?,?,?)";
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, refKey);
         pstmt.setInt(2, pdtl.getPrdDtlCount());
         pstmt.setString(3, pdtl.getPrdDtlSize());
         pstmt.setString(4, pdtl.getPrdDtlColor());
         result= pstmt.executeUpdate();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally{
         JDBCTemplate.close(pstmt);
      }
      return result;
   }

public ArrayList<Product> productList(Connection conn, String productnamesearch, String prdCtgr, String prdSubCtrg,
		int prddatesearch) {
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String query = "select * from product where prd_name like ? and prd_ctgr=? and prd_sub_ctgr=? and prd_up_date between sysdate - ? and sysdate";
	ArrayList<Product> list = new ArrayList<Product>();
	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, "%"+productnamesearch+"%");
		pstmt.setString(2, prdCtgr);
		pstmt.setString(3, prdSubCtrg);
		pstmt.setInt(4, prddatesearch);
		rset = pstmt.executeQuery();
		while (rset.next()) {
			Product p = new Product();
			p.setPrdId(rset.getInt("PRD_ID"));
			p.setPrdName(rset.getString("PRD_NAME"));
			p.setPrdGender(rset.getString("PRD_GENDER"));
			p.setPrdCtgr(rset.getString("PRD_CTGR"));
			p.setPrdSubCtrg(rset.getString("PRD_SUB_CTGR"));
			p.setPrdPrice(rset.getInt("PRD_PRICE"));
			p.setPrdUpDate(rset.getDate("PRD_UP_DATE"));
			p.setPrdFilename(rset.getString("PRD_SN_IMGNAME"));
			p.setPrdSnImgpath(rset.getString("PRD_SN_IMGPATH"));
			p.setPrdFilename(rset.getString("PRD_FILENAME"));
			p.setPrdFilepath(rset.getString("PRD_FILEPATH"));
			list.add(p);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rset);
	}
		return list;
}

public Product searchOne(Connection conn, int prdId) {
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	Product p = null;
	String query = "select * from product where prd_id=?";
	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, prdId);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			p = new Product();
			p.setPrdId(rset.getInt("PRD_ID"));
			p.setPrdName(rset.getString("PRD_NAME"));
			p.setPrdGender(rset.getString("PRD_GENDER"));
			p.setPrdCtgr(rset.getString("PRD_CTGR"));
			p.setPrdSubCtrg(rset.getString("PRD_SUB_CTGR"));
			p.setPrdPrice(rset.getInt("PRD_PRICE"));
			p.setPrdUpDate(rset.getDate("PRD_UP_DATE"));
			p.setPrdSnImgname(rset.getString("PRD_SN_IMGNAME"));
			p.setPrdSnImgpath(rset.getString("PRD_SN_IMGPATH"));
			p.setPrdFilename(rset.getString("PRD_FILENAME"));
			p.setPrdFilepath(rset.getString("PRD_FILEPATH"));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
		
	}
	return p;
}

public ArrayList<ProductDtl> searchdtl(Connection conn, int prdId) {
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	ProductDtl pdtl = null;
	ArrayList<ProductDtl> list = new ArrayList<ProductDtl>();
	String query = "select * from product_dtl where prd_id=?";
	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, prdId);
		rset = pstmt.executeQuery();
		if(rset.next()){
			pdtl = new ProductDtl();
			pdtl.setPrdId(rset.getInt("PRD_ID"));
			pdtl.setPrdDtlId(rset.getInt("PRD_DTL_ID"));
			pdtl.setPrdDtlCount(rset.getInt("PRD_DTL_COUNT"));
			pdtl.setPrdDtlSize(rset.getString("PRD_DTL_SIZE"));
			pdtl.setPrdDtlColor(rset.getString("PRD_DTL_COLOR"));
			list.add(pdtl);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
	}
	return list;
}

public int updateProduct(Connection conn, Product p) {
	PreparedStatement pstmt = null;
	int result =0; 
	String query = "update product set PRD_NAME=?, PRD_PRICE=?, PRD_SN_IMGNAME=?, PRD_SN_IMGPATH=?,PRD_FILENAME=?,PRD_FILEPATH=? where prd_id=?";
	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, p.getPrdName());
		pstmt.setInt(2, p.getPrdPrice());
		pstmt.setString(3, p.getPrdSnImgname());
		pstmt.setString(4, p.getPrdSnImgpath());
		pstmt.setString(5, p.getPrdFilename());
		pstmt.setString(6, p.getPrdFilepath());
		pstmt.setInt(7, p.getPrdId());
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