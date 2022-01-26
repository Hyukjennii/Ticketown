package com.project2.dao;

import java.sql.*;
import java.util.*;

import com.project2.controller.util.*;
import com.project2.dto.*;

public class ManagerDao {

   private ManagerDao() {
   }

   private static ManagerDao ist = new ManagerDao();

   public static ManagerDao getInstance() {
      return ist;
   }

   Connection con = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;

   public ManagerVO getManager(String id) {
      ManagerVO mvo = null;
      String sql = "select * from workers where id=?";
      con = Dbman.getConnection();
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         if (rs.next()) {
            mvo = new ManagerVO();
            mvo.setId(id);
            mvo.setPwd(rs.getString("pwd"));
            mvo.setName(rs.getString("name"));
            mvo.setEmail(rs.getString("email"));
            mvo.setPhone(rs.getString("phone"));
            mvo.setIndate(rs.getTimestamp("indate"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         Dbman.close(con, pstmt, rs);
      }

      return mvo;
   }

   public void updateManager(ManagerVO mvo) {
      String sql = "Update workers set pwd=?, name=?, email=?, phone=? where id = ?";

      con = Dbman.getConnection();
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, mvo.getPwd());
         pstmt.setString(2, mvo.getName());
         pstmt.setString(3, mvo.getEmail());
         pstmt.setString(4, mvo.getPhone());
         pstmt.setString(5, mvo.getId());
         pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         Dbman.close(con, pstmt, rs);
      }

   }

   public int getAllCount(String tablename, String fieldname,  String key) {
      int count = 0;
      String sql = "select count(*) as cnt from " + tablename + " where "
            + fieldname + " like '%'||?||'%'";
      try {
           con = Dbman.getConnection();
           pstmt = con.prepareStatement(sql); 
           pstmt.setString(1, key);
           rs = pstmt.executeQuery();
           if(rs.next()) count = rs.getInt("cnt");
      } catch (Exception e) { e.printStackTrace();
       } finally { Dbman.close(con, pstmt, rs); } 
      return count;
   }
   

