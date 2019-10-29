package kr.magasin.adminPage.model.vo;

import java.util.ArrayList;

public class Chart2 {
	private ArrayList<Integer> genderNoneCount = new ArrayList<Integer>();
	private ArrayList<Integer> manCount = new ArrayList<Integer>();
	private ArrayList<Integer> womanCount = new ArrayList<Integer>();
	
	public Chart2() {
		super();
	}
	
	public Chart2(ArrayList<Integer> genderNoneCount, ArrayList<Integer> manCount, ArrayList<Integer> womancount) {
		super();
		this.genderNoneCount = genderNoneCount;
		this.manCount = manCount;
		this.womanCount = womancount;
	}
	public ArrayList<Integer> getGenderNoneCount() {
		return genderNoneCount;
	}
	public void setGenderNoneCount(ArrayList<Integer> genderNoneCount) {
		this.genderNoneCount = genderNoneCount;
	}
	public ArrayList<Integer> getManCount() {
		return manCount;
	}
	public void setManCount(ArrayList<Integer> manCount) {
		this.manCount = manCount;
	}
	public ArrayList<Integer> getWomancount() {
		return womanCount;
	}
	public void setWomancount(ArrayList<Integer> womancount) {
		this.womanCount = womancount;
	}
	
	
}
