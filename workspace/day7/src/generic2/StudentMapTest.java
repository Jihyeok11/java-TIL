package generic2;

class Student<T>{
	T id;
	String name;
	int kor,eng, mat;
	public Student(T id, String name, int kor, int eng, int mat) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	@Override
	public boolean equals(Object obj) {
		int sum = kor+eng+mat;
		int othersum = ((Student)obj).kor + ((Student)obj).eng + ((Student)obj).mat;
		if (sum == othersum) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		int sum = kor + eng + mat;
		return id + "-" + name + "-" + sum;
	}
	
	
}
public class StudentMapTest {

	public static void main(String[] args) {
		Student<Integer> s1 = new Student(100, "김자바", 100, 90, 80);
		Student<String> s2 = new Student("200", "박지원", 100, 10, 90 );
		System.out.println(s1.toString());
		System.out.println(s2);
		
		if (s1.equals(s2)) {
			System.out.println("두마리는 같다");
		} else {
			System.out.println("두마리는 다르다");
		}
		
		
		

	}

}
