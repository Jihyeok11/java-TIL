package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C_SelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ��ҹ��� ���� - ojdbc6.jar �ȿ� �ִ� ���� ����
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc","jdbc"); // ����ǻ�� ���ÿ� hr�������� ����
			System.out.println("db���� ����");
			
			
			
			String sql = "select count(*) as cnt from c_emp group by dept_id";
			st = conn.createStatement(); // ����
			
			rs = st.executeQuery(sql); 
			rs.next();// 0���� 1�� �̵�
			System.out.println(rs.getInt("cnt"));// ��Ī ����ߴ� as cnt �������� count(*)
			// ��Ű����.Ŭ������@16���� ���
//			System.out.println(rs); // toString() ����� ����ϰ� �ʹ�
			
			
//			while(rs.next()) {
//				int emp_id = rs.getInt("emp_id");
//				String emp_name = rs.getString("emp_name");
//				String title = rs.getNString("title");
//				double salary = rs.getDouble("salary");
//				int dept_id = rs.getInt("dept_id");
//				
//				System.out.println(emp_id +"|"+ emp_name + "|"+title + "|"+salary + "|"+dept_id);
//			}
			
			
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
			}catch(SQLException e) {
				
			}
		}
	}

}
