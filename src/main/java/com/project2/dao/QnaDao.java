package com.project2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project2.controller.util.Dbman;
import com.project2.dto.QnaVO;


public class QnaDao {
   private QnaDao() { }
   private static QnaDao ist = new QnaDao();
   public static QnaDao getInstance() {    return ist;   }
   
   Connection con = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   
   
   public ArrayList<QnaVO> listQna(String id) {
      ArrayList<QnaVO> list = new ArrayList<QnaVO>();
      String sql = "select * from qna where id=? order by qseq desc";
      con = Dbman.getConnection();
      try {
         pstmt = con.prepareStatement(sql   );
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         while(rs.next()) {
            QnaVO qvo = new QnaVO();
            qvo.setQseq(rs.getInt("qseq"));
             qvo.setSubject(rs.getString("subject"));
             qvo.setContent(rs.getString("content"));
             qvo.setId(rs.getString("id"));
             qvo.setIndate(rs.getTimestamp("indate"));
             qvo.setReply(rs.getString("reply"));
             qvo.setRep(rs.getString("rep"));             
             list.add(qvo);
         }
      } catch (SQLException e) {e.printStackTrace();
      } finally {Dbman.close(con, pstmt, rs);}
      return list;
   }
   
   public QnaVO getQna(int qseq) {
      QnaVO qvo = new QnaVO();
      String sql = "select * from qna where qseq=?";
      con = Dbman.getConnection();
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, qseq);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            qvo.setQseq(qseq);
            qvo.setSubject(rs.getString("subject"));
            qvo.setContent(rs.getString("content"));
            qvo.setId(rs.getString("id"));
            qvo.setIndate(rs.getTimestamp("indate"));
            qvo.setReply(rs.getString("reply"));
            qvo.setRep(rs.getString("rep"));
         }
      } catch (SQLException e) {e.printStackTrace();
      } finally {Dbman.close(con, pstmt, rs);}
      return qvo;
      
   }

   public void insertQna(QnaVO qvo, String id) {
      String sql = "insert into qna (qseq, category, subject, content, id) "
            + "values(qna_seq.nextval, ?, ?, ?, ?)";
      con = Dbman.getConnection();
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, qvo.getCategory());
         pstmt.setString(2, qvo.getSubject());
         pstmt.setString(3, qvo.getContent());
         pstmt.setString(4, id);
         pstmt.executeUpdate();
      } catch (SQLException e) {e.printStackTrace();
      } finally {Dbman.close(con, pstmt, rs);}
      
      
      
   }

   public void deleteQna(String qseq) {
      String sql = "delete from qna where qseq=?";
      con = Dbman.getConnection();
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, Integer.parseInt(qseq));
         pstmt.executeUpdate();
      } catch (SQLException e) {e.printStackTrace();
      } finally {Dbman.close(con, pstmt, rs);}
      
   }
   
   
   public void reviseQna(QnaVO qvo) {
      String sql = "update qna set subject=?, category=?, content=? where qseq=?";
      con = Dbman.getConnection();
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, qvo.getSubject());
         pstmt.setString(2, qvo.getCategory());
         pstmt.setString(3, qvo.getContent());
         pstmt.setInt(4, qvo.getQseq());
         pstmt.executeUpdate();
      } catch (SQLException e) {e.printStackTrace();
      } finally {Dbman.close(con, pstmt, rs);}
   }
   
   public void deleteQnaMember(String id) {
      String sql ="delete from qna where id=? ";
      
      con = Dbman.getConnection();
      try {
         pstmt= con.prepareStatement(sql);
         pstmt.setString(1, id);
         pstmt.executeUpdate();
      } catch (SQLException e) { e.printStackTrace();
      } finally { Dbman.close(con, pstmt, rs);  }   
      
   }
   

}