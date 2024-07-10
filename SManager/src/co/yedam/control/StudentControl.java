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

		while (isTrue) {
			System.out.println("1.학생목록  2.등록  3.수정  4.삭제  5.종료");
			System.out.println("선택> ");
			int menu = Integer.parseInt(scanner.nextLine());

			switch (menu) {
			case 1:
				studentList();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				modifyStudent();
				break;
			case 4:
				removeStudent();
				break;
			case 5:
				System.out.println("종료합니다.");
				isTrue = false;
			}
		}
	} // end of run

	// 삭제 기능.
	void removeStudent() {
		System.out.println("삭제할 학생번호>   [예) 'S2024-00']");
		String sno = scanner.nextLine();
		if (sdao.removeStudent(sno) == 1) {
			System.out.println("삭제완료!");
		} else {
			System.out.println("삭제처리 중 문제발생!");
		}
		
	}//end of removeStudent

	// 수정 기능.
	void modifyStudent() {
		String sno = ""; // 블럭레벨 변수.
		while (true) {
			System.out.println("변경할 학생번호>   [예) 'S2024-00']");
			sno = scanner.nextLine();
			if (sdao.selectExists(sno) == 1) {
				// 학생번호 존재한다는 의미.
				break;
			}
			System.out.println("찾는 학생번호가 없음 학생번호 다시 입력>");
		}

		System.out.println("변경할 연락처>");
		String phon = scanner.nextLine();
		
		System.out.println("변경할 주소>");
		String staddr = scanner.nextLine();
		
		StudentVO std = new StudentVO();
		std.setStdNo(sno);
		std.setStdPhone(phon);
		std.setAddress(staddr);
//		std.setStdName(sname);
//		std.setBirthDate(stbirth);

		if (sdao.updateStudent(std)) {
			System.out.println("수정완료!");
		}

	}

	// 등록 기능.
	void addStudent() {
		System.out.println(">학생번호 입력.   [예) 'S2024-00']");
		String sno = scanner.nextLine();

		System.out.println(">학생 생년월일 입력.   [예) '2024-00-00']");
		String stbirth = scanner.nextLine();

		System.out.println(">학생 주소 입력.");
		String staddr = scanner.nextLine();

		System.out.println(">학생이름 입력.");
		String sname = scanner.nextLine();

		System.out.println(">학생연락처 입력.   [예) '000-0000-0000']");
		String phon = scanner.nextLine();

		StudentVO std = new StudentVO();
		std.setStdNo(sno);
		std.setStdName(sname);
		std.setStdPhone(phon);
		std.setAddress(staddr);
		std.setBirthDate(stbirth);

		// 입력기능 호출.
		if (sdao.insertStudent(std)) {
			System.out.println("저장완료!");
		} else {
			System.out.println("처리 중 예외발생!");
		}

	}

	// 목록 출력 기능.
	void studentList() {
		List<StudentVO> students = sdao.selectList();
		System.out.println("학생번호     학생이름     연락처");
		System.out.println("-------------------------------------");
		for (StudentVO svo : students) {
			System.out.println(svo.briefShow());
		}
	}// end of studentList().
}// end class
