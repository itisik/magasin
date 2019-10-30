package kr.magasin.prdPaging.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import kr.magasin.basket.model.vo.BasketT;
import kr.magasin.common.JDBCTemplate;
import kr.magasin.orderP.model.vo.OrderP2;
import kr.magasin.prdPaging.model.vo.ProductAll;
import kr.magasin.prdPaging.model.vo.ProductLee;
import kr.magasin.product.model.vo.Product;
import kr.magasin.productDtl.model.vo.ProductDtl;


public class ProductLeeDao {
	// 상품번호로 페이지 이동  (경필) 건들 ㄴㄴ
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
	               pdI.setPrdId(prdId);
	               pdI.setPrdName(rset.getString("prd_Name"));
	               pdI.setPrdGender(rset.getString("prd_gender"));
	               pdI.setPrdCtgr(rset.getString("prd_ctgr"));
	               pdI.setPrdSubCtrg(rset.getString("prd_sub_ctgr"));
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

	//은지 장바구니에서 결체로 넘어각게 만든 페이지 건들지 마세요 !!!!!!
	public ArrayList<ProductAll> insertBasket(Connection conn, ArrayList<BasketT> list, int count) {
		ProductAll pa = null;
		ArrayList<ProductAll> lists = new ArrayList<ProductAll>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select a.prd_Id, a.prd_Sn_Imgname, prd_Sn_Imgpath, prd_Dtl_Count from product a, product_dtl b where  a.prd_id = b.prd_id and prd_dtl_id=?";
		try {
			for(int i=0;i<count;i++) {
				
		
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,Integer.parseInt(list.get(i).getPrdDtlId()));
			rset = pstmt.executeQuery();
			if(rset.next()) {
				pa = new ProductAll();
				pa.setPrdId(rset.getInt("prd_Id"));
				pa.setPrdSnImgname(rset.getString("prd_Sn_Imgname"));
				pa.setPrdSnImgpath(rset.getString("prd_Sn_Imgpath"));
				pa.setPrdDtlCount(rset.getInt("prd_Dtl_Count"));
				pa.setCount(list.get(i).getPrdCount());
				pa.setPrdDtlColor(list.get(i).getPrdDtlColor());
				pa.setPrdDtlSize(list.get(i).getPrdDtlSize());
				pa.setPrdPrice(list.get(i).getPrdPrice());
				pa.setPrdName(list.get(i).getPrdName());
				pa.setPrdDtlSize(list.get(i).getPrdDtlSize());
				lists.add(pa);
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("데이터베이스 잘왔는지 확인 ");
		System.out.println(list.get(0).getPrdDtlColor());
		return lists;
	}


/*
 	
 	가격과 신상으로 조회
 	
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
*/

	public ArrayList<ProductLee> selectList(Connection conn, int start, int end, String ctgr, String gender) {
		ArrayList<ProductLee> lists = new ArrayList<ProductLee>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select* from"+
						"(select ROWNUM as rnum, n. * from"
						+ "(select * from product where prd_ctgr=? and prd_gender=? order by prd_up_date desc) n )"
						+ " where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ctgr);
			pstmt.setString(2, gender);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ProductLee p = new ProductLee();
				p.setRnum(rset.getInt("rnum"));
				p.setPrdId(rset.getInt("prd_Id"));
				p.setPrdName(rset.getString("prd_Name"));
				p.setPrdGender(rset.getString("prd_gender"));
				p.setPrdCtgr(rset.getString("prd_ctgr"));
				p.setPrdSubCtrg(rset.getString("prd_sub_ctgr"));
				p.setPrdPrice(rset.getInt("prd_price"));
				p.setPrdUpDate(rset.getDate("prd_up_date"));
				p.setPrdSnImgname(rset.getString("prd_sn_imgname"));
				p.setPrdSnImgpath(rset.getString("prd_sn_imgpath"));
				p.setPrdFilename(rset.getString("prd_filename"));
				p.setPrdFilepath(rset.getString("prd_filepath"));
				lists.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return lists;
		
	}

	public int totalCount(Connection conn,String ctgr, String gender) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from Product where prd_ctgr=? and prd_gender=? order by prd_up_date desc";
		int result =0 ;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ctgr);
			pstmt.setString(2, gender);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<ArrayList<ProductDtl>> searchColor(Connection conn,ArrayList<ProductLee> list){
		ArrayList<ArrayList<ProductDtl>> list2 = new ArrayList<ArrayList<ProductDtl>>();
		ArrayList<ProductDtl> colors = new ArrayList<ProductDtl>();
		ProductDtl prdDtl = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT DISTINCT(PRD_DTL_COLOR) FROM PRODUCT_DTL WHERE PRD_ID = ?";
		try {
	        pstmt = conn.prepareStatement(query); 
			for(int i=0; i<list.size();i++) {
	            
	            pstmt.setInt(1, list.get(i).getPrdId());
	            rset = pstmt.executeQuery();
	            while(rset.next()) {
	               
	            	prdDtl = new ProductDtl();
	                prdDtl.setPrdDtlColor(rset.getString("PRD_DTL_COLOR"));
	                prdDtl.setPrdId(list.get(i).getPrdId());
	                colors.add(prdDtl);
	             }
	            list2.add(colors);
	         }
			System.out.println(list2.get(0).get(0).getPrdDtlColor());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list2;
	}
	
	public ArrayList<String> subCtgr(Connection conn,String ctgr,String gender) {

		ArrayList<String> sub = new ArrayList<String>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT DISTINCT PRD_CTGR, PRD_SUB_CTGR FROM PRODUCT WHERE PRD_CTGR =? and PRD_GENDER=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ctgr);
			pstmt.setString(2, gender);

			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				sub.add(rset.getString("prd_sub_ctgr"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return sub;
	}


	public int subTotalCount(Connection conn, String subCtgr, String gender) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from Product where prd_sub_ctgr=? and prd_gender=? order by prd_up_date desc";
		int result =0 ;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, subCtgr);
			pstmt.setString(2, gender);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<ProductLee> subCtgrSearch(Connection conn, int start, int end, String subCtgr, String gender) {
		// TODO Auto-generated method stub
		ArrayList<ProductLee> list = new ArrayList<ProductLee>();
		ProductLee prd = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select* from"+
						"(select ROWNUM as rnum, n. * from"
						+ "(select * from product where prd_sub_ctgr=? and prd_gender=? order by prd_up_date desc) n )"
						+ " where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, subCtgr);
			pstmt.setString(2, gender);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				prd = new ProductLee();
				prd.setRnum(rset.getInt("rnum"));
				prd.setPrdId(rset.getInt("prd_Id"));
				prd.setPrdName(rset.getString("prd_Name"));
				prd.setPrdGender(rset.getString("prd_gender"));
				prd.setPrdCtgr(rset.getString("prd_ctgr"));
				prd.setPrdSubCtrg(rset.getString("prd_sub_ctgr"));
				prd.setPrdPrice(rset.getInt("prd_price"));
				prd.setPrdUpDate(rset.getDate("prd_up_date"));
				prd.setPrdSnImgname(rset.getString("prd_sn_imgname"));
				prd.setPrdSnImgpath(rset.getString("prd_sn_imgpath"));
				prd.setPrdFilename(rset.getString("prd_filename"));
				prd.setPrdFilepath(rset.getString("prd_filepath"));
				list.add(prd);
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

	public ArrayList<Integer> subCtgrCount(Connection conn, String ctgr, ArrayList<String> subCtgr) {
		// TODO Auto-generated method stub
		ArrayList<Integer> subCtgrCount = new ArrayList<Integer>();
		int count = 0;
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		String query="select count(*) as count from product where prd_ctgr=? and prd_sub_ctgr =?";
		try {
			pstmt = conn.prepareStatement(query);
			for(String sub : subCtgr) {
				pstmt.setString(1, ctgr);
				pstmt.setString(2, sub);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					count = rset.getInt("count");
					subCtgrCount.add(count);
				}
				
			}
			System.out.println(subCtgrCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subCtgrCount;
	}

	public ArrayList<ProductLee> newPrdList(Connection conn,int start, int end, String gender) {
		// TODO Auto-generated method stub
		ArrayList<ProductLee> list = new ArrayList<ProductLee>();
		ProductLee prd = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select* from"+
								"(select ROWNUM as rnum, n. * from"
								+ "(select * from product where prd_gender=? order by prd_up_date desc) n )"
								+ " where rnum between ? and ?";
		
			try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, gender);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				prd = new ProductLee();
				prd.setPrdCtgr(rset.getString("prd_ctgr"));
				prd.setPrdGender(rset.getString("prd_gender"));
				prd.setPrdId(rset.getInt("prd_id"));
				prd.setPrdName(rset.getString("prd_name"));
				prd.setPrdPrice(rset.getInt("prd_price"));
				prd.setPrdSnImgpath(rset.getString("prd_sn_imgpath"));
				prd.setPrdSnImgname(rset.getString("prd_sn_imgname"));
				prd.setPrdSubCtrg(rset.getString("prd_sub_ctgr"));
				prd.setPrdUpDate(rset.getDate("prd_up_date"));
				list.add(prd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		 }
		
		return list;
	}


	public int newPrdtotalCount(Connection conn, String gender) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from product where prd_gender=? order by prd_up_date desc";
		int result =0 ;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, gender);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}



	public ArrayList<String> selectColor(Connection conn, int prdId) {
		// TODO Auto-generated method stub
		ArrayList<String> colors = new ArrayList<String>();
		String color = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT DISTINCT(PRD_DTL_COLOR) FROM PRODUCT_DTL WHERE PRD_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, prdId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				color = rset.getString("prd_dtl_color");
				colors.add(color);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return colors;
	}



	public ArrayList<String> selectSize(Connection conn, int prdId) {
		// TODO Auto-generated method stub
		ArrayList<String> sizes = new ArrayList<String>();
		String size = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT DISTINCT(PRD_DTL_size) FROM PRODUCT_DTL WHERE PRD_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, prdId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				size = rset.getString("prd_dtl_size");
				sizes.add(size);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return sizes;
	}



	public int orderComplete(Connection conn, int prdId, String size, int amount, String color) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update product_dtl set prd_dtl_count = (prd_dtl_count-?) where prd_Id=? and prd_dtl_size=? and prd_dtl_color =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, amount);
			pstmt.setInt(2, prdId);
			pstmt.setString(3, size);
			pstmt.setString(4, color);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}



	

	
}
