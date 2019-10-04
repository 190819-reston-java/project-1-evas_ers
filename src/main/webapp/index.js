'use strict';

// let logoutPanel = document.getElementById("logout-panel");
// logoutPanel.style.display = "none";
console.log("Version 1.19");

let id = null;
let firstName = null;
let lastName = null;
let email = null;
let password = null;
let position = null;

let accountMenu = document.getElementById("account-button");
let transactionTable = document.getElementById("transaction-table");

fetch("http://localhost:8080/evas_online/LiveUser?", { method: "GET" })
    .then((response) => {
        return response.json();
    })
    .then((json) => {
        console.log(json);
        id = json.employeeid;
        firstName = json.employeefirstname;
        lastName = json.employeelastname;
        email = json.employeeemail;
        password = json.employeepassword;
        position = json.employeeposition;
        console.log(json.employeeposition);
        console.log(window.location);
        if(id==null){
            window.location.replace("http://localhost:8080/evas_online/login.html");
        } else if (position === "Manager"){
            window.location.replace("http://localhost:8080/evas_online/manager_home.html");
        }
        accountMenu.innerHTML = firstName + " " + lastName;
    });



  
// fetch("http://localhost:8080/evas_online/ViewRequests", { method: "POST" })
//     .then((response) => {
//         return response.json();
//     })
// transactionTable.insertRow("piggy");
// transactionTable.innerHTML = "piggy";


let logoutPanel = document.getElementById("logout-panel");
// let logoutYes = document.getElementById("logout-panel-yes");
let logoutNo = document.getElementById("logout-panel-no");

function confirmLogout() {
    logoutPanel.style.visibility = "visible";
    overlayOn();
    console.log("OH NO DON'T LEAVE!");
}

function declineLogout() {
    logoutPanel.style.visibility = "hidden";
    overlayOff();
}

function overlayOn() {
    document.getElementById("overlay").style.visibility = "visible";
    document.getElementById("blurMe").style.filter = "blur(6px)";
}

function overlayOff() {
    document.getElementById("overlay").style.visibility = "hidden";
    document.getElementById("blurMe").style.filter = "blur(0px)";

}
