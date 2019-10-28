package kr.magasin.adminPage.model.vo;

import java.sql.Date;

public class Chart {
	private Date date;
	private String countByDate;
	private String sumMoney;

	private String time;
	private String countByTime;

	private String age10;
	private String age20;
	private String age30;
	private String age40;
	private String ageNone;

	private String male;
	private String female;
	private String noneGender;

	public Chart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chart(Date date, String countByDate, String sumMoney, String time, String countByTime, String age10,
			String age20, String age30, String age40, String ageNone, String male, String female, String noneGender) {
		super();
		this.date = date;
		this.countByDate = countByDate;
		this.sumMoney = sumMoney;
		this.time = time;
		this.countByTime = countByTime;
		this.age10 = age10;
		this.age20 = age20;
		this.age30 = age30;
		this.age40 = age40;
		this.ageNone = ageNone;
		this.male = male;
		this.female = female;
		this.noneGender = noneGender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCountByDate() {
		return countByDate;
	}

	public void setCountByDate(String countByDate) {
		this.countByDate = countByDate;
	}

	public String getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(String sumMoney) {
		this.sumMoney = sumMoney;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCountByTime() {
		return countByTime;
	}

	public void setCountByTime(String countByTime) {
		this.countByTime = countByTime;
	}

	public String getAge10() {
		return age10;
	}

	public void setAge10(String age10) {
		this.age10 = age10;
	}

	public String getAge20() {
		return age20;
	}

	public void setAge20(String age20) {
		this.age20 = age20;
	}

	public String getAge30() {
		return age30;
	}

	public void setAge30(String age30) {
		this.age30 = age30;
	}

	public String getAge40() {
		return age40;
	}

	public void setAge40(String age40) {
		this.age40 = age40;
	}

	public String getAgeNone() {
		return ageNone;
	}

	public void setAgeNone(String ageNone) {
		this.ageNone = ageNone;
	}

	public String getMale() {
		return male;
	}

	public void setMale(String male) {
		this.male = male;
	}

	public String getFemale() {
		return female;
	}

	public void setFemale(String female) {
		this.female = female;
	}

	public String getNoneGender() {
		return noneGender;
	}

	public void setNoneGender(String noneGender) {
		this.noneGender = noneGender;
	}

}
