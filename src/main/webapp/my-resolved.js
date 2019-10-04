'use strict';

console.log("version 5.08");

// let id = null;
// let firstName = null;
// let lastName = null;
// let accountMenu = document.getElementById("account-button");
let transactionTable = document.getElementById("transaction-table");
// transactionTable.insertRow(3).


    
    /* Edit this block of code: */
fetch("http://localhost:8080/evas_online/MyResolved", { method: "POST" })
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
            b.innerHTML = json[i].requestcatagory;
            c.innerHTML = json[i].requestinformation;
            d.innerHTML = '$' + json[i].requestvalue;
            e.innerHTML = json[i].requeststatus;
        }
    });


// let logoutPanel = document.getElementById("logout-panel");
// // let logoutYes = document.getElementById("logout-panel-yes");
// let logoutNo = document.getElementById("logout-panel-no");

// function confirmLogout() {
//     logoutPanel.style.visibility = "visible";
//     overlayOn();
//     console.log("OH NO DON'T LEAVE!");
// }

// function declineLogout() {
//     logoutPanel.style.visibility = "hidden";
//     overlayOff();
// }

// function overlayOn() {
//     document.getElementById("overlay").style.visibility = "visible";
//     document.getElementById("blurMe").style.filter = "blur(6px)";
// }

// function overlayOff() {
//     document.getElementById("overlay").style.visibility = "hidden";
//     document.getElementById("blurMe").style.filter = "blur(0px)";

// }
