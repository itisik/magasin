$("#customerSearchBtn").click(function() {
					const searchIndex = $("[name = searchIndex]").val();
					const selectIndex = $("[name = selectIndex]").val();
					const dateSelect = $("[name = dateSelect]").val();
					const customer = $("[name = customer]").val();
					const countList = $("#countList");

					const tbody = $("#customersResult tbody");
					
					if (searchIndex == "none") {
						tbody.html('조회기간을 선택해주세요.');
						countList.html('0');
					} else if (customer == "") {
						tbody.html('검색어를 입력해주세요');
						countList.html('0');
					} else {
						$.ajax({
							url : "/customerSearch",
							type : "get",
							data : {
								searchIndex : searchIndex,
								selectIndex : selectIndex,
								dateSelect : dateSelect,
								customer : customer
								},
							success : function(data) {
								if (data[0].cusId == "") {
									tbody.html('검색결과 없음');
									countList.html('0');
								} else {
									tbody.html('');
									
									for (let index in data) {
										const tr = $("<tr>");
										const idTd = $("<td style='width: 10%;'>").html(decodeURIComponent(data[index].cusId));
										const nameTd = $("<td style='width: 10%;'>").html(decodeURIComponent(data[index].cusName));
										let tmp;
										if(decodeURIComponent(data[index].cusGender) == "m"){
											tmp = "남성"
										} else {
											tmp = "여성"
										}
										const genderTd = $("<td style='width: 10%;'>").html(decodeURIComponent(tmp));
										const addrTd = $("<td style='width: 30%;'>").html(decodeURIComponent(data[index].cusAddr));
										const phoneTd = $("<td style='width: 10%;'>").html("0"+decodeURIComponent(data[index].cusPhone));
										const birthTd = $("<td style='width: 10%;'>").html(decodeURIComponent(data[index].cusBirthdate));
										const emailTd = $("<td style='width: 20%;'>").html(decodeURIComponent(data[index].cusEmail));
										
										tr.append(idTd).append(nameTd)
										.append(genderTd)
										.append(addrTd)
										.append(phoneTd)
										.append(birthTd)
										.append(emailTd);
										
										tbody.append(tr);
										
										countList.html(Number(index)+Number(1));
									}
								}
							},
							error : function(){
								tbody.html('검색결과 없음');
								countList.html('0');
							}
						});
					}
				});
		