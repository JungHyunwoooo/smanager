package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = req.getParameter("page");  // 값을 받는 부분
		page = page == null ? "1" : page;
		String sc = req.getParameter("searchCondition"); // 값을 받는 부분
		String kw = req.getParameter("keyword"); // 값을 받는 부분
		String order = req.getParameter("order"); // 값을 받는 부분
		String res = req.getParameter("res");
		
		SearchDTO search = new SearchDTO();
		search.setKeyword(kw);
		search.setPage(Integer.parseInt(page));
		search.setSearchCondition(sc);
		
		MemberService svc = new MemberServiceImpl();
		
		
		// 전체 조회
		List<MemberVO> list = svc.memberCheck(search);
		
		//조회된 값 넘기기
		req.setAttribute("memberList", list);

		// 값 넘기기
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		req.setAttribute("order", order);
		req.setAttribute("res", res);
		
		// paging
		int totalCnt = svc.totalCount(search);
		PageDTO pageDTO = new PageDTO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", pageDTO);
		
		req.getRequestDispatcher("admin/memberList.tiles").forward(req, resp);

	}

}
