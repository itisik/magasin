package kr.magasin.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import kr.magasin.board.model.vo.Review;
import kr.magasin.common.JDBCTemplate;

public class ReviewDao {

	
	public int totalCount(Connection conn) {
		// TODO Auto-generated method stub
		int total=0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select count(*) as total from review";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				total = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
		return total;
	}

	public ArrayList<Review> reviewList(Connection conn, int start, int end) {
		// TODO Auto-generated method stub
			ArrayList<Review> list = new ArrayList<Review>();
			Review n = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query = "select * from (select rownum as rnum, n.*from "
					+ "(select * from review order by review_no desc)n)"
					+ " where rnum between ? and ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					n = new Review();
					n.setPrdName(rset.getString("prd_name"));
					n.setPrdSnImg(rset.getString("prd_sn_img"));
					n.setReviewCont(rset.getString("review_cont"));
					n.setReviewCount(rset.getInt("review_count"));
					n.setReviewDate(rset.getDate("review_date"));
					n.setReviewFilename1(rset.getString("review_filename1"));
					n.setReviewFilepath1(rset.getString("review_filepath1"));
					n.setReviewFilename2(rset.getString("review_filename2"));
					n.setReviewFilepath2(rset.getString("review_filepath2"));
					n.setReviewNo(rset.getInt("review_no"));
					n.setReviewPoint(rset.getInt("review_point"));
					n.setReviewTitle(rset.getString("review_title"));
					n.setReviewWriter(rset.getString("review_writer"));
					list.add(n);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return list;
	}

	public int reviewInsert(Connection conn, Review r) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt =null;
		String query="insert into review values(review_seq.nextval,?,?,?,?,sysdate,0,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getReviewWriter());
			pstmt.setString(2, r.getReviewTitle());
			pstmt.setInt(3, r.getReviewPoint());
			pstmt.setString(4, r.getReviewCont());
			pstmt.setString(5, r.getReviewFilename1());
			pstmt.setString(6, r.getReviewFilepath1());
			pstmt.setString(7, r.getReviewFilename2());
			pstmt.setString(8, r.getReviewFilepath2());
			pstmt.setString(9, r.getPrdName());
			pstmt.setString(10, r.getPrdSnImg());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			
		}
		
		
		return result;
	}

	public Review reviewOne(Connection conn, int reviewNo) {
		// TODO Auto-generated method stub
		Review r= null;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String query="select * from review where review_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				r= new Review();
				r.setPrdName(rset.getString("prd_name"));
				r.setPrdSnImg(rset.getString("prd_sn_img"));
				r.setReviewCont(rset.getString("review_cont"));
				r.setReviewCount(rset.getInt("review_count"));
				r.setReviewDate(rset.getDate("review_date"));
				r.setReviewFilename1(rset.getString("review_filename1"));
				r.setReviewFilepath1(rset.getString("review_filepath1"));
				r.setReviewFilename2(rset.getString("review_filename2"));
				r.setReviewFilepath2(rset.getString("review_filepath2"));
				r.setReviewNo(rset.getInt("review_no"));
				r.setReviewPoint(rset.getInt("review_point"));
				r.setReviewTitle(rset.getString("review_title"));
				r.setReviewWriter(rset.getString("review_writer"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
		return r;
	}

	public int reviewUpdate(Connection conn, Review r) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query="update review set review_cont=? , review_title=? , review_filename1=?,"
				+ " review_filepath1=?, review_filename2 =? , review_filepath2=? , review_point=? where review_no=?";
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, r.getReviewCont());
			pstmt.setString(2, r.getReviewTitle());
			pstmt.setString(3, r.getReviewFilename1());
			pstmt.setString(4, r.getReviewFilepath1());
			pstmt.setString(5, r.getReviewFilename2());
			pstmt.setString(6, r.getReviewFilepath2());
			pstmt.setInt(7, r.getReviewPoint());
			pstmt.setInt(8, r.getReviewNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int reviewDelete(Connection conn, int reviewNo) {
		// TODO Auto-generated method stub
		int result =0;
		PreparedStatement pstmt = null;
		String query ="delete from review where review_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Review> searchReview(Connection conn,String memberId) {
		// TODO Auto-generated method stub
		ArrayList<Review> list = new ArrayList<Review>();
		Review n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from review where review_writer = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				n = new Review();
				n.setPrdName(rset.getString("prd_name"));
				n.setPrdSnImg(rset.getString("prd_sn_img"));
				n.setReviewCont(rset.getString("review_cont"));
				n.setReviewCount(rset.getInt("review_count"));
				n.setReviewDate(rset.getDate("review_date"));
				n.setReviewFilename1(rset.getString("review_filename1"));
				n.setReviewFilepath1(rset.getString("review_filepath1"));
				n.setReviewFilename2(rset.getString("review_filename2"));
				n.setReviewFilepath2(rset.getString("review_filepath2"));
				n.setReviewNo(rset.getInt("review_no"));
				n.setReviewPoint(rset.getInt("review_point"));
				n.setReviewTitle(rset.getString("review_title"));
				n.setReviewWriter(rset.getString("review_writer"));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	


}
