package day2;

public class NullTest {

	public static void main(String[] args) {
		String s1 = "asd";
		System.out.println(s1);
		if (s1!=null) {
		System.out.println(s1.toUpperCase());
		}
		//char - 1개 문자 = '단일문자', String - "여러문자묶
		String sa = "java";
		String sb = "java";
		String sc = new String("java");
		String sd = new String("java");
		
		sa = "python";
		
		if (sa==sb) {
			System.out.println("sa == sb 이다.");
		}
		if (sc==sb) {
			System.out.println("sb == sc 이다.");
		}
		if (sc==sd) {
			System.out.println("sc == sd 이다.");
		}
		// 참조형 변수 == 동등성을 비교 (실제 내용을 비교한는 것이 아니라 참조하는 주소값을 비교)
		// 참조형 변수의 문자열내용을 비교할 때에는 String.equals() 를 사용
		
		if (sa.equals(sb)) {
			System.out.println("sa == sb 이다.");
		}
		if (sc.equals(sb)) {
			System.out.println("sb == sc 이다.");
		}
		if (sc.equals(sd)) {
			System.out.println("sc == sd 이다.");
		}
		
		int i = 10;
		double d = 10.0;
		if (i==d) {
			System.out.println("진짜다");
		}
	}

}
