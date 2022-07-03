package com.ntt.domain;

public class Customer {
	private int cid;
	private String password;
	public Customer(int cid, String password) {
		super();
		this.cid = cid;
		this.password = password;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString()
	{
		return ("CustomerID-"+cid+", CustomerPassword-"+password).toString();
	
}}
