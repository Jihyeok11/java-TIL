package day8;
interface Math{
	public int calc(int first, int second);
}
class A1 implements Math{
	public int calc(int first, int second) {return first * second;}
}
class B implements Math{
	public int calc(int first, int second) {return first + second; }
}
public class FunctionalTest {

	public static void main(String[] args) {
		Math m = new Math() {
			public int calc(int first, int second) {return first / second;}
		};
		System.out.println(m.calc(10,2));
		System.out.println(new A1().calc(10, 2));
		System.out.println(new B().calc(10, 2));
		
		// Math m2 = (int first, int second) -> {return first - second ;};
		Math m2 = (i,j) -> i-j;
		System.out.println(m2.calc(10, 2));

	}
}
