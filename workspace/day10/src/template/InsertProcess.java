package template;

import java.util.Scanner;

public class InsertProcess {
	void process() {
		Scanner key = new Scanner(System.in);
		System.out.print("사번 입력 : ");
		int id = key.nextInt();
		System.out.print("이름 입력 : ");
		String name = key.next();
		System.out.print("급여 입력 : ");
		double salary = key.nextDouble();
//		EmployeeVO e = new EmployeeVO(id,name,salary);
		Controller c = Controller.getInstance();
		// Controller 클래스 입력 내용 전달
		// EmployeeVO e = new EmployeeVO(id, name, salary);
		// EMployeeDAO ??? 메소드 호출
		c.insert(id, name, salary);
	
		
	}
}
