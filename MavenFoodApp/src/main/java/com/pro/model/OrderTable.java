package com.pro.model;

public class OrderTable {
	private int id;
	private int userId;
	private int restarauntId;
	private int orderTime;
	private float totalAmount;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRestarauntId() {
		return restarauntId;
	}
	public void setRestarauntId(int restarauntId) {
		this.restarauntId = restarauntId;
	}
	public int getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "orderTable [id=" + id + ", userId=" + userId + ", restarauntId=" + restarauntId + ", orderTime="
				+ orderTime + ", totalAmount=" + totalAmount + ", status=" + status + "]";
	}
	public OrderTable(int id, int userId, int restarauntId, int orderTime, float totalAmount, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.restarauntId = restarauntId;
		this.orderTime = orderTime;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public OrderTable(int userId, int restarauntId, int orderTime, float totalAmount, String status) {
		super();
		this.userId = userId;
		this.restarauntId = restarauntId;
		this.orderTime = orderTime;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public OrderTable(int orderTime, float totalAmount, String status) {
		super();
		this.orderTime = orderTime;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public OrderTable() {
		super();
	}


}
