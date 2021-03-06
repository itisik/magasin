$("#memberSearchBtn").click(
				function() {
					const memberCondition = $("[name = memberCondition]").val();
					// 검색조건
					// customerName, customerId, product, totalMoney, totalCount

					const memberKeyword = $("[name = memberKeyword]").val();

					const tbody = $("#memberResult tbody");

					const memberList = $("#memberList");

					if (memberCondition == "none") {
						tbody.html('검색조건을 선택해주세요.');
						countList.html('0');
					} else if (memberKeyword == "") {
						tbody.html('검색어를 입력해주세요');
						countList.html('0');
					} else {
						$.ajax({
									url : "/memberSearch",
									type : "get",
									data : {
										memberCondition : memberCondition,
										memberKeyword : memberKeyword
									},
									success : function(data) {
										if (data[0].memId == null) {
											tbody.html('검색결과 없음');
											countList.html('0');
										} else {
											tbody.html('');
											for ( let index in data) {
												const tr = $("<tr>");
												const memIdTd = $("<td style='width: 12.5%;'>").html(decodeURIComponent(data[index].memId));
												const memNameTd = $("<td style='width: 12.5%;'>").html(decodeURIComponent(data[index].memName));
												const tMoneyTd = $("<td style='width: 12.5%;'>").html(decodeURIComponent(data[index].tMoney));
												const tCountTd = $("<td style='width: 12.5%;'>").html(decodeURIComponent(data[index].tCount));
												const enrollDate = $("<td style='width: 12.5%'>").html(decodeURIComponent(data[index].enrollDate));
												const recentOrderDateTd = $("<td style='width: 12.5%;'>").html(decodeURIComponent(data[index].recentOrderDate));
												
												const gradeTd = $("<td style='width: 12.5%;'>");
												let tmp1 = $("<select name = 'chGrade' class='chGrade' style='height: 30px;'>");
												const tmp2 = $("<option value = 'member'>").html(decodeURIComponent('member'));
												const tmp3 = ($("<option value = 'admin'>")).html(decodeURIComponent('admin'));
												if(data[index].grade == "admin"){
													tmp1.append(tmp3);
													tmp1.append(tmp2);
												} else {
													tmp1.append(tmp2);
													tmp1.append(tmp3);
												}
												gradeTd.append(tmp1);
												
												const memGradeChangeTd = $("<td style='width: 12.5%;'>");
												const tmp4 = $("<button id = '" + data[index].memId + "' class='chGradeBtn'>").html(decodeURIComponent('등급변경'));
												memGradeChangeTd.append(tmp4);
												
												tr.append(memIdTd)
														.append(memNameTd)
														.append(tMoneyTd)
														.append(tCountTd)
														.append(enrollDate)
														.append(recentOrderDateTd)
														.append(gradeTd)
														.append(memGradeChangeTd);

												tbody.append(tr);

												memberList.html(Number(index) + Number(1));
											}
										}
									},
									error : function() {
										tbody.html('검색결과 없음');
										countList.html('0');
									}
								})
					}
				})