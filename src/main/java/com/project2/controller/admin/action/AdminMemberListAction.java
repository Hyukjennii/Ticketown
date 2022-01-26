package com.project2.controller.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.controller.action.Action;
import com.project2.controller.util.Paging;
import com.project2.dao.ManagerDao;
import com.project2.dao.MemberDao;
import com.project2.dto.ManagerVO;
import com.project2.dto.MemberVO;

public class AdminMemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="admin/memberList.jsp";
		
		HttpSession session = request.getSession();
		ManagerVO id = (ManagerVO)session.getAttribute("adminUser");
		
		int page=1; 
		
		if( id == null) { 
			url = "movie.do?command=loginManager"; 
		}else {
			if( request.getParameter("first") != null ) {
				session.removeAttribute("page");
				session.removeAttribute("key");
			}
			String key="";
			if( request.getParameter("key") != null ) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			} else if( session.getAttribute("key")!= null ) {
				key = (String)session.getAttribute("key");
			} else {
				session.removeAttribute("key");
				key = "";
				
			}
			
			if( request.getParameter("page") != null ) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if( session.getAttribute("page")!= null ) {
				page = (int) session.getAttribute("page");
			} else {
				page = 1;
				session.removeAttribute("page");
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			ManagerDao mdao = ManagerDao.getInstance();
			
			int count = mdao.getAllCount("members","id", key);
			
			paging.setTotalCount(count);
			
			ArrayList<MemberVO> memberList = mdao.listMember(paging, key);
			request.setAttribute("memberList", memberList);	
			request.setAttribute("paging", paging);
			request.setAttribute("key", key);		
			}
			request.getRequestDispatcher(url).forward(request, response);
		}

	}