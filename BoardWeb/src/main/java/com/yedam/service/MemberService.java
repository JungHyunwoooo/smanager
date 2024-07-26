package com.yedam.service;

import java.util.List;

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
}
