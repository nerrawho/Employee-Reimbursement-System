let URL = 'http://localhost:7000';

let accbtn = document.getElementById('showAccount');
accbtn.addEventListener("click", readUserById);

function buildTable(data) {

    var table1 = document.getElementById('myTable');

        var row = 
        `<tr>
            <td>${data.userID}</td>
            <td>${data.role}</td>
            <td>${data.username}</td>
            <td>${data.password}</td>
            <td>${data.first}</td>
            <td>${data.last}</td>
            <td>${data.email}</td>
        </tr>`

        table1.innerHTML += row;
    
}

function readUserById() {

    var table2 = document.getElementById("myTable");

    for (var i = 0; i < table2.rows.length;) {
        table2.deleteRow(i);
    }

    let apiURL = `${URL}/user/session`;

    fetch(apiURL)
        .then((res) => res.json())
        .then((data) => buildTable(data));

}
