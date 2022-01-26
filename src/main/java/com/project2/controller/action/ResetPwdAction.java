package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project2.dao.MemberDao;
import com.project2.dto.MemberVO;



public class ResetPwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO mvo = new MemberVO();
		mvo.setId( request.getParameter("id"));
		mvo.setPwd( request.getParameter("pwd"));
		
		MemberDao mdao = MemberDao.getInstance();
		mdao.resetPwd(mvo);
		
		String url = "member/resetPwdComplete.jsp";
		request.getRequestDispatcher(url).forward(request, response);

	}

}
