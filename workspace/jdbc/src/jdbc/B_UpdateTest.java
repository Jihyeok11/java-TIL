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
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 대소문자 구분 - ojdbc6.jar 안에 있는 것을 실행
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc","jdbc"); // 내컴퓨터 로컬에 hr계정으로 접속
			System.out.println("db연결 성공");
			// sql 전송 - 결과 검색
			/*
			 * update 테이블 명
			 * set 변경컬럼이름=변경값
			 * where 변경조건식
			 * update c_empt set title = (select title from c_emp where emp_id = 100)
			 * where emp_name = '이자바'
			 * 
			 * ------
			 * 대리들의 급여를 5000씩 인상해라
			 * 
			 * "delete c_empt where emp_id=100" 하면 삭제됨
			 */
			String sql = "update c_emp set salary=salary+5000"
					+
					" where title='대리'";
			Statement st = conn.createStatement(); // 실행
			int updaterow = st.executeUpdate(sql); 
			System.out.println(updaterow+" 개의 행 삽입");
			
			
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
