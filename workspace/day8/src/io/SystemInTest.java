package io;

import java.io.IOException;
import java.io.InputStream;

public class SystemInTest {

	public static void main(String[] args) {
		System.out.println("키보드 입력을 시작하세요");
		
		// 0이 입력될 때 까지 입력을 계속 해라
//		System.in.read(); // 0을 입력하면 48, 1을 입력하면 49
//		while(true) {
//			try {
//				int result = System.in.read(); // in의 하위클래스 중에서 read()는 오버라이딩 되어 사용
//				System.out.println((char)result);
//				if ( result== 13/* 혹은 '\n' */) { // 13은 엔터키
//					break;
//				}
//				// if (result == -1) {break} // ctrl + z를 입력할때 종료
//			} catch(IOException e) {
//				e.printStackTrace();
//			}
//		}
		try {
			
			InputStream is = System.in;
			byte b[] = new byte[100] ;
			
			int cnt = is.read(b); // 키보드 1바이트 입력 b에 배열 저장, cnt는 입력 갯수
			String inputString = new String(b, 0, cnt); // 자바에서의 String은 한 문자를 2바이트 저장하는 특징
			
			System.out.println(inputString);

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

// 한글 입력 - 2바이트 ==> ??