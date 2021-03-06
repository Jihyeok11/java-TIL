package edu;

abstract class Shape{ //여기에 final을 추가할 수 없다. abstract는 상속을 해야하는데 final은 반대로 안할 떄 쓰는 것이다.
	abstract void area(); // 얘는 무조건 상속해야 한다. 메소드를 쓸거면 클래스에도 abstract를 써야한다
	void tell() { // 얘는 	
	}
}

class Rectangle extends Shape{
	int w,h;
	Rectangle(int w, int h){ // 생성자 w,h를 매개변수로 쓰겠다
		this.w = w; //앞에서 선언한 w값 변경
		this.h = h; //앞에서 선언한 h값 변경
	}
	void area() { // abstract 를 통해 상속받으므로 area는 필수이다.
		System.out.println(
				"가로 = "+ + w + "이고 세로 = "+ h + " 인 사각형의 면적은 "+w*h);
	}
}


class Circle extends Shape{
	int r;
	double pi = 3.14;
	Circle(int r){ 
		this.r = r; //앞에서 선언한 r값 변경
	}
	void area() { // 상위가 modifier가 default 이므로 여기 modifier 는 protected 혹은 public이 가능하다
		System.out.println(
				"반지름의 길이가 "+r+"인 원의 면적은" + r*r*2*pi);
	}
}

public class AbstractTest {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(5,8);
		r1.area();
		Circle r2 = new Circle(5);
		r2.area();
	}

}
