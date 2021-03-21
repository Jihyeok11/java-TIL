package day8;

class Outer{
	class Inner{ // non-static(= 인스턴스) 멤버충첩클래스
		void m() {
			System.out.println("중첩클래스 메소드 실행");
		}
	}
	static class Inner2{ // static 멤버 중첩 클래스
		void m2() {
			System.out.println("중첩클래스 메소드 실행 2");
		}
	}
	void test() {
		class Inner3{ // 지역 중첩 클래스
			void m3() {
				System.out.println("중첩클래스 메소드 실행 3");
			}
		}
		new Inner3().m3();
	}
}

class A{
	static int i = 10;
}
public class InnerTest1 {

	public static void main(String[] args) {
		// static이 없을 때
		Outer o = new Outer();
		Outer.Inner i = o.new Inner();
		i.m();
		
		// static일 때
		System.out.println(A.i);
		Outer.Inner2 i2 = new Outer.Inner2();
		i2.m2();
		
		// 지역 중첩 클래스
		Outer o3 = new Outer();
		o.test();
	}

}
