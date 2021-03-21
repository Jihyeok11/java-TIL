package day8;


class Outer2{
	int outervar = 10; // 외부클래스 non-static 멤버변수
	static int outervar2 = 20; // 외부클래스 static 멤버변수
	String name = "Outer2";
	
	class Inner{ // non-static(= 인스턴스) 멤버충첩클래스
		String name = "Inner";
		void m() {
			String name = "m메소드";
			System.out.println("중첩클래스 메소드 실행");
			System.out.println(outervar);
			System.out.println(outervar2);
			System.out.println(Outer2.this.name);
			System.out.println(this.name);
			System.out.println(name);
			
		}
	}
	static class Inner2{ // static 멤버 중첩 클래스
		void m2() {
			System.out.println("중첩클래스 메소드 실행 2");
//			System.out.println(outervar);
			System.out.println(outervar2);
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

public class InnerTest2 {
// 1. main 실행 이전 static(변수, 내부클래스 ,메소드들) 메모리에 저장
// 2. new Outer2() 실행, non-static (변수, 내부클래스, 메소드) 메모리 저장
	public static void main(String[] args) {
		Outer2.Inner i = new Outer2().new Inner();
		i.m();
		
		Outer2.Inner2 i2 = new Outer2.Inner2();
		i2.m2();
		
		Outer2 o = new Outer2();
		o.test();

	}

}
