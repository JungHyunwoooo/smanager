package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) // 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		SearchDTO search = new SearchDTO();
		search.setKeyword(kw);
		search.setPage(Integer.parseInt(page));
		search.setSearchCondition(sc);
		
		// 검색정보 값 넘기기
		req.setAttribute("myName", "정현우");
		
		BoardService svc = new BoardServiceImpl();
		
		// 전체 조회
		List<BoardVO> list = svc.boardList(search); //서비스 - 매퍼
		
		//조회된 값 넘기기
		req.setAttribute("boardList", list);

		// 값 넘기기
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		// paging
		int totalCnt = svc.totalCount(search);
		PageDTO pageDTO = new PageDTO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", pageDTO);
		
		req.getRequestDispatcher("board/boardList.tiles")
				.forward(req, resp); // 페이지를 재지정(이동)하겠다는 의미
	}


}//end of class
