package kr.magasin.adminPage.model.vo;

import java.util.ArrayList;

public class Chart {
	ArrayList<String> date = new ArrayList<String>();
	ArrayList<Integer> countByDate = new ArrayList<Integer>();
	ArrayList<Integer> sumMoney = new ArrayList<Integer>();
	
	public Chart() {
		super();
	}

	public Chart(ArrayList<String> date, ArrayList<Integer> countByDate, ArrayList<Integer> sumMoney) {
		super();
		this.date = date;
		this.countByDate = countByDate;
		this.sumMoney = sumMoney;
	}

	public ArrayList<String> getDate() {
		return date;
	}

	public void setDate(ArrayList<String> date) {
		this.date = date;
	}

	public ArrayList<Integer> getCountByDate() {
		return countByDate;
	}

	public void setCountByDate(ArrayList<Integer> countByDate) {
		this.countByDate = countByDate;
	}

	public ArrayList<Integer> getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(ArrayList<Integer> sumMoney) {
		this.sumMoney = sumMoney;
	}
	
	
}