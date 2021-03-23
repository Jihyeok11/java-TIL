package template;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
	Employee(){}
	int id, salary;
	String name;
	Employee(int id, String name, int salary){
		this.id = id;
		this.salary = salary;
		this.name = name;
	}
	public String toString() {
		return id + "|" + name + "|" + salary;
	}
	
	
}
public class MenuTest {

	public static void main(String[] args) {
		System.out.println("=== 다음과 같은 메뉴가 이용 가능합니다 ===");
		System.out.println("1. 사원 등록");
		System.out.println("2. 모든 사원 정보 조회");
		System.out.println("3. 사원 정보 수정");
		System.out.println("4. 사원 정보 삭제");
		System.out.println("5. 프로그램 종료");
		
		
		while(true){
			System.out.println("원하는 번호를 눌러주세요");
			Scanner key = new Scanner(System.in);
			int num = key.nextInt();
			
			if (num == 1) {			
				// 사원 등록 추가 입력 => InsertProcess
				InsertProcess p = new InsertProcess();
				p.process();
				
				// ArrayList에 정의하고 등록 사원을 ArrayList 가장 끝에 저장
				
//				list.add(e1);
//				System.out.println("총 "+list.size()+"명의 사원을 등록했습니다");
				
			}else if (num == 2) {
				System.out.println("모든 사원 정보 조회를 선택하였습니다.");
//				try {
//					FileReader fr = new FileReader("employe.txt");
//					Scanner sc = new Scanner(fr /* InputStream/Reader 둘다 가능 */);
//					while (sc.hasNextLine()) {
//						String line = sc.nextLine(); // 엔터 앞에까지 줄을 읽는다
//						String items[] = line.split("\\|");
//						String id = items[0];
//						String name = items[1];
//						double salary = Double.parseDouble(items[2]);
//						System.out.println(id + "|" + name + "|" + salary*1.5);
//					}
//					sc.close();
//					fr.close();
//					
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			}else if (num == 3) {
				System.out.println("사원 정보 수정을 선택하였습니다.");
				System.out.println("수정을 원하는 사원의 사번을 누르세요");
				String idNum = key.next();
				System.out.println("수정을 원하는 사원의 이름을 누르세요");
				key.nextLine();
				String newName = key.nextLine();
				
				try {
					FileReader fr = new FileReader("employe.txt");
					Scanner sc = new Scanner(fr /* InputStream/Reader 둘다 가능 */);
					
					ArrayList<String> list = new ArrayList<String>();
					while (sc.hasNextLine()) {
						String line = sc.nextLine(); // 엔터 앞에까지 줄을 읽는다
						String items[] = line.split("\\|");
						String id = items[0];
						String name = items[1];
						if (id.contentEquals(idNum)) {
							name = newName;
						}
						String salary = items[2];
						// System.out.println(id + "|" + name + "|" + salary);
						list.add(id + "|" + name + "|" + salary);
						
						// 이제 수정값 저장
					}
					sc.close();
					fr.close();
					FileWriter fw = new FileWriter("employe.txt");
					for (int i=0; i<list.size(); i++) {
						fw.write(list.get(i) +"\n");
					}
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
//				
//				try {
//					FileWriter fw = new FileWriter("employe.txt", true);
//					FileReader fr = new FileReader("employe.txt");
//					Scanner sc = new Scanner(fr);
//					while (sc.hasNextLine()) {
//						String line = sc.nextLine();
//						System.out.println("바꾸기 전" + line);
//						String items[] = line.split("\\|");
//						int id = Integer.parseInt(items[0]);
//						if (id == idNum ){
//							fw.write(items[0]+"|"+newName+"|"+items[2]+"\n");
//						}else {
//							fw.write(line);
//						}
//					}
//					sc.close();
//					
//					fw.close();
//					fr.close();
//				
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				// 수정 사번 입력 : 100
				// 수정 항목 입력 : name 박수정 -> 이름 박수정으로 변경
				// 				salary 3000 -> 현재 급여 + 3000으로 변경
			}else if (num == 4) {
				System.out.println("사원 탈퇴를 선택하였습니다.");
			}else if (num == 5) {
				System.out.println("프로그램을 종료합니다");
				break;
			} else {
				System.out.println("해당 기능의 메뉴를 존재하지 않습니다.");	
			}
			
		}
		// 1을 입력하면 사원 객체 생성
		// 사번 입력 : 
		// 이름 입력 :
		
		/*
		 * 2를 입력하면
		 * 사원 정보 조회를 선택하였습니다. 출력
		 * 
		 * 3을 입력하면
		 * 사원 정보 수정을 선택하였습니다. 출력
		 * 
		 * 4를 입력하면
		 * 사원 탈퇴를 선택하였습니다. 출력
		 * 
		 * 5를 입력하면 프로그램 종료
		 * 
		 * 1~5를 제외한 다른 번호를 누르면
		 * 해당 기능의 메뉴를 존재하지 않습니다. 출력
		 */

	}

}
