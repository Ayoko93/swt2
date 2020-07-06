var modal = document.getElementById("myModal");
var btnOpen = document.getElementById("b_open");
var span = document.getElementsByClassName("close")[0];

modal.style.display = "none";

btnOpen.onclick = function () {
  modal.style.display = "block";
};

span.onclick = function () {
  modal.style.display = "none";
};


window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
};