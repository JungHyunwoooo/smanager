package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) // 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("myName", "정현우");
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList();
		req.setAttribute("boardList", list);
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp")
				.forward(req, resp); // 페이지를 재지정하겠다는 의미
	}


}//end of class
