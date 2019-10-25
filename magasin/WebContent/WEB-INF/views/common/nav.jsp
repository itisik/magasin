<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/common_css/nav.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

	<script>
	   $(document).ready(function(){
          $(".subNavi").hide();
          
          $(".navi>li").click(function(){              
              var index = $(".navi>li").index(this);
	          	if($(".navi>li").eq(index).children('span').text()==''){
				    $(".subNavi").hide(500);
				    $(".navi").find('span').text("");
					$(".navi>li").eq(index).children('span').text(' ');
					 $(this).next($(".subNavi")).show(500); 
				   }else if($(".navi>li").eq(index).children('span').text()==' '){   
					 $(this).next($(".subNavi")).hide(500); 
					 $(".navi>li").eq(index).children('span').text('');
				   }			            	
	              
          	}); 
       });
        
	</script>
	
    <div class="naviWrapper">
        <ul class="navi">
            <li>New<span></span></li>
            <ul class="subNavi">
            	<li><a href="#">Woman</a></li>
            	<li><a href="#">Man</a></li>
            </ul>
            <li>Woman<span></span></li>
            <ul class="subNavi">
                <li><a href="#">Best</a></li>
                <li><a href="#">Outer</a></li>
                <li><a href="#">Top</a></li>
                <li><a href="#">Bottom</a></li>
                <li><a href="#">Dress</a></li>
            </ul>
            <li>Man<span></span></li>
             <ul class="subNavi">
                <li><a href="#">Best</a></li>
                <li><a href="#">Outer</a></li>
                <li><a href="#">Top</a></li>
                <li><a href="#">Shirts</a></li>
                <li><a href="#">Bottom</a></li>
            </ul>
            <li>Common<span></span></li>
             <ul class="subNavi">
                <li><a href="#">Jewelry</a></li>
                <li><a href="#">Bag</a></li>
                <li><a href="#">Shoes</a></li>
                <li><a href="#">Acc</a></li>
            </ul>
            <li>Community<span></span></li>
             <ul class="subNavi">
                <li><a href="/noticeList">Notice</a></li>
                <li><a href="/qnaList">Q&A</a></li>
                <li><a href="/reviewList">Review</a></li>
            </ul>
        </ul>
    </div>