package kr.magasin.orderP.model.vo;

public class Order {
	
	private String orderUserId;
	private int orderStatus;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderUserId, int orderStatus) {
		super();
		this.orderUserId = orderUserId;
		this.orderStatus = orderStatus;
	}
	public String getOrderUserId() {
		return orderUserId;
	}
	public void setOrderUserId(String orderUserId) {
		this.orderUserId = orderUserId;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
