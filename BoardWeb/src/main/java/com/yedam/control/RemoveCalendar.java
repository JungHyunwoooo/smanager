package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class RemoveCalendar implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardService svc = new BoardServiceImpl();
		
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
	
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setStart(start);
		bvo.setEnd(end);
		
		Map<String, Object> map = new HashMap<>();
		
		try {
			if (svc.removeCalendar(bvo)) {   
				map.put("retCode", "Success");  //성공했다.
			}
		} catch (Exception e) {
			map.put("retCode", "Fail");  //실패했다.
		}
		// json문자열 생성.
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		
		resp.getWriter().print(json);
		
	} // end of exec

} // end of class
