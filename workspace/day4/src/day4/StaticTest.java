package day4;

class Person{
	String name;
	int age;
//	static String nation="대한민국"; // 공유기능 on
	static final String nation="대한민국"; // final이 붙으면 수정 불가능
}

public class StaticTest {
	public static void main(String[] args) {
		System.out.println(Person.nation); // nation은 특정 개체에 속해 있는 것이 아니라 p1 선언 하기 전에도 이렇게 프린트 가능
		Person p1 = new Person();
		p1.name = "박민국";
		p1.age = 20;
//		p1.nation = "대한민국";
//		p1.nation = "미국"; // nation은 static이라서 공유하고 있다 static final이 붙어있으므로 변경 불가능
		System.out.println(p1.name + ":" + p1.age + ":" + p1.nation);
		Person p2 = new Person();
		p2.name = "김대한";
		p2.age = 30;
//		p2.nation = "대한민국";
		System.out.println(p2.name + ":" + p2.age + ":" + p2.nation);
	}
}
