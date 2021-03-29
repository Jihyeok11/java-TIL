package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class B_UpdateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ��ҹ��� ���� - ojdbc6.jar �ȿ� �ִ� ���� ����
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc","jdbc"); // ����ǻ�� ���ÿ� hr�������� ����
			System.out.println("db���� ����");
			// sql ���� - ��� �˻�
			/*
			 * update ���̺� ��
			 * set �����÷��̸�=���氪
			 * where �������ǽ�
			 * update c_empt set title = (select title from c_emp where emp_id = 100)
			 * where emp_name = '���ڹ�'
			 * 
			 * ------
			 * �븮���� �޿��� 5000�� �λ��ض�
			 * 
			 * "delete c_empt where emp_id=100" �ϸ� ������
			 */
			String sql = "update c_emp set salary=salary+5000"
					+
					" where title='�븮'";
			Statement st = conn.createStatement(); // ����
			int updaterow = st.executeUpdate(sql); 
			System.out.println(updaterow+" ���� �� ����");
			
			
			System.out.println("db������������");
		}catch (ClassNotFoundException e) {
			System.out.println("����̹� ���� Ȯ���ϼ���");
		}catch(SQLException e) {
			System.out.println("DB �������� Ȯ���ϼ���");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {}
		}
	}

}
