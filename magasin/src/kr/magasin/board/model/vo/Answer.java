package kr.magasin.board.model.vo;

import java.sql.Date;

public class Answer {

	private int aNo;
	private int aQNoRef;
	private String aTitle;
	private String aCont;
	private Date aDate;
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(int aNo, int aQNoRef, String aTitle, String aCont, Date aDate) {
		super();
		this.aNo = aNo;
		this.aQNoRef = aQNoRef;
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
	public int getaQNoRef() {
		return aQNoRef;
	}
	public void setaQNoRef(int aQNoRef) {
		this.aQNoRef = aQNoRef;
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
