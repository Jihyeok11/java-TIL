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
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 대소문자 구분 - ojdbc6.jar 안에 있는 것을 실행
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc","jdbc"); // 내컴퓨터 로컬에 hr계정으로 접속
			System.out.println("db연결 성공");
			// sql 전송 - 결과 검색
			
			String sql = // db 전송
					"insert into c_emp values(?,?,?,?,?)";//형태잡기. preparedStatement가 ?를 db로 전송시켜준다
			PreparedStatement st = conn.prepareStatement(sql); // 값들을 나중에 넣어주면 되니까 형태만 만들어 준다느 의미의 PrepareStatement이다
			// ? 부분에 넣을 값들을 셋팅해주자 sql 문장에 입력 파라미터값을 세팅
			st.setInt(1,800); // 첫번쨰 값에 800을 넣겠다
			st.setString(2,"김신입"); // 자바에서는 ''는 단일 문자만 가능해서 setString 형태로 ""로 전송해주면 알아서 자동으로 ''로 전송시켜준다
			st.setNString(3, "사원");
			st.setDouble(4, 10000.99);
			st.setInt(5, 10);
			
			//실행
			int insertrow = st.executeUpdate(); // insert 한 행의 개수
			System.out.println(insertrow+" 개의 행 삽입");
			
			
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
