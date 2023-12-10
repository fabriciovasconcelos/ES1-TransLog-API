async function registrarEndereco(){
    let auth = window.localStorage.getItem('Authorization');

    let estado = document.getElementById('estado').value;
    let municipio = document.getElementById('municipio').value;
    let bairro = document.getElementById('bairro').value;
    let rua = document.getElementById('rua').value;
    let numero = document.getElementById('numero').value;
    let complemento = document.getElementById('complemento').value;
    let cep = document.getElementById('cep').value;

    const novoEndereco = await fetch("http://localhost:8080/api/endereco", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json",
            Authorization: auth
        }),
        body: JSON.stringify({
            estado: estado,
            municipio: municipio,
            bairro: bairro,
            rua: rua,
            numero: parseInt(numero),
            complemento: complemento,
            cep: cep
        }),
    });

    if(novoEndereco.ok){
        window.location.href = "listarEnderecos.html";
    }
}