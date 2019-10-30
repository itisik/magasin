package kr.magasin.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.magasin.common.JDBCTemplate;
import kr.magasin.product.model.dao.ProductDao;
import kr.magasin.product.model.vo.Product;
import kr.magasin.productDtl.model.vo.ProductDtl;
import oracle.sql.converter.JdbcCharacterConverters;

public class ProductService {


   public ArrayList<Product> productList(int prdId) {
      Connection conn = JDBCTemplate.getConnection();
      ProductDao dao = new ProductDao();
      ArrayList<Product> list = dao.productList(conn,prdId);
      JDBCTemplate.close(conn);
      return list;
   }

   public int delete(int prdId) {
      Connection conn = JDBCTemplate.getConnection();
      ProductDao dao = new ProductDao();
      int result = dao.delete(conn, prdId);
      if(result>0){
         JDBCTemplate.commit(conn);
      }else{
         JDBCTemplate.rollback(conn);
      }
      JDBCTemplate.close(conn);
      return result;
   }

   public int insertProduct(Product p) {
      Connection conn = JDBCTemplate.getConnection();
      ProductDao dao = new ProductDao();
      
      int result = dao.insertProduct(conn, p);
      if(result>0){
//         int refKey = dao.selectSequenNo(conn);
//         for(int i=0; i<list.size(); i++){
//            int result1 = dao.insertProductdtl(conn, refKey, list.get(i));
//            if(result>0){
//               totalResult++;
//            }
//         }
         JDBCTemplate.commit(conn);
      }else{
         JDBCTemplate.rollback(conn);
      }
//      if(totalResult == list.size()){
//         
//      }else{
//         
//      }
      JDBCTemplate.close(conn);
      return result;
   }
   
   public int productInsert(Product p, ArrayList<ProductDtl> list) {
      Connection conn = JDBCTemplate.getConnection();
      ProductDao dao = new ProductDao();
      int totalResult =0;
      int result = dao.insertProduct(conn, p); //상품등록 먼저
      if(result>0){
         int refKey = dao.selectSequenNo(conn); //prdId 확인
         for(int i=0; i<list.size(); i++){
            int result1= dao.insertProdctdtl(conn, refKey, list.get(i));//prddtl 등록
            System.out.println("리스트 값 확인");
            System.out.println(list.get(i).getPrdDtlColor());
            if(result>0){
               totalResult++;
            }
         }
         JDBCTemplate.commit(conn);

 		JDBCTemplate.close(conn);

         return 1;
      }else {
         JDBCTemplate.rollback(conn);
         JDBCTemplate.close(conn);
         return -1;
      }
   }

   public ArrayList<Product> productSearch(String productnamesearch, String prdCtgr, String prdSubCtrg,int prddatesearch) {
      Connection conn = JDBCTemplate.getConnection();
       ProductDao dao = new ProductDao();
       ArrayList<Product> list = new ArrayList<Product>();
       list = dao.productList(conn,productnamesearch,prdCtgr,prdSubCtrg,prddatesearch);
       if(list.isEmpty()){
          JDBCTemplate.rollback(conn);
       } else {
          JDBCTemplate.commit(conn);
       }
       JDBCTemplate.close(conn);
       return list;
   }

public Product searchOne(int prdId) {
   Connection conn = JDBCTemplate.getConnection();
   ProductDao dao = new ProductDao();
   Product p = dao.searchOne(conn, prdId);
		/*
		 * if(p !=null){ ArrayList<ProductDtl> list = dao.searchdtl(conn, prdId); }
		 */
   JDBCTemplate.close(conn);
   return p;
}

public int updateProduct(Product p) {
   Connection conn = JDBCTemplate.getConnection();
   ProductDao dao = new ProductDao();
   int result = dao.updateProduct(conn,p);
   if(result>0){
      JDBCTemplate.commit(conn);
   }else {
      JDBCTemplate.rollback(conn);
   }
   JDBCTemplate.close(conn);
   return result;
}


      
}