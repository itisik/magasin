package kr.magasin.basket.model.vo;

public class Basket {

	private String basketId;
	private String basketUserId;
	private String basketProDtlId;
	private String basketProCount;
	public Basket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Basket(String basketId, String basketUserId, String basketProDtlId, String basketProCount) {
		super();
		this.basketId = basketId;
		this.basketUserId = basketUserId;
		this.basketProDtlId = basketProDtlId;
		this.basketProCount = basketProCount;
	}
	public String getBasketId() {
		return basketId;
	}
	public void setBasketId(String basketId) {
		this.basketId = basketId;
	}
	public String getBasketUserId() {
		return basketUserId;
	}
	public void setBasketUserId(String basketUserId) {
		this.basketUserId = basketUserId;
	}

	public String getBasketProDtlId() {
		return basketProDtlId;
	}
	public void setBasketProDtlId(String basketProDtlId) {
		this.basketProDtlId = basketProDtlId;
	}
	public String getBasketProCount() {
		return basketProCount;
	}
	public void setBasketProCount(String basketProCount) {
		this.basketProCount = basketProCount;
	}
	


}
