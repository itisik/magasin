package kr.magasin.product.model.vo;

import java.sql.Date;

public class Product {
	private int prdId;
	private String prdName;
	private String prdGender;
	private String prdCtgr;
	private String prdSubCtrg;
	private int prdPrice;
	private Date prdUpDate;
	private String prdSnImgname;
	private String prdSnImgpath;
	private String prdFilename;
	private String prdFilepath;
	
	public Product(int prdId, String prdName, String prdGender, String prdCtgr, String prdSubCtrg, int prdPrice,
			Date prdUpDate, String prdSnImgname, String prdSnImgpath, String prdFilename, String prdFilepath) {
		super();
		this.prdId = prdId;
		this.prdName = prdName;
		this.prdGender = prdGender;
		this.prdCtgr = prdCtgr;
		this.prdSubCtrg = prdSubCtrg;
		this.prdPrice = prdPrice;
		this.prdUpDate = prdUpDate;
		this.prdSnImgname = prdSnImgname;
		this.prdSnImgpath = prdSnImgpath;
		this.prdFilename = prdFilename;
		this.prdFilepath = prdFilepath;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getPrdGender() {
		return prdGender;
	}
	public void setPrdGender(String prdGender) {
		this.prdGender = prdGender;
	}
	public String getPrdCtgr() {
		return prdCtgr;
	}
	public void setPrdCtgr(String prdCtgr) {
		this.prdCtgr = prdCtgr;
	}
	public String getPrdSubCtrg() {
		return prdSubCtrg;
	}
	public void setPrdSubCtrg(String prdSubCtrg) {
		this.prdSubCtrg = prdSubCtrg;
	}
	public int getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}
	public Date getPrdUpDate() {
		return prdUpDate;
	}
	public void setPrdUpDate(Date prdUpDate) {
		this.prdUpDate = prdUpDate;
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
	public String getPrdFilename() {
		return prdFilename;
	}
	public void setPrdFilename(String prdFilename) {
		this.prdFilename = prdFilename;
	}
	public String getPrdFilepath() {
		return prdFilepath;
	}
	public void setPrdFilepath(String prdFilepath) {
		this.prdFilepath = prdFilepath;
	}
	
	
	
}