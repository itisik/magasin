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
					n.setReviewFilename(rset.getString("review_filename"));
					n.setReviewFilepath(rset.getString("review_filepath"));
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
