package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.StudentVO;

public interface StudentMapper {
	List<StudentVO> studentList();
	StudentVO selectOne(String sno);
	int insertStudent(StudentVO svo);
	
	// 로그인체크를 위한 메소드 이름은?
	int selectMember(@Param("id") String id, @Param("pw") String pw);
}
