'use strict';

console.log("version 2.27");

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
        let p = 0;
        for(var i=0;i<json.length;i++){
            var a = transactionTable.insertRow(transactionTable.size);
            var b = a.insertCell(0);
            var c = a.insertCell(1);
            var d = a.insertCell(2);
            var e = a.insertCell(3);

            b.innerHTML = json[i].employeename;
            c.innerHTML = json[i].requestcatagory;
            d.innerHTML = '$' + json[i].requestvalue;
            e.innerHTML = json[i].requeststatus;

            p = json[i].transaction;

            var f = a.insertCell(4);

            if(json[i].requeststatus === "pending"){
            //creates a form for each row
            var x = document.createElement("FORM");             //form
            x.setAttribute("id", "myForm");
            x.setAttribute("action", "ApprovalServlet");        //Connects to the servlet
            x.setAttribute("method", "POST");
            document.body.appendChild(x);

            //creates a button to select the employee
            var y = document.createElement("INPUT");            //input 1: button
            y.setAttribute("type", "submit");
            y.setAttribute("value", "Approve");
            f.appendChild(y);

            // creates a hidden field to store the employee data
            var z = document.createElement("INPUT");            //input 2: hidden field
            z.setAttribute("type", "hidden");
            z.setAttribute("value", p);    //stores the request number
            console.log(z.getAttribute("value"));
            }
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
