'use strict';

console.log("version 11:01");

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

fetch("http://localhost:8080/evas_online/ViewRequests", { method: "POST" })
    .then((response) => {
        return response.json();
    })
    .then((json) => {
        console.log(json);
        // transactionTable.innerHTML = json[1].reimbursementamount;
        // var tr = document.createElement("tr");
        // var td = document.createElement("td");
        // td.innerText = json[1].reimbursementdate;
        // for(var i=0;i<json.length;i++){
        //     var newRow = transactionTable.insertRow(transactionTable.rows.length);
        //     var cellDate = newRow.insertCell(0);
        //     var dateText = document.createTextNode(json[i].reimbursementdate);
        // }
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
        }
    });

addRow(transactionTable);



// var j0={"reimbursementid":2,"reimbursementamount":9.99,"reimbursementdate":1560139200000,"reimbursementstatus":"resolved"}
// var j1={"reimbursementid":2,"reimbursementamount":21.99,"reimbursementdate":1560139200000,"reimbursementstatus":"pending"}

// var testJson = {j0, j1};
// console.log(testJson.size);
// console.log(testJson.length);
// console.log(Object.keys(testJson).length);

// for(let p=0;p<Object.keys(testJson).length;p++){
//     var a = transactionTable.insertRow(transactionTable.size);
//     var b = a.insertCell(0);

//     var x = document.createElement("FORM");
//     x.setAttribute("id", "myForm");
//     document.body.appendChild(x);

//     var y = document.createElement("INPUT");
//     y.setAttribute("type", "submit");
//     y.setAttribute("value", "Select");
//     b.appendChild(y);

//     var c = a.insertCell(1);
//     var d = a.insertCell(2);
//     var e = a.insertCell(3);
//     var f = a.insertCell(4);
//     c.innerHTML = Object.keys(testJson)[p].reimbursementamount;
//     d.innerHTML = "Travel/sdf";
//     e.innerHTML = Object.keys(testJson)[p].reimbursementamount;
//     f.innerHTML = Object.keys(testJson)[p].reimbursementstatus;

//     var z = document.createElement("INPUT");
//     z.setAttribute("type", "hidden");
//     z.setAttribute("value", e.innerHTML);
//     // b.appendChild(y);
//     console.log(z.getAttribute("value"));
// }

// console.log(testJson[j1].reimbursementamount);
// console.log(testJson[0].reimbursementid);

// rowFunction("transaction-table");
// rowFunction("transaction-table");
// rowFunction("transaction-table");

// rowFunction("transaction-table");

// function rowFunction(x) {
//     var a = transactionTable.insertRow(transactionTable.size);
//     var b = a.insertCell(0);
//     var c = a.insertCell(1);
//     var d = a.insertCell(2);
//     var e = a.insertCell(3);
//     b.innerHTML = "1/9";
//     c.innerHTML = "Travel/Overnight";
//     d.innerHTML = "$100";
//     e.innerHTML = "Pending";
//  }

//  ****OKAY****
//  function rowFunction(x) {
//     var a = document.getElementById(x).insertRow(x.size);
//     var b = a.insertCell(0);
//     var c = a.insertCell(1);
//     var d = a.insertCell(2);
//     var e = a.insertCell(3);
//     b.innerHTML = "1/9";
//     c.innerHTML = "Travel/Overnight"
//     d.innerHTML = "$100"
//     e.innerHTML = "Pending"
//  }


//  rowFunction("transaction-table");
//  rowFunction("transaction-table");
//  rowFunction("transaction-table");
 
 
//  function rowFunction(x) {
    //  var a = document.getElementById(x).insertRow(transactionTable.rows.length);
    //  var b = a.insertCell(0);
    //  var c = a.insertCell(1);
    //  var d = a.insertCell(2);
    //  var e = a.insertCell(4);
    //  b.innerHTML = "1/9";
    //  c.innerHTML = "Travel/Overnight"
    //  d.innerHTML = "$100"
    //  e.innerHTML = "Pending"
//   }



// var newRow = transactionTable.insertRow(transactionTable.rows.length);
// var cellDate = newRow.insertCell(0);
// var dateText = document.createTextNode(testJson.reimbursementdate);
// cellDate.appendChild(dateText);
// var celldesc = newRow.insertCell(1);
// var descText = document.createTextNode("Travel/Overnight");
// cellDate.appendChild(descText);


// var tr = document.createElement("tr");
// var tdDate = document.createElement("td");
// tdDate.innerText = "json[1].reimbursementdate";
// var tdDetails = document.createElement("td");
// tdDetails.innerText = "fuel + hotel";
// var tdAmt = document.createElement("td");
// tdAmt.innerText = "amount goes here";
// var tdDate = document.createElement("td");
// tdDate.innerText = "it was lovely";


// function addRow(tableID) {
//     let newRow = tableID.insertRow(-1);
//     let newCell = newRow.insertCell(0);
//     let newText = document.createTextNode("new row guys");
//     let newCell2 = newRow.insertCell(1);
//     let newText2 = document.createTextNode("column #2");
//     let newCell3 = newRow.insertCell(2);
//     let newText3 = document.createTextNode("final col");
//     newCell.appendChild(newText);
// }


// fetch("http://localhost:8080/evas_online/ViewRequests", { method: "POST" })
//     .then((response) => {
//         return response.json();
//     })
// transactionTable.insertRow("piggy");
// transactionTable.innerHTML = "piggy";
// var row = transactionTable.insertRow(0);
// var cell1 = row.insertCell(0);
// cell1.innerHTML = "birdie";


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
