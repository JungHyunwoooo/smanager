package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.StudentMapper;
import com.yedam.vo.StudentVO;

@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SampleServlet() {
		super();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 실행.");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 메소드 실행.");
		resp.setContentType("text/html;charset=utf-8"); // 웹브라우저에 출력되는 컨텐트 타입
		PrintWriter out = resp.getWriter(); // 데이터 출력 스트림(웹브라우저 화면)
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		out.print("<b>Hello 한글도처리됨.</b>");
		List<StudentVO> list = mapper.studentList();
		
		for(StudentVO svo : list) {
			out.println("<li><a href='jsp/Student.jsp?sno="+svo.getStdNo()+"'>" + svo.getStdNo() + ", " + svo.getStdName() + "</a></li>");
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy 메소드 실행.");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 서블릿의 생명주기 (init()실행 -> service()실행 -> destroy()실행)
		// 개발자가 실행흐름을 주도하는 것이 아닌, WebApplicationServer가 주도하는 것. = 제어의 역전
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
