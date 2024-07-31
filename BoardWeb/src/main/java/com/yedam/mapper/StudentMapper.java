package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.common.SearchDTO;
import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVO;

public interface StudentMapper {
	List<StudentVO> studentList();
	StudentVO selectOne(String sno);
	int insertStudent(StudentVO svo);
	int deleteStudent(String sno);
	
	// 로그인체크를 위한 메소드 이름은?
	MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	
	List<MemberVO> selectListPaging(SearchDTO search); //페이지 정보를 넣어주면 5건씩 출력하는 것
	// 페이징 계산하기 위한 전체건수.
	int selectTotalCount(SearchDTO search);
	
	// 차트 (작성자별 건수)
	List<Map<String, Object>> selectCountByMember();
}
