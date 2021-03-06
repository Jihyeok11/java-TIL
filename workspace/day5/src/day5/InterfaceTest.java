package day5;
// 1. 다중상속
// 2. 여러 서로 클래스 공통 메소드 정의 스펙 = abstract 클래스
class StudentTeacher /* extends Object */ implements Student, Teacher{
//	String name = "학생"; Student 상속
//	String name = "교수"; Teacher 상속
	String name = "조교";
	public void study() { // 여기서는 public 써줘야 한다.
		System.out.println(name); // 조교가 나온다
		System.out.println(Student.name);
		System.out.println(Teacher.name);
//		System.out.println(super.name); // 여기서 super는 Object가 된다.Interface는 객체가 될 수 없으므로 생성자도 될 수 없다.
		// 만약 student.name 값을 바꿀 수는 없다 interface는 final 이라서
		System.out.println("학생 - 공부하다");
	}

	@Override
	public void teach() {
		System.out.println("선생님 - 가르치다");
	}

	@Override
	public void lunch() {
		System.out.println("학생과 선생님 - 점심먹다");
	}
}

// Teacher 인터페이스를 다중 상속
class ITTeacher implements Teacher{

	@Override
	public void teach() {
		
	}

	@Override
	public void lunch() {
		
	}
	
}

public class InterfaceTest {

	public static void main(String[] args) {
//		StudentTeacher st = new StudentTeacher();
//		st.study();
//		st.teach();
//		st.lunch();
//		System.out.println(st.name); // 조교
		
		Student st = new StudentTeacher(); // 타입을 student로 형변환
		st.study();
//		st.teach();
		st.lunch();
//		System.out.println(st.name); // 학생
		
		
//		Teacher st2= new StudentTeacher();
////		st2.study();
//		st2.teach();
//		st2.lunch();
//		System.out.println(st2.name); // 교수
		
		Teacher [] t = new Teacher [2]; //2개짜리 배열 생성
		t[0] = new StudentTeacher();
		t[1] = new ITTeacher();
		t[0].teach();
		t[0].lunch();
		t[1].lunch();
		t[1].teach();
		
//		t[0].study(); // t는 Teacher 타입이기 때문에 study 사용 불가능
		StudentTeacher st3 = (StudentTeacher)t[0];
		st3.study();
		
		for (int i=0; i<t.length; i++) {
//			StudentTeacher st4 = (StudentTeacher)t[i];
//			st4.study();// i가 1일 때(ITTeacher 객체에는 study가 없다) 오류
			if ( t[i] instanceof StudentTeacher) {
				StudentTeacher st4 = (StudentTeacher)t[i];
				st4.study();
			}
		}
	}

}
