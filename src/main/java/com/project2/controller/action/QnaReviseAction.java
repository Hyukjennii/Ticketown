package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.dao.QnaDao;
import com.project2.dto.MemberVO;
import com.project2.dto.QnaVO;

public class QnaReviseAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String url = "movie.do?command=qnaList";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		QnaVO qvo = new QnaVO();
		QnaDao qdao = QnaDao.getInstance();
		

		int qseq = Integer.parseInt(request.getParameter("qseq"));
		qvo.setSubject(request.getParameter("subject"));
		qvo.setContent(request.getParameter("content"));
		qvo.setCategory(request.getParameter("category"));
		
		qdao.reviseQna(qvo, qseq);
		
		response.sendRedirect(url);
		*/
		String url="movie.do?command=qnaList";
		QnaVO qvo = new QnaVO();
		qvo.setQseq(Integer.parseInt(request.getParameter("qseq")));
		qvo.setSubject(request.getParameter("subject"));
		qvo.setContent(request.getParameter("content"));
		qvo.setCategory(request.getParameter("category"));
		QnaDao qdao = QnaDao.getInstance();
		qdao.reviseQna(qvo);
		response.sendRedirect(url);
	}

}
