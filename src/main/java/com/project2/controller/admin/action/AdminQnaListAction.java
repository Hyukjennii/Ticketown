package com.project2.controller.admin.action;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.project2.controller.action.*;
import com.project2.controller.util.*;
import com.project2.dao.*;
import com.project2.dto.*;

public class AdminQnaListAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "admin/qna/qnaList.jsp";
      
      HttpSession session = request.getSession();
      ManagerVO mvo = (ManagerVO)session.getAttribute("adminUser");
      
      int page  = 1;
      if( mvo == null) { 
         url = "movie.do?command=loginManager"; 
      } else {
         if(request.getParameter("first") != null) {
            session.removeAttribute("page");
            session.removeAttribute("key");
         }
         
         String key ="";
         if(request.getParameter("key") !=null) {
            key = request.getParameter("key");
            session.setAttribute("key", key);
         }else if(session.getAttribute("key")!=null) {
            key = (String)session.getAttribute("key");
         }else {
            session.removeAttribute("key");
            key = "";
         }
         
         if(request.getParameter("page")!=null) {
            page = Integer.parseInt(request.getParameter("page"));
            session.setAttribute("page", page);
         }else if(session.getAttribute("page")!=null){
            page = (int) session.getAttribute("page");
         } else {
            page = 1;
            session.removeAttribute("page");
         }
               
         Paging paging = new Paging();
         paging.setPage(page);
         ManagerDao mdao = ManagerDao.getInstance();
         
          // 총 개시물의 갯수 리턴
         int count = mdao.getAllCount("qna", "subject",key);
         paging.setTotalCount(count);
         
         ArrayList<QnaVO> list = mdao.listQnaAdmin(paging, key);
         request.setAttribute("qnaList", list);
         request.setAttribute("paging", paging);
         request.setAttribute("key", key);      
      }         
      request.getRequestDispatcher(url).forward(request, response);
   }



}