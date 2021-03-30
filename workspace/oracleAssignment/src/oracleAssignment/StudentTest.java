package oracleAssignment;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentTest {
	public static void main(String[] args) {
		/* 수업시간에 한것 처럼
		 * 1을 누르면 Insert를,
		 * 2를 누르면 모든 값들을 조회,
		 * 3을 누르면 while문을 종료하게 만들었습니다
		 */
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("학생 데이터");
			System.out.println("1. 학생 추가");
			System.out.println("2. 모든 학생들 조회");
			System.out.println("3. 프로그램 종료");
			System.out.println("원하는 번호를 누르고 엔터를 눌러주세요");
			try {
				int num = sc.nextInt();
				if (num==1) {
					System.out.println("잠시만 기다려주세요");
					StudentDAO dao = new StudentDAO();
					dao.insertStudent();
					
				}else if (num==2) {
					StudentDAO dao = new StudentDAO();
					ArrayList<StudentDTO> list = dao.printAllStudents();
					for(StudentDTO dto : list) {
						System.out.println(dto.getNo() +"\t" +dto.getName()+"\t" +dto.getDet()+"\t" +dto.getAddr()+"\t" +dto.getTel() );
					}
				}else if (num==3) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}else {
					System.out.println("1~3의 값만 입력해주세요");
				}
			}catch(InputMismatchException e) {
				System.out.println("1~3의 값만 입력해주세요");
				sc.nextLine();
			}
			
		}
	}
}
