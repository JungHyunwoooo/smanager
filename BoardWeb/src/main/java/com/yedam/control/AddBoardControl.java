package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		String title = req.getParameter("title");
		BoardVO bvo = new BoardVO();
		bvo.setWriter(writer);
		bvo.setContent(content);
		bvo.setTitle(title);

		BoardService svc = new BoardServiceImpl();
		if (svc.addBoard(bvo)) {
			// 목록이동.
			resp.sendRedirect("boardList.do");
		}
		
	}//end of exec

}//end of class
