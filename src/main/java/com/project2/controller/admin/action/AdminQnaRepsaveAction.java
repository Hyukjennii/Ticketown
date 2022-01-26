package com.project2.controller.admin.action;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.project2.controller.action.*;
import com.project2.dao.*;
import com.project2.dto.*;

public class AdminQnaRepsaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "movie.do?command=adminQnaDetail";
		HttpSession session = request.getSession();
		ManagerVO avo = (ManagerVO)session.getAttribute("loginAdmin");
	
		ManagerDao mdao = ManagerDao.getInstance();
		QnaVO qvo = new QnaVO();
		qvo.setQseq(Integer.parseInt(request.getParameter("qseq")));
		qvo.setReply(request.getParameter("reply"));
		// 답글저장 및 답글상태 변경('1'->'2')
		mdao.updateQna(qvo);
		// 원래 보던 Qna 페이지로 이동
		url = url + "&qseq=" + request.getParameter("qseq");
		
		response.sendRedirect(url);
	}

}
