function show(servicos) {
    let tab = `<thead>
            <th scope="col">#</th>
            <th scope="col">Descrição</th>
        </thead>`;

    for (let servico of servicos) {
        tab += `
            <tr>
                <td scope="row">${servico.id}</td>
                <td>${servico.descricao}</td>
            </tr>
        `;
    }

    document.getElementById("servicos").innerHTML = tab;
}

async function getServicos() {
    let auth = localStorage.getItem('Authorization');
    console.log(auth);
    const usuarioRequest = await fetch("http://localhost:8080/api/usuario", {
        method: "GET",
        headers: new Headers({
            Authorization: auth,
        }),
    });

    let usuario = await usuarioRequest.json();
    let usuarioId = usuario.id;
    console.log(usuarioId);

    const servicosRequest = await fetch("http://localhost:8080/api/servico/manager/" + usuarioId, {
        method: "GET",
        headers: new Headers({
            Authorization: auth
        })
    });
    let data = await servicosRequest.json();
    console.log(data);
    show(data);
}

document.addEventListener("DOMContentLoaded", function (event) {
    if (!localStorage.getItem("Authorization"))
        window.location = "/view/login.html";
});

getServicos();
