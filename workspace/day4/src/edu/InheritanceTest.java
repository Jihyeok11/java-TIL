package edu;

class Employee{ // 슈바! ConstructorTest에 있는 Employee랑 중복이네(같은 package) => edu 라는 패키지를 생성해서 옮겻다
	int id;
	String name;
	String salary;
	// 암호 추가
//	private int pw; // private는 상속 불가능, protected 혹은 public은 가능!
	String pw = "Employee";
	public void printEmp() {
		System.out.println(id + ":" + name + ":" + salary);
	}
}
class Manager extends Employee{
	String jobofManage; // 관리하는 업무
	int cntofSub; // 관리하고 있는 부하직원 수
	String pw = "Manager"; 
	/*
	 * Employee 상속 그대로 사용 또는 변경 재정의
	 * 이름 매개변수, 리턴 타입, modifier가 동일하거나 더 넓을 경우 내용변경이 가능하다.
	 */
	
	@Override // 자바시스템에게 나 이거 override할거라고 알려준 것이다. 상속값을 줄 수 없으모르 아래에 printEmp(i)라고 쓸 수 없다.
	public void printEmp() { // 상위 클래스가 public 이므로 하위 클래스는 이와 같은 public만 가능(더 넓거나 같아야 하므로)
//		printEmp(); // 자기 자신을 계속 호출하는 것
		super.printEmp(); // 상속을 받은 printEmp를 의미 ,즉 11번쨰 줄을 호출
		System.out.println(id + ":" + name + ":" + salary);
		System.out.println(jobofManage + ":" + cntofSub);
//		return 0; // return 타입이 void 라서 return 사용 불가능
	}
	void test() {
//		id = 12345;
//		System.out.println(id);
//		System.out.println(pw);
		
		String pw = "test 메소드";// 새로운 지역 변수
		System.out.println(pw);
		System.out.println(this.pw); // 상속받은 변수와 이름이 같아서 this 사용
		System.out.println(super.pw);
	}
}

public class InheritanceTest {
	public static void main(String[] args) {
		Manager m = new Manager();
		m.id = 12345;
		m.name = "김부장";
		m.jobofManage = "it직종관리";
		m.cntofSub = 10;
		System.out.println(m.id+":"+m.name+":"+m.jobofManage+":"+m.cntofSub);
		m.test();
		m.printEmp(); // Emp
		Manager s = (Manager)new Employee();
	}
}

