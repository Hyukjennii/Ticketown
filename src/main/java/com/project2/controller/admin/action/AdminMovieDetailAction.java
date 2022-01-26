package com.project2.controller.admin.action;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.project2.controller.action.*;
import com.project2.dao.*;
import com.project2.dto.*;

public class AdminMovieDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/movie/movieDetail.jsp";
		
		HttpSession session = request.getSession();
		ManagerVO avo = (ManagerVO)session.getAttribute("adminUser");
		if( avo == null) { 
			url = "movie.do?command=loginManager"; 
		} else {
			String movieno = request.getParameter("movieno");
		
			MovieDao mdao = MovieDao.getInstance();
			MovieVO mvo = mdao.getMovie(movieno); 
			
			// 카테고리 별 타이틀을 배열에 저장
			String genreList[] = { "0", "액션", "스릴러", "멜로", "코미디", 
					"공포", "애니메이션", "판타지", "드라마" };   

			int index = Integer.parseInt( mvo.getGenre() ); 
			
			// 추출한 genre 번호로 배열에서 해당 타이틀 추출 & 리퀘스트에  저장
			request.setAttribute("genre", genreList[index]);
			request.setAttribute("MovieVO", mvo);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
