package kr.magasin.prdPaging.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.magasin.basket.model.vo.BasketT;
import kr.magasin.common.JDBCTemplate;
import kr.magasin.prdPaging.model.dao.ProductLeeDao;
import kr.magasin.prdPaging.model.vo.PageDataLee;
import kr.magasin.prdPaging.model.vo.ProductAll;
import kr.magasin.prdPaging.model.vo.ProductLee;
import kr.magasin.product.model.vo.Product;
import kr.magasin.productDtl.model.vo.ProductDtl;

public class ProductLeeService {

	ProductLeeDao dao = new ProductLeeDao();

	public ArrayList<Product> productList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Product> list = dao.productList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	  public ArrayList<ProductAll> ProductdetailId(ArrayList<BasketT> list,int count) {
		   System.out.println("productLEE 서비스페이지 도착 !");
		  ArrayList<ProductAll> pay = new ArrayList<ProductAll>();
		  Connection conn =	  JDBCTemplate.getConnection(); 
		  pay = dao.ProductdetailId(conn, list, count);
		  JDBCTemplate.close(conn); 
		  return pay; 
		  }
	

/*
  가격과 신상으로 정렬
	public ArrayList<Product> productLowPrice() {
		Connection conn = JDBCTemplate.getConnection();
		ProductDao dao = new ProductDao();
		ArrayList<Product> lop = dao.productLowPrice(conn);
		JDBCTemplate.close(conn);
		return lop;
	}

	public ArrayList<Product> productHighprice() {
		Connection conn = JDBCTemplate.getConnection();
		ProductDao dao = new ProductDao();
		ArrayList<Product> hop = dao.productHighprice(conn);
		JDBCTemplate.close(conn);
		return hop;
	}

	public ArrayList<Product> productArrival() {
		Connection conn = JDBCTemplate.getConnection();
		ProductDao dao = new ProductDao();
		ArrayList<Product> nc = dao.productArrival(conn);
		JDBCTemplate.close(conn);
		return nc;
	}
*/

	public PageDataLee selectList(int reqPage,String ctgr, String gender) {
		Connection conn = JDBCTemplate.getConnection();
		
		int numPerPage = 12;// 한페이지당 게시물 수
		int totalCount = dao.totalCount(conn,ctgr,gender); //전체 게시물수
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작게시물 번호
		int end = reqPage*numPerPage; // 페이지 마지막 게시물 번호
		ArrayList<ProductLee> lists = dao.selectList(conn,start,end,ctgr,gender);
		/* 페이지 네비게이션 생성 */
		String pageNavi="";
		int pageNaviSize = 5; // 페이지 넘버 수
		//pageNo는 해당 페이지 시작번호
		//1~5 =>1 , 6~10 => 6
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		
		// 이전 버튼 생성
		if(pageNo !=1) {
			pageNavi += "<a class ='btn' href='/productPage?ctgr="+ctgr+"&gender="+gender+"&?reqPage="+(pageNo-1)+"'><img src=\"/img/product/prnx2.jpg\"></a>"; //
		}
		int i=1;
		
		// i를 1부터 증가시키면서  pageNaviSize만큼 반복문
		// 단, pageNo가 totalPage보다 크면 마지막 페이지에 도달한 것이므로
		// 반복문 수행을 멈춤
		
		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<span class = 'seletPage'>"+pageNo+"</span>";
			}else {
				pageNavi += "<a class= 'btn' href ='/productPage?ctgr="+ctgr+"&gender="+gender+"&?reqPage="+pageNo+"'>"+pageNo+"</a>"; 
			}
			pageNo++;
		}
		if(pageNo<= totalPage) {
			pageNavi += "<a class = 'btn' href ='/productPage?ctgr="+ctgr+"&gender="+gender+"&?reqPage="+pageNo+"'><img src=\"/img/product/prnx3.jpg\"></a>";
		}

		PageDataLee pd = new PageDataLee(lists,pageNavi);
		
		JDBCTemplate.close(conn);
		return pd;
	}
	
	public ArrayList<ProductDtl> searchColor(){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<ProductDtl> list = dao.searchColor(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<String> subCtgr(String ctgr,String gender) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<String> sub = dao.subCtgr(conn,ctgr,gender);

		JDBCTemplate.close(conn);
		return sub;
	}

	public PageDataLee subCtgrSearch(int reqPage, String subCtgr, String gender) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		
		int numPerPage = 12;// 한페이지당 게시물 수
		int totalCount = dao.subTotalCount(conn,subCtgr,gender); //전체 게시물수
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작게시물 번호
		int end = reqPage*numPerPage; // 페이지 마지막 게시물 번호
		ArrayList<ProductLee> lists = dao.subCtgrSearch(conn,start,end,subCtgr,gender);
		/* 페이지 네비게이션 생성 */
		String pageNavi="";
		int pageNaviSize = 5; // 페이지 넘버 수
		//pageNo는 해당 페이지 시작번호
		//1~5 =>1 , 6~10 => 6
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		
		// 이전 버튼 생성
		if(pageNo !=1) {
			pageNavi += "<a class ='btn' href='/productPage?subCtgr="+subCtgr+"&gender="+gender+"&?reqPage="+(pageNo-1)+"'><img src='/img/product/prnx2.jpg'></a>"; //
		}
		int i=1;
		
		// i를 1부터 증가시키면서  pageNaviSize만큼 반복문
		// 단, pageNo가 totalPage보다 크면 마지막 페이지에 도달한 것이므로
		// 반복문 수행을 멈춤
		
		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<span class = 'seletPage'>"+pageNo+"</span>";
			}else {
				pageNavi += "<a class= 'btn' href ='/productPage?subCtgr="+subCtgr+"&gender="+gender+"&?reqPage="+pageNo+"'>"+pageNo+"</a>"; 
			}
			pageNo++;
		}
		if(pageNo<= totalPage) {
			pageNavi += "<a class = 'btn' href ='/productPage?subCtgr="+subCtgr+"&gender="+gender+"&?reqPage="+pageNo+"'><img src='/img/product/prnx3.jpg'></a>";
		}

		PageDataLee pd = new PageDataLee(lists,pageNavi);
		
		JDBCTemplate.close(conn);
		return pd;
	
	}

	public ArrayList<Integer> subCtgrCount(String ctgr, ArrayList<String> subCtgr) {
		// TODO Auto-generated method stub
		Connection conn= JDBCTemplate.getConnection();
		
		ArrayList<Integer> subCtgrCount = dao.subCtgrCount(conn,ctgr,subCtgr);
		System.out.println(subCtgrCount);
		JDBCTemplate.close(conn);
		return subCtgrCount;
	}
	
}
