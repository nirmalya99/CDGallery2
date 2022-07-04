package com.ntt.domain;
public class Hire {
	private int hireId;
	private int customerId;
	private int albumId;
	private String hireDate;
	private String returnDate;
	private String status;
	private int totalHirePrice;
	
	public Hire(int hireId,int customerId, int aid, String hireDate, String returnDate, String status,
			int totalHirePrice) {
		super();
		this.hireId=hireId;
		this.customerId = customerId;
		this.albumId = aid;
		this.hireDate = hireDate;
		this.returnDate = returnDate;
		this.status = status;
		this.totalHirePrice = totalHirePrice;

	}
	public int getHireId() {
		return hireId;
	}
	public void setHireId(int hireId) {
		this.hireId = hireId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalHirePrice() {
		return totalHirePrice;
	}
	public void setTotalHirePrice(int totalHirePrice) {
		this.totalHirePrice = totalHirePrice;
	}
	@Override
	public String toString() {
		return  ("hireId=" + hireId + ", customerId=" + customerId + ", albumId=" + albumId + ", hireDate="
				+ hireDate + ", returnDate=" + returnDate + " status=" + status
				+ ", totalHirePrice=" + totalHirePrice);
	}
}
