package com.project2.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.project2.controller.action.Action;
import com.project2.dao.MovieDao;
import com.project2.dto.ManagerVO;
import com.project2.dto.MovieVO;

public class AdminMovieUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "admin/movie/movieUpdate.jsp";
		
		HttpSession session = request.getSession();
		ManagerVO avo = (ManagerVO)session.getAttribute("adminUser");
		if( avo == null) { 
			url = "movie.do?command=loginManager"; 
		}else {
			// 전달된 상품번호로 상품상세내역을 조회하고 리퀘스트에 저장합니다
			String movieno = request.getParameter("movieno");
			MovieDao mdao = MovieDao.getInstance();
			MovieVO mvo = mdao.getMovie(movieno);
			request.setAttribute("MovieVO", mvo);
			// 현재 상품의 카테고리(kind)값을 상품 종류로 변환하여 리퀘스트에 저장합니다
			String genreList[] = {"액션", "스릴러", "멜로", "코미디", 
					"공포", "애니메이션", "판타지", "드라마" ," " };    
			request.setAttribute("genreList", genreList);
			int index = Integer.parseInt(mvo.getGenre());
			request.setAttribute("genre", genreList[index]);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}