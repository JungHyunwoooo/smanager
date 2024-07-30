package com.yedam.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriterEx1 {

	public static void main(String[] args) {
		// 기본스트림 - 보조스트림 - 추가적인 기능 수행.
		List<MemberVO> members = new ArrayList<>();
		try {
			FileReader fr = new FileReader("c:/temp/file3.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			String[] strAry = null;
			
			while (true) {
				str = br.readLine(); // 한 라인을 읽는다. 더 이상 읽을 것이 없으면 null로 결과값이 나온다. ex) 101 홍길동 90
				if (str == null) {
					break;
				}
				
				// 파일의 정보를 활용 -> 컬렉션 생성.
				strAry = str.split(" ");
				MemberVO member = new MemberVO();
				member.setMemberNo(Integer.parseInt(strAry[0]));
				member.setMemberName(strAry[1]);
				member.setPoint(Integer.parseInt(strAry[2]));
				members.add(member);

				//System.out.println(str);
			}
			br.close();
			fr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		members.forEach(System.out::println);
		
		System.out.println("완료!!");
	}// end of main

	static void reader1() {
		// Reader(부모) <- FileReader(자식)
		try {
			Reader reader = new FileReader("c:/temp/file2.dat");
			while (true) {
				int read = reader.read();
				if (read == -1)
					break;
				System.out.print(read + " -> " + (char) read); // byte(1byte) char(2byte) short(2byte) int(4byte)
																// long(8byte)
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("완료!!");
	}// end of reader1

	static void writer1() {
		// 문자기반 스트림 Writer <- 상속받는 FileWriter
		Scanner scn = new Scanner(System.in);
		String str = "";
		try {
			Writer writer = new FileWriter("c:/temp/file2.dat");
			while (true) {
				System.out.print("입력>> ");
				str = scn.nextLine();
				if (str.equals("quit")) // str에 quit이라는 말이 나오면
					break; // 종료하겠다.

				writer.write(str + "\n");
			}
			writer.flush();
			writer.close();
			scn.close(); // 리소스 환원
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("완료!!");

	}// end of writer1

}// end of class
