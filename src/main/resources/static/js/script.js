var rateButtons = document.getElementsByClassName("rate");
var closeButton = document.getElementById("close");
var ratingDialog = document.getElementById("myModal");

ratingDialog.style.display = "none";

closeButton.onclick = function () {
  ratingDialog.style.display = "none";
};

window.onclick = function (event) {
  if (event.target == ratingDialog) {
    ratingDialog.style.display = "none";
  }
};

for(let i = 0; i < rateButtons.length; i++)
  rateButtons[i].onclick = function (event) {
    ratingDialog.style.display = "block";
    document.getElementById("hotelid").value = event.srcElement.attributes.hotelid.nodeValue;
  }
