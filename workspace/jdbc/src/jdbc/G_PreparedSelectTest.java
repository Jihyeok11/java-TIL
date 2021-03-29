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
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 대소문자 구분 - ojdbc6.jar 안에 있는 것을 실행
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc","jdbc"); // 내컴퓨터 로컬에 hr계정으로 접속
			System.out.println("db연결 성공");
			
			
			
			String sql = "select * from c_emp where emp_id between ? and ?";
			st = conn.prepareStatement(sql); // 실행
			st.setInt(1, 200);
			st.setInt(2, 300);
			
			
			// 실행
			rs = st.executeQuery();
			
			while(rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String title = rs.getNString("title");
				double salary = rs.getDouble("salary");
				int dept_id = rs.getInt("dept_id");
				
				System.out.println(emp_id +"|"+ emp_name + "|"+title + "|"+salary + "|"+dept_id);
			}
			
			
			System.out.println("db연결해제성공");
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}catch(SQLException e) {
			System.out.println("DB 연결정보 확인하세요");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				conn.close(); // 조회 역순
			}catch(SQLException e) {
				
			}
		}
	}

}
