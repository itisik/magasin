
<%@page import="kr.magasin.productDtl.model.vo.ProductDtl"%>
<%@page import="kr.magasin.prdPaging.model.vo.ProductLee"%>

<%@page import="kr.magasin.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
      /* ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");*/
         
        ArrayList<ProductLee> lists = (ArrayList<ProductLee>)request.getAttribute("lists");
        String pageNavi = (String)request.getAttribute("pageNavi");
        ArrayList<ArrayList<ProductDtl>> prdDtl = (ArrayList<ArrayList<ProductDtl>>)request.getAttribute("prdDtl");
        ArrayList<String> subCtgr = (ArrayList<String>)request.getAttribute("sub");


        ArrayList<Integer> subCtgrCount = (ArrayList<Integer>)request.getAttribute("count");

   %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/prdPage/lists.css">
<link rel="stylesheet" href="/css/common_css/layout.css">
</head>
<body id="body1">

	<div class="wrapper">
		<header>
			<div class="header">
				<%@include file="/WEB-INF/views/common/header.jsp"%>
			</div>
		</header>
		<section>
			<div class="mainContainer">
				<div class="side-nav">
					<%@include file="/WEB-INF/views/common/nav.html"%>
				</div>
				<div class="mainContent" style="width: 943px;">
					<!-- 만드신 콘텐츠 넣으세요!!!!!!!!!!!!!!!!width 반드시 943!!!!!!!!!!!!!!!!!!!!!!!!!! -->
					

	<div class="windowContainer">
	
	
    <div class="main-div">

        <div class="main-title">
            <div class="title-middle">
                <div class="title-text">
                
                <%if(!lists.isEmpty()){
               		if(lists.get(0).getPrdCtgr().indexOf("_")==-1){ %>
                	<h3><%=lists.get(0).getPrdCtgr().toUpperCase() %></h3>
                <%}else{ %>
                <h3><%=lists.get(0).getPrdCtgr().substring(0,lists.get(0).getPrdCtgr().indexOf("_")).toUpperCase() %></h3>
                <%} 
                }%>
                </div>
                
                <div class="title-category">     


                             <ul class="subCategory">  
                
                <%int c=0;
                for(String sub : subCtgr) {
                	
                %>
                   
                   <li><a href="/subCtgrSearch?ctgr=<%=lists.get(0).getPrdCtgr() %>&subCtgr=<%=sub%>&gender=<%=lists.get(0).getPrdGender()%>"><%=sub.toUpperCase()%></a>(<span class="subCtgr-count"><%=subCtgrCount.get(c) %></span>)</li>
           
                <% c++;
                   }%>
				


                </ul>

                </div>
            </div>
        </div>
    </div> 
   
    
    <div class="sub-main">
    <div class="sub-title">
             <div class="sub-top"  >new arrivalcategory have <strong><%=lists.size() %></strong> product</div> 
        </div> 
        
             
    <div style="width:100%;">
	    <%int n=1;
        for(int i=0; i<lists.size(); i++){ %>
        
        <div class="cate-window" style="float:left;">  
            <div class="window-cloths" style="float:left; width:230px;">

            <div class="cloths-img"><a href="/productExdetail?prdId=<%=lists.get(i).getPrdId() %>">
               <img src="/upload/photo/<%=lists.get(i).getPrdSnImgpath()%>"></a>
            </div>
            <div class="cloths-title">
               <a href="/productExdetail?prdId=<%=lists.get(i).getPrdId() %>"><%=lists.get(i).getPrdName()%></a>
            </div>
            <div class="cloths-price"><span><%=lists.get(i).getPrdPrice() %></span></div>
            <%-- <input type="hidden" name="prdId" value="<%=list.get(4*i+j).getPrdId() %>"> --%>
            <div class="cloths-color">
            
            <%
            for(int k=0; k<prdDtl.get(i).size(); k++){if(lists.get(i).getPrdId() == prdDtl.get(i).get(k).getPrdId()){
            %>
            
            <div class="color1" style="background-color:<%=prdDtl.get(i).get(k).getPrdDtlColor()%>"></div>

           
            <%}
               }%>
           </div>
            </div>
        </div>
       	 <%if(i==4*n-1){ %>
			<div style="clear:both; width:100%;"></div>
			<%++n;} %>
		 
        <%} %>
   	</div>
    
     <div class="move" style="clear:both;"><%=pageNavi %></div> 
</div>            
            </div>
            </div>
      </section>
      <footer>
         <div class="footer">
            <%@include file="/WEB-INF/views/common/footer.jsp"%>
         </div>
      </footer>
   </div>

</body>
</html>