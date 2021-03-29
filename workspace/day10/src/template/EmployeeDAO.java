package template;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDAO {
	void insert(EmployeeVO vo) { // Controller의 insert와 이름 똑같이 하는 것이 편리하다
		try { 
			FileWriter fw = new FileWriter("employe.txt",true); // 계속 추가하기 위해 true, day9에 생성될 것
			fw.write(vo.toString()+"\n"); // "사번 :"+ id + ", 이름 :" + name + ", 급여" + salary;
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	void getall() {
		ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			FileReader fr = new FileReader("employe.txt");
			Scanner sc = new Scanner(fr /* InputStream/Reader 둘다 가능 */);
			while (sc.hasNextLine()) {
				String line = sc.nextLine(); // 엔터 앞에까지 줄을 읽는다
				String items[] = line.split("\\|");
				String id = items[0];
				String name = items[1];
				String salary = items[2];
//				System.out.println(id + "|" + name + "|" + salary*1.5);
//				list.add(id + "|" + name + "|" + salary);
			}
			sc.close();
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
