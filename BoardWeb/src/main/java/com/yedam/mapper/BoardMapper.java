package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

/*
 글목록, 등록, 수정, 삭제, 단건조회
 기능정의 -> 기능구현(BoardMapper.xml)
 */

public interface BoardMapper {
	List<BoardVO> selectList();
	List<BoardVO> selectListPaging(SearchDTO search); //페이지 정보를 넣어주면 5건씩 출력하는 것
	// 페이징 계산하기 위한 전체건수.
	int selectTotalCount(SearchDTO search);
	int insertBoard(BoardVO board);
	int updateBoard(BoardVO board);
	int deleteBoard(int boardNo);
	BoardVO selectBoard(int boardNo);
}
