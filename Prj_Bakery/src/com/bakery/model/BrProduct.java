package com.bakery.model;

public class BrProduct {
	private String prodId;
	private String prodName;
	private int prodPrice;
	private int qty;
	private String prodDesc;
	private int catId;
	private BrCategory brCat;
	private BrProductPhoto prodPhoto;
	
	
	public class BrProductPhoto{
		private String photoName;
		private byte[] photoData;
		private long photoSize;
		public String getPhotoName() {
			return photoName;
		}
		public void setPhotoName(String photoName) {
			this.photoName = photoName;
		}
		public byte[] getPhotoData() {
			return photoData;
		}
		public void setPhotoData(byte[] photoData) {
			this.photoData = photoData;
		}
		public long getPhotoSize() {
			return photoSize;
		}
		public void setPhotoSize(long photoSize) {
			this.photoSize = photoSize;
		}
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public BrCategory getBrCat() {
		return brCat;
	}
	public void setBrCat(BrCategory brCat) {
		this.brCat = brCat;
	}
	public BrProductPhoto getProdPhoto() {
		return prodPhoto;
	}
	public void setProdPhoto(BrProductPhoto prodPhoto) {
		this.prodPhoto = prodPhoto;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
