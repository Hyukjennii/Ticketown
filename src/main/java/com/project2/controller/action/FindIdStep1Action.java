package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project2.dao.MemberDao;
import com.project2.dto.MemberVO;



public class FindIdStep1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDao mdao = MemberDao.getInstance();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		MemberVO mvo = mdao.confirmPhone(name, phone);

		String url = "member/findIdconfirmNumber.jsp";
		
		if( mvo == null ) {
			request.setAttribute("msg", "이름과 번화번호가 일치하는 회원이 없습니다");
			request.setAttribute("name", name);
			request.setAttribute("phone", phone);
			url = "member/findIdForm.jsp";
		}
		request.setAttribute("member", mvo);
		request.getRequestDispatcher(url).forward(request, response);
	}

	}


