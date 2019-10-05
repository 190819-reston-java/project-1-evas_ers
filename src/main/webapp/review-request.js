'use strict';

// let logoutPanel = document.getElementById("logout-panel");
// logoutPanel.style.display = "none";
console.log("2.11");

let id = null;
let firstName = null;
let lastName = null;
let email = null;
let password = null;
let position = null;
// let accountMenu = document.getElementById("account-button");

let accountMenu = document.getElementById("account-button");
let currentFirstName = document.getElementById("currentFirstName");
let currentLastName = document.getElementById("currentLastName");
// let currentEmail = document.getElementById("currentEmail");
// let currentPassword = document.getElementById("currentPassword");



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


// console.log("testing");
// name.innerText = "bob";    
// var info = "Additional Info:"
// information.innerText="additional text goes here";
let name = document.getElementById("name");
// let emp_position = document.getElementById("position");
let value = document.getElementById("value");
let category = document.getElementById("category");
let information = document.getElementById("information");
let approve = document.getElementById("approve-button");
let deny = document.getElementById("deny-button");
let back = document.getElementById("backButton");
let home = document.getElementById("homeButton");


fetch("http://localhost:8080/evas_online/SelectRequest", { method: "POST" })
    .then((response) => {
        return response.json();
    })
    .then((json) => {
        console.log("Getting request")
        console.log(json);

        name.innerHTML = json.employeename;
        value.innerHTML = '$' + json.requestvalue;
        category.innerHTML = json.requestcategory;
        information.innerHTML = json.requestinformation;

        if (json.requeststatus != 'pending' && json.requeststatus != 'Pending') {
            approve.disabled = true;
            deny.disabled = true;
            alert("The selected item has been resolved");
            back.style.visibility = "visible";
            home.style.visibility = "visible";
        }

    });
    
    // deny.remove();
function goBack(){
    window.history.back();
}


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
