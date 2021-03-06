package day6;

import java.util.regex.Pattern;
public class PatternTest {

	public static void main(String[] args) {
		// 정규표현식 전용 문자열
		System.out.println(Pattern.matches("aaa*bbb", "aaacccbbb"));
		/* 전화번호 정의
		 * 1. 010으로 시작
		 * 2. 국번 3-4 자리 번호
		 * 3. 전화 번호 4자리 숫자
		 */
		System.out.println(Pattern.matches("010-[0-9]{3,4}-[0-9]{4}", "010-1234-5678"));
		System.out.println(Pattern.matches("010-[0-9]{3,4}-[0-9]{4}", "012-1234-5678"));
		System.out.println(Pattern.matches("010-[0-9]{3,4}-[0-9]{4}", "010-123-5678"));
		System.out.println(Pattern.matches("010-[0-9]{3,4}-[0-9]{4}", "010-123a-5678"));
		
		System.out.println("-----------------------------");
		/*
		 * 이메일 정의
		 * 알파벳, 숫자, !#$%_ 가능하고 8-10 자리 구성 [a-zA-Z0-9!#$%_]{8,10}
		 * 8-10자리 가능
		 * 중간에 @ 필수
		 * 이메일 서버 - 알파벳, 숫자 가능, 3-10자리 가능 [a-zA-Z0-9]{3,10}
		 * . 필수    <====== \\.
		 * com 혹은 co.kr 혹은 go.kr 만 가능 (com|co.kr|go.kr)
		 */
//		String myemail = "javadosa1!@campus.com";
//		String myemail = "jav@#%ado!@campus.com";
		String myemail = "javadosa1!@campus.net";
		boolean result = Pattern.matches
				("[a-zA-Z0-9!#$%_]{8,10}@[a-zA-Z0-9]{3,10}\\.(com|co.kr|go.kr)",myemail);
		if(result == false) {
			System.out.println("불쌍맨이야");
		}
		
	}

}
