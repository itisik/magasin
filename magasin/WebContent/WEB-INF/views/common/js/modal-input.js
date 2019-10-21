// 우선, 모달창을 띄우기 전에 클릭할 객체를 적어주셔야 합니다.
// 저는 button이라는 id를 가진 버튼을 클릭했을때를 가정하고 코딩했습니다.

document.getElementById("button").addEventListener("click", function() {
  document.querySelector(".bg-modal").style.display = "flex";
});

document.querySelector(".close").addEventListener("click", function() {
  document.querySelector(".bg-modal").style.display = "none";
});
