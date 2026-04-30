package com.bakery.model;

public class BrCreditCard {
	private int cardId;
	private String cardNo;
	private int cardPaid;
	private String cardStatus;
	private String cardPaidId;
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public int getCardPaid() {
		return cardPaid;
	}
	public void setCardPaid(int cardPaid) {
		this.cardPaid = cardPaid;
	}
	public String getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}
	public String getCardPaidId() {
		return cardPaidId;
	}
	public void setCardPaidId(String cardPaidId) {
		this.cardPaidId = cardPaidId;
	}
}
