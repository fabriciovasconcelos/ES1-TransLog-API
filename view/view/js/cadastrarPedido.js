function showEnderecoOptions(enderecos) {
    let line = `<option selected value ="0">Selecione o endereco: </option>`;
    enderecos.forEach(endereco => {
        line += `
            <option value="${endereco.id}">${endereco.rua} ${endereco.numero}, ${endereco.bairro}</option>
        `;

        console.log(endereco)
    });
    
    document.getElementById("enderecosOpcoes").innerHTML = line;
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
    showEnderecoOptions(data);
}

async function registrarOrigem(){
    let selectValue = document.getElementById('enderecosOpcoes').value;
    window.localStorage.setItem('Origem', selectValue);
}

async function registrarEndereco(){
    let auth = window.localStorage.getItem('Authorization');

    let estadoDestino = document.getElementById('estadoDestino').value;
    let municipioDestino = document.getElementById('municipioDestino').value;
    let bairroDestino = document.getElementById('bairroDestino').value;
    let ruaDestino = document.getElementById('ruaDestino').value;
    let numeroDestino = document.getElementById('numeroDestino').value;
    let complementoDestino = document.getElementById('complementoDestino').value;
    let cepDestino = document.getElementById('cepDestino').value;

    const destino = await fetch("http://localhost:8080/api/endereco/destinatario", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json",
            Authorization: auth
        }),
        body: JSON.stringify({
            estado: estadoDestino,
            municipio: municipioDestino,
            bairro: bairroDestino,
            rua: ruaDestino,
            numero: parseInt(numeroDestino),
            complemento: complementoDestino,
            cep: cepDestino
        }),
    });

    const destinoData = await destino.json();

    console.log('destino ' + destinoData.id);
    window.localStorage.setItem('Destino',destinoData.id);
}

async function registrarProduto(){
    let auth = window.localStorage.getItem('Authorization');
    let largura = document.getElementById('largura').value;
    let altura = document.getElementById('altura').value;
    let comprimento = document.getElementById('comprimento').value;
    let peso = document.getElementById('peso').value;

    const response = await fetch("http://localhost:8080/api/produto", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json",
            Authorization: auth
        }),
        body: JSON.stringify({
            largura: parseInt(largura),
            altura: parseInt(altura),
            comprimento: parseInt(comprimento),
            peso: parseFloat(peso)
        })
    })

    const produtoData = await response.json();

    console.log('produto ' + produtoData.id);
    window.localStorage.setItem('Produto', produtoData.id);
}

async function registrarDestinatario(){
    let auth = window.localStorage.getItem('Authorization');
    let nome = document.getElementById('nomeDestinatario').value;
    let email = document.getElementById('emailDestinatario').value;
    let telefone = document.getElementById('telefoneDestinatario').value;

    const reponse = await fetch("http://localhost:8080/api/destinatario", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json",
            Authorization: auth
        }),
        body: JSON.stringify({
            nome: nome,
            email: email,
            telefone: telefone
        })
    });

    const destinatarioData = await reponse.json();
    console.log('destinatario ' + destinatarioData.id);
    window.localStorage.setItem('Destinatario', destinatarioData.id);
}

async function getIdLogado(){
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
    console.log('usuario ' + usuarioData.id);
    return usuarioData.id;
}

async function registrarServico(){
    let auth = window.localStorage.getItem('Authorization');
    let origem = window.localStorage.getItem('Origem');
    let destino = window.localStorage.getItem('Destino');
    let produto = window.localStorage.getItem('Produto');
    let destinatario = window.localStorage.getItem('Destinatario');
    let pagamento = document.getElementById('pagamento').value;
    let descricao = document.getElementById('descricao').value;
    let rementente = await getIdLogado();

    const response = await fetch("http://localhost:8080/api/servico", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json",
            Authorization: auth
        }),
        body: JSON.stringify({
            descricao: descricao,
            enderecoBuscaId: origem,
            enderecoEntregaId: destino,
            produtoId: produto,
            pagamento: pagamento,
            remetenteId: parseInt(rementente),
            destinatarioId: parseInt(destinatario),
            status: 'AGUARDANDO'
        }),
    });

    if(response.ok){
        window.location.href = "listagem.html";
    }
}

async function fazerPedido(){
    await registrarEndereco();
    await registrarProduto();
    await registrarDestinatario();
    await registrarServico();
}

getEnderecos();