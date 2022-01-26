package com.project2.controller.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.controller.action.*;
import com.project2.dto.ManagerVO;


public class AdminEditAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		ManagerVO mvo = (ManagerVO)session.getAttribute("adminUser");
		request.setAttribute("adminUser", mvo);

		RequestDispatcher dis=request.getRequestDispatcher("admin/UpdateManager.jsp");
		dis.forward(request, response);

	}

	}

