import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {
		// 명령형 매개변수 입력
		// a.txt, b.txt
		// src/FileCopyTest.java를 b.txt에 ==> (b.txt. 파일 존재 x) ==> b.txt 생성
		// src/FileClassTest.java를 b.txt ==> (b.txt 출력 파일 존재 o) ==> 기존 내용 삭제
		// src/FileClassTest.java를 b.txt (true) ==> (b.txt 출력 파일 존재 o) ==> 기존 내용 유지, 추가
		try {
		FileInputStream fi = new FileInputStream(args[0]);
		// 실제 입력 파일이 존재하지 않으면 오류가 발생한다. 
		// 출력 파일은 없어도 생성이 된다.
		// 입력 파일이 없었을 때의 대처법
		/*
		 * File f = new File(args[0]);
		 * if(f.exists()){
		 * 	FileInputStream fi = new FIleInputStream(f);
		 */
//		FileOutputStream fo = new FileOutputStream(args[1], true); //true로 하면 기존 내용 유지, false(default)이면 내용 삭제
		FileWriter fo = new FileWriter(args[1], true); 
		while(true) {
			int result = fi.read(); // read이므로 1바이트, a이면 result는 97이다
			fo.write(result); // int 데이터 1바이트만 출력 ==> 97이였으면 A로 출력
			if (result == -1) {break;}
			
		}
		fi.close();
		fo.close();
		
		} catch(IOException e) { // a.txt가 없을때 발생하는 FileNotFoundException도 IOException에서 걸러졌다
			e.printStackTrace();
		}

	}

}
