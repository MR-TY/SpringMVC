package com.ty.springmvc.entitys;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String emali;
	private Integer age;

	private Address address;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmali() {
		return emali;
	}

	public void setEmali(String emali) {
		this.emali = emali;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", emali=" + emali + ", age="
				+ age + "]";
	}

	public User(Integer id, String username, String password, String emali, Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.emali = emali;
		this.age = age;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
