package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.dao.MemberDao;
import com.project2.dao.OrdersDao;
import com.project2.dao.QnaDao;
import com.project2.dto.MemberVO;



public class DeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(); // 세션 가져옴
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser"); // 세션에 있는 로그인정보를 MemberVO에 담음

		String pwd = request.getParameter("pwd");
		
		
		System.out.println("세션에 있는 id > " + mvo.getId());
		System.out.println("세션에 있는 pw > " + mvo.getPwd());
		System.out.println("탈퇴페이지에서 보낸 pw > " + request.getParameter("pwd"));
		
		String url = null;
		
		
		if( mvo.getPwd().equals(pwd)) {
			MemberDao mdao = MemberDao.getInstance();
			QnaDao qdao = QnaDao.getInstance();
			OrdersDao odao = OrdersDao.getInstance();
			
		
			qdao.deleteQnaMember(mvo.getId());
			odao.deleteOrdersMember(mvo.getId());
			mdao.deleteMember(mvo.getId());
			
			session.removeAttribute("loginUser");
			
			request.setAttribute("deleteAttr", "Y");
			
			
		}else {
			
			request.setAttribute("errorMessage", "비밀번호가 맞지않습니다");
		}
		
		url = "member/deleteMemberForm.jsp";
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);

	}

}
