<%@page import="kr.magasin.productDtl.model.vo.ProductDtl"%>
<%@page import="kr.magasin.prdPaging.model.vo.ProductLee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<ProductLee> list = (ArrayList<ProductLee>)request.getAttribute("subList");
	String pageNavi = (String)request.getAttribute("pageNavi");
    ArrayList<ProductDtl> prdDtl = (ArrayList<ProductDtl>)request.getAttribute("prdDtl");
    ArrayList<String> subCtgrList = (ArrayList<String>)request.getAttribute("subCtgrList");
    ArrayList<Integer> subCtgrCount = (ArrayList<Integer>)request.getAttribute("count");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
                
                <h3><%=list.get(0).getPrdCtgr().toUpperCase() %></h3>
                
                </div>

                <div class="title-category">     
                <ul class="subCategory">  
                
                <%int c=0;
                for(String sub : subCtgrList) {
                	
                %>
                   
                   <li><a href="/subCtgrSearch?ctgr=<%=list.get(0).getPrdCtgr() %>&subCtgr=<%=sub%>&gender=<%=list.get(0).getPrdGender()%>"><%=sub%></a>(<span class="subCtgr-count"><%=subCtgrCount.get(c) %></span>)</li>
           
                <% c++;
                   }%>
				
                </ul>
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
    <div class="sub-title">
             <div class="sub-top">new arrivalcategory have <strong><%=list.size() %></strong> product</div> 
        </div> 
        <%for(int i=0; i<list.size()/2; i++){ %>

        <div class="cate-window">
         <%for(int j=0; j<2; j++){ %>
	            <div class="window-cloths">
	            <div class="cloths-event" style="display: none;"></div>
	
	            <div class="cloths-img"><a href="/productExdetail?prdId=<%=list.get(2*i+j).getPrdId() %>">
	               <img src="/img/product/<%=list.get(2*i+j).getPrdSnImgpath()%>"></a>
	            </div>
	            <div class="cloths-title">
	               <a href="/productExdetail?prdId=<%=list.get(2*i+j).getPrdId() %>"><%=list.get(2*i+j).getPrdName()%></a>
	            </div>
	            <div class="cloths-price"><span><%=list.get(2*i+j).getPrdPrice() %></span></div>
	            <%-- <input type="hidden" name="prdId" value="<%=list.get(4*i+j).getPrdId() %>"> --%>
	            <div class="cloths-color">
	            
	 			 <%
	            for(int k=0; k<prdDtl.size(); k++){
	 
	               if(list.get(4*i+j).getPrdId() == prdDtl.get(k).getPrdId()){
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
            	</div> 
            </div>       
         <%} %>
        </div>
       <%} %>
    </div>
     <div class="move"><%=pageNavi %></div> 
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