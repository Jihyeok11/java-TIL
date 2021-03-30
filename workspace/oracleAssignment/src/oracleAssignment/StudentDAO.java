package oracleAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAO {
	public void insertStudent() {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "test", "test");
			System.out.println("학번을 입력하세요");
			int No = sc.nextInt();
			sc.nextLine();
			System.out.println("학생 이름을 입력하세요");
			String name = sc.nextLine();
			System.out.println("전공을 입력하세요");
			String det = sc.nextLine();
			System.out.println("주소를 입력하세요");
			String addr = sc.nextLine();
			System.out.println("전화번호를 입력하세요");
			String tel = sc.nextLine();
			StudentDTO dto = new StudentDTO();
			dto.setNo(No);
			dto.setName(name);
			dto.setDet(det);
			dto.setAddr(addr);
			dto.setTel(tel);
			String insertSQL = "insert into Student values(?,?,?,?,?)";
			pt = conn.prepareStatement(insertSQL);
			pt.setInt(1, No);
			pt.setNString(2, name);
			pt.setNString(3, det);
			pt.setNString(4, addr);
			pt.setNString(5, tel);
			int cnt = pt.executeUpdate();
			System.out.println("완료되었습니다");
		}catch (ClassNotFoundException e){
			System.out.println("드라이버 세팅 확인하세요");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("DB 연결정보를 확인하세요");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println("test");
				e.printStackTrace();}
		}
	}
	public ArrayList<StudentDTO> printAllStudents() {
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs =  null;
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection
			("jdbc:oracle:thin:@127.0.0.1:1521:xe", "test", "test");
			String selectSQL = "SELECT * FROM Student";
			pt = con.prepareStatement(selectSQL);
			rs = pt.executeQuery(); //컬럼명 위치
			while(rs.next()) { //번호 제목  작성자 조회수 
				StudentDTO dto = new StudentDTO();
				dto.setNo(rs.getInt("No"));
				dto.setName(rs.getNString("name"));
				dto.setDet(rs.getString("det"));
				dto.setAddr(rs.getString("addr"));
				dto.setTel(rs.getString("tel"));
				list.add(dto);
			}

		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 정보를 확인하세요");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			pt.close();
			con.close(); // db 더이상 접속 허용x
			}catch(SQLException e) { }
		}
		return list;
		
	}
}
