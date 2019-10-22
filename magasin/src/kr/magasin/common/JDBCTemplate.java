package kr.magasin.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
  public JDBCTemplate() {
     
  }
  //Connection 객체 생성 메소드
  public static Connection getConnection() {
     Connection conn = null;
     try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MAGASIN", "TEAM3!");
        //자동으로 commit을 지원해주는 기능을 해제
        conn.setAutoCommit(false);
     } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }
     return conn;
  }
  //커넥션 객체 닫는 메소드
  public static void close(Connection conn) {
     try {
        if(conn != null && !conn.isClosed()) {
           conn.close();
        }
     } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }
  }
  //커밋용 메소드
  public static void commit(Connection conn) {
     try {
        if(conn != null && !conn.isClosed()) {
           conn.commit();
        }
     } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }
  }
  //롤백용 메소드
  public static void rollback(Connection conn) {
     try {
        if(conn != null && !conn.isClosed()) {
           conn.rollback();
        }
     } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }
  }
  //stmt, pstmt, rset
  public static void close(Statement stmt) {
     try {
        if(stmt != null && !stmt.isClosed()) {
           stmt.close();
        }
     } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }
  }
  public static void close(ResultSet rset) {
     try {
        if(rset != null && !rset.isClosed()) {
           rset.close();
        }
     } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }
  }

}