package day3;

public class Product {
	// 정보저장 클래스 - private 변수 / public setter/getter 메소드
	private int code;
	private String productName;
	private double price;
	private int balance;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
//	public void setCode(int c) {
//		code = c;
//	}
//	
//	public int getCode() {
//		return code;
//	}
}
