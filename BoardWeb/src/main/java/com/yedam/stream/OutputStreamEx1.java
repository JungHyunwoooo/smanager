package com.yedam.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OutputStreamEx1 {
	public static void main(String[] args) {
		// 읽고 쓰기 (복사)
		try {
			InputStream is = new FileInputStream("c:/temp/origin.jpg");
			OutputStream os = new FileOutputStream("c:/temp/copy2.jpg");
			int read = -1;
			byte[] buf = new byte[100];
			while (true) {
				read = is.read(buf); // 1바이트씩 읽어서 느리다. 'buf'를 넣으면 한 번에 100바이트씩 읽는다.
				if (read == -1) {
					break; // 더 이상 읽을 파일 정보가 없으면 반복문을 종료하겠다는 의미
				}
				os.write(buf);
			}
			os.flush();
			os.close();
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("완료!!");
	}// end of main

	static void read1() {
		// 입력스트림도 상위에 InputStream이 존재한다. <- FileInputStream
		try {
			InputStream is = new FileInputStream("c:/temp/file1.dat");
			while (true) {
				int r = is.read(); // 1바이트씩 읽기 : 읽은 바이트를 반환 / 끝부분에서 -1을 반환.
				if (r == -1) {
					break;
				}
				System.out.println(r);
			}
			is.close(); // 반환해준다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("완료!");
	} // end of read1

	static void write1() {
		// 출력스트림 상위에 OutputStream이 존재한다. <- FileOutputStream
		try {
			OutputStream os = new FileOutputStream("c:/temp/file1.dat");
			// 10, 20, 30, 숫자 쓰기
			os.write(10);
			os.write(20);
			os.write(30);
			os.flush(); // 버퍼에 남아있는 것들을 지우겠다는 의미
			os.close(); // 리소스 환원
		} catch (IOException e) { // 읽고 쓰는 IO 발생
			e.printStackTrace();
		}
		System.out.println("완료!");
	}// end of write1
}
