package edu;
class A /*  extends Object */ {
	int i;
//	A() { } // 하위 클래스 생성자 용도 아니면 하위클래스에서 따로 설정 가능
	A(String s){
		// super();
		i = 10;
		System.out.println("A 생성자 호출");
	}
}
class B extends A{
	int j;
	B(){
		// super(); ==> A() 생성자 호출
		super("aaa"); // A에 매개변수가 필요한데 넘기는게 없으면 이런식으로 한다
		j = 100;
		System.out.println("B 생성자 호출");
	}
}
public class SuperTest {

	public static void main(String[] args) {
		B b1 = new B();
		System.out.println(b1.i);
		System.out.println(b1.j);
		
	}

}