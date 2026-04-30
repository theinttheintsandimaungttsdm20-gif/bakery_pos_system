package com.bakery.model;

public class BrOrdersView {
	private String orderNo,orderDate,receiveDate,
	orderStatus,paidStatus,custName,detailTotal,ingTotal;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(String paidStatus) {
		this.paidStatus = paidStatus;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getDetailTotal() {
		return detailTotal;
	}

	public void setDetailTotal(String detailTotal) {
		this.detailTotal = detailTotal;
	}

	public String getIngTotal() {
		return ingTotal;
	}

	public void setIngTotal(String ingTotal) {
		this.ingTotal = ingTotal;
	}
}
