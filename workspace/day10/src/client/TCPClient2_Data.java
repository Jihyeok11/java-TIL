package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient2_Data {

	public static void main(String[] args) {
		try {
		Socket s = new Socket("192.168.219.113", 3333);
		System.out.println("서버와의 연결 중");
		
		
		/////////// 서버로부터 클라이언트가 hello server 문자열을 전송 (클라이언트 입장에서는 출력)
		OutputStream o = s.getOutputStream();
		//o.write( byte 1개 / byte[]
		DataOutputStream ds = new DataOutputStream(o);
		String data = "Hello Server";
		ds.writeUTF(data);
		
		
		//////////서버로부터 클라이언트가 데이터를 입력받아 사용
		InputStream i = s.getInputStream();
		DataInputStream ds2 = new DataInputStream(i);
		String input_b = ds2.readUTF();
		System.out.println("서버가 클라이너트로 전송한 데이터 "+input_b);
		
		s.close();
		System.out.println("서버와의 연결 종료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
