$("#chartSearchBtn").click(
		function() {
			const chartIndex = $("[name = chartIndex]").val();
			// 결제일 기준 조회 혹은 배송완료일 기준 조회
			// purchaseDate, completeDate
			const startDate = $("[name = datepicker1]").val();
			const endDate = $("[name = datepicker2]").val();

			console.log(chartIndex);
			console.log(startDate);
			console.log(endDate);

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

					// ▼ 2번 차트 성별 나오게 하기.
					const arr1 = data[0].date;
					const arr2 = data[0].countByDate;
					const arr3 = data[0].sumMoney;
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
					});

					let chart2 = c3.generate({
						bindto : ".bottom-canvas2",
						data : {
							columns : [ [ "시간별 결제건수", 20, 11, 10, 0, 0, 0, 0,
									1, 0, 3, 10, 2, 13, 15, 3, 2, 0, 0, 8, 12,
									20, 23, 24, 15 ] ],
							types : {
								data1 : "area"
							}
						}
					});

					let chart3 = c3.generate({
						bindto : ".top-canvas3",
						data : {
							columns : [ [ "남성", 1, 4, 0, 10, 2 ],
									[ "여성", 10, 30, 20, 40, 50 ],
									[ "알수없음", 10, 30, 200, 40, 50 ] ],
							colors : {
								남성 : "#30a3fc",
								여성 : "#ff758c",
								알수없음 : "#cccccc"
							},
							type : "pie"
						}
					});

					let chart4 = c3.generate({
						bindto : ".bottom-canvas4",
						data : {
							columns : [ [ "10대", 10, 5, 1, 4, 1 ],
									[ "20대", 20, 30, 50, 42, 35 ],
									[ "30대", 1, 3, 8, 12, 1 ],
									[ "40대 이상", 0, 0, 1, 0, 2 ],
									[ "알수없음", 10, 30, 20, 40, 50 ] ],
							colors : {
								알수없음 : "#cccccc"
							},
							type : "donut"
						}
					});
				},
				error : function() {
					alert("조회실패!");
				}
			});
		});