'use strict';

// let logoutPanel = document.getElementById("logout-panel");
// logoutPanel.style.display = "none";
console.log("aaahhh!!");

let id = null;
let firstName = null;
let lastName = null;
let email = null;
let password = null;
let position = null;

let accountMenu = document.getElementById("account-button");
let currentFirstName = document.getElementById("currentFirstName");
let currentLastName = document.getElementById("currentLastName");
let currentEmail = document.getElementById("currentEmail");
let currentPassword = document.getElementById("currentPassword");

// currentFirstName.innerText = "NULL";
// currentLastName.innerText = "NULL";
// currentEmail.innerText = "NULL";
// currentPassword.innerText = "****";


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
        accountMenu.innerHTML = firstName + " " + lastName;

        currentFirstName.innerText = firstName;
        currentLastName.innerText = lastName;
        currentEmail.innerText = email;
        currentPassword.innerText = censor(password);
    });


function censor(text) {
    let output = "";
    for (let i = 0; i < text.length; i++) {
        output = output + '*';
    }
    return output;
}

console.log("testing: " + censor("sdf"));


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
