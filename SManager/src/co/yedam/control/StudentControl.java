package co.yedam.control;

import java.util.List;
import java.util.Scanner;

import co.yedam.dao.StudentDAO;
import co.yedam.vo.StudentVO;

/*
 * 사용자입력을 가이드, 처리된 결과를 출력 등등
 */
public class StudentControl {
	Scanner scanner = new Scanner(System.in);
	StudentDAO sdao = new StudentDAO();
	
	public void run() {
		boolean isTrue = true;
		
		while(isTrue) {
			System.out.println("1.학생목록  2.등록  3.수정  4.삭제  5.종료");
			System.out.println("선택> ");
			int menu = Integer.parseInt(scanner.nextLine());
			
			switch(menu) {
			case 1:
				studentList();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("종료합니다.");
				isTrue = false;
			}
		}
	} //end of run
	
	//등록 기능.
	void addStudent() {
		System.out.println(">학생번호 입력.");
		String sno = scanner.nextLine();
		
		System.out.println(">학생 생년월일 입력");
		String stbirth = scanner.nextLine();
		
		System.out.println(">학생 주소 입력");
		String staddr = scanner.nextLine();
		
		System.out.println(">학생이름 입력.");
		String sname = scanner.nextLine();
		
		System.out.println(">학생연락처 입력.");
		String phon = scanner.nextLine();
		
		StudentVO std = new StudentVO();
		std.setStdNo(sno);
		std.setStdName(sname);
		std.setStdPhone(phon);
		std.setAddress(staddr);
		std.setBirthDate(stbirth);
		
		//입력기능 호출.
		if(sdao.insertStudent(std)) {
			System.out.println("저장완료!");
		}else {
			System.out.println("처리 중 예외발생!");
		}
		
	}
	
	
	//목록 출력 기능.
	void studentList() {
		List<StudentVO> students = sdao.selectList();
		System.out.println("학생번호     학생이름     연락처");
		System.out.println("-------------------------------------");
		for(StudentVO svo : students) {
			System.out.println(svo.briefShow());
		}
	}//end of studentList().
}// end class
