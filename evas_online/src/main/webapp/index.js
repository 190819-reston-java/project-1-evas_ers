'use strict';

// let logoutPanel = document.getElementById("logout-panel");
// logoutPanel.style.display = "none";

let accountMenu = document.getElementById("account-button");
accountMenu.innerHTML = "BLAHBLAH"

let logoutPanel = document.getElementById("logout-panel");
// let logoutYes = document.getElementById("logout-panel-yes");
let logoutNo = document.getElementById("logout-panel-no");

function confirmLogout() {
    logoutPanel.style.visibility = "visible";
    overlayOn();
}

function declineLogout(){
    logoutPanel.style.visibility = "hidden";
    overlayOff();
}

function overlayOn(){
    document.getElementById("overlay").style.visibility = "visible";
    document.getElementById("blurMe").style.filter = "blur(6px)";
}

function overlayOff(){
    document.getElementById("overlay").style.visibility = "hidden";
    document.getElementById("blurMe").style.filter = "blur(0px)";

}

// let logoutConfirm=document.getElementById("confirm-logout");

// document.getElementById("confirm-logout").style.display="none";

// let logoutButton = document.getElementByID("logoutButton");
// logoutButton.addEventListener("click", (event)=>{
// 	document.getElementById("confirm-logout").style.display = "none";
// });

// logoutConfirm.hidden="false";

// x.innerText;
// document.getelementById("demo").innerHTML = "hi from js";