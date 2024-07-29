package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class PagingCount implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 글번호를 하나 던져주면 ? 댓글의 건수를 반환해주는 걸 
		String bno = req.getParameter("bno");
		
		ReplyService svc = new ReplyServiceImpl();
		int totalCnt = svc.replyTotalCnt(Integer.parseInt(bno));
		
		// {"totalCount": 30}
		resp.getWriter().print("{\"totalCount\": " + totalCnt + "}");
	}

}
