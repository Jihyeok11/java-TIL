package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_InsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ��ҹ��� ���� - ojdbc6.jar �ȿ� �ִ� ���� ����
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc","jdbc"); // ����ǻ�� ���ÿ� hr�������� ����
			System.out.println("db���� ����");
			// sql ���� - ��� �˻�
			
			// jdbc ���� c_emp ���̺� ������ ����
			// 600 ���ڹ� ���� 10000 10
			// �ڹ� "sql" ���� - db ���� - ��� �˻�
			String sql = // db ����
//					"insert into c_emp values(600, '���ڹ�', '�ӿ�',10000,10)";
					"insert into c_emp values("+args[0]+", '"+args[1]+"', '"+args[2]+"',"+args[3]+","+args[4]+")";
			Statement st = conn.createStatement(); // ����
			int insertrow = st.executeUpdate(sql); // insert �� ���� ����
			System.out.println(insertrow+" ���� �� ����");
			
			
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
