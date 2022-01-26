package com.project2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project2.controller.util.*;
import com.project2.dto.MovieVO;

public class MovieDao {
	private MovieDao() {}
	private static MovieDao ist = new MovieDao();
	public static MovieDao getInstance() { 	return ist;	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<MovieVO> MovieList() {
		ArrayList<MovieVO> list = new ArrayList<MovieVO>();
		String sql = "select * from movie";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
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
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return list;
	}

	public ArrayList<MovieVO> detailOrder(String movieno) {
		ArrayList<MovieVO> list = new ArrayList<MovieVO>();
		String sql = "select * from movie where movieno = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  movieno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return list;
	}

	public MovieVO getMovie(String movieno) {
		MovieVO mvo = new MovieVO(); 
		String sql = "select * from movie where movieno=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  movieno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mvo.setMovieno(Integer.parseInt(movieno));
				mvo.setActor(rs.getString("actor"));
				mvo.setDirector(rs.getString("director"));
				mvo.setTitle(rs.getString("title"));
				mvo.setGenre(rs.getString("genre"));
				mvo.setAgegrade(rs.getString("agegrade"));
				mvo.setPlaytime(rs.getString("playtime"));
				mvo.setOpendate(rs.getString("opendate"));
				mvo.setImage(rs.getString("image"));
				mvo.setVideo(rs.getString("video"));
				mvo.setUseyn(rs.getString("useyn"));
    	    	mvo.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return mvo;
	}

	public int getAllCount() {
		int count = 0;
		String sql = "select count(*) as cnt from movie";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())	count = rs.getInt("cnt");
		}catch (SQLException e) { 	e.printStackTrace();
		}finally {	Dbman.close(con, pstmt, rs);	}

		return count;
	}


	public ArrayList<MovieVO> selectAll(Paging paging) {
		ArrayList<MovieVO> list = new ArrayList<MovieVO>();
		String sql = "select * from "
				+ " ( select * from "
				+ " ( select rownum as rn, t.*  from"
				+ " ( select * from movie order by movieno desc ) t  "
				+ " ) where rn >= ? "
				+ " ) where rn <= ? ";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  paging.getStartNum() );
			pstmt.setInt(2,  paging.getEndNum() );
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
	} catch (SQLException e) {	e.printStackTrace();
	} finally { Dbman.close(con, pstmt, rs);	}	
		return list;

	}
	
	public ArrayList<MovieVO> getGenreDrama() {
		ArrayList<MovieVO> list = new ArrayList<MovieVO>();
		String sql = "select * from movie where genre='8'";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MovieVO mvo = new MovieVO();
				mvo.setMovieno(rs.getInt("movieno"));
				mvo.setGenre(rs.getString("genre"));
				mvo.setImage(rs.getString("image"));
				list.add(mvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return list;
	}
	
	public ArrayList<MovieVO> getGenreFantasy() {
		ArrayList<MovieVO> list = new ArrayList<MovieVO>();
		String sql = "select * from movie where genre='7'";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MovieVO mvo = new MovieVO();
				mvo.setMovieno(rs.getInt("movieno"));
				mvo.setGenre(rs.getString("genre"));
				mvo.setImage(rs.getString("image"));
				list.add(mvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return list;
	}
	
	public ArrayList<MovieVO> getGenreAnimation() {
		ArrayList<MovieVO> list = new ArrayList<MovieVO>();
		String sql = "select * from movie where genre='6'";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MovieVO mvo = new MovieVO();
				mvo.setMovieno(rs.getInt("movieno"));
				mvo.setGenre(rs.getString("genre"));
				mvo.setImage(rs.getString("image"));
				list.add(mvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return list;
	}
	
	public ArrayList<MovieVO> getGenreAction() {
		ArrayList<MovieVO> list = new ArrayList<MovieVO>();
		String sql = "select * from movie where genre='1'";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MovieVO mvo = new MovieVO();
				mvo.setMovieno(rs.getInt("movieno"));
				mvo.setGenre(rs.getString("genre"));
				mvo.setImage(rs.getString("image"));
				list.add(mvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return list;
	}
	
	public ArrayList<MovieVO> getGenreComedy() {
		ArrayList<MovieVO> list = new ArrayList<MovieVO>();
		String sql = "select * from movie where genre='4'";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MovieVO mvo = new MovieVO();
				mvo.setMovieno(rs.getInt("movieno"));
				mvo.setGenre(rs.getString("genre"));
				mvo.setImage(rs.getString("image"));
				list.add(mvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return list;
	}
	
	public ArrayList<MovieVO> getGenreThriller() {
		ArrayList<MovieVO> list = new ArrayList<MovieVO>();
		String sql = "select * from movie where genre='2'";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MovieVO mvo = new MovieVO();
				mvo.setMovieno(rs.getInt("movieno"));
				mvo.setGenre(rs.getString("genre"));
				mvo.setImage(rs.getString("image"));
				list.add(mvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return list;
	}
	
	
	
	public MovieVO getGenre(String genre) {
		MovieVO mvo = new MovieVO(); 
		String sql = "select * from movie where genre=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  genre);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mvo.setGenre(genre);
				mvo.setImage(rs.getString("image"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return mvo;
	}

	public void deleteMovie(int movieno) {
		String sql = "delete from movie where movieno=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, movieno);
			pstmt.executeUpdate();
		} catch (SQLException e) {			e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
			}

	public MovieVO getMovieOrder(Integer movieno) {
		MovieVO mvo1 = new MovieVO(); 
		String sql = "select * from movie where movieno=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  movieno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mvo1.setMovieno(movieno);
				mvo1.setActor(rs.getString("actor"));
				mvo1.setDirector(rs.getString("director"));
				mvo1.setTitle(rs.getString("title"));
				mvo1.setGenre(rs.getString("genre"));
				mvo1.setAgegrade(rs.getString("agegrade"));
				mvo1.setPlaytime(rs.getString("playtime"));
				mvo1.setOpendate(rs.getString("opendate"));
				mvo1.setImage(rs.getString("image"));
				mvo1.setVideo(rs.getString("video"));
				mvo1.setUseyn(rs.getString("useyn"));
    	    	mvo1.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return mvo1;
	}


}

