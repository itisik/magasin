package kr.magasin.adminPage.model.vo;

public class Order {
	private int orderNum;
	private String orderCusId;
	private String orderCusName;
	private String orderCusAddr;
	private String orderCusPrdName;
	private String orderCusPrdCount;
	private String orderCusPurDate;
	private String orderCusOutDate;
	private String orderCusComDate;
	private int orderStatus;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderNum, String orderCusId, String orderCusName, String orderCusAddr, String orderCusPrdName,
			String orderCusPrdCount, String orderCusPurDate, String orderCusOutDate, String orderCusComDate,
			int orderStatus) {
		super();
		this.orderNum = orderNum;
		this.orderCusId = orderCusId;
		this.orderCusName = orderCusName;
		this.orderCusAddr = orderCusAddr;
		this.orderCusPrdName = orderCusPrdName;
		this.orderCusPrdCount = orderCusPrdCount;
		this.orderCusPurDate = orderCusPurDate;
		this.orderCusOutDate = orderCusOutDate;
		this.orderCusComDate = orderCusComDate;
		this.orderStatus = orderStatus;
	}

	public String getOrderCusAddr() {
		return orderCusAddr;
	}

	public void setOrderCusAddr(String orderCusAddr) {
		this.orderCusAddr = orderCusAddr;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderCusId() {
		return orderCusId;
	}
	public void setOrderCusId(String orderCusId) {
		this.orderCusId = orderCusId;
	}
	public String getOrderCusName() {
		return orderCusName;
	}
	public void setOrderCusName(String orderCusName) {
		this.orderCusName = orderCusName;
	}
	public String getOrderCusPrdName() {
		return orderCusPrdName;
	}
	public void setOrderCusPrdName(String orderCusPrdName) {
		this.orderCusPrdName = orderCusPrdName;
	}
	public String getOrderCusPrdCount() {
		return orderCusPrdCount;
	}
	public void setOrderCusPrdCount(String orderCusPrdCount) {
		this.orderCusPrdCount = orderCusPrdCount;
	}
	public String getOrderCusPurDate() {
		return orderCusPurDate;
	}
	public void setOrderCusPurDate(String orderCusPurDate) {
		this.orderCusPurDate = orderCusPurDate;
	}
	public String getOrderCusOutDate() {
		return orderCusOutDate;
	}
	public void setOrderCusOutDate(String orderCusOutDate) {
		this.orderCusOutDate = orderCusOutDate;
	}
	public String getOrderCusComDate() {
		return orderCusComDate;
	}
	public void setOrderCusComDate(String orderCusComDate) {
		this.orderCusComDate = orderCusComDate;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}