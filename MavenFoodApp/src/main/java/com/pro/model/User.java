package com.pro.model;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private long phonenum;
	private String address;
	private String createdDate;
	private String lastLoginDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(long phonenum) {
		this.phonenum = phonenum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phonenum=" + phonenum + ", address=" + address
				+ ", createdDate=" + createdDate + ", lastLoginDate=" + lastLoginDate + "]";
	}
	public User(int id, String name, String email, String password, long phonenum, String address, String createdDate,
			String lastLoginDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phonenum = phonenum;
		this.address = address;
		this.createdDate = createdDate;
		this.lastLoginDate = lastLoginDate;
	}
	public User(String name, String email, String password, long phonenum, String address, String createdDate,
			String lastLoginDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phonenum = phonenum;
		this.address = address;
		this.createdDate = createdDate;
		this.lastLoginDate = lastLoginDate;
	}
	public User() {
		super();
	}

}
