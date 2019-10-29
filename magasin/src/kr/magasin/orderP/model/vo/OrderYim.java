package kr.magasin.orderP.model.vo;

import java.sql.Date;

public class OrderYim {
	private int orderNum;
	private String orderUserId;
	private String orderBuyerName;
	private String orderBuyerPhone;
	private int orderPrdDtlId;
	private int orderPrdCount;
	private int orderMoney;
	private String orderAddr;
	private int orderStatus;
	private String orderPay;
	private Date orderDate;
	private Date orderOutDate;
	private Date orderComDate;
	public OrderYim() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderYim(int orderNum, String orderUserId, String orderBuyerName, String orderBuyerPhone, int orderPrdDtlId,
			int orderPrdCount, int orderMoney, String orderAddr, int orderStatus, String orderPay, Date orderDate,
			Date orderOutDate, Date orderComDate) {
		super();
		this.orderNum = orderNum;
		this.orderUserId = orderUserId;
		this.orderBuyerName = orderBuyerName;
		this.orderBuyerPhone = orderBuyerPhone;
		this.orderPrdDtlId = orderPrdDtlId;
		this.orderPrdCount = orderPrdCount;
		this.orderMoney = orderMoney;
		this.orderAddr = orderAddr;
		this.orderStatus = orderStatus;
		this.orderPay = orderPay;
		this.orderDate = orderDate;
		this.orderOutDate = orderOutDate;
		this.orderComDate = orderComDate;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getOrderUserId() {
		return orderUserId;
	}
	public void setOrderUserId(String orderUserId) {
		this.orderUserId = orderUserId;
	}
	public String getOrderBuyerName() {
		return orderBuyerName;
	}
	public void setOrderBuyerName(String orderBuyerName) {
		this.orderBuyerName = orderBuyerName;
	}
	public String getOrderBuyerPhone() {
		return orderBuyerPhone;
	}
	public void setOrderBuyerPhone(String orderBuyerPhone) {
		this.orderBuyerPhone = orderBuyerPhone;
	}
	public int getOrderPrdDtlId() {
		return orderPrdDtlId;
	}
	public void setOrderPrdDtlId(int orderPrdDtlId) {
		this.orderPrdDtlId = orderPrdDtlId;
	}
	public int getOrderPrdCount() {
		return orderPrdCount;
	}
	public void setOrderPrdCount(int orderPrdCount) {
		this.orderPrdCount = orderPrdCount;
	}
	public int getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(int orderMoney) {
		this.orderMoney = orderMoney;
	}
	public String getOrderAddr() {
		return orderAddr;
	}
	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderPay() {
		return orderPay;
	}
	public void setOrderPay(String orderPay) {
		this.orderPay = orderPay;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getOrderOutDate() {
		return orderOutDate;
	}
	public void setOrderOutDate(Date orderOutDate) {
		this.orderOutDate = orderOutDate;
	}
	public Date getOrderComDate() {
		return orderComDate;
	}
	public void setOrderComDate(Date orderComDate) {
		this.orderComDate = orderComDate;
	}
	
}
