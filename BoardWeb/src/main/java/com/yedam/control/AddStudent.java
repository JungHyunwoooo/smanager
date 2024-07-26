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
import com.yedam.vo.StudentVO;

public class AddStudent implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=UTF-8");
		String sno = req.getParameter("sno");
		String sname = req.getParameter("sname");
		String phone = req.getParameter("phone");
		
		StudentVO svo = new StudentVO();
		svo.setStdNo(sno);
		svo.setStdName(sname);
		svo.setStdPhone(phone);
		svo.setBirthDate("1999-03-05");
		
		Gson gson = new GsonBuilder().create();
		//gson.toJson(null) //json 문자열로 바꿔주는
		Map<String, Object> map = new HashMap<>();
		
		MemberService svc = new MemberServiceImpl();
		if (svc.addStudent(svo)) {
			map.put("retCode", "Success");
			map.put("retVal", svo);
		}else {
			map.put("retCode", "Fail");
			map.put("retVal", null);
			
		}
		resp.getWriter().print(gson.toJson(map));
	}

}
