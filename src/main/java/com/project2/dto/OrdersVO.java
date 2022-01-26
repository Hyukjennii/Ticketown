package com.project2.dto;

import java.sql.Timestamp;

public class OrdersVO {
	private Integer orderno;
	private String id;
	private Integer movieno;
	private Integer quantity1;
	private Integer quantity2;
	private String cinemas;
	private String seat;
	private String movietime;
	private String moviedate;
	private Integer totalprice;
	private Timestamp orderdate;
	private String title;
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCinemas() {
		return cinemas;
	}
	public void setCinemas(String cinemas) {
		this.cinemas = cinemas;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getMovietime() {
		return movietime;
	}
	public void setMovietime(String movietime) {
		this.movietime = movietime;
	}
	public String getMoviedate() {
		return moviedate;
	}
	public void setMoviedate(String moviedate) {
		this.moviedate = moviedate;
	}
	public Integer getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}
	public Integer getOrderno() {
		return orderno;
	}
	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}
	public Integer getMovieno() {
		return movieno;
	}
	public void setMovieno(Integer movieno) {
		this.movieno = movieno;
	}
	public Integer getQuantity1() {
		return quantity1;
	}
	public void setQuantity1(Integer quantity1) {
		this.quantity1 = quantity1;
	}
	public Integer getQuantity2() {
		return quantity2;
	}
	public void setQuantity2(Integer quantity2) {
		this.quantity2 = quantity2;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}
}
