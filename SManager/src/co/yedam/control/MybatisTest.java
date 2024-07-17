package co.yedam.control;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.StudentVO;

public class MybatisTest {

	public static void main(String[] args) {
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession sqlSession = factory.openSession(true); // SqlSession 객체를 얻는 방법.
		// 매퍼인터페이스의 구현. => 구현클래스.
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		//<학생 추가>
		StudentVO student = new StudentVO();
		student.setStdNo("S2024-09");
		student.setStdName("김길중");
		student.setStdPhone("010-1234-5678");
		
		int cnt = mapper.insertStudent(student);
		System.out.println("처리된 건수: " + cnt);
		sqlSession.commit(); // 커밋을 해야 sql에 연동됨. or openSession 괄호 안에 'true' 를 지정해놓으면 자동으로 연동됨.
		
		
		//<학생 수정>
		student = new StudentVO();
		student.setStdPhone("010-1234-7777");
		student.setStdNo("S2024-08");
		cnt = mapper.updateStudent(student);
		System.out.println("처리된 건수: " + cnt);
		
		//<학생 조회>
		List<StudentVO> list = mapper.studentList();
		for(StudentVO svo : list) {
			System.out.println(svo);
		}
		System.out.println("OK");
		
	}//end of main

}//end of class
