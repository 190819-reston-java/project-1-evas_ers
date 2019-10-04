'use strict';

console.log("version 8.17");

let id = null;
let firstName = null;
let lastName = null;
let accountMenu = document.getElementById("account-button");
let transactionTable = document.getElementById("transaction-table");
// transactionTable.insertRow(3).

fetch("http://localhost:8080/evas_online/LiveUser?", { method: "GET" })
    .then((response) => {
        return response.json();
    })
    .then((json) => {
        console.log(json);
        firstName = json.employeefirstname;
        lastName = json.employeelastname;
        accountMenu.innerHTML = firstName + " " + lastName;
        // transactionTable.innerHTML = firstName + " " + lastName;
    });


    
    /* Edit this block of code: */
fetch("http://localhost:8080/evas_online/ViewAll", { method: "POST" })
    .then((response) => {
        return response.json();
    })
    .then((json) => {
        console.log(json);
        for(var i=0;i<json.length;i++){
            var a = transactionTable.insertRow(transactionTable.size);
            var b = a.insertCell(0);
            var c = a.insertCell(1);
            var d = a.insertCell(2);
            var e = a.insertCell(3);

            b.innerHTML = json[i].reimbursementdate;
            c.innerHTML = "Travel/Overnight";
            d.innerHTML = '$' + json[i].reimbursementamount;
            e.innerHTML = json[i].reimbursementstatus;

            var f = a.insertCell(4);

            //creates a form for each row
            var x = document.createElement("FORM");
            x.setAttribute("id", "myForm");
            x.setAttribute("action", "ViewEmployeeRequests");
            document.body.appendChild(x);

            //creates a button to select the employee
            var y = document.createElement("INPUT");
            y.setAttribute("type", "submit");
            y.setAttribute("value", json[i].employeelastname);
            f.appendChild(y);

            // creates a hidden field to store the employee data
            var z = document.createElement("INPUT");
            z.setAttribute("type", "hidden");
            z.setAttribute("value", json[i].reimbursementstatus);
            console.log(z.getAttribute("value"));
        }
    });


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