package test.my.project;

import java.util.Date;

public class MemberDTO {
	private String id, password,username;
	private Date create_time;
	
	public MemberDTO() {}
	
	public MemberDTO(String id, String password, String username) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	
}