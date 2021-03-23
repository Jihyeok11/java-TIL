package template;

public class Controller {
	// singleton 패턴
	// 생성자는 private
	// 자기자신에 대해 변수를 쓰는데 static
	// return 값은 public static
	private static Controller con = new Controller();// 외부 클래스에서 Controller.con 사용 불가, static 이므로 con은 여기서만 생성 가능
	private Controller() { // 외부에서 함부로 생성자를 만들수 없게 (new Controller() 같으거 못하게);
		
	}
	public static Controller getInstance() {
		return con; // Controller 객체로 con을 return
	}
	
	void insert(int id, String name, double salary) {
		//VO를 선정하여 저장, DAO 메소드에 호출해야한다
		 EmployeeVO e = new EmployeeVO(id,name,salary);
		 EmployeeDAO dao = new EmployeeDAO();
		 dao.insert(e);
	}
	void getall() {
		
	}
	
	
}

// 외부에서 Controller c = Controller.getInstance(); 형태로 사용 가능
// static 이라서 
// Controller c = Controller.getInstance();
// Controller c = Controller.getInstance();
// Controller c = Controller.getInstance(); 
// 이래도 1번만 호출 된다