package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> selectList(int boardNo); //댓글조회
	List<ReplyVO> selectListPaging(SearchDTO search); //원본 글 번호, 페이지 정보.
	int insertReply(ReplyVO rvo); //댓글등록
	int deleteReply(int replyNo); //댓글삭제
	//댓글 페이징.
	int totalReplyCnt(int boardNo); // 글번호 댓글 개수.
}
