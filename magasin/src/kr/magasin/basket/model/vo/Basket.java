package kr.magasin.basket.model.vo;

public class Basket {
	private int basketId;
	private String basketUserId;
	private int basketPrdDtlId;
	private int basketPrdCount;
	
	public int getBasketId() {
		return basketId;
	}
	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}
	public String getBasketUserId() {
		return basketUserId;
	}
	public void setBasketUserId(String basketUserId) {
		this.basketUserId = basketUserId;
	}
	public int getBasketPrdDtlId() {
		return basketPrdDtlId;
	}
	public void setBasketPrdDtlId(int basketPrdDtlId) {
		this.basketPrdDtlId = basketPrdDtlId;
	}
	public int getBasketPrdCount() {
		return basketPrdCount;
	}
	public void setBasketPrdCount(int basketPrdCount) {
		this.basketPrdCount = basketPrdCount;
	}
	public Basket(int basketId, String basketUserId, int basketPrdDtlId, int basketPrdCount) {
		super();
		this.basketId = basketId;
		this.basketUserId = basketUserId;
		this.basketPrdDtlId = basketPrdDtlId;
		this.basketPrdCount = basketPrdCount;
	}
	public Basket() {
		super();
		// TODO Auto-generated constructor stub
	}
}
