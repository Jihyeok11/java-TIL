package jdbc;

import java.util.ArrayList;

import emp.EmployeeDAO;
import emp.EmployeeDTO;

public class I_PreparedSelectTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDAO dao = new EmployeeDAO();
		ArrayList<EmployeeDTO> list = dao.getEmployees(args[0],args[1]);
		// �������� a,b�� �Է� ������ a �������� �����ְ� �� �������� b����
		for(EmployeeDTO dto : list) {
			System.out.println(dto.getFirst_name() + "|" + dto.getSalary());
		}
	}

}
