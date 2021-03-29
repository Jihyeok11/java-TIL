package jdbc;

import java.util.ArrayList;

import emp.EmployeeDAO;
import emp.EmployeeDTO;

public class I_PreparedSelectTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDAO dao = new EmployeeDAO();
		ArrayList<EmployeeDTO> list = dao.getEmployees(args[0],args[1]);
		// 이제부터 a,b를 입력 받으면 a 페이지를 보여주고 한 페이지당 b개씩
		for(EmployeeDTO dto : list) {
			System.out.println(dto.getFirst_name() + "|" + dto.getSalary());
		}
	}

}
