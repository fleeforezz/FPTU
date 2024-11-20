// Hamburger Button
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
    for (j = 0; j < click.length; j++) {
        click[j].style.display = "none";
    }
    click[clickIndex - 1].style.display = "block";
}

// Image preview
function previewImage(event) {
    const file = event.target.files[0];
    const preview = document.getElementById("imagePreview");

    if (file) {
        // Create a URL for the selected image
        const reader = new FileReader();
        reader.onload = function (e) {
            preview.src = e.target.result;
            preview.style.display = "block";
        }
        reader.readAsDataURL(file); // Read file as Data URL
    } else {
        preview.src = "#";
        preview.style.display = "none"; // Hide preview if no file is selected
    }
}

// Sidebar collapse
function openNav() {
  document.getElementById("mySidenav").style.width = "30%";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
