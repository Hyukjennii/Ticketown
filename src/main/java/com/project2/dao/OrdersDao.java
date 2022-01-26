package com.project2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project2.controller.util.*;
import com.project2.dto.OrdersVO;

public class OrdersDao {
	private OrdersDao() {}
	private static OrdersDao ist = new OrdersDao();
	public static OrdersDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void getOrder(OrdersVO ovo) {
		String sql = "insert into orders(orderno, id, movieno, quantity1, quantity2, seat, movietiome, moviedate, totalprice, orderdate) "
				+ " values(orderno_seq.nextval, ?, ?, ?, ? )";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ovo.getId());
			pstmt.setInt(2, ovo.getMovieno());
			pstmt.setInt(3, ovo.getQuantity1());
			pstmt.setInt(4, ovo.getQuantity2());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}

	public void insertOrder(OrdersVO ovo) {
		String sql = "insert into orders(orderno, id, movieno, quantity1, quantity2, cinemas, seat, movietime, moviedate, totalprice) "
				+ " values(orderno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ovo.getId());
			pstmt.setInt(2, ovo.getMovieno());
			pstmt.setInt(3, ovo.getQuantity1());
			pstmt.setInt(4, ovo.getQuantity2());
			pstmt.setString(5, ovo.getCinemas());
			pstmt.setString(6, ovo.getSeat());
			pstmt.setString(7, ovo.getMovietime());
			pstmt.setString(8, ovo.getMoviedate());
			pstmt.setInt(9, ovo.getTotalprice());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}

	public void deleteOrdersMember(String id) {
		String sql= "delete from orders where id=?";
		
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }	
		
	}

	public ArrayList<OrdersVO> listOrder(String id, Paging paging) {
		ArrayList<OrdersVO> list = new ArrayList<OrdersVO>();
		//String sql = "select * from orders where id=? order by orderno desc";
		
		String sql = "select * from ("
				+ " select * from ("
				+ " select rownum as rn, p.* from "
				+ " ((SELECT ode.orderno, ode.id, ode.movieno,"
				+ " (SELECT title FROM movie WHERE movieno = ode.movieno ) as title,"
				+ " (SELECT image FROM movie WHERE movieno = ode.movieno ) as image,"
				+ "	ode.quantity1, ode.quantity2, ode.cinemas, ode.seat, ode.movietime, ode.moviedate, ode.totalprice,"
				+ "	ode.orderdate FROM orders ode where id=? order by orderno desc) p)"
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
				OrdersVO ovo = new OrdersVO();
				ovo.setCinemas(rs.getString("cinemas"));
				ovo.setId(rs.getString("id"));
				ovo.setMoviedate(rs.getString("moviedate"));
				ovo.setMovieno(rs.getInt("movieno"));
				ovo.setTitle(rs.getString("title"));
				ovo.setMovietime(rs.getString("movietime"));
				ovo.setOrderdate(rs.getTimestamp("orderdate"));
				ovo.setOrderno(rs.getInt("orderno"));
				ovo.setQuantity1(rs.getInt("quantity1"));
				ovo.setQuantity2(rs.getInt("quantity2"));
				ovo.setSeat(rs.getString("seat"));
				ovo.setTotalprice(rs.getInt("totalprice"));
				
				list.add(ovo);
			}
			
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return list;
	}

	public OrdersVO getOrderList(String orderno) {
		OrdersVO ovo = new OrdersVO();
		//String sql = "select * from orders where orderno=?";
		String sql = "SELECT ode.*,"
				+ " (SELECT title FROM movie WHERE movieno = ode.movieno ) as title,"
				+ " (SELECT image FROM movie WHERE movieno = ode.movieno ) as image"
				+ " FROM orders ode where orderno=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, orderno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ovo.setOrderno(Integer.parseInt(orderno));
				ovo.setCinemas(rs.getString("cinemas"));
				ovo.setId(rs.getString("id"));
				ovo.setMoviedate(rs.getString("moviedate"));
				ovo.setMovieno(rs.getInt("movieno"));
				ovo.setMovietime(rs.getString("movietime"));
				ovo.setOrderdate(rs.getTimestamp("orderdate"));
				ovo.setOrderno(rs.getInt("orderno"));
				ovo.setQuantity1(rs.getInt("quantity1"));
				ovo.setQuantity2(rs.getInt("quantity2"));
				ovo.setSeat(rs.getString("seat"));
				ovo.setTotalprice(rs.getInt("totalprice"));
				ovo.setTitle(rs.getString("title"));
				ovo.setImage(rs.getString("image"));
				
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return ovo;
	}

	public void deleteMovie(int movieno) {
		String sql = "delete from orders where movieno=?";
		con = Dbman.getConnection();
		try {
			 pstmt = con.prepareStatement(sql);
			 pstmt.setInt(1, movieno);
		     pstmt.executeUpdate();
			} catch (SQLException e) {e.printStackTrace();
			} finally {Dbman.close(con, pstmt, rs);}	
	
		
		
	}
	
	public void deleteOrder(int orderno) {
		String sql = "delete from orders where orderno=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderno);
			pstmt.executeUpdate();
		} catch (SQLException e) {			e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
			}


}
