package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class F_PreparedUpdateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 대소문자 구분 - ojdbc6.jar 안에 있는 것을 실행
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc","jdbc"); // 내컴퓨터 로컬에 hr계정으로 접속
			System.out.println("db연결 성공");
			
			
			String sql = "update c_emp set salary=salary+? where title=?";
			st = conn.prepareStatement(sql);
			
			st.setInt(1,Integer.parseInt(args[1])); // 첫번쨰 값에 800을 넣겠다
			st.setString(2,args[0]);

			int updaterow = st.executeUpdate(); 
			System.out.println(updaterow);
			
			
			System.out.println("db연결해제성공");
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}catch(SQLException e) {
			System.out.println("DB 연결정보 확인하세요");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {}
		}
	}

}
