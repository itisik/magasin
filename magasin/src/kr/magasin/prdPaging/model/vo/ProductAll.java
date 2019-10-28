package kr.magasin.prdPaging.model.vo;


import java.sql.Date;

public class ProductAll {
	
	private int prdId;
	private String prdName;
	private int prdPrice;
	private String prdSnImgname;
	private  String prdSnImgpath;
	private int prdDtlId;
	private int prdDtlCount; //재고 수량
	private String prdDtlSize;
	private String prdDtlColor;
	private int count; // 구매개수 
	
	public ProductAll() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductAll(int prdId, String prdName, int prdPrice, String prdSnImgname, String prdSnImgpath, int prdDtlId,
			int prdDtlCount, String prdDtlSize, String prdDtlColor, int count) {
		super();
		this.prdId = prdId;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdSnImgname = prdSnImgname;
		this.prdSnImgpath = prdSnImgpath;
		this.prdDtlId = prdDtlId;
		this.prdDtlCount = prdDtlCount;
		this.prdDtlSize = prdDtlSize;
		this.prdDtlColor = prdDtlColor;
		this.count = count;
	}
	public int getPrdId() {
		return prdId;
	}
	public void setPrdId(int prdId) {
		this.prdId = prdId;
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
	public String getPrdSnImgname() {
		return prdSnImgname;
	}
	public void setPrdSnImgname(String prdSnImgname) {
		this.prdSnImgname = prdSnImgname;
	}
	public String getPrdSnImgpath() {
		return prdSnImgpath;
	}
	public void setPrdSnImgpath(String prdSnImgpath) {
		this.prdSnImgpath = prdSnImgpath;
	}
	public int getPrdDtlId() {
		return prdDtlId;
	}
	public void setPrdDtlId(int prdDtlId) {
		this.prdDtlId = prdDtlId;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
