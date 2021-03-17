package day5;

public class CheckedExceptionTest {

	public static void main(String[] args) {
		// forname("A")은 A라는 클래스가 있는지 물어보는 api
		try {
//			Class.forName("A"); // A라는 클래스는 없다
			Class.forName("day5.CheckedExceptionTest");  // class가 있으니까 catch 미실행
		} catch(ClassNotFoundException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		//args[0] 값을 정수로 변경해서 0보타 큰지 확인하여 만족하면 정상 사용
		//만약 0보다 작거나 같으면 인우적으로 NumberFormatException(숫자 형태가 아닐 때 나오는 에러) 발생
		int su = Integer.parseInt("-100");
		
		if (su<=0) {
			throw new NumberFormatException("소수 구하기 부적합 합니다") ; //강제로 NumberFormatException을 만들겠다는 뜻
		}
		
		/*
		 * Exception in thread "main" java.lang.NumberFormatException: 소수 구하기 부적합 합니다
		 * 	at day5.CheckedExceptionTest.main(CheckedExceptionTest.java:20)
		 * 라고 나온다.
		 */
	}
}
