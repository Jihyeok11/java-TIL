package generic2;

class Fruit{
	String name = "과일";
}
class Apple extends Fruit{
	String origin;
	Apple(String name, String origin){
		this.name = name;
		this.origin = origin;
	}
}

class Orange extends Fruit {
	String imported;
	Orange(String name, String imported){
		this.name = name;
		this.imported = imported;
	}
}

class Paper {
	String size = "A4";
}

class Box<T extends Fruit> {
	// 멤버변수, 생성자, 메소드는 순서가 없다 그러나 이런 순으로 쓰는거로 하자
	T o;
	Box(T o){
		this.o = o;
	}
	public T getO() {
		return o;
	}
	public void setO(T o) {
		this.o = o;
	}
}

class BoxManager{
	public void test (Box <? extends Fruit> b) { // Box는 Fruit이나 Fruit으로 상속받은 값만 사용하겠다고 선언
		System.out.println(b.getO().name);
	}
}
public class GenericTest {

	public static void main(String[] args) {
		Fruit f = new Fruit();
		Apple a = new Apple("사과", "대구");
		Orange o = new Orange("오렌지", "켈리포니아");
		Paper p = new Paper();
		Box<Apple> box1 = new Box<Apple>(a);
		Box<Orange> box2 = new Box<Orange>(o);
		Box<Fruit> box3 = new Box<Fruit>(f);
		
		// Box<Paper> box4 = new Box<Paper>(p); paper는 Fruit클래스를 상속받지 못하였으므로 불가능
		BoxManager m = new BoxManager();
		m.test(box1);
		m.test(box2);
		m.test(box3);
		// m.test(new Box<Paper>(p));

	}

}
