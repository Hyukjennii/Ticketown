package com.project2.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.project2.controller.action.*;
import com.project2.dto.*;

public class AdminMovieWriteFormAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/movie/movieWrite.jsp";
		HttpSession session = request.getSession();
		ManagerVO avo = (ManagerVO)session.getAttribute("adminUser");
		if( avo == null) { 
			url = "movie.do?command=loginManager"; 
		}else {
			String genreList[] = {"액션", "스릴러", "멜로", "코미디", 
					"공포", "애니메이션", "판타지", "드라마" }; 
			request.setAttribute("genreList", genreList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}

