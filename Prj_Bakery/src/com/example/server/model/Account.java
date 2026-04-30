package com.example.server.model;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int accountId;
	private String holderName;
	private String cardNo;
	private int accountBalance;
	private List<Transaction> transcation;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public List<Transaction> getTranscation() {
		return transcation;
	}
	public void setTranscation(List<Transaction> transcation) {
		this.transcation = transcation;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	
}
