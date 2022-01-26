package com.project2.controller.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.controller.action.*;
import com.project2.dao.ManagerDao;
import com.project2.dto.ManagerVO;

public class AdminUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ManagerVO mvo = new ManagerVO();
		mvo.setId(request.getParameter("id"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setName(request.getParameter("name"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setPhone(request.getParameter("phone"));
		
		ManagerDao mdao = ManagerDao.getInstance();
		mdao.updateManager(mvo);   
	    HttpSession session=request.getSession();
	    session.setAttribute("adminUser", mvo); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie.do?command=main");
		dispatcher.forward(request, response);


	}

}
