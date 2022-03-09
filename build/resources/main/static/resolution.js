let URL = 'http://localhost:7000';


//Approve API
function updateApprove() {
    let rid = document.getElementById("reimbursementID").value;
    let mName = document.getElementById("managerName").value;


    console.log(rid);

    let reimbursementObj = {
        id: rid,
        managerName: mName
    }

    let apiURL = `${URL}/reimbursement/manager/approve`;

    fetch(apiURL, {
        method: 'PUT',
        headers: {
            "Content-Type" : "application/json"
        },
        body: JSON.stringify(reimbursementObj)
    }).then(alert("Reimbursement Approved"))
}

//Deny API
function updateDeny() {
    let rid = document.getElementById("reimbursementID").value;
    let mName = document.getElementById("managerName").value;

    console.log(rid);

    let reimbursementObj = {
        id: rid,
        managerName: mName
    }

    let apiURL = `${URL}/reimbursement/manager/deny`;

    fetch(apiURL, {
        method: 'PUT',
        headers: {
            "Content-Type" : "application/json"
        },
        body: JSON.stringify(reimbursementObj)
    }).then(alert("Reimbursement Denied"))
}

let approveReimbursement = document.getElementById("approve");
approveReimbursement.addEventListener("click", updateApprove);


let denyReimbursement = document.getElementById("deny");
denyReimbursement.addEventListener("click", updateDeny);






