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
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class RemoveReplyCotrol implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReplyService svc = new ReplyServiceImpl();
		// retCode: Success, retVal: ReplyVO
		// retCode: Fail, retVal: null
		String rvo = req.getParameter("rvo");  //변수선언
		Map<String, Object> map = new HashMap<>();

		try {
			if (svc.removeReply(Integer.parseInt(rvo))) {   //받는 값이 문자라서 int로 바꿔줘야 한다.
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

}// end of class
