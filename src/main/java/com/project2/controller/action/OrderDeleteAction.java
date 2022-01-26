package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.dao.OrdersDao;
import com.project2.dto.MemberVO;


public class OrderDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="movie.do?command=myPage";
		HttpSession session = request.getSession();
		MemberVO avo = (MemberVO) session.getAttribute("loginUser");
		if(avo==null) {
			url="movie.do?command=login";
		}else{
			int orderno = Integer.parseInt(request.getParameter("orderno"));
			
			System.out.println("orderno->"+orderno);
			OrdersDao odao = OrdersDao.getInstance();
			
			odao.deleteOrder(orderno);
		}
		request.getRequestDispatcher(url).forward(request, response);	
	}
}
