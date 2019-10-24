package kr.magasin.product.model.vo;

import java.util.ArrayList;

public class PageData {
	private ArrayList<Product> lists;
	private String pageNavi;
	public PageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageData(ArrayList<Product> lists, String pageNavi) {
		super();
		this.lists = lists;
		this.pageNavi = pageNavi;
	}
	public ArrayList<Product> getLists() {
		return lists;
	}
	public void setList(ArrayList<Product> lists) {
		this.lists = lists;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	
}
