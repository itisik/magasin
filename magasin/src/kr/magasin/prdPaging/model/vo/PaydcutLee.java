package kr.magasin.prdPaging.model.vo;

public class PaydcutLee {
	   private int prdId;
	   private int amount;
	   private String prdName ;
	   private int prdPrice;
	   private String prdDtlColor ;
	   private String prdDtlSize;
	   private String PrdSnImgpath;
	public PaydcutLee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaydcutLee(int prdId, int amount, String prdName, int prdPrice, String prdDtlColor, String prdDtlSize,
			String prdSnImgpath) {
		super();
		this.prdId = prdId;
		this.amount = amount;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdDtlColor = prdDtlColor;
		this.prdDtlSize = prdDtlSize;
		PrdSnImgpath = prdSnImgpath;
	}
	public int getPrdId() {
		return prdId;
	}
	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public int getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}
	public String getPrdDtlColor() {
		return prdDtlColor;
	}
	public void setPrdDtlColor(String prdDtlColor) {
		this.prdDtlColor = prdDtlColor;
	}
	public String getPrdDtlSize() {
		return prdDtlSize;
	}
	public void setPrdDtlSize(String prdDtlSize) {
		this.prdDtlSize = prdDtlSize;
	}
	public String getPrdSnImgpath() {
		return PrdSnImgpath;
	}
	public void setPrdSnImgpath(String prdSnImgpath) {
		PrdSnImgpath = prdSnImgpath;
	}

}
