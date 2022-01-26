package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.dto.MemberVO;
import com.project2.dto.QnaVO;

public class QnaEditFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		// QnaVO qvo = (QnaVO)session.getAttribute("qseq");
		String qseq = request.getParameter("qseq");
		String id = mvo.getId();
		
		request.setAttribute("qna", qseq);
		request.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("qna/updateForm.jsp");
		rd.forward(request, response);
		
	}

}
