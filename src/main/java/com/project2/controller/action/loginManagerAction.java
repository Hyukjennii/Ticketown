package com.project2.controller.action;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.project2.dao.*;
import com.project2.dto.*;

public class loginManagerAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="admin/loginManager.jsp";
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		
		ManagerDao mdao = ManagerDao.getInstance();
		ManagerVO mvo = mdao.getManager(id); 
		
		
	    if( mvo == null ) {
	    	request.setAttribute("message", "아이디가 없어요");
	    } else if( mvo.getPwd() == null ) {
	    	request.setAttribute("message", "회원정보 오류. 관리자에게 문의하세요");
	    } else if( !mvo.getPwd().equals(pwd) ) {
	    	request.setAttribute("message", "비밀번호가 틀려요");
	    } else {
	    	HttpSession session=request.getSession();
	    	session.setAttribute("loginUser", mvo);
	    	url="movie.do?command=main";
	    }
	    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

