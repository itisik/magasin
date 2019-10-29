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
	 System.out.println("장바구니 디에이오~~");
	 System.out.println("디에이오의 ID"+id);
	 ArrayList<Basket> list = new ArrayList<Basket>();
	 Basket b = null;
	 PreparedStatement pstmt = null;
	 ResultSet rset = null;
	 String query = "select c.basket_Id, c.basket_User_Id, a.prd_name, a.prd_price, basket_Prd_Dtl_Id, basket_Prd_Count, prd_Dtl_Size, prd_Dtl_Color from product_dtl b, basket c, product a where c.basket_Prd_Dtl_Id = b.prd_dtl_id and b.prd_id = a.prd_id and basket_user_id=?"; 
	 try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, id);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			b = new Basket();		
			b.setBasketId(rset.getString("BASKET_ID"));
			b.setBasketUserId(rset.getString("BASKET_USER_ID"));
			b.setPrdName(rset.getString("PRD_NAME"));
			b.setPrdPrice(rset.getString("PRD_PRICE"));
			b.setBasketPrdDtlId(rset.getString("BASKET_PRD_DTL_ID"));
			b.setBasketPrdCount(rset.getString("BASKET_PRD_COUNT"));
			b.setPrdDtlSize(rset.getString("PRD_DTL_SIZE"));
			b.setPrdDtlColor(rset.getString("PRD_DTL_COLOR"));
			list.add(b);
		}
		//System.out.println(b.getBasketId()+"/"+b.getBasketPrdCount()+"/"+b.getBasketPrdDtlId()+"/"+b.getBasketUserId()+"/"+b.getPrdDtlColor()+"/"+b.getPrdDtlSize()+"/"+b.getPrdName()+"/"+b.getPrdPrice());
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
		 System.out.println("장바구니 delete DAO");
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
	 public int locationPrd(Connection conn, int prdDtlId) {
		 int result = 0;
		 ResultSet rset = null;
		 PreparedStatement pstmt = null;
		 String query = "select prd_id from product_dtl where prd_dtl_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, prdDtlId);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					result = rset.getInt("prd_id");
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
