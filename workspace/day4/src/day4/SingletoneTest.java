package day4;
// 싱글톤은 Spring에서 주로 사용
class A{ // singletone - 1. 생성자는 prviate로 생성, 2. 변수 (A a1)으로 생성할 것, 3. return 값도 자기 자신
	private static A a1 = new A();
	private A() {	// private를 사용했으므로 A 클래스에서만 사용
		System.out.println("A 생성자 호출");
	}
	static A getInstance() { // 다른 패키지에 사용하려면 modifier로 public을 추가해 준다.
		return a1; // static 은 객체 생성 이전 메모리 저장하고 유지한다 메서드, 변수 모두 static이여야 한다.
	}

	
	
//	A(){
//		System.out.println("A 생성자 호출");
//	}
}

public class SingletoneTest {

	public static void main(String[] args) {
		// public 이전
//		A a1 = new A();
//		A a2 = a1;// A 타입 객체를 공유
//		A a3 = new A(); // static은 객체들끼리 공유하기 떄문에 (클래스 이름).(static) = 매개변수 로 사용
		A.getInstance(); // A 타입 객체 생성 통로
		System.out.println("하이");
		A.getInstance();
		A.getInstance(); // a1을 세번 호출한다. a1도 static 이므로 한번만 공유하여 1번만 프린트 된다.
		
	}

}