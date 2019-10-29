package kr.magasin.board.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.magasin.board.model.dao.QnADao;
import kr.magasin.board.model.vo.AEtc;
import kr.magasin.board.model.vo.APrd;
import kr.magasin.board.model.vo.PageData;
import kr.magasin.board.model.vo.QEtc;
import kr.magasin.board.model.vo.QPrd;

import kr.magasin.common.JDBCTemplate;

public class QnAService {
	QnADao dao = new QnADao();
	public PageData qnAList(int reqPage1) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		
		int numberPage = 10;
		int qEtctotalCount = dao.qEtcTotalCount(conn);
		
		int totalPage1 = (qEtctotalCount % numberPage ==0) ? (qEtctotalCount/ numberPage) : (qEtctotalCount/numberPage)+1;
		int start1 = (reqPage1-1)* numberPage +1;
		int end1 = reqPage1*numberPage;
		
		ArrayList<QEtc> qEtcList = dao.qEtcList(conn,start1, end1);
		ArrayList<QPrd> qPrdList = dao.qPrdList(conn);
		ArrayList<AEtc> aEtcList = dao.aEtcList(conn);
		ArrayList<APrd> aPrdList = dao.aPrdList(conn);
		String pageNavi1 = "";
		int pageNaviSize = 5;
		int pageNo1 = ((reqPage1-1) / pageNaviSize) * pageNaviSize + 1;
		
		if(pageNo1!=1) {
			pageNavi1 += "<a class='btn paging-btn' href='/qnaList?reqPage1="+(pageNo1-1)+"'>이전</a>";
		}
		int i= 1;
		while(!(i++>pageNaviSize|| pageNo1>totalPage1)) {
			if(reqPage1 == pageNo1) {
				pageNavi1 += "<span class='selectPage'>"+pageNo1+"</span>";
			}else {
				pageNavi1 += "<a class='btn paging-btn' href='/qnaList?reqPage1="+pageNo1+"'>"+pageNo1+"</a>";
			}
			pageNo1++;
		}
		if(pageNo1 <= totalPage1) {
			pageNavi1 += "<a class='btn paging-btn' href='/qnaList?reqPage1="+pageNo1+ "'>다음</a>";
		}
		
		PageData pd = new PageData(pageNavi1, null,null, qEtcList, aEtcList,qPrdList,aPrdList);
		
		JDBCTemplate.close(conn);

		return pd;
		
	}
	public int qEtcInsert(QEtc q) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.qEtcInsert(conn,q);
		if(result>0) {
			JDBCTemplate.commit(conn);
			
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public int qPrdInsert(QPrd q) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.qPrdInsert(conn,q);
		if(result>0) {
			JDBCTemplate.commit(conn);
			
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public QEtc qEtcOne(int qNo) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		QEtc q = dao.qEtcOne(conn,qNo);
		JDBCTemplate.close(conn);
		return q;
	}
	public QPrd qPrdOne(int qNo) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		QPrd q = dao.qPrdOne(conn,qNo);
		JDBCTemplate.close(conn);
		return q;
	}
	public int aEtcInsert(AEtc a) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.aEtcInsert(conn,a);
		if(result>0) {
			int uIsA = dao.uEtcIsA(conn,a.getaQEtcNoRef());
			if(uIsA>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}else {
			System.out.println("등록 실패");
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public int aPrdInsert(APrd a) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.aPrdInsert(conn,a);
		if(result>0) {
			int uIsA = dao.uPrdIsA(conn,a.getaQPrdNoRef());
			if(uIsA>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}else {
			System.out.println("등록 실패");
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public AEtc aEtcOne(int aNo) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		AEtc a = dao.aEtcOne(conn,aNo);
		JDBCTemplate.close(conn);
		return a;
	}
	public APrd aPrdOne(int aNo) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		APrd a = dao.aPrdOne(conn,aNo);
		JDBCTemplate.close(conn);
		return a;
	}
	public int qEtcDelete(int qNo) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.qEtcDelete(conn, qNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public int qPrdDelete(int qNo) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.qPrdDelete(conn, qNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public int qEtcUpdate(QEtc q) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.qEtcUpdate(conn, q);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public int qPrdUpdate(QPrd q) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.qPrdUpdate(conn, q);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);		
		return result;
	}
	public int aEtcDelete(int aNo) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.aEtcDelete(conn, aNo);
		if(result>0) {
			int qNo = aEtcOne(aNo).getaQEtcNoRef();
			int result2 = dao.qEtcQIsADown(conn, qNo);
			if(result2>0) {
				JDBCTemplate.commit(conn);	
			}
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);		
		return result;
	}
	public int aPrdDelete(int aNo) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.aPrdDelete(conn, aNo);
		if(result>0) {
			int qNo = aPrdOne(aNo).getaQPrdNoRef();
			int result2 = dao.qPrdQIsADown(conn,qNo);
			if(result2>0) {
				JDBCTemplate.commit(conn);	
			}
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);		
		return result;
	}
	public int aEtcUpdate(AEtc a) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.aEtcUpdate(conn, a);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);		
		return result;
	}
	public int aPrdUpdate(APrd a) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.aPrdUpdate(conn, a);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);		
		return result;
	}


}
