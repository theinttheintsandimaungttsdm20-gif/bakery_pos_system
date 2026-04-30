package com.bakery.model;

import java.util.Date;
import java.util.List;

public class BrSales {
	private String salesId;
	private Date salesDate;
	private String paidStatus;
	private String empId;
	private List<BrSalesDetail> salesDetails;
	private BrCreditCard creditCard;
	
	public String getSalesId() {
		return salesId;
	}
	public void setSalesId(String strSalesId) {
		this.salesId = strSalesId;
	}
	public Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	public String getPaidStatus() {
		return paidStatus;
	}
	public void setPaidStatus(String paidStatus) {
		this.paidStatus = paidStatus;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public List<BrSalesDetail> getSalesDetails() {
		return salesDetails;
	}
	public void setSalesDetails(List<BrSalesDetail> salesDetails) {
		this.salesDetails = salesDetails;
	}
	public BrCreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(BrCreditCard creditCard) {
		this.creditCard = creditCard;
	}
	

}
