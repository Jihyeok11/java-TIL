package day3;

class Test{
	int ma(){
		int i = 10;
		return i*i; // ma() 값으로 i*i 결과를 되돌려줌
	}
	String mb() {
		String s = "java";
		return s.toUpperCase();
	}
	int [] mc() {
		int [] i = new int[3];
		i[0] = 100;
		i[1] = 200;
		i[2] = 300;
		return i;
	}
	void md() {// return 값이 없으면 데이터 타입을 void로 한다
		int i = 13;
		System.out.println(i*i);
	}
	void me() {
		int i = 0;
		System.out.println("me메소드 시작");
		if(i==0) { return;}
		System.out.println("me메소드 종료");
	}
}
public class ReturnTypeTest {

	public static void main(String[] args) {
		Test t = new Test(); // 다른 class에 있으므로 선언 필요
		int r1 = t.ma();
		System.out.println(r1);
		String s1 = t.mb();
		System.out.println(s1);
		int [] r3 = t.mc();
		for(int one:r3) {
			System.out.println(one);
		}
		t.md();
		t.me();
		System.out.println("main 종료");
	}

}
