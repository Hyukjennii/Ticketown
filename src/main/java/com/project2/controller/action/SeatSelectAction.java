package com.project2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project2.dao.MovieDao;
import com.project2.dao.OrdersDao;
import com.project2.dao.TheatersDao;
import com.project2.dto.MovieVO;
import com.project2.dto.TheatersVO;

public class SeatSelectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "order/seatSelect.jsp";
		String movieno = request.getParameter("movieno"); // 선택영화
		String cinemas = request.getParameter("cinemas"); // 특별관
		String date = request.getParameter("date"); // 선택날짜
		String time = request.getParameter("time"); // 선택시간
		
		int quantity1 = Integer.parseInt(request.getParameter("quantity1")); // 성인수량
		int quantity2 = Integer.parseInt(request.getParameter("quantity2")); // 소인수량
		
		OrdersDao odao = OrdersDao.getInstance();
		MovieDao mdao = MovieDao.getInstance();
		MovieVO mvo = mdao.getMovie(movieno);
		TheatersDao tdao = TheatersDao.getInstance();  
		TheatersVO selectTheaters = tdao.selectTheaters(cinemas);
		
		int totalprice = (selectTheaters.getAdult()*quantity1) + (selectTheaters.getChild()*quantity2);
		
		request.setAttribute("MovieVO", mvo);
		request.setAttribute("TheatersVO", selectTheaters);
		request.setAttribute("Time", time);
		request.setAttribute("Date", date);
		request.setAttribute("Quantity1", quantity1);
		request.setAttribute("Quantity2", quantity2);
		request.setAttribute("Totalprice", totalprice);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
