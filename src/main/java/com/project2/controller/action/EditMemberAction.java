package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.dto.MemberVO;



public class EditMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		request.setAttribute("member", mvo);

		RequestDispatcher dis=request.getRequestDispatcher("member/updateForm.jsp");
		dis.forward(request, response);

	}

}
