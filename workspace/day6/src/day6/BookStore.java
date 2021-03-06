//BookStore.java -->수정 불필요
//Book.java -->작성
//BookMgr.java-->작성
//
//public class BookStore {
//	public static void main(String[] args) {
//		Book booklist[] = new Book[5];
//
//		Book book1 = new Book("Java Program", 25000);
//		Book book2 = new Book("JSP Program", 15000);
//		Book book3 = new Book("SQL Fundamentals", 30000);
//		Book book4 = new Book("JDBC Program", 28000);
//		Book book5 = new Book();
//		book5.setTitle("Spring Program");
//		book5.setPrice(34000);
//		booklist[0] = book1;
//		booklist[1] = book2;
//		booklist[2] = book3;
//		booklist[3] = book4;
//		booklist[4] = book5;
//		
//		BookMgr mgr = new BookMgr(booklist);
//		System.out.println("=== 책 목록  정보 ===");
//		System.out.println(mgr);
//		System.out.println(mgr/*.toString());
//	}
//}
//
//Book 클래스의 제약조건
//1. 책 제목(title)과 가격(price)정보를 저장하는 
//필드변수가 있어야 한다.
//2. 필드변수는 모두 private 접근제한자를 가져야 한다. 
//3. 필드변수를 모두 초기화하는 생성자가 있어야 한다.
//( main 메소드 Book객체생성 문장 오류 발생 x:
//생성자 추가)
//4. 필드변수에 값을 설정하고 리턴하는 
//setter/getter 메서드가 있어야 한다.
//setTitle(String title) : 멤버변수 title 값을 셋팅하는 메소드
//String getTitle() : 멤버변수 title 값을 반환하는 메소드
//void setPrice(int price) : 멤버변수 price 값을 셋팅하는 메소드
//int getPrice() : 멤버변수 price 값을 반환하는 메소드 
//5. setter/getter 메서드는 모두 public 접근제한자를 가져야 한다. 
//
//BookMgr 클래스의 제약조건 
//1. 책(Book) 객체 여러 개를 저장할 수 있는 
//책 목록(booklist)이라는 배열을 필드변수로 가져야 한다. 
//2. 책 목록(booklist)이라는 배열 변수를 
//초기화하는 생성자를 작성해야 한다. 
//3. 책 목록  정보를 출력한다.
//책 이름은 20자리 문자열, 왼쪽 정렬
//
//[실행결과]
//
//=== 책 목록  정보 ===
//Java Program        	 | 25000
//JSP Program         	 | 15000
//SQL Fundamentals    	 | 30000
//JDBC Program        	 | 28000
//Spring Program      	 | 34000
//전체 책 가격의 합 : 132000
//


package day6;

class Book{
	private String title;
	private int price;
	Book(){}
	Book(String title, int price){
		this.title = title;
		this.price = price;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	
	// source - Generate getters and setters 를 이용하면 아래처럼
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public int getPrice() {
//		return price;
//	}
//	public void setPrice(int price) {
//		this.price = price;
//	}
}

class BookMgr {
	Book booklist []; // 아직 몇개의 Book이 들어가는지 모르기떄문에 new Book [n] 불가능
	BookMgr(Book [] booklist){
		this.booklist = booklist;
	}
	
	@Override
	public String toString() {
		String result = "";
		int total = 0;
		for (int i=0; i<booklist.length; i++) {
			result += String.format("%-20s", booklist[i].getTitle())+"|"+booklist[i].getPrice() + "\n";
			total += booklist[i].getPrice();
		}
		result += "전체 책 가격의 합 : " + total ;
		return result;
	}

	
}

public class BookStore {
	public static void main(String[] args) {
		Book booklist[] = new Book[5];

		Book book1 = new Book("Java Program", 25000);
		Book book2 = new Book("JSP Program", 15000);
		Book book3 = new Book("SQL Fundamentals", 30000);
		Book book4 = new Book("JDBC Program", 28000);
		Book book5 = new Book();
		book5.setTitle("Spring Program");
		book5.setPrice(34000);
		
		// booklist 배열 저장 초기화
		booklist[0] = book1;
		booklist[1] = book2;
		booklist[2] = book3;
		booklist[3] = book4;
		booklist[4] = book5;
//		for ( int i=0; i<booklist.length;i++) {
//			System.out.println(booklist[i].title);
//			System.out.println(booklist[i].price);
//		}
		
		
		BookMgr mgr = new BookMgr(booklist);
		System.out.println("=== 책 목록  정보 ===");
		System.out.println(mgr); // 패키지명 .
//		System.out.println(mgr/*.toString());
	}
}
