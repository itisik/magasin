package kr.magasin.adminPage.model.vo;

import java.util.ArrayList;

public class Chart3 {
	private ArrayList<Integer> age10 = new ArrayList<Integer>();
	private ArrayList<Integer> age20 = new ArrayList<Integer>();
	private ArrayList<Integer> age30 = new ArrayList<Integer>();
	private ArrayList<Integer> ageOver40 = new ArrayList<Integer>();
	private ArrayList<Integer> ageNone = new ArrayList<Integer>();

	public Chart3() {
		super();
	}

	public Chart3(ArrayList<Integer> age10, ArrayList<Integer> age20, ArrayList<Integer> age30,
			ArrayList<Integer> ageOver40, ArrayList<Integer> ageNone) {
		super();
		this.age10 = age10;
		this.age20 = age20;
		this.age30 = age30;
		this.ageOver40 = ageOver40;
		this.ageNone = ageNone;
	}

	public ArrayList<Integer> getAge10() {
		return age10;
	}

	public void setAge10(ArrayList<Integer> age10) {
		this.age10 = age10;
	}

	public ArrayList<Integer> getAge20() {
		return age20;
	}

	public void setAge20(ArrayList<Integer> age20) {
		this.age20 = age20;
	}

	public ArrayList<Integer> getAge30() {
		return age30;
	}

	public void setAge30(ArrayList<Integer> age30) {
		this.age30 = age30;
	}

	public ArrayList<Integer> getAgeOver40() {
		return ageOver40;
	}

	public void setAgeOver40(ArrayList<Integer> ageOver40) {
		this.ageOver40 = ageOver40;
	}

	public ArrayList<Integer> getAgeNone() {
		return ageNone;
	}

	public void setAgeNone(ArrayList<Integer> ageNone) {
		this.ageNone = ageNone;
	}

}
