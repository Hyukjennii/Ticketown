package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project2.dao.QnaDao;

public class QnaDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qseq = request.getParameter("qseq");
		QnaDao qdao = QnaDao.getInstance();
		qdao.deleteQna(qseq);
		
		response.sendRedirect("movie.do?command=qnaList");
	}

}
