function show(enderecos) {
    let line = "";
    let i = 1;
    enderecos.forEach(endereco => {
        line += `
            <tr>
                <th scope="row">${i}</th>
                <td scope="row">${endereco.rua} ${endereco.numero}, ${endereco.bairro}</td>
                <td scope="row">${endereco.cep}</td>
                <td scope="row">${endereco.estado}</td>
                <td class="excluirEndereco" scope="row">
                    <button class="btn btn-danger btn-sm" type="button" data-toggle="tooltip" data-placement="top" title="Delete" onclick="deleteEndereco(${endereco.id})">
                        Excluir
                    </button>
                </td>
            </tr>
        `;
        i++;
        
    });
    
    document.getElementById("enderecos").innerHTML = line;
}
function cadastrarEndereco(){
    window.location.href ='cadastrarEndereco.html'
}

async function deleteEndereco(enderecoId){
    let auth = localStorage.getItem('Authorization');
    const enderecoRequest =  await fetch(`http://localhost:8080/api/endereco/${enderecoId}`, {
        method: "DELETE",
        headers: new Headers({
            Authorization: auth,
        }),
    });
    location.reload();
}

async function getEnderecos() {
    let auth = localStorage.getItem('Authorization');
    const enderecoRequest =  await fetch("http://localhost:8080/api/endereco/list", {
        method: "GET",
        headers: new Headers({
            Authorization: auth,
        }),
    });

    let data = await enderecoRequest.json();
    show(data);
}

document.addEventListener("DOMContentLoaded", function (event) {
    if (!localStorage.getItem("Authorization"))
        window.location = "/view/login.html";
});

getEnderecos();