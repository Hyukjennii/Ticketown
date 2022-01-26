package com.project2.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project2.controller.action.Action;
import com.project2.dao.ManagerDao;
import com.project2.dto.ManagerVO;
import com.project2.dto.MovieVO;

public class AdminMovieWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "movie.do?command=adminMovieList";
		HttpSession session = request.getSession();
		
		ManagerVO avo = (ManagerVO)session.getAttribute("adminUser");
		if( avo == null) { 
			url = "movie.do?command=loginManager"; 
		} else {
		
			ServletContext context = session.getServletContext();	
			String uploadFilePath = context.getRealPath("movie/files");
	
			MultipartRequest multi = new MultipartRequest(
					request, uploadFilePath, 28*2048*2048,  "UTF-8",
					 new DefaultFileRenamePolicy() );

			MovieVO mvo = new MovieVO();
			mvo.setTitle(multi.getParameter("title"));
			mvo.setDirector(multi.getParameter("director"));
			mvo.setActor(multi.getParameter("actor"));
			mvo.setGenre(multi.getParameter("genre"));
			mvo.setAgegrade(multi.getParameter("agegrade"));
			mvo.setPlaytime(multi.getParameter("playtime"));
			mvo.setOpendate(multi.getParameter("opendate"));
			mvo.setImage(multi.getFilesystemName("image"));
			mvo.setVideo(multi.getFilesystemName("video"));
			mvo.setUseyn(multi.getParameter("useyn"));
			mvo.setContent(multi.getParameter("content"));
			
			
			
			
			ManagerDao mdao = ManagerDao.getInstance();
			mdao.insertMovie(mvo);	
		}
		response.sendRedirect(url);
	}

}

	