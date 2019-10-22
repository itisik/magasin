<%@page import="kr.magasin.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
		ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("Product");
    
        ArrayList<Product> lop = (ArrayList<Product>)request.getAttribute("Product"); /* 같은 리스트를 쓰기 땜에 키값을 맞춰서 써줘야함. */ /*낮은 가격순 조회*/
        
        ArrayList<Product> hop = (ArrayList<Product>)request.getAttribute("Product"); /* 높은 가격순 조회 */
        
        ArrayList<Product> nc = (ArrayList<Product>)request.getAttribute("Product"); /* 최신순 으로 조회 */
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/prdPage/lists.css">
</head>
<body>
	<div class="windowContainer">
    <div class="main-div">
        <div class="main-title">
            <div class="title-top"><a href=#>home</a>><a href="#">OUTER</a></div>
            <div class="title-middle">
                <div class="title-text">
                    <h3>OUTER</h3>
                </div>
                <div class="title-category">
                <ul class="subCategory">        
                   <li><span><a href="#">JACKET</a>(109)</span></li>
                   <li><span><a href="#">CARDIGAN</a>(109)</span></li>
                   <li><span><a href="#">TRENCH COAT</a>(109)</span></li>
                   <li><span><a href="#">JUMPER / MUSTANG</a>(109)</span></li>     
                   <li><span><a href="#">COAT</a>(109)</span></li>        
                </ul>
                </div>
            </div>
        </div>
    </div>
    
    <div class="sub-main">
    <div class="sub-title">
            <div class="sub-top">
             <div>new arrivalcategory have <strong><%=list.size() %></strong> product</div>
             <div><a href="/productLowprice">low price</a> |<a href="/productHighprice">high price</a> |<a href="/productArrival">new arrival</a></div>
            </div>
        </div> 
        <%for(int i=0; i<list.size()/4; i++){ %>
        <div class="cate-window">
			<%for(int j=0; j<4; j++){ %>
            <div class="window-cloths">
            <div class="cloths-event" style="display: none;"></div>
            <div class="cloths-img"><a href="/productExdetail?prdId=<%=list.get(4*i+j).getPrdId() %>"><img src="/img/product/<%=list.get(i*4+j).getPrdSnImgpath()%>"></a></div>
            <div class="cloths-title"><a href="/productExdetail?prdId=<%=list.get(4*i+j).getPrdId() %>"><%=list.get(4*i+j).getPrdName()%></a></div>
            <div class="cloths-price"><span><%=list.get(4*i+j).getPrdPrice() %></span></div>
            <%-- <input type="hidden" name="prdId" value="<%=list.get(4*i+j).getPrdId() %>"> --%>
            <div class="cloths-color">
            <div class="color1"></div>
            <div class="color2"></div>
            <div class="color3"></div>
            <div class="color4"></div>
            </div>
            <div class="cloths-new"><div class="imgs"><img src="/img/product/custom_43.gif"></div>
            <div class="cloths-review">Review : <span></span></div>
            </div> </div>       
         <%} %>
        </div>
       <%} %>
    </div>
     <div class="move">
     <a href="#"><img src="/img/product/prnx2.jpg"></a>
     <a href="#">1</a>
     <a href="#">2</a>
     <a href="#">3</a>
     <a href="#">4</a>
     <a href="#">5</a>
     <a href=""><img src="/img/product/prnx3.jpg"></a></div>
</div>
</body>
</html>