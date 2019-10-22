package kr.magasin.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import kr.magasin.board.model.vo.Notice;
import kr.magasin.common.JDBCTemplate;

public class NoticeDao {

	public ArrayList<Notice> noticeList(Connection conn, int start, int end) {
		// TODO Auto-generated method stub
		ArrayList<Notice> list = new ArrayList<Notice>();
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum as rnum, n.*from "
				+ "(select * from notice order by notice_no desc)n)"
				+ " where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				n = new Notice();
				n.setNoticeCont(rset.getString("notice_cont"));
				n.setNoticeCount(rset.getInt("notice_count"));
				n.setNoticeDate(rset.getDate("notice_date"));
				n.setNoticeFilename(rset.getString("notice_filename"));
				n.setNoticeFilepath(rset.getString("notice_filepath"));
				n.setNoticeNo(rset.getInt("notice_no"));
				n.setNoticeTitle(rset.getString("notice_title"));
				n.setNoticeWriter(rset.getString("notice_writer"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int totalCount(Connection conn) {
		int total=0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select count(*) as total from notice";
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

	public Notice noticeOne(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select * from notice where notice_no =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				n = new Notice();
				n.setNoticeCont(rset.getString("notice_cont"));
				n.setNoticeCount(rset.getInt("notice_count"));
				n.setNoticeDate(rset.getDate("notice_date"));
				n.setNoticeFilename(rset.getString("notice_filename"));
				n.setNoticeFilepath(rset.getString("notice_filepath"));
				n.setNoticeNo(rset.getInt("notice_no"));
				n.setNoticeTitle(rset.getString("notice_title"));
				n.setNoticeWriter(rset.getString("notice_writer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
		
		return n;
	}

	public int noticeCountUp(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update notice set notice_count = notice_count+1 where notice_no =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int noticeInsert(Connection conn, Notice n) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into notice values(NOTICE_SEQ.nextval,?,?,?,sysdate,0,null,null)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeWriter());
			pstmt.setString(3, n.getNoticeCont());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int noticeUpdate(Connection conn, Notice n) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update notice set notice_title =? , notice_cont = ? , notice_date = sysdate where notice_no =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeCont());
			pstmt.setInt(3, n.getNoticeNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int noticeDelete(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt =null;
		String query= "delete from notice where notice_no =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}

}
