package day4;

class Adding{
	public int add(int i, int j) {
		return i+j;
	}
	public double add(double i, double j) {
		return i+j;
	}
	
}
public class OverloadTest {

	public static void main(String[] args) {
		String s1 = "100";
		int dec = Integer.parseInt(s1);
		int bin = java.lang.Integer.parseInt(s1,2);
		System.out.println(bin);
		/*
		 * parseInt는 아래처럼 작동하고 있다
		 * class Integer{
		 * public int parseInt(String s){
		 * 	return s
		 * }
		 * public int parseInt(String s, int r){
		 * 	return s를 (r진수)
		 * }
		 * 
		 * 1개의 클래스에 같은 이름 메소드 여러개 정의를 기술하였다
		 * 이를 메소드 overloading이라고 한다.
		 * 매개변수 갯수, 타입, 순서 중 1개 이상을 다르게 정의
		 * 리턴타입, modifier 상과없다
		 */
	}

}
