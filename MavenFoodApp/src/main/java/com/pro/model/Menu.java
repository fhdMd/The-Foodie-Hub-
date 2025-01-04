package com.pro.model;

public class Menu {

	private int id;
	private int restarauntId;
	private String name;
	private int price;
	private String description;
	private String imgPath;
	private boolean isAvailable;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRestarauntId() {
		return restarauntId;
	}
	public void setRestarauntId(int restarauntId) {
		this.restarauntId = restarauntId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", restarauntId=" + restarauntId + ", name=" + name + ", price=" + price
				+ ", description=" + description + ", imgPath=" + imgPath + ", isAvailable=" + isAvailable + "]";
	}
	public Menu(int id, int restarauntId, String name, int price, String description, String imgPath,
			boolean isAvailable) {
		super();
		this.id = id;
		this.restarauntId = restarauntId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imgPath = imgPath;
		this.isAvailable = isAvailable;
	}
	public Menu(int restarauntId, String name, int price, String description, String imgPath, boolean isAvailable) {
		super();
		this.restarauntId = restarauntId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imgPath = imgPath;
		this.isAvailable = isAvailable;
	}
	public Menu(String name, int price, String description, String imgPath, boolean isAvailable) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.imgPath = imgPath;
		this.isAvailable = isAvailable;
	}
	public Menu() {
		super();
	}


}
