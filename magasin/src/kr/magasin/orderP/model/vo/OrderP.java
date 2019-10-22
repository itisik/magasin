package kr.magasin.orderP.model.vo;

import java.sql.Date;

public class OrderP {
    private int orderNum;
    private String orderUserId;
    private int orderPrdDtlId;
    private int orderPrdCount;
    private int orderMoney;
    private String orderAddr;
    private String orderStatus;
    private String orderPay;
    private Date orderDate;
    private Date orderOutDate;
    
	public OrderP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderP(int orderNum, String orderUserId, int orderPrdDtlId, int orderPrdCount, int orderMoney,
			String orderAddr, String orderStatus, String orderPay, Date orderDate, Date orderOutDate) {
		super();
		this.orderNum = orderNum;
		this.orderUserId = orderUserId;
		this.orderPrdDtlId = orderPrdDtlId;
		this.orderPrdCount = orderPrdCount;
		this.orderMoney = orderMoney;
		this.orderAddr = orderAddr;
		this.orderStatus = orderStatus;
		this.orderPay = orderPay;
		this.orderDate = orderDate;
		this.orderOutDate = orderOutDate;
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

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
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
	
	
}
