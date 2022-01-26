package com.project2.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.dao.OrdersDao;
import com.project2.dto.MemberVO;
import com.project2.dto.OrdersVO;

public class OrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "order/orderList.jsp";

		
		String orderno = request.getParameter("orderno");
		
		OrdersDao odao = OrdersDao.getInstance();
		OrdersVO ovo = odao.getOrderList(orderno);
		
		request.setAttribute("OrdersVO", ovo);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
