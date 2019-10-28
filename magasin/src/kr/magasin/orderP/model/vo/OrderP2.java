package kr.magasin.orderP.model.vo;

import java.sql.Date;
//은지 기존의 OrderP로 처리할 변수가 충족되지 않아 추가로 만듬 
public class OrderP2 {
	private int prdId;
	private int prdDtlId;
	private String orderBuyerName;
	private String orderBuyerphone;
	private String prdName;
	private String prdDtlSize;
	private String prdDtlColor;
	private int prdPrice;
	private String prdSnImgname;
	private String prdSnImgpath;
	private String prdFilename;
	private String prdFilepath;
	private int orderPrdCount;
	private int orderMoney;
	private String orderAddr;
	private String orderStatus;
	private String orderPay;
	private Date orderDate;
	private Date orderOutDate;
    private int orderNum;
    private String orderUserId;
    private int orderPrdDtlId;
	public OrderP2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderP2(int prdId, int prdDtlId, String orderBuyerName, String orderBuyerphone, String prdName,
			String prdDtlSize, String prdDtlColor, int prdPrice, String prdSnImgname, String prdSnImgpath,
			String prdFilename, String prdFilepath, int orderPrdCount, int orderMoney, String orderAddr,
			String orderStatus, String orderPay, Date orderDate, Date orderOutDate, int orderNum, String orderUserId,
			int orderPrdDtlId) {
		super();
		this.prdId = prdId;
		this.prdDtlId = prdDtlId;
		this.orderBuyerName = orderBuyerName;
		this.orderBuyerphone = orderBuyerphone;
		this.prdName = prdName;
		this.prdDtlSize = prdDtlSize;
		this.prdDtlColor = prdDtlColor;
		this.prdPrice = prdPrice;
		this.prdSnImgname = prdSnImgname;
		this.prdSnImgpath = prdSnImgpath;
		this.prdFilename = prdFilename;
		this.prdFilepath = prdFilepath;
		this.orderPrdCount = orderPrdCount;
		this.orderMoney = orderMoney;
		this.orderAddr = orderAddr;
		this.orderStatus = orderStatus;
		this.orderPay = orderPay;
		this.orderDate = orderDate;
		this.orderOutDate = orderOutDate;
		this.orderNum = orderNum;
		this.orderUserId = orderUserId;
		this.orderPrdDtlId = orderPrdDtlId;
	}
	public int getPrdId() {
		return prdId;
	}
	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}
	public int getPrdDtlId() {
		return prdDtlId;
	}
	public void setPrdDtlId(int prdDtlId) {
		this.prdDtlId = prdDtlId;
	}
	public String getOrderBuyerName() {
		return orderBuyerName;
	}
	public void setOrderBuyerName(String orderBuyerName) {
		this.orderBuyerName = orderBuyerName;
	}
	public String getOrderBuyerphone() {
		return orderBuyerphone;
	}
	public void setOrderBuyerphone(String orderBuyerphone) {
		this.orderBuyerphone = orderBuyerphone;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
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
	public int getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
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
	
	
}
