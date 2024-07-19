package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class UpdateBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		BoardVO mvo = new BoardVO();
		mvo.setBoardNo(Integer.parseInt(bno));
		mvo.setTitle(title);
		mvo.setContent(content);
		
		
		BoardService svc = new BoardServiceImpl();
		if(svc.modifyBoard(mvo)) {
			// 수정 정상처리 되면 목록으로 이동
			resp.sendRedirect("boardList.do");
		}else {
			//실패하면 수정페이지로 이동
			resp.sendRedirect("modifyBoard.do?bno=" + bno);
		}
	}

}
