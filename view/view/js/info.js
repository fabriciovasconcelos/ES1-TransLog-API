function show(servico){
    
  let lines = `<ul class="list-group">
                <li class="list-group-item">Estado: ${servico.enderecoBusca.estado}</li>
                <li class="list-group-item">Municipio: ${servico.enderecoBusca.municipio}</li>
                <li class="list-group-item">Bairro: ${servico.enderecoBusca.bairro}</li>
                <li class="list-group-item">Rua: ${servico.enderecoBusca.rua}</li>
                <li class="list-group-item">Número: ${servico.enderecoBusca.numero}</li>
                <li class="list-group-item">Complemento: ${servico.enderecoBusca.complemento}</li>
                <li class="list-group-item">CEP: ${servico.enderecoBusca.cep}</li>
                </ul>`

  document.getElementById("enderecoOrigem").innerHTML = lines;

    lines = `<ul class="list-group">
                <li class="list-group-item">Estado: ${servico.enderecoEntrega.estado}</li>
                <li class="list-group-item">Municipio: ${servico.enderecoEntrega.municipio}</li>
                <li class="list-group-item">Bairro: ${servico.enderecoEntrega.bairro}</li>
                <li class="list-group-item">Rua: ${servico.enderecoEntrega.rua}</li>
                <li class="list-group-item">Número: ${servico.enderecoEntrega.numero}</li>
                <li class="list-group-item">Complemento: ${servico.enderecoEntrega.complemento}</li>
                <li class="list-group-item">CEP: ${servico.enderecoEntrega.cep}</li>
                </ul>`

  document.getElementById("enderecoDestino").innerHTML = lines;
}

async function getServico(servicoId){
    let auth = localStorage.getItem('Authorization');
    const servicoRequest =  await fetch("http://localhost:8080/api/servico/" + servicoId, {
        method: "GET",
        headers: new Headers({
            Authorization: auth,
        }),
    });

    let data = await servicoRequest.json();
    show(data);
}

async function getOrcamento(servicoId){
    let auth = localStorage.getItem('Authorization');
    const orcamentoRequest =  await fetch("http://localhost:8080/api/orcamento/" + servicoId, {
        method: "GET",
        headers: new Headers({
            Authorization: auth,
        }),
    });

    let data = await orcamentoRequest.json();
    show(data);
}

let servicoId = window.localStorage.getItem('servicoId')
getServico(servicoId);