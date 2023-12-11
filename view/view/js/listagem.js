function show(servicos) {
    let line = "";
    let i = 1;

    let cargo = window.localStorage.getItem('Cargo');

    servicos.forEach(servico => {

        if(cargo.includes("ORCAMENTO")){
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
                <td scope ="row">
                <div class="registrarOrcamento">   
                    <button class="btn btn-info btn-sm" type="button" data-toggle="tooltip" data-placement="top" title="Info" onclick="openOrcamento(${servico.id})">
                        Orçamento
                    </button>
                </div>
                </td>
            </tr>
        `;
        }else{
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
        }

        
        i++;
        
    });
    
    document.getElementById("servicos").innerHTML = line;
}

function showHeaders(){
    let line = "";
    let cargo = window.localStorage.getItem('Cargo');

    if(cargo.includes("ORCAMENTO")){
        line = `
        <tr>
            <th scope="col">#</th>
            <th scope="col">Descrição</th>
            <th scope="col">Status</th>
            <th scope="col">Informações</th>
            <th scope="col">Orçamento</th>
        </tr>`
    }else{
        line = `
        <tr>
            <th scope="col">#</th>
            <th scope="col">Descrição</th>
            <th scope="col">Status</th>
            <th scope="col">Informações</th>
        </tr>`
    }

    document.getElementById("servicosCabecalho").innerHTML = line;
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
    showHeaders();
    show(data);
}

async function getCargo(){
    let auth = window.localStorage.getItem('Authorization');

    const response = await fetch("http://localhost:8080/api/usuario", {
        method: "GET",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json",
            Authorization: auth
        })
    })

    const usuarioData = await response.json();
    window.localStorage.setItem('Cargo', usuarioData.cargos);
    console.log('Cargo ' + usuarioData.cargos);
}

document.addEventListener("DOMContentLoaded", function (event) {
    if (!localStorage.getItem("Authorization"))
        window.location = "/view/login.html";
});

getServicos();
getCargo();

function openInfo (servicoId){
    window.localStorage.setItem('servicoId', servicoId)
    window.location.href = "info.html";
    
}

function openOrcamento(servicoId){
    window.localStorage.setItem('servicoId', servicoId)
    window.location.href = "orcamentoPedido.html";
}