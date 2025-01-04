package com.pro.model;

public class Restaurant {
	private int id;
	private String name;
	private int deliveryTime;
	private String cuisineType;
	private String address;
	private float rating;
	private boolean isActive;
//	private int adminId;
	private String imgPath;
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
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
//	public int getAdminId() {
//		return adminId;
//	}
//	public void setAdminId(int adminId) {
//		this.adminId = adminId;
//	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "Restaraunt [id=" + id + ", name=" + name + ", deliveryTime=" + deliveryTime + ", cuisineType="
				+ cuisineType + ", address=" + address + ", rating=" + rating + ", isActive=" + isActive +  ", imgPath=" + imgPath + "]";
	}
	public Restaurant(int id, String name, int deliveryTime, String cuisineType, String address, float rating,
			boolean isActive, String imgPath) {
		super();
		this.id = id;
		this.name = name;
		this.deliveryTime = deliveryTime;
		this.cuisineType = cuisineType;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
//		this.adminId = adminId;
		this.imgPath = imgPath;
	}
	public Restaurant(String name, int deliveryTime, String cuisineType, String address, float rating, boolean isActive,
			int adminId, String imgPath) {
		super();
		this.name = name;
		this.deliveryTime = deliveryTime;
		this.cuisineType = cuisineType;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
//		this.adminId = adminId;
		this.imgPath = imgPath;
	}
	public Restaurant(String name, int deliveryTime, String cuisineType, String address, float rating, boolean isActive,
			String imgPath) {
		super();
		this.name = name;
		this.deliveryTime = deliveryTime;
		this.cuisineType = cuisineType;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
		this.imgPath = imgPath;
	}
	public Restaurant() {
		super();
	}


}
