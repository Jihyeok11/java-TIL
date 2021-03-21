package io;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("정수 1 입력");
		int first = key.nextInt();
		System.out.println("정수 2 입력");
		int second = key.nextInt();
		
		System.out.println(first+second);
		
		System.out.println("한글 문자열 입력");
		String word = key.next();
		System.out.println(word);
		key.nextLine(); // 엔터 치는 순간을 입력받도록 설정
		System.out.println("한글 문자열 입력");
		String words = key.nextLine();
		System.out.println(words);
		
		
	}

}
