package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class G_PreparedSelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ��ҹ��� ���� - ojdbc6.jar �ȿ� �ִ� ���� ����
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc","jdbc"); // ����ǻ�� ���ÿ� hr�������� ����
			System.out.println("db���� ����");
			
			
			
			String sql = "select * from c_emp where emp_id between ? and ?";
			st = conn.prepareStatement(sql); // ����
			st.setInt(1, 200);
			st.setInt(2, 300);
			
			
			// ����
			rs = st.executeQuery();
			
			while(rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String title = rs.getNString("title");
				double salary = rs.getDouble("salary");
				int dept_id = rs.getInt("dept_id");
				
				System.out.println(emp_id +"|"+ emp_name + "|"+title + "|"+salary + "|"+dept_id);
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
			}catch(SQLException e) {
				
			}
		}
	}

}
