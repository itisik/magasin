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
	public Member selectOne2(String email) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.selectOne2(conn,email);
		JDBCTemplate.close(conn);
		return m;
	}
	public Member searchId(String name, String email) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.searchId(conn,name,email);
		JDBCTemplate.close(conn);
		return m;
	}
	public Member searchId2(String name, String phone) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.searchId2(conn,name,phone);
		JDBCTemplate.close(conn);
		return m;
	}

	public Member searchPw(String name, String id, String email) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.searchPw(conn,name,id,email);
		JDBCTemplate.close(conn);
		return m;
	}
	public Member searchPw2(String name, String id, String phone) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.searchPw2(conn,name,id,phone);
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
	

	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.updateMember(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;	
	}
	public int delete(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result  = dao.delete(conn, memberId);
		JDBCTemplate.close(conn);
		return result;
	}



}
