package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.StudentVO;

public interface StudentMapper {
	// 접근제한자 리턴타입 메소드명(매개변수){.....}
	// 매개변수 : 메소드 밖에서 메소드 안에 실행하기 위에서 필요한 값 전달함.
	// 리턴타입 : 메소드를 실행한 결과가 리턴해줄때 그 타입
	List<StudentVO> studentList();
	// insert, update, delete => 데이터에 변경이 생기는 쿼리, 변경처리된 건수가 반환값으로 지정.
	int insertStudent(StudentVO svo);
	int updateStudent(StudentVO svo); //학생번호를 기준으로 연락처 변경.
	int deleteStudent(StudentVO svo);
}
