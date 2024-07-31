package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVO;

public interface MemberService {
	MemberVO loginCheck(String id, String pw);
	
	List<MemberVO> memberCheck(SearchDTO search);
	int totalCount(SearchDTO search);
	
	//학생목록조회.
	List<StudentVO> studentList();
	boolean removeStudent(String sno);
	boolean addStudent(StudentVO svo);
	
	//차트(작성자별 건수)
	List<Map<String, Object>> getCountByMember();
}
