package day3;

class Student{
	String s = "";
	void name(String na) {
		System.out.println("학생의 이름은 " + na +"입니다");
	}
	
}
public class StudentTest3 {

	public static void main(String[] args) {
		Student s = new Student();
		for(int i=0;i<args.length;i++) {
			s.name(args[i]);
		}

	}

}
