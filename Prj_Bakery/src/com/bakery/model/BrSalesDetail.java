package com.bakery.model;

public class BrSalesDetail {
	private int deteailId;
	private String prodId;
	private BrProduct prod;
	private int qty;
	private int price;
	private String salesId;
	private BrSales sales;
	
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
	public String getSalesId() {
		return salesId;
	}
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
	public BrSales getSales() {
		return sales;
	}
	public void setSales(BrSales sales) {
		this.sales = sales;
	}
	
}	
