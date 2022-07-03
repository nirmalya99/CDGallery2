package com.ntt.domain;

public class AlbumDetails {
	private int albumId;
	private int CategoryId;
	private String albumTitle;
	private int hirePrice;
	private int noofCD;
	private String status;
	public AlbumDetails(int albumId, int categoryId, String albumTitle, int hirePrice, int noofCD,String status) {
		super();
		this.albumId = albumId;
		this.CategoryId = categoryId;
		this.albumTitle = albumTitle;
		this.hirePrice = hirePrice;
		this.noofCD = noofCD;
		this.status=status;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public String getAlbumTitle() {
		return albumTitle;
	}
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}
	public int getHirePrice() {
		return hirePrice;
	}
	public void setHirePrice(int hirePrice) {
		this.hirePrice = hirePrice;
	}
	public int getNoofCD() {
		return noofCD;
	}
	public void setNoofCD(int noofCD) {
		this.noofCD = noofCD;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(int noofCD) {
		this.status = status;
	}
	@Override
	public String toString() {
		return ("AlbumId=" + albumId + ", CategoryId=" + CategoryId + ", albumTitle=" + albumTitle
				+ ", hirePrice=" + hirePrice + ", noofCD=" + noofCD + ", status=" + status);
	}
	
}
