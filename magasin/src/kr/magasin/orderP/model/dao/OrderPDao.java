package kr.magasin.orderP.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.common.JDBCTemplate;
import kr.magasin.orderP.model.vo.OrderP2;

public class OrderPDao {
	 public ArrayList<OrderP2> selectAll(Connection conn, String id){
		 OrderP2 oP = null;
		 ArrayList<OrderP2> list = new ArrayList<OrderP2>();
		 PreparedStatement pstmt = null;
		 ResultSet rset = null;
		 String query = "select A.prd_id,  B.prd_Dtl_Id, A.prd_Name, B.prd_Dtl_Size, B.prd_Dtl_Color,A.prd_Price, a.prd_Sn_Imgname, a.prd_Sn_Imgpath, a.prd_filename, a.prd_filepath, c.order_Prd_Count, c.order_Money, order_Addr, order_Status, order_Pay, order_Date, order_Out_Date, order_Num, order_User_Id, order_Prd_Dtl_Id FROM PRODUCT A ,PRODUCT_Dtl B ,order_p c where A.PRD_ID= B.PRD_ID AND b.PRD_DTL_ID = c.ORDER_PRd_DTL_ID and order_USER_id=?"; 

		 
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, id);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					oP = new OrderP2();
					oP.setPrdId(rset.getInt("prd_id"));
					oP.setPrdDtlId(rset.getInt("prd_dtl_id"));
					oP.setPrdName(rset.getString("prd_name"));
					oP.setPrdDtlSize(rset.getString("prd_dtl_size"));
					oP.setPrdDtlColor(rset.getString("prd_dtl_color"));
					oP.setPrdPrice(rset.getInt("prd_price"));
					oP.setPrdSnImgname(rset.getString("prd_sn_imgname"));
					oP.setPrdSnImgpath(rset.getString("prd_sn_imgpath"));
					oP.setPrdFilename(rset.getString("prd_filename"));
					oP.setPrdFilepath(rset.getString("prd_filepath"));
					oP.setOrderPrdCount(rset.getInt("order_prd_count"));
					oP.setOrderMoney(rset.getInt("order_money"));
					oP.setOrderAddr(rset.getString("order_addr"));
					oP.setOrderStatus(rset.getString("order_status"));
					oP.setOrderPay(rset.getString("order_pay"));
					oP.setOrderDate(rset.getDate("order_date"));
					oP.setOrderOutDate(rset.getDate("order_out_date"));
					oP.setOrderNum(rset.getInt("order_num"));
					oP.setOrderUserId(rset.getString("order_user_id"));
					oP.setOrderPrdDtlId(rset.getInt("order_prd_dtl_id"));
					list.add(oP);
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
	 
	 
	 public ArrayList<OrderP2> selectAll2(Connection conn, String id){
		 OrderP2 oP = null;
		 ArrayList<OrderP2> list = new ArrayList<OrderP2>();
		 PreparedStatement pstmt = null;
		 ResultSet rset = null;
		 String query = "select A.prd_id,  B.prd_Dtl_Id, A.prd_Name, B.prd_Dtl_Size, B.prd_Dtl_Color,A.prd_Price, a.prd_Sn_Imgname, a.prd_Sn_Imgpath, a.prd_filename, a.prd_filepath, c.order_Prd_Count, c.order_Money, order_Addr, order_Status, order_Pay, order_Date, order_Out_Date, order_Num, order_User_Id, order_Prd_Dtl_Id FROM PRODUCT A ,PRODUCT_Dtl B ,order_p c where A.PRD_ID= B.PRD_ID AND b.PRD_DTL_ID = c.ORDER_PRd_DTL_ID and order_USER_id=?"; 

		 
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, id);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					oP = new OrderP2();
					oP.setPrdId(rset.getInt("prd_id"));
					oP.setPrdDtlId(rset.getInt("prd_dtl_id"));
					oP.setPrdName(rset.getString("prd_name"));
					oP.setPrdDtlSize(rset.getString("prd_dtl_size"));
					oP.setPrdDtlColor(rset.getString("prd_dtl_color"));
					oP.setPrdPrice(rset.getInt("prd_price"));
					oP.setPrdSnImgname(rset.getString("prd_sn_imgname"));
					oP.setPrdSnImgpath(rset.getString("prd_sn_imgpath"));
					oP.setPrdFilename(rset.getString("prd_filename"));
					oP.setPrdFilepath(rset.getString("prd_filepath"));
					oP.setOrderPrdCount(rset.getInt("order_prd_count"));
					oP.setOrderMoney(rset.getInt("order_money"));
					oP.setOrderAddr(rset.getString("order_addr"));
					oP.setOrderStatus(rset.getString("order_status"));
					oP.setOrderPay(rset.getString("order_pay"));
					oP.setOrderDate(rset.getDate("order_date"));
					oP.setOrderOutDate(rset.getDate("order_out_date"));
					oP.setOrderNum(rset.getInt("order_num"));
					oP.setOrderPrdDtlId(rset.getInt("order_prd_dtl_id"));
					list.add(oP);
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
	 
	 public int update(Connection conn, int orderNum) {
		 int result = 0;
		 PreparedStatement pstmt = null;
		 String query = "update order_P set ORDER_STATUS=? where order_num =?";
		 
		 try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "취소접수");
			pstmt.setInt(2, orderNum);
			result = pstmt.executeUpdate();
			
			if(result >0) {
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
	 
	 public int update1(Connection conn, int orderNum) {
		 int result = 0;
		 PreparedStatement pstmt = null;
		 String query = "update order_P set ORDER_STATUS=? where order_num =?";
		 
		 try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "반품접수");
			pstmt.setInt(2, orderNum);
			result = pstmt.executeUpdate();
			
			if(result >0) {
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
