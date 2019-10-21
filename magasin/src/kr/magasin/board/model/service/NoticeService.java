package kr.magasin.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.magasin.board.model.dao.NoticeDao;
import kr.magasin.board.model.vo.Notice;
import kr.magasin.common.JDBCTemplate;

public class NoticeService {
	NoticeDao dao = new NoticeDao();
	public ArrayList<Notice> noticeList() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Notice> list = dao.noticeList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

}
