$("#chartSearchBtn").click(function() {
	const chartIndex = $("[name = chartIndex]").val();
	// 결제일 기준 조회 혹은 배송완료일 기준 조회
	// purchaseDate, completeDate
	const startDate = $("[name = datepicker1]").val();
	const endDate = $("[name = datepicker2]").val();

<<<<<<< HEAD
			$.ajax({
				url : "/chart",
				type : "get",
=======
	$.ajax({
		url : "/chart",
		type : "get",
		data : {
			chartIndex : chartIndex,
			startDate : startDate,
			endDate : endDate
		},
		success : function(data) {
			// ▼ 1번 차트 날짜별 구매건수와 구매금액 나오게 하기.
			const arr1 = data[0].date;
			const arr2 = data[0].countByDate;
			const arr3 = data[0].sumMoney;
			// ▲ 1번 차트 날짜별 구매건수와 구매금액 나오게 하기.

			const tmp1 = [ 'x' ];
			const tmp2 = [ '결제건수' ];
			const tmp3 = [ '결제금액' ];
			
			const result1 = tmp1.concat(arr1);
			const result2 = tmp2.concat(arr2);
			const result3 = tmp3.concat(arr3);

			let chart1 = c3.generate({
				bindto : ".top-canvas1",
>>>>>>> 3cda43826fd4486fe17db5bf77ff5f468007ee11
				data : {
					x : 'x',
					columns : [ result1, result2, result3 ],
					colors : {
						결제건수 : "#41c572",
						결제금액 : "#26a2ec"
					},
					axes : {
						결제금액 : "y2"
					},
					types : {
						결제금액 : "bar" // ADD
					}
				},
<<<<<<< HEAD
				success : function(data) {
					// ▼ 1번 차트 날짜별 구매건수와 구매금액 나오게 하기.
					const arr1 = data[0].date;
					const arr2 = data[0].countByDate;
					const arr3 = data[0].sumMoney;
					// ▲ 1번 차트 날짜별 구매건수와 구매금액 나오게 하기.

					// ▼ 2번 차트 성별 나오게 하기.
					const arr4 = data[0].date;
					const arr5 = data[0].countByDate;
					const arr6 = data[0].sumMoney;
					// ▲ 2번 차트 성별 나오게 하기.
					
					const tmp1 = [ 'x' ];
					const tmp2 = [ '결제건수' ];
					const tmp3 = [ '결제금액' ];

					const result1 = tmp1.concat(arr1);
					const result2 = tmp2.concat(arr2);
					const result3 = tmp3.concat(arr3);

					let chart1 = c3.generate({
						bindto : ".top-canvas1",
						data : {
							x : 'x',
							columns : [ result1, result2, result3 ],
							colors : {
								결제건수 : "#41c572",
								결제금액 : "#26a2ec"
							},
							axes : {
								결제금액 : "y2"
							},
							types : {
								결제금액 : "bar" // ADD
							}
						},
=======
>>>>>>> 3cda43826fd4486fe17db5bf77ff5f468007ee11

				axis : {
					x : {
						type : 'timeseries',
						tick : {
							format : '%y-%m-%d'
						}
					},
					y : {
						label : {
							text : "결제건수",
							position : "outer-middle"
						}
					},
					y2 : {
						show : true,
						label : {
							text : "결제금액",
							position : "outer-middle"
						}
					}
				}
			})
		},
		error : function() {
			alert("조회실패!");
		}
	});

	$.ajax({
		url : "/chart2",
		type : "get",
		data : {
			chartIndex : chartIndex,
			startDate : startDate,
			endDate : endDate
		},
		success : function(data) {
			// ▼ 2번 차트 성별 나오게 하기.
			const arr4 = data[0].genderNoneCount;
			const arr5 = data[0].manCount;
			const arr6 = data[0].womanCount;
			// ▲ 2번 차트 성별 나오게 하기.

			const tmp4 = [ '알수없음' ];
			const tmp5 = [ '남성' ];
			const tmp6 = [ '여성' ];

			const result4 = tmp4.concat(arr4);
			const result5 = tmp5.concat(arr5);
			const result6 = tmp6.concat(arr6);

			let chart3 = c3.generate({
				bindto : ".top-canvas3",
				data : {
					columns : [ result4, result5, result6 ],
					colors : {
						남성 : "#30a3fc",
						여성 : "#ff758c",
						알수없음 : "#cccccc"
					},
					type : "pie"
				}
			});
		},
		error : function() {
			alert("조회실패!");
		}
	});
});