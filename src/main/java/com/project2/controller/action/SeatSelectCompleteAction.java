package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.dao.MovieDao;
import com.project2.dao.OrdersDao;
import com.project2.dao.TheatersDao;
import com.project2.dto.MemberVO;
import com.project2.dto.MovieVO;
import com.project2.dto.OrdersVO;
import com.project2.dto.TheatersVO;

public class SeatSelectCompleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아직 미완료 레코드 값 조회 및 가져오기!
		String url = "order/orderConfirm.jsp";
		HttpSession session = request.getSession();
		MemberVO mvo1 = (MemberVO)session.getAttribute("loginUser");
		
		if(mvo1==null) {
			url="movie.do?command=login";
		}else {
		
		String movieno = request.getParameter("movieno");
		int quantity1 = Integer.parseInt(request.getParameter("quantity1")) ;
		int quantity2 = Integer.parseInt(request.getParameter("quantity2")) ;
		String time = request.getParameter("time");
		String date = request.getParameter("date");
		String cinemas = request.getParameter("cinemas");
		
		MovieDao mdao = MovieDao.getInstance();
		MovieVO mvo = mdao.getMovie(movieno);
		TheatersDao tdao = TheatersDao.getInstance();
		TheatersVO tvo = new TheatersVO();
		OrdersDao odao = OrdersDao.getInstance();
		OrdersVO ovo = new OrdersVO();
		
		tvo = tdao.getOrder(cinemas);
		int totalprice = (tvo.getAdult()*quantity1) + (tvo.getChild()*quantity2);
		
		ovo.setId(mvo1.getId());
		ovo.setMovieno(Integer.parseInt(request.getParameter("movieno")));
		ovo.setQuantity1(Integer.parseInt(request.getParameter("quantity1")));
		ovo.setQuantity2(Integer.parseInt(request.getParameter("quantity2")));
		ovo.setSeat(request.getParameter("seat"));
		ovo.setCinemas(request.getParameter("cinemas"));
		ovo.setMovietime(request.getParameter("time"));
		ovo.setMoviedate(request.getParameter("date"));
		ovo.setTotalprice(totalprice);
		
		odao.insertOrder(ovo);
		
		request.setAttribute("OrdersVO", ovo);
		request.setAttribute("Quantity1", quantity1);
		request.setAttribute("Quantity2", quantity2);
		request.setAttribute("MovieVO", mvo);
		request.setAttribute("Date", date);
		request.setAttribute("Time", time);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
//		response.sendRedirect();
	}

}
