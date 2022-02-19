let URL = 'http://localhost:7000';


var btn1 = document.getElementById("pend");
btn1.addEventListener("click", getEmployeePending);

var btn2 = document.getElementById("resolved");
btn2.addEventListener("click", getEmployeeResolved);


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

//get pending reimbursement
function getEmployeePending() {

    var table = document.getElementById("myTable");
    for(var i = 0; i < table.rows.length;) {
        table.deleteRow(i);
    }
    
    let apiURL = `${URL}/reimbursement/employee/pending`;

    fetch(apiURL)
        .then((res) => res.json())
        .then((data) => buildTable(data));

}

//get pending reimbursement
function getEmployeeResolved() {

    var table = document.getElementById("myTable");
    for(var i = 0; i < table.rows.length;) {
        table.deleteRow(i);
    }
    
    let apiURL = `${URL}/reimbursement/employee/resolved`;

    fetch(apiURL)
        .then((res) => res.json())
        .then((data) => buildTable(data));

}
