package kr.magasin.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
         pstmt.setString(8, p.getPrdImgname());
         pstmt.setString(9, p.getPrdImgpath());
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

   

}