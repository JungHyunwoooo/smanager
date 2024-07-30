package com.yedam.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferStreamEx1 {
	public static void main(String[] args) {
		//기본스트림 -> 버퍼스트림
		try {
			FileInputStream fis = new FileInputStream("c:/temp/vscode.exe");
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			FileOutputStream fos = new FileOutputStream("c:/temp/vscopy3.exe");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			byte[] buf = new byte[10];
			int read = -1;
			
			while(true) {
				read = fis.read(buf); //버퍼의 크기만큼 읽기.
				read = bis.read();
				if(read == -1)
					break;
			fos.write(buf); // 버퍼의 크기만큼 쓰기.
			bos.write(read);
			}
			bos.flush();bos.close();fos.flush();fos.close();
			bis.close();fis.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("완료!!");
	}// end of main

}// end of class
