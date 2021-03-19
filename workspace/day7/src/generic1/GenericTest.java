package generic1;
class Apple{
	String origin = "대구";
}
class Paper{
	String size = "A4";
}
class Box<T, K>{ // 제너릭!
	T t1;
	K k1;
	String name = "상자";
	
	Box(T t1,K k1){
		this.t1 = t1;
		this.k1 = k1;
	}
	public T getT1() {
		return t1;
	}
	public K getK1() {
		return k1;
	}
	public void setT1(T t1) {
		this.t1 = t1;
	}
	public void setK1(K k1) {
		this.k1 = k1;
	}
}

class BoxManager{ // 얘는 Generic이 아니다 ( <> 사용 안햇으니까 )
	
	// 클래스 순서가 apple, Paper가 맞는지 테스트
	public <P1, P2> Box<P1,P2> test(P1 a, P2 p) { // 맨 앞에 있는 <P1,P2> 뜻은  P1과 P2는 내가 전달하는 파라미터 이다 라는 뜻
		Box<P1, P2> box2 = new Box<P1, P2>(a, p);
		
		return box2;
	}
}

public class GenericTest {
	public static void main(String[] args) {
		Apple a = new Apple();
		Paper p = new Paper();
		Box<Apple, Paper> box = new Box<Apple, Paper>(a, p); // new Box(a)도 가능
		System.out.println(box.getT1().origin);
		System.out.println(box.getK1().size);
		
		BoxManager manager = new BoxManager();
		Box<Apple, Paper> box2 = manager.test(a, p);
		System.out.println(box2.getT1());
		System.out.println(box2.getT1().origin);
	}

}
