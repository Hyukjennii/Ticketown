package com.project2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project2.dao.MovieDao;
import com.project2.dto.MovieVO;

public class MovieInformationAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="movie/information.jsp";
		// String[] Genre = {"드라마", "판타지", "애니메이션", "스릴러", "코미디"};
		
		MovieDao mdao = MovieDao.getInstance();
		ArrayList<MovieVO> list = mdao.MovieList();
		ArrayList<MovieVO> listDrama = mdao.getGenreDrama();
		ArrayList<MovieVO> listFantasy = mdao.getGenreFantasy();
		ArrayList<MovieVO> listAnimation = mdao.getGenreAnimation();
		ArrayList<MovieVO> listAction = mdao.getGenreAction();
		ArrayList<MovieVO> listThriller = mdao.getGenreThriller();
		ArrayList<MovieVO> listComedy = mdao.getGenreComedy();
		
		
		
		request.setAttribute("MovieVO", list);
		request.setAttribute("Drama", listDrama);
		request.setAttribute("Fantasy", listFantasy);
		request.setAttribute("Animation", listAnimation);
		request.setAttribute("Action", listAction);
		request.setAttribute("Thriller", listThriller);
		request.setAttribute("Comedy", listComedy);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
