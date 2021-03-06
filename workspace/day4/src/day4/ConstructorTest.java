package day4;

class Employee{
	// 기본 생성자(default constructor ) 생성자 자동
	// 1.
	Employee(String id, String n){
		this.id = id; // 사번 this를 붙여서 매개변수 id
		name = n; // 이름
	}
	// 2
	Employee(String id){
		this.id = id; // 지역변수 id 값 = 매개변수 id값 을 의미
		name = "none"; // name은 매개변수가 없으므로 this.name이나 name이나 같다
		
		new Employee(id, "none"); // 1번 생성자 호출
//		this(id,"none"); 바로 위와 동일한 것이다.
	}
	// 3
	Employee(){
		id = "---";
		name="none";
//		this("---","none"); //1번 생성자를 호출
	}
	String id;
	String name;
	String title;
	String dept;
	void work() {
		System.out.println(name + "사원이+ "+ dept + "부서에서 일한다");
	}
}

public class ConstructorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("100", "이사원");
		Employee e2 = new Employee("200", "김대리");
		Employee e3 = new Employee("300", "박과장");
		Employee e4 = new Employee("400");
		Employee e5 = new Employee();
		System.out.println(e1.id + ":" + e1.name);
		System.out.println(e2.id + ":" + e2.name);
		System.out.println(e3.id + ":" + e3.name);
		System.out.println(e4.id + ":" + e4.name);
		System.out.println(e5.id + ":" + e5.name);
		e1.work();
		e2.work();
		e3.work();
		e4.work();
		e5.work();
	}

}
