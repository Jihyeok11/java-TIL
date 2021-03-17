package day4;

class Parent{
	int su1 = 10;
	void pr() {
		System.out.println(su1);
	}
	void mp() {
		System.out.println("Parent");
	}
}

class Child extends Parent{
	int su2 = 20;
	void pr() {
		System.out.println(su2);
	}void mc(){
		System.out.println("Child");
	}
}
public class TypeCastingTest {

	public static void main(String[] args) {
//		Parent p1 = new Parent(); // no 형변환
//		Child c1 = new Child(); // no 형변환
		Parent p2 = new Child(); // 자동 형변환(상위 변수 = new 하위;) 타입이 Parent
		System.out.println(p2.su1);
//		System.out.println(p2.su2); 메모리에는 있으나 호출은 불가능, 타입이 Parent 라서..
		p2.mp(); // Parent 호출 
//		p2.mc(); // 불가능
		p2.pr(); // Child 호출
		
		Child c2 = null;
		
		if (p2 instanceof Child) { // instanceof는 객체가 맞는지를 검사하는 장치이다.
			System.out.println("test1");
//			c2 = (child) p2;
		}
		
		Parent p3 = new Parent();
		if (p3 instanceof Child) {
			System.out.println("test2");
//			Child c3 = (child)p3;
		}
		
//		Child c2 = (Child) p2; // ( 타입을 Child로 명시적 형변환 )
		System.out.println(c2.su2); // Child로 형변환 했으니 이제 su2 가능
//		c2.mc();
		
		
//		Child c3 - new Parent(); // 자동 형변환 불가능!
//		Child c3 = (Child) new Parent(); // 명시적 형변환 시도, 하지만 원래대로 되돌릴 수가 없다. 그러므로 명시적 형변환 불가능 컴파일은 가능하나 오류뜸

	}

}
