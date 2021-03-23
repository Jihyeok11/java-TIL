package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		try {
		Socket s = new Socket("192.168.219.113", 3333);
		System.out.println("서버와의 연결 중");
		/////////// 서버로부터 클라이언트가 hello server 문자열을 전송 (클라이언트 입장에서는 출력)
		OutputStream o = s.getOutputStream();
		String data = "Hello Server"; // 전송할 데이터
//		o.write(97); // a를 전송
		byte [] data_byte = data.getBytes();
		System.out.println(data_byte.length);
		o.write(data_byte ); // String을 직접 전송할수 없으므로 byte[]로
		InputStream i = s.getInputStream();
		
		//////////서버로부터 클라이언트가 데이터를 입력받아 사용
		/* 1. 방법
		byte b[] = new byte[100];
		i.read(b);
		String input_b = new String(b); // byte []를 다시 String으로
		*/
		// 2. 방법
		Scanner sc = new Scanner(i/*InputStream Reader*/);
		String input_b = sc.nextLine();
		
		System.out.println("서버가 클라이너트로 전송한 데이터 "+input_b);
		
		s.close();
		System.out.println("서버와의 연결 종료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
