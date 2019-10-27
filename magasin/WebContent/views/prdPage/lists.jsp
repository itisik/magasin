<%@page import="java.util.HashMap"%>
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
        ArrayList<ProductDtl> prdDtl = (ArrayList<ProductDtl>)request.getAttribute("prdDtl");
        ArrayList<String> subCtgr = (ArrayList<String>)request.getAttribute("sub");
        
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/prdPage/lists.css">
</head>
<body>

	<div class="windowContainer mainContent" style="width: 943px;">

	<div class="windowContainer">
	
	
    <div class="main-div">
        <div class="main-title">
            <div class="title-middle">
                <div class="title-text">
                <h3><%=lists.get(0).getPrdCtgr() %></h3>
                </div>
                
                <div class="title-category">     
                <ul class="subCategory">  
                <%for(String sub : subCtgr) {%>
                   <li><span><%=sub%></span></li>      
                <%} %>
                </ul>
                </div>
            </div>
        </div>
    </div>
   
    
    <div class="sub-main">
    <div class="sub-title">
             <div class="sub-top"  >new arrivalcategory have <strong><%=lists.size() %></strong> product</div> 
        </div> 
        <%for(int i=0; i<lists.size()/4; i++){ %>
        <div class="cate-window">
			<%for(int j=0; j<4; j++){ %>
            <div class="window-cloths">
            <div class="cloths-event" style="display: none;"></div>
            <div class="cloths-img"><a href="/productExdetail?prdId=<%=lists.get(4*i+j).getPrdId() %>">
            	<img src="/img/product/<%=lists.get(i*4+j).getPrdSnImgpath()%>"></a>
            </div>
            <div class="cloths-title">
            	<a href="/productExdetail?prdId=<%=lists.get(4*i+j).getPrdId() %>"><%=lists.get(4*i+j).getPrdName()%></a>
            </div>
            <div class="cloths-price"><span><%=lists.get(4*i+j).getPrdPrice() %></span></div>
            <%-- <input type="hidden" name="prdId" value="<%=list.get(4*i+j).getPrdId() %>"> --%>
            <div class="cloths-color">
            
            <%
            for(int k=0; k<prdDtl.size(); k++){
 
            	if(lists.get(4*i+j).getPrdId() == prdDtl.get(k).getPrdId()){
            %>
            
            <div class="color1" style="background-color:<%=prdDtl.get(k).getPrdDtlColor()%>"></div>
           
            <% 
            }
            }%>
           <!--  <div class="color2"></div>
            <div class="color3"></div>
            <div class="color4"></div> -->
            </div>
            <div class="cloths-new">
            <div class="cloths-review">Review : <span></span></div>
            </div> </div>       
         <%} %>
        </div>
       <%} %>
    </div>
     <div class="move"><%=pageNavi %></div> 
</div>

</body>
</html>