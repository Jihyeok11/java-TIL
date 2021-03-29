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
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 대소문자 구분 - ojdbc6.jar 안에 있는 것을 실행
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr","hr"); // 내컴퓨터 로컬에 hr계정으로 접속
			System.out.println("db연결 성공");
			
			
			// hr 계정, employees 테이블에서  급여 상위순서
			// 11~20번쨰 사원 이름과 급어 조회
			
//			/* 1. rownum 사용
			String sql = "select r, first_name, salary "
					+ "from (select rownum as r, first_name, salary from (select * from employees order by salary desc)) where r>=? and r<=?";
//					"select first_name,rownum, salary from "
//					+ "(select * from employees order by salary desc)"
//					+ " where rownum between 11 and 20";
			// rownum 은 크거나 같다(>=), 크다(>)가 불가능하다( 비교숫자가 1이면 가능하긴함 )
//			 "select r, salary from (select rownum as r, salary from (select * from employee order by salary desc)) where r>=11 and r<20"
//			*/
			
			/* 2. row_number();-- where 구문을 못쓰기 때문에 subquery 사용
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
			// 실행
			rs = st.executeQuery();
			
			while(rs.next()) {
				String emp_name = rs.getString("first_name");
				int rank = rs.getInt("r");
				double salary = rs.getDouble("salary");
//				int rank = rs.getInt("r");
				System.out.println(salary +"|"+ emp_name+"|"+rank);
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
