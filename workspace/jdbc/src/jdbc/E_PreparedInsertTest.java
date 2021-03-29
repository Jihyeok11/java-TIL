package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class E_PreparedInsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ��ҹ��� ���� - ojdbc6.jar �ȿ� �ִ� ���� ����
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc","jdbc"); // ����ǻ�� ���ÿ� hr�������� ����
			System.out.println("db���� ����");
			// sql ���� - ��� �˻�
			
			String sql = // db ����
					"insert into c_emp values(?,?,?,?,?)";//�������. preparedStatement�� ?�� db�� ���۽����ش�
			PreparedStatement st = conn.prepareStatement(sql); // ������ ���߿� �־��ָ� �Ǵϱ� ���¸� ����� �شٴ� �ǹ��� PrepareStatement�̴�
			// ? �κп� ���� ������ ���������� sql ���忡 �Է� �Ķ���Ͱ��� ����
			st.setInt(1,800); // ù���� ���� 800�� �ְڴ�
			st.setString(2,"�����"); // �ڹٿ����� ''�� ���� ���ڸ� �����ؼ� setString ���·� ""�� �������ָ� �˾Ƽ� �ڵ����� ''�� ���۽����ش�
			st.setNString(3, "���");
			st.setDouble(4, 10000.99);
			st.setInt(5, 10);
			
			//����
			int insertrow = st.executeUpdate(); // insert �� ���� ����
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
