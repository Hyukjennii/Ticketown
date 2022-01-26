package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.dao.MemberDao;
import com.project2.dto.MemberVO;

public class MemberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO mvo = new MemberVO();
		mvo.setId(request.getParameter("id"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setName(request.getParameter("name"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setPhone(request.getParameter("phone"));
		
		MemberDao mdao = MemberDao.getInstance();
		mdao.updateMembers(mvo);   
	    HttpSession session=request.getSession();
	    session.setAttribute("loginUser", mvo); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie.do?command=main");
		dispatcher.forward(request, response);

	}

}
