package com.kh.semi.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.notice.service.NoticeService;
import com.kh.semi.notice.vo.NoticeVo;
@WebServlet(urlPatterns = "/notice/write")
public class NoticeWriteController extends HttpServlet{
	
	// 공지사항 작성 (회면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		boolean isAdmin = loginMember != null && loginMember.getId().equals("aaa");
		
		if(isAdmin) {
			//관리자 일 때, 포워딩
			req.getRequestDispatcher("/views/notice/write.jsp").forward(req, resp);
			
		}else {
			//관리자 아님 -> 에러페이지
			req.setAttribute("msg", "권한이 없습니다.");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
			
		}
		
		
	}
	
	// 공지사항 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		//세션꺼내기
		HttpSession s = req.getSession();
		
		//로그인멤버꺼내기
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		// 데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		// 뭉치기
		NoticeVo vo = new NoticeVo();
		vo.setTitle(title);
		vo.setContent(content);
		
		vo.setWriter(loginMember.getNo());
		
		// 디비
		int result = new NoticeService().write(vo);
		
		// 화면선택
		if(result == 1) {
			// 성공 -> 알림 메세지, 리스트 화면으로 리다이렉트
			s.setAttribute("alertMsg", "공지사항 작성 완료 !");
			resp.sendRedirect("/semi/notice/list");
		}else {
			// 실패 -> 메세지, 에러페이지 포워딩
			req.setAttribute("msg", "공지사항 작성 실패@");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}//doPost
}//class
