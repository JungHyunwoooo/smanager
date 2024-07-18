package com.yedam.common;

import org.apache.ibatis.session.SqlSession;

import com.yedam.mapper.BoardMapper;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AppTest {
	public static void main(String[] args) {
		
		BoardService svc = new BoardServiceImpl();
		svc.boardList().forEach(System.out::println);
		System.out.println("- End -");
		
//		SqlSession sqlSession = //
//				DataSource.getInstance().openSession(true);
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
//		
//		BoardVO brd = new BoardVO();
//		brd.setTitle("매퍼테스트222");
////		brd.setContent("조건이 제대로 되는지2222");
//		brd.setWriter("newbie");
//		brd.setBoardNo(5);
//		
//		System.out.println(mapper.selectBoard(4));
//		
//
//		//보드에 추가하기.
////		if(mapper.insertBoard(brd) == 1) {
////			System.out.println("OK");
////		}
//
////		//보드 수정하기.
////		if(mapper.updateBoard(brd) == 1) {
////			System.out.println("OK");
////		}
////		
//		//보드 삭제하기.
//		if(mapper.deleteBoard(5) == 1) {
//			System.out.println("OK");
//		}
//		
		//전체조회하기.
//		mapper.selectList()//
//				.forEach(board -> System.out.println(board.toString()));
//
//		
//		System.out.println("- End -");
////		mapper.studentList().forEach(student -> {
////			System.out.println(student);
////		});
		
		
		
	}//end of main
}//end of class
