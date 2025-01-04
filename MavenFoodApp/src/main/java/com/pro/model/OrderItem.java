package com.pro.model;

public class OrderItem {
	private int orderItemId;
	private int orderId;
	private int menuId;
	private int quantity;
	private float subtotal;
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public String toString() {
		return "orderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", menuId=" + menuId + ", quantity="
				+ quantity + ", subtotal=" + subtotal + "]";
	}
	public OrderItem(int orderItemId, int orderId, int menuId, int quantity, float subtotal) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public OrderItem(int orderId, int menuId, int quantity, float subtotal) {
		super();
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public OrderItem() {
		super();
	}


}
