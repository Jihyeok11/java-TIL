package day2;

public class PrimeNumberTest {

	public static void main(String[] args) {
		// 소수 = 1과 자신의 수로만 나누어지는 자연수
		int su = 14;
		int rest = 0;
		for (su=2;su<=30;su++) {
			rest = 0;
			for (int i=2;i<su;i++) {
				
				if (su%i == 0) {
					rest++;
				}
			}
			System.out.print(su+"는");
			if (rest>0) {
				System.out.println("소수가 아닙니다");
			}else {
				System.out.println("소수입니다.");
			}
		}

	}

}
