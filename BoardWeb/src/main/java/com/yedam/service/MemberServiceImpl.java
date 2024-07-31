package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.StudentMapper;
import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVO;

public class MemberServiceImpl implements MemberService{
	SqlSession sqlSession = //
			DataSource.getInstance().openSession(true);
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

	@Override
	public MemberVO loginCheck(String id, String pw) {
		return mapper.selectMember(id, pw);
	}

	@Override
	public List<MemberVO> memberCheck(SearchDTO search) {
		return mapper.selectListPaging(search);
	}

	@Override
	public int totalCount(SearchDTO search) {
		return mapper.selectTotalCount(search);
	}

	@Override
	public List<StudentVO> studentList() {
		// TODO Auto-generated method stub
		return mapper.studentList();
	}

	@Override
	public boolean removeStudent(String sno) {
		// TODO Auto-generated method stub
		return mapper.deleteStudent(sno) == 1;
	}

	@Override
	public boolean addStudent(StudentVO svo) {
		return mapper.insertStudent(svo) == 1;
	}

	@Override
	public List<Map<String, Object>> getCountByMember() {
		return mapper.selectCountByMember();
	}

}
