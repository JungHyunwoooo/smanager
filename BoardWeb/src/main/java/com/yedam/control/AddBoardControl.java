package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// key=value 값처럼 처리 위한 application/x-www-form-urlencode 방식.
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		String title = req.getParameter("title");
        //파일전송 multipart/form-data 방식. cos라이브러리 방식
        // 1. 파일업로드 (images) 2. DB입력.
        /*
         * 파라미터로 
         * 1. 요청정보(req).
         * 2. 업로드 경로를 String 타입.
         * 3. 업로드가능한 최대 파일 크기.
         * 4. 파일명 해석을 위한 인코딩 방식.
         * 5. 파일명이 중복일 경우 리네임 정책.
         */
        String savePath = req.getServletContext().getRealPath("images");// ServletContext 는 상위 경로
        int maxSize = 1024 * 1024 * 5; // 1MB = 1024 * 1024 / 5MB = 1024 * 1024 * 5
        MultipartRequest request = new MultipartRequest(req, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy());
        writer = request.getParameter("writer");
        content = request.getParameter("content");
        title = request.getParameter("title");
        String image = request.getFilesystemName("img");
		
		BoardVO bvo = new BoardVO();
		bvo.setWriter(writer);
		bvo.setContent(content);
		bvo.setTitle(title);
		bvo.setImage(image);

		BoardService svc = new BoardServiceImpl();
		if (svc.addBoard(bvo)) {
			// 목록이동.
			resp.sendRedirect("boardList.do");
		}
		
	}//end of exec

}//end of class
