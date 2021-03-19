package day7;

import java.util.HashMap;
import java.util.Set;

public class PhoneMapTest {

	public static void main(String[] args) {
		HashMap<String, String[]> phone = new HashMap<String, String[]>();
		
		phone.put("초등친구",new String [] { "010-1111-2222","02-3429-0987","031-9988-1235","이메일@multi.com"});
		phone.put("고등친구",  new String[] {"010-1111-2222","051-9988-1235","asdf@multi.com"});
		phone.put("회사동기",  new String[] {"010-1111-2222","동기메일@multi.com"});
		phone.put("회사상사",  new String[] {"010-1111-2222","02-3429-0987","이메일@multi.com"});
		phone.put("회사상사",  new String[] {"010-1234-5677","031-3429-0987","이메일@multi.com"}); // 수정
		
		System.out.println("총 연락처 갯수는 "+ phone.size()+"개");
		
		// 회사 동기의 연락처 정보 조회
//		String[] phonelist = phone.get("회사동기");
//		// 혹은 Object o = phone.get("회사동기");
//		for(String one : phonelist) {
//			System.out.println(one);
//		}
		
		// 사장님의 연락처 정보 조회
		if (phone.containsKey("사장님")) {
			String[] phonelist2 = phone.get("사장님");
			// 혹은 Object o = phone.get("회사동기");
			for(String one : phonelist2 ) {
				System.out.println(one);
			}
		} else {
			System.out.println("사장 나오라고 그래!");
		}
		Set<String> keys = phone.keySet();
//		Set<String> keys = phone.keySet(); // key 중복 허용 x
		for(String k : keys) {
			System.out.println(k + " : ");
			String[] phonelist = phone.get(k);
			for(String one : phonelist) {
				System.out.print(one + "|");
			}
			System.out.println();
			
		}
	}

}
