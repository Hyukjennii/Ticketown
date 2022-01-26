package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project2.dto.MemberVO;
import com.project2.dao.MemberDao;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO mdto = new MemberVO();
		mdto.setId(request.getParameter("id"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setName(request.getParameter("name"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setEmail(request.getParameter("email"));
		
		MemberDao mdao = MemberDao.getInstance();
		mdao.insertMembers(mdto);
		
		response.sendRedirect("movie.do?command=loginForm");
	}


	}


