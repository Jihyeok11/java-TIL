package day6;

// 동시 실행 내용 생기면 멀티 스노레드 코드로 작성
// 동시 실행중에 특정 객체 접근시 SYNCHRONIZED 블록 순서 지키고 1번에 1개 스레드 접근
// SINGLETON 패턴은 자주 등장
// 스레드는 내부에서 이미 구현된 완성된 API를 사용하게 된다 그러나 개념은 꼭 알고 있을 것(java의 특징)
class MyStack {
	char[] ch = new char[10];
	int idx = 0; // 멤버변수
//	void push(char c) { // 이 작업을 하면 멀티 쓰레드를 작업 하면서 중간에 다른 쓰레드 작업을 할 수가 있다
//		ch[idx] = c;
//		System.out.println
//		(Thread.currentThread().getName() + " idx = " + idx + ", ch[idx] = "+ ch[idx]);
//		idx ++;
//	}
	void push(char c) { 
		synchronized (ch) { // 이 작업을 시작하면 중간에 다른 쓰레드가 오지 못하게 lock 해제, 하지만 스레드 수행 속도가 느려질 수 있다
			ch[idx] = c;
			System.out.println
			(Thread.currentThread().getName() + " idx = " + idx + ", ch[idx] = "+ ch[idx]);
			idx ++;
		}
	}
}

class MyStackThread extends Thread{
	MyStack st;
	char c;
	MyStackThread(MyStack st, char c){
		this.st = st;
		this.c = c;
	}
	public void run() { // Thread 안에는 run이 꼭 override 해야 한다
		for (int i = 1; i <= 5; i ++) {
			st.push(c);
		}
	}
}

public class SynchroizedTest {
public static void main(String[] args) {
	MyStack st = new MyStack();
//	st.push('a');
//	st.push('b');
//	st.push('c');
	MyStackThread t1 = new MyStackThread(st, 'a');
	MyStackThread t2 = new MyStackThread(st, 'b'); // 똑같은 개체 st에 b만 저장
	t1.setName("t1");
	t2.setName("t2");
	t1.start();
	t2.start();
	

}

}
