package com.project2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project2.dto.MemberVO;
import com.project2.controller.util.Dbman;

public class MemberDao {

	private MemberDao() {
	}

	private static MemberDao ist = new MemberDao();

	public static MemberDao getInstance() {
		return ist;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public MemberVO getMembers(String id) {
		MemberVO mvo = null;
		String sql = "select * from members where id=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mvo = new MemberVO();
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

	public void insertMembers(MemberVO mdto) {
		String sql = "insert into members(id, pwd, name, phone, email) values(?, ?, ?, ?, ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getId());
			pstmt.setString(2, mdto.getPwd());
			pstmt.setString(3, mdto.getName());
			pstmt.setString(4, mdto.getPhone());
			pstmt.setString(5, mdto.getEmail());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
	}

	public int confirmID(String id) {
		int result = 0; 
		String sql = "select * from members where id=?";
		con = Dbman.getConnection();
		try {	
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
		    rs = pstmt.executeQuery();
		    if( rs.next() ) result = 1; 
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		return result;
	}

	public void updateMembers(MemberVO mvo) {
		String sql = "Update members set pwd=?, name=?, email=?, phone=? where id = ?";
		
		con = Dbman.getConnection();
		try {
		      pstmt = con.prepareStatement(sql);      
			  pstmt.setString(1, mvo.getPwd());
			  pstmt.setString(2, mvo.getName());
			  pstmt.setString(3, mvo.getEmail());
			  pstmt.setString(4, mvo.getPhone());
			  pstmt.setString(5, mvo.getId());
			  pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace();
	    } finally { Dbman.close(con, pstmt, rs); }  
		
	}

	public MemberVO confirmPhone(String name, String phone) {
		MemberVO mvo = null;
		String sql = "select * from members where name=? and phone=?";
		con = Dbman.getConnection();
		try {	
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
		    rs = pstmt.executeQuery();
		    if(rs.next()){
		    	mvo = new MemberVO();
		        mvo.setId(rs.getString("id"));
		        mvo.setPwd(rs.getString("pwd"));
		        mvo.setName(rs.getString("name"));
		        mvo.setEmail(rs.getString("email"));
		        mvo.setPhone(rs.getString("phone"));
		        mvo.setIndate(rs.getTimestamp("indate"));
		    } 
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		return mvo;
	}

	public MemberVO confirmIdnamePhone(String id, String name, String phone) {
		MemberVO mvo = null;
		String sql = "select * from members where id=? and name=? and phone=?";
		con = Dbman.getConnection();
		try {	
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  id);
			pstmt.setString(2, name);
			pstmt.setString(3, phone);
		    rs = pstmt.executeQuery();
		    if(rs.next()){
		    	mvo = new MemberVO();
		        mvo.setId(rs.getString("id"));
		        mvo.setPwd(rs.getString("pwd"));
		        mvo.setName(rs.getString("name"));
		        mvo.setEmail(rs.getString("email"));
		        mvo.setPhone(rs.getString("phone"));
		        mvo.setIndate(rs.getTimestamp("indate"));
		    } 
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		return mvo;

	}

	public void resetPwd(MemberVO mvo) {
		String sql = "update members set pwd = ? where id = ?";
		con = Dbman.getConnection();
		try {	
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  mvo.getPwd() );
			pstmt.setString(2, mvo.getId());
		    pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }		
		
	}
	

	public void deleteMember(String id) {
		String sql = "delete from members where id= ?";
						
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }	
	}
}
