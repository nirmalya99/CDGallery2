package com.ntt.domain;

public class Admin {
	private int aid;
	private String password;
	public Admin(int aid, String password) {
		super();
		this.aid = aid;
		this.password = password;
	}
	public int getAid() {
		return aid;
	}
	public void setCid(int aid) {
		this.aid = aid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString()
	{
		return ("AdminID-"+aid+", AdminPassword-"+password).toString();
	}

}
