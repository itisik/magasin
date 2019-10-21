let chart1 = c3.generate({
  bindto: ".top-canvas1",
  data: {
    columns: [
      ["결제건수", 10, 22, 15, 41, 13, 25],
      ["결제금액", 510000, 1110000, 725000, 1210500, 687500, 1081000]
    ],
    colors: {
      결제건수: "#41c572",
      결제금액: "#26a2ec"
    },
    axes: {
      결제금액: "y2"
    },
    types: {
      결제금액: "bar" // ADD
    }
  },
  axis: {
    y: {
      label: {
        text: "결제건수",
        position: "outer-middle"
      }
    },
    y2: {
      show: true,
      label: {
        text: "결제금액",
        position: "outer-middle"
      }
    }
  }
});

let chart2 = c3.generate({
  bindto: ".bottom-canvas2",
  data: {
    columns: [
      [
        "시간별 결제건수",
        20,
        11,
        10,
        0,
        0,
        0,
        0,
        1,
        0,
        3,
        10,
        2,
        13,
        15,
        3,
        2,
        0,
        0,
        8,
        12,
        20,
        23,
        24,
        15
      ]
    ],
    types: {
      data1: "area"
    }
  }
});

let chart3 = c3.generate({
  bindto: ".top-canvas3",
  data: {
    columns: [
      ["남성", 1, 4, 0, 10, 2],
      ["여성", 10, 30, 20, 40, 50],
      ["알수없음", 10, 30, 200, 40, 50]
    ],
    colors: {
      남성: "#30a3fc",
      여성: "#ff758c",
      알수없음: "#cccccc"
    },
    type: "pie"
  }
});

let chart4 = c3.generate({
  bindto: ".bottom-canvas4",
  data: {
    columns: [
      ["10대", 10, 5, 1, 4, 1],
      ["20대", 20, 30, 50, 42, 35],
      ["30대", 1, 3, 8, 12, 1],
      ["40대 이상", 0, 0, 1, 0, 2],
      ["알수없음", 10, 30, 20, 40, 50]
    ],
    colors: {
      알수없음: "#cccccc"
    },
    type: "donut"
  }
});
