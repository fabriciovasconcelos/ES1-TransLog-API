function show(servicos) {
    let line = "";
    let i = 1;
    servicos.forEach(servico => {
        line += `
            <tr>
                <th scope="row">${i}</th>
                <td scope="row">${servico.descricao}</td>
                <td scope="row">${servico.status}</td>
                <td scope ="row" class="expandirInformacoes">
                    <button class="btn btn-info btn-sm" type="button" data-toggle="tooltip" data-placement="top" title="Info" onclick="openInfo(${servico.id})">
                        Info
                    </button>
                </td>
            </tr>
        `;
        i++;
        
    });
    
    document.getElementById("servicos").innerHTML = line;
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

function openInfo (servicoId){
    window.localStorage.setItem('servicoId', servicoId)
    window.location.href = "/ES1-TransLog-API/view/view/info.html";
}