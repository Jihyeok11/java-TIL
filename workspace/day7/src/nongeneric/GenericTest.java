package nongeneric;
class Apple{
	String origin = "대구";
}
class Paper{
	String size = "A4";
}
class Box<T>{
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
public class GenericTest {
	public static void main(String[] args) {
		Apple a = new Apple();
		Paper p = new Paper();
		Box<Apple> appleBox = new Box<Apple>(a); // new Box(a)도 가능
		Box<Paper> paperBox = new Box(p);
		
		System.out.println(appleBox.getO());
		System.out.println(((Apple)appleBox.getO()).origin);
		System.out.println(((Paper)paperBox.getO()).size);

	}

}
