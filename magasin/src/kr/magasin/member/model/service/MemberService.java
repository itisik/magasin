package kr.magasin.member.model.service;

import java.sql.Connection;


import kr.magasin.common.JDBCTemplate;
import kr.magasin.member.model.dao.MemberDao;
import kr.magasin.member.model.vo.Member;

public class MemberService {
	public Member login(String id, String pw) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.login(conn,id,pw);
		JDBCTemplate.close(conn);
		return m;
	}
	public Member selectOne(String id) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.selectOne(conn,id);
		JDBCTemplate.close(conn);
		return m;
	}
	
	
	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.insertMember(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	

}
