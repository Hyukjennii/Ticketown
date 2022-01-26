package com.project2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.dao.MovieDao;
import com.project2.dto.MemberVO;
import com.project2.dto.MovieVO;
import com.project2.dto.TheatersVO;


public class MovieDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "movie/movieDetail.jsp";
		String movieno = request.getParameter("movieno"); // 전달된 movieno 값 소개할 영화 내용
		
		MovieDao mdao = MovieDao.getInstance();
		MovieVO mvo = mdao.getMovie(movieno);
		request.setAttribute("MovieVO", mvo);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
