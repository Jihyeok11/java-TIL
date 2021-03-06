package day5;

public class ObjectClassTest {
	public static void main(String[] args) {
		MyObject o1 = new MyObject("java");
		MyObject o2 = new MyObject("java");
		// 패키지명.클래스명@16진수주소값(암호)
		// 객체는 자동 먼저 호출 결과 출력
		// 메소드 오버라이딩하면 다른값 재정의 기능 - 출력값 변경
		System.out.println(o1); // o1은 객체 참조 변수
//		System.out.println(o1.toString());
		System.out.println(o2);
		
		if (o1 == o2) { // '=='는 기본형 변수, 참조형 변수 둘 다 가능(참조형일 땐 같은 주소를 가르키는 지를 비교) 
			System.out.println("o1 == o2 : true");
		}
		if (o1.equals(o2)) { // 메소드라는 것은 참조형 변수밖에 없다.
			// 메소드 : 참조(주소값) 메소드 오버라이딩 이전
			// 전달 매개변수 MyOject
			System.out.println("o1.equals(o2) : true");
		}
	}

}

class MyObject /* extends Object */{
	String msg;
	MyObject(String msg){
		this.msg = msg;
	}
	// MyObject에는 toString()하고 equls() 이 있다.
	
	// toString()을 overriding - MyObject 객체 출력 내용 변경
	public String toString() {
		return msg;
	}
	
	// equals() 오버라이딩
	// if (o1.equals(o2))
	@Override // 타입 체크 용
	public boolean equals(Object obj) {
//		String o2 = new String("java");
//		MyObject o2 = new MyObject("java");
//		Object obj = 자바 모든 객체 // 자동 형변환
//		전달 매개변수 MyObject 타입이고 전달 매개변수값이 동일하면 true
		if (obj instanceof MyObject) {
			
//			
//			String me = this.toString();
//			String other = obj.toString();
//			if (me.equals(other)) { // String equals 메소드는 문자열 내용 비교
//				return true;
//			}
//			else {
//				return false;
//			}
			
//			 위를 간결하게 아래처럼
			return toString().contentEquals(obj.toString());
		}
		else {
			return false;
		}
	}
}
