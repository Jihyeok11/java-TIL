package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Data Access Object
public class EmployeeDAO {
	public ArrayList<EmployeeDTO> getEmployees(String currentPage, String cntPerPage){ // first, last �� ���� ���
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ��ҹ��� ���� - ojdbc6.jar �ȿ� �ִ� ���� ����
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr","hr"); // ����ǻ�� ���ÿ� hr�������� ����
			System.out.println("db���� ����");
			
			
			// hr ����, employees ���̺���  �޿� ��������
			// 11~20���� ��� �̸��� �޾� ��ȸ
			
	//		/* 1. rownum ���
			String sql = "select r, first_name, salary "
					+ "from (select rownum as r, first_name, salary from (select * from employees order by salary desc)) where r>=? and r<=?";
	//				"select first_name,rownum, salary from "
	//				+ "(select * from employees order by salary desc)"
	//				+ " where rownum between 11 and 20";
			// rownum �� ũ�ų� ����(>=), ũ��(>)�� �Ұ����ϴ�( �񱳼��ڰ� 1�̸� �����ϱ��� )
	//		 "select r, salary from (select rownum as r, salary from (select * from employee order by salary desc)) where r>=11 and r<20"
	//		*/
			
			/* 2. row_number();-- where ������ ������ ������ subquery ���
			String sql = "select r, salary from("
					+ " select row_number() over(order by salary desc) as r,salary "
					+ " from employees)";
			*/
			
			
			/* 3. rank
			String sql=
					"select r, salary "
					+ "from (select rank() over(roder by salary desc )"
					+ " as r, salary from employees) where r betweem 11 and 20";
			*/
	
			
			st = conn.prepareStatement(sql);
//			st.setInt(1, Integer.parseInt(first));
//			st.setInt(2, Integer.parseInt(last));
			
			st.setInt(1, (Integer.parseInt(currentPage) -1)*Integer.parseInt(cntPerPage));
			st.setInt(2, ( Integer.parseInt(currentPage) * Integer.parseInt(cntPerPage) ));
			// ����
			rs = st.executeQuery();
			
			// ���ϰ�� REsultSet = ArrayList�� ���� - EmployeeDTO
			
			while(rs.next()) {
				String emp_name = rs.getString("first_name");
				int r = rs.getInt("r");
				double salary = rs.getDouble("salary");
				EmployeeDTO dto = new EmployeeDTO();
				dto.setFirst_name(emp_name);
				dto.setSalary(salary);
				list.add(dto);
				
				System.out.println(salary +"|"+ emp_name+"|"+r);
			}
			
			
			System.out.println("db������������");
		}catch (ClassNotFoundException e) {
			System.out.println("����̹� ���� Ȯ���ϼ���");
		}catch(SQLException e) {
			System.out.println("DB �������� Ȯ���ϼ���");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				conn.close(); // ��ȸ ����
				rs.next();
			}catch(SQLException e) { }
		}
		return list;
	}
}
