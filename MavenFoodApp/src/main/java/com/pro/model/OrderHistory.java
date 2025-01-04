package com.pro.model;

public class OrderHistory {
	private int id;
	private int orderId;
	private int userId;
	private String orderDate;
	private float totalAmount;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
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
		return "OrderHistory [id=" + id + ", orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate
				+ ", totalAmount=" + totalAmount + ", status=" + status + "]";
	}
	public OrderHistory(int id, int orderId, int userId, String orderDate, float totalAmount, String status) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public OrderHistory(int orderId, int userId, String orderDate, float totalAmount, String status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public OrderHistory() {
		super();
	}
}
