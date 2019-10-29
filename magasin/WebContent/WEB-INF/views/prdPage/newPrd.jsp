<%@page import="kr.magasin.productDtl.model.vo.ProductDtl"%>
<%@page import="kr.magasin.prdPaging.model.vo.ProductLee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<ProductLee> list = (ArrayList<ProductLee>)request.getAttribute("newList");
	String pageNavi = (String)request.getAttribute("pageNavi");
	ArrayList<ProductDtl> dtlList  = (ArrayList<ProductDtl>)request.getAttribute("dtlList");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common_css/layout.css">
<link rel="stylesheet" href="/css/prdPage/lists.css">
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
     
        <%for(int i=0; i<list.size()/4; i++){ %>

        <div class="cate-window">
         <%for(int j=0; j<4; j++){ %>
	            <div class="window-cloths">
	            <div class="cloths-event" style="display: none;"></div>
	
	            <div class="cloths-img"><a href="/productExdetail?prdId=<%=list.get(4*i+j).getPrdId() %>">
	               <img src="/img/product/<%=list.get(4*i+j).getPrdSnImgpath()%>"></a>
	            </div>
	            <div class="cloths-title">
	               <a href="/productExdetail?prdId=<%=list.get(4*i+j).getPrdId() %>"><%=list.get(4*i+j).getPrdName()%></a>
	            </div>
	            <div class="cloths-price"><span><%=list.get(4*i+j).getPrdPrice() %></span></div>
	            <%-- <input type="hidden" name="prdId" value="<%=list.get(4*i+j).getPrdId() %>"> --%>
	           <div class="cloths-color">
	            
	 			 <%
	            for(int k=0; k<dtlList.size(); k++){
	 
 	               if(list.get(4*i+j).getPrdId() == dtlList.get(k).getPrdId()){
 	            %>
	            
	            <div class="color1" style="background-color:<%=dtlList.get(k).getPrdDtlColor()%>;"></div>
	           
	            <% 
 	               }
	            }%> 
	            <!--  <div class="color2"></div>
	            <div class="color3"></div>
	            <div class="color4"></div> -->
	            </div>
	            <div class="cloths-new">

            	<div class="cloths-review">Review : <span></span></div>
            	</div> 
            </div>       
          <%} %> 
        </div>
       <%} %>
    </div>
										
				
									
							 <div class="move"><%=pageNavi %></div> 			
										
											
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