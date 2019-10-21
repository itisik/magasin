package kr.magasin.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		return list;
	}

	public int totalCount(Connection conn) {
		// TODO Auto-generated method stub
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

}
