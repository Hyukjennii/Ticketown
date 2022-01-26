package com.project2.controller;

import com.project2.controller.ActionFactory;
import com.project2.controller.action.*;
import com.project2.controller.admin.action.*;
import com.project2.controller.admin.action.loginManagerAction;
import com.project2.controller.admin.action.loginManagerFormAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory ist = new ActionFactory();
	public static ActionFactory getInstance() {	 return ist;	 }
	
	public Action getAction(String command) {
		Action ac = null;
		
		if (command.equals("main")) ac = new MainAction();
		else if(command.equals("loginForm")) ac = new LoginFormAction();
		else if(command.equals("login")) ac = new LoginAction();
		else if(command.equals("joinForm")) ac = new JoinFormAction();
		else if(command.equals("join")) ac = new JoinAction();
		else if(command.equals("movieDetail")) ac = new MovieDetailAction();
		else if(command.equals("orderForm")) ac = new OrderFormAction();
		else if(command.equals("loginManagerForm")) ac = new loginManagerFormAction();
		else if(command.equals("loginManager")) ac = new loginManagerAction();
		else if(command.equals("idCheckForm")) ac = new IdCheckFormAction();
		else if(command.equals("cinfo")) ac = new CinfoAction();
		else if(command.equals("movieInformation")) ac = new MovieInformationAction();
		else if(command.equals("editMember"))  ac = new EditMemberAction();
		else if(command.equals("memberUpdate")) ac = new MemberUpdateAction();
		else if(command.equals("logout"))	ac= new LogOutAction();
		else if(command.equals("seatSelect")) ac = new SeatSelectAction();
		else if(command.equals("seatSelectComplete")) ac = new SeatSelectCompleteAction();
		else if(command.equals("myPage")) ac = new MyPageAction();
		else if(command.equals("orderList")) ac = new OrderListAction();
		else if(command.equals("orderDelete")) ac = new OrderDeleteAction();
		
		else if(command.equals("qnaList")) ac = new QnaListAction();
		else if(command.equals("qnaWriteForm")) ac = new QnaWriteFormAction();
		else if(command.equals("qnaView")) ac = new QnaViewAction();
		else if(command.equals("qnaWrite")) ac = new QnaWriteAction();
		else if(command.equals("qnaRevise")) ac = new QnaReviseAction();
		else if(command.equals("qnaDelete")) ac = new QnaDeleteAction();
		else if(command.equals("qnaReviseForm")) ac = new QnaReviseFormAction();
		
		else if(command.equals("findIdPwd")) ac = new FindIdPwdAction();
		else if(command.equals("findIdForm")) ac = new FindIdFormAction();
		else if(command.equals("findPwdForm")) ac = new FindPwdFormAction();
		else if(command.equals("findIdStep1")) ac = new FindIdStep1Action();
		else if(command.equals("findIdStep2"))	ac = new FindIdStep2Action();
		else if(command.equals("findPwdForm")) ac = new FindPwdFormAction();
		else if(command.equals("findPwdStep1")) ac = new FindPwdStep1Action();
		else if(command.equals("findPwdStep2")) ac =new FindPwdStep2Action();
		else if(command.equals("resetPwd")) ac = new ResetPwdAction();
		else if(command.equals("deleteMember")) ac = new DeleteMemberAction();
		else if(command.equals("deleteMemberForm")) ac = new DeleteMemberFormAction();
		
		else if(command.equals("adminLogout")) ac = new AdminLogOutAction();	
		else if(command.equals("adminUpdate")) ac = new AdminUpdateAction();
		else if(command.equals("adminEdit")) ac = new AdminEditAction();
		
		else if(command.equals("adminMovieList")) ac = new AdminMovieListAction();
		else if(command.equals("adminMovieWriteForm")) ac = new AdminMovieWriteFormAction();
		else if(command.equals("adminMovieDetail")) ac = new AdminMovieDetailAction();
		else if(command.equals("adminMovieWrite")) ac = new AdminMovieWriteAction();
		else if(command.equals("adminMovie")) ac = new AdminMovieWriteAction();
		else if(command.equals("adminMovieUpdateForm")) ac = new AdminMovieUpdateFormAction();
		else if(command.equals("adminMovieUpdate")) ac = new AdminMovieUpdateAction();
		else if(command.equals("adminMovieDelete")) ac = new AdminMovieDeleteAction();
		else if(command.equals("adminMemberList")) ac = new AdminMemberListAction();
		else if(command.equals("adminQnaList")) ac = new AdminQnaListAction();
		else if(command.equals("adminQnaDetail")) ac = new AdminQnaDetailAction();
		else if(command.equals("adminQnaRepsave")) ac = new AdminQnaRepsaveAction();
		
		else if(command.equals("th_2D")) ac = new Th_2DAction();
		else if(command.equals("th_4DX")) ac = new Th_4DXAction();
		else if(command.equals("th_goldclass")) ac = new Th_GoldclassAction();
		else if(command.equals("th_Imax")) ac = new Th_ImaxAction();
		else if(command.equals("th_premium")) ac = new Th_PremiumAction();
		else if(command.equals("th_starium")) ac = new Th_StariumAction();
		
		return ac;
	}
}