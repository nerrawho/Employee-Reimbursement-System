let URL = 'http://localhost:7000';


var btn1 = document.getElementById("submit");
btn1.addEventListener("click", updateAccount);


//get pending reimbursement
function updateAccount() {

    first = document.getElementById("first").value;
    last = document.getElementById("last").value;
    username = document.getElementById("username").value;
    password = document.getElementById("password").value;

    console.log(username);
    console.log(password);


    let updateObj = {
        first,
        last,
        username,
        password
    }

    let test = JSON.stringify(updateObj)
    console.log(test);

    let apiURL = `${URL}/user/update`;

    fetch(apiURL, {
        method: "PUT",
        body: JSON.stringify(updateObj)
    }).then(alert("Information Updated"))
}