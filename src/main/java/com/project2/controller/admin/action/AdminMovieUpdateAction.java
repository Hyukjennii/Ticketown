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

public class AdminMovieUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "movie.do?command=adminMovieDetail";
		HttpSession session = request.getSession();
		ManagerVO avo = (ManagerVO)session.getAttribute("adminUser");
		if( avo == null) url = "movie.do?command=loginManager"; 
		else {
			MovieVO mvo = new MovieVO();
			ServletContext context = session.getServletContext();
		    String path = context.getRealPath("movie/files");
		    
		    MultipartRequest multi = new MultipartRequest( request, 
		    path,	28*2048*2048, "UTF-8",	new DefaultFileRenamePolicy());
		   
		    mvo.setMovieno(Integer.parseInt( multi.getParameter("movieno")));
		    mvo.setTitle( multi.getParameter("title"));
		    mvo.setDirector( multi.getParameter("director"));
		    mvo.setActor( multi.getParameter("actor"));
		    mvo.setGenre( multi.getParameter("genre"));
		    mvo.setAgegrade( multi.getParameter("agegrade"));
		    mvo.setPlaytime(multi.getParameter("playtime"));
		    mvo.setOpendate(multi.getParameter("opendate"));
		    mvo.setUseyn(multi.getParameter("useyn"));
		    mvo.setContent(multi.getParameter("content"));
		    
		    if(mvo.getUseyn()==null) {
		    	mvo.setUseyn("n");
		    }
		    if(multi.getFilesystemName("image") == null )
		    	mvo.setImage(multi.getParameter("oldImage") );
		    else
		    	mvo.setImage( multi.getFilesystemName("image") );
			
		    if(multi.getFilesystemName("video") == null )
			  mvo.setVideo(multi.getParameter("oldVideo") ); 
			else 
				mvo.setVideo( multi.getFilesystemName("video") );
			 
		    ManagerDao mdao = ManagerDao.getInstance();
		    mdao.updateMovie(mvo);
		    url = url + "&movieno=" + mvo.getMovieno();
		}
		response.sendRedirect(url);
	}
}

