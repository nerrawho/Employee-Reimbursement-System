let URL = 'http://localhost:7000';


var btn = document.getElementById("dashboard");
btn.addEventListener("click", getAll);


var btn2 = document.getElementById("pend");
btn2.addEventListener("click", getAllPending);

var btn3 = document.getElementById("resolved");
btn3.addEventListener("click", getAllResolved);

var btn4 = document.getElementById("employee");
btn4.addEventListener("click", getReimbursementByEmployeeId);


//GET function display as table
function buildTable(data) {
    var table = document.getElementById('myTable');
    for(var i = 0; i < data.length; i++) {
        var row = `<tr>
            <td>${data[i].reimbursementID}</td>
            <td>${data[i].employee.userID}</td>
            <td>${data[i].type}</td>
            <td>${data[i].amount}</td>
            <td>${data[i].submit}</td>
            <td>${data[i].resolvedBy}</td>
            <td>${data[i].resolved}</td>
            <td>${data[i].description}</td>
            <td>${data[i].status}</td>
        </tr>`
    
        table.innerHTML += row;
    }

}

//get all reimbursement
function getAll() {

    var table = document.getElementById("myTable");
    for(var i = 0; i < table.rows.length;) {
        table.deleteRow(i);
    }

    let apiURL = `${URL}/reimbursement`;

    fetch(apiURL)
        .then((res) => res.json())
        .then((data) => buildTable(data));

}


//get pending reimbursement
function getAllPending() {

    var table = document.getElementById("myTable");
    for(var i = 0; i < table.rows.length;) {
        table.deleteRow(i);
    }
    
    let apiURL = `${URL}/reimbursement/manager/pending`;

    fetch(apiURL)
        .then((res) => res.json())
        .then((data) => buildTable(data));

}

//get pending reimbursement
function getAllResolved() {

    var table = document.getElementById("myTable");
    for(var i = 0; i < table.rows.length;) {
        table.deleteRow(i);
    }
    
    let apiURL = `${URL}/reimbursement/manager/resolved`;

    fetch(apiURL)
        .then((res) => res.json())
        .then((data) => buildTable(data));

}


function getReimbursementByEmployeeId() {

    let id = document.getElementById("employeeID").value;
    var table = document.getElementById("myTable");

    for(var i = 0; i < table.rows.length;) {
        table.deleteRow(i);
    }

    console.log(id);

    let apiURL = `${URL}/reimbursement/${id}`;

    console.log(apiURL);

    fetch(apiURL)
        .then((res) => res.json())
        .then((data) => buildTable(data));
}






