package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class D_SelectTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 대소문자 구분 - ojdbc6.jar 안에 있는 것을 실행
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr","hr"); // 내컴퓨터 로컬에 hr계정으로 접속
			System.out.println("db연결 성공");
			
			
			
			String sql = "select to_char(hire_date, 'yyyy:mm:dd HH24:MMmi:ss') as h_date from employees";
			st = conn.createStatement(); // 실행
			
			rs = st.executeQuery(sql); 
			
			// 패키지명.클래스명@16진수 출력
//			System.out.println(rs); // toString() 결과를 출력하고 싶다
			
			while(rs.next()) {
//				int emp_id = rs.getInt("employee_id");
//				String emp_name = rs.getString("first_name");
//				String title = rs.getNString("job_id");
//				double salary = rs.getDouble("salary");
//				int dept_id = rs.getInt("department_id");
//				java.sql.Date hire_date = rs.getDate("hire_date");
				String hire_date = rs.getString("h_date"); // 원래는 hire_date 인데 위에 sql문을 바꿔서 이렇게
				
//				System.out.println(emp_id +"|"+ emp_name + "|"+title + "|"+salary + "|"+dept_id + "|" + hire_date);
				System.out.println(hire_date);
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
			}catch(SQLException e) {}
		}
	}

}
