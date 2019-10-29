package kr.magasin.adminPage.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.adminPage.model.dao.MemberDao;
import kr.magasin.adminPage.model.vo.MemberGrade;
import kr.magasin.common.JDBCTemplate;

public class MemberService {

	public ArrayList<MemberGrade> memberGradeChange(String memberCondition, String memberKeyword) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		
		System.out.println(memberKeyword);
		// ID로 검색
		if(memberCondition.equals("customerId")) {
			System.out.println("사용자 아이디로 검색하기!");
			MemberGrade list = dao.MemberGrade1(conn, memberKeyword);
			// id, name, enrollDate, orderDate, grade
			ArrayList<MemberGrade> resultList = dao.MemberGrade2(conn, memberKeyword, list);
			// tCount, tMoney
			JDBCTemplate.close(conn);
			return resultList;
			
			
		} else if (memberCondition.equals("customerName")) {
			// 이름으로 검색
		} else if (memberCondition.equals("totalMoney")) {
			// 총 구매금액 얼마 이상
		} else if(memberCondition.equals("totalCount")) {
			// 총 구매횟수 얼마 이상
		}
		
		return null;
	}

}
