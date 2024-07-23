package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.ActionControl;
import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardForm;
import com.yedam.control.BoardListControl;
import com.yedam.control.DeleteBoardControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginForm;
import com.yedam.control.LogoutControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.RemoveBoardControl;
import com.yedam.control.StudentListControl;
import com.yedam.control.UpdateBoardControl;

/*
 * FrontController 역할은 사용자의 모든 요청을 처리.
 * 서블릿. a.do, sample.do 로 끝나는 모든 요청들은 FrontController로 시작하게 만들기 위함
 * 1.객체생성(class) -> init -> service -> destroy(서버 종료되는 시점 / 생명주기)
 */

public class FrontController extends HttpServlet {
	
	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do", new BoardListControl());
		// 글등록 구현: 등록하는 화면(boardForm.do) + DB에 등록하는 기능(addBoard.do) -> 글목록으로 페이지 이동하는 부분.
		
		map.put("/boardForm.do", new BoardForm());
		map.put("/addBoard.do", new AddBoardControl());
		// 학생목록.
		map.put("/stdList.do", new StudentListControl());
		//게시판 상세
		map.put("/board.do", new BoardControl());
		//게시판 삭제
		map.put("/removeBoard.do", new RemoveBoardControl()); // 삭제 화면 보여주기
		map.put("/deleteBoard.do", new DeleteBoardControl()); // 실제 삭제 처리 기능
		//게시판 수정
		map.put("/modifyBoard.do", new ModifyBoardControl()); // 수정화면 보여주기
		map.put("/updateBoard.do", new UpdateBoardControl()); // 실제 수정 기능
		
		//태그연습
		map.put("/action.do", new ActionControl());
		
		//로그인
		map.put("/loginForm.do", new LoginForm()); // 로그인 화면을 열어주는 기능.
		map.put("/login.do", new LoginControl()); //로그인 기능.
		
		//로그아웃
		map.put("/logout.do", new LogoutControl()); // 로그아웃 기능.
		
		// 관리자가 사용하는 기능들..ex)회원목록
		map.put("/memberList.do", new MemberListControl());
		
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// boardList.do -목록. addBoard.do -등록.
		String uri = req.getRequestURI(); // URL(http://localhost/BoardWeb/boardList.do) vs. URI
		String context = req.getContextPath(); // 프로젝트 명.
		String path = uri.substring(context.length()); // "/boardList.do"

		System.out.println(path); //board.do
		Control sub = map.get(path);
		sub.exec(req, resp);

	}
}// end of class
