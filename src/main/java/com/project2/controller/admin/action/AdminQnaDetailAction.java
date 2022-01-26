package com.project2.controller.admin.action;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.project2.controller.action.*;
import com.project2.dao.*;
import com.project2.dto.*;

public class AdminQnaDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/qna/qnaDetail.jsp";
		HttpSession session = request.getSession();
		ManagerVO avo = (ManagerVO)session.getAttribute("loginAdmin");
		
		String qseq = request.getParameter("qseq");
		// Qna 하나를 검색하고 리턴 받는 코드
		QnaDao qdao = QnaDao.getInstance();
		QnaVO qvo = qdao.getQna(Integer.parseInt(qseq));
		// 리턴 받은 Qna 를 request 에 저장하는 코드
		request.setAttribute("qnaVO", qvo);
	
		request.getRequestDispatcher(url).forward(request, response);

	}
}
