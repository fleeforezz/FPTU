function openNav() {
  document.getElementById("hamburger-btn").style.width = "100%";
}

function closeNav() {
  document.getElementById("hamburger-btn").style.width = "0%";
}


// Customer Says
let clickIndex = 1;
clickSlides(clickIndex);

function nextSlides(m) {
  clickSlides(clickIndex += m);
}

function currentClick(m) {
  clickSlides(clickIndex = m);
}

function clickSlides(m) {
  let j;
  let click = document.getElementsByClassName("customer-says-message");
  if (m > click.length) {
    clickIndex = 1;
  }
  if (m < 1) {
    clickIndex = click.length;
  }
  for (j=0; j<click.length; j++) {
    click[j].style.display = "none";
  }
  click[clickIndex - 1].style.display = "block";
}


