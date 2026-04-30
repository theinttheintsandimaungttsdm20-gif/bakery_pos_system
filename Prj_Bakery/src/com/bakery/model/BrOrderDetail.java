package com.bakery.model;

public class BrOrderDetail {
	private int deteailId;
	private String prodId;
	private BrProduct prod;
	private int qty;
	private int price;
	private String orderId;
	private BrOrder order;
	
	public int getDeteailId() {
		return deteailId;
	}
	public void setDeteailId(int deteailId) {
		this.deteailId = deteailId;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public BrProduct getProd() {
		return prod;
	}
	public void setProd(BrProduct prod) {
		this.prod = prod;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public BrOrder getOrder() {
		return order;
	}
	public void setOrder(BrOrder order) {
		this.order = order;
	}

}	
