
let URL = 'http://localhost:7000';


var btn1 = document.getElementById("all-employee");
btn1.addEventListener("click", getAllEmployee);

function buildTable(data) {

    var table = document.getElementById('myTable');
    for(var i = 0; i < data.length; i++) {
        var row = 
        `<tr>
            <td>${data[i].userID}</td>
            <td>${data[i].role}</td>
            <td>${data[i].username}</td>
            <td>${data[i].password}</td>
            <td>${data[i].first}</td>
            <td>${data[i].last}</td>
            <td>${data[i].email}</td>
        </tr>`
    
        table.innerHTML += row;
    }
}


//get all reimbursement
function getAllEmployee() {

    var table = document.getElementById("myTable");

    for(var i = 0; i < table.rows.length;) {
        table.deleteRow(i);
    }

    let apiURL = `${URL}/user`;

    fetch(apiURL)
        .then((res) => res.json())
        .then((data) => buildTable(data));

}

