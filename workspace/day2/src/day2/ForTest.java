package day2;

public class ForTest {

	public static void main(String[] args) {
		
		
		int sum = 0;
		int i = 0;
		for (i=1; i<=10; i++) {
			if (i==5) {
				continue;
			}
//			System.out.println(i);
			sum = sum + i;
			System.out.println(i+"까지의 정수 총합 = "+sum);
		}
		System.out.println(i-1 +"까지 구할수 있었다");
		
		// 학생 10명 자바시험 ==> 1~100 10개 정수 만들기
		
//		for (int i=1; i<= 10; i++) {
//			int a = (int)(1+ Math.random()*100);
//			System.out.println(a);	
//		}
	}
}
