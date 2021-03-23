import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyTest3 {

	public static void main(String[] args) {
		FileReader fi = null;
		FileWriter fo = null;
		System.out.println("되긴 하니?");
		try {
			fi = new FileReader("./src/FileCopyTest3.java");
			
			// 라인번호 정수 : 왼쪽 라인 시작 추가
			int linenum = 1;
			Scanner sc = new Scanner(fi); // 이제 한 라인을 읽을 수가 있다(\n 이전 문자까지)
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				fo.write(linenum++ +":"+ line+ "\n");
			} 
			
//			fo = new FileWriter("linecopy.txt");
//			while (true) {
//				int result = fi.read();
//				fo.write(result); // a --> 97, 1 ---> 48
//				if(Result == -1) {break;}
//			} 
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fi.close();
				fo.close();
			}catch(IOException e) {}
		}
	}
}