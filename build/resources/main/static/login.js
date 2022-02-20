let URL = 'http://localhost:7000';


let loginBtn = document.getElementById('login').addEventListener('click', login);

function login() {
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;

    let loginObj =
    {
        email,
        password
    }

    let apiURL = `${URL}/login`;

    fetch(apiURL, {
        method: 'POST',
        body: JSON.stringify(loginObj)
    }).then((res) => {

        console.log(res.headers.get('user-role'));
        document.cookie = `user-role=${res};`;
        console.log(res);

        let x = res.headers.get('user-role');

        if (x == "MANAGER") {
            window.location.href = "manager.html"
        }
        if (x == "EMPLOYEE") {
            window.location.href = "employee.html"
        }
    });
}
