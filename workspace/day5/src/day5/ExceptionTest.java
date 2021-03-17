package day5;

public class ExceptionTest {

	public static void main(String[] args) {
		
		// 1. ArrayIndexOutOfBoundsException
		// args[0] = 100, args[1] = null
//		int i = Integer.parseInt(args[0]); // 
//		int j = Integer.parseInt(args[1]); //이 값이 없어서 ArrayIndexOutOfBoundsException
//		System.out.println(i/j);
//		System.out.println("main 종료");
		
		
		// 2. ArithmeticException (0으로 나눈 경우)
		// args[0] = 100, args[1] = null
//		int i = Integer.parseInt(args[0]); // 
//		int j = Integer.parseInt(args[1]); //이 값이 없어서 ArrayIndexOutOfBoundsException
//		System.out.println(i/j);
//		System.out.println("main 종료");
		
		try {
			int i = Integer.parseInt(args[0]);
			int j = Integer.parseInt(args[1]);
			System.out.println(i/j);
		}
		// 모든 예외에 대해서 사용하고 싶을 때
		// 모든 예외 타입은 Exception 클래스에 상속받아 있다
		// Exception e = new xxxException();처럼 사용하고 있었다
		catch(ArithmeticException e) {
			System.out.println("0으로 나눌수 없습니다");
		}
		
//		catch(Exception e) {
//			System.out.println("Arithmetic 예외를 제외한 모든 예외 타입들을 동일하게 처리합니다.");
//		}
		// 예외가 있든 없든 무조건 실행
		finally {
			System.out.println("항상 실행합니다");
		}
		
		// ArithmeticException만 일어날때 랑 다른 예외 타입과 분리하고 싶다면
		/*
		 * 자바의 try 예외 처리
		 * 1. try에서 예외 확인
		 * 2. new ArithmeticException() 실행 
		 * 3. catch로 이동(위에서부터 차근차근 수행)
		 * 4. catch는 한 번만 작동되면 알아서 break 즉, 뒤에 있는 catch는 실행되지 않는다.
		 */
		
		
		
		
		/* 부분적으로 예외 타입에 따라 다르게 사용
		catch(ArithmeticException e) { //ArithmeticException가 일어나면 시도
			// j = 100;
			System.out.println("0으로 나눌수 없습니다");
			e.printStackTrace(); // 예외발생라인 추적 정보
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e) {
			System.out.println("정수료 변경 가능한 값을 입력하세요");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("입력 배열을 다시 확인해보세요");
		}
		 */
		System.out.println("main 종료");

	}

}
