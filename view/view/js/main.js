async function login(){
    let email = document.getElementById("emailInput").value;
    let senha = document.getElementById("passwordInput").value;

    console.log(email, senha);

    const response = await fetch("http://localhost:8080/login", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json",
        }),
        body: JSON.stringify({
            email: email,
            senha: senha,
        }),
    });

    let key = "Authorization";
    let token = response.headers.get(key);
    console.log(token);
    window.localStorage.setItem(key, token);
}