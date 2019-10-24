package kr.magasin.board.model.vo;

import java.sql.Date;

public class APrd {
	private int aNo;
	private int aQPrdNoRef;
	private String aTitle;
	private String aCont;
	private Date aDate;
	public APrd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public APrd(int aNo, int aQPrdNoRef, String aTitle, String aCont, Date aDate) {
		super();
		this.aNo = aNo;
		this.aQPrdNoRef = aQPrdNoRef;
		this.aTitle = aTitle;
		this.aCont = aCont;
		this.aDate = aDate;
	}
	public int getaNo() {
		return aNo;
	}
	public void setaNo(int aNo) {
		this.aNo = aNo;
	}
	public int getaQPrdNoRef() {
		return aQPrdNoRef;
	}
	public void setaQPrdNoRef(int aQPrdNoRef) {
		this.aQPrdNoRef = aQPrdNoRef;
	}
	public String getaTitle() {
		return aTitle;
	}
	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}
	public String getaCont() {
		return aCont;
	}
	public void setaCont(String aCont) {
		this.aCont = aCont;
	}
	public Date getaDate() {
		return aDate;
	}
	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}
	
}
