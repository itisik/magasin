package kr.magasin.adminPage.model.vo;

public class Count {
	private int newOrder;
	private int shippingOrder;
	private int comOrder;
	private int todayMoney;
	private int weekMoney;
	private int qCount;
	private int cancleOrder;

	public Count() {
		super();
	}

	public Count(int newOrder, int shippingOrder, int comOrder, int todayMoney, int weekMoney, int qCount,
			int cancleOrder) {
		super();
		this.newOrder = newOrder;
		this.shippingOrder = shippingOrder;
		this.comOrder = comOrder;
		this.todayMoney = todayMoney;
		this.weekMoney = weekMoney;
		this.qCount = qCount;
		this.cancleOrder = cancleOrder;
	}

	public int getNewOrder() {
		return newOrder;
	}

	public void setNewOrder(int newOrder) {
		this.newOrder = newOrder;
	}

	public int getShippingOrder() {
		return shippingOrder;
	}

	public void setShippingOrder(int shippingOrder) {
		this.shippingOrder = shippingOrder;
	}

	public int getComOrder() {
		return comOrder;
	}

	public void setComOrder(int comOrder) {
		this.comOrder = comOrder;
	}

	public int getTodayMoney() {
		return todayMoney;
	}

	public void setTodayMoney(int todayMoney) {
		this.todayMoney = todayMoney;
	}

	public int getWeekMoney() {
		return weekMoney;
	}

	public void setWeekMoney(int weekMoney) {
		this.weekMoney = weekMoney;
	}

	public int getqCount() {
		return qCount;
	}

	public void setqCount(int qCount) {
		this.qCount = qCount;
	}

	public int getCancleOrder() {
		return cancleOrder;
	}

	public void setCancleOrder(int cancleOrder) {
		this.cancleOrder = cancleOrder;
	}

}
