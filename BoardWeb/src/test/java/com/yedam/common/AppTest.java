package com.yedam.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class AppTest {
	public static void main(String[] args) {
		MemberService svc = new MemberServiceImpl();
		List<Map<String, Object>> list = svc.getCountByMember();
		for(Map<String, Object> map : list) {
			System.out.println("-----------------");
			Set<String> keyset = map.keySet();
			for(String key : keyset) {
				System.out.println(key + ", " + map.get(key));
			}
		}
		System.out.println("- End -");
//		BoardService svc = new BoardServiceImpl();
//		SearchDTO search = new SearchDTO();
//		search.setSearchCondition("TW");
//		search.setKeyword("웹은");
//		search.setPage(1);
		
//		svc.boardList(search).forEach(System.out::println);
		
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
