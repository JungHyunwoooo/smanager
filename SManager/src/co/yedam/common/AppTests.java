package co.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import co.yedam.vo.StudentVO;

public class AppTests {
	// 커넥션
	public static Connection getConn() {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "jsp";
		String pass = "jsp";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("오라클 드라이버 없음.");
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	// 실행 메서드
	public static void main(String[] args) {
		// 1) Oracle JDBC Driver 자바라이브러리.
		// 2) Connection 객체. 세션
		Scanner scanner = new Scanner(System.in);
		
//		System.out.println(">학생번호 입력.");
//		String sno = scanner.nextLine();
//		System.out.println(">학생이름 입력.");
//		String sname = scanner.nextLine();
//		System.out.println(">학생연락처 입력.");
//		String phon = scanner.nextLine();
		
//		addStudent(sno,sname,phon); //입력.
		
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
		
		String stdNo = scanner.nextLine();
		
		StudentVO std = new StudentVO();
		std.setStdNo(sno);
		std.setStdName(sname);
		std.setStdPhone(phon);
		std.setAddress(staddr);
		std.setBirthDate(stbirth);
		
//		modStudent(sno,stbirth,staddr,sname,phon); //입력.
		
		search(); // 목록조회.
		
//		removeStudent(stdNo);
	}
	
	/*
update tbl_student set    birth_date = to_date('1992-10-13', 'yyyy-mm-dd'),std_name = '변경값'
      ,std_phone = '변경값'
      ,address = '경주 20번지' where std_no = 'S2024-02';
*/
	
	//수정기능.
	public static void modStudent(String stdNo, String birthDate, String address, String stdName, String stdPhone) {
		Connection conn = getConn();
		String sql = "UPDATE tbl_student";
		sql += " set    birth_date = to_date('"+birthDate+"', 'yyyy-mm-dd')";
		sql += ",std_name = '"+stdName+"'";
		sql += ",std_phone = '"+stdPhone+"'";
		sql += ",address = '"+address+"'";
		sql += " where std_no = '"+stdNo+"'";
		
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); //insert, update, delete => 처리된 건수를 반환해주는 메소드
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//수정기능2.
	public static void modStu(StudentVO svo) {
		
		Connection conn = getConn();
		String sql = "UPDATE tbl_student";
		sql += " set    std_name = nvl('"+svo.getStdName() + "', std_name)";
		sql += "       ,std_phone = nvl('" + svo.getStdPhone() + "', std_phone)";
		sql += "       ,address = nvl('" + svo.getAddress() + "', address)";
		sql += "       ,birth_date = nvl('" + svo.getBirthDate() + "', birthDate)";
		sql += " where std_no = '"+svo.getStdNo() + "'";
		
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); //insert, update, delete => 처리된 건수를 반환해주는 메소드
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*delete from tbl_student
	where std_no = '2024-04';*/
	
	//삭제기능.
	public static void removeStudent(String stdNo) {
		Connection conn = getConn();
		String sql = "DELETE tbl_student";
		sql += " where std_no = '" + stdNo + "'";
		
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); //insert, update, delete => 처리된 건수를 반환해주는 메소드
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	//입력기능.

	public static void addStudent(String stdNo, String stdName, String phone) {
		Connection conn = getConn();
		String sql = "INSERT into tbl_student (std_no, std_name, std_phone)";
		sql += "values('"+stdNo+"', '"+stdName+"', '"+phone+"')";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); //insert, update, delete => 처리된 건수를 반환해주는 메소드
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 조회기능.
	public static void search() {
		// 조회기능.

		try {
			Connection conn = getConn();
			Statement stmt = conn.createStatement(); // 실행할 쿼리를 넣어주면 쿼리를 해석해서 처리한 결과를 가져온다.
			ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_student order by std_no");
			// [객체1, 객체2, 객체3]
			while (rs.next()) {
				System.out.println(rs.getString("std_no") + ", " + rs.getString("std_name") + ", "
						+ rs.getString("std_phone") + ", " + rs.getString("address"));
			}
			System.out.println("end of data.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 조회기능 끝.
	}
}