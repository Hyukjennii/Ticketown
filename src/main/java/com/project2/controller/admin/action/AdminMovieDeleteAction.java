package com.project2.controller.admin.action;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.project2.controller.action.*;
import com.project2.dao.*;
import com.project2.dto.*;

public class AdminMovieDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="movie.do?command=adminMovieList";
		HttpSession session = request.getSession();
		ManagerVO avo = (ManagerVO) session.getAttribute("adminUser");
		if(avo==null) {
			url="movie.do?command=loginManager";
		}else{
			int movieno = Integer.parseInt(request.getParameter("movieno"));
			
			System.out.println("movieno->"+movieno);
			MovieDao mdao = MovieDao.getInstance();
			OrdersDao odao = OrdersDao.getInstance();
			
			odao.deleteMovie(movieno);
			mdao.deleteMovie(movieno);
		}
		request.getRequestDispatcher(url).forward(request, response);	}

}
