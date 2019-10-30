 var prdId = $("")
$("#searchbtn").click(function(){
	 const productnamesearch = $("[name = productnamesearch]").val();
	 const prdCtgr =  $("[name = prdCtgr]").val();
	 const prdSubCtrg = $("[name = prdSubCtrg]").val();
	 const prddatesearch = $("[name = prddatesearch]").val();
	 const tbody = $("#prdresult tbody");
	 if(productnamesearch == ""){
		 tbody.html('상품명을 입력하세요');
	 }else if(prdCtgr =="none1"){
		 tbody.html('카테고리를 선택하세요');
	 }else if(prdSubCtrg =="none2"){
		 tbody.html('서브카테고리를 선택하세요');
	 }else{
		 $.ajax({
			url : "/prdSearch", 
			type : "get",
			data : {
				productnamesearch : productnamesearch,
				prdCtgr : prdCtgr,
				prdSubCtrg : prdSubCtrg,
				prddatesearch : prddatesearch
				}, 
			success : function(data) {	
					
					tbody.html('');
					for (let index in data) {
						console.log(data[index].prdFilepath);
						const tr = $("<tr class='productlisttabletr2'>");
					
						const fileinput = $("<input type='hidden'>").html(data[index].prdFilepath);
						const idTd = $("<td style='width: 9%;'>").html(data[index].prdId);
						const nameTd = $("<td style='width: 10%;'>").html(decodeURIComponent(data[index].prdName));
						const genderTd = $("<td style='width: 10%;'>").html(decodeURIComponent(data[index].prdGender));
						const cateTd = $("<td style='width: 17%;'>").html(decodeURIComponent(data[index].prdCtgr));
						const subTd = $("<td style='width: 16%;'>").html(decodeURIComponent(data[index].prdSubCtrg));
						const priceTd = $("<td style='width: 9%;'>").html(data[index].prdPrice);
						const dateTd = $("<td style='width: 17%;'>").html(decodeURIComponent(data[index].prdUpDate));
						const updateTd =  $("<td style='width: 6%;'>").html("<a href='/prdUpdate?prdId="+data[index].prdId+"'>수정</a>");
						const deleteTd =  $("<td style='width: 6%;'>").html("<button onclick=deletePrd('"+data[index].prdId+"','"+data[index].prdFilepath+"') class='updatetete'>삭제</button>");
						tr.append(idTd)
						.append(nameTd)
						.append(genderTd)
						.append(cateTd)
						.append(subTd)
						.append(priceTd)
						.append(dateTd)
						.append(updateTd)
						.append(deleteTd);
						tbody.append(tr);
							
					}
				
			},
			error : function(){
				tbody.html('검색결과 없음');
			}
					
		 });
	 } 
 });

function deletePrd(prdId,prdFilepath){
	var url = "/prdDelete";
	var encFilepath = encodeURIComponent(prdFilepath);
	location.href = url+'?prdId='+prdId+'&prdFilepath='+encFilepath;
};
