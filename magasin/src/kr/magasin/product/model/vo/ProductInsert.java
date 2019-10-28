package kr.magasin.product.model.vo;

public class ProductInsert {
	private int result1;
	private int prdId;
	
	public int getResult1() {
		return result1;
	}
	public void setResult1(int result1) {
		this.result1 = result1;
	}
	public int getPrdId() {
		return prdId;
	}
	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}
	public ProductInsert(int result1, int prdId) {
		super();
		this.result1 = result1;
		this.prdId = prdId;
	}
	public ProductInsert() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
