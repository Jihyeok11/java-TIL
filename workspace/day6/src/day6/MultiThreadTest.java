package day6;

class Multi1 extends Thread{
	public void run() {
		for(int i = 0; i<=10; i++) {
			System.out.println(getName() + " - 다른 작업 수행");
		}
	}
}

class Multi2 implements Runnable{
	public void run() {
		for(int i=1;i<=10; i++) {
			System.out.println
			(Thread.currentThread().getName() + " - 다른 작업 수행");
		}
	}
}
public class MultiThreadTest {

	public static void main(String[] args) {
		Multi1 m1 = new Multi1();
		m1.setName("m1");
		m1.start(); // run() 동시 실행 = 멀티스레드 1
		
		Multi1 m2 = new Multi1();
		m2.setName("m2");
		m2.start(); // run() 동시 실행 = 멀티스레드 2
		
		
		for (int i = 1; i<= 5; i++) {
			System.out.println("메인 작업 수행");
		}
		// Runnable
		Multi2 mul1 = new Multi2();
		Thread t1 = new Thread(mul1);
		
		t1.setName("t1");
		t1.start();
		
		Multi2 mul2 = new Multi2();
		Thread t2 = new Thread(mul2);
		t2.setName("t2");
		t2.start();
	}
	
}
