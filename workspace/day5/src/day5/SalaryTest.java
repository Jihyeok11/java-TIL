//	-상속과 오버라이딩을 이용하여 
//	각 직종의 회사원들의 급여를 계산하시오.
//	super
//	형변환
//	
//	회사원(Employee class){
//	 	- 멤버변수 선언
//	 	   사번 이름 본봉 일반수당 총급여
//	 	- 생성자 정의(main참고)
//	 	e[0] = new Employee(1000,"이사원",10000,5000);
//	 	(총급여 제외한) 
//	        매개변수 4개의 값을 멤버변수 값으로  초기화.
//	 
//	 	- 급여 계산메서드(): 
//	 	   총급여 = 본봉 + 일반수당 
//	}
//	
//	간부직(Manager class) : 상속
//		- 변수 선언(자동포함 제외 추가 변수 선언)
//	 	   이름 사번 본봉 일반수당 총급여
//		  간부수당
//		- 생성자 정의
//	 	Manager(2000,"김간부",20000,10000,10000);
//	        (Manager 생성자 내부 첫문장 super() ; 정의
//	         Employee() 생성자 호출)
//	
//	
//	- 급여 계산메서드()
//	 	   총급여 = 본봉 + 일반수당+간부수당  
//	 }
//		
//	기술직(Engineer class):상속 
//	 - 변수 선언
//	 	   이름 사번 본봉 일반수당 총급여
//	 	 자격수당 기술수당 
//	 	- 생성자 정의:main
//	 	
//	 - 급여 계산메서드()
//	 	   총급여 = 본봉 + 일반수당+자격수당+기술수당 	
//			
//	비서직(Secretary class) :상속
//		- 변수 선언
//	 	   이름 사번 본봉 일반수당 총급여
//		  비서수당 
//		- 생성자 정의
//	 	
//		- 급여 계산메서드()
//	 	   총급여 = 본봉 + 일반수당+비서수당 
//		
//	//====== 4개 클래스 정의 ================
//		   
//	class SalaryTest{
//	public static void main(String args[]){
//	
//		Employee e [] = new Employee[4];
//		// 1.상속 2.생성자(타입 순서 갯수....)
//		e[0] = new Employee
//		(1000,"이사원",10000,5000);
//		e[1] = new Manager
//		(2000,"김간부",20000,10000,10000);
//		e[2] = new Engineer
//		(3000,"박기술",15000,7500,5000,5000);
//		e[3] = new Secretary
//		(4000,"최비서",15000,7000,10000);
//	
//		/* 배열 내의 각 객체의 
//	          급여계산메소드 호출하고
//		사번, 이름, 총급여 출력
//	
//	사번:이름:본봉:총급여
//	1000:이사원:10000:xxxxx
//	2000:김간부:20000:xxxxx
//	3000:박기술:15000:xxxxx
//	4000:최비서:15000:xxxxx
//	 */ 
//		}
//	}	
//	


package day5;

class Employee {
	int id, baseSalary, generalFee, totalSalary;
	String name;
	
//	Employee(){}
	Employee(int id, String name, int baseSalary, int generalFee){
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
		this.generalFee = generalFee;
	}
	
	public void calcTotalSalary() {
		// 총 급여 = 본봉 + 일반수당
		this.totalSalary = this.baseSalary + this.generalFee;
	}
	
}
class Manager extends Employee{
	int manFee;
	Manager(int id, String name, int baseSalary, int generalFee, int manFee){
		// 자바의 첫 생성자 문장은 super()가 생략되어 있다
		super(id, name, baseSalary, generalFee); //이걸 하면 아래 4문장을 해준다.
//		this.id = id; // this.id가 아니라 super.id가 정확한 표현, 하지만 상속받은 값을 그대로 사용하기 떄문에 상관없다
//		this.name = name;
//		this.baseSalary = baseSalary;
//		this.generalFee = generalFee;
		this.manFee = manFee;
	}
	@Override
	public void calcTotalSalary() {
		//totalSalary = baseSalary + generalFee + manFee; 
		// 혹은
		
		super.calcTotalSalary(); // totalSalary = baseSalary + generalFee
		totalSalary += manFee;
	}
}

class Engineer extends Employee{
	int certiFee; // 자격수당
	int techFee; // 기술수당
	
	Engineer (int id, String name, int baseSalary, int generalFee, int certiFee, int techFee ){
		super(id,name,baseSalary,generalFee);
		this.certiFee = certiFee;
		this.techFee = techFee;
	}

	@Override
	public void calcTotalSalary() {
		// totalSalary = baseSalary + generalFee + certiFee + techFee
		super.calcTotalSalary();
		totalSalary += certiFee+techFee;
	}
}

class Secretary extends Employee{
	int secFee; // 비서수당
	public Secretary(int id, String name, int baseSalary, int generalFee, int secFee) {
		super(id,name,baseSalary,generalFee);
		this.secFee = secFee;
	}
	@Override
	public void calcTotalSalary() {
		//totalSalary = baseSalary + generalFee + secFee;
		super.calcTotalSalary(); 
		totalSalary += secFee;
	}
	
}
public class SalaryTest {

	public static void main(String[] args) {
		Employee e [] = new Employee[4];
		e[0] = new Employee(1000,"이사원",10000,5000);
		e[1] = new Manager(2000,"김간부",20000,10000,10000);
		e[2] = new Engineer(3000,"박기술",15000,7500,5000,5000);
		e[3] = new Secretary(4000,"최비서",15000,7000,10000);
		
		for (int i=0;i<e.length;i++) {
			e[i].calcTotalSalary();
			System.out.println(e[i].id + ":" + e[i].name+":" + e[i].baseSalary + ":" + e[i].totalSalary);
			
			// for구문을 돌면서 Engineer 객체인 경우네는 certiFee, techFee를 같이 출력하도록 하기 위해서
			if (e[i] instanceof Engineer) { 
				Engineer en = (Engineer) e[i];
				System.out.println(en.certiFee + ":" + en.techFee);
			}
		}
				

	}

}
