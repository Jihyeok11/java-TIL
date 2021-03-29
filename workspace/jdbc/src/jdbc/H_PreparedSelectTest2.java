package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H_PreparedSelectTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ��ҹ��� ���� - ojdbc6.jar �ȿ� �ִ� ���� ����
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr","hr"); // ����ǻ�� ���ÿ� hr�������� ����
			System.out.println("db���� ����");
			
			
			// hr ����, employees ���̺���  �޿� ��������
			// 11~20���� ��� �̸��� �޾� ��ȸ
			
//			/* 1. rownum ���
			String sql = "select r, first_name, salary "
					+ "from (select rownum as r, first_name, salary from (select * from employees order by salary desc)) where r>=? and r<=?";
//					"select first_name,rownum, salary from "
//					+ "(select * from employees order by salary desc)"
//					+ " where rownum between 11 and 20";
			// rownum �� ũ�ų� ����(>=), ũ��(>)�� �Ұ����ϴ�( �񱳼��ڰ� 1�̸� �����ϱ��� )
//			 "select r, salary from (select rownum as r, salary from (select * from employee order by salary desc)) where r>=11 and r<20"
//			*/
			
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
			st.setInt(1, 10);
			st.setInt(2, 30);
			// ����
			rs = st.executeQuery();
			
			while(rs.next()) {
				String emp_name = rs.getString("first_name");
				int rank = rs.getInt("r");
				double salary = rs.getDouble("salary");
//				int rank = rs.getInt("r");
				System.out.println(salary +"|"+ emp_name+"|"+rank);
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
