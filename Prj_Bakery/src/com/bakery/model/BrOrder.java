package com.bakery.model;

import java.util.Date;
import java.util.List;

public class BrOrder {
	private String orderId;
	private Date orderDate,receiveDate;
	private String paidStatus;
	private Boolean orderStatus;
	private String empId;
	private List<BrOrderDetail> orderDetails;
	private List<BrIngredient> orderIngs;
	private BrCreditCard creditCard;
	private int custId;
	private BrCustomer customer;
	private BrEmployee emp;
	
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getPaidStatus() {
		return paidStatus;
	}
	public void setPaidStatus(String paidStatus) {
		this.paidStatus = paidStatus;
	}
	public Boolean getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Boolean orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public List<BrOrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<BrOrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public BrCreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(BrCreditCard creditCard) {
		this.creditCard = creditCard;
	}
	public List<BrIngredient> getOrderIngs() {
		return orderIngs;
	}
	public void setOrderIngs(List<BrIngredient> orderIngs) {
		this.orderIngs = orderIngs;
	}
	public BrCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(BrCustomer customer) {
		this.customer = customer;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public BrEmployee getEmp() {
		return emp;
	}
	public void setEmp(BrEmployee emp) {
		this.emp = emp;
	}
	

}
