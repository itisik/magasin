<%@page import="kr.magasin.productDtl.model.vo.ProductDtl"%>
<%@page import="kr.magasin.prdPaging.model.vo.ProductLee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<ProductLee> list = (ArrayList<ProductLee>)request.getAttribute("newList");
	String pageNavi = (String)request.getAttribute("pageNavi");
	ArrayList<ArrayList<ProductDtl>> dtlList  = (ArrayList<ArrayList<ProductDtl>>)request.getAttribute("dtlList");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common_css/layout.css">
<link rel="stylesheet" href="/css/prdPage/lists.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<style>
.paging-btn {
	color: black;
}
.selectPage{
	color: purple;
	font-size:15px;
	
}
</style>	
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
					
										
	<div class="windowContainer">
   
   
     <div class="main-div">
        <div class="main-title">
            <div class="title-middle">
                <div class="title-text">
                

                <h3> NEW > <%=list.get(0).getPrdGender().toUpperCase() %></h3>

                </div>

        
            </div>
        </div>
    </div> 
   
    <style>
    	.window-cloths{
    		padding-top:10px;
    	}
    </style>
    <div class="sub-main">
     
          <div style="width:100%;">
	    <%int n=1;
        for(int i=0; i<list.size(); i++){ %>
        
        <div class="cate-window" style="float:left;">  
            <div class="window-cloths" style="float:left; width:230px;">

            <div class="cloths-img"><a href="/productExdetail?prdId=<%=list.get(i).getPrdId() %>">
               <img src="/upload/photo/<%=list.get(i).getPrdSnImgpath()%>"></a>
            </div>
            <div class="cloths-title">
               <a href="/productExdetail?prdId=<%=list.get(i).getPrdId() %>"><%=list.get(i).getPrdName()%></a>
            </div>
            <div class="cloths-price"><span><%=list.get(i).getPrdPrice() %></span></div>
            <%-- <input type="hidden" name="prdId" value="<%=list.get(4*i+j).getPrdId() %>"> --%>
            <div class="cloths-color">
            
            <%
            for(int k=0; k<dtlList.get(i).size(); k++){
            	if(list.get(i).getPrdId() == dtlList.get(i).get(k).getPrdId()){
            %>
            
            <div class="color1" style="background-color:<%=dtlList.get(i).get(k).getPrdDtlColor()%>"></div>
           
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
				<div class="footer" id="main-footer">
					<%@include file="/WEB-INF/views/common/footer.jsp"%>
				</div>
			</footer>
		</div>
	</body>
</html>