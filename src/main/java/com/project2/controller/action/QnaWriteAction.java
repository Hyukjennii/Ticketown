package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.dao.QnaDao;
import com.project2.dto.MemberVO;
import com.project2.dto.QnaVO;

public class QnaWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "movie.do?command=qnaList";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		QnaDao qdao = QnaDao.getInstance();
		
		QnaVO qvo = new QnaVO();
		qvo.setCategory(request.getParameter("category"));
		qvo.setSubject(request.getParameter("subject"));
		qvo.setContent(request.getParameter("content"));
		
		qdao.insertQna(qvo, mvo.getId());
		response.sendRedirect(url);
		
		
	}

}
