package test.my.project;

import java.util.Date;

public class BoardDTO {
	int no, price;
	String item, contents, seller;
	Date sell_time;

	public BoardDTO() {}

	public BoardDTO(int price, String item, String contents) {
		super();
		this.price = price;
		this.item = item;
		this.contents = contents;
	}
	

	// contents가 필수가 아니라서 뺀 값도 추가
	public BoardDTO(int price, String item) {
		super();
		this.price = price;
		this.item = item;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public Date getSell_time() {
		return sell_time;
	}
	public void setSell_time(Date sell_time) {
		this.sell_time = sell_time;
	}
}
