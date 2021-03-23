class A{
	int add(int ... numbers) { //numbers는 내부적으로 배열이 된다
		System.out.println("전달매개변수 갯수="+numbers.length);
		int sum = 0;
		for (int one : numbers) {
			sum += one;
		}
		return sum;
	}
}
public class VariableArgumentTest {

	public static void main(String ... args) {
		A a1 = new A();
		int result = a1.add(1,2);
		System.out.println("총합 :"+result);
		result = a1.add(1,2,3,4,5,6,7,8,9,10);
		System.out.println("총합 :"+result);
		result = a1.add(14,15,6,23,51);
		System.out.println("총합 :"+result);
		System.out.println(args[0]);
		System.out.println(args[1]);
	}

}
