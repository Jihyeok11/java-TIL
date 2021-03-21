package day8;


@FunctionalInterface // 얘의 역할은 메소드가 1개만 사용하겠다는 뜻
interface Math2{ // 람다를 쓸려면 메소드 2개를 쓰면 안된다
	public int calc(int first, int second);
//	public double calc2(double f, double s);
}


@FunctionalInterface
interface A3{
	int ma();
}

@FunctionalInterface
interface B3{
	int mb(int i);
}

@FunctionalInterface 
interface C3{ 
	public int calc(int first, int second);
}

class C1{
	static int mc1(int i, int j) {
		return i/j ;
	}
	int mc2(int i, int j) {
		return i%j;
	}
}
public class FunctionalTest2 {
	String name = "멤버변수";
	public static void main(String[] args) {

		String name = "메인지역변수";	
		Math2 m = (a,b)-> a*b;
		System.out.println(m.calc(10,2));
		
		
		Math2 m2 = (i,j)-> i-j;
		System.out.println(m2.calc(10,2));
		
		Math2 m3 = (i,j)->i+j;
		System.out.println(m3.calc(10,2));
		
		Math2 m4 = (a,b)-> a*b;
		System.out.println(m4.calc(10,2));
		
		
//		C1.mc1(10, 2);
//		C1 c = new C1();
//		c.mc2(10,2);

		Math m5 = (i,j) -> C1.mc1(i,j);
		// 외부클래스 메소드 실행한 결과 리턴
		System.out.println("여기야 여기");
		System.out.println(m5.calc(10, 2));
		
		// 위 표현을 좀더 간결하게 Math m5 = (i,j) -> C1.mc1(i,j);와 같은 표현으로
		Math m6 = C1::mc1; // 클래스명::static메소드명
		System.out.println(m6.calc(20, 2));
		
		// Non-static 메소드 사용하는 방법
		Math m7 = (i,j)-> new C1().mc2(i,j);
		System.out.println(m7.calc(10, 2));
		
		// 위와 같은 방법  [ 객체 생성변수명::non-static메소드명 ]
		Math m8 = new C1()::mc2;
		System.out.println(m8.calc(9, 5));
		
		A3 a1 = ()->{ 
			return 1;
		};
		
		// 위와 같다
		A3 a13 = () -> 1;
		System.out.println(a13.ma());
		
		B3 b3 = (a)-> {
//			String name = "람다"; // 아래에서 print에서 name를 사용하기 때문에 name으로 불가능(범위 중복)
			String name3 = "람다"; 
			System.out.println("람다식 실행");
			System.out.println(name); // 람다 포함 메소드 지역 변수 사용 가능
			System.out.println(name3);
			// static 변수 ---> 클래스명.static 변수
			// non-static 변수 ---> new 클래스명.non-static 변수
			System.out.println(new FunctionalTest2().name);
			return a*a;
		};
		System.out.println(b3.mb(10));
	}

}
