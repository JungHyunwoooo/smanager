package com.yedam.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * 바이트(1byte), char(2byte) => 객체를 처리하는 보조스트림.
 */

public class ObjectStreamEx1 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/file4.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			List<MemberVO> list = (List<MemberVO>) ois.readObject();
			list.forEach(member -> System.out.println(member));
			
			ois.close();fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("완료!!!");
	}// end of 

	static void writer1() {
		List<MemberVO> members = new ArrayList<>();
		members.add(new MemberVO(101, "김꽃님", 120));
		members.add(new MemberVO(102, "박달님", 110));
		members.add(new MemberVO(103, "이햇님", 105));
		members.add(new MemberVO(104, "최별님", 100));

		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/file4.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// serialize(직렬화) -> deserialize(역직렬화 or 기본화)
			oos.writeObject(members);

			oos.flush();
			oos.close();
			fos.flush();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("완료!!!");
	} // end of writer1
} // end of class
