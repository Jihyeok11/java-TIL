package day3;

public class InputTest {

	public static void main(String[] args) {
		// main2(); // 다른 main2()를 만들어서 사용할려면 이런식으로 한다.
		/* 
		 * Run - Run configurations... - Arguments - Program Arguments 영역에 자바 program 과정 을 입력하면 args가 아래처럼 변경된다
		 * args = new String[3]
		 * args[0] = "자바";
		 * args[0] = "program";
		 * args[0] = "과정";
		 * 위처럼 입력이 된다.
		 * 
		 * 만약 String이 아니라 int로 바꾸고 싶으면
		 * public static void main(int[] args){ 로 변경해주면 된다.
		 */
		for (int i=0;i<args.length;i++) {
			System.out.println(args[i]);
		}
		int first = Integer.parseInt(args[0]);
		int second = Integer.parseInt(args[1]);
		int third = Integer.parseInt(args[2]);
		System.out.println(first+second+third);
//		Integer.parseInt("100"); ==> 100이라는 정수로 변환
		
		double d = Double.parseDouble(args[0]+args[1]+args[2]);
		System.out.println(d);
	}
//	public static void main2() { // 얘는 이클립스에서 실행하지 못한다
//		System.out.println("main2");
//	}

}
// run
// 이클랩스를 일반적으로 실행하면
// run InputTest ===> run InputTest.main()을 실행하도록 설계되어 있다.
// main 메소드를 entry point method 라고 한다.