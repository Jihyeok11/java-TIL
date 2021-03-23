package day9;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileClassTest {

	public static void main(String[] args) {
		File f = new File("."); // 현재 디렉토리를 의미
		System.out.println("파일 여부 : "+f.isFile());
		try {
			System.out.println("기준경로 : " +f.getCanonicalPath()); // Unhandled exception type IOException 를 해결하기 위해 try, catch
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		File f1 = new File("FileClassTest.java"); // 현재 디렉토리를 의미
		System.out.println("파일 여부 : "+f1.isFile()); // 
		try { // 결과를 보면 패키지까지 알려준다. 즉, 구라치고 있다
			System.out.println("기준경로 : " +f1.getCanonicalPath()); // Unhandled exception type IOException 를 해결하기 위해 try, catch
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		File f2 = new File("src/day9/FileClassTest.java"); // 현재 디렉토리를 의미
		System.out.println("파일 여부 : "+f2.isFile()); // 
		
		File f3 = new File(args[0]);
		System.out.println("f3 파일 여부 : "+f3.isFile()); // 
		try { //찾았다!
			System.out.println("기준경로 : " +f3.getCanonicalPath()); // Unhandled exception type IOException 를 해결하기 위해 try, catch
		} catch(IOException e) {
			e.printStackTrace();
		}
		if(f3.isFile()){ // 파일이냐
			System.out.println(" 읽기 여부 : "+f3.canRead());
			System.out.println(" 쓰기 여부 : "+f3.canWrite());
			System.out.println(" 총길이 : "+f3.length());
			System.out.println(" 최종수정시각 : "+f3.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss"); // 24시간형태는 HH 12형태는 hh
			String nowString = 
					sdf.format(new java.util.Date() ); // 사이에 new를 집어넣은 sdf.format(new java.util.Date())가 현재 시간을 나타낸다
			System.out.println(" 현재 시각 = "+nowString);
			String dateString = 
					sdf.format(new java.util.Date(f.lastModified()) );
			System.out.println(" 최중 수정시각 = "+dateString);
			
			
		} else { // 디렉토리면
			String[] details = f3.list();
			for (String one : details) {
				File ff = new File(one);
				String result = "";
				if(ff.isFile()) {
					result = " :file";
				} else {
					result = " : dir";
				} System.out.println(one + result);
			}
		}
		
		
		
	}

}
