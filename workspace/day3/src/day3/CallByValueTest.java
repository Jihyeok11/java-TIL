package day3;

class MyObject{
	int a = 10;
}

class Call{
	void add(int i) {
		// 전달 받은 i가 10이라고 가정
		System.out.println(i++);
	}
	void addObject(MyObject mo) { // 참조형 변수 하나만 전달되는 포현
//		MyObject mo_copy = mo;
		System.out.println(mo.a++);
	}
}

public class CallByValueTest {

	public static void main(String[] args) {
		Call c = new Call();
//		int j =10;
//		c.add(j);
//		System.out.println("c.add(j) 호출 후의 j = "+j);
		MyObject obj = new MyObject();
		c.addObject(obj);
		System.out.println("c.addObject(obj) 호출 후의 obj.a = " + obj.a);

	}

}
