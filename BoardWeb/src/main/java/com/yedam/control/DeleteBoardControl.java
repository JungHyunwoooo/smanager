package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class DeleteBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceImpl();
		if(svc.removeBoard(Integer.parseInt(bno))) {
			// 삭제가 정상처리 되면 목록으로 이동
			resp.sendRedirect("boardList.do");
		}else {
			//실패하면 삭제페이지로 이동
			resp.sendRedirect("removeBoard.do?bno=" + bno);
		}
		
	}//end of exec

}//end of class
