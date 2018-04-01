var leftMain;
var rightNav;
var queryInput;
var leftMainOpen = false;
var searchAreaOpen = false;
var toggleLeftMainButton;
var toggleSearchAreaButton;
window.addEventListener("load", () => {
    // Left main
    leftMain = document.querySelector("#left-main");
    toggleLeftMainButton = document.querySelector("#left-main-toggle");
    toggleLeftMainButton.addEventListener("click", toggleLeftMain);
    // Right Nav
    rightNav = document.querySelector("#right-nav");
    queryInput = document.createElement("input");
    queryInput.id = "query";
    queryInput.name = "query";
    queryInput.setAttribute("placeholder", rightNav.getAttribute("data-query-place-holder"));
    rightNav.insertBefore(queryInput, rightNav.firstChild);
    toggleSearchAreaButton = document.querySelector("#search-area-toggle");
    toggleSearchAreaButton.addEventListener("click", verifySearch);
});


function toggleLeftMain() {
    leftMainOpen ^= true;
    leftMain.classList.toggle("left-to-right");
    toggleLeftMainButton.classList.toggle("toggle-menu-icon");
}

function verifySearch() {
    if (queryInput.value) {
        performSearch();
    } else {
        toggleSearchArea();
    }
}

function performSearch() {
    alert("Performing search...");
}

function toggleSearchArea() {
    searchAreaOpen ^= true;
    rightNav.classList.toggle("search-area");
}