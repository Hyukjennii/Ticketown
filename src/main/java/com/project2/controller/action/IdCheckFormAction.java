package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project2.dao.MemberDao;



public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		System.out.println(id);
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.confirmID(id);
		
		request.setAttribute("result", result);
		request.setAttribute("id", id);
		
		RequestDispatcher dispatcher 
			=request.getRequestDispatcher("member/idCheck.jsp");
		dispatcher.forward(request, response);
	}

	}


