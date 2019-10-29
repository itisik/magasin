package kr.magasin.prdPaging.model.vo;

import java.util.ArrayList;


public class PageDataLee {
	private ArrayList<ProductLee> lists;
	private String pageNavi;
	public PageDataLee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageDataLee(ArrayList<ProductLee> lists, String pageNavi) {
		super();
		this.lists = lists;
		this.pageNavi = pageNavi;
	}
	public ArrayList<ProductLee> getLists() {
		return lists;
	}
	public void setLists(ArrayList<ProductLee> lists) {
		this.lists = lists;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
