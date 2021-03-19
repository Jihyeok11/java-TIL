package day7;

import java.util.ArrayList;

class SameSentence{
	String[] compare(ArrayList<String> list1, ArrayList<String> list2){
		String[] result = null;
		ArrayList<String> resultList = new ArrayList();
		
		
		if (list1.size() == list2.size()) { // 같으면 2개 ArrayList 각 인덱스마다 문자열 내욜 비교하고 같은 문자열만 result에 넣어서 리턴
			int idx = 0;
			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i).equals(list2.get(i))) {
					resultList.add(list1.get(i));
					// result[idx] = list1.get(i);
					// idx += 1;
				}
			}
		}else { // (최수 작은 쪽의 개수) n 개, 최대 m개의 리스트 입니다"를 result 배열에 넣어서 리턴
			// result[0] = "최소 "+ list1.size()+"개, 최대 " + list2.size()+"개개의 리스트 입니다";
			resultList.add("최소 "+ list1.size()+"개, 최대 " + list2.size()+"개개의 리스트 입니다");
		}
		
		result = new String[resultList.size()];
		result = resultList.toArray(result);
		return result;
		
//		int len1 = list1.size();
//		int len2 = list2.size();
//		if (len1==len2) {
//			for(int i = 0; i<len1; i++) {
//				if (list1.get(i).equals(list2.get(i))) {
//					result[i] = list1.get(i);
//				}
//			}
//		}
//		return result; 
	}
}

public class SameSentenceTest {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("자바는 객체지향 언어입니다");
		list1.add("우리는 멀티캠퍼스에서 자바를 배우는 중입니다");
		list1.add("오늘은 컬렉션 프레임워크를 배우죠! ");
		list1.add("람다, 입출력과 네트워크도 배울 예정입니다 ");
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("자바는 객체지향 언어입니다");
		list2.add("우리는 multicampus에서 자바를 배우는 중입니다");
		list2.add("오늘은 컬렉션 프레임워크를 배우죠! ");
		list2.add("입출력과 네트워크도 배울 예정입니다 ");
		
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("자바는 객체지향 언어입니다");
		list3.add("우리는 multi에서 자바를 배우는 중입니다");
		list3.add("오늘은 컬렉션 프레임워크를 배우죠! ");
		
		SameSentence ss = new SameSentence();
		
		String r1[] = ss.compare(list1,list2);
		for (String one : r1) {
			System.out.println(one);
		}
		String r2[] = ss.compare(list1,list3);
		for (String one : r2) {
			System.out.println(one);
		}

	}
	
	
	

}
