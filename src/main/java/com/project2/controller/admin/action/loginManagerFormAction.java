package com.project2.controller.admin.action;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.project2.controller.action.*;

public class loginManagerFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="admin/loginManager.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
