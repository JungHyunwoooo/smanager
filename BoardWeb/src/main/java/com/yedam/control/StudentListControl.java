package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
/*
 * POJO (Plain Old Java Object).
 */

public class StudentListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// stdList.do -> 실제 보여줄 페이지는 WEB-INF/jsp/studentList.jsp이다
		try {
			req.getRequestDispatcher("WEB-INF/jsp/studentList.jsp")
						.forward(req, resp); //페이지를 재지정하겠다는 의미
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//end of exec

}//end of class
