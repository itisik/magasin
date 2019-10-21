package kr.magasin.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.board.model.vo.Notice;
import kr.magasin.common.JDBCTemplate;

public class NoticeDao {

	public ArrayList<Notice> noticeList(Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<Notice> list = new ArrayList<Notice>();
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from notice order by notice_no desc ";
		try {
			pstmt = conn.prepareStatement(query);
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

}
