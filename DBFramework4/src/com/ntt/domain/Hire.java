package com.ntt.domain;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Hire {
	private int hireId;
	private int customerId;
	private String albumId;
	private Date hireDate;
	private Date returnDate;
	private String status;
	private int totalHirePrice;
	
	public Hire(int hireId, int customerId, String albumId, Date hireDate, Date returnDate, String status,
			int totalHirePrice) {
		super();
		this.hireId = hireId;
		this.customerId = customerId;
		this.albumId = albumId;
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
	public String getAlbumId() {
		return albumId;
	}
	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
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
		return "Hire [hireId=" + hireId + ", customerId=" + customerId + ", albumId=" + albumId + ", hireDate="
				+ hireDate + ", returnDate=" + returnDate + " status=" + status
				+ ", totalHirePrice=" + totalHirePrice + "]";
	}
}
