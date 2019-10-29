package kr.magasin.adminPage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.magasin.adminPage.model.dao.MemberDao;
import kr.magasin.adminPage.model.vo.MemberGrade;
import kr.magasin.common.JDBCTemplate;

public class MemberService {

	public ArrayList<MemberGrade> memberGradeChange(String memberCondition, String memberKeyword) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		
		// ID로 검색
		if(memberCondition.equals("customerId")) {
			MemberGrade mg = dao.MemberGrade1(conn, memberKeyword);
			// id, name, enrollDate, orderDate, grade
			ArrayList<MemberGrade> resultList = dao.MemberGrade2(conn, memberKeyword, mg);
			// tCount, tMoney
			JDBCTemplate.close(conn);
			return resultList;
		} else if (memberCondition.equals("totalMoney")) {
			// 총 구매금액 얼마 이상
			MemberGrade mg = dao.MemberGradeByMoney1(conn, memberKeyword);
			// id, name, enrollDate, orderDate, grade
			ArrayList<MemberGrade> resultList = dao.MemberGradeByMoney2(conn, memberKeyword, mg);
			// tCount, tMoney
			JDBCTemplate.close(conn);
			return resultList;
		} else if(memberCondition.equals("totalCount")) {
			// 총 구매횟수 얼마 이상
			MemberGrade mg = dao.MemberGradeByCount1(conn, memberKeyword);
			// id, name, enrollDate, orderDate, grade
			ArrayList<MemberGrade> resultList = dao.MemberGradeByCount2(conn, memberKeyword, mg);
			// tCount, tMoney
			JDBCTemplate.close(conn);
			return resultList;
		}
		
		return null;
	}

}
