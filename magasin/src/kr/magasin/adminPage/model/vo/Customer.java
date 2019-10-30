package kr.magasin.adminPage.model.vo;

public class Customer {
	private String cusId;
	private String cusName;
	private String cusGender;
	private String cusAddr;
	private String cusPhone;
	private String cusBirthdate;
	private String cusEmail;

	public Customer() {
		super();
	}

	public Customer(String cusId, String cusName, String cusGender, String cusAddr, String cusPhone,
			String cusBirthdate, String cusEmail) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusGender = cusGender;
		this.cusAddr = cusAddr;
		this.cusPhone = cusPhone;
		this.cusBirthdate = cusBirthdate;
		this.cusEmail = cusEmail;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusGender() {
		return cusGender;
	}

	public void setCusGender(String cusGender) {
		this.cusGender = cusGender;
	}

	public String getCusAddr() {
		return cusAddr;
	}

	public void setCusAddr(String cusAddr) {
		this.cusAddr = cusAddr;
	}

	public String getCusPhone() {
		return cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public String getCusBirthdate() {
		return cusBirthdate;
	}

	public void setCusBirthdate(String cusBirthdate) {
		this.cusBirthdate = cusBirthdate;
	}

	public String getCusEmail() {
		return cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}
	
	
}