package day1;

public class VariableTest {

	public static void main(String[] args) {
		// int 최대값
		// -2^31 ~ 2^31-1
		/*
		System.out.println(Integer.MAX_VALUE); // 자바 라이브러리 제공 변수
		System.out.println(Integer.MIN_VALUE); // 자바 라이브러리 제공 변수
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		byte a = 100;		
		System.out.println(a);
		*/
		boolean b1 = true;
		System.out.println("b1의 값은 "+b1);
		boolean b2 = 10 > 5;
		System.out.println("10 은 5보다 더 큰가요?" + b2);
		char c1 = 'a';
		System.out.println(c1);
		System.out.println("'" + c1 + "'");
		char c2 = 9;
		System.out.println(c2);
		char c3 = '9';
		System.out.println(c3);
		double d3 = 3.141592;
		int i3 = (int)d3;
		System.out.println(i3);
	}

}
