package day3;


// 지금까지 클래스 1개만 다뤘는데 여러개 사용 가능
// public은 java로 선언한 클래스명에 붙여준다.
// main는 메소드를 가진 클래스명.java
class Employee{ // 회사원 객체 클라스
	// 사번 이름 직급 부서 변수
	String id;
	String name;
	String title;
	String dept;
	
	// 메소드
	String work(){
		System.out.println(name + "사원이 "+dept+"라는 부서에서 일하고 있다");
		return "이달의 급여처리 업무 완료";
	}
	
}
public class EmployeeTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee();
		e1.id = "100";
		e1.name = "박대리";
		e1.title = "대리";
		e1.dept = "인사부";
		System.out.println
		(e1.id + ":" + e1.name + ":" + e1.title + ":" + e1.dept);
		String r1 = e1.work();
		System.out.println(r1);
		
		Employee e2 = new Employee();
		e2.id = "200";
		e2.name = "회사원";
		e2.title = "신입사원";
		e2.dept = "IT개발";
		System.out.println
		(e2.id + ":" + e2.name + ":" + e2.title + ":" + e2.dept);
		e2.work();
	}

}
