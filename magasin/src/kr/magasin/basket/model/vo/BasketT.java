package kr.magasin.basket.model.vo;

public class BasketT {
	private String prdDtlId;
	private String prdDtlSize;
	private String prdDtlColor;
	private int prdCount;
	private int prdPrice;
	public BasketT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BasketT(String prdDtlId, String prdDtlSize, String prdDtlColor, int prdCount, int prdPrice) {
		super();
		this.prdDtlId = prdDtlId;
		this.prdDtlSize = prdDtlSize;
		this.prdDtlColor = prdDtlColor;
		this.prdCount = prdCount;
		this.prdPrice = prdPrice;
	}
	public String getPrdDtlId() {
		return prdDtlId;
	}
	public void setPrdDtlId(String prdDtlId) {
		this.prdDtlId = prdDtlId;
	}
	public String getPrdDtlSize() {
		return prdDtlSize;
	}
	public void setPrdDtlSize(String prdDtlSize) {
		this.prdDtlSize = prdDtlSize;
	}
	public String getPrdDtlColor() {
		return prdDtlColor;
	}
	public void setPrdDtlColor(String prdDtlColor) {
		this.prdDtlColor = prdDtlColor;
	}
	public int getPrdCount() {
		return prdCount;
	}
	public void setPrdCount(int prdCount) {
		this.prdCount = prdCount;
	}
	public int getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}
	
}
