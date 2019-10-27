package kr.magasin.basket.model.vo;

public class Basket {

	private String basketId;
	private String prdName; 
	private String prdPrice;
	private String basketUserId;
	private String basketPrdDtlId;
	private String basketPrdCount;
	private String prdDtlSize;
	private String prdDtlColor;
	//사이즈 ,컬러, 

	public Basket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Basket(String basketId, String prdName, String prdPrice, String basketUserId, String basketPrdDtlId,
			String basketPrdCount, String prdDtlSize, String prdDtlColor) {
		super();
		this.basketId = basketId;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.basketUserId = basketUserId;
		this.basketPrdDtlId = basketPrdDtlId;
		this.basketPrdCount = basketPrdCount;
		this.prdDtlSize = prdDtlSize;
		this.prdDtlColor = prdDtlColor;
	}
	public String getBasketId() {
		return basketId;
	}
	public void setBasketId(String basketId) {
		this.basketId = basketId;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public String getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(String prdPrice) {
		this.prdPrice = prdPrice;
	}
	public String getBasketUserId() {
		return basketUserId;
	}
	public void setBasketUserId(String basketUserId) {
		this.basketUserId = basketUserId;
	}
	public String getBasketPrdDtlId() {
		return basketPrdDtlId;
	}
	public void setBasketPrdDtlId(String basketPrdDtlId) {
		this.basketPrdDtlId = basketPrdDtlId;
	}
	public String getBasketPrdCount() {
		return basketPrdCount;
	}
	public void setBasketPrdCount(String basketPrdCount) {
		this.basketPrdCount = basketPrdCount;
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
	
	

}
