$("#chartSearchBtn").click(function() {
			const chartIndex = $("[name = chartIndex]").val();
			// 결제일 기준 조회 혹은 배송완료일 기준 조회
			// purchaseDate, completeDate
			const startDate = $("[name = datepicker1]").val();
			const endDate = $("[name = datepicker2]").val();
			
			$.ajax({
				url: "/chart",
				type: get,
				data : {
					chartIndex : chartIndex,
					startDate : startDate,
					endDate : endDate
					},
					success : function(data){
						// ▼ 1번 차트 날짜별 구매건수와 구매금액 나오게 하기.
						const arr1 = ['x', '2013-01-01', '2013-01-02', '2013-01-03', '2013-01-04', '2013-01-05', '2013-01-06', '2013-01-07', '2013-01-08', '2013-01-09', '2013-01-10', '2013-01-11', '2013-01-12'];
			            const arr2 =  [ "결제건수", 10, 22, 15, 41, 13, 25 ];
			            const arr3 = [ "결제금액", 510000, 1110000, 725000, 1210500, 687500, 1081000 ];
						// ▲ 1번 차트 날짜별 구매건수와 구매금액 나오게 하기.
						
						// let arr = []

						let chart1 = c3.generate({
							bindto : ".top-canvas1",
							data : {
						        x: 'x',
						        columns: [
						            arr1,
						            arr2,
									arr3
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
								x: {
						            type: 'timeseries',
						            tick: {
						                count: 7,// 변수로 설정하자.
						                format: '%Y-%m-%d'
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

						let chart2 = c3
								.generate({
									bindto : ".bottom-canvas2",
									data : {
										columns : [ [ "시간별 결제건수", 20, 11, 10, 0, 0, 0, 0, 1, 0, 3, 10, 2, 13, 15, 3, 2, 0, 0, 8, 12, 20, 23, 24, 15 ] ],
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
					error : function(){
						alert("조회실패!");
					}
			});

});