package day2;

public class StarTest {

	public static void main(String[] args) {
		// TODO 5*5 사각형 모양 * 출력
		
//		for (int j=1; j<=5; j++) {
//			for (int i=1;i<=5;i++) {
//				System.out.print("*");
//				if (i==j) {
//					System.out.println();
//					break;
//				}
//			}
//		}
		/////
//		char c = 'a';
////		System.out.println((char)(++c));
//		for(int i=1; i<=5; i++) {
//			for(int j=1; j<=i; j++) {
//				System.out.print((char)(c));
//				c++;
//				if (i==j) {
//					break;
//				}
//			}
//			System.out.println();
//		}
		
		// 강사님 코드
		char c='a';
		System.out.println((char)('a'+1)); // 'a'에 1을 더하면 int형으로 자동 형변환
		for(int i=1; i<=5; i++) {
			for(int j=c; j<c+i; j++) {
				System.out.print((char)j);
			}
			c = (char)(c+i);
			System.out.println();
		}
	}
}
