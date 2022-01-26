package com.project2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.dao.MovieDao;
import com.project2.dao.TheatersDao;
import com.project2.dto.MemberVO;
import com.project2.dto.MovieVO;
import com.project2.dto.TheatersVO;

public class OrderFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "order/orderForm.jsp";
		String movieno = request.getParameter("movieno"); // 전달된 movieno 값
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		if (mvo == null) {
		      url = "movie.do?command=loginForm";
		      session.removeAttribute("adminUser");
		}else {
			MovieDao mdao = MovieDao.getInstance();
			MovieVO ordermovie = mdao.getMovie(movieno);
			TheatersDao tdao = TheatersDao.getInstance(); 
			ArrayList<TheatersVO> theaterslist = tdao.getTheaters();
			request.setAttribute("MovieVO", ordermovie);
			request.setAttribute("TheatersList", theaterslist);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