   public ArrayList<QnaVO> listQna(String id, Paging paging) {
      ArrayList<QnaVO> list  = new ArrayList<QnaVO>();
      
      String sql = "select * from ( "
            + " select * from ("
            + " select rownum as rn, p.* from "
            + " ((select * from qna where id=? order by qseq desc) p) "
            + " ) where rn >= ? "
            + " ) where rn <= ? ";
      
      con = Dbman.getConnection();
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, id);
         pstmt.setInt(2,  paging.getStartNum() );
         pstmt.setInt(3, paging.getEndNum() );
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
      } catch (SQLException e) { e.printStackTrace();
      } finally {Dbman.close(con, pstmt, rs);    }
      return list;
   }

   public void updateQna(QnaVO qvo) {
      String sql = "update qna set reply=?, rep='2' where qseq=?";
      try {
         con = Dbman.getConnection();
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, qvo.getReply());
         pstmt.setInt(2,  qvo.getQseq());
         pstmt.executeUpdate();
      } catch (SQLException e) { e.printStackTrace();
      } finally {Dbman.close(con, pstmt, rs);}
      
   }

   public void insertMovie(MovieVO mvo) {
      
      String sql = "insert into movie(movieno, title, director, actor, genre, agegrade, "
            + " playtime, opendate, image, video, useyn, content) values( movie_seq.nextVal, ?,?,?,?,?,?,?,?,?,?,?)";
      con = Dbman.getConnection();
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, mvo.getTitle());      
         pstmt.setString(2, mvo.getDirector());
          pstmt.setString(3, mvo.getActor());
          pstmt.setString(4, mvo.getGenre());
          pstmt.setString(5, mvo.getAgegrade());
          pstmt.setString(6, mvo.getPlaytime()); 
          pstmt.setString(7, mvo.getOpendate());
          pstmt.setString(8, mvo.getImage());
          pstmt.setString(9, mvo.getVideo());
          pstmt.setString(10, mvo.getUseyn());
          pstmt.setString(11, mvo.getContent());
          pstmt.executeUpdate();
      } catch (SQLException e) {   e.printStackTrace();
      } finally { Dbman.close(con, pstmt, rs);    }
   }

      public void updateMovie(MovieVO mvo) {
            String sql = " update movie set title=?, director=?, actor=?, genre=?, "
            + " agegrade=?, playtime=?, opendate=?, image=?, video=?, useyn=?, content=? where movieno=? ";
            con = Dbman.getConnection();
            try {         
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, mvo.getTitle());
                pstmt.setString(2, mvo.getDirector());
                pstmt.setString(3, mvo.getActor());
                pstmt.setString(4, mvo.getGenre());
                pstmt.setString(5, mvo.getAgegrade());
                pstmt.setString(6, mvo.getPlaytime());
                pstmt.setString(7, mvo.getOpendate());
                pstmt.setString(8, mvo.getImage());
                pstmt.setString(9, mvo.getVideo());
                pstmt.setString(10, mvo.getUseyn());
                pstmt.setString(11, mvo.getContent());
                pstmt.setInt(12,mvo.getMovieno());
                pstmt.executeUpdate();
            } catch (SQLException e) {e.printStackTrace();
            } finally { Dbman.close(con, pstmt, rs);}   
         }
      
      public ArrayList<MemberVO> listMember(Paging paging, String key) {
         ArrayList<MemberVO> list = new ArrayList<MemberVO>();
         String sql =" select * from ("
               + " select * from ("
               + " select rownum as rn, p.* from "
               + " ((select * from members where id like '%'||?||'%' "
               + " order by id desc) p) "
               + " )where rn >= ? "
               + " ) where rn <= ? ";
         con = Dbman.getConnection();
         try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, key);
            pstmt.setInt(2,  paging.getStartNum() );
            pstmt.setInt(3,  paging.getEndNum() );
            rs = pstmt.executeQuery();
            while( rs.next() ) {
               MemberVO lvo = new MemberVO();
               lvo.setId(rs.getString("id"));
               lvo.setName(rs.getString("name"));
               lvo.setEmail(rs.getString("email"));
               lvo.setPhone(rs.getString("phone"));
               lvo.setIndate(rs.getTimestamp("indate"));
            
               list.add(lvo);
            }
      } catch (SQLException e) {   e.printStackTrace();
      } finally { Dbman.close(con, pstmt, rs);   }   
         return list;

      }

   public ArrayList<QnaVO> listQnaAdmin(Paging paging, String key) {
      ArrayList<QnaVO> list  = new ArrayList<QnaVO>();
      String sql = "select * from ( "
            + " select * from ("
            + " select rownum as rn, p.* from "
            + " ((select * from qna where id like '%'||?||'%' "
            + " order by qseq desc) p) "
            + " ) where rn >= ? "
            + " ) where rn <= ? ";
      con = Dbman.getConnection();
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, key);
         pstmt.setInt(2,  paging.getStartNum() );
         pstmt.setInt(3, paging.getEndNum() );
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
      } catch (SQLException e) { e.printStackTrace();
      } finally {Dbman.close(con, pstmt, rs);    }
      return list;
   }
   public ArrayList<MovieVO> listMovie(Paging paging, String key) {
      ArrayList<MovieVO> list = new ArrayList<MovieVO>();
      String sql =" select * from ("
            + " select * from ("
            + " select rownum as rn, p.* from "
            + " ((select * from movie where title like '%'||?||'%' "
            + " order by movieno desc) p) "
            + " )where rn >= ? "
            + " ) where rn <= ? ";
      con = Dbman.getConnection();
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, key);
         pstmt.setInt(2,  paging.getStartNum() );
         pstmt.setInt(3,  paging.getEndNum() );
         rs = pstmt.executeQuery();
         while( rs.next() ) {
            MovieVO mvo = new MovieVO();
            mvo.setMovieno(rs.getInt("movieno"));
              mvo.setTitle(rs.getString("title"));
              mvo.setDirector(rs.getString("director"));
              mvo.setActor(rs.getString("actor"));
              mvo.setGenre(rs.getString("genre"));
              mvo.setAgegrade(rs.getString("agegrade"));
              mvo.setPlaytime(rs.getString("playtime"));
              mvo.setOpendate(rs.getString("opendate"));
              mvo.setImage(rs.getString("image"));
              mvo.setVideo(rs.getString("video"));
              mvo.setUseyn(rs.getString("useyn"));
              mvo.setContent(rs.getString("content"));
            list.add(mvo);
         }
   } catch (SQLException e) {   e.printStackTrace();
   } finally { Dbman.close(con, pstmt, rs);   }   
      return list;

   }

}