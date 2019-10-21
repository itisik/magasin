package kr.magasin.board.model.vo;

import java.util.ArrayList;

public class PageData {

	private String pageNavi;
	private ArrayList<Notice> noticeList;
	private ArrayList<Review> reviewList;
	private ArrayList<Question> qList;
	private ArrayList<Answer> aList;
	public PageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageData(String pageNavi, ArrayList<Notice> noticeList, ArrayList<Review> reviewList,
			ArrayList<Question> qList, ArrayList<Answer> aList) {
		super();
		this.pageNavi = pageNavi;
		this.noticeList = noticeList;
		this.reviewList = reviewList;
		this.qList = qList;
		this.aList = aList;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	public ArrayList<Notice> getNoticeList() {
		return noticeList;
	}
	public void setNoticeList(ArrayList<Notice> noticeList) {
		this.noticeList = noticeList;
	}
	public ArrayList<Review> getReviewList() {
		return reviewList;
	}
	public void setReviewList(ArrayList<Review> reviewList) {
		this.reviewList = reviewList;
	}
	public ArrayList<Question> getqList() {
		return qList;
	}
	public void setqList(ArrayList<Question> qList) {
		this.qList = qList;
	}
	public ArrayList<Answer> getaList() {
		return aList;
	}
	public void setaList(ArrayList<Answer> aList) {
		this.aList = aList;
	}
	
	
}
