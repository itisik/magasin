package kr.magasin.adminPage.model.vo;

public class Customer {
	private String cusId;
	private String cusName;
	private String cusPrdName;
	private String cusPrdCount;
	private String cusPurDate;
	private String cusOutDate;
	private String cusComDate;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCusComDate() {
		return cusComDate;
	}

	public void setCusComDate(String cusComDate) {
		this.cusComDate = cusComDate;
	}

	public Customer(String cusId, String cusName, String cusPrdName, String cusPrdCount, String cusPurDate,
			String cusOutDate, String cusComDate) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusPrdName = cusPrdName;
		this.cusPrdCount = cusPrdCount;
		this.cusPurDate = cusPurDate;
		this.cusOutDate = cusOutDate;
		this.cusComDate = cusComDate;
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

	public String getCusPrdName() {
		return cusPrdName;
	}

	public void setCusPrdName(String cusPrdName) {
		this.cusPrdName = cusPrdName;
	}

	public String getCusPrdCount() {
		return cusPrdCount;
	}

	public void setCusPrdCount(String cusPrdCount) {
		this.cusPrdCount = cusPrdCount;
	}

	public String getCusPurDate() {
		return cusPurDate;
	}

	public void setCusPurDate(String cusPurDate) {
		this.cusPurDate = cusPurDate;
	}

	public String getCusOutDate() {
		return cusOutDate;
	}

	public void setCusOutDate(String cusOutDate) {
		this.cusOutDate = cusOutDate;
	}

}
