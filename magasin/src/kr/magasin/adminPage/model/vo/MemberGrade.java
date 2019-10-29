package kr.magasin.adminPage.model.vo;


public class MemberGrade {
	private String memId;
	private String memName;
	private String enrollDate;
	private String recentOrderDate;
	private String tCount;
	private String tMoney;
	private String grade;

	public MemberGrade() {
		super();
	}
	
	public MemberGrade(String memId, String memName, String enrollDate, String recentOrderDate, String tCount, String tMoney,
			String grade) {
		super();
		this.memId = memId;
		this.memName = memName;
		this.enrollDate = enrollDate;
		this.recentOrderDate = recentOrderDate;
		this.tCount = tCount;
		this.tMoney = tMoney;
		this.grade = grade;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getRecentOrderDate() {
		return recentOrderDate;
	}

	public void setRecentOrderDate(String recentOrderDate) {
		this.recentOrderDate = recentOrderDate;
	}

	public String gettCount() {
		return tCount;
	}

	public void settCount(String tCount) {
		this.tCount = tCount;
	}

	public String gettMoney() {
		return tMoney;
	}

	public void settMoney(String tMoney) {
		this.tMoney = tMoney;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
