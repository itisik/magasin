package kr.magasin.product.model.vo;

import java.sql.Date;

public class Product {
	private String prdId;
	private String prdName;
	private String prdGender;
	private String prdCtgr;
	private String prdSubCtrg;
	private int prdPrice;
	// 실수형으로 받지 못하게 유효성 검사?
	private Date prdUpDate;

}
