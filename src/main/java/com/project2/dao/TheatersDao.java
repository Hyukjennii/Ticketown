package com.project2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project2.controller.util.Dbman;
import com.project2.dto.MovieVO;
import com.project2.dto.TheatersVO;


public class TheatersDao {
	private TheatersDao() {}
	private static TheatersDao ist = new TheatersDao();
	public static TheatersDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public ArrayList<TheatersVO> getTheaters() {
		ArrayList<TheatersVO> list = new ArrayList<TheatersVO>();
		String sql = "select * from theaters";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TheatersVO tvo = new TheatersVO();
				tvo.setCinemas(rs.getString("cinemas"));
				tvo.setSeat(rs.getString("seat"));
				list.add(tvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return list;
	}


	public TheatersVO getOrder(String cinemas) {
		TheatersVO tvo = new TheatersVO();
		String sql = "select * from theaters where cinemas=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cinemas);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tvo.setCinemas(cinemas);
				tvo.setAdult(rs.getInt("adult"));
				tvo.setChild(rs.getInt("child"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return tvo;
	}

	public TheatersVO selectTheaters(String cinemas) {
		TheatersVO tvo = new TheatersVO();
		String sql = "select * from theaters where cinemas=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cinemas);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tvo.setCinemas(cinemas);
				tvo.setAdult(rs.getInt("adult"));
				tvo.setChild(rs.getInt("child"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return tvo;
	}

}
	
