package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class a_ConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ��ҹ��� ���� - ojdbc6.jar �ȿ� �ִ� ���� ����
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr","hr"); // ����ǻ�� ���ÿ� hr�������� ����
			System.out.println("db���� ����");
			// sql ���� - ��� �˻�
			
			
			System.out.println("db������������");
		}catch (ClassNotFoundException e) {
			System.out.println("����̹� ���� Ȯ���ϼ���");
		}catch(SQLException e) {
			System.out.println("DB �������� Ȯ���ϼ���");
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {}
		}
	}

}
