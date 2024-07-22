package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// id, pw 파라미터 => 성공시 게시글 목록으로 or 실패시 로그인 화면으로 이동
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberService svc = new MemberServiceImpl();
		if(svc.loginCheck(id, pw)) {
			// 세션객체(attribute)
			HttpSession session = req.getSession();
			session.setAttribute("logid", id);
			session.setMaxInactiveInterval(30 * 60);
			resp.sendRedirect("boardList.do");
		}else {
			//실패시 메세지 전달 "아이디와 비밀번호를 확인하세요!"
			req.setAttribute("msg", "아이디와 비밀번호를 확인하세요!");
			req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp); // 페이지를 재지정하겠다는 의미
		}
	}

}
