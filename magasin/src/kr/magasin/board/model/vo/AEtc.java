package kr.magasin.board.model.vo;

import java.sql.Date;

public class AEtc {
	private int aNo;
	private int aQEtcNoRef;
	private String aTitle;
	private String aCont;
	private Date aDate;
	public AEtc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AEtc(int aNo, int aQEtcNoRef, String aTitle, String aCont, Date aDate) {
		super();
		this.aNo = aNo;
		this.aQEtcNoRef = aQEtcNoRef;
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
	public int getaQEtcNoRef() {
		return aQEtcNoRef;
	}
	public void setaQEtcNoRef(int aQEtcNoRef) {
		this.aQEtcNoRef = aQEtcNoRef;
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
