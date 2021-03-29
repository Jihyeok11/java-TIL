package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class D_SelectTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ��ҹ��� ���� - ojdbc6.jar �ȿ� �ִ� ���� ����
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr","hr"); // ����ǻ�� ���ÿ� hr�������� ����
			System.out.println("db���� ����");
			
			
			
			String sql = "select to_char(hire_date, 'yyyy:mm:dd HH24:MMmi:ss') as h_date from employees";
			st = conn.createStatement(); // ����
			
			rs = st.executeQuery(sql); 
			
			// ��Ű����.Ŭ������@16���� ���
//			System.out.println(rs); // toString() ����� ����ϰ� �ʹ�
			
			while(rs.next()) {
//				int emp_id = rs.getInt("employee_id");
//				String emp_name = rs.getString("first_name");
//				String title = rs.getNString("job_id");
//				double salary = rs.getDouble("salary");
//				int dept_id = rs.getInt("department_id");
//				java.sql.Date hire_date = rs.getDate("hire_date");
				String hire_date = rs.getString("h_date"); // ������ hire_date �ε� ���� sql���� �ٲ㼭 �̷���
				
//				System.out.println(emp_id +"|"+ emp_name + "|"+title + "|"+salary + "|"+dept_id + "|" + hire_date);
				System.out.println(hire_date);
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
			}catch(SQLException e) {}
		}
	}

}
