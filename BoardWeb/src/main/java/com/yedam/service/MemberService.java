package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.MemberVO;

public interface MemberService {
	MemberVO loginCheck(String id, String pw);
	
	List<MemberVO> memberCheck(SearchDTO search);
	int totalCount(SearchDTO search);
}
