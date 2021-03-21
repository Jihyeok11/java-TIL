package day8;

public class InnerTest3 {

	public static void main(String[] args) {
		int out = 10;
		class Inner{
			public int count() {
				int cnt = 0;
				for(int i = 0;i < out; i++) {
					cnt += i;
				}
				return cnt;
			}
		}
		System.out.println(new Inner().count());
		
		// 무명객체
//		interface Runnable {
//			public void run();
//		}
		
		class RunnableSub implements Runnable{
			public void run() {
				System.out.println("실행중");
			}
		}
		
		// 지역 내부 객체 생성
		Runnable sub = new RunnableSub();
		
		// 메소드 호출
		Thread t1 = new Thread(sub);
		t1.start();
		
		Runnable sub2 = new Runnable() {
			public void run() {
				System.out.println("실행중1");
			}
		};
		Thread t2 = new Thread(sub2);
		t2.start();
		

		Thread t3 = new Thread(new Runnable() {
			public void run() {
				System.out.println("실행중2");
			}
		});
		t3.start();
		
		// 람다
		new Thread(new Runnable() { public void run() { System.out.println("실행중3"); }}).start();
		
		new Thread( /* Thread다음 괄호는 Runnable */(/* run메소드 */) -> {System.out.println("실행중444");}).start();
		
		myInter i = new myInter() { // 자동형변환 이후 myInter에 포함딘 메소드만 호출 가능, 그러므로 mi3는 호출 불가능
			public void mi1() {
				System.out.println("mi1는 반드시 overriding");
			}
			public void mi2() { // 오버라이딩
				System.out.println("mi2는 반드시 overriding");
				mi3();
			}
			public void mi3() { // 추가된 메소드 - 여기서만 가능한 표현이다
				System.out.println("mi3는 추가 메소드");
			}
		};
		i.mi1();
		i.mi2();
//		i.mi3(); 익명 표현 밖에서는 사용 불가능
		
	}

}


interface myInter {
	/*public abstract */void mi1();
	void mi2();
}

abstract class Aa {
	abstract void ma();
	public void mb() { System.out.println("mb 호출");}
}