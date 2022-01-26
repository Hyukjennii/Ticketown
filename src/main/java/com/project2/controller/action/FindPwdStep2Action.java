package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project2.dto.MemberVO;



public class FindPwdStep2Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/resetPwd.jsp";
		MemberVO mvo = new MemberVO();
		String confirmNum = request.getParameter("confirmNum");
		mvo.setId( request.getParameter("id") );
		mvo.setName( request.getParameter("name") );
		mvo.setPhone( request.getParameter("phone") );
		
		if(!confirmNum.equals("0000"))
			url = "member/findPwdconfirmNumber.jsp";
		
		request.setAttribute("member",mvo);
		request.getRequestDispatcher(url).forward(request, response);

	}
}


