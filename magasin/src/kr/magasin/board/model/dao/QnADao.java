package kr.magasin.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.magasin.board.model.vo.AEtc;
import kr.magasin.board.model.vo.APrd;
import kr.magasin.board.model.vo.QEtc;
import kr.magasin.board.model.vo.QPrd;
import kr.magasin.common.JDBCTemplate;

public class QnADao {

	public int qEtcTotalCount(Connection conn) {
		// TODO Auto-generated method stubint total=0;
		int qTotal=0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select count(*) as total from q_etc ";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				qTotal = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
		return qTotal;
	}
	public ArrayList<QEtc> qEtcList(Connection conn, int start, int end) {
		// TODO Auto-generated method stub
		ArrayList<QEtc> qList = new ArrayList<QEtc>();
		QEtc q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum as rnum, q.*from (select * from q_etc order by q_no desc)q) where rnum between ? and ?";
				
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				q = new QEtc();
				q.setqCont(rset.getString("q_cont"));
				q.setqCtgr(rset.getString("q_ctgr"));
				q.setqDate(rset.getDate("q_date"));
				q.setqFilename(rset.getString("q_filename"));
				q.setqFilepath(rset.getString("q_filepath"));
				q.setqIsA(rset.getInt("q_is_a"));
				q.setqNo(rset.getInt("q_no"));
				q.setqTitle(rset.getString("q_title"));
				q.setqWriter(rset.getString("q_writer"));
				qList.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return qList;
	}

	public ArrayList<QPrd> qPrdList(Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<QPrd> qList = new ArrayList<QPrd>();
		QPrd q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from q_prd order by q_no desc";
				
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				q = new QPrd();
				q.setPrdName(rset.getString("prd_name"));
				q.setPrdSnImg(rset.getString("prd_sn_img"));
				q.setqCont(rset.getString("q_cont"));
				q.setqCtgr(rset.getString("q_ctgr"));
				q.setqDate(rset.getDate("q_date"));
				q.setqFilename(rset.getString("q_filename"));
				q.setqFilepath(rset.getString("q_filepath"));
				q.setqIsA(rset.getInt("q_is_a"));
				q.setqNo(rset.getInt("q_no"));
				q.setqTitle(rset.getString("q_title"));
				q.setqWriter(rset.getString("q_writer"));
				qList.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return qList;
	}

	public ArrayList<AEtc> aEtcList(Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<AEtc> aList = new ArrayList<AEtc>();
		AEtc a = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from a_etc ";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				a = new AEtc();
				a.setaCont(rset.getString("a_cont"));
				a.setaDate(rset.getDate("a_date"));
				a.setaNo(rset.getInt("a_no"));
				a.setaQEtcNoRef(rset.getInt("a_etc_q_no_ref"));
				a.setaTitle(rset.getString("a_title"));
				aList.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
				
		return aList;
	}

	public ArrayList<APrd> aPrdList(Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<APrd> aList = new ArrayList<APrd>();
		APrd a = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from a_prd";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				a = new APrd();
				a.setaCont(rset.getString("a_cont"));
				a.setaDate(rset.getDate("a_date"));
				a.setaNo(rset.getInt("a_no"));
				a.setaQPrdNoRef(rset.getInt("a_prd_q_no_ref"));
				a.setaTitle(rset.getString("a_title"));
				aList.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
				
		return aList;
	}
	public int qEtcInsert(Connection conn, QEtc q) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query =  "insert into q_etc values(q_etc_seq.nextval,?,?,?,?,sysdate,default,null,null)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, q.getqCtgr());
			pstmt.setString(2, q.getqTitle());
			pstmt.setString(3, q.getqWriter());
			pstmt.setString(4, q.getqCont());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public int qPrdInsert(Connection conn, QPrd q) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query =  "insert into q_prd values(q_prd_seq.nextval,?,?,?,?,sysdate,default,null,null,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, q.getqCtgr());
			pstmt.setString(2, q.getqTitle());
			pstmt.setString(3, q.getqWriter());
			pstmt.setString(4, q.getqCont());
			pstmt.setString(5, q.getPrdName());
			pstmt.setString(6, q.getPrdSnImg());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public QEtc qEtcOne(Connection conn, int qNo) {
		// TODO Auto-generated method stub
		QEtc q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select * from q_etc where q_no =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				q = new QEtc();
				q.setqCont(rset.getString("q_cont"));
				q.setqCtgr(rset.getString("q_ctgr"));
				q.setqDate(rset.getDate("q_date"));
				q.setqIsA(rset.getInt("q_is_a"));
				q.setqNo(rset.getInt("q_no"));
				q.setqTitle(rset.getString("q_title"));
				q.setqWriter(rset.getString("q_writer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return q;
	}
	public QPrd qPrdOne(Connection conn, int qNo) {
		// TODO Auto-generated method stub
		QPrd q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select * from q_Prd where q_no =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				q = new QPrd();
				q.setqCont(rset.getString("q_cont"));
				q.setqCtgr(rset.getString("q_ctgr"));
				q.setqDate(rset.getDate("q_date"));
				q.setqIsA(rset.getInt("q_is_a"));
				q.setqNo(rset.getInt("q_no"));
				q.setqTitle(rset.getString("q_title"));
				q.setqWriter(rset.getString("q_writer"));
				q.setPrdName(rset.getString("prd_name"));
				q.setPrdSnImg(rset.getString("prd_sn_img"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return q;
	}
	/*public ArrayList<Question> qList(Connection conn, int start, int end) {
		// TODO Auto-generated method stub
		ArrayList<Question> qList = new ArrayList<Question>();
		Question q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum as rnum, q.*from (select * from q order by q_ctgr desc)q) where rnum between ? and ? order by q_no desc";
				
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				q = new Question();
				q.setPrdName(rset.getString("prd_name"));
				q.setPrdSnImg(rset.getString("prd_sn_img"));
				q.setqCont(rset.getString("q_cont"));
				q.setqCtgr(rset.getString("q_ctgr"));
				q.setqDate(rset.getDate("q_date"));
				q.setqFilename(rset.getString("q_filename"));
				q.setqFilepath(rset.getString("q_filepath"));
				q.setqIsA(rset.getInt("q_is_a"));
				q.setqNo(rset.getInt("q_no"));
				q.setqTitle(rset.getString("q_title"));
				q.setqWriter(rset.getString("q_writer"));
				qList.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return qList;
	}

	public ArrayList<Answer> aList(Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<Answer> aList = new ArrayList<Answer>();
		Answer a = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from a ";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				a = new Answer();
				a.setaCont(rset.getString("a_cont"));
				a.setaDate(rset.getDate("a_date"));
				a.setaNo(rset.getInt("a_no"));
				a.setaQNoRef(rset.getInt("a_q_no_ref"));
				a.setaTitle(rset.getString("a_title"));
				aList.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
				
		return aList;
	}*/

	public int aEtcInsert(Connection conn, AEtc a) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query="insert into a_etc values(a_etc_seq.nextval,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, a.getaQEtcNoRef());
			pstmt.setString(2, a.getaTitle());
			pstmt.setString(3, a.getaCont());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public int aPrdInsert(Connection conn, APrd a) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query="insert into a_prd values(a_prd_seq.nextval,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, a.getaQPrdNoRef());
			pstmt.setString(2, a.getaTitle());
			pstmt.setString(3, a.getaCont());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public int uEtcIsA(Connection conn, int aEtcQNoRef) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query="update q_etc set q_is_a=1 where q_no =?" ;
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, aEtcQNoRef);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int uPrdIsA(Connection conn, int aPrdQNoRef) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query="update q_prd set q_is_a=1 where q_no =?" ;
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, aPrdQNoRef);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public AEtc aEtcOne(Connection conn, int aNo) {
		// TODO Auto-generated method stub
		AEtc a =null;
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		String query = "select * from a_etc where a_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, aNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				a = new AEtc();
				a.setaCont(rset.getString("a_cont"));
				a.setaDate(rset.getDate("a_date"));
				a.setaNo(rset.getInt("a_no"));
				a.setaQEtcNoRef(rset.getInt("a_etc_q_no_ref"));
				a.setaTitle(rset.getString("a_title"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	public APrd aPrdOne(Connection conn, int aNo) {
		// TODO Auto-generated method stub
		APrd a =null;
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		String query = "select * from a_prd where a_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, aNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				a = new APrd();
				a.setaCont(rset.getString("a_cont"));
				a.setaDate(rset.getDate("a_date"));
				a.setaNo(rset.getInt("a_no"));
				a.setaQPrdNoRef(rset.getInt("a_prd_q_no_ref"));
				a.setaTitle(rset.getString("a_title"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	public int qEtcDelete(Connection conn, int qNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt=null;
		String query = "delete from q_etc where q_no =?";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, qNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public int qPrdDelete(Connection conn, int qNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt=null;
		String query = "delete from q_Prd where q_no =?";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, qNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public int qEtcUpdate(Connection conn, QEtc q) {
		// TODO Auto-generated method stub
		int result =0;
		PreparedStatement pstmt = null;
		String query = "update q_etc set q_title = ? , q_cont =? , q_ctgr = ? where q_no =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, q.getqTitle());
			pstmt.setString(2, q.getqCont());
			pstmt.setString(3, q.getqCtgr());
			pstmt.setInt(4,q.getqNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}
	public int qPrdUpdate(Connection conn, QPrd q) {
		// TODO Auto-generated method stub
		int result =0;
		PreparedStatement pstmt = null;
		String query = "update q_prd set q_title = ? , q_cont =? , q_ctgr = ? where q_no =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, q.getqTitle());
			pstmt.setString(2, q.getqCont());
			pstmt.setString(3, q.getqCtgr());
			pstmt.setInt(4,q.getqNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public int aEtcDelete(Connection conn, int aNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from a_etc where a_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, aNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public int aPrdDelete(Connection conn, int aNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from a_prd where a_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, aNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public int qEtcQIsADown(Connection conn,int qNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update q_etc set q_is_a=0 where q_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int qPrdQIsADown(Connection conn,int qNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update q_prd set q_is_a=0 where q_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int aEtcUpdate(Connection conn, AEtc a) {
		// TODO Auto-generated method stub
		int result =0;
		PreparedStatement pstmt = null;
		String query="update a_etc set a_Title=? , a_Cont =? where a_no =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, a.getaTitle());
			pstmt.setString(2, a.getaCont());
			pstmt.setInt(3, a.getaNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result ;
	}
	public int aPrdUpdate(Connection conn, APrd a) {
		// TODO Auto-generated method stub
		int result =0;
		PreparedStatement pstmt = null;
		String query="update a_prd set a_Title=? , a_Cont =? where a_no =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, a.getaTitle());
			pstmt.setString(2, a.getaCont());
			pstmt.setInt(3, a.getaNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result ;
	}
	public ArrayList<QEtc> searchQEtc(Connection conn, String memberId) {
		// TODO Auto-generated method stub
		ArrayList<QEtc> list = new ArrayList<QEtc>();
		QEtc q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select * from q_etc where q_writer =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				q = new QEtc();
				q.setqCont(rset.getString("q_cont"));
				q.setqCtgr(rset.getString("q_ctgr"));
				q.setqDate(rset.getDate("q_date"));
				q.setqIsA(rset.getInt("q_is_a"));
				q.setqNo(rset.getInt("q_no"));
				q.setqTitle(rset.getString("q_title"));
				q.setqWriter(rset.getString("q_writer"));
				list.add(q);
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
	public ArrayList<QPrd> searchQPrd(Connection conn, String memberId) {
		// TODO Auto-generated method stub
		ArrayList<QPrd> list = new ArrayList<QPrd>();
		QPrd q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select * from q_prd where q_writer =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				q = new QPrd();
				q.setqCont(rset.getString("q_cont"));
				q.setqCtgr(rset.getString("q_ctgr"));
				q.setqDate(rset.getDate("q_date"));
				q.setqIsA(rset.getInt("q_is_a"));
				q.setqNo(rset.getInt("q_no"));
				q.setqTitle(rset.getString("q_title"));
				q.setqWriter(rset.getString("q_writer"));
				q.setPrdName(rset.getString("prd_name"));
				q.setPrdSnImg(rset.getString("prd_sn_img"));
				list.add(q);
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
