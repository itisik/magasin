package kr.magasin.board.model.vo;

import java.util.ArrayList;

public class PageData {

	private String pageNavi;
	private ArrayList<Notice> noticeList;
	private ArrayList<Review> reviewList;
	private ArrayList<QEtc> qEtcList;
	private ArrayList<AEtc> aEtcList;
	private ArrayList<QPrd> qPrdList;
	private ArrayList<APrd> aPrdList;
	public PageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageData(String pageNavi, ArrayList<Notice> noticeList, ArrayList<Review> reviewList,
			ArrayList<QEtc> qEtcList, ArrayList<AEtc> aEtcList, ArrayList<QPrd> qPrdList, ArrayList<APrd> aPrdList) {
		super();
		this.pageNavi = pageNavi;
		this.noticeList = noticeList;
		this.reviewList = reviewList;
		this.qEtcList = qEtcList;
		this.aEtcList = aEtcList;
		this.qPrdList = qPrdList;
		this.aPrdList = aPrdList;
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
	public ArrayList<QEtc> getqEtcList() {
		return qEtcList;
	}
	public void setqEtcList(ArrayList<QEtc> qEtcList) {
		this.qEtcList = qEtcList;
	}
	public ArrayList<AEtc> getaEtcList() {
		return aEtcList;
	}
	public void setaEtcList(ArrayList<AEtc> aEtcList) {
		this.aEtcList = aEtcList;
	}
	public ArrayList<QPrd> getqPrdList() {
		return qPrdList;
	}
	public void setqPrdList(ArrayList<QPrd> qPrdList) {
		this.qPrdList = qPrdList;
	}
	public ArrayList<APrd> getaPrdList() {
		return aPrdList;
	}
	public void setaPrdList(ArrayList<APrd> aPrdList) {
		this.aPrdList = aPrdList;
	}
	
}
