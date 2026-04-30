package com.example.server.model;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int trandId;
	private int tranAmt;
	private Date tranDate;
	private Date tranTime;
	private String tranStatus;
	private int accountId;
	private Account account;
	
	public int getTrandId() {
		return trandId;
	}
	public void setTrandId(int trandId) {
		this.trandId = trandId;
	}
	public int getTranAmt() {
		return tranAmt;
	}
	public void setTranAmt(int tranAmt) {
		this.tranAmt = tranAmt;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Date getTranDate() {
		return tranDate;
	}
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}
	public Date getTranTime() {
		return tranTime;
	}
	public void setTranTime(Date tranTime) {
		this.tranTime = tranTime;
	}
	public String getTranStatus() {
		return tranStatus;
	}
	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}
}