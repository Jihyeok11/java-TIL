package day7;

import java.util.ArrayList;

class Employee{
	int id;
	String name;
	double salary;
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return this.id+"-"+this.name+"-"+this.salary;
	}

	
	
}
public class ArrayListTest {

	public static void main(String[] args) {
		// ArrayList 는 조회를 자주 이용할 때 효율적이다
		// LinkedList는 저장 수정 삭제를 자주이용할 떄 효율적이다
		
//		ArrayList list = new ArrayList(5); // 참조형 변수만 저장 가능
		
		// 만약 동일 데이터 타입에 대해서만 저장하고 싶으면
		ArrayList<Employee> list = new ArrayList<Employee>(5);
		
//		list.add(100); // int 타입 데이터를 Integer 타입 자동 변경 가능
//		list.add(new Integer(200)); // Integer 타입 객체
//		list.add(2.55); // double
//		list.add(new Double(32.14)); // Double 타입 객체
//		list.add(300);
//		list.add(9.99);
//		list.add("자바프로그램");
//		list.add(0, "추가됨");
//		list.set(0, "변경됨");
//		list.remove(0);
//		System.out.println(list.size());
		
		
		
		
		Employee e1 = new Employee(100, "이사원", 56000.55);
		Employee e2 = new Employee(200, "최대리", 66000.55);
		Employee e3 = new Employee(300, "박과장", 76000.55);
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		System.out.println(list.size());
		// list 내에 멀티캠퍼스 문자열 삭제
		if (list.contains("멀티캠퍼스")) {
			System.out.println(list.indexOf("멀티캠퍼스"));
			list.remove("멀티캠퍼스");
		} else {
			System.out.println("없는뒈?");
		}
		for (int i=0;i<list.size();i++) {
			Object o = list.get(i); //  Employee로만 저장했다면 Employee o = list.get(i)
			System.out.println(i+ "번 인덱스의 값은 " + o);
//			System.out.println(o);
			
			// 각 이름을 출력하고 싶을 때 (list는 Employee 타입만 저장되어 있다)
			if (o instanceof Employee) {
				System.out.println(((Employee)o).name);				
			}
			
			// Employee 만 저장했다면
			System.out.println(((Employee)o).name);
		} // 일반적으로는 toString이 오버라이딩이 되어있지만 내가 만드는 class는 안되어 있음
	}
}
