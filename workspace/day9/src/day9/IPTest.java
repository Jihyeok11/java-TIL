package day9;

import java.net.InetAddress;

public class IPTest {

	public static void main(String[] args) {
		try {
		InetAddress myip = InetAddress.getLocalHost();
		System.out.println(myip.getHostAddress());
		
		// www.google.com 서버 접속 - ip : port 없다
		// 인터넷 미이저 사이트들 - 서버이름 등록 = domain
		InetAddress[] ips = InetAddress.getAllByName("www.google.com");
		for (InetAddress one : ips) {
			System.out.println(one.getHostAddress()); // 우리가 구글에 들어가면 출력되는 ip를 이용하고 있다
		}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
