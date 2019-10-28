package kr.magasin.basket.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.basket.model.vo.Basket;
import kr.magasin.basket.model.vo.BasketT;
import kr.magasin.common.JDBCTemplate;

public class BasketDao {
 public ArrayList<Basket> basketList(Connection conn,String id){
	 ArrayList<Basket> list = new ArrayList<Basket>();
	 Basket b = null;
	 PreparedStatement pstmt = null;
	 ResultSet rset = null;
	 String query = "select basket_Id, basket_User_Id, prd_name, prd_price, basket_Prd_Dtl_Id, basket_Prd_Count, prd_Dtl_Size, prd_Dtl_Color from product_dtl , basket, product where basket.basket_Prd_Dtl_Id = product_dtl.prd_dtl_ID and product_dtl.prd_id = product.prd_id and basket_user_id=?";; 
	 		
	 try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, id);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			b = new Basket();
			b.setPrdPrice(rset.getString("prd_price"));
			b.setBasketId(rset.getString("basket_Id"));
			b.setPrdName(rset.getString("prd_name"));
			b.setBasketUserId(rset.getString("basket_User_Id"));
			b.setBasketPrdDtlId(rset.getString("basket_Prd_Dtl_Id"));
			b.setBasketPrdCount(rset.getString("basket_Prd_Count"));
			b.setPrdDtlSize(rset.getString("prd_Dtl_Size"));
			b.setPrdDtlColor(rset.getString("prd_Dtl_Color"));
			list.add(b);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		JDBCTemplate.close(conn);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rset);
	}
	 
	 return list;
 }
 	//구매페이지로 들어갔을떄 장바구니 삭제하는 로직 
 	public int deleteBasket(Connection conn, ArrayList<BasketT> list, int count) {
 		 int result = 0;
		 PreparedStatement pstmt = null;
		 String query = "delete from basket where basket_id =?";
		 
		 try {
			for(int i = 0; i<count;i++) {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, list.get(i).getBasketId());
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
						
			}else {
				conn.rollback();
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}	 
		 return result;
 	}
 
	 public int deleteOne(Connection conn, int basketId) {
		 int result = 0;
		 PreparedStatement pstmt = null;
		 String query = "delete from basket where basket_id =?";
		 
		 try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, basketId);
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
						
			}else {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}	 
		 return result;
	 }
	 
	 public int deleteAll(Connection conn, String basketUserId) {
		 int result = 0;
		 PreparedStatement pstmt = null;
		 String query = "delete from basket where basket_User_Id =?";
		 
		 try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, basketUserId);
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}	 
		 return result;
	 }
	 
	
	 public int updateBasketCount(Connection conn,int basketId, int basketPrdCount) {
		 int result = 0;
		 PreparedStatement pstmt = null;
		 System.out.println("여기는 basketDAO!!!!");
		 String query = "update basket set basket_prd_Count=? where basket_Id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, basketPrdCount);
				pstmt.setInt(2, basketId);
				result = pstmt.executeUpdate();
				if(result>0) {
					conn.commit();
				}else {
					conn.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}
		 return result;
	 }
		 
}
