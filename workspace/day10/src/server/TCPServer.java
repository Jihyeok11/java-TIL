package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		// ServerSocket 생성하고 대기, port번호 = 서버프로그램 식별번호 = 2^`6까지 가능(0 - 65535)
		// 그런데 0 - 1024 이내 포트 번호들은 windows 자체 ftp, telnet, http 프로토콜 포트 번호들이 쓰고 있는 경우들이 많다
		// 그래서 1025 - 5000 이내로 권고
		try {
		ServerSocket ss = new ServerSocket(3333); // 서버 시작 연결 대기중
		System.out.println("서버 시작 대기중");
		while(true) {
			Socket s = ss.accept(); // 연결 승인 SOcket 생성(연결점)
			System.out.println("클라이언트와 연결중");
			InputStream i = s.getInputStream();
			byte b[] = new byte[100];
			i.read(b);
			// byte []를 다시 String으로
			String input_b = new String(b);
			System.out.println("클라이언트가 서버로 전송한 데이터 "+input_b);
			
			/////////// 클라이언트로부터 hello Client 문자열을 전송 (서버입장에서는 출력)
			OutputStream o = s.getOutputStream();
			String data = "Hello Client";
//			
			byte [] data_byte = data.getBytes();
			o.write(data_byte ); // String을 직접 전송할수 없으므로 byte[]로
			
			
			s.close();
			System.out.println("클라이언트와 연결 종료");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
