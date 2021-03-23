package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MeberServer {

	public static void main(String[] args) {
		try {
		ServerSocket ss = new ServerSocket(3332); // 서버 시작 연결 대기중
		System.out.println("서버 시작 대기중");
		while(true) {
			Socket s = ss.accept(); // 연결 승인 SOcket 생성(연결점)
			System.out.println("클라이언트와 연결중");
			
			InputStream i = s.getInputStream();
			DataInputStream ds = new DataInputStream(i);
			String inform = ds.readUTF();
			System.out.println("클라이언트가 서버로 전송한 데이터 "+inform);
			
			String ids [] = {"java", "jsp", "spring"};
			String informArr [] = inform.split(" ");
			String id = informArr[0];
			String pw = informArr[1];
			boolean duplicate = false;
			for (String one : ids) {
				if (id.equals(one)) {
					duplicate = true;
					break;
				}
			}
			/////////// 클라이언트로부터 hello Client 문자열을 전송 (서버입장에서는 출력)
			OutputStream o = s.getOutputStream();
			DataOutputStream ds2 = new DataOutputStream(o);
			if (duplicate == true) {
				ds2.writeUTF("다른 아이디를 사용하세요");
				
			} else {
				ds2.writeUTF(id+"는 사용 가능합니다");
			}
			s.close();
			System.out.println("클라이언트와 연결 종료");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
