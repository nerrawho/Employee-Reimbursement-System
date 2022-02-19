let LURL = 'http://localhost:7000';

let logOutBtn = document.getElementById("logout").addEventListener("click", logout);

function logout() {
    let apiURL = `${LURL}/logout`;

    fetch(apiURL)
        .then((res) => {
            console.log("Logged Out");
            window.location.href = "login.html"
        });
}