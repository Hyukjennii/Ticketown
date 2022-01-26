package com.project2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project2.controller.util.Paging;
import com.project2.dao.ManagerDao;
import com.project2.dao.QnaDao;
import com.project2.dto.MemberVO;
import com.project2.dto.QnaVO;

public class QnaListAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "qna/qnaList.jsp";
      HttpSession session = request.getSession();
      MemberVO mvo = (MemberVO) session.getAttribute("loginUser");

      int page  = 1;
      if( mvo == null) { 
         url = "movie.do?command=login"; 
      } else {
         if(request.getParameter("page")!=null)
            page = Integer.parseInt(request.getParameter("page"));
         
         Paging paging = new Paging();
         paging.setPage(page);
                  
         ManagerDao mdao = ManagerDao.getInstance();
         
          // 총 개시물의 갯수 리턴
         int count = mdao.getAllCount("qna", "subject", "");
         paging.setTotalCount(count);
         
         ArrayList<QnaVO> list = mdao.listQna(mvo.getId(), paging);
         
         request.setAttribute("qnaList", list);
         request.setAttribute("paging", paging);
      }
      request.getRequestDispatcher(url).forward(request, response);
   }

}