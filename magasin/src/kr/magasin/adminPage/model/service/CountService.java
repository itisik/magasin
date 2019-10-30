package kr.magasin.adminPage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.magasin.adminPage.model.dao.CountDao;
import kr.magasin.adminPage.model.vo.Count;
import kr.magasin.common.JDBCTemplate;

public class CountService {
	public static ArrayList<Count> Count() {
		Connection conn = JDBCTemplate.getConnection();
		Count c = new Count();
		ArrayList<Count> list = new ArrayList<Count>();
		CountDao dao = new CountDao();
		
		c = dao.CountNew(conn);
		c = dao.CountShip(conn, c);
		c = dao.CountCom(conn, c);
		c = dao.CountToday(conn, c);
		c = dao.CountWeek(conn, c);
		c = dao.CountQ1(conn, c);
		c = dao.CountQ2(conn, c);
		list = dao.CountCancle(conn, c);
		return list;
	}
	
}
