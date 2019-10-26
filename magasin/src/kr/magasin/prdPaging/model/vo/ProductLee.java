package kr.magasin.prdPaging.model.vo;

import java.sql.Date;

public class ProductLee {
	
	private int rnum;
	private int prdId;
	private String prdName;
	private String prdGender;
	private String prdCtgr;
	private String prdSubCtrg;
	private int prdPrice;
	private Date prdUpDate;
	private String prdSnImgname;
	private  String prdSnImgpath;
	private String prdFilename;
	private String prdFilepath;
	private int prdDtlId;
	private int prdDtlCount;
	private String prdDtlSize;
	private String prdDtlColor;
	
	public ProductLee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductLee(int rnum, int prdId, String prdName, String prdGender, String prdCtgr, String prdSubCtrg,
			int prdPrice, Date prdUpDate, String prdSnImgname, String prdSnImgpath, String prdFilename,
			String prdFilepath, int prdDtlId, int prdDtlCount, String prdDtlSize, String prdDtlColor) {
		super();
		this.rnum = rnum;
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
		this.prdDtlId = prdDtlId;
		this.prdDtlCount = prdDtlCount;
		this.prdDtlSize = prdDtlSize;
		this.prdDtlColor = prdDtlColor;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
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

	

	
	
}
