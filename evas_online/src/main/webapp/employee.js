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


    
var j0={"reimbursementid":2,"reimbursementamount":9.99,"reimbursementdate":1560139200000,"reimbursementstatus":"resolved"}
var j1={"reimbursementid":2,"reimbursementamount":21.99,"reimbursementdate":1560139200000,"reimbursementstatus":"pending"}

var testJson = {j0, j1};
console.log(testJson.size);
console.log(testJson.length);
console.log(Object.keys(testJson).length);

for(let p=0;p<Object.keys(testJson).length;p++){
    var a = transactionTable.insertRow(transactionTable.size);
    var b = a.insertCell(0);
    var c = a.insertCell(1);
    var d = a.insertCell(2);
    var e = a.insertCell(3);
    var f = a.insertCell(4);
    b.innerHTML = Object.keys(testJson)[p].reimbursementamount;
    c.innerHTML = "Travel/sdf";
    d.innerHTML = Object.keys(testJson)[p].reimbursementamount;
    e.innerHTML = Object.keys(testJson)[p].reimbursementstatus;
    // var myForm = f.appendChild("FORM");
    // var myForm = document.createElement("FORM");
    // f.appendChild(myForm);
    // // myForm.innerHTML = hi;
    // var myButton = document.createElement("input");
    // // myButton.setAttribute("type", "submit");
    // // myButton.setAttribute("value", "Select");

    var x = document.createElement("FORM");
    x.setAttribute("id", "myForm");
    document.body.appendChild(x);

    var y = document.createElement("INPUT");
    y.setAttribute("type", "submit");
    y.setAttribute("value", "Select");
    f.appendChild(y);

}


/* Edit this block of code: */
// fetch("http://localhost:8080/evas_online/EmployeeList", { method: "POST" })
//     .then((response) => {
//         return response.json();
//     })
//     .then((json) => {
//         console.log(json);
//         for (var i = 0; i < json.length; i++) {
//             var a = transactionTable.insertRow(transactionTable.size);
//             var b = a.insertCell(0);

//             //creates a form for each row
//             var x = document.createElement("FORM");
//             x.setAttribute("id", "myForm");
//             document.body.appendChild(x);

//             //creates a button to select the employee
//             var y = document.createElement("INPUT");
//             y.setAttribute("type", "submit");
//             y.setAttribute("value", json[i].employeelastname);
//             b.appendChild(y);

//             // creates a hidden field to store the employee data
//             var z = document.createElement("INPUT");
//             z.setAttribute("type", "hidden");
//             z.setAttribute("value", e.innerHTML);
//             console.log(z.getAttribute("value"));

//             var c = a.insertCell(1);
//             var d = a.insertCell(2);
//             var e = a.insertCell(3);
//             var f = a.insertCell(4);
//             c.innerHTML = json[i].employeelastname;
//             d.innerHTML = json[i].employeefirstname;
//             e.innerHTML = json[i].employeeposition;
//             f.innerHTML = json[i].employeeemail;
//         }
//     });

    // fetch("http://localhost:8080/evas_online/EmployeeList", { method: "POST" })
    // .then((response) => {
    //     return response.json();
    // })
    // .then((json) => {
    //     console.log(json);
    //     for(var i=0;i<json.length;i++){
    //         var a = transactionTable.insertRow(transactionTable.size);
    //         var b = a.insertCell(0);
    //         var c = a.insertCell(1);
    //         var d = a.insertCell(2);
    //         var e = a.insertCell(3);
    //         var f = a.insertCell(4);
    //         b.innerHTML = json[i].employeelastname;
    //         c.innerHTML = json[i].employeefirstname;
    //         d.innerHTML = json[i].employeeposition;
    //         e.innerHTML = json[i].employeeemail;
    //         a.createElement("FORM");
            
            
    //     }
    // });


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
