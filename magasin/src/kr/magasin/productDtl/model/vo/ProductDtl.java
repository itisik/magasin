package kr.magasin.productDtl.model.vo;

public class ProductDtl {
	private int prdDtlId;
	private int prdId;
	private int prdDtlCount;
	private String prdDtlSize;
	private String prdDtlColor;
	public int getPrdDtlId() {
		return prdDtlId;
	}
	public void setPrdDtlId(int prdDtlId) {
		this.prdDtlId = prdDtlId;
	}
	public int getPrdId() {
		return prdId;
	}
	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}
	public int getPrdDtlCount() {
		return prdDtlCount;
	}
	public void setPrdDtlCount(int prdDtlCount) {
		this.prdDtlCount = prdDtlCount;
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
	public ProductDtl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDtl(int prdDtlId, int prdId, int prdDtlCount, String prdDtlSize, String prdDtlColor) {
		super();
		this.prdDtlId = prdDtlId;
		this.prdId = prdId;
		this.prdDtlCount = prdDtlCount;
		this.prdDtlSize = prdDtlSize;
		this.prdDtlColor = prdDtlColor;
	}
	
}