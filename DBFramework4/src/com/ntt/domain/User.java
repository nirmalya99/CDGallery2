package com.ntt.domain;

public class User {
private int  customerId;
private String password;
private String firstName;
private String secondName;
private int dob;
private String address;
private long contactNo;
private long creditCardNo;
private	String creditCardType;
private	int creditCardExpDate;
public User(int customerId, String password, String firstName, String secondName, int dob, String address,
		long contactNo, long creditCardNo, String creditCardType, int creditCardExpDate) {
	super();
	this.customerId = customerId;
	this.password = password;
	this.firstName = firstName;
	this.secondName = secondName;
	this.dob = dob;
	this.address = address;
	this.contactNo = contactNo;
	this.creditCardNo = creditCardNo;
	this.creditCardType = creditCardType;
	this.creditCardExpDate = creditCardExpDate;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getSecondName() {
	return secondName;
}
public void setSecondName(String secondName) {
	this.secondName = secondName;
}
public int getDob() {
	return dob;
}
public void setDob(int dob) {
	this.dob = dob;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getContactNo() {
	return contactNo;
}
public void setContacttNo(long contacttNo) {
	this.contactNo = contacttNo;
}
public long getCreditCardNo() {
	return creditCardNo;
}
public void setCreditCardNo(long creditCardNo) {
	this.creditCardNo = creditCardNo;
}
public String getCreditCardType() {
	return creditCardType;
}
public void setCreditCardType(String creditCardType) {
	this.creditCardType = creditCardType;
}
public int getCreditCardExpDate() {
	return creditCardExpDate;
}
public void setCreditCardExp(int creditCardExpDate) {
	this.creditCardExpDate = creditCardExpDate;
}
@Override
public String toString() {
	return ("customerId=" + customerId + ", password=" + password + ", firstName=" + firstName + ", secondName="
			+ secondName + ", dob=" + dob + ", address=" + address + ", contactNo=" + contactNo + ", creditCardNo="
			+ creditCardNo + ", creditCardType=" + creditCardType + ", creditCardExpDate=" + creditCardExpDate);
}

}
