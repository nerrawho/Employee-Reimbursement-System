let URL = "http://localhost:7000";

var btn1 = document.getElementById("submit");
btn1.addEventListener("click", createNewReimbursement);

function createNewReimbursement() {
   let typeInput = document.getElementById("typeInput").value;
   let amountInput = document.getElementById("amountInput").value;
   let descriptionInput = document.getElementById("descrInput").value;
   let emailInput = document.getElementById("emailInput").value;

   let reimbursementObj = {
        email: emailInput,
        type: typeInput,
        amount: amountInput,
        description: descriptionInput
   }

   let apiURL = `${URL}/reimbursement`;

   console.log(apiURL);

   fetch(apiURL, {
       method: "POST",
       headers: {
           "Content-Type" : "application/json"
       },
       body: JSON.stringify(reimbursementObj)
   }).then(alert("Reimbursement Created"))
}