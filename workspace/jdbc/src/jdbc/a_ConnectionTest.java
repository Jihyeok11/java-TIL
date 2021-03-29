package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class a_ConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 대소문자 구분 - ojdbc6.jar 안에 있는 것을 실행
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr","hr"); // 내컴퓨터 로컬에 hr계정으로 접속
			System.out.println("db연결 성공");
			// sql 전송 - 결과 검색
			
			
			System.out.println("db연결해제성공");
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}catch(SQLException e) {
			System.out.println("DB 연결정보 확인하세요");
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {}
		}
	}

}
