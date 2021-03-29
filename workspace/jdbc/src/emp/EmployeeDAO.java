package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Data Access Object
public class EmployeeDAO {
	public ArrayList<EmployeeDTO> getEmployees(String currentPage, String cntPerPage){ // first, last 줄 때도 기억
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 대소문자 구분 - ojdbc6.jar 안에 있는 것을 실행
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr","hr"); // 내컴퓨터 로컬에 hr계정으로 접속
			System.out.println("db연결 성공");
			
			
			// hr 계정, employees 테이블에서  급여 상위순서
			// 11~20번쨰 사원 이름과 급어 조회
			
	//		/* 1. rownum 사용
			String sql = "select r, first_name, salary "
					+ "from (select rownum as r, first_name, salary from (select * from employees order by salary desc)) where r>=? and r<=?";
	//				"select first_name,rownum, salary from "
	//				+ "(select * from employees order by salary desc)"
	//				+ " where rownum between 11 and 20";
			// rownum 은 크거나 같다(>=), 크다(>)가 불가능하다( 비교숫자가 1이면 가능하긴함 )
	//		 "select r, salary from (select rownum as r, salary from (select * from employee order by salary desc)) where r>=11 and r<20"
	//		*/
			
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
//			st.setInt(1, Integer.parseInt(first));
//			st.setInt(2, Integer.parseInt(last));
			
			st.setInt(1, (Integer.parseInt(currentPage) -1)*Integer.parseInt(cntPerPage));
			st.setInt(2, ( Integer.parseInt(currentPage) * Integer.parseInt(cntPerPage) ));
			// 실행
			rs = st.executeQuery();
			
			// 리턴결과 REsultSet = ArrayList에 복사 - EmployeeDTO
			
			while(rs.next()) {
				String emp_name = rs.getString("first_name");
				int r = rs.getInt("r");
				double salary = rs.getDouble("salary");
				EmployeeDTO dto = new EmployeeDTO();
				dto.setFirst_name(emp_name);
				dto.setSalary(salary);
				list.add(dto);
				
				System.out.println(salary +"|"+ emp_name+"|"+r);
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
				rs.next();
			}catch(SQLException e) { }
		}
		return list;
	}
}
