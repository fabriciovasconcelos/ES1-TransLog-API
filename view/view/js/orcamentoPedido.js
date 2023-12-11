async function getServicoId(){
    document.addEventListener('DOMContentLoaded', function() {
        const servicoId = localStorage.getItem('servicoId');
        const inputServico = document.getElementById('servico');
        inputServico.value = servicoId;
    });
}

async function registrarOrcamento(){
    let auth = window.localStorage.getItem('Authorization');
    custoEmbalagem = document.getElementById('custoEmbalagem').value
    taxaDesistencia = document.getElementById('taxaDesistencia').value
    valor = document.getElementById('valor').value
    prazo = document.getElementById('prazo').value
    servicoId = document.getElementById('servico').value

    const response = await fetch("http://localhost:8080/api/orcamento", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json",
            Authorization: auth
        }),
        body: JSON.stringify({
            custoEmbalagem: custoEmbalagem,
            taxaDesistencia: taxaDesistencia,
            valor: valor,
            prazo: prazo,
            servicoId: servicoId
        }),
    });

    if(response.ok){
        window.location.href = "listagem.html";
    }
}


document.addEventListener("DOMContentLoaded", function (event) {
    if (!localStorage.getItem("Cargo").includes("ORCAMENTO"))
        window.location = "/view/login.html";
});

getServicoId();