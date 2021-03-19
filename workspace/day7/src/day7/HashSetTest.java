package day7;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
//		HashSet set = new HashSet();
//		set.add(100);
//		set.add(3.14);
//		set.add("java");
//		Iterator it = set.iterator(); // 반복자(set 안에 저장데이터들을 순서없이 모음)
//		while(it.hasNext()) { // 다음 데이터 존재하는지 여부를 물어보고
//			Object o = it.next(); // 다음 데이터 조회
//			System.out.println(o.toString());
//		}
		// ArrayLIst와 마찬가지로 원하는 타입만 저장할 수 있다
		HashSet<Employee> set = new HashSet<Employee>();
		Employee e1 = new Employee(400, "박부장", 88000.99);
		set.add(e1);
		set.add(e1); // 중복 저장시도해도 저장 안된다.
//		set.add(new Employee(400, "박부장", 88000.99)); // e1은 객체를 가리키는 주소를 말한다. 이 값은 새로운 객체를 생성하게 된다.
		System.out.println(set.size());
		
//		for(int i=0;i<set.size(); i++) {
//			set.get(i); set은 인덱스 순서가 없으므로 get 을 사용할 수 없다
//		}
		Iterator<Employee> it = set.iterator(); // 반복자(set 안에 저장데이터들을 순서없이 모음)
		while(it.hasNext()) { // 다음 데이터 존재하는지 여부를 물어보고
			Employee o = it.next(); // 다음 데이터 조회
			System.out.println(o.name);
		}
		
		HashSet<Integer> lotto = new HashSet<Integer>();
		// 1부터 45 사이의 난수 생성
		// lotto 출력하면 6개 정수 나오도록 처리(저장 - 조회 출력 순서 일치하지 않아도 된다)
		while (lotto.size() <6) {
			int a = (int)(Math.random()*45)+1 ;
			lotto.add(a);
		}
		Iterator lt = lotto.iterator(); // Iterator<Integer> lt = lotto.iterator();
		while (lt.hasNext()) {
			Object o = lt.next();
			System.out.println(o.toString());
		}
	}

}
