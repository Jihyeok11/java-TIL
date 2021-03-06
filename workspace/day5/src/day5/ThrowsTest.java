package day5;

class Test{
	// ArithmeticException 예외 처리를 하지 않고 예외 처리 권한을 다른 메소드에게 위임
	void m1(int i) throws ArithmeticException { // 다른 예외들 있으면 ','로 열거하면 된다
		System.out.println(100/i);
	}
	void m2() throws ArithmeticException {
//	void m2() {
		try {
			m1(0);
		} catch(ArithmeticException e) {
			System.out.println(e.getMessage()); 
		}
	}
	
	void m3() {
		try {
			m1(0);
		} catch(ArithmeticException e) {
			m1(100); // 0으로 나눠서 예외가 나왔으니 100으로 나눠본다
		}
	}
}
public class ThrowsTest {
	public static void main(String[] args) {
		Test t = new Test();
		t.m2(); // 만약 void m2()도 trhows를 사용하면 여기서 예외 처리 해야한다. main(String[] args) 앞에 throws arit- 추가한다
	}
}
