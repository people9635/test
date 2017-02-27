package com.tccp.entity;

/**
 * 用户
 * @author tccp项目组
 *
 */
public class User {

	private int user_id;
	private String username;
	private String age;
	private String tel;
	
	public User(){
		super();
	}
	
	public User(int user_id, String username, String age) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.age = age;
	}
	
	public User(int user_id, String username, String age, String tel) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.age = age;
		this.tel = tel;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + 
				", age=" + age + "]";
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
