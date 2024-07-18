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
import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardForm;
import com.yedam.control.BoardListControl;
import com.yedam.control.StudentListControl;

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
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// boardList.do -목록. addBoard.do -등록.
		String uri = req.getRequestURI(); // URL(http://localhost/BoardWeb/boardList.do) vs. URI
		String context = req.getContextPath(); // 프로젝트 명.
		String path = uri.substring(context.length()); // "/boardList.do"

		System.out.println(path);
		Control sub = map.get(path);
		sub.exec(req, resp);

	}
}// end of class
