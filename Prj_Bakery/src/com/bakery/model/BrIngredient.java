package com.bakery.model;

public class BrIngredient {
	private int ingId;
	private String ingName;
	private int ingPrice;
	private int ingQty;
	private String ingDesc;
	private String orderNo;
	
	public int getIngId() {
		return ingId;
	}
	public void setIngId(int ingId) {
		this.ingId = ingId;
	}
	public String getIngName() {
		return ingName;
	}
	public void setIngName(String ingName) {
		this.ingName = ingName;
	}
	public int getIngPrice() {
		return ingPrice;
	}
	public void setIngPrice(int ingPrice) {
		this.ingPrice = ingPrice;
	}
	public int getIngQty() {
		return ingQty;
	}
	public void setIngQty(int ingQty) {
		this.ingQty = ingQty;
	}
	public String getIngDesc() {
		return ingDesc;
	}
	public void setIngDesc(String ingDesc) {
		this.ingDesc = ingDesc;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
}
