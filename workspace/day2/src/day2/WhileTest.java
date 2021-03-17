package day2;

public class WhileTest {

	public static void main(String[] args) {
//		int number = (int)(Math.random() * 50)+1;
//		while(number != 50 && number != 25) {
//			// 25, 50 이 아니면 while 실행
//			System.out.println(number);
//			number = (int)(Math.random() * 50)+1;
		while(true) {
			int number = (int)(Math.random()*50)+1;
			System.out.println(number);
			if(number == 25) {
				break;
			}
		}
		

	}

}
