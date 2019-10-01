'use strict';

// let logoutPanel = document.getElementById("logout-panel");
// logoutPanel.style.display = "none";
console.log("asd");


let accountMenu = document.getElementById("account-button");
fetch("http://localhost:8080/evas_online/LiveUser?", { method: "GET" })
    .then((response) => {
        // console.log("response: " + response);
        // console.log("response.json: " + response.json);
        // console.log("response.json(): " + response.json());
        // console.log("JSON.stringify(response): " + JSON.stringify(response));
        // console.log("JSON.stringify(response.json): " + JSON.stringify(response.json));
        // console.log("JSON.stringify(response.json())): " + JSON.stringify(response.json()));
        // console.log("how'd it go?");
        return response.json();
    })
    .then((json)=>{
        console.log(json);
        accountMenu.innerHTML = json.hi;
    });

// fetch("/evas_online/LiveUser?").then((response) =>{
//             console.log(response);
//             console.log(response.json);
//             console.log(JSON.stringify(response));
//             console.log(JSON.stringify(response.json));
// })


// var qwe = new XMLHttpRequest();
// qwe.open("GET", "/evas_online/LiveUser?");

// qwe.responseType = 'text';

// qwe.onload = function () {
//     console.log(qwe.response);
//     console.log(qwe.responseText);
// };

// qwe.send(null);
// console.log(qwe.response);
// console.log(qwe.responseText);

// var xhr = new XMLHttpRequest();
// xhr.open("GET", "/evas_online/LiveUser?");
// xhr.send;
// console.log(xhr.response);
// console.log(xhr.responseText);

// const activeAccount = await fetch("/evas_online/LiveUser");
// const aAJson = await activeAccount.json();
// console.log(JSON.stringify(aAJson));



// accountMenu.innerHTML = "WORKALREADY" + fetch("/evas_online/LiveUser?", { method: "GET" })
//     .then((response)=>{
//       return response.json();
//     })
//     .then((playerJson)=>{
//       clearDisplay();
//       createLi(playerJson);
//     });




// accountMenu.innerHTML = "WORKALREADY" + fetch("/evas_online/LiveUser?", { method: "GET" })
//     .then((response) => response.json() 
//     // {
//     //     return "chicken";
//     //     console.log(response);
//     //     console.log(response.json);
//     // }
//     );



// console.log("hello");
fetch("/evas_online/LiveUser?", { method: "GET" })
    .then((response) => {
        console.log(response);
        console.log(response.json);
    })
fetch("/evas_online/LiveUser", { method: "POST" })
    .then((response) => {
        console.log(response);
        console.log(response.json);
    })

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

// let logoutConfirm=document.getElementById("confirm-logout");

// document.getElementById("confirm-logout").style.display="none";

// let logoutButton = document.getElementByID("logoutButton");
// logoutButton.addEventListener("click", (event)=>{
// document.getElementById("confirm-logout").style.display = "none";
// });

// logoutConfirm.hidden="false";

// x.innerText;
// document.getelementById("demo").innerHTML = "hi from js";
