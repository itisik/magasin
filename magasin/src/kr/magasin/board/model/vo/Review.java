package kr.magasin.board.model.vo;

import java.sql.Date;

public class Review {

	private int reviewNo;
	private String reviewWriter;
	private String reviewTitle;
	private int reviewPoint;
	private String reviewCont;
	private Date reviewDate;
	private int reviewCount;
	private String reviewFilename;
	private String reviewFilepath;
	private String prdName;
	private String prdSnImg;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int reviewNo, String reviewWriter, String reviewTitle, int reviewPoint, String reviewCont,
			Date reviewDate, int reviewCount, String reviewFilename, String reviewFilepath, String prdName,
			String prdSnImg) {
		super();
		this.reviewNo = reviewNo;
		this.reviewWriter = reviewWriter;
		this.reviewTitle = reviewTitle;
		this.reviewPoint = reviewPoint;
		this.reviewCont = reviewCont;
		this.reviewDate = reviewDate;
		this.reviewCount = reviewCount;
		this.reviewFilename = reviewFilename;
		this.reviewFilepath = reviewFilepath;
		this.prdName = prdName;
		this.prdSnImg = prdSnImg;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public int getReviewPoint() {
		return reviewPoint;
	}
	public void setReviewPoint(int reviewPoint) {
		this.reviewPoint = reviewPoint;
	}
	public String getReviewCont() {
		return reviewCont;
	}
	public void setReviewCont(String reviewCont) {
		this.reviewCont = reviewCont;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	public String getReviewFilename() {
		return reviewFilename;
	}
	public void setReviewFilename(String reviewFilename) {
		this.reviewFilename = reviewFilename;
	}
	public String getReviewFilepath() {
		return reviewFilepath;
	}
	public void setReviewFilepath(String reviewFilepath) {
		this.reviewFilepath = reviewFilepath;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public String getPrdSnImg() {
		return prdSnImg;
	}
	public void setPrdSnImg(String prdSnImg) {
		this.prdSnImg = prdSnImg;
	}
	
	
}
