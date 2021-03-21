package java_과제1_안재완;

import java.util.concurrent.ForkJoinPool.ManagedBlocker;

class Book {
	int price;
	String isbn, title, author, publisher,desc;
	
	public String toString(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		return isbn+"\t| "+title+"\t| "+author + "\t| "+publisher+"\t| "+price+"\t"+desc;
	}
}

class Magazine {
	int year, price, month ;
	String isbn, title, author, publisher, desc ;

	public String toString(String isbn, String title, String author, String publisher, int year, int month, int pirce, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.month = month;
		this.price = price;
		this.desc = desc;
		return isbn+"\t| "+title+"\t| "+author+"\t| "+ publisher+ "\t| " + price + "\t| "+ year+"."+month + "\t| "+ desc;
	}
	
}

public class BookTest {

	public static void main(String[] args) {
		System.out.println("*********************** 도서목록  **************************");
		Book b1 = new Book();
		Magazine m1 = new Magazine();
		System.out.println(b1.toString("21424","Java Pro","김하나","Jaen.kr",15000,"기본문법"));
		System.out.println(b1.toString("35535","OOAD 분석, 설계","소나무","Jaen.kr",3000,null));
		System.out.println(m1.toString("35535","Java World","편집부","androidjava.com",7000,2013,2,null));
	}

}
