package com.project2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.dao.QnaDao;
import com.project2.dto.MemberVO;
import com.project2.dto.QnaVO;

public class QnaUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnaVO qvo = new QnaVO();
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		QnaDao qdao = QnaDao.getInstance();
		
		
		//qvo.setCategory(request.getParameter("category"));
		qvo.setSubject(request.getParameter("subject"));
		qvo.setContent(request.getParameter("content"));
		qvo.setId(mvo.getId());
		

		//qdao.updateQna(qvo); 
		HttpSession sessions = request.getSession();
		sessions.setAttribute("qna", qvo);
		RequestDispatcher dispatcher
		= request.getRequestDispatcher("movie.do?command=qnaList");
		dispatcher.forward(request, response);

	}

}
