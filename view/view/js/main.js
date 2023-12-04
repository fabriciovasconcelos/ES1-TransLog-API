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

    if (response.ok) {
        window.location.href = "listagem.html";
    }
}

async function criarCadastro(){
    let nome = document.getElementById("nameInput").value;
    let email = document.getElementById("emailInput").value;
    let senha = document.getElementById("passwordInput").value;
    let cpf = document.getElementById("cpfInput").value;
    let telefone = document.getElementById("numberInput").value;

    console.log(nome, email, senha, cpf, telefone);

    const response = await fetch("http://localhost:8080/api/usuario", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",

            Accept: "application/json",
        }),
        body: JSON.stringify({
            nome: nome,
            email: email,
            senha: senha,
            cpf: cpf,
            telefone: telefone,
        }),
    });

    if (response.ok) {
        window.location.href = "index.html";
    }
}